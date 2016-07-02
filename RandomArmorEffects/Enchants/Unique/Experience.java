package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Experience implements Listener {
	@EventHandler
	private void blockBreakEvent(BlockBreakEvent event) {
		if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Experience").equalsIgnoreCase("true"))) { return;
		} else {
			Random random = new Random();
			int chance = 0;
			for(int i = 1; i <= 5; i++) {
				if(event.isCancelled()) { return; }
				int randomNumber = random.nextInt(i + 1);
				if(randomNumber == 0) { randomNumber = 1; }
				chance = chance + 15;
				if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Experience.Experience" + i + ".ItemLore")))
						&& randomNumber <= chance) {
					event.setExpToDrop(event.getExpToDrop() * randomNumber);
					return;
				}
			}
			return;
		}
	}
}
