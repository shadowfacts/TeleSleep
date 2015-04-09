package net.shadowfacts.telesleep;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author shadowfacts
 */
@Mod(modid = TeleSleep.modId, name = TeleSleep.displayName, version = TeleSleep.version)
public class TeleSleep {

	public static final String modId = "telesleep";
	public static final String displayName = "TeleSleep";
	public static final String version = "@VERSION@";

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

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(CommandReloadTeleSleep.instance);
	}

}
