package ryoryo.cct.client.model;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.References;

public class BlockModelLoader implements ICustomModelLoader {

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return modelLocation.getResourceDomain().equals(References.MOD_ID)
				&& modelLocation.getResourcePath().contains("compressed_cobblestone");
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if(!(modelLocation instanceof ModelResourceLocation))
			return ModelLoaderRegistry.getMissingModel();

		ModelResourceLocation location = (ModelResourceLocation) modelLocation;

		// try parsing tier from ResourceLocation
		if(location.getVariant().equals("inventory")) {
			// cct:compressed_cobblestone_x"tier"#inventory
			// Path: compressed_cobblestone_x"tier"
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "blocks/" + location.getResourcePath());
			return new ModelCompressedCobblestone(textureLocation);
		}

		int tier = 0;
		// cct:compressed_cobblestone#compressed="tier"
		// Variant: compressed="tier"
		try {
			tier = Integer.parseInt(location.getVariant().substring("compressed=".length()));
		}
		catch(Exception e) {
			CompressedCobblestoneTools.LOGGER.error("Can't parse tier from ResourceLocation.");
			return ModelLoaderRegistry.getMissingModel();
		}

		if(tier > 0) {
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "blocks/compressed_cobblestone_x" + tier);
			return new ModelCompressedCobblestone(textureLocation);
		}

		return ModelLoaderRegistry.getMissingModel();
	}
}