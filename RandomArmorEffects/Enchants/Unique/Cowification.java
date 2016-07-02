package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Cowification implements Listener {
	
	@EventHandler
	private void playerProjectileEvent(EntityShootBowEvent event) {
		if(!(event.getEntity() instanceof Player) || event.isCancelled()
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.Cowification").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player shooter = (Player) event.getEntity();
			Entity projectile = event.getProjectile();
			if(projectile.isDead()
					|| projectile.isOnGround()
					|| shooter.getLocation().getPitch() < (float) -13.9
					|| shooter.getInventory().getItemInMainHand() == null
					|| !(shooter.getInventory().getItemInMainHand().getType().name().endsWith("BOW"))
					|| !(shooter.getInventory().getItemInMainHand().hasItemMeta())
					|| !(shooter.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int randomChance = 100;
				int randomNumber = random.nextInt(randomChance);
				int chance = 25;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 25;
					if(shooter.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Cowification.Cowification" + i + ".ItemLore")))
							&& randomNumber <= chance) {
						shooter.getWorld().playSound(shooter.getLocation().add(1, 0, 1), Sound.ENTITY_COW_AMBIENT, 1, 1);
						Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomPackage.getPlugin(), new Runnable() {
							public void run() {
								if(projectile.isDead()
										|| projectile.isOnGround()) {
									for(Entity entity : projectile.getNearbyEntities(0.1, 0.1, 0.1)) {
										if(entity.getType() == EntityType.COW) {
											entity.remove();
										}
									}
									return;
								} else {
									event.getProjectile().getWorld().spawnEntity(new Location(projectile.getWorld(), projectile.getLocation().getX(), projectile.getLocation().getY() + 0.5, projectile.getLocation().getZ()), EntityType.COW);
									for(Entity entity : projectile.getNearbyEntities(2.5, 2.5, 2.5)) {
										if(entity.getType() == EntityType.COW
												&& projectile.getLocation().distance(entity.getLocation()) > 0.5) {
											entity.remove();
										}
									}
									for(Entity entity : projectile.getNearbyEntities(-2.5, 2.5, -2.5)) {
										if(entity.getType() == EntityType.COW
												&& projectile.getLocation().distance(entity.getLocation()) > 0.5) {
											entity.remove();
										}
									}
									for(Entity entity : projectile.getNearbyEntities(0, 0.5, 0)) {
										if(entity.getType() == EntityType.COW) {
											entity.teleport(new Location(projectile.getWorld(), projectile.getLocation().getX(), projectile.getLocation().getY() + 0.5, projectile.getLocation().getZ()));
											return;
										}
									}
									return;
								}
							}
						}, 0L, 0L);
						return;
					}
				}
				return;
			}
		}
	}
}
