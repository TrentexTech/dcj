package de.TrentexTech.dcj.framework;

import java.util.logging.Level;

@SuppressWarnings("rawtypes")
public class Logger {

	public Logger() {
		// TODO Auto-generated constructor stub
	}

	public static void log(Level level, String subject, Class cls, String msg) {
		System.out.println(level.getName() + " - " + cls.getSimpleName() + " - " + subject + ": " + msg);
	}

	public static void logInfo(String subject, Class cls, String msg) {
		log(Level.INFO, subject, cls, msg);
	}

	public static void logWarn(String subject, Class cls, String msg) {
		// TODO sponge colorcode
		log(Level.WARNING, subject, cls, "" + msg);
	}

}
