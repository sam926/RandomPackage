package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Lifesteal implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Lifesteal").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			LivingEntity entity = (LivingEntity) event.getEntity();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().hasItemMeta())
					|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 8;
							for(int i = 1; i <= 5; i++) {
								chance = chance + 2;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Lifesteal.Lifesteal" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									if(entity.getHealth() - 1 <= 0
											|| damager.getHealth() + 1 > damager.getMaxHealth()) {
										return;
									} else {
										entity.setHealth(entity.getHealth() - 1);
										damager.setHealth(damager.getHealth() + 1);
										damager.getWorld().playSound(damager.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 5);
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
}
