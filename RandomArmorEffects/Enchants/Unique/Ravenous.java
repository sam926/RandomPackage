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

public class Ravenous implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Ravenous").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getDamager();
			if(player.getInventory().getItemInMainHand() == null || !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE")
					|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(player.getInventory().getItemInMainHand().getType().name().endsWith("AXE"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 12;
							for(int i = 1; i <= 4; i++) {
								chance = chance + 2;
								if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Ravenous.Ravenous" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 4));
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