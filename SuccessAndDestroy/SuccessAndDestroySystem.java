package me.randomHashTags.randomPackage.RandomArmorEffects.SuccessAndDestroy;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookLores;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;

public class SuccessAndDestroySystem implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null
				|| event.getCursor() == null
				|| !(event.getCursor().getType() == Material.BOOK)
				|| !(event.getCursor().hasItemMeta())
				|| !(event.getCursor().getItemMeta().hasLore())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			if(event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor"))) && event.getCurrentItem().getType().name().endsWith("HELMET")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor"))) && event.getCurrentItem().getType().name().endsWith("CHESTPLATE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor"))) && event.getCurrentItem().getType().name().endsWith("LEGGINGS")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor"))) && event.getCurrentItem().getType().name().endsWith("BOOTS")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet"))) && event.getCurrentItem().getType().name().endsWith("HELMET")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate"))) && event.getCurrentItem().getType().name().endsWith("CHESTPLATE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings"))) && event.getCurrentItem().getType().name().endsWith("LEGGINGS")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot"))) && event.getCurrentItem().getType().name().endsWith("BOOTS")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword"))) && event.getCurrentItem().getType().name().endsWith("SWORD")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe"))) && event.getCurrentItem().getType().name().endsWith("_AXE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon"))) && event.getCurrentItem().getType().name().endsWith("SWORD")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon"))) && event.getCurrentItem().getType().name().endsWith("_AXE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow"))) && event.getCurrentItem().getType() == Material.BOW
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe"))) && event.getCurrentItem().getType().name().endsWith("PICKAXE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool"))) && event.getCurrentItem().getType().name().endsWith("HOE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool"))) && event.getCurrentItem().getType().name().endsWith("AXE")
					|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool"))) && event.getCurrentItem().getType().name().endsWith("SPADE")) {
				
				if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()) {
					int levelcap = 0;
					for(int i = 0; i < EnchantBookLores.getLegendaryItemLores().size(); i++) {
						if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getLegendaryItemLores().get(i))) {
							levelcap = levelcap + 1;
						}
					}
					for(int i = 0; i < EnchantBookLores.getUltimateItemLores().size(); i++) {
						if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUltimateItemLores().get(i))) {
							levelcap = levelcap + 1;
						}
					}
					for(int i = 0; i < EnchantBookLores.getEliteItemLores().size(); i++) {
						if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getEliteItemLores().get(i))) {
							levelcap = levelcap + 1;
						}
					}
					for(int i = 0; i < EnchantBookLores.getUniqueItemLores().size(); i++) {
						if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUniqueItemLores().get(i))) {
							levelcap = levelcap + 1;
						}
					}
					for(int i = 0; i < EnchantBookLores.getSimpleItemLores().size(); i++) {
						if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSimpleItemLores().get(i))) {
							levelcap = levelcap + 1;
						}
					}
					if(!(event.getWhoClicked().isOp()) && levelcap + 1 >= RandomPackage.getPlugin().getConfig().getInt("EnchantmentOptions.DefaultEnchantCap")
							|| event.getWhoClicked().isOp() && levelcap + 1 >= RandomPackage.getPlugin().getConfig().getInt("EnchantmentOptions.OpEnchantCap")) {
						return;
					}
				}
				
				Random random = new Random();
				int success = 0, destroy = 0, enchantAmount = 0;
				boolean hasSameEnchant = false, hasSoulTracker = false, isTransmogScrolled = false;
				String lowerEnchant = null;
				
				ItemStack currentItem = event.getCurrentItem();
				ItemMeta currentItemMeta = currentItem.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				
				String enchant = null;
				for(int i = 0; i <= 100; i++) {
					if(event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + i)))) {
						success = i;
					}
					if(event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "" + i)))) {
						destroy = i;
					}
				}
				for(int i = 0; i <= 100; i++) {
					if(i < EnchantBookNames.getSoulBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getSoulBookNames().get(i))) {
						enchant = EnchantBookNames.getSoulBookNames().get(i);
					} else if(i < EnchantBookNames.getLegendaryBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getLegendaryBookNames().get(i))) {
						enchant = EnchantBookLores.getLegendaryItemLores().get(i);
					} else if(i < EnchantBookNames.getUltimateBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUltimateBookNames().get(i))) {
						enchant = EnchantBookLores.getUltimateItemLores().get(i);
					} else if(i < EnchantBookNames.getEliteBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getEliteBookNames().get(i))) {
						enchant = EnchantBookLores.getEliteItemLores().get(i);
					} else if(i < EnchantBookNames.getUniqueBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUniqueBookNames().get(i))) {
						enchant = EnchantBookLores.getUniqueItemLores().get(i);
					} else if(i < EnchantBookNames.getSimpleBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getSimpleBookNames().get(i))) {
						enchant = EnchantBookLores.getSimpleItemLores().get(i);
					}
				}
				for(int i = 0; i <= 100; i++) {
					if(i < EnchantBookLores.getSoulItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSoulItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
					if(i < EnchantBookLores.getLegendaryItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getLegendaryItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
					if(i < EnchantBookLores.getUltimateItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUltimateItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
					if(i < EnchantBookLores.getEliteItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getEliteItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
					if(i < EnchantBookLores.getUniqueItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUniqueItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
					if(i < EnchantBookLores.getSimpleItemLores().size() && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()
							&& event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSimpleItemLores().get(i))) {
						enchantAmount = enchantAmount + 1;
					}
				}
				if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()) {
					for(int i = 0; i < event.getCurrentItem().getItemMeta().getLore().size(); i++) {
						if(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(i).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")).startsWith(ChatColor.stripColor(event.getCursor().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")))) {
							int bookLevel = 0;
							int enchantLevel = 0;
							int enchantSlot = 0;
							for(int o = 1; o <= 10; o++) {
								if(event.getCursor().getItemMeta().getDisplayName().replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "1").endsWith("" + o)) {
									bookLevel = o;
								}
								if(event.getCurrentItem().getItemMeta().getLore().get(i).replace(" X", "10").replace(" IX", "9").replace(" VIII", "8").replace(" VII", "7").replace(" VI", "6").replace(" V", "5").replace(" IV", "4").replace(" III", "3").replace(" II", "2").replace(" I", "1").endsWith("" + o)) {
									enchantLevel = o;
									enchantSlot = i;
								}
							}
							lowerEnchant = event.getCurrentItem().getItemMeta().getLore().get(enchantSlot);
							if(bookLevel <= enchantLevel) {
								String rarity = null;
								String enchantBookName = null;
								for(int p = 0; p <= 100; p++) {
									if(p < EnchantBookLores.getSoulItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getSoulItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getSoulItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getSoulItemLores().get(Math.addExact(p, 1)); rarity = "Soul";
									} else if(p < EnchantBookLores.getLegendaryItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getLegendaryItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getLegendaryItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getLegendaryItemLores().get(Math.addExact(p, 1)); rarity = "Legendary";
									} else if(p < EnchantBookLores.getUltimateItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getUltimateItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getUltimateItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getUltimateItemLores().get(Math.addExact(p, 1)); rarity = "Ultimate";
									} else if(p < EnchantBookLores.getEliteItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getEliteItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getEliteItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getEliteItemLores().get(Math.addExact(p, 1)); rarity = "Elite";
									} else if(p < EnchantBookLores.getUniqueItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getUniqueItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getUniqueItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getUniqueItemLores().get(Math.addExact(p, 1)); rarity = "Unique";
									} else if(p < EnchantBookLores.getSimpleItemLores().size() && event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).equalsIgnoreCase(EnchantBookLores.getSimpleItemLores().get(p))
											&& event.getCurrentItem().getItemMeta().getLore().get(enchantSlot).startsWith(EnchantBookLores.getSimpleItemLores().get(Math.addExact(p, 1)).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", ""))) {
										enchant = EnchantBookLores.getSimpleItemLores().get(Math.addExact(p, 1)); rarity = "Simple";
									}
								}
								if(!(enchant == null)) { hasSameEnchant = true; enchantBookName = ChatColor.stripColor(event.getCursor().getItemMeta().getDisplayName().replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "")); } else { player.sendMessage("returned 1"); return; }
								if(RandomPackage.getPlugin().getConfig().getString("Enchantments." + rarity + "." + enchantBookName + "." + enchantBookName + Math.addExact(enchantLevel, 1) + ".ItemLore") == null) { return; }
							} else {
								for(int p = 0; p <= 100; p++) {
									if(p < EnchantBookNames.getSoulBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getSoulBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getSoulItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getSoulBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getSoulItemLores().get(p);
									} else if(p < EnchantBookNames.getLegendaryBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getLegendaryBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getLegendaryItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getLegendaryItemLores().get(p);
									} else if(p < EnchantBookNames.getUltimateBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUltimateBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getUltimateItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getUltimateItemLores().get(p);
									} else if(p < EnchantBookNames.getEliteBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getEliteBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getEliteItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getEliteItemLores().get(p);
									} else if(p < EnchantBookNames.getUniqueBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getUniqueBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getUniqueItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getUniqueItemLores().get(p);
									} else if(p < EnchantBookNames.getSimpleBookNames().size() && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(EnchantBookNames.getSimpleBookNames().get(p))
											&& ChatColor.stripColor(EnchantBookLores.getSimpleItemLores().get(p)).startsWith(ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(p).replace(" X", "").replace(" IX", "").replace("VIII", "").replace("VII", "").replace("VI", "").replace("V", "").replace("IV", "").replace("III", "").replace("II", "").replace("I", "")))) {
										enchant = EnchantBookLores.getSimpleItemLores().get(p);
									}
									if(!(enchant == null)) { hasSameEnchant = true; } else { player.sendMessage("returned 2"); return; }
								}
							}
						}
					}
				}
				int previousLoreCount = 0;
				if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
					for(int i = 0; i <= 15; i++) {
						if(event.getCurrentItem().getItemMeta().getDisplayName().endsWith(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount").replace("%loreCount%", "" + i)))) {
							isTransmogScrolled = true;
							previousLoreCount = i;
						}
					}
				}
				
				String soulTracker = null;
				if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()) {
					for(int i = 0; i < event.getCurrentItem().getItemMeta().getLore().size(); i++) {
						for(int o = 0; o <= 100; o++) {
							if(event.getCurrentItem().getItemMeta().getLore().get(i).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + i)))
									|| event.getCurrentItem().getItemMeta().getLore().get(i).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + i)))
									|| event.getCurrentItem().getItemMeta().getLore().get(i).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + i)))
									|| event.getCurrentItem().getItemMeta().getLore().get(i).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + i)))
									|| event.getCurrentItem().getItemMeta().getLore().get(i).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + i)))) {
								hasSoulTracker = true;
								soulTracker = event.getCurrentItem().getItemMeta().getLore().get(i);
							}
						}
					}
				}
				
				if(enchant == null) { return;
				} else {
					boolean hasWhiteScroll = false; if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED")) { hasWhiteScroll = true; }
					if(random.nextInt(100) <= success) {
						if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()) { lore.addAll(event.getCurrentItem().getItemMeta().getLore()); }
						if(hasSameEnchant == true) { lore.remove(lowerEnchant); }
						if(hasWhiteScroll == true) { lore.remove(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED"); }
						if(hasSoulTracker == true) { lore.remove(soulTracker); }
						lore.add(enchant);
						if(hasWhiteScroll == true) { lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED"); hasWhiteScroll = false; }
						if(hasSoulTracker == true) { lore.add(soulTracker); }
						
						currentItemMeta.setLore(lore);
						if(isTransmogScrolled == true) { currentItemMeta.setDisplayName(event.getCurrentItem().getItemMeta().getDisplayName().replace(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount")).replace("%loreCount%", "" + previousLoreCount), ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount")).replace("%loreCount%", "" + Math.addExact(previousLoreCount, 1)))); }
						currentItem.setItemMeta(currentItemMeta);
						event.setCurrentItem(currentItem);
						if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1); } else { event.setCursor(new ItemStack(Material.AIR)); }
						event.setCancelled(true);
						player.updateInventory();
						for(int i = 1; i <= 15; i++) {
							player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1);
						}
						player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2);
						hasWhiteScroll = false; hasSameEnchant = false;
						return;
					} else if(random.nextInt(100) <= destroy) {
						if(hasWhiteScroll == true) {
							lore.addAll(event.getCurrentItem().getItemMeta().getLore());
							lore.remove(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED");
							currentItemMeta.setLore(lore);
							currentItem.setItemMeta(currentItemMeta);
							event.setCurrentItem(currentItem);
							event.setCancelled(true);
						} else {
							event.setCurrentItem(new ItemStack(Material.AIR));
						}
						player.updateInventory();
						for(int i = 1; i <= 15; i++) {
							player.getWorld().playEffect(player.getEyeLocation(), Effect.LAVA_POP, 1);
						}
						if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1); } else { event.setCursor(new ItemStack(Material.AIR)); }
						player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
						hasWhiteScroll = false; hasSameEnchant = false;
						return;
					} else {
						if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1); } else { event.setCursor(new ItemStack(Material.AIR)); }
						event.setCancelled(true);
						player.updateInventory();
						for(int i = 1; i <= 15; i++) {
							player.getWorld().playEffect(player.getEyeLocation(), Effect.LAVA_POP, 1);
						}
						player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
						hasWhiteScroll = false; hasSameEnchant = false;
						return;
					}
				}
			} else { return; }
		}
	}
}
