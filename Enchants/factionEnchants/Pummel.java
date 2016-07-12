package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.factionEnchants;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Pummel implements Listener {
	@EventHandler
	private void entityDamagebyEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Pummel").equalsIgnoreCase("true"))) { return;
		} else {
			if(Bukkit.getPluginManager().getPlugin("MassiveCore") == null) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Player damager = (Player) event.getDamager();
							if(!(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().hasItemMeta() && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()
									&& damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE")) {
								int chance = 6;
								Random random = new Random();
								for(int i = 1; i <= 3; i++) {
									chance = chance + 2;
									if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Pummel.Pummel" + i + ".ItemLore")))
											&& random.nextInt(100) <= chance) {
										for(Entity entity : damager.getNearbyEntities(6, 2, 6)) {
											if(entity instanceof Player) {
												Player nearbyplayer = (Player) entity;
												if(FPlayers.getInstance().getByPlayer(damager).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyplayer)) == null
														|| FPlayers.getInstance().getByPlayer(damager).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyplayer)) == Relation.ENEMY) {
													nearbyplayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, i));
												}
											}
										}
									}
								}
								return;
							} else { return; }
						}
					}
				}, 1);
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Player damager = (Player) event.getDamager();
							if(!(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().hasItemMeta() && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()
									&& damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE")) {
								int chance = 6;
								Random random = new Random();
								for(int i = 1; i <= 3; i++) {
									chance = chance + 2;
									if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Pummel.Pummel" + i + ".ItemLore")))
											&& random.nextInt(100) <= chance) {
										for(Entity entity : damager.getNearbyEntities(6, 2, 6)) {
											if(entity instanceof Player) {
												Player nearbyplayer = (Player) entity;
												if(MPlayer.get(damager).getRelationTo(MPlayer.get(nearbyplayer)) == null
														|| MPlayer.get(damager).getRelationTo(MPlayer.get(nearbyplayer)) == Rel.ENEMY) {
													nearbyplayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, i));
												}
											}
										}
									}
								}
								return;
							} else { return; }
						}
					}
				}, 1);
				return;
			}
		}
	}
}
