package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Enchanter;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class enchanterCommand implements CommandExecutor {
	public static Inventory enchanter = Bukkit.createInventory(null, RandomPackage.getEnchanterConfig().getInt("EnchanterGui.Slots"), ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("EnchanterGui.ChestName")));
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		} else {
			String iteM = null;
			ItemStack item = new ItemStack(Material.ACACIA_DOOR);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			Player player = (Player) sender;
			for(int i = 1; i <= 3; i++) {
				lore.clear();
				if(i == 1) { iteM = "SoulTrackers";
				} else if(i == 2) { iteM = "Books";
				} else if(i == 3) { iteM = "Other";
				}
				for(int o = 0; o < RandomPackage.getEnchanterConfig().getStringList("EnchanterGui." + iteM + ".Lore").size(); o++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("EnchanterGui." + iteM + ".Lore").get(o)));
				}
				item = new ItemStack(Material.getMaterial(RandomPackage.getEnchanterConfig().getString("EnchanterGui." + iteM + ".Item").toUpperCase()));
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("EnchanterGui." + iteM + ".Name")));
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				enchanter.setItem(RandomPackage.getEnchanterConfig().getInt("EnchanterGui." + iteM + ".Slot"), item);
			}
			player.openInventory(enchanter);
			return true;
		}
	}
}