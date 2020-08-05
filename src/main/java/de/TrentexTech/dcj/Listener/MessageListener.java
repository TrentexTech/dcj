package de.TrentexTech.dcj.Listener;

import java.util.logging.Level;

import de.TrentexTech.dcj.Command.Command;
import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.main.Dcj;
import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.utils.Logger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

	private Dcj dcj;

	public MessageListener(Dcj dcj) {
		this.dcj = dcj;
		Logger.logInfo("EventListener", this.getClass(), "Listener registered.");
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (!(event.getChannel() instanceof TextChannel)) {
			return;
		}
		Message message = event.getMessage();
		TextChannel channel = (TextChannel) event.getChannel();

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
				handleCommand(event);
			}
		} else {
			if (msg.startsWith("nerv: ")) {
				// message.delete().queue();
			}
		}
	}

	private void handleCommand(MessageReceivedEvent event) {
		Command cmd = Command.parse(event.getMessage());
		CommandExecutor ce = dcj.getCommand(cmd.getLabel());
		Logger.logInfo("CommandExecution", ce.getClass(), cmd.getSender().getAsTag() + ": " + cmd.getLabel());
		ce.onCommand(cmd.getSender(), cmd.getLabel(), cmd.getArgs(), event);
	}
}
