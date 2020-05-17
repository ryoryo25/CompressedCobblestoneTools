package ryoryo.cct.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import ryoryo.cct.util.EnumCompressed;

public class ItemModPickaxe extends ItemPickaxe {

	private final EnumCompressed compressed;

	protected ItemModPickaxe(EnumCompressed compressed) {
		super(compressed.getToolMaterial());
		this.setUnlocalizedName("pickaxe_compressed_x" + compressed.getTier());
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.compressed = compressed;
	}
}