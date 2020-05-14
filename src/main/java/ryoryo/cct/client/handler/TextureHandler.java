package ryoryo.cct.client.handler;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.client.textures.SpriteCompressed;
import ryoryo.cct.util.EnumCompressed;

public class TextureHandler {

	@SubscribeEvent
	public void loadTexture(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		if(!map.getBasePath().equals("textures"))
			return;

		CompressedCobblestoneTools.LOGGER.info("Stitching textures");
		for(int i = 0; i < EnumCompressed.getLength(); i++) {
			map.setTextureEntry(new SpriteCompressed("cobblestone", i, (float) Math.sqrt(EnumCompressed.getLength() * 8) + 0.5F));
		}
	}
}