package de.TrentexTech.dcj.cmd;

import java.util.List;

import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class CMDMute implements CommandExecutor {

	public CMDMute() {
		aliases.add("mute");
	}

	public boolean onCommand(User sender, String command, String[] args, Guild guild) {

		List<Role> roleList = guild.getRolesByName("Muted", false);
		if (roleList.size() < 1) {
			System.out.println("no rule");
		} else {
			for (int i = 0; i < roleList.size(); i++) {
				if (roleList.get(i).getName().equals("Muted")) {
					guild.addRoleToMember(guild.getMember(sender), roleList.get(i));
					Storage.commandChannel.sendMessage("mute them all").queue();
					return true;
				}
			}
		}
		return false;
	}

	public List<String> getAliases() {
		return aliases;
	}

}
