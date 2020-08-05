package de.TrentexTech.dcj.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.Listener.GenericListener;
import de.TrentexTech.dcj.Listener.MessageListener;
import de.TrentexTech.dcj.utils.Commands;
import de.TrentexTech.dcj.utils.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class Dcj {

	private JDA jda;
	private Commands cmds;

	public boolean ready = false;

	public Map<String, CommandExecutor> cmdList = new HashMap<String, CommandExecutor>();

	public Dcj() throws LoginException, InterruptedException {
		jda = JDABuilder.createDefault(Storage.getTOKEN()).build();
		getJda().addEventListener(new GenericListener(this));
		getJda().addEventListener(new MessageListener(this));
		getJda().awaitReady();
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

	private void init() {
		cmds = new Commands(this);
		List<TextChannel> channels = getJda().getTextChannels();
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

	public JDA getJda() {
		return jda;
	}
}
