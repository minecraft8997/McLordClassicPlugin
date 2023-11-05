package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;

public class PingPacketHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x01;
    public static final int PACKET_LENGTH = 0;

    public PingPacketHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream stream) {
    }
}
