package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Explosive implements Listener {
	@EventHandler
	private void explosiveInMainHand(ProjectileHitEvent event) {
		if(!(event.getEntity().getShooter() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Explosive").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity().getShooter();
			if(player.getInventory().getItemInMainHand() == null
					|| !(player.getInventory().getItemInMainHand().hasItemMeta())
					|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("BOW"))) {
				return;
			} else {
				Random random = new Random();
				int randomChance = 100;
				int randomNumber = random.nextInt(randomChance);
				int chance = 15;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 15;
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Explosive.Explosive" + i + ".ItemLore")))
							&& randomNumber <= chance) {
						player.getWorld().createExplosion(event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1F, false, false);
						return;
					}
				}
				return;
			}
		}
	}
	@EventHandler
	private void explosiveInOffHand(ProjectileHitEvent event) {
		if(!(event.getEntity().getShooter() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Explosive").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity().getShooter();
			if(player.getInventory().getItemInOffHand() == null
					|| !(player.getInventory().getItemInOffHand().hasItemMeta())
					|| !(player.getInventory().getItemInOffHand().getItemMeta().hasLore())
					|| !(player.getInventory().getItemInOffHand().getType().name().endsWith("BOW"))) {
				return;
			} else {
				Random random = new Random();
				int randomChance = 100;
				int randomNumber = random.nextInt(randomChance);
				int chance = 15;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 15;
					if(player.getInventory().getItemInOffHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Explosive.Explosive" + i + ".ItemLore")))
							&& randomNumber <= chance) {
						player.getWorld().createExplosion(event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1F, false, false);
						return;
					}
				}
				return;
			}
		}
	}
}