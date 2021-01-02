package ryoryo.cct.client.handler;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.ProgressManager;
import net.minecraftforge.fml.common.ProgressManager.ProgressBar;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.client.textures.SimpleSprite;
import ryoryo.cct.client.textures.SpriteCompressed;
import ryoryo.cct.client.textures.SpriteCompressedTools;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.cct.util.References;

public class TextureHandler {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void loadTexture(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		if(!map.getBasePath().equals("textures"))
			return;

		CompressedCobblestoneTools.LOGGER.info("Start stitching textures");
		long start = System.nanoTime();
		ProgressBar stitchBar = ProgressManager.push("CCT: stitching textures", 8 + 1); // tier 1 - 8 and paxel

		float max_n = (float) Math.sqrt(EnumCompressed.getLength() * 8) + 0.5F;

		for(int i = 0; i < EnumCompressed.getLength(); i ++) {
			stitchBar.step("Compressed tier " + (i + 1));

			map.setTextureEntry(new SpriteCompressed("cobblestone", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_shovel", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_pickaxe", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_axe", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_sword", i, max_n));
			map.setTextureEntry(new SpriteCompressedTools("stone_paxel", new ResourceLocation(References.MOD_ID, "textures/items/stone_paxel.png"), i, max_n));
		}

		stitchBar.step("Stone Paxel");
		// any JSON model files don't load this texture, so this texture isn't registered in the atlas
		map.setTextureEntry(new SimpleSprite(new ResourceLocation(References.MOD_ID, "items/stone_paxel")));

		ProgressManager.pop(stitchBar);
		long time = System.nanoTime() - start;
		CompressedCobblestoneTools.LOGGER.info(String.format("Finish stitching textures : took %1.2f ms", time / 1000000D));
	}
}