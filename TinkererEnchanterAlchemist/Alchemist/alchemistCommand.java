package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Alchemist;

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

public class alchemistCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			Inventory alchemist = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("ChestName")));
			player.openInventory(alchemist);
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
			ItemMeta itemMeta = item.getItemMeta();
			for(int i = 0; i < alchemist.getSize(); i++) {
				ArrayList<String> lore = new ArrayList<String>();
				lore.clear();
				if(i == 3 || i == 5) { item = new ItemStack(Material.AIR);
				} else if(i == 13) {
					item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Preview.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Preview.Data"));
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Preview.Name")));
					for(int o = 0; o < RandomPackage.getAlchemistConfig().getStringList("Gui.Preview.Lore").size(); o++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Preview.Lore").get(o)));
					}
				} else if(i == 22) {
					item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Exchange.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Exchange.Data"));
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Exchange.Name")));
					for(int o = 0; o < RandomPackage.getAlchemistConfig().getStringList("Gui.Exchange.Lore").size(); o++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Exchange.Lore").get(o)));
					}
				} else {
					item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Other.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Other.Data"));
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Other.Name")));
					lore.clear();
				}
				itemMeta.setLore(lore);
				if(!(item.getType() == Material.AIR)) { item.setItemMeta(itemMeta); }
				player.getOpenInventory().setItem(i, item);
			}
			return true;
		}
	}
}
