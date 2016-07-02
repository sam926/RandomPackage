package me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer;

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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;

public class newDustAndFireballs implements Listener {
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIREBALL))) {
			return;
		} else {
			Player player = (Player) event.getPlayer();
			String type = null, effect = null;
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.LegendaryName")))) {
				type = "Legendary";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.UltimateName")))) {
				type = "Ultimate";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.EliteName")))) {
				type = "Elite";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.UniqueName")))) {
				type = "Unique";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Fireballs.SimpleName")))) {
				type = "Simple";
			} else { return; }
			
			Random random = new Random();
			int chanceRegular = RandomPackage.getTinkererConfig().getInt("Chances." + type + "Dust");
			int chancePrimal = RandomPackage.getTinkererConfig().getInt("Chances." + type + "Primal");
			ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			
			if(random.nextInt(100) <= chancePrimal) {
				int percent = random.nextInt(31);
				if(percent < 10) { percent = 10; }
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.PrimalItem").toUpperCase()), 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust." + type + ".PrimalName")));
				for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".PrimalLore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".PrimalLore").get(i).replace("%percent%", "" + percent)));
				}
				effect = "Dust";
				player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			} else if(random.nextInt(100) <= chanceRegular) {
				int percent = random.nextInt(10);
				if(percent == 0) { percent = 1; }
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()), 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust." + type + ".DustName")));
				for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".DustLore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".DustLore").get(i).replace("%percent%", "" + percent)));
				}
				effect = "Dust";
				player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			} else {
				item = new ItemStack(Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.MysteryItem").toUpperCase()), 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.MysteryDust.Name")));
				for(int i = 0; i < RandomPackage.getTinkererConfig().getStringList("Dust.MysteryDust.Lore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust.MysteryDust.Lore").get(i)));
				}
				player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
			}
			if(effect == "Dust") {
				for(int i = 1; i <= 15; i++) {
					player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1);
				}
			} else {
				for(int i = 1; i <= 15; i++) {
					player.getWorld().playEffect(player.getEyeLocation(), Effect.LAVA_POP, 1);
				}
			}
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
			player.getInventory().addItem(item);
			if(player.getInventory().getItemInMainHand().getAmount() > 1) { player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			} else { player.getInventory().setItemInMainHand(new ItemStack(Material.AIR)); }
			player.updateInventory();
			event.setCancelled(true);
			return;
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null
				|| !(event.getCurrentItem().getType() == Material.BOOK)
				|| !(event.getCurrentItem().hasItemMeta()) || !(event.getCurrentItem().getItemMeta().hasDisplayName()) || !(event.getCurrentItem().getItemMeta().hasLore())
				|| !(event.getCursor().getType() == Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.DustItem").toUpperCase()))
				&& !(event.getCursor().getType() == Material.getMaterial(RandomPackage.getTinkererConfig().getString("Dust.PrimalItem").toUpperCase()))
				|| !(event.getCursor().hasItemMeta()) || !(event.getCursor().getItemMeta().hasDisplayName()) || !(event.getCursor().getItemMeta().hasLore())) {
			return;
		} else {
			String type = null;
			int dustPercent = 0;
			Player player = (Player) event.getWhoClicked();
			ItemStack currentItem = event.getCurrentItem();
			ItemMeta currentItemMeta = currentItem.getItemMeta();
			List<String> currentItemLore = currentItemMeta.getLore();
			if(EnchantBookNames.getLegendaryBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Legendary.DustName")))
				|| EnchantBookNames.getLegendaryBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Legendary.PrimalName")))) {
				type = "Legendary";
			} else if(EnchantBookNames.getUltimateBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Ultimate.DustName")))
					|| EnchantBookNames.getUltimateBookNames().contains(event.getCursor().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Ultimate.PrimalName")))) {
				type = "Ultimate";
			} else if(EnchantBookNames.getEliteBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Elite.DustName")))
					|| EnchantBookNames.getEliteBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Elite.PrimalName")))) {
				type = "Elite";
			} else if(EnchantBookNames.getUniqueBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Unique.DustName")))
					|| EnchantBookNames.getUniqueBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Unique.PrimalName")))) {
				type = "Unique";
			} else if(EnchantBookNames.getSimpleBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Simple.DustName")))
					|| EnchantBookNames.getSimpleBookNames().contains(event.getCurrentItem().getItemMeta().getDisplayName()) && event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getString("Dust.Simple.PrimalName")))) {
				type = "Simple";
			} else {
				type = null;
				return;
			}
			for(int i = 0; i <= 30; i++) {
				if(event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".PrimalLore").get(2).replace("%percent%", "" + i)))
						|| event.getCursor().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getTinkererConfig().getStringList("Dust." + type + ".DustLore").get(2).replace("%percent%", "" + i)))) {
					dustPercent = i;
				}
			}
			for(int i = 0; i <= 99; i++) {
				if(event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + i)))) {
					event.setCancelled(true);
					if(Math.addExact(i, dustPercent) > 100) {
						i = 50; dustPercent = 50;
					}
					currentItemLore.set(0, ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success").replace("%success%", "" + Math.addExact(dustPercent, i))));
					currentItemMeta.setLore(currentItemLore);
					currentItem.setItemMeta(currentItemMeta);
					event.setCurrentItem(currentItem);
					if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1);
					} else { event.setCursor(new ItemStack(Material.AIR)); }
					for(int o = 1; o <= 15; o++) {
						player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1);
					}
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
					player.updateInventory();
					return;
				}
			}
			return;
		}
	}
}
