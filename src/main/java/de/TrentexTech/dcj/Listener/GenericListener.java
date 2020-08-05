package de.TrentexTech.dcj.Listener;

import de.TrentexTech.dcj.main.Dcj;
import de.TrentexTech.dcj.main.Storage;
import de.TrentexTech.dcj.utils.Logger;
import net.dv8tion.jda.api.events.GatewayPingEvent;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class GenericListener implements EventListener {

	private Dcj dcj;

	public GenericListener(Dcj dcj) {
		this.dcj = dcj;
		Logger.logInfo("EventListener", this.getClass(), "Listener registered.");
	}

	public void onEvent(GenericEvent event) {
		if (event instanceof ReadyEvent) {
			Logger.logInfo("Bot", this.getClass(), "ready");
		} else if (event instanceof GatewayPingEvent && this.dcj.ready) {
			event = (GatewayPingEvent) event;
			Storage.getAnnouncementChannel().sendMessage("ping: " + dcj.getJda().getGatewayPing()).queue();
		}
	}

}
