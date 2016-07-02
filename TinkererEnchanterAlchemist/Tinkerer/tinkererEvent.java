package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookLores;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;

public class tinkererEvent implements Listener {
	private ArrayList<String> tinkererItems = new ArrayList<String>();
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		tinkererItems.add("" + 0); tinkererItems.add("" + 5); tinkererItems.add("" + 6); tinkererItems.add("" + 7); tinkererItems.add("" + 8);
		tinkererItems.add("" + 14); tinkererItems.add("" + 15); tinkererItems.add("" + 16); tinkererItems.add("" + 17);
		tinkererItems.add("" + 23); tinkererItems.add("" + 24); tinkererItems.add("" + 25); tinkererItems.add("" + 26);
		tinkererItems.add("" + 32); tinkererItems.add("" + 33); tinkererItems.add("" + 34); tinkererItems.add("" + 35);
		tinkererItems.add("" + 41); tinkererItems.add("" + 42); tinkererItems.add("" + 43); tinkererItems.add("" + 44);
		tinkererItems.add("" + 50); tinkererItems.add("" + 51); tinkererItems.add("" + 52); tinkererItems.add("" + 53);
	}
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.ChestName"))))) {
			return;
		} else {
			if(!(event.getCurrentItem().getType().name().endsWith("HELMET"))
					&& !(event.getCurrentItem().getType().name().endsWith("CHESTPLATE"))
					&& !(event.getCurrentItem().getType().name().endsWith("LEGGINGS"))
					&& !(event.getCurrentItem().getType().name().endsWith("BOOTS"))
					&& !(event.getCurrentItem().getType().name().endsWith("BOW"))
					&& !(event.getCurrentItem().getType().name().endsWith("SWORD"))
					&& !(event.getCurrentItem().getType().name().endsWith("PICKAXE"))
					&& !(event.getCurrentItem().getType().name().endsWith("AXE"))
					&& !(event.getCurrentItem().getType().name().endsWith("SPADE"))
					&& !(event.getCurrentItem().getType().name().endsWith("HOE"))
					&& !(event.getCurrentItem().getType().name().endsWith("THIN_GLASS"))
					&& !(event.getCurrentItem().getType().name().endsWith("STAINED_GLASS_PANE"))
					&& !(event.getCurrentItem().getType().name().endsWith("BOOK"))
					|| event.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK)
					|| event.getCurrentItem().getType().equals(Material.BOOK)
					&& !(event.getCurrentItem().hasItemMeta()) && !(event.getCurrentItem().getItemMeta().hasDisplayName())&& !(event.getCurrentItem().getItemMeta().hasLore())) {
				event.setCancelled(true);
				return;
			} else {
				Player player = (Player) event.getWhoClicked();
				ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
				ItemMeta itemMeta = item.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				for(int i = 4; i <= 53; i += 9) {
					if(event.getRawSlot() == i) {
						event.setCancelled(true);
						return;
					}
				}
				for(int i = 0; i <= 53; i++) {
					if(tinkererItems.contains("" + event.getRawSlot())) {
						event.setCancelled(true);
						if(event.getRawSlot() == 0) {
							if(event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE
									&& event.getCurrentItem().getItemMeta().hasDisplayName() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.AgreePanes.Name")))
									&& event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.AgreePanes.Lore")))) {
								event.setCancelled(true);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.Messages.TradeAccepted")));
								
								ItemStack agreePane = player.getOpenInventory().getItem(0);
								ItemMeta agreePaneMeta = agreePane.getItemMeta();
								agreePaneMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Trade Accepted.");
								agreePane.setItemMeta(agreePaneMeta);
								player.getOpenInventory().setItem(0, agreePane);
								
								player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 1);
								for(int o = 1; o <= 53; o++) {
									if(!(player.getOpenInventory().getItem(o) == null) && !(player.getOpenInventory().getItem(o).getType().equals(Material.AIR)) && !(player.getOpenInventory().getItem(o).getType().equals(Material.THIN_GLASS)) && !(player.getOpenInventory().getItem(o).getType().equals(Material.STAINED_GLASS_PANE))
											&& tinkererItems.contains("" + o)) {
										player.getInventory().addItem(player.getOpenInventory().getItem(o));
										player.updateInventory();
									}
								}
								player.closeInventory();
								return;
							} else {
								event.setCancelled(true);
								return;
							}
						} else {
							return;
						}
					} else if(!(player.getOpenInventory().getItem(i) == null) && !(player.getOpenInventory().getItem(i).getType().equals(Material.AIR) && !(player.getOpenInventory().getItem(i).getType().equals(Material.THIN_GLASS)))
							&& !(player.getOpenInventory().getItem(i).getType().equals(Material.STAINED_GLASS_PANE)) && event.getRawSlot() < 49) {
						player.getInventory().addItem(event.getCurrentItem());
						event.setCurrentItem(new ItemStack(Material.AIR));
						if(event.getRawSlot() < 4) {
							player.getOpenInventory().setItem(Math.addExact(event.getRawSlot(), 4), new ItemStack(Material.AIR));
						} else {
							player.getOpenInventory().setItem(Math.addExact(event.getRawSlot(), 5), new ItemStack(Material.AIR));
						}
						return;
					}
				}
				if(!(event.getCurrentItem().hasItemMeta()) || event.getRawSlot() == 8) {
					event.setCancelled(true);
					return;
				} else if(event.getRawSlot() > 53) {
					ItemStack tradeItem = event.getCurrentItem();
					event.setCancelled(true);
					if(event.getCurrentItem().getType().equals(Material.BOOK)) {
						item = new ItemStack(Material.FIREBALL, 1);
						if(EnchantBookNames.getLegendaryBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.LegendaryName")));
						} else if(EnchantBookNames.getUltimateBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.UltimateName")));
						} else if(EnchantBookNames.getEliteBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.EliteName")));
						} else if(EnchantBookNames.getUniqueBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.UniqueName")));
						} else if(EnchantBookNames.getSimpleBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.SimpleName")));
						} else {
							event.setCancelled(true);
							return;
						}
						event.setCurrentItem(new ItemStack(Material.AIR));
						for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust.Fireballs.Lore").size(); i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust.Fireballs.Lore").get(i)));
						}
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						
						for(int i = 1; i <= 48; i++) {
							if(player.getOpenInventory().getItem(i) == null || player.getOpenInventory().getItem(i).getType().equals(Material.AIR)) {
								player.getOpenInventory().setItem(i, tradeItem);
								if(i < 8) {
									player.getOpenInventory().setItem(Math.addExact(i, 4), item);
									player.updateInventory();
									return;
								} else {
									player.getOpenInventory().setItem(Math.addExact(i, 5), item);
									player.updateInventory();
									return;
								}
							}
						}
						player.updateInventory();
						return;
					} else {
						int experience = 0;
						for(int i = 0; i < EnchantBookLores.getLegendaryItemLores().size(); i++) {
							if(event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getLegendaryItemLores().get(i))) {
								experience = experience + RandomPackage.getTinkererConfig().getInt("TinkererExp.Legendary." + ChatColor.stripColor(EnchantBookLores.getLegendaryItemLores().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "").replace(" ", "")));
							}
						}
						for(int i = 0; i < EnchantBookLores.getUltimateItemLores().size(); i++) {
							if(event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUltimateItemLores().get(i))) {
								experience = experience + RandomPackage.getTinkererConfig().getInt("TinkererExp.Ultimate." + ChatColor.stripColor(EnchantBookLores.getUltimateItemLores().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "").replace(" ", "")));
							}
						}
						for(int i = 0; i < EnchantBookLores.getEliteItemLores().size(); i++) {
							if(event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getEliteItemLores().get(i))) {
								experience = experience + RandomPackage.getTinkererConfig().getInt("TinkererExp.Elite." + ChatColor.stripColor(EnchantBookLores.getEliteItemLores().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "").replace(" ", "")));
							}
						}
						for(int i = 0; i < EnchantBookLores.getUniqueItemLores().size(); i++) {
							if(event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUniqueItemLores().get(i))) {
								experience = experience + RandomPackage.getTinkererConfig().getInt("TinkererExp.Unique." + ChatColor.stripColor(EnchantBookLores.getUniqueItemLores().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "").replace(" ", "")));
							}
						}
						for(int i = 0; i < EnchantBookLores.getSimpleItemLores().size(); i++) {
							if(event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSimpleItemLores().get(i))) {
								experience = experience + RandomPackage.getTinkererConfig().getInt("TinkererExp.Simple." + ChatColor.stripColor(EnchantBookLores.getSimpleItemLores().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "").replace(" ", "")));
							}
						}
						
						event.setCurrentItem(new ItemStack(Material.AIR));
						
						item = new ItemStack(Material.EXP_BOTTLE, 1);
						if(!(Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw") == null)) {
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("BottleName")));
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("Value").replace("%value%", "" + experience)));
							lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("BottleEnchanter").replace("%player%", "Tinkerer")));
						} else {
							itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Experience Bottle " + ChatColor.GRAY + "(Throw)");
							lore.add(ChatColor.LIGHT_PURPLE + "Value " + ChatColor.RESET + experience + " XP");
							lore.add(ChatColor.LIGHT_PURPLE + "Enchanter " + ChatColor.RESET + "Tinkerer");
							lore.add(ChatColor.RED + "Download Beast-XpWithdraw to get the full amount of XP");
						}
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						for(int i = 1; i <= 48; i++) {
							if(player.getOpenInventory().getItem(i) == null || player.getOpenInventory().getItem(i).getType().equals(Material.AIR)) {
								player.getOpenInventory().setItem(i, tradeItem);
								if(i < 8) {
									player.getOpenInventory().setItem(Math.addExact(i, 4), item);
									player.updateInventory();
									return;
								} else {
									player.getOpenInventory().setItem(Math.addExact(i, 5), item);
									player.updateInventory();
									return;
								}
							}
						}
						player.updateInventory();
						return;
					}
				} else {
					player.sendMessage(ChatColor.RED + "Tell RandomHashTags how you got this message ASAP");
					event.setCancelled(true);
					return;
				}
			}
		}
	}
	@EventHandler
	private void inventoryCloseEvent(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.ChestName")))
				&& !(event.getInventory().getItem(0).getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Trade Accepted."))) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Tinkerer.Messages.TradeCancelled")));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 2);
			for(int i = 1; i < 48; i++) {
				if(!(tinkererItems.contains("" + i)) && !(player.getOpenInventory().getItem(i) == null) && !(player.getOpenInventory().getItem(i).getType().equals(Material.AIR)) && !(player.getOpenInventory().getItem(i).getType().equals(Material.THIN_GLASS))
						&& !(player.getOpenInventory().getItem(i).getType().equals(Material.STAINED_GLASS_PANE))) {
					player.getInventory().addItem(player.getOpenInventory().getItem(i));
					player.updateInventory();
				}
			}
			return;
		} else {
			return;
		}
	}
}