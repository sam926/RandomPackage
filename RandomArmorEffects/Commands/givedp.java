package me.randomHashTags.randomPackage.RandomArmorEffects.Commands;

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

public class givedp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			int amount = 1;
			String type = null;
			if(args.length == 0) {
				sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "/givedp <player> <item< <amount>");
				return true;
			} else if(args.length == 1) {
				sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "You need to specify who to give the item to");
				return true;
			} else if(args.length == 2) {
				return true;
			} else if(args.length == 3) {
				for(int i = 1; i <= 64; i++) {
					if(args[2].equalsIgnoreCase("" + i)) {
						amount = i;
					}
				}
				
				if(!(amount == 0)) {
					if(args[1].equalsIgnoreCase("1")
							|| args[1].equalsIgnoreCase("simplesoultracker")
							|| args[1].equalsIgnoreCase("simplest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Simple.";
					} else if(args[1].equalsIgnoreCase("2")
							|| args[1].equalsIgnoreCase("uniquesoultracker")
							|| args[1].equalsIgnoreCase("uniquest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Unique.";
					} else if(args[1].equalsIgnoreCase("3")
							|| args[1].equalsIgnoreCase("elitesoultracker")
							|| args[1].equalsIgnoreCase("elitest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Elite.";
					} else if(args[1].equalsIgnoreCase("4")
							|| args[1].equalsIgnoreCase("ultimatesoultracker")
							|| args[1].equalsIgnoreCase("ultimatest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Ultimate.";
					} else if(args[1].equalsIgnoreCase("5")
							|| args[1].equalsIgnoreCase("legendarysoultracker")
							|| args[1].equalsIgnoreCase("legendaryst")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Legendary.";
					} else if(args[1].equalsIgnoreCase("6")
							|| args[1].equalsIgnoreCase("simplebook")
							|| args[1].equalsIgnoreCase("simpleb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Simple.";
					} else if(args[1].equalsIgnoreCase("7")
							|| args[1].equalsIgnoreCase("uniquebook")
							|| args[1].equalsIgnoreCase("uniqueb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Unique.";
					} else if(args[1].equalsIgnoreCase("8")
							|| args[1].equalsIgnoreCase("elitebook")
							|| args[1].equalsIgnoreCase("eliteb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Elite.";
					} else if(args[1].equalsIgnoreCase("9")
							|| args[1].equalsIgnoreCase("ultimatebook")
							|| args[1].equalsIgnoreCase("ultimateb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Ultimate.";
					} else if(args[1].equalsIgnoreCase("10")
							|| args[1].equalsIgnoreCase("legendarybook")
							|| args[1].equalsIgnoreCase("legendaryb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Legendary.";
					} else if(args[1].equalsIgnoreCase("11")
							|| args[1].equalsIgnoreCase("soulbook")
							|| args[1].equalsIgnoreCase("sb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "SoulBooks.";
					} else if(args[1].equalsIgnoreCase("12")) {
						item = new ItemStack(Material.EMERALD, amount);
						type = "SoulGemOptions.";
					} else if(args[1].equalsIgnoreCase("13")
							|| args[1].equalsIgnoreCase("transmogscroll")
							|| args[1].equalsIgnoreCase("transmog")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("TransmogScroll.Item").toUpperCase()), amount);
						type = "TransmogScroll.";
					} else if(args[1].equalsIgnoreCase("14")
							|| args[1].equalsIgnoreCase("nametag")
							|| args[1].equalsIgnoreCase("itemnametag")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("ItemNameTag.Item").toUpperCase()), amount);
						type = "ItemNameTag.";
					} else if(args[1].equalsIgnoreCase("15")
							|| args[1].equalsIgnoreCase("whitescroll")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("WhiteScrollOptions.Item").toUpperCase()), amount);
						type = "WhiteScrollOptions.";
					} else if(args[1].equalsIgnoreCase("16")
							|| args[1].equalsIgnoreCase("blackscroll")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("BlackScrollOptions.Item").toUpperCase()), amount);
						type = "BlackScrollOptions.";
					} else if(args[1].equalsIgnoreCase("17")
							|| args[1].equalsIgnoreCase("simplefireball")
							|| args[1].equalsIgnoreCase("simplefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Simple";
					} else if(args[1].equalsIgnoreCase("18")
							|| args[1].equalsIgnoreCase("uniquefireball")
							|| args[1].equalsIgnoreCase("uniquefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Unique";
					} else if(args[1].equalsIgnoreCase("19")
							|| args[1].equalsIgnoreCase("elitefireball")
							|| args[1].equalsIgnoreCase("elitefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Elite";
					} else if(args[1].equalsIgnoreCase("20")
							|| args[1].equalsIgnoreCase("ultimatefireball")
							|| args[1].equalsIgnoreCase("ultimatefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Ultimate";
					} else if(args[1].equalsIgnoreCase("21")
							|| args[1].equalsIgnoreCase("legendaryfireball")
							|| args[1].equalsIgnoreCase("legendaryfb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Legendary";
					} else if(args[1].equalsIgnoreCase("22") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "SimpleDP";
					} else if(args[1].equalsIgnoreCase("23") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "UniqueDP";
					} else if(args[1].equalsIgnoreCase("24") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "EliteDP";
					} else if(args[1].equalsIgnoreCase("25") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "UltimateDP";
					} else if(args[1].equalsIgnoreCase("26") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "LegendaryDP";
					} else if(args[1].equalsIgnoreCase("SoulBound")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "SoulBound";
					} else if(args[1].equalsIgnoreCase("MysteryMobSpawner") || args[1].equalsIgnoreCase("mms") || args[1].equalsIgnoreCase("27")) {
						item = new ItemStack(Material.MOB_SPAWNER, 1);
						type = "MysteryMobSpawner";
					} else {
						return true;
					}
					
					Random random = new Random();
					int randomChance = 100;
					int randomNumber = random.nextInt(randomChance);
					if(randomNumber < 60 && randomNumber + 50 <= 100) {
						randomNumber = randomNumber + 50;
					} else if(randomNumber < 60 && randomNumber + 40 > 59) {
						randomNumber = randomNumber + 40;
					} else if(randomNumber < 60 && randomNumber + 30 > 59) {
						randomNumber = randomNumber + 50;
					} else if(randomNumber + 60 <= 100) {
						randomNumber = randomNumber + 60;
					} else if(randomNumber < 60 && randomNumber + 40 >= 60) {
						randomNumber = randomNumber + 40;
					}
					
					if(type.startsWith("SoulTrackers.") || type.startsWith("BookOptions.") || type.startsWith("SoulBooks.") || type.startsWith("TransmogScroll.")
							|| type.startsWith("WhiteScrollOptions.") || type.startsWith("BlackScrollOptions.") || type.startsWith("Dust.Fireballs.")) {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
						if(type.startsWith("Dust.Fireballs.")) {
							type = type.replace("Legendary", "").replace("Ultimate", "").replace("Elite", "").replace("Unique", "").replace("Simple", "");
						}
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore1")));
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore2")));
						if(type.startsWith("WhiteScrollOptions.") || type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore3").replace("%percent%", "" + randomNumber + "%")));
						}
						if(type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore4")));
						}
					} else if(type.startsWith("ItemNameTag.")) {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore")));
					} else if(type.equalsIgnoreCase("SoulBound")) {
						itemMeta.setDisplayName(ChatColor.GREEN + "SoulBound");
						lore.add(ChatColor.AQUA + "Enchant incoming soon");
					} else if(type == "SimpleDP"
							|| type == "UniqueDP"
							|| type == "EliteDP"
							|| type == "UltimateDP"
							|| type == "LegendaryDP") {
						type = type.replace("DP", "");
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Name")));
						lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore1")));
						lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore2")));
					} else if(type == "SoulGemOptions.") {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name").replace("%souls%", "" + 0)));
						for(int i = 1; i <= 10; i++) {
							if(!(RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i) == null)) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i)));
							}
						}
					} else if(!(Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus") == null) && type == "MysteryMobSpawner") {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Name")));
						for(int i = 1; i <= 12; i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Lore" + i)));
						}
					} else {
						return true;
					}
					
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					
					if(!(Bukkit.getPlayer(args[0]) == null)
							&& Bukkit.getPlayer(args[0]).isOnline()
							&& !(type == null)
							&& !(amount == 0)) {
						Bukkit.getPlayer(args[0]).getInventory().addItem(item);
						Bukkit.getPlayer(args[0]).updateInventory();
						return true;
					} else {
						sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "Player " + ChatColor.YELLOW + ChatColor.ITALIC + args[0] + ChatColor.GRAY + " is offline, or doesn't exist");
						return true;
					}
				} else {
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "/givedp <player> <item> <amount>");
				return true;
			}
		} else {
			Player player = (Player) sender;
			int amount = 0;
			String type = null;
			ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			
			if(args.length == 0) {
				return true;
			} else {
				amount = 0;
				if(args.length == 2) {
					for(int i = 1; i <= 64; i++) {
						if(args[1].equalsIgnoreCase("" + i)) {
							amount = i;
						}
					}
				}
				if(args.length == 1 || args.length == 2 && !(amount == 1)) {
					if(args.length == 1) {
						amount = 1;
					}
					if(args[0].equalsIgnoreCase("1")
							|| args[0].equalsIgnoreCase("simplesoultracker")
							|| args[0].equalsIgnoreCase("simplest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Simple.";
					} else if(args[0].equalsIgnoreCase("2")
							|| args[0].equalsIgnoreCase("uniquesoultracker")
							|| args[0].equalsIgnoreCase("uniquest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Unique.";
					} else if(args[0].equalsIgnoreCase("3")
							|| args[0].equalsIgnoreCase("elitesoultracker")
							|| args[0].equalsIgnoreCase("elitest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Elite.";
					} else if(args[0].equalsIgnoreCase("4")
							|| args[0].equalsIgnoreCase("ultimatesoultracker")
							|| args[0].equalsIgnoreCase("ultimatest")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Ultimate.";
					} else if(args[0].equalsIgnoreCase("5")
							|| args[0].equalsIgnoreCase("legendarysoultracker")
							|| args[0].equalsIgnoreCase("legendaryst")) {
						item = new ItemStack(Material.PAPER, amount);
						type = "SoulTrackers.Legendary.";
					} else if(args[0].equalsIgnoreCase("6")
							|| args[0].equalsIgnoreCase("simplebook")
							|| args[0].equalsIgnoreCase("simpleb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Simple.";
					} else if(args[0].equalsIgnoreCase("7")
							|| args[0].equalsIgnoreCase("uniquebook")
							|| args[0].equalsIgnoreCase("uniqueb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Unique.";
					} else if(args[0].equalsIgnoreCase("8")
							|| args[0].equalsIgnoreCase("elitebook")
							|| args[0].equalsIgnoreCase("eliteb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Elite.";
					} else if(args[0].equalsIgnoreCase("9")
							|| args[0].equalsIgnoreCase("ultimatebook")
							|| args[0].equalsIgnoreCase("ultimateb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Ultimate.";
					} else if(args[0].equalsIgnoreCase("10")
							|| args[0].equalsIgnoreCase("legendarybook")
							|| args[0].equalsIgnoreCase("legendaryb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "BookOptions.Legendary.";
					} else if(args[0].equalsIgnoreCase("11")
							|| args[0].equalsIgnoreCase("soulbook")
							|| args[0].equalsIgnoreCase("sb")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "SoulBooks.";
					} else if(args[0].equalsIgnoreCase("12")) {
						item = new ItemStack(Material.EMERALD, amount);
						type = "SoulGemOptions.";
					} else if(args[0].equalsIgnoreCase("13")
							|| args[0].equalsIgnoreCase("transmogscroll")
							|| args[0].equalsIgnoreCase("transmog")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("TransmogScroll.Item").toUpperCase()), amount);
						type = "TransmogScroll.";
					} else if(args[0].equalsIgnoreCase("14")
							|| args[0].equalsIgnoreCase("nametag")
							|| args[0].equalsIgnoreCase("itemnametag")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("ItemNameTag.Item").toUpperCase()), amount);
						type = "ItemNameTag.";
					} else if(args[0].equalsIgnoreCase("15")
							|| args[0].equalsIgnoreCase("whitescroll")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("WhiteScrollOptions.Item").toUpperCase()), amount);
						type = "WhiteScrollOptions.";
					} else if(args[0].equalsIgnoreCase("16")
							|| args[0].equalsIgnoreCase("blackscroll")) {
						item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("BlackScrollOptions.Item").toUpperCase()), amount);
						type = "BlackScrollOptions.";
					} else if(args[0].equalsIgnoreCase("17")
							|| args[0].equalsIgnoreCase("simplefireball")
							|| args[0].equalsIgnoreCase("simplefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Simple";
					} else if(args[0].equalsIgnoreCase("18")
							|| args[0].equalsIgnoreCase("uniquefireball")
							|| args[0].equalsIgnoreCase("uniquefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Unique";
					} else if(args[0].equalsIgnoreCase("19")
							|| args[0].equalsIgnoreCase("elitefireball")
							|| args[0].equalsIgnoreCase("elitefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Elite";
					} else if(args[0].equalsIgnoreCase("20")
							|| args[0].equalsIgnoreCase("ultimatefireball")
							|| args[0].equalsIgnoreCase("ultimatefb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Ultimate";
					} else if(args[0].equalsIgnoreCase("21")
							|| args[0].equalsIgnoreCase("legendaryfireball")
							|| args[0].equalsIgnoreCase("legendaryfb")) {
						item = new ItemStack(Material.FIREBALL, amount);
						type = "Dust.Fireballs.Legendary";
					} else if(args[0].equalsIgnoreCase("22") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "SimpleDP";
					} else if(args[0].equalsIgnoreCase("23") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "UniqueDP";
					} else if(args[0].equalsIgnoreCase("24") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "EliteDP";
					} else if(args[0].equalsIgnoreCase("25") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "UltimateDP";
					} else if(args[0].equalsIgnoreCase("26") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
						item = new ItemStack(Material.TRAPPED_CHEST, amount);
						type = "LegendaryDP";
					} else if(args[0].equalsIgnoreCase("SoulBound")) {
						item = new ItemStack(Material.BOOK, amount);
						type = "SoulBound";
					} else if(args[0].equalsIgnoreCase("MysterMobSpawner") || args[0].equalsIgnoreCase("mms") || args[0].equalsIgnoreCase("27")) {
						item = new ItemStack(Material.MOB_SPAWNER, 1);
						type = "MysteryMobSpawner";
					} else {
						return true;
					}
					
					Random random = new Random();
					int randomChance = 100;
					int randomNumber = random.nextInt(randomChance);
					if(randomNumber < 60 && randomNumber + 50 <= 100) {
						randomNumber = randomNumber + 50;
					} else if(randomNumber < 60 && randomNumber + 40 > 59) {
						randomNumber = randomNumber + 40;
					} else if(randomNumber < 60 && randomNumber + 30 > 59) {
						randomNumber = randomNumber + 50;
					} else if(randomNumber + 60 <= 100) {
						randomNumber = randomNumber + 60;
					} else if(randomNumber < 60 && randomNumber + 40 >= 60) {
						randomNumber = randomNumber + 40;
					}
					
					if(type.startsWith("SoulTrackers.") || type.startsWith("BookOptions.") || type.startsWith("SoulBooks.") || type.startsWith("TransmogScroll.")
							|| type.startsWith("WhiteScrollOptions.") || type.startsWith("BlackScrollOptions.") || type.startsWith("Dust.Fireballs.")) {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
						if(type.startsWith("Dust.Fireballs.")) {
							type = type.replace("Legendary", "").replace("Ultimate", "").replace("Elite", "").replace("Unique", "").replace("Simple", "");
						}
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore1")));
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore2")));
						if(type.startsWith("WhiteScrollOptions.") || type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore3").replace("%percent%", "" + randomNumber + "%")));
						}
						if(type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore4")));
						}
					} else if(type.startsWith("ItemNameTag.")) {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore")));
					} else if(type.equalsIgnoreCase("SoulBound")) {
						itemMeta.setDisplayName(ChatColor.GREEN + "SoulBound");
						lore.add(ChatColor.AQUA + "Enchant incoming soon");
					} else if(type == "SimpleDP"
							|| type == "UniqueDP"
							|| type == "EliteDP"
							|| type == "UltimateDP"
							|| type == "LegendaryDP") {
						type = type.replace("DP", "");
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Name")));
						lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore1")));
						lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore2")));
					} else if(type == "SoulGemOptions.") {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name").replace("%souls%", "" + 0)));
						for(int i = 1; i <= 10; i++) {
							if(!(RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i) == null)) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i)));
							}
						}
					} else if(!(Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus") == null) && type == "MysteryMobSpawner") {
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Name")));
						for(int i = 1; i <= 12; i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Lore" + i)));
						}
					} else {
						return true;
					}
					
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					
					player.getInventory().addItem(item);
					player.updateInventory();
					return true;
				} else if(args.length == 3) {
					for(int i = 1; i <= 64; i++) {
						if(args[2].equalsIgnoreCase("" + i)) {
							amount = i;
						}
					}
					
					if(!(amount == 0)) {
						if(args[1].equalsIgnoreCase("1")
								|| args[1].equalsIgnoreCase("simplesoultracker")
								|| args[1].equalsIgnoreCase("simplest")) {
							item = new ItemStack(Material.PAPER, amount);
							type = "SoulTrackers.Simple.";
						} else if(args[1].equalsIgnoreCase("2")
								|| args[1].equalsIgnoreCase("uniquesoultracker")
								|| args[1].equalsIgnoreCase("uniquest")) {
							item = new ItemStack(Material.PAPER, amount);
							type = "SoulTrackers.Unique.";
						} else if(args[1].equalsIgnoreCase("3")
								|| args[1].equalsIgnoreCase("elitesoultracker")
								|| args[1].equalsIgnoreCase("elitest")) {
							item = new ItemStack(Material.PAPER, amount);
							type = "SoulTrackers.Elite.";
						} else if(args[1].equalsIgnoreCase("4")
								|| args[1].equalsIgnoreCase("ultimatesoultracker")
								|| args[1].equalsIgnoreCase("ultimatest")) {
							item = new ItemStack(Material.PAPER, amount);
							type = "SoulTrackers.Ultimate.";
						} else if(args[1].equalsIgnoreCase("5")
								|| args[1].equalsIgnoreCase("legendarysoultracker")
								|| args[1].equalsIgnoreCase("legendaryst")) {
							item = new ItemStack(Material.PAPER, amount);
							type = "SoulTrackers.Legendary.";
						} else if(args[1].equalsIgnoreCase("6")
								|| args[1].equalsIgnoreCase("simplebook")
								|| args[1].equalsIgnoreCase("simpleb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "BookOptions.Simple.";
						} else if(args[1].equalsIgnoreCase("7")
								|| args[1].equalsIgnoreCase("uniquebook")
								|| args[1].equalsIgnoreCase("uniqueb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "BookOptions.Unique.";
						} else if(args[1].equalsIgnoreCase("8")
								|| args[1].equalsIgnoreCase("elitebook")
								|| args[1].equalsIgnoreCase("eliteb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "BookOptions.Elite.";
						} else if(args[1].equalsIgnoreCase("9")
								|| args[1].equalsIgnoreCase("ultimatebook")
								|| args[1].equalsIgnoreCase("ultimateb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "BookOptions.Ultimate.";
						} else if(args[1].equalsIgnoreCase("10")
								|| args[1].equalsIgnoreCase("legendarybook")
								|| args[1].equalsIgnoreCase("legendaryb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "BookOptions.Legendary.";
						} else if(args[1].equalsIgnoreCase("11")
								|| args[1].equalsIgnoreCase("soulbook")
								|| args[1].equalsIgnoreCase("sb")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "SoulBooks.";
						} else if(args[1].equalsIgnoreCase("12")) {
							item = new ItemStack(Material.EMERALD, amount);
							type = "SoulGemOptions.";
						} else if(args[1].equalsIgnoreCase("13")
								|| args[1].equalsIgnoreCase("transmogscroll")
								|| args[1].equalsIgnoreCase("transmog")) {
							item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("TransmogScroll.Item").toUpperCase()), amount);
							type = "TransmogScroll.";
						} else if(args[1].equalsIgnoreCase("14")
								|| args[1].equalsIgnoreCase("nametag")
								|| args[1].equalsIgnoreCase("itemnametag")) {
							item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("ItemNameTag.Item").toUpperCase()), amount);
							type = "ItemNameTag.";
						} else if(args[1].equalsIgnoreCase("15")
								|| args[1].equalsIgnoreCase("whitescroll")) {
							item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("WhiteScrollOptions.Item").toUpperCase()), amount);
							type = "WhiteScrollOptions.";
						} else if(args[1].equalsIgnoreCase("16")
								|| args[1].equalsIgnoreCase("blackscroll")) {
							item = new ItemStack(Material.getMaterial(RandomPackage.getPlugin().getConfig().getString("BlackScrollOptions.Item").toUpperCase()), amount);
							type = "BlackScrollOptions.";
						} else if(args[1].equalsIgnoreCase("17")
								|| args[1].equalsIgnoreCase("simplefireball")
								|| args[1].equalsIgnoreCase("simplefb")) {
							item = new ItemStack(Material.FIREBALL, amount);
							type = "Dust.Fireballs.Simple";
						} else if(args[1].equalsIgnoreCase("18")
								|| args[1].equalsIgnoreCase("uniquefireball")
								|| args[1].equalsIgnoreCase("uniquefb")) {
							item = new ItemStack(Material.FIREBALL, amount);
							type = "Dust.Fireballs.Unique";
						} else if(args[1].equalsIgnoreCase("19")
								|| args[1].equalsIgnoreCase("elitefireball")
								|| args[1].equalsIgnoreCase("elitefb")) {
							item = new ItemStack(Material.FIREBALL, amount);
							type = "Dust.Fireballs.Elite";
						} else if(args[1].equalsIgnoreCase("20")
								|| args[1].equalsIgnoreCase("ultimatefireball")
								|| args[1].equalsIgnoreCase("ultimatefb")) {
							item = new ItemStack(Material.FIREBALL, amount);
							type = "Dust.Fireballs.Ultimate";
						} else if(args[1].equalsIgnoreCase("21")
								|| args[1].equalsIgnoreCase("legendaryfireball")
								|| args[1].equalsIgnoreCase("legendaryfb")) {
							item = new ItemStack(Material.FIREBALL, amount);
							type = "Dust.Fireballs.Legendary";
						} else if(args[1].equalsIgnoreCase("22") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
							item = new ItemStack(Material.TRAPPED_CHEST, amount);
							type = "SimpleDP";
						} else if(args[1].equalsIgnoreCase("23") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
							item = new ItemStack(Material.TRAPPED_CHEST, amount);
							type = "UniqueDP";
						} else if(args[1].equalsIgnoreCase("24") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
							item = new ItemStack(Material.TRAPPED_CHEST, amount);
							type = "EliteDP";
						} else if(args[1].equalsIgnoreCase("25") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
							item = new ItemStack(Material.TRAPPED_CHEST, amount);
							type = "UltimateDP";
						} else if(args[1].equalsIgnoreCase("26") && !(Bukkit.getPluginManager().getPlugin("DropPackages") == null)) {
							item = new ItemStack(Material.TRAPPED_CHEST, amount);
							type = "LegendaryDP";
						} else if(args[1].equalsIgnoreCase("SoulBound")) {
							item = new ItemStack(Material.BOOK, amount);
							type = "SoulBound";
						} else if(args[1].equalsIgnoreCase("MysterMobSpawner") || args[1].equalsIgnoreCase("mms") || args[1].equalsIgnoreCase("27")) {
							item = new ItemStack(Material.MOB_SPAWNER, 1);
							type = "MysteryMobSpawner";
						} else {
							return true;
						}
						
						Random random = new Random();
						int randomChance = 100;
						int randomNumber = random.nextInt(randomChance);
						if(randomNumber < 60 && randomNumber + 50 <= 100) {
							randomNumber = randomNumber + 50;
						} else if(randomNumber < 60 && randomNumber + 40 > 59) {
							randomNumber = randomNumber + 40;
						} else if(randomNumber < 60 && randomNumber + 30 > 59) {
							randomNumber = randomNumber + 50;
						} else if(randomNumber + 60 <= 100) {
							randomNumber = randomNumber + 60;
						} else if(randomNumber < 60 && randomNumber + 40 >= 60) {
							randomNumber = randomNumber + 40;
						}
						
						if(type.startsWith("SoulTrackers.") || type.startsWith("BookOptions.") || type.startsWith("SoulBooks.") || type.startsWith("TransmogScroll.")
								|| type.startsWith("WhiteScrollOptions.") || type.startsWith("BlackScrollOptions.") || type.startsWith("Dust.Fireballs.")) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
							if(type.startsWith("Dust.Fireballs.")) {
								type = type.replace("Legendary", "").replace("Ultimate", "").replace("Elite", "").replace("Unique", "").replace("Simple", "");
							}
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore1")));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore2")));
							if(type.startsWith("WhiteScrollOptions.") || type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore3").replace("%percent%", "" + randomNumber + "%")));
							}
							if(type.startsWith("TransmogScroll.") || type.startsWith("BlackScrollOptions.")) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore4")));
							}
						} else if(type.startsWith("ItemNameTag.")) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name")));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore")));
						} else if(type.equalsIgnoreCase("SoulBound")) {
							itemMeta.setDisplayName(ChatColor.GREEN + "SoulBound");
							lore.add(ChatColor.AQUA + "Enchant incoming soon");
						} else if(type == "SimpleDP"
								|| type == "UniqueDP"
								|| type == "EliteDP"
								|| type == "UltimateDP"
								|| type == "LegendaryDP") {
							type = type.replace("DP", "");
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Name")));
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore1")));
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString(type + ".Lore2")));
						} else if(type == "SoulGemOptions.") {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Name").replace("%souls%", "" + 0)));
							for(int i = 1; i <= 10; i++) {
								if(!(RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i) == null)) {
									lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString(type + "Lore" + i)));
								}
							}
						} else if(!(Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus") == null) && type == "MysteryMobSpawner") {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Name")));
							for(int i = 1; i <= 12; i++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("RandomArmorEffectsPlus").getConfig().getString("MysteryMobSpawners.Lore" + i)));
							}
						} else {
							return true;
						}
						
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						
						if(!(Bukkit.getPlayer(args[0]) == null)
								&& Bukkit.getPlayer(args[0]).isOnline()
								&& !(type == null)
								&& !(amount == 0)) {
							Bukkit.getPlayer(args[0]).getInventory().addItem(item);
							Bukkit.getPlayer(args[0]).updateInventory();
							return true;
						} else {
							sender.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "Player " + ChatColor.YELLOW + ChatColor.ITALIC + args[0] + ChatColor.GRAY + " is offline, or doesn't exist");
							return true;
						}
					} else {
						return true;
					}
				} else if(args.length == 2) {
					return true;
				} else if(args.length == 1) {
					return true;
				} else {
					return true;
				}
			}
		}
	}
}
