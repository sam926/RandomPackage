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
		if(event.getItem().getType().name().endsWith("HELMET")
				|| event.getItem().getType().name().endsWith("CHESTPLATE")
				|| event.getItem().getType().name().endsWith("LEGGINGS")
				|| event.getItem().getType().name().endsWith("BOOTS")) {
			if(!(event.getItem().hasItemMeta())
					|| !(event.getItem().getItemMeta().hasLore())
					|| event.isCancelled()
					|| !(RandomPackage.getEnabledEnchantsConfig().getString("Soul.Immortal").equalsIgnoreCase("true"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							if(event.getItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal1.ItemLore")))
									|| event.getItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal2.ItemLore")))
									|| event.getItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal3.ItemLore")))
									|| event.getItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal4.ItemLore")))) {
								event.setCancelled(true);
								return;
							} else {
								return;
							}
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
