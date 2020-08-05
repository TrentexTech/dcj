package de.TrentexTech.dcj.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.utils.Logger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMDMute implements CommandExecutor {

	List<String> aliases = new ArrayList<String>();

	public CMDMute() {
		aliases.add("mute");
	}

	/**
	 * Mute the user (currently).
	 */
	@Override
	public boolean onCommand(User sender, String command, String[] args, MessageReceivedEvent event) {
		if (args.length == 1) {
			Guild guild = event.getGuild();
			List<Role> roleList = guild.getRolesByName("Muted", false);
			Member member = event.getMessage().getMentionedMembers().get(0);
			if (roleList.size() < 1) {
				Logger.logWarn("CMD_Mute", this.getClass(), "Role \"Mute\" doesn't exist");
			} else {
				guild.addRoleToMember(member, roleList.get(0)).queue();
				Storage.commandChannel.sendMessage(member.getUser().getAsTag() + " is now muted.").queue();
				Logger.log(Level.INFO, "CMDMute finished", this.getClass(),
						sender.getAsTag() + " muted " + member.getUser().getAsTag());
				return true;
			}
		}
		return false;
	}

	public List<String> getAliases() {
		return aliases;
	}

}
