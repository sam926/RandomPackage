package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class ObsidianDestroyer implements Listener {
	
	@EventHandler
	private void blockEvent(BlockDamageEvent event) {
		if(event.isCancelled()
				|| !(event.getBlock().getType().equals(Material.OBSIDIAN))
				|| event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.ObsidianDestroyer").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = event.getPlayer();
			for(int i = 1; i <= 5; i++) {
				if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.ObsidianDestroyer.ObsidianDestroyer" + i + ".ItemLore")))) {
					if(event.getPlayer().hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
						player.removePotionEffect(PotionEffectType.FAST_DIGGING);
						player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, i * 20, i - 1));
						return;
					} else {
						player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, i * 20, i - 1));
						return;
					}
				}
			}
			return;
		}
	}
}