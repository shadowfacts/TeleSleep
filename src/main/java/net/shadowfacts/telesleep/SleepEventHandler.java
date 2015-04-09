package net.shadowfacts.telesleep;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

/**
 * @author shadowfacts
 */
public class SleepEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerSleepInBed(PlayerSleepInBedEvent event) {
		if (SleepLocations.instance.logBedCoords) {
			System.out.println("Bed coordinates: " + getCoordsFromEvent(event).toString());
		}
		if (isBedLocationValid(event)) {
			Coord4d newCoord = SleepLocations.instance.getCoordFromBedCoord(getCoordsFromEvent(event));
			if (newCoord.dim != event.entityPlayer.dimension) {
				event.entityPlayer.travelToDimension(newCoord.dim);
			}
			event.entityPlayer.setPositionAndUpdate(newCoord.x, newCoord.y, newCoord.z);
		}
	}

	public boolean isBedLocationValid(PlayerSleepInBedEvent event) {
		return SleepLocations.instance.hasLocation(getCoordsFromEvent(event));
	}

	public Coord4d getCoordsFromEvent(PlayerSleepInBedEvent event) {
		return new Coord4d(event.x, event.y, event.z, event.entityPlayer.dimension);
	}

}
