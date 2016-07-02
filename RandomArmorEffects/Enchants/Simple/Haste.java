package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Haste implements Listener {
	
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(event.isCancelled()
				|| player.getInventory().getItemInMainHand() == null || !(player.getInventory().getItemInMainHand().hasItemMeta())
				|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
				&& !(player.getInventory().getItemInMainHand().getType().name().endsWith("AXE"))
				&& !(player.getInventory().getItemInMainHand().getType().name().endsWith("SPADE"))
				&& !(player.getInventory().getItemInMainHand().getType().name().endsWith("HOE"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Haste").equalsIgnoreCase("true"))) {
			return;
		} else {
			int duration = 160;
			for(int i = 1; i <= 3; i++) {
				duration = duration - 20;
				if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Haste.Haste" + i + ".ItemLore")))) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, duration, i));
				}
			}
			return;
		}
	}
}