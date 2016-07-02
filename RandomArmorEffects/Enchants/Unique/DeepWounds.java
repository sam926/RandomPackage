package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

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

public class DeepWounds implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.DeepWounds").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						LivingEntity victim = (LivingEntity) event.getEntity();
						Player damager = (Player) event.getDamager();
						
						Random random = new Random();
						int randomChance = 100; // 100%
						int randomNumber = random.nextInt(randomChance);
						if(damager.getInventory().getItemInMainHand() == null
								|| !(damager.getInventory().getItemInMainHand().hasItemMeta())
								|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
							return;
						} else {
							int chance = 7;
							for(int i = 1; i <= 3; i++) {
								chance = chance + 1;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.DeepWounds.DeepWounds" + i + ".ItemLore")))
										&& randomNumber <= chance) {
									victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 140, i - 1));
									return;
								}
							}
							return;
						}
					}
				}
			}, 1);
			return;
		}
	}
}