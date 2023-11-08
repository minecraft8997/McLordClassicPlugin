package ru.mclord.classic.plugin;

import ru.mclord.classic.Block;
import ru.mclord.classic.BlockManager;

import java.lang.reflect.Field;

public class Blocks {
    public static final Block DIRT = new Block((short) 3, "Dirt", false, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 2, 2, 2);

    public static void registerAll() {
        for (Field field : Blocks.class.getDeclaredFields()) {
            if (field.getType() != Block.class) continue;

            field.setAccessible(true);
            Block block;
            try {
                block = (Block) field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            BlockManager.getInstance().registerBlock(block);
        }
    }
}
