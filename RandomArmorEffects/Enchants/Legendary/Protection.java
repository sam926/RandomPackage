package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Protection implements Listener {
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		if(!(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Protection").equalsIgnoreCase("true"))) { return;
		} else {
			Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						if(!(player.getInventory().getHelmet() == null) && player.getInventory().getHelmet().hasItemMeta()
								&& player.getInventory().getHelmet().getItemMeta().hasLore()) {
							for(int i = 1; i <= 5; i++) {
								if(player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Protection.Protection" + i + ".ItemLore")))) {
									for(int o = 0; o < player.getNearbyEntities(5, 2, 5).size(); o++) {
										if(player.getNearbyEntities(5, 2, 5).get(o) instanceof Player) {
											Player nearbyPlayer = (Player) player.getNearbyEntities(5, 2, 5).get(o);
											if(FPlayers.getInstance().getByPlayer(nearbyPlayer).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyPlayer)) == Relation.ALLY) {
												nearbyPlayer.removePotionEffect(PotionEffectType.ABSORPTION);
												nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, i * 20 + 100, i - 1));
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
}
