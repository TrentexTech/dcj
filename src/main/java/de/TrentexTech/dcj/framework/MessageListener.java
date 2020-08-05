package de.TrentexTech.dcj.framework;

import java.util.logging.Level;

import de.TrentexTech.dcj.main.Dcj;
import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.stuff.Command;
import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

	Dcj dcj;
	Commands cmds;

	public MessageListener(Dcj dcj) {
		this.dcj = dcj;
		cmds = new Commands(this.dcj);
		Logger.logInfo("MessageListener", this.getClass(), "ready");
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (!(event.getChannel() instanceof TextChannel)) {
			return;
		}
		Message message = event.getMessage();
		TextChannel channel = (TextChannel) event.getChannel();
		Guild guild = event.getGuild();
		User sender = message.getAuthor();

		String msg = message.getContentDisplay();
		String channelName = channel.getName().toString();

		if (channelName.equals(Storage.CMDCHANNEL)) {
			Storage.commandChannel = channel;
		}

		Logger.log(Level.FINER, "MessageListener", this.getClass(),
				"[" + channelName + "|" + sender.getAsTag() + "]: " + msg);
		if (!sender.getAsTag().equals(Storage.NAME)) {
			if (msg.startsWith(Storage.PREFIX) && channelName.equals(Storage.CMDCHANNEL)) {
				handleCommand(message, guild);
			}
		}
	}

	private void handleCommand(Message message, Guild guild) {
		Command cmd = Command.parse(message);
		CommandExecutor ce = dcj.getCommand(cmd.getLabel());
		Logger.logInfo("CommandExecution", ce.getClass(), cmd.getSender().getAsTag() + ": help");
		ce.onCommand(cmd.getSender(), cmd.getLabel(), cmd.getArgs(), guild);
	}
}
