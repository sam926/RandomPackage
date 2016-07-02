package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Enchanter;

import java.util.ArrayList;
import java.util.Random;

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

public class enchanterListener implements Listener {
	private ArrayList<String> protectSoulPurchase = new ArrayList<String>();
	public static Inventory soulTrackerGui = Bukkit.createInventory(null, RandomPackage.getEnchanterConfig().getInt("SoulTrackers.Slots"), ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers.ChestName")));
	public static Inventory books = Bukkit.createInventory(null, RandomPackage.getEnchanterConfig().getInt("Books.Slots"), ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books.ChestName")));
	public static Inventory other = Bukkit.createInventory(null, RandomPackage.getEnchanterConfig().getInt("Other.Slots"), ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other.ChestName")));
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || event.getWhoClicked().getOpenInventory().getTitle() == null
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("EnchanterGui.ChestName"))))) {
			return;
		} else {
			String iteM = null;
			ItemStack item = new ItemStack(Material.ACACIA_DOOR);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			Player player = (Player) event.getWhoClicked();
			player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 1);
			for(int i = 1; i <= 7; i++) {
				if(i == 1) { iteM = "Simple";
				} else if(i == 2) { iteM = "Unique";
				} else if(i == 3) { iteM = "Elite";
				} else if(i == 4) { iteM = "Ultimate";
				} else if(i == 5) { iteM = "Legendary";
				} else if(i == 6) { iteM = "Soul";
				} else if(i == 7) { iteM = "Back";
				}
				if(!(i == 6)) {
					lore.clear();
					item = new ItemStack(Material.getMaterial(RandomPackage.getEnchanterConfig().getString("SoulTrackers." + iteM + ".Item").toUpperCase()), 1, (byte) RandomPackage.getEnchanterConfig().getInt("SoulTrackers." + iteM + ".Data"));
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers." + iteM + ".Name")));
					for(int o = 0; o < RandomPackage.getEnchanterConfig().getStringList("SoulTrackers." + iteM + ".Lore").size(); o++) {
						if(!(iteM == "Back") && RandomPackage.getEnchanterConfig().getString("SoulTrackers." + iteM + ".PurchaseWithCash").equalsIgnoreCase("true")) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("SoulTrackers." + iteM + ".Lore").get(o).replace("%price%", "" + RandomPackage.getEnchanterConfig().getInt("SoulTrackers." + iteM + ".Price"))));
						} else {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("SoulTrackers." + iteM + ".Lore").get(o).replace("%price%", "" + RandomPackage.getEnchanterConfig().getInt("SoulTrackers." + iteM + ".XpCost"))));
						}
					}
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					soulTrackerGui.setItem(RandomPackage.getEnchanterConfig().getInt("SoulTrackers." + iteM + ".Slot"), item);
				}
				//
				lore.clear();
				item = new ItemStack(Material.getMaterial(RandomPackage.getEnchanterConfig().getString("Books." + iteM + ".Item").toUpperCase()), 1, (byte) RandomPackage.getEnchanterConfig().getInt("Books." + iteM + ".Data"));
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books." + iteM + ".Name")));
				for(int o = 0; o < RandomPackage.getEnchanterConfig().getStringList("Books." + iteM + ".Lore").size(); o++) {
					if(!(iteM == "Back") && RandomPackage.getEnchanterConfig().getString("Books." + iteM + ".PurchaseWithCash").equalsIgnoreCase("true")) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("Books." + iteM + ".Lore").get(o).replace("%cost%", "" + RandomPackage.getEnchanterConfig().getInt("Books." + iteM + ".Price"))));
					} else {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("Books." + iteM + ".Lore").get(o).replace("%cost%", "" + RandomPackage.getEnchanterConfig().getInt("Books." + iteM + ".XpCost"))));
					}
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				books.setItem(RandomPackage.getEnchanterConfig().getInt("Books." + iteM + ".Slot"), item);
				//
			}
			for(int i = 1; i <= 6; i++) {
				if(i == 1) { iteM = "WhiteScrolls";
				} else if(i == 2) { iteM = "BlackScrolls";
				} else if(i == 3) { iteM = "TransmogScrolls";
				} else if(i == 4) { iteM = "ItemNameTags";
				} else if(i == 5) { iteM = "MysteryMobSpawner";
				} else if(i == 6) { iteM = "Back";
				}
				lore.clear();
				item = new ItemStack(Material.getMaterial(RandomPackage.getEnchanterConfig().getString("Other." + iteM + ".Item").toUpperCase()), 1, (byte) RandomPackage.getEnchanterConfig().getInt("Other." + iteM + ".Data"));
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other." + iteM + ".Name")));
				for(int o = 0; o < RandomPackage.getEnchanterConfig().getStringList("Other." + iteM + ".Lore").size(); o++) {
					if(!(iteM == "Back") && RandomPackage.getEnchanterConfig().getString("Other." + iteM + ".PurchaseWithCash").equalsIgnoreCase("true")) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("Other." + iteM + ".Lore").get(o).replace("%cost%", "" + RandomPackage.getEnchanterConfig().getInt("Other." + iteM + ".Price"))));
					} else {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getStringList("Other." + iteM + ".Lore").get(o).replace("%cost%", "" + RandomPackage.getEnchanterConfig().getInt("Other." + iteM + ".XpCost"))));
					}
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				other.setItem(RandomPackage.getEnchanterConfig().getInt("Other." + iteM + ".Slot"), item);
			}
			
			if(event.getRawSlot() > RandomPackage.getEnchanterConfig().getInt("EnchanterGui.Slots")) { event.setCancelled(true); return;
			} else if(event.getRawSlot() == RandomPackage.getEnchanterConfig().getInt("EnchanterGui.SoulTrackers.Slot")
					&& RandomPackage.getEnchanterConfig().getString("SoulTrackers.Enabled").equalsIgnoreCase("true")) {
				event.setCancelled(true);
				player.openInventory(soulTrackerGui);
				return;
			} else if(event.getRawSlot() == RandomPackage.getEnchanterConfig().getInt("EnchanterGui.Books.Slot")
					&& RandomPackage.getEnchanterConfig().getString("Books.Enabled").equalsIgnoreCase("true")) {
				event.setCancelled(true);
				player.openInventory(books);
				protectSoulPurchase.add(player.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						protectSoulPurchase.remove(player.getName());
						return;
					}
				}, 1);
				return;
			} else if(event.getRawSlot() == RandomPackage.getEnchanterConfig().getInt("EnchanterGui.Other.Slot")
					&& RandomPackage.getEnchanterConfig().getString("Other.Enabled").equalsIgnoreCase("true")) {
				event.setCancelled(true);
				player.openInventory(other);
				return;
			} else {
				event.setCancelled(true);
				return;
			}
		}
	}
	@EventHandler
	private void back(InventoryClickEvent event) {
		if(event.getCurrentItem() == null || !(event.getCurrentItem().hasItemMeta()) || !(event.getCurrentItem().getItemMeta().hasDisplayName()) || !(event.getCurrentItem().getItemMeta().hasLore())
				|| event.getWhoClicked().getOpenInventory().getTitle() == null) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers.ChestName")))
					&& event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers.Back.Name")))
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books.ChestName")))
					&& event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books.Back.Name")))
					|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other.ChestName")))
					&& event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other.Back.Name")))) {
				event.setCancelled(true);
				player.openInventory(enchanterCommand.enchanter);
				player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 1);
				return;
			} else { return; }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	private void purchase(InventoryClickEvent event) {
		if(event.getWhoClicked().getOpenInventory().getTitle() == null
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers.ChestName"))))) {
			return;
		} else {
			if(event.getRawSlot() >= RandomPackage.getEnchanterConfig().getInt("SoulTrackers.Slots")
					|| event.getRawSlot() >= RandomPackage.getEnchanterConfig().getInt("Books.Slots")
					|| event.getRawSlot() >= RandomPackage.getEnchanterConfig().getInt("Other.Slots")) {
				event.setCancelled(true);
				return;
			} else {
				Random random = new Random();
				int percent = random.nextInt(100);
				if(percent < 40) {
					percent = 60 + percent;
				}
				Player player = (Player) event.getWhoClicked();
				String purchase = null, purchaseItem = null;
				if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("SoulTrackers.ChestName")))) {
					purchase = "SoulTrackers.";
				} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Books.ChestName")))) {
					purchase = "Books.";
				} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Other.ChestName")))) {
					purchase = "Other.";
				} else { return; }
				ArrayList<String> lore = new ArrayList<String>();
				if(purchase == "Other.") {
					for(int i = 1; i <= 5; i++) {
						if(i == 1) { purchaseItem = "WhiteScrolls";
						} else if(i == 2) { purchaseItem = "BlackScrolls";
						} else if(i == 3) { purchaseItem = "TransmogScrolls";
						} else if(i == 4) { purchaseItem = "ItemNameTags";
						} else if(i == 5) { purchaseItem = "MysteryMobSpawner";
						}
						if(event.getRawSlot() == RandomPackage.getEnchanterConfig().getInt("Other." + purchaseItem + ".Slot")
								&& RandomPackage.getEnchanterConfig().getString("Other." + purchaseItem + ".Enabled").equalsIgnoreCase("true")) {
							event.setCancelled(true);
							if(RandomPackage.getEnchanterConfig().getString("Other." + purchaseItem + ".PurchaseWithCash").equalsIgnoreCase("true")) {
								if(RandomPackage.econ.withdrawPlayer(player.getName(), RandomPackage.getEnchanterConfig().getInt("Other." + purchaseItem + ".Price")).transactionSuccess()) {
									player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 2);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.CashWithdraw").replace("%amount%", RandomPackage.getEnchanterConfig().getString("Other." + purchaseItem + ".Price"))));
									lore.clear();
									ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
									
									if(!(purchaseItem == "MysteryMobSpawner")) { item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString(purchaseItem + ".Item").toUpperCase()), 1);
									} else { item = new ItemStack(Material.getMaterial(RandomPackage.getMysteryMobSpawnerConfig().getString("Item").toUpperCase()), 1); }
									
									ItemMeta itemMeta = item.getItemMeta();
									
									if(!(purchaseItem == "MysteryMobSpawner")) { itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString(purchaseItem + ".Name")));
									} else { itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Name"))); }
									
									if(!(purchaseItem == "MysteryMobSpawner")) {
										for(int o = 0; o < RandomPackage.getGivedpItemsConfig().getStringList(purchaseItem + ".Lore").size(); o++) {
											lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList(purchaseItem + ".Lore").get(o).replace("%percent%", "" + percent)));
										}
									} else {
										for(int o = 0; o < RandomPackage.getMysteryMobSpawnerConfig().getStringList("Lore").size(); o++) {
											lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getStringList("Lore").get(o)));
										}
									}
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									player.getInventory().addItem(item);
									player.updateInventory();
									return;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.notEnough").replace("%type%", "CASH")));
									return;
								}
							} else {
								event.setCancelled(true);
								if(player.getTotalExperience() >= RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".XpCost")
										&& RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".Enabled").equalsIgnoreCase("true")) {
									int experience = player.getTotalExperience() - RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".XpCost");
									player.setTotalExperience(0); player.setExp(0); player.setLevel(0);
									player.giveExp(experience);
									player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 2);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.ExpRemove").replace("%xp%", RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".XpCost"))));
									lore.clear();
									ItemStack item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString(purchaseItem + ".Item").toUpperCase()), 1);
									ItemMeta itemMeta = item.getItemMeta();
									itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString(purchaseItem + ".Name")));
									for(int o = 0; o < RandomPackage.getBookOptionsConfig().getStringList(purchaseItem + ".Lore").size(); o++) {
										lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList(purchaseItem + ".Lore").get(o)));
									}
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									player.getInventory().addItem(item);
									player.updateInventory();
									return;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.notEnough").replace("%type%", "XP")));
									return;
								}
							}
						}
					}
					return;
				} else {
					if(protectSoulPurchase.contains(player.getName())) { event.setCancelled(true); return; }
					for(int i = 1; i <= 6; i++) {
						if(i == 1) { purchaseItem = "Simple";
						} else if(i == 2) { purchaseItem = "Unique";
						} else if(i == 3) { purchaseItem = "Elite";
						} else if(i == 4) { purchaseItem = "Ultimate";
						} else if(i == 5) { purchaseItem = "Legendary";
						} else if(i == 6) { purchaseItem = "Soul"; }
						if(event.getRawSlot() == RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".Slot")
								&& RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".Enabled").equalsIgnoreCase("true")) {
							event.setCancelled(true);
							if(RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".PurchaseWithCash").equalsIgnoreCase("true")) {
								if(RandomPackage.econ.withdrawPlayer(player.getName(), RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".Price")).transactionSuccess()) {
									player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 2);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.CashWithdraw").replace("%amount%", RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".Price"))));
									lore.clear();
									ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
									if(purchase == "SoulTrackers.") {
										item = new ItemStack(Material.getMaterial(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()), 1);
									} else {
										item = new ItemStack(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString(purchaseItem + ".Item").toUpperCase()), 1);
									}
									ItemMeta itemMeta = item.getItemMeta();
									if(purchase == "SoulTrackers.") {
										itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers." + purchaseItem + ".Name")));
									} else {
										itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString(purchaseItem + ".Name")));
									}
									if(purchase == "SoulTrackers.") {
										for(int o = 0; o < RandomPackage.getSoulConfig().getStringList("SoulTrackers." + purchaseItem + ".Lore").size(); o++) {
											lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("SoulTrackers." + purchaseItem + ".Lore").get(o)));
										}
									} else {
										for(int o = 0; o < RandomPackage.getGivedpItemsConfig().getStringList(purchaseItem + ".Lore").size(); o++) {
											lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList(purchaseItem + ".Lore").get(o)));
										}
									}
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									player.getInventory().addItem(item);
									player.updateInventory();
									return;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.notEnough").replace("%type%", "CASH")));
									return;
								}
							} else {
								event.setCancelled(true);
								if(player.getTotalExperience() >= RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".XpCost")
										&& RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".Enabled").equalsIgnoreCase("true")) {
									int experience = player.getTotalExperience() - RandomPackage.getEnchanterConfig().getInt(purchase + purchaseItem + ".XpCost");
									player.setTotalExperience(0); player.setExp(0); player.setLevel(0);
									
									player.giveExp(experience);
									player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 2);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.ExpRemove").replace("%xp%", RandomPackage.getEnchanterConfig().getString(purchase + purchaseItem + ".XpCost"))));
									lore.clear();
									ItemStack item = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString(purchaseItem + ".Item").toUpperCase()), 1);
									ItemMeta itemMeta = item.getItemMeta();
									itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString(purchaseItem + ".Name")));
									for(int o = 0; o < RandomPackage.getBookOptionsConfig().getStringList(purchaseItem + ".Lore").size(); o++) {
										lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList(purchaseItem + ".Lore").get(o)));
									}
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									player.getInventory().addItem(item);
									player.updateInventory();
									return;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getEnchanterConfig().getString("Messages.notEnough").replace("%type%", "XP")));
									return;
								}
							}
						}
					}
					return;
				}
			}
		}
	}
}
