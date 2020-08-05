package de.TrentexTech.dcj.cmd;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.stuff.CommandExecutor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

public class CMDRemove implements CommandExecutor {

	List<String> aliases = new ArrayList<String>();

	public CMDRemove() {
		this.aliases.add("remove");
		this.aliases.add("rm");
	}

	/**
	 * multiple removing operations.
	 */
	@Override
	public boolean onCommand(User sender, String command, String[] args, Guild guild) {
		if (args.length == 2) {
			if (args[0].equals("msg")) {

				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

}
