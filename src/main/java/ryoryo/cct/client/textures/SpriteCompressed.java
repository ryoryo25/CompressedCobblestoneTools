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

public class SpriteCompressed extends TextureAtlasSprite {

	private int n;
	private float max_n;
	private ResourceLocation location;

	public SpriteCompressed(String texBase, int n, float max_n) {
		super(References.MOD_ID + ":blocks/compressed_" + texBase + "_x" + (n + 1));
		this.n = n;
		this.max_n = max_n;
		this.location = new ResourceLocation("minecraft", "textures/blocks/" + texBase + ".png");
	}

	@Override
	public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location) {
		return true;
	}

	//Reference:
	//https://github.com/rwtema/Extra-Utilities-2-Source/blob/master/1.10.2/src/main/java/com/rwtema/extrautils2/textures/SpriteCompressed.java#L30
	@Override
	public boolean load(IResourceManager manager, ResourceLocation location, Function<ResourceLocation, TextureAtlasSprite> textureGetter) {
		try {
			int mipmap = Minecraft.getMinecraft().gameSettings.mipmapLevels;
			BufferedImage base = ImageIO.read(manager.getResource(this.location).getInputStream());
			int w = base.getWidth();
			int h = base.getHeight();
			BufferedImage newImage = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_ARGB).createBufferedImage(w, h);

			float border = (2.0F + this.n / this.max_n / 2.0F) / 32F;

			for(int px = 0; px < w; px++) {
				for(int py = 0; py < h; py++) {
					float rx = ((float) px / (w - 1));
					float ry = ((float) (py % w)) / (w - 1);//to adapt animatin texture with %
					int color = base.getRGB(px, py);
					float dist = getDistFromCenter(rx, ry);

					float darken = 1.0F - this.n / this.max_n + (0.35F - dist);
					if(darken > 1)
						darken = 1;
					if(darken < 0)
						darken = 0;

					if(rx <= border || ry < border || (1 - rx) <= border || (1 - ry) <= border)
						darken *= 0.5F;

					int a = getAlpha(color);
					int r = MathHelper.clamp(Math.round(getRed(color) * darken), 0, 255);
					int g = MathHelper.clamp(Math.round(getGreen(color) * darken), 0, 255);
					int b = MathHelper.clamp(Math.round(getBlue(color) * darken), 0, 255);

					newImage.setRGB(px, py, getColor(r, g, b, a));
				}
			}

			int[] raw = new int[w * h];
			newImage.getRGB(0, 0, w, h, raw, 0, w);

			int[][] aint = new int[1 + mipmap][];
			for(int i = 0; i < aint.length; i++) {
				aint[i] = raw;
			}

			this.setIconWidth(w);
			this.setIconHeight(h);
			this.clearFramesTextureData();
			this.framesTextureData.add(aint);
		}
		catch(Throwable e) {
			CompressedCobblestoneTools.LOGGER.error("Error: unable to load " + this.location.toString());

			return true;
		}

		return false;
	}

	private static float getDistFromCenter(float x, float y) {
		return MathHelper.sqrt((x - 0.5F) * (x - 0.5F) + (y - 0.5F) * (y - 0.5F));
	}

	private static int getAlpha(int color) {
		return (color & 0xFF000000) >>> 24;
	}

	private static int getRed(int color) {
		return (color & 0x00FF0000) >>> 16;
	}

	private static int getGreen(int color) {
		return (color & 0x0000FF00) >> 8;
	}

	private static int getBlue(int color) {
		return color & 0x000000FF;
	}

	private static int getColor(int r, int g, int b, int a) {
		return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
	}
}