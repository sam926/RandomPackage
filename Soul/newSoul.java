package me.randomHashTags.randomPackage.RandomArmorEffects.Soul;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class newSoul implements Listener {
	public static ArrayList<String> status = new ArrayList<String>();
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(!(event.getAction() == Action.RIGHT_CLICK_AIR) && !(event.getAction() == Action.RIGHT_CLICK_BLOCK)
				|| event.getPlayer().getInventory().getItemInMainHand() == null || !(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.EMERALD))
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())) {
			return;
		} else {
			for(int i = 0; i <= 100; i++) {
				if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGem.Name").replace("%souls%", "" + i)))) {
					if(status.contains(event.getPlayer().getName())) {
						status.remove(event.getPlayer().getName());
						for(int o = 0; o < RandomPackage.getSoulConfig().getStringList("Messages.SoulMode.Deactivate").size(); o++) {
							event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("Messages.SoulMode.Deactivate").get(o)));
						}
						return;
					} else {
						status.add(event.getPlayer().getName());
						for(int o = 0; o < RandomPackage.getSoulConfig().getStringList("Messages.SoulMode.Activate").size(); o++) {
							event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("Messages.SoulMode.Activate").get(o)));
						}
						if(event.getPlayer().getWorld().getGameRuleValue("commandBlockOutput").equalsIgnoreCase("true")) { event.getPlayer().getWorld().setGameRuleValue("commandBlockOutput", "false"); }
						if(event.getPlayer().getWorld().getGameRuleValue("logAdminCommands").equalsIgnoreCase("true")) { event.getPlayer().getWorld().setGameRuleValue("logAdminCommands", "false"); }
						if(event.getPlayer().getWorld().getGameRuleValue("sendCommandFeedback").equalsIgnoreCase("true")) { event.getPlayer().getWorld().setGameRuleValue("sendCommandFeedback", "false"); }
						Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomPackage.getPlugin(), new Runnable() {
							public void run() {
								if(status.contains(event.getPlayer().getName())) {
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute " + event.getPlayer().getName() + " ~ ~ ~ particle enchantmenttable ~ ~ ~ 0.8 1 0.8 1 15");
									return;
								} else {
									return;
								}
							}
						}, 0L, 0L);
						return;
					}
				}
			}
			return;
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR
				|| !(event.getCurrentItem().getType().name().endsWith("SWORD")) && !(event.getCurrentItem().getType().name().endsWith("_AXE")) || event.getCursor() == null
				|| !(event.getCursor().hasItemMeta()) || !(event.getCursor().getItemMeta().hasDisplayName()) || !(event.getCursor().getItemMeta().hasLore())
				|| !(event.getCursor().getType().name().endsWith(RandomPackage.getSoulConfig().getString("SoulTrackers.Item").toUpperCase()))) {
			return;
		} else {
			String soulTrackerRarity = null;
			if(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.Name")))) {
				soulTrackerRarity = "Simple";
			} else if(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.Name")))) {
				soulTrackerRarity = "Unique";
			} else if(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.Name")))) {
				soulTrackerRarity = "Elite";
			} else if(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.Name")))) {
				soulTrackerRarity = "Ultimate";
			} else if(event.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.Name")))) {
				soulTrackerRarity = "Legendary";
			} else { return; }
			
			ArrayList<String> lore = new ArrayList<String>();
			Player player = (Player) event.getWhoClicked();
			ItemStack currentItem = event.getCurrentItem();
			ItemMeta currentItemMeta = currentItem.getItemMeta();
			
			if(currentItem.hasItemMeta() && currentItem.getItemMeta().hasLore()) {
				for(int i = 0; i <= 199; i++) {
					if(currentItem.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + i)))
						|| currentItem.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + i)))
						|| currentItem.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + i)))
						|| currentItem.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + i)))
						|| currentItem.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + i)))) {
						return;
					}
				}
				lore.addAll(currentItemMeta.getLore());
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers." + soulTrackerRarity + ".ApplyLore").replace("%souls%", "0")));
			} else if(!(currentItem.hasItemMeta()) || currentItem.hasItemMeta() && !(currentItem.getItemMeta().hasLore())) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers." + soulTrackerRarity + ".ApplyLore").replace("%souls%", "0")));
			} else { return; }
			
			currentItemMeta.setLore(lore);
			currentItem.setItemMeta(currentItemMeta);
			
			if(event.getCursor().getAmount() > 1) { event.getCursor().setAmount(event.getCursor().getAmount() - 1);
			} else { event.setCursor(new ItemStack(Material.AIR)); }
			
			event.setCurrentItem(currentItem);
			event.setCancelled(true);
			
			for(int i = 1; i <= 15; i++) { player.getWorld().playEffect(player.getEyeLocation(), Effect.SPELL, 1); }
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			player.updateInventory();
			return;
		}
	}
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		if(status.contains(event.getEntity().getName())) {
			status.remove(event.getEntity().getName());
			return;
		} else { return; }
	}
}
