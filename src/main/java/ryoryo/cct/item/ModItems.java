package ryoryo.cct.item;

import net.minecraft.item.Item;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.EnumCompressed;

public class ModItems {

	public static final Item ITEM_SHOVEL_X1 = new ItemModShovel(EnumCompressed.X1);
	public static final Item ITEM_SHOVEL_X2 = new ItemModShovel(EnumCompressed.X2);
	public static final Item ITEM_SHOVEL_X3 = new ItemModShovel(EnumCompressed.X3);
	public static final Item ITEM_SHOVEL_X4 = new ItemModShovel(EnumCompressed.X4);
	public static final Item ITEM_SHOVEL_X5 = new ItemModShovel(EnumCompressed.X5);
	public static final Item ITEM_SHOVEL_X6 = new ItemModShovel(EnumCompressed.X6);
	public static final Item ITEM_SHOVEL_X7 = new ItemModShovel(EnumCompressed.X7);
	public static final Item ITEM_SHOVEL_X8 = new ItemModShovel(EnumCompressed.X8);

	public static final Item ITEM_PICKAXE_X1 = new ItemModPickaxe(EnumCompressed.X1);
	public static final Item ITEM_PICKAXE_X2 = new ItemModPickaxe(EnumCompressed.X2);
	public static final Item ITEM_PICKAXE_X3 = new ItemModPickaxe(EnumCompressed.X3);
	public static final Item ITEM_PICKAXE_X4 = new ItemModPickaxe(EnumCompressed.X4);
	public static final Item ITEM_PICKAXE_X5 = new ItemModPickaxe(EnumCompressed.X5);
	public static final Item ITEM_PICKAXE_X6 = new ItemModPickaxe(EnumCompressed.X6);
	public static final Item ITEM_PICKAXE_X7 = new ItemModPickaxe(EnumCompressed.X7);
	public static final Item ITEM_PICKAXE_X8 = new ItemModPickaxe(EnumCompressed.X8);

	public static final Item ITEM_AXE_X1 = new ItemModAxe(EnumCompressed.X1);
	public static final Item ITEM_AXE_X2 = new ItemModAxe(EnumCompressed.X2);
	public static final Item ITEM_AXE_X3 = new ItemModAxe(EnumCompressed.X3);
	public static final Item ITEM_AXE_X4 = new ItemModAxe(EnumCompressed.X4);
	public static final Item ITEM_AXE_X5 = new ItemModAxe(EnumCompressed.X5);
	public static final Item ITEM_AXE_X6 = new ItemModAxe(EnumCompressed.X6);
	public static final Item ITEM_AXE_X7 = new ItemModAxe(EnumCompressed.X7);
	public static final Item ITEM_AXE_X8 = new ItemModAxe(EnumCompressed.X8);

	public static final Item ITEM_SWORD_X1 = new ItemModSword(EnumCompressed.X1);
	public static final Item ITEM_SWORD_X2 = new ItemModSword(EnumCompressed.X2);
	public static final Item ITEM_SWORD_X3 = new ItemModSword(EnumCompressed.X3);
	public static final Item ITEM_SWORD_X4 = new ItemModSword(EnumCompressed.X4);
	public static final Item ITEM_SWORD_X5 = new ItemModSword(EnumCompressed.X5);
	public static final Item ITEM_SWORD_X6 = new ItemModSword(EnumCompressed.X6);
	public static final Item ITEM_SWORD_X7 = new ItemModSword(EnumCompressed.X7);
	public static final Item ITEM_SWORD_X8 = new ItemModSword(EnumCompressed.X8);

	public static final Item ITEM_PAXEL_X1 = new ItemModPaxel(EnumCompressed.X1);
	public static final Item ITEM_PAXEL_X2 = new ItemModPaxel(EnumCompressed.X2);
	public static final Item ITEM_PAXEL_X3 = new ItemModPaxel(EnumCompressed.X3);
	public static final Item ITEM_PAXEL_X4 = new ItemModPaxel(EnumCompressed.X4);
	public static final Item ITEM_PAXEL_X5 = new ItemModPaxel(EnumCompressed.X5);
	public static final Item ITEM_PAXEL_X6 = new ItemModPaxel(EnumCompressed.X6);
	public static final Item ITEM_PAXEL_X7 = new ItemModPaxel(EnumCompressed.X7);
	public static final Item ITEM_PAXEL_X8 = new ItemModPaxel(EnumCompressed.X8);

	public static void init() {
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X1, "shovel_compressed_x1");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X2, "shovel_compressed_x2");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X3, "shovel_compressed_x3");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X4, "shovel_compressed_x4");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X5, "shovel_compressed_x5");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X6, "shovel_compressed_x6");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X7, "shovel_compressed_x7");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SHOVEL_X8, "shovel_compressed_x8");

		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X1, "pickaxe_compressed_x1");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X2, "pickaxe_compressed_x2");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X3, "pickaxe_compressed_x3");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X4, "pickaxe_compressed_x4");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X5, "pickaxe_compressed_x5");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X6, "pickaxe_compressed_x6");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X7, "pickaxe_compressed_x7");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PICKAXE_X8, "pickaxe_compressed_x8");

		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X1, "axe_compressed_x1");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X2, "axe_compressed_x2");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X3, "axe_compressed_x3");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X4, "axe_compressed_x4");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X5, "axe_compressed_x5");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X6, "axe_compressed_x6");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X7, "axe_compressed_x7");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_AXE_X8, "axe_compressed_x8");

		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X1, "sword_compressed_x1");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X2, "sword_compressed_x2");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X3, "sword_compressed_x3");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X4, "sword_compressed_x4");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X5, "sword_compressed_x5");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X6, "sword_compressed_x6");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X7, "sword_compressed_x7");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_SWORD_X8, "sword_compressed_x8");

		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X1, "paxel_compressed_x1");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X2, "paxel_compressed_x2");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X3, "paxel_compressed_x3");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X4, "paxel_compressed_x4");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X5, "paxel_compressed_x5");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X6, "paxel_compressed_x6");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X7, "paxel_compressed_x7");
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_PAXEL_X8, "paxel_compressed_x8");
	}
}