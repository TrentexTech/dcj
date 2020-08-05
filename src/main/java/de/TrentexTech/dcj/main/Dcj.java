package de.TrentexTech.dcj.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import de.TrentexTech.dcj.framework.Logger;
import de.TrentexTech.dcj.framework.MessageListener;
import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.GatewayPingEvent;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class Dcj implements EventListener {

	private JDA jda;

	public boolean ready = false;

	public Map<String, CommandExecutor> cmdList = new HashMap<String, CommandExecutor>();

	public Dcj() throws LoginException, InterruptedException {
		jda = JDABuilder.createDefault(Storage.getTOKEN()).build();
		jda.addEventListener(this);
		jda.addEventListener(new MessageListener(this));
		jda.awaitReady();
		init();
		ready = true;
	}

	public static void main(String[] args) {
		Storage.setToken(args[0]);
		try {
			new Dcj();
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onEvent(GenericEvent event) {
		// Logger.log(Level.DEBUG, "Testing", event.getClass().getSimpleName());
		if (event instanceof ReadyEvent) {
			Logger.logInfo("Bot", this.getClass(), "ready");
		} else if (event instanceof GatewayPingEvent && ready) {
			event = (GatewayPingEvent) event;
			Storage.getAnnouncementChannel().sendMessage("ping: " + jda.getGatewayPing()).queue();
		}
	}

	private void init() {
		List<TextChannel> channels = jda.getTextChannels();
		for (int i = 0; i < channels.size(); i++) {
			if (channels.get(i).getName().equals("bot-announcements")) {
				Storage.setAnnouncementChannel(channels.get(i));
				break;
			}
		}
	}

	public CommandExecutor getCommand(String name) {
		String alias = name.toLowerCase();

		if (cmdList.containsKey(alias)) {
			return cmdList.get(alias);
		}
		Logger.logWarn("CommandGrabber", this.getClass(), "Command is not initialized or does not exist!");
		return null;
	}
}
