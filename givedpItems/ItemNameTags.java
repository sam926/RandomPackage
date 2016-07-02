package me.randomHashTags.randomPackage.givedpItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

@SuppressWarnings("deprecation")
public class ItemNameTags implements Listener {
	private ArrayList<Player> ItemNameTags = new ArrayList<Player>();
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getAction() == Action.RIGHT_CLICK_AIR) && !(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			return;
		} else {
			if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.NAME_TAG
					&& event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()
					&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()
					&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Name")))) {
				event.setCancelled(true);
				if(!(ItemNameTags.contains(event.getPlayer()))) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Messages.Activate")));
					ItemNameTags.add(event.getPlayer());
					if(event.getPlayer().getInventory().getItemInMainHand().getAmount() > 1) {
						event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
						return;
					} else {
						event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
						return;
					}
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}
	@EventHandler
	private void playerChatEvent(PlayerChatEvent event) {
		if(event.isCancelled()) {
			return;
		} else {
			if(ItemNameTags.contains(event.getPlayer())) {
				if(event.getPlayer().getInventory().getItemInMainHand() == null
						|| event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR) {
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Messages.CannotRenameAir")));
					ArrayList<String> lore = new ArrayList<String>();
					ItemStack nameTag = new ItemStack(Material.NAME_TAG, 1);
					ItemMeta nameTagMeta = nameTag.getItemMeta();
					nameTagMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Name")));
					for(int i = 0; i < RandomPackage.getGivedpItemsConfig().getStringList("TransmogScrolls.Lore").size(); i++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("ItemNameTags.Lore").get(i)));
					}
					nameTagMeta.setLore(lore);
					nameTag.setItemMeta(nameTagMeta);
					
					event.getPlayer().getInventory().addItem(nameTag);
					event.getPlayer().updateInventory();
					
					ItemNameTags.remove(event.getPlayer());
					return;
				} else if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOOK
						&& event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()
						&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()
						&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()
						|| event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FIREBALL
						&& event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()
						&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()
						&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()
						&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("Dust.Fireballs.Lore1")))) {
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Messages.CannotRenameItem")));
					ArrayList<String> lore = new ArrayList<String>();
					ItemStack nameTag = new ItemStack(Material.NAME_TAG, 1);
					ItemMeta nameTagMeta = nameTag.getItemMeta();
					nameTagMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("ItemNameTags.Name")));
					for(int i = 0; i < RandomPackage.getGivedpItemsConfig().getStringList("TransmogScrolls.Lore").size(); i++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getStringList("ItemNameTags.Lore").get(i)));
					}
					nameTagMeta.setLore(lore);
					nameTag.setItemMeta(nameTagMeta);
					
					event.getPlayer().getInventory().addItem(nameTag);
					event.getPlayer().updateInventory();
					
					ItemNameTags.remove(event.getPlayer());
					return;
				} else {
					ItemStack currentItem = event.getPlayer().getInventory().getItemInMainHand();
					ItemMeta currentItemMeta = event.getPlayer().getInventory().getItemInMainHand().getItemMeta();
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGivedpItemsConfig().getString("TransmogScrolls.Messages.Success").replace("%name%", ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', event.getMessage()))));
					currentItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
					currentItem.setItemMeta(currentItemMeta);
					event.getPlayer().getInventory().setItemInMainHand(currentItem);
					event.getPlayer().updateInventory();
					event.setCancelled(true);
					ItemNameTags.remove(event.getPlayer());
					return;
				}
			} else {
				return;
			}
		}
	}
}
