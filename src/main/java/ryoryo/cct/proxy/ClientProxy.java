package ryoryo.cct.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import ryoryo.cct.block.BlockCompressedCobblestone;
import ryoryo.cct.block.ModBlocks;
import ryoryo.polishedlib.util.RegistryUtils;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		RegistryUtils.registerBlockColor(new BlockCompressedCobblestone(), ModBlocks.BLOCK_COMPRESSED_COBBLESTONE);
		RegistryUtils.registerItemBlockColor((stack, tintIndex) -> BlockCompressedCobblestone.getColor(stack.getMetadata()), ModBlocks.BLOCK_COMPRESSED_COBBLESTONE);
	}
}