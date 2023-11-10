package ru.mclord.classic.plugin;

import ru.mclord.classic.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class ClassicLevelDownloadDriver extends LevelDownloadDriver {
    public static final int LEVEL_DATA_CHUNK_PACKET_ID = 0x03;
    public static final int LEVEL_FINALIZE_PACKET_ID = 0x04;

    private final PluginManager.Key key;

    public ClassicLevelDownloadDriver(PluginManager.Key key) {
        this.key = key;
    }

    @Override
    public Level downloadLevel(DataInputStream inputStream) throws IOException {
        byte packetId;
        ByteArrayOutputStream outputStream0 = new ByteArrayOutputStream();
        byte[] compressedData = new byte[1024];
        byte lastPercentComplete = 0;
        while (true) {
            packetId = inputStream.readByte();
            if (packetId == LEVEL_FINALIZE_PACKET_ID) break;
            if (packetId != LEVEL_DATA_CHUNK_PACKET_ID) {
                try {
                    Helper.handlePacket(packetId, key);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                    throw new RuntimeException(e);
                }

                continue;
            }
            short chunkLength = inputStream.readShort();
            inputStream.readFully(compressedData);
            outputStream0.write(compressedData, 0, chunkLength);

            byte percentComplete = inputStream.readByte();
            if (percentComplete != lastPercentComplete) {
                System.out.println("Percent complete: " + percentComplete);
                LoadingScreen.getInstance().setProgress(percentComplete);

                lastPercentComplete = percentComplete;
            }
        }
        int sizeX = inputStream.readShort();
        int sizeY = inputStream.readShort();
        int sizeZ = inputStream.readShort();

        ByteArrayInputStream inputStream0 =
                new ByteArrayInputStream(outputStream0.toByteArray());
        GZIPInputStream decompressedStream = new GZIPInputStream(inputStream0);
        DataInputStream stream = new DataInputStream(decompressedStream);

        int blockArrayLen = stream.readInt();
        if (blockArrayLen != sizeX * sizeY * sizeZ) {
            throw new RuntimeException(String.format("Invalid dimensions: len=%d, " +
                    "sizeX=%d, sizeY=%d, sizeZ=%d", blockArrayLen, sizeX, sizeY, sizeZ));
        }
        Level level = new Level(sizeX, sizeY, sizeZ);
        McLordClassic.game().addTask(() -> {
            for (int y = 0; y < sizeY; y++) {
                for (int z = 0; z < sizeZ; z++) {
                    for (int x = 0; x < sizeX; x++) {
                        try {
                            level.setBlockAt(x, y, z,
                                    (short) Byte.toUnsignedInt(stream.readByte()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        // we don't have to close any of these streams

        return level;
    }
}
