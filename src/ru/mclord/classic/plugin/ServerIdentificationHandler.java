package ru.mclord.classic.plugin;

import ru.mclord.classic.*;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerIdentificationHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x00;
    public static final int PACKET_LENGTH = 130;

    /* package-private */ static byte lastUserType;

    private final PluginManager.Key key;
    private boolean alreadyInitialized;

    public ServerIdentificationHandler(PluginManager.Key key) {
        super(PACKET_ID, PACKET_LENGTH, false);

        this.key = key;
    }

    @Override
    public void handle(DataInputStream stream) throws IOException {
        byte protocolVersion = stream.readByte();
        System.out.println("Server protocol version: " + protocolVersion);
        if (protocolVersion != ClassicPlugin.PROTOCOL_VERSION) {
            NetworkingThread.reportDisconnected("Unsupported protocol version");

            return;
        }

        String serverName = Helper.readProtocolString(stream);
        String serverMOTD = Helper.readProtocolString(stream);
        lastUserType = stream.readByte();

        System.out.println("Server name: " + serverName);
        System.out.println("Server MOTD: " + serverMOTD);
        System.out.println("User type: " + Integer.toHexString(lastUserType) + " (HEX)");

        if (!alreadyInitialized) {
            if (!serverMOTD.toLowerCase().contains("+mclc0")) {
                NetworkingThread.reportDisconnected("The server did not declare " +
                        "support of early McLord Classic versions (including the current " +
                        "one). Boycott this server");

                return;
            }

            PluginManager.getInstance().initPlugins(key);

            alreadyInitialized = true;
        }
    }
}
