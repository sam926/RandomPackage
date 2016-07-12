package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class UndeadRuse implements Listener {
	private ArrayList<Player> spawnDelay = new ArrayList<Player>();
	@EventHandler
	private void entityTargetEvent(EntityTargetEvent event) {
		if(event.getTarget() instanceof Player
				&& event.getEntity().getType() == EntityType.ZOMBIE
				&& event.getEntity().getName().contains(event.getTarget().getName())) {
			event.setCancelled(true);
			return;
		}
	}
	private void spawnSpirit(final Player player, EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player damager = (Player) event.getDamager();
			Zombie zombie = player.getWorld().spawn(player.getLocation(), Zombie.class);
			zombie.setCanPickupItems(false);
			zombie.setCollidable(false);
			zombie.setHealth(20);
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0));
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
			
			zombie.setCustomName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("UndeadRuseName").replace("%player%", player.getName())));
			zombie.setTarget(damager);
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					zombie.remove();
					if(spawnDelay.contains(player)) {
						spawnDelay.remove(player);
						return;
					} else {
						return;
					}
				}
			}, 240L);
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.UndeadRuse").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getBoots() == null
					|| !(player.getInventory().getBoots().hasItemMeta())
					|| !(player.getInventory().getBoots().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						Random random = new Random();
						int chance = 3;
						for(int i = 1; i <= 10; i++) {
							chance = chance + 3;
							if(player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.UndeadRuse.UndeadRuse" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance) {
								if(!(spawnDelay.contains(player))) {
									spawnDelay.add(player);
								} else {
									return;
								}
								if(random.nextInt(100) <= 25) {
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									return;
								} else if(random.nextInt(100) <= 50) {
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									return;
								} else {
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									spawnSpirit(player, event);
									return;
								}
							}
						}
						return;
					}
				}, 1);
				return;
			}
		}
	}
}
