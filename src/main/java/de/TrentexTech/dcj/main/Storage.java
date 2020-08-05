package de.TrentexTech.dcj.main;

import java.util.logging.Level;

import de.TrentexTech.dcj.utils.Logger;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

public class Storage {

	private static String TOKEN;
	// TODO sponge get bot name;
	public static String NAME;

	public static String CMDCHANNEL = "bot-commands";
	public static String PREFIX = "</";

	private static TextChannel announcementChannel;
	public static MessageChannel commandChannel;

	public static void setToken(String string) {
		if (!(TOKEN != null)) {
			TOKEN = string;
		}
	}

	public static String getTOKEN() {
		return TOKEN;
	}

	public static TextChannel getAnnouncementChannel() {
		return announcementChannel;
	}

	public static void setAnnouncementChannel(TextChannel announcementChannel) {
		Storage.announcementChannel = announcementChannel;
		Logger.log(Level.FINE, "anChannelSet", Storage.class, "is now set");
	}
}
