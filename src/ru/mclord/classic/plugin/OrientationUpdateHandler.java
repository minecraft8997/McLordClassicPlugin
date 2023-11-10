package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class OrientationUpdateHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0B;
    public static final int PACKET_LENGTH = 3;

    public OrientationUpdateHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream inputStream) {
        // not implemented
    }
}
