package me.randomHashTags.randomPackage.givedpItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class WhiteScrolls implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled() || event.getCurrentItem() == null
				|| !(event.getCurrentItem().getType().name().endsWith("HELMET"))
				&& !(event.getCurrentItem().getType().name().endsWith("CHESTPLATE"))
				&& !(event.getCurrentItem().getType().name().endsWith("LEGGINGS"))
				&& !(event.getCurrentItem().getType().name().endsWith("BOOTS"))
				&& !(event.getCurrentItem().getType().name().endsWith("BOW"))
				&& !(event.getCurrentItem().getType().name().endsWith("SWORD"))
				&& !(event.getCurrentItem().getType().name().endsWith("PICKAXE"))
				&& !(event.getCurrentItem().getType().name().endsWith("AXE"))
				&& !(event.getCurrentItem().getType().name().endsWith("SPADE"))
				&& !(event.getCurrentItem().getType().name().endsWith("HOE"))
				|| event.getCursor() == null || !(event.getCursor().getType() == Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Item").toUpperCase())) || !(event.getCursor().hasItemMeta()
				|| !(event.getCursor().getItemMeta().hasDisplayName())) || !(event.getCursor().getItemMeta().hasLore()) || event.getCursor().getItemMeta().getLore().get(2) == null
				|| !(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Name"))))
				|| !(event.getCursor().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(0))))
				&& !(event.getCursor().getItemMeta().getLore().get(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(1))))
				&& !(event.getCursor().getItemMeta().getLore().get(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(2))))
				|| event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore() && event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED")) {
			return;
		} else {
			ItemStack currentItem = event.getCurrentItem();
			ItemMeta currentItemMeta = currentItem.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLore()) { lore.addAll(event.getCurrentItem().getItemMeta().getLore()); }
			lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "PROTECTED");
			currentItemMeta.setLore(lore);
			currentItem.setItemMeta(currentItemMeta);
			
			if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1);
			} else { event.setCursor(new ItemStack(Material.AIR)); }
			event.setCurrentItem(currentItem);
			event.setCancelled(true);
			for(int i = 1; i <= 15; i++) {
				event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getEyeLocation(), Effect.SPELL, 1);
			}
			event.getWhoClicked().getWorld().playSound(event.getWhoClicked().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			((Player) event.getWhoClicked()).updateInventory();
			return;
		}
	}
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Name"))))
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.getMaterial(RandomPackage.getGivedpItemsConfig().getString("WhiteScrolls.Item").toUpperCase())))
				|| event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(2) == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(0))))
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(1))))
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("WhiteScrolls.Lore").get(2))))
				|| !(event.getAction() == Action.RIGHT_CLICK_AIR)
				&& !(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			return;
		} else {
			event.setCancelled(true);
			event.getPlayer().updateInventory();
			return;
		}
	}
}