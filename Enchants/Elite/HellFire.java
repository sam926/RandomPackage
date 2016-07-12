package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class HellFire implements Listener {
	@EventHandler
	private void playerShootEvent(EntityShootBowEvent event) {
		if(!(event.getEntity() instanceof Player)
				|| event.isCancelled()
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Hellfire").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getItemInMainHand() == null
					|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("BOW"))
					|| !(player.getInventory().getItemInMainHand().hasItemMeta())
					|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int chance = 30;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 10;
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Hellfire.Hellfire" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						event.getProjectile().setFireTicks(300);
						return;
					}
				}
				return;
			}
		}
	}
}
