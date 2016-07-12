package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Teleportation implements Listener {
	private int enchant = 0;
	private Player player = null;
	private Vector direction = null;
	@EventHandler
	private void entityShootBowEvent(EntityShootBowEvent event) {
		if(event.isCancelled()
				|| !(event.getEntity() instanceof Player)) {
			enchant = 0;
			return;
		} else {
			Random random = new Random();
			int randomChance = 100;
			int randomNumber = random.nextInt(randomChance);
			
			Player player = (Player) event.getEntity();
			if(!(player.getInventory().getItemInMainHand() == null)
					&& player.getInventory().getItemInMainHand().getType().name().endsWith("BOW")
					&& player.getInventory().getItemInMainHand().hasItemMeta()
					&& player.getInventory().getItemInMainHand().getItemMeta().hasLore()
					&& !(event.isCancelled())) {
				int chance = 30;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 10;
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Teleportation.Teleportation" + i + ".ItemLore")))
							&& randomNumber <= chance) {
						this.player = player;
						direction = player.getLocation().getDirection();
						enchant = 1;
						return;
					}
				}
				return;
			} else {
				enchant = 0;
				return;
			}
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getDamager() instanceof Arrow)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Teleportation").equalsIgnoreCase("true"))) {
			enchant = 0;
			direction = null;
			player = null;
			return;
		} else {
			if(enchant == 1
					&& !(event.isCancelled())) {
				this.player.teleport(new Location(event.getEntity().getWorld(), event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), this.player.getLocation().getYaw(), this.player.getLocation().getPitch()));
				enchant = 0;
				return;
			} else {
				enchant = 0;
				return;
			}
		}
	}
}