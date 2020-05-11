package ryoryo.cct.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.block.ModBlocks;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.util.Utils;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
	}

	public void init(FMLInitializationEvent event) {
		if(!Utils.isOreDictLoaded(EnumCompressed.X1.getOreDictName())) {
		}
		else {
			CompressedCobblestoneTools.LOGGER.info("Detect: " + EnumCompressed.X1.getOreDictName() + ". Skip registering recipes.");
		}
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

	public void loadComplete(FMLLoadCompleteEvent event) {
	}
}