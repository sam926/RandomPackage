package me.randomHashTags.randomPackage.RandomArmorEffects.Commands.bookGui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantType;

public class BookGuiListener implements Listener {
	private Inventory legendaryBookGui = Bukkit.createInventory(null, 54, "Legendary Books | Page 1");
	private Inventory ultimateBookGui = Bukkit.createInventory(null, 54, "Ultimate Books | Page 1");
	private Inventory ultimateBookGui2 = Bukkit.createInventory(null, 54, "Ultimate Books | Page 2");
	private Inventory eliteBookGui = Bukkit.createInventory(null, 54, "Elite Books | Page 1");
	private Inventory eliteBookGui2 = Bukkit.createInventory(null, 54, "Elite Books | Page 2");
	private Inventory uniqueBookGui = Bukkit.createInventory(null, 54, "Unique Books | Page 1");
	private Inventory uniqueBookGui2 = Bukkit.createInventory(null, 54, "Unique Books | Page 2");
	private Inventory simpleBookGui = Bukkit.createInventory(null, 54, "Simple Books | Page 1");
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.getCurrentItem() == null
				|| !(event.getCurrentItem().hasItemMeta())
				|| !(event.getCurrentItem().getItemMeta().hasDisplayName())
				|| !(event.getCurrentItem().getItemMeta().hasLore())
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(BookGui.bookGuiTitle))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(legendaryBookGui.getTitle()))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ultimateBookGui.getTitle())) && !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ultimateBookGui2.getTitle()))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(eliteBookGui.getTitle())) && !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(eliteBookGui2.getTitle()))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(uniqueBookGui.getTitle())) && !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(uniqueBookGui2.getTitle()))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(simpleBookGui.getTitle()))) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			ItemStack item = new ItemStack(Material.ACACIA_DOOR);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			item = new ItemStack(Material.PAPER, 1);
			itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Next Page");
			lore.add(ChatColor.YELLOW + "Go to page 2");
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
			if(player.getOpenInventory().getTitle().equalsIgnoreCase(BookGui.bookGuiTitle)) {
				legendaryBookGui.clear();
				ultimateBookGui.clear(); ultimateBookGui2.clear();
				eliteBookGui.clear(); eliteBookGui2.clear();
				uniqueBookGui.clear(); uniqueBookGui2.clear();
				simpleBookGui.clear();
				ultimateBookGui.setItem(ultimateBookGui.getSize() - 1, item);
				eliteBookGui.setItem(eliteBookGui.getSize() - 1, item);
				uniqueBookGui.setItem(uniqueBookGui.getSize() - 1, item);
				for(int i = 0; i < EnchantBookNames.getLegendaryBookNames().size(); i++) {
					item = new ItemStack(Material.BOOK, 1);
					itemMeta.setDisplayName(EnchantBookNames.getLegendaryBookNames().get(i));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
					for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Legendary." + ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Legendary." + ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
					}
					if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
					} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
					} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
					} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
					} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
					} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
					} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
					} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
					} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
					} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
					} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
					} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
					} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					legendaryBookGui.addItem(item);
					lore.clear();
				}
				//
				for(int i = 0; i < EnchantBookNames.getUltimateBookNames().size(); i++) {
					item = new ItemStack(Material.BOOK, 1);
					itemMeta.setDisplayName(EnchantBookNames.getUltimateBookNames().get(i));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
					for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Ultimate." + ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Ultimate." + ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
					}
					if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
					} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
					} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
					} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
					} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
					} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
					} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
					} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
					} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
					} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
					} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
					} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
					} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					ultimateBookGui.addItem(item);
					lore.clear();
				}
				//
				for(int i = 0; i < EnchantBookNames.getUltimateBookNames().size(); i++) {
					if(ultimateBookGui.getItem(ultimateBookGui.getSize() - 2).getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUltimateBookNames().get(i))) {
						for(int o = i; o < EnchantBookNames.getUltimateBookNames().size(); o++) {
							lore.clear();
							item = new ItemStack(Material.BOOK, 1);
							itemMeta.setDisplayName(EnchantBookNames.getUltimateBookNames().get(o));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
							for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Ultimate." + ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Ultimate." + ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
							}
							if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
							} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
							} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
							} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
							} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
							} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
							} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
							} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
							} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
							} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
							} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
							} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
							} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
							itemMeta.setLore(lore);
							item.setItemMeta(itemMeta);
							ultimateBookGui2.addItem(item);
						}
					}
				}
				//
				for(int i = 0; i < EnchantBookNames.getEliteBookNames().size(); i++) {
					lore.clear();
					item = new ItemStack(Material.BOOK, 1);
					itemMeta.setDisplayName(EnchantBookNames.getEliteBookNames().get(i));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
					for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Elite." + ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Elite." + ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
					}
					if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
					} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
					} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
					} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
					} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
					} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
					} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
					} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
					} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
					} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
					} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
					} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
					} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					eliteBookGui.addItem(item);
				}
				//
				for(int i = 0; i < EnchantBookNames.getEliteBookNames().size(); i++) {
					if(eliteBookGui.getItem(eliteBookGui.getSize() - 2).getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getEliteBookNames().get(i))) {
						for(int o = i; o < EnchantBookNames.getEliteBookNames().size(); o++) {
							lore.clear();
							item = new ItemStack(Material.BOOK, 1);
							itemMeta.setDisplayName(EnchantBookNames.getEliteBookNames().get(o));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
							for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Elite." + ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Elite." + ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
							}
							if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
							} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
							} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
							} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
							} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
							} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
							} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
							} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
							} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
							} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
							} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
							} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
							} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
							itemMeta.setLore(lore);
							item.setItemMeta(itemMeta);
							eliteBookGui2.addItem(item);
						}
					}
				}
				//
				for(int i = 0; i < EnchantBookNames.getUniqueBookNames().size(); i++) {
					lore.clear();
					item = new ItemStack(Material.BOOK, 1);
					itemMeta.setDisplayName(EnchantBookNames.getUniqueBookNames().get(i));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
					for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Unique." + ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Unique." + ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
					}
					if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
					} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
					} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
					} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
					} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
					} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
					} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
					} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
					} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
					} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
					} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
					} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
					} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					uniqueBookGui.addItem(item);
				}
				//
				for(int i = 0; i < EnchantBookNames.getUniqueBookNames().size(); i++) {
					if(uniqueBookGui.getItem(uniqueBookGui.getSize() - 2).getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUniqueBookNames().get(i))) {
						for(int o = i; o < EnchantBookNames.getUniqueBookNames().size(); o++) {
							lore.clear();
							item = new ItemStack(Material.BOOK, 1);
							itemMeta.setDisplayName(EnchantBookNames.getUniqueBookNames().get(o));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
							for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Unique." + ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Unique." + ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
							}
							if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
							} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
							} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
							} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
							} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
							} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
							} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
							} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
							} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
							} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
							} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
							} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
							} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
							itemMeta.setLore(lore);
							item.setItemMeta(itemMeta);
							uniqueBookGui2.addItem(item);
						}
					}
				}
				//
				for(int i = 0; i < EnchantBookNames.getSimpleBookNames().size(); i++) {
					lore.clear();
					item = new ItemStack(Material.BOOK, 1);
					itemMeta.setDisplayName(EnchantBookNames.getSimpleBookNames().get(i));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "100")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "0")));
					for(int p = 0; p < RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Simple." + ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).size(); p++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments.Simple." + ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore")).get(p)));
					}
					if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
					} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
					} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
					} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
					} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
					} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
					} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
					} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
					} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
					} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
					} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
					} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
					} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); }
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					simpleBookGui.addItem(item);
				}
			}
			if(player.getOpenInventory().getTitle().equalsIgnoreCase(BookGui.bookGuiTitle)) {
				player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 1);
				event.setCancelled(true);
				if(event.getRawSlot() == 6) { player.openInventory(legendaryBookGui);
				} else if(event.getRawSlot() == 5) { player.openInventory(ultimateBookGui);
				} else if(event.getRawSlot() == 4) { player.openInventory(eliteBookGui);
				} else if(event.getRawSlot() == 3) { player.openInventory(uniqueBookGui);
				} else if(event.getRawSlot() == 2) { player.openInventory(simpleBookGui);
				} else {
					return;
				}
				return;
			} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(legendaryBookGui.getTitle())
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(ultimateBookGui.getTitle())
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(eliteBookGui.getTitle())
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(uniqueBookGui.getTitle())
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(simpleBookGui.getTitle())) {
				if(player.getOpenInventory().getTitle().equalsIgnoreCase(ultimateBookGui.getTitle()) && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Next Page")) {
					player.openInventory(ultimateBookGui2);
				} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(eliteBookGui.getTitle()) && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Next Page")) {
					player.openInventory(eliteBookGui2);
				} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(uniqueBookGui.getTitle()) && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Next Page")) {
					player.openInventory(uniqueBookGui2);
				}
				event.setCancelled(true);
				return;
			} else {
				event.setCancelled(true);
				return;
			}
		}
	}
}
