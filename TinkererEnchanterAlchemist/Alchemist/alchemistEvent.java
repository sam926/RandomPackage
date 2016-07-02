package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Alchemist;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantType;

public class alchemistEvent implements Listener {
	private String dust = null;
	private ArrayList<String> price = new ArrayList<String>();
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getCurrentItem() == null
				|| !(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("ChestName"))))) {
			return;
		} else {
			if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Legendary.DustName")))
					|| event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Legendary.PrimalName")))
					|| !(event.getCurrentItem().hasItemMeta()) || !(event.getCurrentItem().getItemMeta().hasDisplayName()) || !(event.getCurrentItem().getItemMeta().hasLore())) { event.setCancelled(true); return; }
			ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			if(event.getRawSlot() == 3 && !(player.getOpenInventory().getItem(3).getType() == Material.AIR) && player.getOpenInventory().getItem(3).hasItemMeta()
					|| event.getRawSlot() == 5 && !(player.getOpenInventory().getItem(5).getType() == Material.AIR)) {
				for(int i = 0; i < price.size(); i++) {
					if(price.get(i).startsWith(player.getName())) {
						price.remove(i);
					}
				}
				player.getInventory().addItem(player.getOpenInventory().getItem(event.getRawSlot()));
				event.setCurrentItem(new ItemStack(Material.AIR));
				event.setCancelled(true);
				
				lore.clear();
				
				item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Preview.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Preview.Data"));
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Preview.Name")));
				for(int i = 0; i < RandomPackage.getAlchemistConfig().getStringList("Gui.Preview.Lore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Preview.Lore").get(i)));
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				player.getOpenInventory().setItem(13, item);
				
				item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Exchange.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Exchange.Data"));
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Exchange.Name")));
				for(int i = 0; i < RandomPackage.getAlchemistConfig().getStringList("Gui.Exchange.Lore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Exchange.Lore").get(i)));
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				player.getOpenInventory().setItem(22, item);
				player.updateInventory();
				return;
			} else if(event.getRawSlot() == 13) { event.setCancelled(true); return;
			} else if(event.getRawSlot() == 22) {
				if(player.getOpenInventory().getItem(3).getType() == Material.AIR || player.getOpenInventory().getItem(5).getType() == Material.AIR) { event.setCancelled(true); return;
				} else {
					int cost = 0;
					for(int i = 0; i < price.size(); i++) {
						if(price.get(i).startsWith(player.getName())) {
							cost = Integer.parseInt(price.get(i).replace(player.getName() + "_", ""));
							price.remove(i);
						}
					}
					if(!(player.getTotalExperience() >= cost)) {
						event.setCancelled(true);
						player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 2);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Messages.NeedMoreXp")));
						player.closeInventory();
						return;
					} else {
						event.setCancelled(true);
						
						int experience = player.getTotalExperience() - cost;
						player.setTotalExperience(0); player.setExp(0); player.setLevel(0); player.giveExp(experience);
						
						player.getInventory().addItem(player.getOpenInventory().getItem(13));
						player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 1);
						player.updateInventory();
						player.getOpenInventory().setItem(22, new ItemStack(Material.GOLDEN_APPLE, 1));
						player.closeInventory();
						Random random = new Random();
						for(int i = 1; i <= 50; i++) {
							player.getWorld().playEffect(new Location(player.getWorld(), player.getLocation().getX() + random.nextDouble(), player.getLocation().getY() + + random.nextDouble(), player.getLocation().getZ() + random.nextDouble()), Effect.HAPPY_VILLAGER, 1);
						}
						player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1, 1);
						return;
					}
				}
			} else if(event.getRawSlot() > 27 && event.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)) { event.setCancelled(true); return; } else {
				if(event.getCurrentItem().getType().equals(Material.BOOK) && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
					if(!(player.getOpenInventory().getItem(3).getType() == Material.AIR) && player.getOpenInventory().getItem(5).getType() == Material.AIR
							&& player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCurrentItem().getAmount() == 1) {
						player.getOpenInventory().setItem(5, event.getCurrentItem());
						
						int success = 0, destroy = 0;
						for(int i = 0; i <= 100; i++) {
							if(player.getOpenInventory().getItem(3).getItemMeta().getLore().get(0).equals(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + i)))) { success = i; }
							if(player.getOpenInventory().getItem(3).getItemMeta().getLore().get(1).equals(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "" + i)))) { destroy = i; }
						}
						for(int i = 0; i <= 100; i++) {
							if(player.getOpenInventory().getItem(5).getItemMeta().getLore().get(0).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + i)))) { success = (success / 4) + (i / 4); }
							if(player.getOpenInventory().getItem(5).getItemMeta().getLore().get(1).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "" + i)))) {
								if(i > destroy) { destroy = (i + destroy) / 4 + i; } else { destroy = (i + destroy) / 4 + destroy; }
							}
						}
						if(destroy > 100) { destroy = 100; }
						String enchantName = null, rarity = null;
						for(int i = 0; i <= 100; i++) {
							if(i < EnchantBookNames.getLegendaryBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getLegendaryBookNames().size() && EnchantBookNames.getLegendaryBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& EnchantBookNames.getLegendaryBookNames().get(Math.addExact(i, 1)).startsWith(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
								enchantName = EnchantBookNames.getLegendaryBookNames().get(Math.addExact(i, 1)); rarity = "Legendary";
							} else if(i < EnchantBookNames.getUltimateBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getUltimateBookNames().size() && EnchantBookNames.getUltimateBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& EnchantBookNames.getUltimateBookNames().get(Math.addExact(i, 1)).startsWith(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
								enchantName = EnchantBookNames.getUltimateBookNames().get(Math.addExact(i, 1)); rarity = "Ultimate";
							} else if(i < EnchantBookNames.getEliteBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getEliteBookNames().size() && EnchantBookNames.getEliteBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& EnchantBookNames.getEliteBookNames().get(Math.addExact(i, 1)).startsWith(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
								enchantName = EnchantBookNames.getEliteBookNames().get(Math.addExact(i, 1)); rarity = "Elite";
							} else if(i < EnchantBookNames.getUniqueBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getUniqueBookNames().size() && EnchantBookNames.getUniqueBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& EnchantBookNames.getUniqueBookNames().get(Math.addExact(i, 1)).startsWith(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
								enchantName = EnchantBookNames.getUniqueBookNames().get(Math.addExact(i, 1)); rarity = "Unique";
							} else if(i < EnchantBookNames.getSimpleBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getSimpleBookNames().size() && EnchantBookNames.getSimpleBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& EnchantBookNames.getSimpleBookNames().get(Math.addExact(i, 1)).startsWith(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
								enchantName = EnchantBookNames.getSimpleBookNames().get(Math.addExact(i, 1)); rarity = "Simple";
							} else if(i == 100 && enchantName == null) { event.setCancelled(true); return; }
						}
						item = new ItemStack(Material.BOOK, 1);
						itemMeta.setDisplayName(enchantName);
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + success)));
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "" + destroy)));
						
						for(int i = 0; i < RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + rarity + "." + ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "") + ".BookLore").size(); i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + rarity + "." + ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "") + ".BookLore").get(i)));
						}
						
						if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(enchantName.replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
						} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
						} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
						} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
						} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
						} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
						} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
						} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
						} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
						} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
						} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
						} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(enchantName).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""))) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
						} else { return; }
						
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						player.getOpenInventory().setItem(13, item);
						
						lore.clear();
						int xpCost = 0;
						if(EnchantBookNames.getSoulBookNames().contains(event.getCurrentItem())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.SoulCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Soul." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));;
						} else if(EnchantBookNames.getLegendaryBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.LegendaryCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Legendary." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));;
						} else if(EnchantBookNames.getUltimateBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.UltimateCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Ultimate." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));;
						} else if(EnchantBookNames.getEliteBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.EliteCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Elite." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));;
						} else if(EnchantBookNames.getUniqueBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.UniqueCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Unique." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));
						} else if(EnchantBookNames.getSimpleBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
							xpCost = xpCost + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.SimpleCost") + RandomPackage.getAlchemistConfig().getInt("BookUpgrade.Simple." + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "10").replace(" VIII", "9").replace(" VII", "8").replace(" VI", "7").replace(" V", "6").replace(" IV", "5").replace(" III", "4").replace(" II", "3").replace(" I", "2")));
						} else { return; }
						item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Accept.Item").toUpperCase()), 1, (byte) RandomPackage.getAlchemistConfig().getInt("Gui.Accept.Data"));
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Accept.Name")));
						for(int i = 0; i < RandomPackage.getAlchemistConfig().getStringList("Gui.Accept.Lore").size(); i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Accept.Lore").get(i).replace("%cost%", "" + xpCost)));
							price.add(player.getName() + "_" + xpCost);
						}
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						player.getOpenInventory().setItem(22, item);
						
						event.setCurrentItem(new ItemStack(Material.AIR));
					} else if(player.getOpenInventory().getItem(3).getType() == Material.AIR && player.getOpenInventory().getItem(5).getType() == Material.AIR) {
						for(int i = 0; i < 100; i++) {
							if(i < EnchantBookNames.getLegendaryBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getLegendaryBookNames().size() && EnchantBookNames.getLegendaryBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& !(EnchantBookNames.getLegendaryBookNames().get(Math.addExact(i, 1)).startsWith(EnchantBookNames.getLegendaryBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))
									|| i < EnchantBookNames.getUltimateBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getUltimateBookNames().size() && EnchantBookNames.getUltimateBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& !(EnchantBookNames.getUltimateBookNames().get(Math.addExact(i, 1)).startsWith(EnchantBookNames.getUltimateBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))
									|| i < EnchantBookNames.getEliteBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getEliteBookNames().size() && EnchantBookNames.getEliteBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& !(EnchantBookNames.getEliteBookNames().get(Math.addExact(i, 1)).startsWith(EnchantBookNames.getEliteBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))
									|| i < EnchantBookNames.getUniqueBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getUniqueBookNames().size() && EnchantBookNames.getUniqueBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& !(EnchantBookNames.getUniqueBookNames().get(Math.addExact(i, 1)).startsWith(EnchantBookNames.getUniqueBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))
									|| i < EnchantBookNames.getSimpleBookNames().size() && Math.addExact(i, 1) < EnchantBookNames.getSimpleBookNames().size() && EnchantBookNames.getSimpleBookNames().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())
									&& !(EnchantBookNames.getSimpleBookNames().get(Math.addExact(i, 1)).startsWith(EnchantBookNames.getSimpleBookNames().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))) {
								event.setCancelled(true);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Messages.AlchemistMaxEnchants")));
								return;
							}
						}
						player.getOpenInventory().setItem(3, event.getCurrentItem());
						event.setCurrentItem(new ItemStack(Material.AIR));
					} else { event.setCancelled(true); }
					player.updateInventory();
					return;
				} else if(event.getCurrentItem().getType().equals(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()))
						&& event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName() && event.getCurrentItem().getItemMeta().hasLore()) {
					dust = "Dust";
				} else if(event.getCurrentItem().getType().equals(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.PrimalItem").toUpperCase()))
						&& event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName() && event.getCurrentItem().getItemMeta().hasLore()) {
					dust = "Primal";
				} else { event.setCancelled(true); return; }
				if(!(dust == null)) {
					if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getAmount() == 1) {
						if(player.getOpenInventory().getItem(3).getType() == Material.AIR) {
							player.getOpenInventory().setItem(3, event.getCurrentItem()); event.setCurrentItem(new ItemStack(Material.AIR)); return;
						} else if(player.getOpenInventory().getItem(5).getType() == Material.AIR && player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equals(event.getCurrentItem().getItemMeta().getDisplayName())) {
							player.getOpenInventory().setItem(5, event.getCurrentItem()); event.setCurrentItem(new ItemStack(Material.AIR));
							
							String upgrade = null, previous = null;
							item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust." + dust + "Item").toUpperCase()));
							if(player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Ultimate." + dust + "Name")))
									&& player.getOpenInventory().getItem(5).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Ultimate." + dust + "Name")))) {
								upgrade = "Legendary"; previous = "Ultimate";
							} else if(player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Elite." + dust + "Name")))
									&& player.getOpenInventory().getItem(5).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Elite." + dust + "Name")))) {
								upgrade = "Ultimate"; previous = "Elite";
							} else if(player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Unique." + dust + "Name")))
									&& player.getOpenInventory().getItem(5).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Unique." + dust + "Name")))) {
								upgrade = "Elite"; previous = "Unique";
							} else if(player.getOpenInventory().getItem(3).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Simple." + dust + "Name")))
									&& player.getOpenInventory().getItem(5).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Simple." + dust + "Name")))) {
								upgrade = "Unique"; previous = "Simple";
							} else { event.setCancelled(true); return; }
							
							int success = 0;
							for(int i = 0; i <= 30; i++) {
								if(player.getOpenInventory().getItem(3).getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + previous + "." + dust + "Lore").get(0).replace("%percent%", "" + i)))) {
									success = success + i;
								}
								if(player.getOpenInventory().getItem(5).getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + previous + "." + dust + "Lore").get(0).replace("%percent%", "" + i)))) {
									success = success + i;
								}
							}
							success = success / 2;
							
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust." + upgrade + "." + dust + "Name")));
							for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust." + upgrade + "." + dust + "Lore").size(); i++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + upgrade + "." + dust + "Lore").get(i).replace("%percent%", "" + success)));
							}
							itemMeta.setLore(lore);
							item.setItemMeta(itemMeta);
							
							player.getOpenInventory().setItem(13, item);
							
							lore.clear();
							
							item = new ItemStack(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Accept.Item").toUpperCase()));
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Accept.Name")));
							
							int cost = RandomPackage.getAlchemistConfig().getInt("DustUpgrade." + upgrade + dust);
							
							for(int i = 0; i < RandomPackage.getAlchemistConfig().getStringList("Gui.Accept.Lore").size(); i++) {
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getStringList("Gui.Accept.Lore").get(i).replace("%cost%", "" + cost)));
							}
							price.add(player.getName() + "_" + cost);
							itemMeta.setLore(lore);
							item.setItemMeta(itemMeta);
							player.getOpenInventory().setItem(22, item);
							return;
						} else {
							event.setCancelled(true);
							return;
						}
					} else { event.setCancelled(true); return; }
				} else {
					event.setCancelled(true);
					return;
				}
			}
		}
	}
	@EventHandler
	private void inventoryCloseEvent(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		if(!(player.getOpenInventory().getTitle() == null)
				&& player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("ChestName")))
				&& !(player.getOpenInventory().getItem(22).getType().equals(Material.getMaterial(RandomPackage.getAlchemistConfig().getString("Gui.Preview.Item").toUpperCase())))
				&& player.getOpenInventory().getItem(22).hasItemMeta() && player.getOpenInventory().getItem(22).getItemMeta().hasDisplayName()
				&& player.getOpenInventory().getItem(22).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getAlchemistConfig().getString("Gui.Preview.Name")))
				|| player.getOpenInventory().getItem(22) == new ItemStack(Material.GOLDEN_APPLE, 1)) {
			if(!(player.getOpenInventory().getItem(3) == null)) { player.getInventory().addItem(player.getOpenInventory().getItem(3)); }
			if(!(player.getOpenInventory().getItem(5) == null)) { player.getInventory().addItem(player.getOpenInventory().getItem(5)); }
			player.updateInventory();
			return;
		} else { return; }
	}
}
