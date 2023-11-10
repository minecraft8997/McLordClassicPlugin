package ru.mclord.classic.plugin;

import ru.mclord.classic.McLordClassic;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class UpdateUserTypeHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0F;
    public static final int PACKET_LENGTH = 1;

    public UpdateUserTypeHandler() {
        super(PACKET_ID, PACKET_LENGTH);
    }

    @Override
    public void handle(DataInputStream inputStream) throws IOException {
        byte userType = inputStream.readByte();

        McLordClassic.getPlayer().setOp(userType == 0x64);
    }
}
