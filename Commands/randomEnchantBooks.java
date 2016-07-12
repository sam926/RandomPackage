package me.randomHashTags.randomPackage.RandomArmorEffects.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class randomEnchantBooks implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			if(player.hasPermission("random.enchantbooks")) {
				ArrayList<String> lore = new ArrayList<String>();
				String bookType = null;
				ItemStack book = new ItemStack(Material.BOOK, 1);
				ItemMeta bookMeta = book.getItemMeta();
				
				for(int i = 1; i <= 5; i++) {
					if(i == 1) { bookType = "Legendary";
					} else if(i == 2) { bookType = "Ultimate";
					} else if(i == 3) { bookType = "Elite";
					} else if(i == 4) { bookType = "Unique";
					} else if(i == 5) { bookType = "Simple";
					}
					lore.clear();
					for(int o = 0; o < RandomPackage.getBookOptionsConfig().getStringList(bookType + ".Lore").size(); o++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList(bookType + ".Lore").get(o)));
					}
					bookMeta.setLore(lore);
					bookMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString(bookType + ".Name")));
					book.setItemMeta(bookMeta);
					player.getInventory().addItem(book);
					player.updateInventory();
				}
				player.sendMessage(ChatColor.GREEN + "You obtained the Custom Books!");
				player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_BLAST, 1, 1);
				return true;
			} else {
				return true;
			}
		}
	}
} 