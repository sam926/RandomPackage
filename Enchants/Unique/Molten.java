package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Molten implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Molten").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player victim = (Player) event.getEntity();
						Random random = new Random();
						int chance = 7;
						for(int i = 1; i <= 4; i++) {
							chance = chance + 1;
							if(!(random.nextInt(100) <= chance)) { return; }
							if(!(victim.getInventory().getHelmet() == null)
									&& victim.getInventory().getHelmet().hasItemMeta()
									&& victim.getInventory().getHelmet().getItemMeta().hasLore()
									&& victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Molten.Molten" + i + ".ItemLore")))
									|| !(victim.getInventory().getChestplate() == null)
									&& victim.getInventory().getChestplate().hasItemMeta()
									&& victim.getInventory().getChestplate().getItemMeta().hasLore()
									&& victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Molten.Molten" + i + ".ItemLore")))
									|| !(victim.getInventory().getLeggings() == null)
									&& victim.getInventory().getLeggings().hasItemMeta()
									&& victim.getInventory().getLeggings().getItemMeta().hasLore()
									&& victim.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Molten.Molten" + i + ".ItemLore")))
									|| !(victim.getInventory().getBoots() == null)
									&& victim.getInventory().getBoots().hasItemMeta()
									&& victim.getInventory().getBoots().getItemMeta().hasLore()
									&& victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Molten.Molten" + i + ".ItemLore")))) {
								event.getDamager().setFireTicks(140);
								return;
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
