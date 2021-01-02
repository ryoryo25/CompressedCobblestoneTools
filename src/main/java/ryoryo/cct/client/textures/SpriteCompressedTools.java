package ryoryo.cct.client.textures;

import java.awt.image.BufferedImage;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import ryoryo.cct.CompressedCobblestoneTools;
import ryoryo.cct.util.References;
import ryoryo.polishedlib.util.ColorHelper;

public class SpriteCompressedTools extends TextureAtlasSprite {

	private int n;
	private float max_n;
	private ResourceLocation baseLocation;

	public SpriteCompressedTools(String texBase, ResourceLocation location, int n, float max_n) {
		super(References.MOD_ID + ":items/compressed_" + texBase + "_x" + (n + 1));
		this.n = n;
		this.max_n = max_n;
		this.baseLocation = location;
	}

	public SpriteCompressedTools(String texBase, int n, float max_n) {
		this(texBase, new ResourceLocation("minecraft", "textures/items/" + texBase + ".png"), n, max_n);
	}

	@Override
	public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location) {
		return true;
	}

	// Reference:
	// https://github.com/rwtema/Extra-Utilities-2-Source/blob/master/1.10.2/src/main/java/com/rwtema/extrautils2/textures/SpriteCompressed.java#L30
	@Override
	public boolean load(IResourceManager manager, ResourceLocation location, Function<ResourceLocation, TextureAtlasSprite> textureGetter) {
		int mipmap = Minecraft.getMinecraft().gameSettings.mipmapLevels;

		// handle for Resource Packs
		try {
			BufferedImage newImage = ImageIO.read(manager.getResource(location).getInputStream());
			int[][] pixels = new int[mipmap + 1][];
			pixels[0] = new int[newImage.getWidth() * newImage.getHeight()];
			newImage.getRGB(0, 0, newImage.getWidth(), newImage.getHeight(), pixels[0], 0, newImage.getWidth());
			this.setIconWidth(newImage.getWidth());
			this.setIconHeight(newImage.getHeight());
			this.clearFramesTextureData();
			this.framesTextureData.add(pixels);

			CompressedCobblestoneTools.LOGGER.info("Found image for {}, so skip generating image", location);
			return false;
		} catch(Exception e) {
			// NO-OP
		}

		try {
			BufferedImage base = ImageIO.read(manager.getResource(this.baseLocation).getInputStream());
			int w = base.getWidth();
			int h = base.getHeight();
			BufferedImage newImage = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_ARGB).createBufferedImage(w, h);

			float border = (2.0F + this.n / this.max_n / 2.0F) / 32F;

			for(int px = 0; px < w; px ++) {
				for(int py = 0; py < h; py ++) {
					float rx = ((float) px / (w - 1));
					float ry = ((float) (py % w)) / (w - 1);//to adapt animatin texture with %
					int color = base.getRGB(px, py);
					float dist = getDistFromCenter(rx, ry);

					float darken = 1.0F - this.n / this.max_n + (0.35F - dist);
					if(darken > 1)
						darken = 1;
					if(darken < 0)
						darken = 0;

					if(isEdge(base, rx, ry, w, h) || rx <= border || ry < border || (1 - rx) <= border || (1 - ry) <= border)
						darken *= 0.5F;

					int a = ColorHelper.getAlpha(color);
					int r = ColorHelper.clamp(Math.round(ColorHelper.getRed(color) * darken));
					int g = ColorHelper.clamp(Math.round(ColorHelper.getGreen(color) * darken));
					int b = ColorHelper.clamp(Math.round(ColorHelper.getBlue(color) * darken));

					newImage.setRGB(px, py, ColorHelper.getARGB(r, g, b, a));
				}
			}

			int[] raw = new int[w * h];
			newImage.getRGB(0, 0, w, h, raw, 0, w);

			int[][] pixels = new int[1 + mipmap][];
			for(int i = 0; i < pixels.length; i ++) {
				pixels[i] = raw;
			}

			this.setIconWidth(w);
			this.setIconHeight(h);
			this.clearFramesTextureData();
			this.framesTextureData.add(pixels);
		} catch(Exception e) {
			CompressedCobblestoneTools.LOGGER.error("Error: unable to load " + this.baseLocation.toString());

			return true;
		}

		return false;
	}

	private static boolean isEdge(BufferedImage base, float x, float y, int w, int h) {
		for(int px = (int) x - 1; px < x + 1; px ++) {
			for(int py = (int) y - 1; py < y + 1; py ++) {
				if(px < 0 || px >= w || py < 0 || py >= h)
					continue;

				int alpha = ColorHelper.getAlpha(base.getRGB(px, py));
				//				CompressedCobblestoneTools.LOGGER.info(alpha);
				if(alpha == 0xFF) {
					CompressedCobblestoneTools.LOGGER.info("It is edge!");
					return true;
				}
			}
		}

		return false;
	}

	private static float getDistFromCenter(float x, float y) {
		return MathHelper.sqrt((x - 0.5F) * (x - 0.5F) + (y - 0.5F) * (y - 0.5F));
	}
}