package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Inquisitive implements Listener {
	
	@EventHandler
	private void entityDeathEntity(EntityDeathEvent event) {
		if(event.getEntity().getKiller() instanceof Player) {
			Player damager = (Player) event.getEntity().getKiller();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Inquisitive").equalsIgnoreCase("true"))) {
				return;
			} else {
				int inquisLevel = 1;
				for(int i = 1; i <= 4; i++) {
					inquisLevel = inquisLevel + 1;
					if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Inquisitive.Inquisitive" + i + ".ItemLore")))) {
						event.setDroppedExp(event.getDroppedExp() * inquisLevel);
						return;
					}
				}
				return;
			}
		} else {
			return;
		}
	}
}