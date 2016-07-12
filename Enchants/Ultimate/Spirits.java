package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Spirits implements Listener {
	private ArrayList<Player> spawnDelay = new ArrayList<Player>();
	@EventHandler
	private void entityTargetEvent(EntityTargetEvent event) {
		if(event.getTarget() instanceof Player
				&& event.getEntity().getType() == EntityType.BLAZE
				&& event.getEntity().getName().contains(event.getTarget().getName())) {
			event.setCancelled(true);
			return;
		}
	}
	private void spawnSpirit(final Player player, EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof LivingEntity) {
			LivingEntity damager = (LivingEntity) event.getDamager();
			Blaze spirit = player.getWorld().spawn(player.getLocation(), Blaze.class);
			spirit.setCanPickupItems(false);
			spirit.setCollidable(false);
			spirit.setHealth(20);
			
			Random random = new Random();
			int randomChance = 100;
			int randomNumber = random.nextInt(randomChance);
			
			if(randomNumber <= 5) {
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));
			}
			if(randomNumber <= 10) {
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 99999, 1));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 0));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 1));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 1));
			} else if(randomNumber <= 50) {
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 0));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 99999, 0));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0));
			} else {
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
				spirit.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 0));
			}
			
			spirit.setCustomName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("SpiritsName").replace("%player%", player.getName())));
			spirit.setTarget(damager);
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					spirit.remove();
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
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Spirits").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getHelmet() == null
					|| !(player.getInventory().getHelmet().hasItemMeta())
					|| !(player.getInventory().getHelmet().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 3;
							int currentLevel = 0;
							for(int i = 1; i <= 10; i++) {
								currentLevel = currentLevel + 1;
								chance = chance + 1;
								if(player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Spirits.Spirits" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									if(!(spawnDelay.contains(player))) {
										spawnDelay.add(player);
									} else {
										return;
									}
									if(i == 3
											|| i == 4) {
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										return;
									} else if(i == 5
											|| i == 6) {
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										return;
									} else if(i == 7
											|| i == 8) {
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										return;
									} else if(i == 9
											|| i == 10) {
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										spawnSpirit(player, event);
										return;
									} else {
										spawnSpirit(player, event);
										return;
									}
								}
							}
							return;
						}
					}
				}, 1);
				return;
			}
		}
	}
}
