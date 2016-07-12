package me.randomHashTags.randomPackage.RandomArmorEffects.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class levelcap implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command");
			return true;
		} else {
			Player player = (Player) sender;
			int levelcap = 0;
			if(player.isOp()) { levelcap = RandomPackage.getPlugin().getConfig().getInt("EnchantmentOptions.OpEnchantCap");
			} else { levelcap = RandomPackage.getPlugin().getConfig().getInt("EnchantmentOptions.DefaultEnchantCap"); }
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("EnchantmentOptions.Message").replace("%levelcap%", "" + levelcap)));
			return true;
		}
	}
}
