package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import ryoryo.cct.util.EnumCompressed;

public class ItemModShovel extends ItemSpade {

	private final EnumCompressed compressed;

	public ItemModShovel(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("shovel_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}
}