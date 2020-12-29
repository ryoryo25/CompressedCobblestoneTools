package ryoryo.cct.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import ryoryo.cct.util.EnumCompressed;

public class ItemModSword extends ItemSword {

	private final EnumCompressed compressed;

	public ItemModSword(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("sword_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.compressed = compressed;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(this.compressed.getCompressed() + " Swords");
	}
}