package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TestingPhase;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Trickster implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player)) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player player = (Player) event.getEntity();
						Random random = new Random();
						int chance = 5;
						for(int i = 1; i <= 8; i++) {
							chance = chance + 1;
							if(!(random.nextInt(100) <= chance)) { return;
							} else {
								if(!(player.getInventory().getHelmet() == null) && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().hasLore()
										&& player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trickster.Trickster" + i + ".ItemLore")))
										|| player.getInventory().getChestplate() == null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
										&& player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trickster.Trickster" + i + ".ItemLore")))
										|| player.getInventory().getLeggings() == null && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().hasLore()
										&& player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trickster.Trickster" + i + ".ItemLore")))
										|| player.getInventory().getBoots() == null && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore()
										&& player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trickster.Trickster" + i + ".ItemLore")))) {
									player.getLocation().setDirection(new Vector(-player.getLocation().getDirection().getX(), player.getLocation().getDirection().getY(), -player.getLocation().getDirection().getZ()));
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
