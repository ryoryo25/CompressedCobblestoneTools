package ryoryo.cct.util;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import ryoryo.cct.block.ModBlocks;
import ryoryo.cct.item.ModItems;
import ryoryo.cct.item.ModToolMaterial;

public enum EnumCompressed implements IStringSerializable {
	X1("single", 1, ModToolMaterial.STONE_X1),
	X2("double", 2, ModToolMaterial.STONE_X2),
	X3("triple", 3, ModToolMaterial.STONE_X3),
	X4("quadruple", 4, ModToolMaterial.STONE_X4),
	X5("quituple", 5, ModToolMaterial.STONE_X5),
	X6("sextuple", 6, ModToolMaterial.STONE_X6),
	X7("septuple", 7, ModToolMaterial.STONE_X7),
	X8("octuple", 8, ModToolMaterial.STONE_X8),;

	private final String name;
	private final int tier;
	private final ToolMaterial material;
	private static final EnumCompressed[] META_LOOKUP = new EnumCompressed[values().length];
	public static final String[] NAMES = new String[values().length];

	private EnumCompressed(String name, int tier, ToolMaterial material) {
		this.name = name;
		this.tier = tier;
		this.material = material;
	}

	public int getMeta() {
		return this.tier - 1;
	}

	public int getTier() {
		return this.tier;
	}

	public int getCompressed() {
		return (int) Math.pow(9, this.tier);
	}

	public String getOreDictName() {
		return "compressed" + this.tier + "xCobblestone";
	}

	@Override
	public String getName() {
		return this.name;
	}

	public ToolMaterial getToolMaterial() {
		return this.material;
	}

	public ItemStack getNextTierBlock(int count) {
		if(this.tier == 8) {
			return ItemStack.EMPTY;
		}

		return new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, count, this.getMeta() + 1);
	}

	public ItemStack getPrevTierBlock(int count) {
		if(this.tier == 1) {
			return new ItemStack(Blocks.COBBLESTONE, count);
		}

		return new ItemStack(ModBlocks.BLOCK_COMPRESSED_COBBLESTONE, count, this.getMeta() - 1);
	}

	public Item getShovel() {
		return ModItems.SHOVELS[this.getMeta()];
	}

	public Item getPickaxe() {
		return ModItems.PICKAXES[this.getMeta()];
	}

	public Item getAxe() {
		return ModItems.AXES[this.getMeta()];
	}

	public Item getSword() {
		return ModItems.SWORDS[this.getMeta()];
	}

	public Item getPaxel() {
		return ModItems.PAXELS[this.getMeta()];
	}

	public static int getLength() {
		return values().length;
	}

	public static EnumCompressed byMeta(int meta) {
		if(meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}

		return META_LOOKUP[meta];
	}

	static {
		for(EnumCompressed compressed : values()) {
			META_LOOKUP[compressed.getMeta()] = compressed;
			NAMES[compressed.getMeta()] = "x" + compressed.getTier();
		}
	}
}