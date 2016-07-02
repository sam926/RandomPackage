package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class NPCinteract implements Listener {
	private ArrayList<String> doubleCommand = new ArrayList<String>();
	@EventHandler
	private void playerInteractEntityEvent(PlayerInteractEntityEvent event) {
		if(doubleCommand.contains(event.getPlayer().getName())) { return; }
		if(event.getRightClicked().getCustomName() == null) { return;
		} else if(event.getRightClicked().getCustomName().equalsIgnoreCase("Tinkerer")) {
			event.getPlayer().performCommand("tinkerer");
		} else if(event.getRightClicked().getCustomName().equalsIgnoreCase("Enchanter")) {
			event.getPlayer().performCommand("enchanter");
		} else if(event.getRightClicked().getCustomName().equalsIgnoreCase("Alchemist")) {
			event.getPlayer().performCommand("alchemist");
		} else { return; }
		doubleCommand.add(event.getPlayer().getName());
		Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
			public void run() {
				doubleCommand.remove(event.getPlayer().getName());
				return;
			}
		}, 5);
		return;
	}
}
