package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Wither implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Wither").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player player = (Player) event.getEntity();
						Player damager = (Player) event.getDamager();
						if(player.getInventory().getLeggings() == null || !(player.getInventory().getLeggings().hasItemMeta())
								|| !(player.getInventory().getLeggings().getItemMeta().hasLore())) {
							return;
						} else {
							int duration = 0;
							int level = 1;
							for(int i = 1; i <= 5; i++) {
								duration = duration + 80;
								if(duration > 240) { duration = 240; }
								if(player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Wither.Wither" + i + ".ItemLore")))) {
									damager.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration, level));
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