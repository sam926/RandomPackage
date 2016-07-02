package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Barbarian implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Barbarian").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						if(!(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().getType().name().endsWith("AXE") && !(damager.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
								&& damager.getInventory().getItemInMainHand().hasItemMeta() && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
							Random random = new Random();
							int chance = 40;
							for(int i = 1; i <= 4; i++) {
								chance = chance + 10;
								if(!(random.nextInt(100) <= chance)) { return;
								} else {
									double damage = 0.0;
									if(i == 1) { damage = 1.15; } else if(i == 2) { damage = 1.20; } else if(i == 3) { damage = 1.25; } else { damage = 1.30; }
									if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Barbarian.Barbarian" + i + ".ItemLore")))) {
										event.setDamage(event.getDamage() * damage);
										damager.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("BarbarianCriticalMessage")));
										damager.playSound(damager.getLocation(), Sound.ITEM_SHIELD_BLOCK, 1, 2);
										return;
									}
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
