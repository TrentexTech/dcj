package de.TrentexTech.dcj.framework;

import java.util.ArrayList;
import java.util.List;

import de.TrentexTech.dcj.cmd.CMDHelp;
import de.TrentexTech.dcj.cmd.CMDMute;
import de.TrentexTech.dcj.main.Dcj;
import de.TrentexTech.dcj.stuff.CommandExecutor;

public class Commands {

	private Dcj dcj;
	private List<CommandExecutor> list = new ArrayList<CommandExecutor>();

	public Commands(Dcj dcj) {
		this.dcj = dcj;

		//

		list.add(new CMDHelp());
		list.add(new CMDMute());

		//

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getAliases().size(); j++) {
				this.dcj.cmdList.put(list.get(i).getAliases().get(j), list.get(i));
			}
		}
	}
}
