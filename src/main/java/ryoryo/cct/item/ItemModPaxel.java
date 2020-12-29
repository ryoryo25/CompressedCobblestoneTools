package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.item.ItemBasePaxel;

public class ItemModPaxel extends ItemBasePaxel {

	private final EnumCompressed compressed;

	public ItemModPaxel(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("paxel_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Paxels");
	}
}