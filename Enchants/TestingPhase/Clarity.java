package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TestingPhase;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Clarity implements Listener {
	@EventHandler
	private void playerMoveEvent(PlayerMoveEvent event) {
		if(event.isCancelled()) {
			return;
		} else {
			if(!(event.getPlayer().getInventory().getHelmet() == null)
					&& event.getPlayer().getInventory().getHelmet().hasItemMeta() && event.getPlayer().getInventory().getHelmet().getItemMeta().hasLore()) {
				for(int i = 1; i <= 3; i++) {
					if(event.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Clarity.Clarity" + i + ".ItemLore")))) {
						
					}
				}
				return;
			} else { return; }
		}
	}
}
