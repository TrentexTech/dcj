package de.TrentexTech.dcj.cmd;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.main.Storage;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

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
	public boolean onCommand(User sender, String command, String[] args, MessageReceivedEvent event) {
		// TODO sponge send message /create and send embed with link
		Storage.commandChannel.sendMessage("```\nhttps://github.com/TrentexTech/dcj\n```").queue();
		return false;
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

}
