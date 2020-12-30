package ryoryo.cct.client.textures;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class SimpleSprite extends TextureAtlasSprite {

	public SimpleSprite(ResourceLocation location) {
		super(location.toString());
	}
}