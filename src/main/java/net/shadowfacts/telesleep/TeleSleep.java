package net.shadowfacts.telesleep;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author shadowfacts
 */
@Mod(modid = TeleSleep.modId, name = TeleSleep.displayName, version = TeleSleep.version, guiFactory = TeleSleep.guiFactory)
public class TeleSleep {

	public static final String modId = "telesleep";
	public static final String displayName = "TeleSleep";
	public static final String version = "@VERSION@";
	public static final String guiFactory = "net.shadowfacts.telesleep.client.gui.TSGuiFactory";

	@Mod.Instance(modId)
	public static TeleSleep instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SleepLocations.load(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SleepEventHandler());
	}

}
