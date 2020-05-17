package ryoryo.cct.item;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {

	public static final ToolMaterial STONE_X1 = EnumHelper.addToolMaterial(
			"STONE_X1",
			ToolMaterial.STONE.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * 9,
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X2 = EnumHelper.addToolMaterial(
			"STONE_X2",
			ToolMaterial.IRON.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 2),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X3 = EnumHelper.addToolMaterial(
			"STONE_X3",
			ToolMaterial.IRON.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 3),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X4 = EnumHelper.addToolMaterial(
			"STONE_X4",
			ToolMaterial.DIAMOND.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 4),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X5 = EnumHelper.addToolMaterial(
			"STONE_X5",
			ToolMaterial.DIAMOND.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 5),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X6 = EnumHelper.addToolMaterial(
			"STONE_X6",
			ToolMaterial.DIAMOND.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 6),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X7 = EnumHelper.addToolMaterial(
			"STONE_X7",
			ToolMaterial.DIAMOND.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 7),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
	public static final ToolMaterial STONE_X8 = EnumHelper.addToolMaterial(
			"STONE_X8",
			ToolMaterial.DIAMOND.getHarvestLevel(),
			ToolMaterial.STONE.getMaxUses() * (int) Math.pow(9, 8),
			ToolMaterial.STONE.getEfficiency(),
			ToolMaterial.STONE.getAttackDamage(),
			ToolMaterial.STONE.getEnchantability());
}