package de.TrentexTech.dcj.cmd;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

public class CMDGit implements CommandExecutor {

	List<String> aliases = new ArrayList<String>();

	public CMDGit() {
		this.aliases.add("git");
		this.aliases.add("github");
	}

	/**
	 * send a link to the GitHub page.
	 */
	@Override
	public boolean onCommand(User sender, String command, String[] args, Guild guild) {
		// TODO sponge send message /create and send embed with link
		Storage.commandChannel.sendMessage("```\nhttps://github.com/TrentexTech/dcj\n```").queue();
		return false;
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

}
