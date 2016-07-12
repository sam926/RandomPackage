package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Confusion implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Confusion").equalsIgnoreCase("true"))) {
			return;
		} else {
			Random random = new Random();
			Player damager = (Player) event.getDamager();
			LivingEntity entity = (LivingEntity) event.getEntity();
			
			if(damager.getInventory().getItemInMainHand() == null
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							int chance = 7;
							int duration = 100;
							for(int i = 1; i <= 3; i++) {
								chance = chance + 1;
								duration = duration + 20;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Confusion.Confusion" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration, i + 2));
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