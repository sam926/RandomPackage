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

public class Curse implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Curse").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			if(victim.getInventory().getChestplate() == null || !(victim.getInventory().getChestplate().hasItemMeta()) || !(victim.getInventory().getChestplate().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 8;
							int duration = 60;
							for(int i = 1; i <= 3; i++) {
								chance = chance + 2;
								duration = duration + 40;
								if(victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Curse.Curse" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									damager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, 4));
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
}