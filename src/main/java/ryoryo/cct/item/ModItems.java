package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.item.ItemBasePaxel;

public class ModItems {

	public static final Item ITEM_STONE_PAXEL = new ItemBasePaxel(ToolMaterial.STONE).setUnlocalizedName("stone_paxel").setCreativeTab(CreativeTabs.TOOLS);

	public static final Item ITEM_SHOVEL_X1 = new ItemModShovel(EnumCompressed.X1);
	public static final Item ITEM_SHOVEL_X2 = new ItemModShovel(EnumCompressed.X2);
	public static final Item ITEM_SHOVEL_X3 = new ItemModShovel(EnumCompressed.X3);
	public static final Item ITEM_SHOVEL_X4 = new ItemModShovel(EnumCompressed.X4);
	public static final Item ITEM_SHOVEL_X5 = new ItemModShovel(EnumCompressed.X5);
	public static final Item ITEM_SHOVEL_X6 = new ItemModShovel(EnumCompressed.X6);
	public static final Item ITEM_SHOVEL_X7 = new ItemModShovel(EnumCompressed.X7);
	public static final Item ITEM_SHOVEL_X8 = new ItemModShovel(EnumCompressed.X8);
	public static final Item[] SHOVELS = { ITEM_SHOVEL_X1, ITEM_SHOVEL_X2, ITEM_SHOVEL_X3, ITEM_SHOVEL_X4, ITEM_SHOVEL_X5, ITEM_SHOVEL_X6, ITEM_SHOVEL_X7, ITEM_SHOVEL_X8 };

	public static final Item ITEM_PICKAXE_X1 = new ItemModPickaxe(EnumCompressed.X1);
	public static final Item ITEM_PICKAXE_X2 = new ItemModPickaxe(EnumCompressed.X2);
	public static final Item ITEM_PICKAXE_X3 = new ItemModPickaxe(EnumCompressed.X3);
	public static final Item ITEM_PICKAXE_X4 = new ItemModPickaxe(EnumCompressed.X4);
	public static final Item ITEM_PICKAXE_X5 = new ItemModPickaxe(EnumCompressed.X5);
	public static final Item ITEM_PICKAXE_X6 = new ItemModPickaxe(EnumCompressed.X6);
	public static final Item ITEM_PICKAXE_X7 = new ItemModPickaxe(EnumCompressed.X7);
	public static final Item ITEM_PICKAXE_X8 = new ItemModPickaxe(EnumCompressed.X8);
	public static final Item[] PICKAXES = { ITEM_PICKAXE_X1, ITEM_PICKAXE_X2, ITEM_PICKAXE_X3, ITEM_PICKAXE_X4, ITEM_PICKAXE_X5, ITEM_PICKAXE_X6, ITEM_PICKAXE_X7, ITEM_PICKAXE_X8 };

	public static final Item ITEM_AXE_X1 = new ItemModAxe(EnumCompressed.X1);
	public static final Item ITEM_AXE_X2 = new ItemModAxe(EnumCompressed.X2);
	public static final Item ITEM_AXE_X3 = new ItemModAxe(EnumCompressed.X3);
	public static final Item ITEM_AXE_X4 = new ItemModAxe(EnumCompressed.X4);
	public static final Item ITEM_AXE_X5 = new ItemModAxe(EnumCompressed.X5);
	public static final Item ITEM_AXE_X6 = new ItemModAxe(EnumCompressed.X6);
	public static final Item ITEM_AXE_X7 = new ItemModAxe(EnumCompressed.X7);
	public static final Item ITEM_AXE_X8 = new ItemModAxe(EnumCompressed.X8);
	public static final Item[] AXES = { ITEM_AXE_X1, ITEM_AXE_X2, ITEM_AXE_X3, ITEM_AXE_X4, ITEM_AXE_X5, ITEM_AXE_X6, ITEM_AXE_X7, ITEM_AXE_X8 };

	public static final Item ITEM_SWORD_X1 = new ItemModSword(EnumCompressed.X1);
	public static final Item ITEM_SWORD_X2 = new ItemModSword(EnumCompressed.X2);
	public static final Item ITEM_SWORD_X3 = new ItemModSword(EnumCompressed.X3);
	public static final Item ITEM_SWORD_X4 = new ItemModSword(EnumCompressed.X4);
	public static final Item ITEM_SWORD_X5 = new ItemModSword(EnumCompressed.X5);
	public static final Item ITEM_SWORD_X6 = new ItemModSword(EnumCompressed.X6);
	public static final Item ITEM_SWORD_X7 = new ItemModSword(EnumCompressed.X7);
	public static final Item ITEM_SWORD_X8 = new ItemModSword(EnumCompressed.X8);
	public static final Item[] SWORDS = { ITEM_SWORD_X1, ITEM_SWORD_X2, ITEM_SWORD_X3, ITEM_SWORD_X4, ITEM_SWORD_X5, ITEM_SWORD_X6, ITEM_SWORD_X7, ITEM_SWORD_X8 };

	public static final Item ITEM_PAXEL_X1 = new ItemModPaxel(EnumCompressed.X1);
	public static final Item ITEM_PAXEL_X2 = new ItemModPaxel(EnumCompressed.X2);
	public static final Item ITEM_PAXEL_X3 = new ItemModPaxel(EnumCompressed.X3);
	public static final Item ITEM_PAXEL_X4 = new ItemModPaxel(EnumCompressed.X4);
	public static final Item ITEM_PAXEL_X5 = new ItemModPaxel(EnumCompressed.X5);
	public static final Item ITEM_PAXEL_X6 = new ItemModPaxel(EnumCompressed.X6);
	public static final Item ITEM_PAXEL_X7 = new ItemModPaxel(EnumCompressed.X7);
	public static final Item ITEM_PAXEL_X8 = new ItemModPaxel(EnumCompressed.X8);
	public static final Item[] PAXELS = { ITEM_PAXEL_X1, ITEM_PAXEL_X2, ITEM_PAXEL_X3, ITEM_PAXEL_X4, ITEM_PAXEL_X5, ITEM_PAXEL_X6, ITEM_PAXEL_X7, ITEM_PAXEL_X8 };

	public static void init() {
		CompressedCobblestoneTools.REGISTER.registerItem(ITEM_STONE_PAXEL, "stone_paxel");

		for(int i = 0; i < EnumCompressed.getLength(); i ++) {
			CompressedCobblestoneTools.REGISTER.registerItem(SHOVELS[i], "compressed_stone_shovel_x" + (i + 1));
			CompressedCobblestoneTools.REGISTER.registerItem(PICKAXES[i], "compressed_stone_pickaxe_x" + (i + 1));
			CompressedCobblestoneTools.REGISTER.registerItem(AXES[i], "compressed_stone_axe_x" + (i + 1));
			CompressedCobblestoneTools.REGISTER.registerItem(SWORDS[i], "compressed_stone_sword_x" + (i + 1));
			CompressedCobblestoneTools.REGISTER.registerItem(PAXELS[i], "compressed_stone_paxel_x" + (i + 1));
		}
	}
}