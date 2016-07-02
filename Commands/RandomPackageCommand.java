package me.randomHashTags.randomPackage.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class RandomPackageCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "========================================");
			sender.sendMessage(ChatColor.GOLD + "        RandomPackage - " + ChatColor.RED + "Made by " + ChatColor.LIGHT_PURPLE + "Random" + ChatColor.GOLD + ChatColor.MAGIC + "H" + ChatColor.GREEN + "ashTags");
			sender.sendMessage("");
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "========================================");
			return true;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("reload")) {
				Bukkit.getPluginManager().disablePlugin(RandomPackage.getPlugin());
				sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "RandomPackage" + ChatColor.GRAY + "] " + ChatColor.DARK_AQUA + "Plugin successfully reloaded");
				Bukkit.getPluginManager().enablePlugin(RandomPackage.getPlugin());
				return true;
			} else { return true; }
		} else {
			sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "Made by RandomHashTags");
			return true;
		}
	}
}
