package ryoryo.cct.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ryoryo.cct.client.handler.TextureHandler;
import ryoryo.cct.client.model.loader.BlockModelLoader;
import ryoryo.cct.client.model.loader.ToolModelLoader;
import ryoryo.polishedlib.client.handlers.CustomModelRegisterHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new TextureHandler());

		// register loaders
		CustomModelRegisterHandler.registerModelLoader(new BlockModelLoader());
		CustomModelRegisterHandler.registerModelLoader(new ToolModelLoader());
	}
}