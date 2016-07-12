package me.randomHashTags.randomPackage.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class addlore implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			if(args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("addlore.Messages.Usage")));
				return true;
			} else {
				if(player.getInventory().getItemInMainHand() == null
						|| player.getInventory().getItemInMainHand().getType() == Material.AIR) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("addlore.Messages.ItemInMainHandAir")));
					return true;
				} else {
					String arguments = null;
					ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
					ItemMeta itemInMainHandMeta = itemInMainHand.getItemMeta();
					if(args.length == 1) {
						arguments = args[0];
					} else if(args.length == 2) {
						arguments = args[0] + " " + args[1];
					} else if(args.length == 3) {
						arguments = args[0] + " " + args[1] + " " + args[2];
					} else if(args.length == 4) {
						arguments = args[0] + " " + args[1] + " " + args[2] + " " + args[3];
					} else if(args.length == 5) {
						arguments = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4];
					} else if(args.length == 6) {
						arguments = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5];
					} else if(args.length == 7) {
						arguments = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6];
					} else if(args.length == 8) {
						arguments = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7];
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("addlore.Messages.TooManyArguments")));
						return true;
					}
					if(player.getInventory().getItemInMainHand().hasItemMeta()
							&& player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
						List<String> itemInMainHandLore = itemInMainHandMeta.getLore();
						itemInMainHandLore.add(ChatColor.translateAlternateColorCodes('&', arguments));
						itemInMainHandMeta.setLore(itemInMainHandLore);
						itemInMainHand.setItemMeta(itemInMainHandMeta);
						player.getInventory().setItemInMainHand(itemInMainHand);
					} else {
						ArrayList<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', arguments));
						itemInMainHandMeta.setLore(lore);
						itemInMainHand.setItemMeta(itemInMainHandMeta);
						player.getInventory().setItemInMainHand(itemInMainHand);
					}
					player.updateInventory();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("addlore.Messages.Success").replace("%lore%", arguments)));
					return true;
				}
			}
		}
	}
}
