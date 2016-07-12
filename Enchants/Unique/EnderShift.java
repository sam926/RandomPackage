package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

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

public class EnderShift implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.EnderShift").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player victim = (Player) event.getEntity();
			if(victim.getInventory().getHelmet() == null
					|| !(victim.getInventory().getHelmet().hasItemMeta()) || !(victim.getInventory().getHelmet().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 15;
							int health = 8;
							int duration = 40;
							int level = 6;
							for(int i = 1; i <= 3; i++) {
								chance = chance + 1;
								health = health + 2;
								duration = duration + 20;
								level = level + 1;
								if(victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.EnderShift.EnderShift" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance
										&& victim.getHealth() <= health) {
									if(victim.hasPotionEffect(PotionEffectType.SPEED)) {
										victim.removePotionEffect(PotionEffectType.SPEED);
										victim.addPotionEffect(new PotionEffect(PotionEffectType.SPEED , duration, level));
										victim.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 160, 1));
										return;
									} else {
										victim.addPotionEffect(new PotionEffect(PotionEffectType.SPEED , duration, level));
										victim.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 160, 1));
										return;
									}
								}
							}
						}
					}
				}, 1);
				return;
			}
		}
	}
}