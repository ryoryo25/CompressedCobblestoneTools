package ryoryo.cct.proxy;

import javax.annotation.Nonnull;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.block.ModBlocks;
import ryoryo.cct.crafting.RecipeCompressTools;
import ryoryo.cct.item.ModItems;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.util.Utils;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
		ModItems.init();
	}

	public void init(FMLInitializationEvent event) {
		if(!Utils.isOreDictLoaded(EnumCompressed.X1.getOreDictName())) {
			for(int i = 0; i < 8; i ++) {
				// compress recipe
				addRecipe("compressed_cobblestone_x" + (i + 1),
						new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, 1, i),
						"CCC", "CCC", "CCC",
						'C', EnumCompressed.byMeta(i).getPrevTierBlock(1));

				// reverse recipe
				addShapelessRecipe("reverse_compressed_cobblestone_x" + (i + 1),
						EnumCompressed.byMeta(i).getPrevTierBlock(9),
						new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, 1, i));

				// register ore dictionary
				OreDictionary.registerOre(EnumCompressed.byMeta(i).getOreDictName(), new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, 1, i));
			}
		} else {
			CompressedCobblestoneTools.LOGGER.info("Detect: " + EnumCompressed.X1.getOreDictName() + ". Skip registering recipes.");
		}

		// stone paxel
		addRecipe("stone_paxel", new ItemStack(ModItems.ITEM_STONE_PAXEL),
				"spa", " S ", " S ",
				's', Items.STONE_SHOVEL,
				'p', Items.STONE_PICKAXE,
				'a', Items.STONE_AXE,
				'S', Items.STICK);

		for(int i = 0; i < 8; i ++) {
			addRecipeTools(i);
			addRecipeCompressTools(i);
		}
	}

	public void postInit(FMLPostInitializationEvent event) {}

	public void loadComplete(FMLLoadCompleteEvent event) {}

	private void addRecipe(String name, @Nonnull ItemStack output, Object... params) {
		CompressedCobblestoneTools.REGISTER.addRecipe(name, output, params);
	}

	private void addShapelessRecipe(String name, @Nonnull ItemStack output, Object... params) {
		CompressedCobblestoneTools.REGISTER.addShapelessRecipe(name, output, params);
	}

	private void addRecipeTools(int meta) {
		// axe, pickaxe, shovel
		CompressedCobblestoneTools.REGISTER.addRecipeTools("compressed_x" + (meta + 1),
				new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, 1, meta),
				new ItemStack(EnumCompressed.byMeta(meta).getAxe(), 1),
				new ItemStack(EnumCompressed.byMeta(meta).getPickaxe(), 1),
				new ItemStack(EnumCompressed.byMeta(meta).getShovel(), 1));
		// sword
		CompressedCobblestoneTools.REGISTER.addRecipeSword("compressed_x" + (meta + 1),
				new ItemStack(EnumCompressed.byMeta(meta).getSword(), 1),
				new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, 1, meta));
		// paxel
		addRecipe("paxel_compressed_x" + (meta + 1),
				new ItemStack(EnumCompressed.byMeta(meta).getPaxel(), 1),
				"spa", " S ", " S ",
				's', EnumCompressed.byMeta(meta).getShovel(),
				'p', EnumCompressed.byMeta(meta).getPickaxe(),
				'a', EnumCompressed.byMeta(meta).getAxe(),
				'S', Items.STICK);
	}

	private void addRecipeCompressTools(int meta) {
		RecipeCompressTools.addRecipe("shovel_x" + (meta + 1) + "_by_compressing",
				EnumCompressed.byMeta(meta).getShovel(),
				EnumCompressed.byMeta(meta).getPrevTierShovel(1));

		RecipeCompressTools.addRecipe("pickaxe_x" + (meta + 1) + "_by_compressing",
				EnumCompressed.byMeta(meta).getPickaxe(),
				EnumCompressed.byMeta(meta).getPrevTierPickaxe(1));

		RecipeCompressTools.addRecipe("axe_x" + (meta + 1) + "_by_compressing",
				EnumCompressed.byMeta(meta).getAxe(),
				EnumCompressed.byMeta(meta).getPrevTierAxe(1));

		RecipeCompressTools.addRecipe("sword_x" + (meta + 1) + "_by_compressing",
				EnumCompressed.byMeta(meta).getSword(),
				EnumCompressed.byMeta(meta).getPrevTierSword(1));

		RecipeCompressTools.addRecipe("paxel_x" + (meta + 1) + "_by_compressing",
				EnumCompressed.byMeta(meta).getPaxel(),
				EnumCompressed.byMeta(meta).getPrevTierPaxel(1));
	}
}