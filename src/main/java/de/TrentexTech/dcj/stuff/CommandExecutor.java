package de.TrentexTech.dcj.stuff;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

public abstract interface CommandExecutor {

	public static final List<String> aliases = new ArrayList<String>();

	/**
	 * Executes the given command, returning its success
	 *
	 * @param sender  Source of the command
	 * @param command Command which was executed
	 * @param args    Passed command arguments
	 * @param guild   Guild command message
	 * @return true if a valid command, otherwise false
	 */
	boolean onCommand(User sender, String command, String[] args, Guild guild);

	public List<String> getAliases();

}
