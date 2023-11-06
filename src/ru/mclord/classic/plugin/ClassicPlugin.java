package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketManager;
import ru.mclord.classic.Plugin;
import ru.mclord.classic.PluginManager;

public class ClassicPlugin implements Plugin {
    public static final byte PROTOCOL_VERSION = 7;

    private PluginManager.Key key;

    @Override
    public void preInit() {
        System.out.println("Setting up networking...");
        PacketManager.getInstance().registerWriter(new PlayerIdentificationWriter());

        PacketManager.getInstance().registerHandler(new ExtInfoHandler());
        PacketManager.getInstance().registerHandler(new ExtEntryHandler());
        PacketManager.getInstance().registerHandler(new PingPacketHandler());
        PacketManager.getInstance().registerHandler(new ServerIdentificationHandler(key));
        PacketManager.getInstance().registerHandler(new LevelInitializeHandler());
        PacketManager.getInstance().registerHandler(new MessageHandler());
    }

    @Override
    public void message(String description, Object message) {
        if (message instanceof PluginManager.Key) {
            this.key = (PluginManager.Key) message;
        } else {
            System.err.println("Unsupported message received");
        }
    }
}
