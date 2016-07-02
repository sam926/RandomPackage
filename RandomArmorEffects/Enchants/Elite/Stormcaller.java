package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Stormcaller implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Stormcaller").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player victim = (Player) event.getEntity();
						Player damager = (Player) event.getDamager();
						Random random = new Random();
						int chance = 13;
						for(int i = 1; i <= 4; i++) {
							chance = chance + 2;
							if(!(victim.getInventory().getHelmet() == null)
									&& victim.getInventory().getHelmet().hasItemMeta()
									&& victim.getInventory().getHelmet().getItemMeta().hasLore()
									&& victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Stormcaller.Stormcaller" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance
									|| !(victim.getInventory().getChestplate() == null)
									&& victim.getInventory().getChestplate().hasItemMeta()
									&& victim.getInventory().getChestplate().getItemMeta().hasLore()
									&& victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Stormcaller.Stormcaller" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance
									|| !(victim.getInventory().getLeggings() == null)
									&& victim.getInventory().getLeggings().hasItemMeta()
									&& victim.getInventory().getLeggings().getItemMeta().hasLore()
									&& victim.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Stormcaller.Stormcaller" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance
									|| !(victim.getInventory().getBoots() == null)
									&& victim.getInventory().getBoots().hasItemMeta()
									&& victim.getInventory().getBoots().getItemMeta().hasLore()
									&& victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Stormcaller.Stormcaller" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance) {
								damager.getWorld().strikeLightning(new Location(damager.getWorld(), damager.getLocation().getX(), damager.getLocation().getY(), damager.getLocation().getZ()));
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