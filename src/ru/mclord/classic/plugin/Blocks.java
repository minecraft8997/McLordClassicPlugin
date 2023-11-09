package ru.mclord.classic.plugin;

import ru.mclord.classic.Block;
import ru.mclord.classic.BlockManager;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class Blocks {
    public static final Block AIR = new Block((short) 0, "Air", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.NO_ONE, Block.InteractPermission.NO_ONE, -1, -1, -1) {
        @Override
        public boolean shouldBeRenderedAt(int x, int y, int z) {
            return false;
        }
    };
    public static final Block STONE = new Block((short) 1, "Stone", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 1, 1, 1);
    public static final Block GRASS = new Block((short) 2, "Grass", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 0, 3, 2);
    public static final Block DIRT = new Block((short) 3, "Dirt", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 2, 2, 2);
    public static final Block COBBLESTONE = new Block((short) 4, "Cobblestone", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 16, 16, 16);
    public static final Block WOOD = new Block((short) 5, "Wood", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 4, 4, 4);
    public static final Block SAPLING = new Block((short) 6, "Sapling", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, -1, 15, -1);
    public static final Block BEDROCK = new Block((short) 7, "Bedrock", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 17, 17, 17);
    public static final Block WATER = new Block((short) 8, "Water", Block.Solidity.WATER, 128, false, Block.InteractPermission.NO_ONE, Block.InteractPermission.NO_ONE, 14, 14, 14);
    public static final Block STILL_WATER = new Block((short) 9, "Still water", Block.Solidity.WATER, 128, false, Block.InteractPermission.NO_ONE, Block.InteractPermission.NO_ONE, 14, 14, 14);
    public static final Block LAVA = new Block((short) 10, "Lava", Block.Solidity.LAVA, 128, false, Block.InteractPermission.NO_ONE, Block.InteractPermission.NO_ONE, 30, 30, 30);
    public static final Block STILL_LAVA = new Block((short) 11, "Still lava", Block.Solidity.LAVA, 128, false, Block.InteractPermission.NO_ONE, Block.InteractPermission.NO_ONE, 30, 30, 30);
    public static final Block SAND = new Block((short) 12, "Sand", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 18, 18, 18);
    public static final Block GRAVEL = new Block((short) 13, "Gravel", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 19, 19, 19);
    public static final Block GOLD_ORE = new Block((short) 14, "Gold ore", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 32, 32, 32);
    public static final Block IRON_ORE = new Block((short) 15, "Iron ore", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 33, 33, 33);
    public static final Block COAL_ORE = new Block((short) 16, "Coal ore", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 34, 34, 34);
    public static final Block LOG = new Block((short) 17, "Log", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 21, 20, 21);
    public static final Block LEAVES = new Block((short) 18, "Leaves", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 22, 22, 22);
    public static final Block SPONGE = new Block((short) 19, "Sponge", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 48, 48, 48);
    public static final Block GLASS = new Block((short) 20, "Glass", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 49, 49, 49);
    public static final Block RED = new Block((short) 21, "Red", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 64, 64, 64);
    public static final Block ORANGE = new Block((short) 22, "Orange", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 65, 65, 65);
    public static final Block YELLOW = new Block((short) 23, "Yellow", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 66, 66, 66);
    public static final Block LIME = new Block((short) 24, "Lime", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 67, 67, 67);
    public static final Block GREEN = new Block((short) 25, "Green", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 68, 68, 68);
    public static final Block TEAL = new Block((short) 26, "Teal", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 69, 69, 69);
    public static final Block AQUA = new Block((short) 27, "Aqua", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 70, 70, 70);
    public static final Block CYAN = new Block((short) 28, "Cyan", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 71, 71, 71);
    public static final Block BLUE = new Block((short) 29, "Blue", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 72, 72, 72);
    public static final Block INDIGO = new Block((short) 30, "Indigo", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 73, 73, 73);
    public static final Block VIOLET = new Block((short) 31, "Violet", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 74, 74, 74);
    public static final Block MAGENTA = new Block((short) 32, "Magenta", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 75, 75, 75);
    public static final Block PINK = new Block((short) 33, "Pink", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 76, 76, 76);
    public static final Block BLACK = new Block((short) 34, "Black", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 77, 77, 77);
    public static final Block GRAY = new Block((short) 35, "Gray", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 78, 78, 78);
    public static final Block WHITE = new Block((short) 36, "White", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 79, 79, 79);
    public static final Block DANDELION = new Block((short) 37, "Dandelion", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, -1, 13, -1);
    public static final Block ROSE = new Block((short) 38, "Rose", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, -1, 12, -1);
    public static final Block BROWN_MUSHROOM = new Block((short) 39, "Brown mushroom", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, -1, 29, -1);
    public static final Block RED_MUSHROOM = new Block((short) 40, "Red mushroom", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, -1, 28, -1);
    public static final Block GOLD = new Block((short) 41, "Gold", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 24, 40, 56);
    public static final Block IRON = new Block((short) 42, "Iron", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 23, 39, 55);
    public static final Block DOUBLE_SLAB = new Block((short) 43, "Double slab", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 6, 5, 6);
    public static final Block SLAB = new Block((short) 44, "Slab", Block.Solidity.SOLID, 128, true, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 6, 5, 6);
    public static final Block BRICK = new Block((short) 45, "Brick", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 7, 7, 7);
    public static final Block TNT = new Block((short) 46, "TNT", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 9, 8, 10);
    public static final Block BOOKSHELF = new Block((short) 47, "Bookshelf", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 4, 35, 4);
    public static final Block MOSSY_ROCKS = new Block((short) 48, "Mossy rocks", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 36, 36, 36);
    public static final Block OBSIDIAN = new Block((short) 49, "Obsidian", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, 37, 37, 37);
    /*
    public static final Block COBBLESTONE_SLAB = new Block((short) 50, "Cobblestone slab", Block.Solidity.SOLID, 128, true, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block ROPE = new Block((short) 51, "Rope", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block SANDSTONE = new Block((short) 52, "Sandstone", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block SNOW = new Block((short) 53, "Snow", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block FIRE = new Block((short) 54, "Fire", Block.Solidity.WALKTHROUGH, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block LIGHT_PINK = new Block((short) 55, "Light pink", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block FOREST_GREEN = new Block((short) 56, "Forest green", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block BROWN = new Block((short) 57, "Brown", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block DEEP_BLUE = new Block((short) 58, "Deep blue", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block TURQUOISE = new Block((short) 59, "Turquoise", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block ICE = new Block((short) 60, "Ice", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block CERAMIC_TILE = new Block((short) 61, "Ceramic tile", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block MAGMA = new Block((short) 62, "Magma", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block PILLAR = new Block((short) 63, "Pillar", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block CRATE = new Block((short) 64, "Crate", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
    public static final Block STONE_BRICK = new Block((short) 65, "Stone brick", Block.Solidity.SOLID, 128, false, Block.InteractPermission.EVERYONE, Block.InteractPermission.EVERYONE, );
     */

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
