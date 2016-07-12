package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Vampire implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Vampire").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player player = (Player) event.getDamager();
						if(player.getInventory().getItemInMainHand() == null || !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
								|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(player.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
							return;
						} else {
							Random random = new Random();
							int chance = 16;
							for(int i = 1; i <= 3; i++) {
								if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Vampire.Vampire" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									if(player.getHealth() + event.getDamage() / 2 > player.getMaxHealth()) { player.setHealth(player.getMaxHealth()); return;
									} else { player.setHealth(player.getHealth() + event.getDamage() / 2); return; }
								}
							}
							return;
						}
					}
				}
			}, 1);
			return;
		}
	}
}
