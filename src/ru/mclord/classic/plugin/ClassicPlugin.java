package ru.mclord.classic.plugin;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import ru.mclord.classic.*;
import ru.mclord.classic.events.CustomizeEnvironmentEvent;

import java.io.File;

public class ClassicPlugin implements Plugin {
    public static final byte PROTOCOL_VERSION = 7;

    private PluginManager.Key key;
    private boolean customizeEnvironment;

    @Override
    public void preInit() {
        EventManager.getInstance().registerEventHandler(
                CustomizeEnvironmentEvent.class, this::handleCustomizeEnvironment);

        Blocks.registerAll();

        PacketManager.getInstance().registerWriter(new PlayerIdentificationWriter());

        PacketManager.getInstance().registerHandler(new ExtInfoHandler());
        PacketManager.getInstance().registerHandler(new ExtEntryHandler());
        PacketManager.getInstance().registerHandler(new PingPacketHandler());
        PacketManager.getInstance().registerHandler(new ServerIdentificationHandler(key));
        PacketManager.getInstance().registerHandler(new LevelInitializeHandler());
        PacketManager.getInstance().registerHandler(new MessageHandler());
        PacketManager.getInstance().registerHandler(new SpawnPlayerHandler());
        PacketManager.getInstance().registerHandler(new DespawnPlayerHandler());
        PacketManager.getInstance().registerHandler(new DisconnectPlayerHandler());
        PacketManager.getInstance().registerHandler(new OrientationUpdateHandler());
        PacketManager.getInstance().registerHandler(new PositionAndOrientationUpdateHandler());
        PacketManager.getInstance().registerHandler(new PositionUpdateHandler());
        PacketManager.getInstance().registerHandler(new SetBlockHandler());
        PacketManager.getInstance().registerHandler(new SetPositionAndOrientationHandler());
        PacketManager.getInstance().registerHandler(new UpdateUserTypeHandler());

        if (!(new File("mcp_do_not_setup_level_download_driver.txt")).exists()) {
            LevelDownloadDriver.setDriver(new ClassicLevelDownloadDriver(key));
        }
        if (!(new File("mcp_do_not_customize_environment.txt")).exists()) {
            customizeEnvironment = true;
        }
    }

    private void handleCustomizeEnvironment(CustomizeEnvironmentEvent event) {
        if (!customizeEnvironment) return;

        Environment environment = event.getEnvironment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,
                0.5f, 0.5f, 0.5f, 1.0f));
        environment.add(new DirectionalLight().set(
                0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.5f));
        environment.add(new DirectionalLight().set(
                0.2f, 0.2f, 0.2f, 1f, 0.8f, 0.5f));
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
