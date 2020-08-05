package de.TrentexTech.dcj.utils;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.Command.CommandExecutor;
import de.TrentexTech.dcj.cmd.CMDGit;
import de.TrentexTech.dcj.cmd.CMDHelp;
import de.TrentexTech.dcj.cmd.CMDMute;
import de.TrentexTech.dcj.cmd.CMDNerv;
import de.TrentexTech.dcj.main.Dcj;

public class Commands {

	private Dcj dcj;
	private List<CommandExecutor> list = new ArrayList<CommandExecutor>();

	public Commands(Dcj dcj) {
		this.dcj = dcj;

		// Initialize and add command handlers

		list.add(new CMDHelp());
		list.add(new CMDMute());
		list.add(new CMDGit());
		list.add(new CMDNerv());

		// Add the aliases and command handler to command handler list

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getAliases().size(); j++) {
				System.out.println(
						"add " + list.get(i).getAliases().get(j) + " for " + list.get(i).getClass().getSimpleName());
				this.dcj.cmdList.put(list.get(i).getAliases().get(j), list.get(i));
			}
		}
	}
}
