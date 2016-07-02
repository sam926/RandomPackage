package me.randomHashTags.randomPackage.givedpItems;

import java.util.ArrayList;
import java.util.List;

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

public class TransmogScrolls implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.getCurrentItem() == null
				|| !(event.getCurrentItem().hasItemMeta())
				|| !(event.getCurrentItem().getItemMeta().hasLore())) {
			return;
		} else {
			if(!(event.getCursor().getType().name().endsWith(RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Item").toUpperCase()))
					|| event.getCurrentItem().getType().name().endsWith(RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Item").toUpperCase())
					&& event.getCursor().getType().name().endsWith(RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Item").toUpperCase())
					|| !(event.getCursor().hasItemMeta())
					|| !(event.getCursor().getItemMeta().hasDisplayName())
					|| !(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Name"))))
					|| !(event.getCursor().getItemMeta().hasLore())
					|| !(event.getCurrentItem().getType().name().endsWith("SWORD")) && !(event.getCurrentItem().getType().name().endsWith("AXE")) && !(event.getCurrentItem().getType().name().endsWith("SPADE"))
					&& !(event.getCurrentItem().getType().name().endsWith("PICKAXE")) && !(event.getCurrentItem().getType().name().endsWith("BOW")) && !(event.getCurrentItem().getType().name().endsWith("HELMET"))
					&& !(event.getCurrentItem().getType().name().endsWith("CHESTPLATE")) && !(event.getCurrentItem().getType().name().endsWith("LEGGINGS")) && !(event.getCurrentItem().getType().name().endsWith("BOOTS"))) {
				return;
			} else {
				for(int i = 1; i <= 15; i++) {
					if(event.getCurrentItem().hasItemMeta()
					&& event.getCurrentItem().getItemMeta().hasDisplayName()
					&& event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount").replace("%loreCount%", "" + i)))) {
						return;
					}
				}
				int loreCount = 0;
				Player player = (Player) event.getWhoClicked();
				ItemStack currentItem = event.getCurrentItem();
				ItemMeta currentItemMeta = currentItem.getItemMeta();
				List<String> currentItemLore = currentItemMeta.getLore();
				
				ArrayList<String> lore = new ArrayList<String>();
				/*
				 * Soul Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getSoulItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSoulItemLores().get(i))) {
						lore.add(EnchantBookLores.getSoulItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				/*
				 * Legendary Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getLegendaryItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getLegendaryItemLores().get(i))) {
						lore.add(EnchantBookLores.getLegendaryItemLores().get(i)); currentItemLore.remove(EnchantBookLores.getLegendaryItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				/*
				 * Ultimate Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getUltimateItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUltimateItemLores().get(i))) {
						lore.add(EnchantBookLores.getUltimateItemLores().get(i)); currentItemLore.remove(EnchantBookLores.getUltimateItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				/*
				 * Elite Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getEliteItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getEliteItemLores().get(i))) {
						lore.add(EnchantBookLores.getEliteItemLores().get(i)); currentItemLore.remove(EnchantBookLores.getEliteItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				/*
				 * Unique Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getUniqueItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getUniqueItemLores().get(i))) {
						lore.add(EnchantBookLores.getUniqueItemLores().get(i)); currentItemLore.remove(EnchantBookLores.getUniqueItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				/*
				 * Simple Enchants
				 */
				for(int i = 0; i < EnchantBookLores.getSimpleItemLores().size(); i++) {
					if(event.getCurrentItem().getItemMeta().getLore().contains(EnchantBookLores.getSimpleItemLores().get(i))) {
						lore.add(EnchantBookLores.getSimpleItemLores().get(i)); currentItemLore.remove(EnchantBookLores.getSimpleItemLores().get(i));
						loreCount = loreCount + 1;
					}
				}
				lore.addAll(currentItemLore);
				currentItemMeta.setLore(lore);
				if(currentItemMeta.getDisplayName() == null) {
					currentItemMeta.setDisplayName(currentItem.getType().toString().replace("DIAMOND", "Diamond").replace("IRON", "Iron").replace("CHAIN", "Chain").replace("GOLD", "Gold").replace("LEATHER", "Leather").replace("HELMET", "Helmet").replace("CHESTPLATE", "Chestplate").replace("LEGGINGS", "Leggings").replace("BOOTS", "Boots").replace("SWORD", "Sword").replace("SPADE", "Shovel").replace("PICKAXE", "Pickaxe").replace("AXE", "Axe").replace("BOW", "Bow").replace("_", " ") + " " + ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount").replace("%loreCount%", "" + loreCount)));
				} else {
					currentItemMeta.setDisplayName(currentItemMeta.getDisplayName() + " " + ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.ApplyCount").replace("%loreCount%", "" + loreCount)));
				}
				currentItem.setItemMeta(currentItemMeta);
				event.setCurrentItem(currentItem);
				
				if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1);
				} else { event.setCursor(new ItemStack(Material.AIR)); }
				
				event.setCancelled(true);
				for(int i = 1; i <= 15; i++) {
					player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1);
				}
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
				player.updateInventory();
				return;
			}
		}
	}
}
