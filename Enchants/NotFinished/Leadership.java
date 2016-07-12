package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Leadership implements Listener {
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomPackage.getPlugin(), new Runnable() {
			public void run() {
				for(Player player : Bukkit.getServer().getOnlinePlayers()) {
					if(!(player.getInventory().getChestplate() == null) && player.getInventory().getChestplate().hasItemMeta()
							&& player.getInventory().getChestplate().getItemMeta().hasLore()) {
						for(int i = 1; i <= 5; i++) {
							if(player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Commander.Commander" + i + ".ItemLore")))) {
								player.getWorld().playEffect(new Location(player.getWorld(), player.getEyeLocation().getX(), player.getEyeLocation().getY() + 1, player.getEyeLocation().getZ()), Effect.STEP_SOUND, Material.DIAMOND_BLOCK);
								for(int o = 0; o < player.getNearbyEntities(4, 2, 4).size(); o++) {
									if(player.getNearbyEntities(4, 2, 4).get(o) instanceof Player) {
										FPlayer nearbyplayer = FPlayers.getInstance().getByPlayer((Player) player.getNearbyEntities(4, 2, 4).get(o));
										FPlayer nearbyPlayer = FPlayers.getInstance().getByPlayer((Player) player.getNearbyEntities(4, 2, 4).get(o));
										if(nearbyplayer instanceof Player && nearbyPlayer.getRelationTo(FPlayers.getInstance().getByPlayer(player)) == Relation.ALLY) {
											//Bukkit.getPlayer(nearbyplayer.getName()).removePotionEffect(PotionEffectType.FAST_DIGGING);
											//Bukkit.getPlayer(nearbyplayer.getName()).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,  i * 20 + 40, 0));
										}
									}
								}
							}
						}
					}
				}
				return;
			}
		}, 200, 200);
		return;
	}
}
