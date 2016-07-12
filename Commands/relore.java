package me.randomHashTags.randomPackage.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class relore implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			String arguments = null;
			if(args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("relore.Messages.Usage")));
				return true;
			} else {
				if(player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("relore.Messages.ItemIsAir")));
					return true;
				} else {
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
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("relore.Messages.TooManyArguments")));
						return true;
					}
					ArrayList<String> lore = new ArrayList<String>();
					ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
					ItemMeta itemInMainHandMeta = itemInMainHand.getItemMeta();
					lore.add(ChatColor.translateAlternateColorCodes('&', arguments));
					itemInMainHandMeta.setLore(lore);
					itemInMainHand.setItemMeta(itemInMainHandMeta);
					player.getInventory().setItemInMainHand(itemInMainHand);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("relore.Messages.Relore").replace("%lore%", arguments)));
					player.updateInventory();
					return true;
				}
			}
		}
	}
}
