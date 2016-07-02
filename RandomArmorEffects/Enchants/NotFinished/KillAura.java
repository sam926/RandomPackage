package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class KillAura implements Listener {
	@EventHandler
	private void entityDeathEvent(EntityDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)) {
			return;
		} else {
			Player killer = (Player) event.getEntity().getKiller();
			if(!(killer.getInventory().getItemInMainHand() == null)
					&& killer.getInventory().getItemInMainHand().hasItemMeta()
					&& killer.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				int chance = 35;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 5;
					if(killer.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
							&& killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.KillAura.KillAura" + i + ".ItemLore")))
							|| killer.getInventory().getItemInMainHand().getType().name().endsWith("AXE")
							&& !(killer.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
							&& killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.KillAura.KillAura" + i + ".ItemLore")))) {
						Random random = new Random();
						int randomChance = 100;
						int randomNumber = random.nextInt(randomChance);
						int randomKilled = random.nextInt(randomChance);
						int amountKilled = 0;
						if(randomNumber <= chance) {
							String nearbyEntities = event.getEntity().getNearbyEntities(2, 2, 2).toString().replace("CraftBlaze", "BLAZE");
							if(nearbyEntities.contains("" + event.getEntity().getType())) {
								for(Entity entity : event.getEntity().getNearbyEntities(2, 2, 2)) {
									if(!(entity instanceof Player)
											&& !(entity.getType() == EntityType.AREA_EFFECT_CLOUD)
											&& !(entity.getType() == EntityType.ARMOR_STAND)
											&& !(entity.getType() == EntityType.ARROW)
											&& !(entity.getType() == EntityType.BOAT)
											&& !(entity.getType() == EntityType.COMPLEX_PART)
											&& !(entity.getType() == EntityType.DRAGON_FIREBALL)
											&& !(entity.getType() == EntityType.DROPPED_ITEM)
											&& !(entity.getType() == EntityType.EGG)
											&& !(entity.getType() == EntityType.ENDER_CRYSTAL)
											&& !(entity.getType() == EntityType.ENDER_DRAGON)
											&& !(entity.getType() == EntityType.ENDER_PEARL)
											&& !(entity.getType() == EntityType.ENDER_SIGNAL)
											&& !(entity.getType() == EntityType.EXPERIENCE_ORB)
											&& !(entity.getType() == EntityType.FALLING_BLOCK)
											&& !(entity.getType() == EntityType.FIREBALL)
											&& !(entity.getType() == EntityType.FIREWORK)
											&& !(entity.getType() == EntityType.FISHING_HOOK)
											&& !(entity.getType() == EntityType.ITEM_FRAME)
											&& !(entity.getType() == EntityType.LEASH_HITCH)
											&& !(entity.getType() == EntityType.LIGHTNING)
											&& !(entity.getType() == EntityType.LINGERING_POTION)
											&& !(entity.getType().name().startsWith("MINECART"))
											&& !(entity.getType() == EntityType.PAINTING)
											&& !(entity.getType() == EntityType.PRIMED_TNT)
											&& !(entity.getType() == EntityType.SHULKER_BULLET)
											&& !(entity.getType() == EntityType.SMALL_FIREBALL)
											&& !(entity.getType() == EntityType.SNOWBALL)
											&& !(entity.getType() == EntityType.SPECTRAL_ARROW)
											&& !(entity.getType() == EntityType.SPLASH_POTION)
											&& !(entity.getType() == EntityType.THROWN_EXP_BOTTLE)
											&& !(entity.getType() == EntityType.TIPPED_ARROW)
											&& !(entity.getType() == EntityType.UNKNOWN)
											&& !(entity.getType() == EntityType.WEATHER)
											&& !(entity.getType() == EntityType.WITHER_SKULL)) {
										if(randomKilled <= 15) {
											amountKilled = 3;
										} else if(randomKilled <= 35) {
											amountKilled = 2;
										} else {
											return;
										}
										final int killed = amountKilled;
										event.getEntity().getKiller().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("KillAuraMessage").replace("%amount%", "" + amountKilled)));
										Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
											public void run() {
												for(int o = 1; o <= killed; o++) {
													((Damageable) entity).damage(20);
												}
											}
										}, 5);
										return;
									}
								}
								return;
							} else {
								return;
							}
						} else {
							return;
						}
					}
				}
			} else {
				return;
			}
		}
	}
}