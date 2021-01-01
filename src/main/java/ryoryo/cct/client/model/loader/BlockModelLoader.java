package ryoryo.cct.client.model.loader;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.References;
import ryoryo.polishedlib.client.model.IModelLoader;
import ryoryo.polishedlib.client.model.block.ModelCubeAll;

public class BlockModelLoader implements IModelLoader {

	@Override
	public boolean accepts(ModelResourceLocation modelLocation) {
		return modelLocation.getResourceDomain().equals(References.MOD_ID)
				&& modelLocation.getResourcePath().contains("compressed_cobblestone");
	}

	@Override
	public IModel loadModel(ModelResourceLocation modelLocation) throws Exception {
		// try parsing tier from ResourceLocation
		if(modelLocation.getVariant().equals("inventory")) {
			// cct:compressed_cobblestone_x"tier"#inventory
			// Path: compressed_cobblestone_x"tier"
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "blocks/" + modelLocation.getResourcePath());
			return new ModelCubeAll(textureLocation);
		}

		int tier = 0;
		// cct:compressed_cobblestone#compressed="tier"
		// Variant: compressed="tier"
		try {
			tier = Integer.parseInt(modelLocation.getVariant().substring("compressed=".length()));
		} catch(Exception e) {
			CompressedCobblestoneTools.LOGGER.error("Can't parse tier from ResourceLocation.");
			return ModelLoaderRegistry.getMissingModel();
		}

		if(tier > 0) {
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "blocks/compressed_cobblestone_x" + tier);
			return new ModelCubeAll(textureLocation);
		}

		return ModelLoaderRegistry.getMissingModel();
	}
}