package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

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

public class Blind implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Blind").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int duration = 60;
							int chance = 7;
							for(int i = 1; i <= 3; i++) {
								duration = duration + 20;
								chance = chance + 1;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Blind.Blind" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration, 0));
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