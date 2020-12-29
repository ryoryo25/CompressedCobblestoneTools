package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;

public class ItemModShovel extends ItemSpade {

	private final EnumCompressed compressed;

	public ItemModShovel(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("shovel_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Shovels");
	}
}