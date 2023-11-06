package ru.mclord.classic.plugin;

import ru.mclord.classic.LevelDownloadDriver;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class LevelInitializeHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x02;
    public static final int PACKET_LENGTH = 0;

    public LevelInitializeHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream stream) throws IOException {
        LevelDownloadDriver.startDownloading(stream);
    }
}
