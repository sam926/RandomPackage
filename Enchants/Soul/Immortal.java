package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Soul;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Immortal implements Listener {
	@EventHandler
	private void playerItemDamageEvent(PlayerItemDamageEvent event) {
		if(event.isCancelled() || !(event.getItem().hasItemMeta()) || !(event.getItem().getItemMeta().hasLore())) {
			if(event.getItem().getType().name().endsWith("HELMET") && event.getItem().getType().name().endsWith("CHESTPLATE")
					&& event.getItem().getType().name().endsWith("LEGGINGS") && event.getItem().getType().name().endsWith("BOOTS")
					|| !(RandomPackage.getEnabledEnchantsConfig().getString("Soul.Immortal").equalsIgnoreCase("true"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							for(int i = 1; i <= 4; i++) {
								if(event.getItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal" + i + ".ItemLore")))) {
									event.setCancelled(true);
									return;
								}
							}
							return;
						}
					}
				}, 1);
				return;
			}
		} else {
			return;
		}
	}
}