package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
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
}