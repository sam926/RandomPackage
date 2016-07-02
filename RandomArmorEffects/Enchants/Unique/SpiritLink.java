package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class SpiritLink implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.SpiritLink").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						for(int i = 1; i <= 5; i++) {
							if(!(player.getInventory().getHelmet() == null) && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().hasLore()
									&& player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SpiritLink.SpiritLink" + i + ".ItemLore")))
									|| !(player.getInventory().getChestplate() == null) && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
									&& player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SpiritLink.SpiritLink" + i + ".ItemLore")))
									|| !(player.getInventory().getLeggings() == null) && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().hasLore()
									&& player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SpiritLink.SpiritLink" + i + ".ItemLore")))
									|| !(player.getInventory().getBoots() == null) && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore()
									&& player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SpiritLink.SpiritLink" + i + ".ItemLore")))) {
								for(int o = 0; o < player.getNearbyEntities(5, 2, 5).size(); o++) {
									if(!(player.getNearbyEntities(5, 2, 5).get(o) instanceof Player)) { return;
									} else {
										Player nearbyplayer = (Player) player.getNearbyEntities(5, 2, 5).get(o);
										if(FPlayers.getInstance().getByPlayer(player).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyplayer)) == Relation.ALLY) {
											if(nearbyplayer.getHealth() + event.getDamage() / 4 <= nearbyplayer.getMaxHealth()) {
												nearbyplayer.setHealth(nearbyplayer.getHealth() + event.getDamage() / 4);
											} else {
												nearbyplayer.setHealth(nearbyplayer.getMaxHealth());
											}
										}
									}
								}
								return;
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
