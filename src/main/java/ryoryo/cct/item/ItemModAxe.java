package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;

public class ItemModAxe extends ItemAxe {

	private final EnumCompressed compressed;

	protected ItemModAxe(EnumCompressed compressed) {
		super(compressed.getToolMaterial(), 8F, -3.2F);
		this.setUnlocalizedName("axe_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Axes");
	}
}