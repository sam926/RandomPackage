package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Deathbringer implements Listener {
	
	@EventHandler
	private void deathbringerHelmet(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Deathbringer").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						Random random = new Random();
						int chance = 8;
						int duration = 320;
						for(int i = 1; i <= 3; i++) {
							chance = chance + 2;
							duration = duration - 80;
							if(!(random.nextInt(100) <= chance)) { return;
							} else {
								if(!(damager.getInventory().getHelmet() == null)
										&& damager.getInventory().getHelmet().hasItemMeta()
										&& damager.getInventory().getHelmet().getItemMeta().hasLore()
										&& damager.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Deathbringer.Deathbringer" + i + ".ItemLore")))
										|| !(damager.getInventory().getChestplate() == null)
										&& damager.getInventory().getChestplate().hasItemMeta()
										&& damager.getInventory().getChestplate().getItemMeta().hasLore()
										&& damager.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Deathbringer.Deathbringer" + i + ".ItemLore")))
										|| !(damager.getInventory().getLeggings() == null)
										&& damager.getInventory().getLeggings().hasItemMeta()
										&& damager.getInventory().getLeggings().getItemMeta().hasLore()
										&& damager.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Deathbringer.Deathbringer" + i + ".ItemLore")))
										|| !(damager.getInventory().getBoots() == null)
										&& damager.getInventory().getBoots().hasItemMeta()
										&& damager.getInventory().getBoots().getItemMeta().hasLore()
										&& damager.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Deathbringer.Deathbringer" + i + ".ItemLore")))) {
									damager.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, i - 1));
									return;
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