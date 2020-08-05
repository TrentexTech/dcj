package de.TrentexTech.dcj.cmd;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.Command.CommandExecutor;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMDNerv implements CommandExecutor {

	List<String> aliases = new ArrayList<String>();

	public CMDNerv() {
		aliases.add("nerv");
	}

	/**
	 * Send anonymous ping ;).
	 */
	@Override
	public boolean onCommand(User sender, String command, String[] args, MessageReceivedEvent event) {
		if (args.length == 1) {
			event.getMessage().delete().queue();
			event.getChannel().sendMessage("nerv: " + event.getGuild().getMemberByTag(args[0]).getAsMention()).queue();
			return true;
		}
		return false;
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

}
