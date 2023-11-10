package ru.mclord.classic.plugin;

import ru.mclord.classic.Helper;
import ru.mclord.classic.NetworkingThread;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class DisconnectPlayerHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0E;
    public static final int PACKET_LENGTH = 64;

    public DisconnectPlayerHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream inputStream) throws IOException {
        String reason = Helper.readProtocolString(inputStream);

        NetworkingThread.reportDisconnected(reason);
    }
}
