package ru.mclord.classic.plugin;

import ru.mclord.classic.Helper;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class MessageHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x0D;
    public static final int PACKET_LENGTH = 65;

    public MessageHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream stream) throws IOException {
        int playerID = Byte.toUnsignedInt(stream.readByte());
        String message = Helper.readProtocolString(stream);

        System.out.println("A message from playerID=" + playerID + ": " + message);
    }
}
