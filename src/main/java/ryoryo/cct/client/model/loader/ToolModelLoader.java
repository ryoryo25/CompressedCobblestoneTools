package ryoryo.cct.client.model.loader;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import ryoryo.cct.util.References;
import ryoryo.polishedlib.client.model.IModelLoader;
import ryoryo.polishedlib.client.model.item.ModelHandheld;

public class ToolModelLoader implements IModelLoader {

	@Override
	public boolean accepts(ModelResourceLocation modelLocation) {
		return modelLocation.getResourceDomain().equals(References.MOD_ID)
				&& !modelLocation.getResourcePath().contains("compressed_cobblestone");
	}

	@Override
	public IModel loadModel(ModelResourceLocation modelLocation) throws Exception {
		// handle model of Stone Paxel firstly
		if(modelLocation.getResourcePath().equals("stone_paxel")) {
			ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "items/stone_paxel");
			return new ModelHandheld(textureLocation);
		}

		// location: compressed_stone_XXXX_xX
		// texture name: cct:items/compressed_stone_XXXX_xX
		ResourceLocation textureLocation = new ResourceLocation(References.MOD_ID, "items/" + modelLocation.getResourcePath());
		return new ModelHandheld(textureLocation);
	}
}