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

public class SmokeBomb implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.SmokeBomb").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getHelmet() == null || !(player.getInventory().getHelmet().hasItemMeta()) || !(player.getInventory().getHelmet().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Player damager = (Player) event.getDamager();
							Random random = new Random();
							int chance = 8;
							for(int i = 1; i <= 8; i++) {
								chance = chance + 2;
								if(player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.SmokeBomb.SmokeBomb" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									damager.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 180, i - 1));
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
