package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;

public class ItemModPickaxe extends ItemPickaxe {

	private final EnumCompressed compressed;

	protected ItemModPickaxe(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("pickaxe_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Pickaxes");
	}
}