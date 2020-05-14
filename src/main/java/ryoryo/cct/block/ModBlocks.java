package ryoryo.cct.block;

import net.minecraft.block.Block;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.itemblock.ItemBlockMeta;

public class ModBlocks {

	public static final Block BLOCK_COMPRESSED_COBBLESTONE = new BlockCompressedCobblestone();

	public static void init() {
		CompressedCobblestoneTools.REGISTER.registerBlock(
				BLOCK_COMPRESSED_COBBLESTONE,
				new ItemBlockMeta(BLOCK_COMPRESSED_COBBLESTONE, EnumCompressed.NAMES),
				"compressed_cobblestone",
				EnumCompressed.NAMES);
	}
}