package de.TrentexTech.dcj.Command;

import de.TrentexTech.dcj.main.Storage;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class Command {

	User sender;
	String label;
	String[] args;

	public Command() {
		// TODO Auto-generated constructor stub
	}

	private void setSender(User sender) {
		this.sender = sender;
	}

	private void setLabel(String label) {
		this.label = label;
	}

	private void setArgs(String[] args) {
		this.args = args;
	}

	public static Command parse(Message message) {

		String str = message.getContentDisplay().substring(Storage.PREFIX.length());

		String[] a = str.split(" ");
		String[] b = new String[a.length - 1];
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i + 1];
		}

		Command command = new Command();
		command.setSender(message.getAuthor());
		command.setLabel(a[0]);
		command.setArgs(b);

		return command;
	}

	public String getLabel() {
		return label;
	}

	public User getSender() {
		return sender;
	}

	public String[] getArgs() {
		return args;
	}

}
