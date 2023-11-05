package ru.mclord.classic.plugin;

import ru.mclord.classic.Level;
import ru.mclord.classic.LevelDownloadDriver;
import ru.mclord.classic.McLordClassic;
import ru.mclord.classic.PacketHandler;

import java.io.DataInputStream;
import java.io.IOException;

public class LevelInitializeHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x02;
    public static final int PACKET_LENGTH = 0;

    public LevelInitializeHandler() {
        super(PACKET_ID, PACKET_LENGTH, true);
    }

    @Override
    public void handle(DataInputStream stream) throws IOException {
        LevelDownloadDriver driver = LevelDownloadDriver.driver;
        if (driver == null) {
            throw new IllegalStateException("LevelDownloadDriver was not set");
        }

        McLordClassic game = McLordClassic.game();
        game.addTask(() -> game.stage = McLordClassic.GameStage.DOWNLOADING_THE_LEVEL);
        System.out.println("Invoking LevelDownloadDriver (" + driver.getClass() + ")");
        Level level = driver.downloadLevel(stream);

        System.out.printf("Successfully downloaded a %dx%dx%d level%s",
                level.sizeX, level.sizeY, level.sizeZ, System.lineSeparator());
    }
}
