package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Cactus implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getEntity() instanceof Player)
				|| !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Cactus").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					Player victim = (Player) event.getEntity();
					Player damager = (Player) event.getDamager();
					Random random = new Random();
					int chance = 25;
					for(int i = 1; i <= 2; i++) {
						if(!(random.nextInt(100) <= chance)) { return;
						} else {
							if(!(victim.getInventory().getHelmet() == null)
									&& victim.getInventory().getHelmet().hasItemMeta()
									&& victim.getInventory().getHelmet().getItemMeta().hasLore()
									&& victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus" + i + ".ItemLore")))
									|| !(victim.getInventory().getChestplate() == null)
									&& victim.getInventory().getChestplate().hasItemMeta()
									&& victim.getInventory().getChestplate().getItemMeta().hasLore()
									&& victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus" + i + ".ItemLore")))
									|| !(victim.getInventory().getLeggings() == null)
									&& victim.getInventory().getLeggings().hasItemMeta()
									&& victim.getInventory().getLeggings().getItemMeta().hasLore()
									&& victim.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus" + i + ".ItemLore")))
									|| !(victim.getInventory().getBoots() == null)
									&& victim.getInventory().getBoots().hasItemMeta()
									&& victim.getInventory().getBoots().getItemMeta().hasLore()
									&& victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus" + i + ".ItemLore")))) {
								damager.damage(i);
								return;
							}
						}
					}
					return;
				}
			}, 1);
			return;
		}
	}
}