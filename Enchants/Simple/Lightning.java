package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Lightning implements Listener {
	@EventHandler
	private void mainHand(ProjectileHitEvent event) {
		if(!(event.getEntity().getShooter() instanceof Player)) {
			return;
		} else {
			Player player = (Player) event.getEntity().getShooter();
			if(player.getInventory().getItemInMainHand() == null
					|| !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("BOW"))
					|| !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Lightning").equalsIgnoreCase("true"))) {
				return;
			} else {
				Random random = new Random();
				int chance = 10;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 2;
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Lightning.Lightning" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						event.getEntity().getLocation().getWorld().strikeLightning(new Location(event.getEntity().getWorld(), event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ()));
						return;
					}
				}
				return;
			}
		}
	}
	@EventHandler
	private void offHand(ProjectileHitEvent event) {
		if(!(event.getEntity().getShooter() instanceof Player)) {
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
				int chance = 10;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 2;
					if(player.getInventory().getItemInOffHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Lightning.Lightning" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						event.getEntity().getLocation().getWorld().strikeLightning(new Location(event.getEntity().getWorld(), event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ()));
						return;
					}
				}
				return;
			}
		}
	}
}