package ryoryo.cct.client.handler;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.client.textures.SpriteCompressed;
import ryoryo.cct.client.textures.SpriteCompressedTools;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.cct.util.References;

public class TextureHandler {

	@SubscribeEvent(priority = EventPriority.LOW)
	public void loadTexture(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		if(!map.getBasePath().equals("textures"))
			return;

		CompressedCobblestoneTools.LOGGER.info("Stitching textures for " + References.MOD_NAME);
		float max_n = (float) Math.sqrt(EnumCompressed.getLength() * 8) + 0.5F;

		for(int i = 0; i < EnumCompressed.getLength(); i ++) {
			map.setTextureEntry(new SpriteCompressed("cobblestone", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_shovel", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_pickaxe", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_axe", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_sword", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_paxel", new ResourceLocation(References.MOD_ID, "textures/items/stone_paxel.png"), i, max_n));
		}
	}
}