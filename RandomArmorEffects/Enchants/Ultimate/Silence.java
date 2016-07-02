package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Silence implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Silence").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().hasItemMeta())
					|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 4;
							for(int i = 1; i <= 4; i++) {
								chance = chance + 1;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Silence.Silence" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance) {
									Player victim = (Player) event.getEntity();
									victim.removePotionEffect(PotionEffectType.ABSORPTION);
									victim.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
									victim.removePotionEffect(PotionEffectType.FAST_DIGGING);
									victim.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
									victim.removePotionEffect(PotionEffectType.HEALTH_BOOST);
									victim.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
									victim.removePotionEffect(PotionEffectType.INVISIBILITY);
									victim.removePotionEffect(PotionEffectType.JUMP);
									victim.removePotionEffect(PotionEffectType.NIGHT_VISION);
									victim.removePotionEffect(PotionEffectType.REGENERATION);
									victim.removePotionEffect(PotionEffectType.SATURATION);
									victim.removePotionEffect(PotionEffectType.SPEED);
									victim.removePotionEffect(PotionEffectType.WATER_BREATHING);
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
