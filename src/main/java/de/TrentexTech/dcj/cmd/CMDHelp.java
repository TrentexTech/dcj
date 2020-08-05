package de.TrentexTech.dcj.cmd;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.main.Storage;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMDHelp implements CommandExecutor {

	List<String> aliases = new ArrayList<String>();

	public CMDHelp() {
		this.aliases.add("help");
	}

	/**
	 * Send an embed with info on how to use the bot
	 */
	@Override
	public boolean onCommand(User sender, String command, String[] args, MessageReceivedEvent event) {
		// TODO sponge add embed and info
		Storage.commandChannel.sendMessage("help stuff yk TODO").queue();
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.BLUE);
		embed.setTitle("All I can do for you");
		embed.addField("Usage:", "</<command> [arguments..]", false);
		embed.addField("help:", "This helping hand.", false);
		embed.addField("mute:", "Mute your self (broken).", false);
		embed.setFooter("nothing to see here!");

		Storage.commandChannel.sendMessage(embed.build()).queue();
		embed.clear();
		return true;
	}

	public List<String> getAliases() {
		return aliases;
	}
}
