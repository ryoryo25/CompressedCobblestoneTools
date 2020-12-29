package ryoryo.cct.client.model;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import ryoryo.cct.util.References;

public class ToolModelLoader implements ICustomModelLoader {

	private static final String LOC_PREFIX = "models/item/";

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return modelLocation.getResourceDomain().equals(References.MOD_ID)
				&& modelLocation.getResourcePath().startsWith(LOC_PREFIX);
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		String location = modelLocation.getResourcePath().substring(LOC_PREFIX.length());

		// handle model of Stone Paxel firstly
		if(location.equals("stone_paxel")) {
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "items/stone_paxel");
			return new ModelTools(textureLocation);
		}

		// location: compressed_stone_XXXX_xX
		// texture name: cct:items/compressed_stone_XXXX_xX
		ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "items/" + location);
		return new ModelTools(textureLocation);
	}
}