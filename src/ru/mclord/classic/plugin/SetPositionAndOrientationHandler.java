package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class SetPositionAndOrientationHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x08;
    public static final int PACKET_LENGTH = 9;

    public SetPositionAndOrientationHandler() {
        super(PACKET_ID, PACKET_LENGTH);
    }

    @Override
    public void handle(DataInputStream inputStream) {
        // not implemented
    }
}
