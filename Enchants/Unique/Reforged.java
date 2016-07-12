package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Reforged implements Listener {
	@EventHandler
	private void itemDamageEvent(PlayerItemDamageEvent event) {
		Player player = event.getPlayer();
		if(event.isCancelled()
				|| player.getInventory().getItemInMainHand() == null
				|| !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| player.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE")
				|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(player.getInventory().getItemInMainHand().getType().name().endsWith("AXE"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Reforged").equalsIgnoreCase("true"))) {
			return;
		} else {
			Random random = new Random();
			int chance = 30;
			for(int i = 1; i <= 10; i++) {
				chance = chance + 5;
				if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Reforged.Reforged" + i + ".ItemLore")))
						&& random.nextInt(100) <= chance) {
					player.getInventory().getItemInMainHand().setDurability(player.getInventory().getItemInMainHand().getDurability());
					return;
				}
			}
			return;
		}
	}
}