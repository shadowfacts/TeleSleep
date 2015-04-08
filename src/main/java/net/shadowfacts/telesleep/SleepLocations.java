package net.shadowfacts.telesleep;

import com.google.gson.Gson;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shadowfacts
 */
public class SleepLocations {

	public static SleepLocations instance;

	public boolean logBedCoords;

	private Map<String, String> coordinates = new HashMap<String, String>();

	public static void load(FMLPreInitializationEvent event) {
		try {

			File f = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/TeleSleep.json");

			if (!f.exists()) {
				f.createNewFile();
				FileWriter writer = new FileWriter(f);
				writer.write(	"{" +
								"	\"logBedCoords\": true," +
								"	\"coordinates\": {" +
								"		\"0, 0, 0, 0\": \"0, 0, 0, 0\"" +
								"	}" +
								"}");
			}


			FileReader reader = new FileReader(f);

			instance = new Gson().fromJson(reader, SleepLocations.class);


		} catch (IOException e) {
			System.err.println("[TeleSleep] Couldn't load JSON file!");
			e.printStackTrace();
		}
	}

	public boolean hasLocation(Coord4d bedCoord) {
		return coordinates.containsKey(bedCoord.toString());
	}

	public Coord4d getCoordFromBedCoord(Coord4d bedCoord) {
		return new Coord4d(coordinates.get(bedCoord.toString()));
	}

}
