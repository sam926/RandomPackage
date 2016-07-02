package me.randomHashTags.randomPackage.CustomTNT;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class locationTNT implements Listener {
	public static ArrayList<String> tnt = new ArrayList<String>();
	@EventHandler
	private void blockBreakEvent(BlockBreakEvent event) {
		String blockLocation = event.getBlock().getLocation().toString().replace("Location{world=CraftWorld{name=" + event.getBlock().getWorld().getName() + "},", "").replace(",pitch=0.0,yaw=0.0}", "");
		ItemStack item = new ItemStack(Material.TNT, 1);
		ItemMeta itemMeta = item.getItemMeta();
		if(event.getBlock().getType().equals(Material.TNT)) {
			for(int i = 0; i < tnt.size(); i++) {
				if(tnt.get(i).startsWith(blockLocation + "_Mimic")) {
					itemMeta.setDisplayName(ChatColor.AQUA + "Mimic TNT");
				}
				event.setCancelled(true); event.getBlock().setType(Material.AIR);
				tnt.remove(i);
				event.getPlayer().sendMessage("removed from the tnt");
			}
			item.setItemMeta(itemMeta);
			event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), item);
			return;
		} else { return; }
}
	@EventHandler
	private void blockPlaceEvent(BlockPlaceEvent event) {
		if(event.getBlock().getType().equals(Material.TNT) && event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()
				&& event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Mimic TNT")) {
				tnt.add(event.getBlock().getLocation().toString().replace("Location{world=CraftWorld{name=" + event.getBlock().getWorld().getName() + "},", "").replace(",pitch=0.0,yaw=0.0}", "") + "_Mimic");
				event.getPlayer().sendMessage("placed at: " + event.getBlock().getLocation().toString().replace("Location{world=CraftWorld{name=" + event.getBlock().getWorld().getName() + "},", "").replace(",pitch=0.0,yaw=0.0}", "") + "_Mimic");
				return;
			} else { return; }
		} else { return; }
	}
	@EventHandler
	private void pluginDisableEvent(PluginDisableEvent event) {
		tnt.clear();
		return;
	}
	@EventHandler
	private void blockExplodeEvent(EntityExplodeEvent event) {
		for(int i = 0; i < tnt.size(); i++) {
			if(tnt.get(i).startsWith("x=" + event.getEntity().getLocation().getBlockX() + ".0,y=" + event.getEntity().getLocation().getBlockY() + ".0,z=" + event.getEntity().getLocation().getBlockZ() + ".0_Mimic")) {
				for(int o = 0; o <= 2; o++) {
					Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
						public void run() {
							Bukkit.getWorld(event.getEntity().getWorld().getName()).createExplosion(event.getLocation(), 2);
						}
					}, (o + 1) * 3);
				}
				tnt.remove(i);
				return;
			}
		}
		return;
	}
}
