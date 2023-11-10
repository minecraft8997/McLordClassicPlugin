package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class PositionUpdateHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0A;
    public static final int PACKET_LENGTH = 4;

    public PositionUpdateHandler() {
        super(PACKET_ID, PACKET_LENGTH);
    }

    @Override
    public void handle(DataInputStream inputStream) {
        // not implemented
    }
}
