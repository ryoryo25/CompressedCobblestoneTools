package ryoryo.cct.util;

public class References {
	public static final String MOD_ID = "cct";
	public static final String MOD_NAME = "CompressedCobblestoneTools";

	public static final String MOD_VERSION_MAJOR = "GRADLE.VERSION_MAJOR";
	public static final String MOD_VERSION_MINOR = "GRADLE.VERSION_MINOR";
	public static final String MOD_VERSION_PATCH = "GRADLE.VERSION_PATCH";
	public static final String MOD_VERSION = MOD_VERSION_MAJOR + "." + MOD_VERSION_MINOR + "." + MOD_VERSION_PATCH;

	public static final String MOD_DEPENDENCIES = "required-after:forge@[14.23.5.2768,);"
			//			+ "required-after:polishedlib@[1.1.1,);";
			+ "required-after:polishedlib;";

	public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
	public static final String MOD_GUI_FACTORY = "ryoryo.cct.config.GuiFactoryModConfig";

	public static final String PROXY_CLIENT = "ryoryo.cct.proxy.ClientProxy";
	public static final String PROXY_COMMON = "ryoryo.cct.proxy.CommonProxy";
}