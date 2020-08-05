package de.TrentexTech.dcj.cmd;

import java.util.List;

import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class CMDHelp implements CommandExecutor {

	public CMDHelp() {
		aliases.add("help");
	}

	public boolean onCommand(User sender, String command, String[] args, Guild guild) {
		Storage.commandChannel.sendMessage("help stuff yk").queue();
		List<Guild> list = sender.getMutualGuilds();
		for (int i = 0; i < list.size(); i++) {
			List<Role> roles = list.get(i).getRoles();
			for (int j = 0; j < roles.size(); j++) {
				System.out.println(list.get(i).getName() + "(" + i + "): " + roles.get(j).getName() + "(" + j + ")");
			}
		}
		return true;
	}

	public List<String> getAliases() {
		return aliases;
	}
}
