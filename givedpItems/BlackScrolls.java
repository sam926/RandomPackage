package me.randomHashTags.randomPackage.givedpItems;

import java.util.ArrayList;
import java.util.List;
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
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantType;

public class BlackScrolls implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null || !(event.getCurrentItem().hasItemMeta()) || !(event.getCurrentItem().getItemMeta().hasLore())
				|| !(event.getCursor().getType() == Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.Item").toUpperCase()))
				|| event.getCursor().getType() == Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.Item").toUpperCase())
				&& event.getCurrentItem().getType() == Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("BlackScrolls.Item").toUpperCase())
				|| !(event.getCursor().hasItemMeta()) || !(event.getCursor().getItemMeta().hasDisplayName()) || !(event.getCursor().getItemMeta().hasLore())) {
			return;
		} else {
			ItemStack currentItem = event.getCurrentItem();
			ItemMeta currentItemMeta = currentItem.getItemMeta();
			List<String> currentItemLore = event.getCurrentItem().getItemMeta().getLore();
			Player player = (Player) event.getWhoClicked();
			String enchant = null, type = null;
			ArrayList<String> lore = new ArrayList<String>();
			ItemStack book = new ItemStack(Material.BOOK, 1);
			ItemMeta bookMeta = book.getItemMeta();
			
			Random random = new Random();
			int randomSlot = random.nextInt(event.getCurrentItem().getItemMeta().getLore().size());
			
			for(int o = 50; o <= 100; o++) {
				if(event.getCursor().getItemMeta().getLore().get(2).contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("BlackScrolls.Lore").get(2).replace("%percent%", "" + o)))) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + o)));
				}
			}
			
			lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy").replace("%destroy%", "" + 100)));
			for(int i = 0; i <= 100; i++) {
				if(i < EnchantBookLores.getSoulItemLores().size() && EnchantBookLores.getSoulItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getSoulBookNames().get(i); type = "Soul";
				} else if(i < EnchantBookLores.getLegendaryItemLores().size() && EnchantBookLores.getLegendaryItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getLegendaryBookNames().get(i); type = "Legendary";
				} else if(i < EnchantBookLores.getUltimateItemLores().size() && EnchantBookLores.getUltimateItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getUltimateBookNames().get(i); type = "Ultimate";
				} else if(i < EnchantBookLores.getEliteItemLores().size() && EnchantBookLores.getEliteItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getEliteBookNames().get(i); type = "Elite";
				} else if(i < EnchantBookLores.getUniqueItemLores().size() && EnchantBookLores.getUniqueItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getUniqueBookNames().get(i); type = "Unique";
				} else if(i < EnchantBookLores.getSimpleItemLores().size() && EnchantBookLores.getSimpleItemLores().get(i).equalsIgnoreCase(event.getCurrentItem().getItemMeta().getLore().get(randomSlot))) {
					enchant = EnchantBookNames.getSimpleBookNames().get(i); type = "Simple";
				} else if(i == 100 && enchant == null) {
					player.sendMessage("          " + event.getCurrentItem().getItemMeta().getLore().get(randomSlot));
					player.sendMessage(ChatColor.BLUE + "RandomPackage> " + ChatColor.GRAY + "This enchant is currently disabled");
					return;
				}
			}
			for(int i = 0; i < RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + type + "." + ChatColor.stripColor(enchant).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore").size(); i++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + type + "." + ChatColor.stripColor(enchant).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "") + ".BookLore").get(i)));
			}
			bookMeta.setDisplayName(enchant);
			
			if(EnchantType.getArmorEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
			} else if(EnchantType.getAxeEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
			} else if(EnchantType.getBootEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
			} else if(EnchantType.getBowEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
			} else if(EnchantType.getChestplateEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
			} else if(EnchantType.getHelmetEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
			} else if(EnchantType.getLeggingsEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
			} else if(EnchantType.getPickaxeEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
			} else if(EnchantType.getShovelEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
			} else if(EnchantType.getSwordEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
			} else if(EnchantType.getToolEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
			} else if(EnchantType.getWeaponEnchants().contains(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(randomSlot).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", "")))) { lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
			} else { lore.add(ChatColor.GRAY + "Unknown Enchant"); player.sendMessage(event.getCursor().getItemMeta().getDisplayName()); player.sendMessage(ChatColor.RED + "Send this to RandomHashTags ASAP"); }
			lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
			bookMeta.setLore(lore);
			book.setItemMeta(bookMeta);
			
			player.getInventory().addItem(book);
			
			currentItemLore.remove(randomSlot);
			currentItemMeta.setLore(currentItemLore);
			currentItem.setItemMeta(currentItemMeta);
			event.setCurrentItem(currentItem);
			
			if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1); } else { event.setCursor(new ItemStack(Material.AIR)); }
			
			event.setCancelled(true);
			for(int i = 1; i <= 15; i++) {
				player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1);
			}
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2);
			
			player.updateInventory();
			return;
		}
	}
}