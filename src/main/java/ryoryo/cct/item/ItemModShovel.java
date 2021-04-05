package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.item.ItemBaseShovel;

public class ItemModShovel extends ItemBaseShovel {

	private final EnumCompressed compressed;

	public ItemModShovel(EnumCompressed compressed) {
		super("compressed_stone_shovel_x" + compressed.getTier(), compressed.getToolMaterial());
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Shovels");
	}
}