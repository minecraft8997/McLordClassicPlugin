package ru.mclord.classic.plugin;

import ru.mclord.classic.*;
import ru.mclord.classic.events.PlayerSpawnEvent;

import java.io.DataInputStream;
import java.io.IOException;

public class SpawnPlayerHandler extends PacketHandler {
    public static final byte PACKET_ID = 0x07;
    public static final int PACKET_LENGTH = 73;

    public SpawnPlayerHandler() {
        super(PACKET_ID, PACKET_LENGTH, false);
    }

    @Override
    public void handle(DataInputStream stream) throws IOException {
        byte playerId = stream.readByte();
        String username = Helper.readProtocolString(stream);
        short x = stream.readShort();
        short y = stream.readShort();
        short z = stream.readShort();
        byte yaw = stream.readByte();
        byte pitch = stream.readByte();

        Level level = McLordClassic.game().getLevel();
        Player player = level.getPlayer(playerId);
        if (player == null) {
            player = Player.create(playerId, username);
            if (player.isMe()) {
                player.setOp(ServerIdentificationHandler.lastUserType == 0x64);
            }
            level.addPlayer(player);
        }
        player.getSpawnLoc().setX(x);
        player.getSpawnLoc().setY(y);
        player.getSpawnLoc().setZ(z);
        player.getSpawnRot().setYaw(yaw);
        player.getSpawnRot().setPitch(pitch);

        EventManager.getInstance().fireEvent(PlayerSpawnEvent.create(player));
    }
}
