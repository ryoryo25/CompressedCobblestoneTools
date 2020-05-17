package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import ryoryo.cct.util.EnumCompressed;

public class ItemModSword extends ItemSword {

	private final EnumCompressed compressed;

	public ItemModSword(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("sword_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.compressed = compressed;
	}
}