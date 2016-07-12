package me.randomHashTags.randomPackage.RandomPlus.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class FallenHeros implements Listener {
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null) {
			return;
		} else {
			return;
		}
	}
}
