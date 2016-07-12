package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Tank implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Armored").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						Player victim = (Player) event.getEntity();
						Random random = new Random();
						int randomNumber = random.nextInt(100);
						int chance = 0;
						double dividedDamage = 0.0;
						for(int i = 1; i <= 4; i++) {
							chance = chance + 6;
							if(randomNumber <= chance && !(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) {
								if(!(victim.getInventory().getHelmet() == null)
										&& victim.getInventory().getHelmet().hasItemMeta()
										&& victim.getInventory().getHelmet().getItemMeta().hasLore()
										&& victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Tank.Tank" + i + ".ItemLore")))) {
									dividedDamage = dividedDamage + 1.85 * i;
								}
								if(!(victim.getInventory().getChestplate() == null)
										&& victim.getInventory().getChestplate().hasItemMeta()
										&& victim.getInventory().getChestplate().getItemMeta().hasLore()
										&& victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Tank.Tank" + i + ".ItemLore")))) {
									dividedDamage = dividedDamage + 1.85 * i;
								}
								if(!(victim.getInventory().getLeggings() == null)
										&& victim.getInventory().getLeggings().hasItemMeta()
										&& victim.getInventory().getLeggings().getItemMeta().hasLore()
										&& victim.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Tank.Tank" + i + ".ItemLore")))) {
									dividedDamage = dividedDamage + 1.85 * i;
								}
								if(!(victim.getInventory().getBoots() == null)
										&& victim.getInventory().getBoots().hasItemMeta()
										&& victim.getInventory().getBoots().getItemMeta().hasLore()
										&& victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Tank.Tank" + i + ".ItemLore")))) {
									dividedDamage = dividedDamage + 1.85 * i;
								}
								event.setDamage(event.getDamage() / dividedDamage);
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
