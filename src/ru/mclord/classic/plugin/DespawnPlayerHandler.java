package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class DespawnPlayerHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0C;
    public static final int PACKET_LENGTH = 2;

    public DespawnPlayerHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream inputStream) {
        // not implemented
    }
}
