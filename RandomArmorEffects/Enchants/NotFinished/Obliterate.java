package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Obliterate implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(damager.getInventory().getItemInMainHand().getType().name().endsWith("AXE"))
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int chance = 0;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 10;
					if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("")))
							&& random.nextInt(100) <= chance) {
						return;
					}
				}
				return;
			}
		}
	}
}
