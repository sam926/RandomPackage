package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

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

public class RocketEscape implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.RocketEscape").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player victim = (Player) event.getEntity();
						if(!(victim.getInventory().getBoots() == null) && victim.getInventory().getBoots().hasItemMeta() && victim.getInventory().getBoots().getItemMeta().hasLore()) {
							Random random = new Random();
							int health = 4;
							int chance = 7;
							int duration = 40;
							int level = 4;
							
							for(int i = 1; i <= 3; i++) {
								health = health + 2;
								chance = chance + 1;
								duration = duration + 20;
								level = level + 5;
								if(victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.RocketEscape.RocketEscape" + i + ".ItemLore")))
										&& victim.getHealth() <= health
										&& random.nextInt(100) <= chance) {
									if(victim.hasPotionEffect(PotionEffectType.JUMP)) {
										victim.removePotionEffect(PotionEffectType.JUMP);
										victim.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, duration, level));
									}
									if(victim.hasPotionEffect(PotionEffectType.REGENERATION)) {
										victim.removePotionEffect(PotionEffectType.REGENERATION);
										victim.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 4));
									}
								}
							}
							return;
						} else { return; }
					}
				}
			}, 1);
			return;
		}
	}
}