package me.randomHashTags.randomPackage.Commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;


public class newGivedp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		ArrayList<String> lore = new ArrayList<String>();
		ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
		ItemMeta itemMeta = item.getItemMeta();
		String configItem = null, type = null, target = null;
		if(args.length == 0) { return true;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("simplesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Simple";
			} else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("uniquesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Unique";
			} else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("elitesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Elite";
			} else if(args[0].equalsIgnoreCase("4") || args[0].equalsIgnoreCase("ultimatesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Ultimate";
			} else if(args[0].equalsIgnoreCase("5") || args[0].equalsIgnoreCase("legendarysoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Legendary";
			} else if(args[0].equalsIgnoreCase("6") || args[0].equalsIgnoreCase("whitescroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Item").toUpperCase()), 1); configItem = "WhiteScrolls";
			} else if(args[0].equalsIgnoreCase("7") || args[0].equalsIgnoreCase("blackscroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.Item").toUpperCase()), 1); configItem = "BlackScrolls";
			} else if(args[0].equalsIgnoreCase("8") || args[0].equalsIgnoreCase("transmog") || args[0].equalsIgnoreCase("transmogscroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Item").toUpperCase()), 1); configItem = "TransmogScrolls";
			} else if(args[0].equalsIgnoreCase("9") || args[0].equalsIgnoreCase("itemnametag") || args[0].equalsIgnoreCase("nametag")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Item").toUpperCase()), 1); configItem = "ItemNameTags";
			} else if(args[0].equalsIgnoreCase("10") || args[0].equalsIgnoreCase("mms") || args[0].equalsIgnoreCase("mysterymobspawner")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getMysteryMobSpawnerConfig().getString("Item").toUpperCase()), 1); configItem = "MysteryMobSpawner";
			} else if(args[0].equalsIgnoreCase("11") || args[0].equalsIgnoreCase("sb") || args[0].equalsIgnoreCase("soulbook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Soul.Item").toUpperCase()), 1); configItem = "Book"; type = "Soul";
			} else if(args[0].equalsIgnoreCase("12") || args[0].equalsIgnoreCase("legendaryb") || args[0].equalsIgnoreCase("legendarybook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Legendary.Item").toUpperCase()), 1); configItem = "Book"; type = "Legendary";
			} else if(args[0].equalsIgnoreCase("13") || args[0].equalsIgnoreCase("ultimateb") || args[0].equalsIgnoreCase("ultimatebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Ultimate.Item").toUpperCase()), 1); configItem = "Book"; type = "Ultimate";
			} else if(args[0].equalsIgnoreCase("14") || args[0].equalsIgnoreCase("eliteb") || args[0].equalsIgnoreCase("elitebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Elite.Item").toUpperCase()), 1); configItem = "Book"; type = "Elite";
			} else if(args[0].equalsIgnoreCase("15") || args[0].equalsIgnoreCase("uniqueb") || args[0].equalsIgnoreCase("uniquebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Unique.Item").toUpperCase()), 1); configItem = "Book"; type = "Unique";
			} else if(args[0].equalsIgnoreCase("16") || args[0].equalsIgnoreCase("simpleb") || args[0].equalsIgnoreCase("simplebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Simple.Item").toUpperCase()), 1); configItem = "Book"; type = "Simple";
			} else if(args[0].equalsIgnoreCase("17") || args[0].equalsIgnoreCase("sg") || args[0].equalsIgnoreCase("soulgem")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulGem.Item").toUpperCase()), 1); configItem = "SoulGem";
			} else if(args[0].equalsIgnoreCase("18") || args[0].equalsIgnoreCase("simpled") || args[0].equalsIgnoreCase("simpledust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Simple Dust";
			} else if(args[0].equalsIgnoreCase("19") || args[0].equalsIgnoreCase("uniqued") || args[0].equalsIgnoreCase("uniquedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Unique Dust";
			} else if(args[0].equalsIgnoreCase("20") || args[0].equalsIgnoreCase("elited") || args[0].equalsIgnoreCase("elitedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Elite Dust";
			} else if(args[0].equalsIgnoreCase("21") || args[0].equalsIgnoreCase("ultimated") || args[0].equalsIgnoreCase("ultimatedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Ultimate Dust";
			} else if(args[0].equalsIgnoreCase("22") || args[0].equalsIgnoreCase("legendaryd") || args[0].equalsIgnoreCase("legendarydust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Legendary Dust";
			} else if(args[0].equalsIgnoreCase("30") || args[0].equalsIgnoreCase("kingslime")) {
				item = new ItemStack(Material.MONSTER_EGG, 1); configItem = "KingSlime";
			} else { return true; }
			
			
			
		} else if(args.length == 2) {
			if(!(Bukkit.getPlayer(args[0]) == null)
					&& Bukkit.getPlayer(args[0]).isOnline()) {
				target = Bukkit.getPlayer(args[0]).getName();
			}
			
			if(args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("simplesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Simple";
			} else if(args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("uniquesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Unique";
			} else if(args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("elitesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Elite";
			} else if(args[1].equalsIgnoreCase("4") || args[1].equalsIgnoreCase("ultimatesoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Ultimate";
			} else if(args[1].equalsIgnoreCase("5") || args[1].equalsIgnoreCase("legendarysoultracker")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1); configItem = "SoulTracker";  type = "Legendary";
			} else if(args[1].equalsIgnoreCase("6") || args[1].equalsIgnoreCase("whitescroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Item").toUpperCase()), 1); configItem = "WhiteScrolls";
			} else if(args[1].equalsIgnoreCase("7") || args[1].equalsIgnoreCase("blackscroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.Item").toUpperCase()), 1); configItem = "BlackScrolls";
			} else if(args[1].equalsIgnoreCase("8") || args[1].equalsIgnoreCase("transmog") || args[1].equalsIgnoreCase("transmogscroll")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Item").toUpperCase()), 1); configItem = "TransmogScrolls";
			} else if(args[1].equalsIgnoreCase("9") || args[1].equalsIgnoreCase("itemnametag") || args[1].equalsIgnoreCase("nametag")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Item").toUpperCase()), 1); configItem = "ItemNameTags";
			} else if(args[1].equalsIgnoreCase("10") || args[1].equalsIgnoreCase("mms") || args[1].equalsIgnoreCase("mysterymobspawner")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getMysteryMobSpawnerConfig().getString("Item").toUpperCase()), 1); configItem = "MysteryMobSpawner";
			} else if(args[1].equalsIgnoreCase("11") || args[1].equalsIgnoreCase("sb") || args[1].equalsIgnoreCase("soulbook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Soul.Item").toUpperCase()), 1); configItem = "Book"; type = "Soul";
			} else if(args[1].equalsIgnoreCase("12") || args[1].equalsIgnoreCase("legendaryb") || args[1].equalsIgnoreCase("legendarybook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Legendary.Item").toUpperCase()), 1); configItem = "Book"; type = "Legendary";
			} else if(args[1].equalsIgnoreCase("13") || args[1].equalsIgnoreCase("ultimateb") || args[1].equalsIgnoreCase("ultimatebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Ultimate.Item").toUpperCase()), 1); configItem = "Book"; type = "Ultimate";
			} else if(args[1].equalsIgnoreCase("14") || args[1].equalsIgnoreCase("eliteb") || args[1].equalsIgnoreCase("elitebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Elite.Item").toUpperCase()), 1); configItem = "Book"; type = "Elite";
			} else if(args[1].equalsIgnoreCase("15") || args[1].equalsIgnoreCase("uniqueb") || args[1].equalsIgnoreCase("uniquebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Unique.Item").toUpperCase()), 1); configItem = "Book"; type = "Unique";
			} else if(args[1].equalsIgnoreCase("16") || args[1].equalsIgnoreCase("simpleb") || args[1].equalsIgnoreCase("simplebook")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("Simple.Item").toUpperCase()), 1); configItem = "Book"; type = "Simple";
			} else if(args[1].equalsIgnoreCase("17") || args[1].equalsIgnoreCase("sg") || args[1].equalsIgnoreCase("soulgem")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulGem.Item").toUpperCase()), 1); configItem = "SoulGem";
			} else if(args[1].equalsIgnoreCase("18") || args[1].equalsIgnoreCase("simpled") || args[1].equalsIgnoreCase("simpledust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Simple Dust";
			} else if(args[1].equalsIgnoreCase("19") || args[1].equalsIgnoreCase("uniqued") || args[1].equalsIgnoreCase("uniquedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Unique Dust";
			} else if(args[1].equalsIgnoreCase("20") || args[1].equalsIgnoreCase("elited") || args[1].equalsIgnoreCase("elitedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Elite Dust";
			} else if(args[1].equalsIgnoreCase("21") || args[1].equalsIgnoreCase("ultimated") || args[1].equalsIgnoreCase("ultimatedust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Ultimate Dust";
			} else if(args[1].equalsIgnoreCase("22") || args[1].equalsIgnoreCase("legendaryd") || args[1].equalsIgnoreCase("legendarydust")) {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1); configItem = "Legendary Dust";
			} else if(args[1].equalsIgnoreCase("30") || args[0].equalsIgnoreCase("kingslime")) {
				item = new ItemStack(Material.MONSTER_EGG, 1); configItem = "KingSlime";
			} else { return true; }
			
			
			
		} else if(args.length == 3) {
			return true;
			
		}
		
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		if(!(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.RandomizedPercent").equalsIgnoreCase("true"))) { randomNumber = RandomPackage.getGivedpItemsConfig().getInt("BlackScrolls.DefaultPercent");
		} else if(randomNumber < 50) { randomNumber = 50 + randomNumber; }
		
		lore.clear();
		
		if(configItem.startsWith("SoulTracker")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers." + type + ".Name")));
			for(int i = 0; i < RandomPackage.getSoulConfig().getStringList("SoulTrackers." + type + ".Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("SoulTrackers." + type + ".Lore").get(i)));
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SoulTrackers.Obtain" + type)));
		} else if(configItem.equals("Book")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString(type + ".Name")));
			for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList(type + ".Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList(type + ".Lore").get(i)));
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Messages.Obtain" + type)));
		} else if(configItem.equals("SoulGem")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGem.Name").replace("%souls%", "" + 0)));
			for(int i = 0; i < RandomPackage.getSoulConfig().getStringList("SoulGem.Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("SoulGem.Lore").get(i)));
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SoulGem.Obtain")));
		} else if(configItem.equals("WhiteScrolls") || configItem.equals("TransmogScrolls") || configItem.equals("BlackScrolls") || configItem.equals("ItemNameTags")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString(configItem + ".Name")));
			for(int i = 0; i < RandomPackage.getGivedpItemsConfig().getStringList(configItem + ".Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList(configItem + ".Lore").get(i).replace("%percent%", "" + randomNumber)));
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("Messages." + configItem + "Obtain")));
		} else if(configItem.equalsIgnoreCase("MysteryMobSpawner")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Name")));
			for(int i = 0; i < RandomPackage.getMysteryMobSpawnerConfig().getStringList("Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getStringList("Lore").get(i)));
			}
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Obtain")));
		} else if(configItem.endsWith(" Dust")) {
			int percent = random.nextInt(10);
			if(percent == 0) { percent = 1; }
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust." + configItem.replace(" Dust", "") + ".DustName")));
			for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust." + configItem.replace(" Dust", "") + ".DustLore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + configItem.replace(" Dust", "") + ".DustLore").get(i).replace("%percent%", "" + percent)));
			}
			if(args.length == 2) {
				Bukkit.getPlayer(target).sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Messages.Obtain" + configItem.replace(" Dust", "") + "Dust")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Messages.Send" + configItem.replace(" Dust", "") + "Dust").replace("%player%", target)));
			} else if(args.length == 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Messages.Obtain" + configItem.replace(" Dust", "") + "Dust")));
			}
		} else if(configItem.equalsIgnoreCase("KingSlime")) {
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("Bosses.KingSlime.Name")));
			for(int i = 0; i < RandomPackage.getRandomPlusConfig().getStringList("Bosses.KingSlime.Lore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getStringList("Bosses.KingSlime.Lore").get(i)));
			}
		}
		
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		
		if(!(sender instanceof Player)) {
			
		} else {
			Player player = (Player) sender;
			if(args.length == 1) {
				player.getInventory().addItem(item);
				player.updateInventory();
				return true;
			} else if(args.length == 2) {
				if(!(target == null)) {
					Bukkit.getPlayer(target).getInventory().addItem(item);
					Bukkit.getPlayer(target).updateInventory();
					return true;
				} else { sender.sendMessage(ChatColor.RED + "Player " + ChatColor.YELLOW + args[0] + ChatColor.RED + " is offline or doesn't exist"); return true; }
			} else if(args.length == 3) {
				
			}
		}
		
		return true;
	}
}
