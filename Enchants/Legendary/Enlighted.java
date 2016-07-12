package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Enlighted implements Listener {
	
	@EventHandler
	private void helmet(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Enlighted").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Random random = new Random();
						int chance = 7;
						Player damager = (Player) event.getEntity();
						for(int i = 1; i <= 3; i++) {
							chance = chance + 8;
							if(!(random.nextInt(100) < chance)) { return;
							} else {
								if(!(damager.getInventory().getHelmet() == null)
										&& damager.getInventory().getHelmet().hasItemMeta()
										&& damager.getInventory().getHelmet().getItemMeta().hasLore()
										&& damager.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted" + i + ".ItemLore")))
										|| !(damager.getInventory().getChestplate() == null)
										&& damager.getInventory().getChestplate().hasItemMeta()
										&& damager.getInventory().getChestplate().getItemMeta().hasLore()
										&& damager.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted" + i + ".ItemLore")))
										|| !(damager.getInventory().getLeggings() == null)
										&& damager.getInventory().getLeggings().hasItemMeta()
										&& damager.getInventory().getLeggings().getItemMeta().hasLore()
										&& damager.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted" + i + ".ItemLore")))
										|| !(damager.getInventory().getBoots() == null)
										&& damager.getInventory().getBoots().hasItemMeta()
										&& damager.getInventory().getBoots().getItemMeta().hasLore()
										&& damager.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted" + i + ".ItemLore")))) {
									if(damager.getHealth() + 2 <= damager.getMaxHealth()) {
										damager.setHealth(damager.getHealth() + 2);
										return;
									} else { return; }
								}
							}
						}
						return;
					}
				}
			}, 1);
			return;
		}
	}
}