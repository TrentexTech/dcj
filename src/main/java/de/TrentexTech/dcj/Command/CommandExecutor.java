package de.TrentexTech.dcj.Command;

import java.util.List;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract interface CommandExecutor {

	public static final List<String> aliases = null;

	/**
	 * Executes the given command, returning its success
	 *
	 * @param sender  Source of the command
	 * @param command Command which was executed
	 * @param args    Passed command arguments
	 * @param guild   Guild command message
	 * @return true if a valid command, otherwise false
	 */
	boolean onCommand(User sender, String command, String[] args, MessageReceivedEvent event);

	public List<String> getAliases();

}
