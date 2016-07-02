package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Soul;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class NaturesWrath implements Listener {
	private ArrayList<String> naturesWrath = new ArrayList<String>();
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(RandomPackage.getEnabledEnchantsConfig().getString("Soul.NaturesWrath").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Random random = new Random();
						int chance = 0;
						for(int i = 1; i <= 4; i++) {
							chance = chance + 2;
							if(random.nextInt(100) <= chance) {
								if(!(player.getInventory().getHelmet() == null) && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().hasLore()
										&& player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.NaturesWrath.NaturesWrath" + i + ".ItemLore")))
										|| !(player.getInventory().getChestplate() == null) && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
										&& player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.NaturesWrath.NaturesWrath" + i + ".ItemLore")))
										|| !(player.getInventory().getLeggings() == null) && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().hasLore()
										&& player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.NaturesWrath.NaturesWrath" + i + ".ItemLore")))
										|| !(player.getInventory().getBoots() == null) && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore()
										&& player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.NaturesWrath.NaturesWrath" + i + ".ItemLore")))) {
									for(Entity playeR : player.getNearbyEntities(50, 50, 50)) {
										if(playeR instanceof Player) {
											Player playER = (Player) playeR;
											if(FPlayers.getInstance().getByPlayer(playER).getRelationTo(FPlayers.getInstance().getByPlayer(player)) == null
													|| FPlayers.getInstance().getByPlayer(playER).getRelationTo(FPlayers.getInstance().getByPlayer(player)) == Relation.ENEMY) {
												for(int o = 1; o <= 10; o++) {
													Bukkit.getPlayer(playER.getName()).getWorld().strikeLightning(playER.getLocation());
													naturesWrath.add(playER.getName());
													Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
														public void run() {
															naturesWrath.remove(playER.getName());
															return;
														}
													}, 160);
												}
											}
										}
									}
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
	@EventHandler
	private void playerMoveEvent(PlayerMoveEvent event) {
		if(naturesWrath.contains(event.getPlayer().getName())) {
			double x = event.getPlayer().getLocation().getX();
			double y = event.getPlayer().getLocation().getY();
			double z = event.getPlayer().getLocation().getZ();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(!(event.getPlayer().getLocation().getX() == x)
							|| !(event.getPlayer().getLocation().getY() == y)
							|| !(event.getPlayer().getLocation().getZ() == z)) {
						event.setCancelled(true);
						return;
					} else { return; }
				}
			}, 1);
			return;
		} else { return; }
	}
 }
