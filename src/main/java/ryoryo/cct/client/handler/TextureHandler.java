package ryoryo.cct.client.handler;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.ProgressManager;
import net.minecraftforge.fml.common.ProgressManager.ProgressBar;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.client.texture.SpriteCompressed;
import ryoryo.cct.client.texture.SpriteCompressedTools;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.cct.util.References;
import ryoryo.polishedlib.util.Utils;

public class TextureHandler {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void loadTexture(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		if (!map.getBasePath().equals("textures"))
			return;

		Utils.measureTime("stitching textures", CompressedCobblestoneTools.LOGGER, () -> {

			ProgressBar stitchBar = ProgressManager.push("CCT: stitching textures", 8 + 1); // tier 1 - 8 and paxel

			float max_n = (float) Math.sqrt(EnumCompressed.getLength() * 8) + 0.5F;

			for (int i = 0; i < EnumCompressed.getLength(); i ++) {
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
			map.registerSprite(new ResourceLocation(References.MOD_ID, "items/stone_paxel"));

			ProgressManager.pop(stitchBar);

		});
	}
}