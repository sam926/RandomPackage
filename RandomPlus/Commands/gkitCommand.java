package me.randomHashTags.randomPackage.RandomPlus.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomPlus.Events.gkitListener;

public class gkitCommand implements CommandExecutor {
	private static Inventory gkit;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else if(!(RandomPackage.getGkitConfig().getString("Enabled").equalsIgnoreCase("true"))) {
			sender.sendMessage(ChatColor.RED + "gkits are currently disabled");
			return true;
		} else {
			Player player = (Player) sender;
			ArrayList<String> lore = new ArrayList<String>();
			gkit = Bukkit.createInventory(null, RandomPackage.getGkitConfig().getInt("Slots"), ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Name")));
			for(int i = 1; i <= RandomPackage.getGkitConfig().getInt("Slots"); i++) {
				if(!(RandomPackage.getGkitConfig().getString("Kit" + i) == null)) {
					lore.clear();
					ItemStack item = new ItemStack(Material.matchMaterial(RandomPackage.getGkitConfig().getString("Kit" + i + ".Gui.Item").toUpperCase()), RandomPackage.getGkitConfig().getInt("Kit" + i + ".Gui.Amount"), (byte) RandomPackage.getGkitConfig().getInt("Kit" + i + ".Gui.Data"));
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Kit" + i + ".Gui.Name")));
					if(RandomPackage.getGkitConfig().getString("Kit" + i + ".Gui.Enchanted").equalsIgnoreCase("true")) {
						itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
						itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					}
					
					for(int o = 0; o < RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Gui.Lore").size(); o++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Gui.Lore").get(o)));
					}
					if(player.hasPermission("gkit." + i)) {
						lore.add(" ");
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitPermissions.Available")));
					} else {
						lore.add(" ");
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitPermissions.Unavailable")));
					}
					if(!(itemMeta == null)) {
						itemMeta.setLore(lore);
					}
					item.setItemMeta(itemMeta);
					gkit.setItem(RandomPackage.getGkitConfig().getInt("Kit" + i + ".Slot"), item);
				}
			}
			int hasLore = 0;
			player.openInventory(gkit);
			for(int i = 0; i <= 35; i++) {
				if(gkitListener.getKitDelays().contains(player.getName() + i)) {
					ItemStack delayPane = new ItemStack(Material.getMaterial(RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Item").toUpperCase()), RandomPackage.getGkitConfig().getInt("KitDelay.DelayOptions.Amount"), (byte) RandomPackage.getGkitConfig().getInt("KitDelay.DelayOptions.Color"));
					ItemMeta delayPaneMeta = delayPane.getItemMeta();
					lore.clear();
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore1")));
					for(int o = 1; o <= 30; o++) {
						if(RandomPackage.getGkitConfig().getInt("KitDelay.Kit" + Math.addExact(i, 1)) / 60 == o) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", o + " minutes")));
							hasLore = 1;
						} else if(RandomPackage.getGkitConfig().getInt("KitDelay.Kit" + Math.addExact(i, 1)) / 3600 == o) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", o + " hours")));
							hasLore = 1;
						} else if(RandomPackage.getGkitConfig().getInt("KitDelay.Kit" + Math.addExact(i, 1)) / 86400 == o) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", o + " days")));
							hasLore = 1;
						} else if(o == 30 && hasLore == 0) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", "" + RandomPackage.getGkitConfig().getString("KitDelay.Kit" + Math.addExact(i, 1)) + " seconds")));
						}
					}
					delayPaneMeta.setLore(lore);
					delayPaneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.DisplayName")));
					delayPane.setItemMeta(delayPaneMeta);
					player.getOpenInventory().setItem(i, delayPane);
				}
			}
			return true;
		}
	}
	public static Inventory gkits() {
		return gkit;
	}
}