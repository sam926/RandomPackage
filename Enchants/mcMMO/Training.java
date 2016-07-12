package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Training implements Listener {
	@EventHandler
	private void mcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent event) {
		if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						double xp = 0.0;
						//for(int i = 1; i <= 10; i++) {
							xp = xp + 0.4;
							event.setXpGained(event.getXpGained() * 2);
							event.getPlayer().sendMessage("multiplied xp");
							return;
						//}
					}
				}
			}, 1);
			return;
		}
	}
}
