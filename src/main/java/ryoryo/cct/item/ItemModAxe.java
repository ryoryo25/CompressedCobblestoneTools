package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import ryoryo.cct.util.EnumCompressed;

public class ItemModAxe extends ItemAxe {

	private final EnumCompressed compressed;

	protected ItemModAxe(EnumCompressed compressed) {
		super(compressed.getToolMaterial(), 8F, -3.2F);
		this.setUnlocalizedName("axe_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}
}