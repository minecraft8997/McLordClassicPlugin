package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class PositionAndOrientationUpdateHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x09;
    public static final int PACKET_LENGTH = 9;

    public PositionAndOrientationUpdateHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream inputStream) {
        // not implemented
    }
}
