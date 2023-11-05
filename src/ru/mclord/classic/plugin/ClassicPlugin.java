package ru.mclord.classic.plugin;

import ru.mclord.classic.PacketManager;
import ru.mclord.classic.Plugin;

public class ClassicPlugin implements Plugin {
    @Override
    public void preInit() {
        System.out.println("Setting up networking...");
        PacketManager.getInstance().registerWriter(new PlayerIdentificationWriter());

        PacketManager.getInstance().registerHandler(new ExtInfoHandler());
        PacketManager.getInstance().registerHandler(new ExtEntryHandler());
        PacketManager.getInstance().registerHandler(new PingPacketHandler());
        PacketManager.getInstance().registerHandler(new ServerIdentificationHandler());
        PacketManager.getInstance().registerHandler(new LevelInitializeHandler());
        PacketManager.getInstance().registerHandler(new MessageHandler());
    }
}
