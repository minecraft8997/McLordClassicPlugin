package ru.mclord.classic.plugin;

import ru.mclord.classic.McLordClassic;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class SetBlockHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x06;
    public static final int PACKET_LENGTH = 7;

    public SetBlockHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream inputStream) throws IOException {
        short x = inputStream.readShort();
        short y = inputStream.readShort();
        short z = inputStream.readShort();
        short blockType = (short) Byte.toUnsignedInt(inputStream.readByte());

        McLordClassic.game().getLevel().setBlockAt(x, y, z, blockType);
    }
}
