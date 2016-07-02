package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Implants implements Listener {
	
	@EventHandler
	private void playerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(event.isCancelled() || player.getInventory().getHelmet() == null || !(player.getInventory().getHelmet().hasItemMeta()) || !(player.getInventory().getHelmet().getItemMeta().hasLore())
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Implants").equalsIgnoreCase("true"))) { return;
		} else {
			Random random = new Random();
			int chance = 12;
			for(int i = 1; i <= 3; i++) {
				chance = chance + 2;
				if(player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Implants.Implants" + i + ".ItemLore")))
						&& random.nextInt(100) <= chance) {
					if(player.getFoodLevel() + 1 > 20) { return;
					} else { player.setFoodLevel(player.getFoodLevel() + 1); return; }
				}
			}
			return;
		}
	}
}