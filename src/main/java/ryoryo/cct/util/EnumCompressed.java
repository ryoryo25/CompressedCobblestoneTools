package ryoryo.cct.util;

import net.minecraft.util.IStringSerializable;

public enum EnumCompressed implements IStringSerializable
{
	X1("single", 0),
	X2("double", 1),
	X3("triple", 2),
	X4("quadruple", 3),
	X5("quituple", 4),
	X6("sextuple", 5),
	X7("septuple", 6),
	X8("octuple", 7),;

	private final String name;
	private final int meta;
	private static final EnumCompressed[] META_LOOKUP = new EnumCompressed[values().length];
	public static final String[] NAMES = new String[values().length];

	private EnumCompressed(String name, int meta) {
		this.name = name;
		this.meta = meta;
	}

	public int getMeta() {
		return this.meta;
	}

	public int getTier() {
		return this.meta + 1;
	}

	public int getCompressed() {
		return (int) Math.pow(9, getTier());
	}

	public String getOreDictName() {
		return "compressed" + getTier() + "xCobblestone";
	}

	@Override
	public String getName() {
		return this.name;
	}

	public static int getLength() {
		return values().length;
	}

	public static EnumCompressed byMeta(int meta) {
		if(meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}

		return META_LOOKUP[meta];
	}

	static {
		for(EnumCompressed compressed : values()) {
			META_LOOKUP[compressed.getMeta()] = compressed;
			NAMES[compressed.getMeta()] = "x" + compressed.getTier();
		}
	}
}