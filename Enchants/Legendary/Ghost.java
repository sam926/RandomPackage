package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Ghost implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Ghost").equalsIgnoreCase("true"))) {
			return true;
		} else {
			Player player = (Player) sender;
			ArrayList<String> nearbyPlayers = new ArrayList<String>();
			for(Entity entity : player.getNearbyEntities(RandomPackage.getPlaceholderConfig().getInt("Near.MaxDistance"), RandomPackage.getPlaceholderConfig().getInt("Near.MaxDistance"), RandomPackage.getPlaceholderConfig().getInt("Near.MaxDistance"))) {
				if(entity instanceof Player) {
					Player nearbyPlayer = (Player) entity;
					nearbyPlayers.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("Near.PlayersNameColor")) + nearbyPlayer.getName() + ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("Near.Distance").replace("%distance%", "" + (int) nearbyPlayer.getLocation().distance(player.getLocation()))));
					for(int i = 1; i <= 3; i++) {
						if(!(nearbyPlayer.getInventory().getBoots() == null) && nearbyPlayer.getInventory().getBoots().hasItemMeta() && nearbyPlayer.getInventory().getBoots().getItemMeta().hasLore() && nearbyPlayer.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Ghost.Ghost" + i + ".ItemLore")))
								&& nearbyPlayer.getLocation().distance(player.getLocation()) <= i * 50) {
							nearbyPlayers.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("Near.PlayersNameColor")) + nearbyPlayer.getName() + ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("Near.Distance").replace("%distance%", "" + (int) nearbyPlayer.getLocation().distance(player.getLocation()))));
						}
					}
				}
			}
			if(nearbyPlayers.isEmpty()) {
				player.sendMessage(ChatColor.GOLD + "Players nearby: " + nearbyPlayers.toString().replace("[", "").replace("]", "") + ChatColor.WHITE + "none");
			} else {
				player.sendMessage(ChatColor.GOLD + "Players nearby: " + nearbyPlayers.toString().replace("[", "").replace("]", ""));
			}
			nearbyPlayers.clear();
			return true;
		}
	}
}
