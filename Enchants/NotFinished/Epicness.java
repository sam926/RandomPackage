package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Epicness implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Epicness").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						for(int i = 1; i <= 3; i++) {
							if(!(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD") && damager.getInventory().getItemInMainHand().hasItemMeta()
									|| !(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE") && damager.getInventory().getItemInMainHand().hasItemMeta()) {
								if(damager.getInventory().getItemInMainHand().getItemMeta().hasLore()
										&& damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Epicness.Epicness" + i + ".ItemLore")))) {
									if(event.getEntity().getWorld().getGameRuleValue("commandBlockOutput").equalsIgnoreCase("true")) { event.getEntity().getWorld().setGameRuleValue("commandBlockOutput", "false"); }
									if(event.getEntity().getWorld().getGameRuleValue("sendCommandFeedback").equalsIgnoreCase("true")) { event.getEntity().getWorld().setGameRuleValue("sendCommandFeedback", "false"); }
									if(event.getEntity().getWorld().getGameRuleValue("logAdminCommands").equalsIgnoreCase("true")) { event.getEntity().getWorld().setGameRuleValue("logAdminCommands", "false"); }
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "particle largesmoke " + event.getEntity().getLocation().getX() + " " + event.getEntity().getLocation().getY() + " " + event.getEntity().getLocation().getZ() + " 0.5 1 0.5 1 25 1");
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "particle magicCrit " + event.getEntity().getLocation().getX() + " " + event.getEntity().getLocation().getY() + " " + event.getEntity().getLocation().getZ() + " 0.5 1 0.5 1 25 1");
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "particle cloud " + event.getEntity().getLocation().getX() + " " + event.getEntity().getLocation().getY() + " " + event.getEntity().getLocation().getZ() + " 0.5 1 0.5 1 25 1");
									return;
								}
							}
						}
						return;
					}
				}
			}, 1);
			return;
		}
	}
}
