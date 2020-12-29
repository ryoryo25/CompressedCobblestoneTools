package ryoryo.cct.proxy;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.client.handler.TextureHandler;
import ryoryo.cct.client.model.BlockModelLoader;
import ryoryo.cct.client.model.ToolModelLoader;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		CompressedCobblestoneTools.LOGGER.info("Registering custom model loaders.");
		ModelLoaderRegistry.registerLoader(new BlockModelLoader());
		ModelLoaderRegistry.registerLoader(new ToolModelLoader());

		MinecraftForge.EVENT_BUS.register(new TextureHandler());
	}
}