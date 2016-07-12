package me.randomHashTags.randomPackage.RandomArmorEffects.Commands.bookGui;

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

public class BookGui implements CommandExecutor {
	public static String bookGuiTitle = ChatColor.BLACK + "" + ChatColor.BOLD + "Random Book Gui";
	private Inventory BookGui = Bukkit.createInventory(null, 9, bookGuiTitle);
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			
			int slot = 0;
			ItemStack book = new ItemStack(Material.BOOK);
			ItemMeta bookMeta = book.getItemMeta();
			ArrayList<String> bookLore = new ArrayList<String>();
			
			for(int i = 1; i <= 5; i++) {
				bookLore.clear();
				if(i == 1) {
					bookMeta.setDisplayName(ChatColor.WHITE + "Simple Enchants");
					bookLore.add(ChatColor.GRAY + "See all the Simple Custom Enchants");
					slot = 2;
				} else if(i == 2) {
					bookMeta.setDisplayName(ChatColor.GREEN + "Unique Enchants");
					bookLore.add(ChatColor.GRAY + "See all the Unique Custom Enchants");
					slot = 3;
				} else if(i == 3) {
					bookMeta.setDisplayName(ChatColor.AQUA + "Elite Enchants");
					bookLore.add(ChatColor.GRAY + "See all the Elite Custom Enchants");
					slot = 4;
				} else if(i == 4) {
					bookMeta.setDisplayName(ChatColor.YELLOW + "Ultimate Enchants");
					bookLore.add(ChatColor.GRAY + "See all the Ultimate Enchants");
					slot = 5;
				} else {
					bookMeta.setDisplayName(ChatColor.GOLD + "Legendary Enchants");
					bookLore.add(ChatColor.GRAY + "See all the Legendary Enchants");
					slot = 6;
				}
				bookMeta.setLore(bookLore);
				book.setItemMeta(bookMeta);
				
				BookGui.setItem(slot, book);
			}
			player.openInventory(BookGui);
			return true;
		}
	}
}
