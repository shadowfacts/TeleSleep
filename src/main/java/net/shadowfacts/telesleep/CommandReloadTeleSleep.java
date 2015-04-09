package net.shadowfacts.telesleep;

import com.google.gson.Gson;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author shadowfacts
 */
public class CommandReloadTeleSleep extends CommandBase {

	public static final String COMMAND_DISALLOWED = "You are not allowed to use this command.";

	public static CommandReloadTeleSleep instance = new CommandReloadTeleSleep();


	@Override
	public String getCommandName() {
		return "reloadTeleSleep";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Reloads the TeleSleep locations from config/TeleSleep.json";
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		try {

			FileReader reader = new FileReader(SleepLocations.f);
			SleepLocations.instance = new Gson().fromJson(reader, SleepLocations.class);

			sender.addChatMessage(new ChatComponentText("Reloaded!"));

		} catch (IOException e) {
			System.err.println("There was a problem  loading TeleSleep.json!");
			e.printStackTrace();

			sender.addChatMessage(new ChatComponentText("There was a problem loading TeleSleep.json!"));
		}
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		return null;
	}
}
