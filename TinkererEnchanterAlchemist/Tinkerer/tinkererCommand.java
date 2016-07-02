package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class tinkererCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			Inventory tinkerer = Bukkit.createInventory(player, 54, ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.ChestName")));
			ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			
			String tinkererItems = null;
			int tinkererSlot = 0;
			
			for(int i = 0; i <= 53; i++) {
				if(i == 4 || i == 13 || i == 22 || i == 31 || i == 40 || i == 49) {
					tinkererItems = "Divider"; tinkererSlot = i;
				} else if(i == 0
						|| i == 8) {
					tinkererItems = "AgreePanes"; tinkererSlot = i;
				} else {
					tinkererItems = "Air"; tinkererSlot = i;
				}
				if(tinkererItems == "AgreePanes") {
					lore.clear();
					item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) RandomPackage.getTinkererConfig().getInt("Tinkerer.AgreePanes.Color"));
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.AgreePanes.Name")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.AgreePanes.Lore")));
				} else if(tinkererItems == "Divider") {
					item = new ItemStack(Material.THIN_GLASS, 1);
					itemMeta.setDisplayName(" ");
				} else if(tinkererItems == "Air") { item = new ItemStack(Material.AIR);
				} else { player.sendMessage(ChatColor.RED + "Tell RandomHashTags about this ASAP"); }
				
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				tinkerer.setItem(tinkererSlot, item);
			}
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2);
			player.openInventory(tinkerer);
			return true;
		}
	}
}