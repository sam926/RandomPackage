package me.randomHashTags.randomPackage.RandomArmorEffects.Soul;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class soulAdd implements Listener {
	private ArrayList<Player> delay = new ArrayList<Player>();
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)) {
			return;
		} else {
			Player killer = (Player) event.getEntity().getKiller();
			if(killer.getInventory().getItemInMainHand() == null
					|| !(killer.getInventory().getItemInMainHand().hasItemMeta())
					|| !(killer.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				ItemStack itemInMainHand = killer.getInventory().getItemInMainHand();
				ItemMeta itemInMainHandMeta = itemInMainHand.getItemMeta();
				List<String> itemInMainHandLore = itemInMainHandMeta.getLore();
				int trackerSlot = 0;
				int currentSouls = 0;
				
				if(delay.contains(killer)
						&& delay.contains(event.getEntity())) {
					killer.sendMessage(ChatColor.RED + "You cannot kill " + event.getEntity().getName() + " until the 5 minutes have passed!");
					return;
				} else {
					
					for(int i = 1; i <= 199; i++) {
						if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + i)))
								|| killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + i)))
								|| killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + i)))
								|| killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + i)))
								|| killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + i)))) {
							currentSouls = i;
						}
					}
					
					for(int i = 0; i <= 10; i++) {
						if(!(killer.getInventory().getItemInMainHand().getItemMeta().getLore().size() < i)
								&& !(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i) == null)
								&& killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + currentSouls)))) {
							trackerSlot = i;
							
							currentSouls = Math.addExact(currentSouls, 1);
							
							itemInMainHandLore.set(trackerSlot, ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + currentSouls)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer);
							delay.add(event.getEntity());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity());
								}
							}, 1000L);
							
							return;
						} else if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + currentSouls)))) {
							trackerSlot = i;
							
							currentSouls = Math.addExact(currentSouls, 1);
							
							itemInMainHandLore.set(trackerSlot, ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + currentSouls)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer);
							delay.add(event.getEntity());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity());
								}
							}, 1000L);
							
							return;
						} else if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + currentSouls)))) {
							trackerSlot = i;
							
							currentSouls = Math.addExact(currentSouls, 1);
							
							itemInMainHandLore.set(trackerSlot, ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + currentSouls)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer);
							delay.add(event.getEntity());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity());
								}
							}, 1000L);
							
							return;
						} else if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + currentSouls)))) {
							trackerSlot = i;
							
							currentSouls = Math.addExact(currentSouls, 1);
							
							itemInMainHandLore.set(trackerSlot, ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + currentSouls)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer);
							delay.add(event.getEntity());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity());
								}
							}, 1000L);
							
							return;
						} else if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + currentSouls)))) {
							trackerSlot = i;
							
							currentSouls = Math.addExact(currentSouls, 1);
							
							itemInMainHandLore.set(trackerSlot, ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + currentSouls)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer);
							delay.add(event.getEntity());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity());
								}
							}, 1000L);
							return;
						}
					}
				}
			}
		}
	}
}
