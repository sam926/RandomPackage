package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class CreeperArmor implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.getDamager().getType().equals(EntityType.PRIMED_TNT)
				&& RandomPackage.getEnabledEnchantsConfig().getString("Legendary.CreeperArmor").equalsIgnoreCase("true") && event.getEntity() instanceof Player
				|| event.getDamager().getType().equals(EntityType.CREEPER)
				&& RandomPackage.getEnabledEnchantsConfig().getString("Legendary.CreeperArmor").equalsIgnoreCase("true") && event.getEntity() instanceof Player) {
			if(event.isCancelled()) { return; }
			Player victim = (Player) event.getEntity();
			for(int i = 1; i <= 3; i++) {
				if(!(victim.getInventory().getHelmet() == null)
						&& victim.getInventory().getHelmet().hasItemMeta()
						&& victim.getInventory().getHelmet().getItemMeta().hasLore()
						&& victim.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.CreeperArmor.CreeperArmor" + i + ".ItemLore")))
						|| !(victim.getInventory().getChestplate() == null)
						&& victim.getInventory().getChestplate().hasItemMeta()
						&& victim.getInventory().getChestplate().getItemMeta().hasLore()
						&& victim.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.CreeperArmor.CreeperArmor" + i + ".ItemLore")))
						|| !(victim.getInventory().getLeggings() == null)
						&& victim.getInventory().getLeggings().hasItemMeta()
						&& victim.getInventory().getLeggings().getItemMeta().hasLore()
						&& victim.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.CreeperArmor.CreeperArmor" + i + ".ItemLore")))
						|| !(victim.getInventory().getBoots() == null)
						&& victim.getInventory().getBoots().hasItemMeta()
						&& victim.getInventory().getBoots().getItemMeta().hasLore()
						&& victim.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.CreeperArmor.CreeperArmor" + i + ".ItemLore")))) {
					event.setDamage(event.getDamage() / i + 2);
					event.setCancelled(true);
					return;
				}
			}
			return;
		}
	}
}