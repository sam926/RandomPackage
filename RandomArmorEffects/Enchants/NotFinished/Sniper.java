package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

public class Sniper implements Listener {
	private String shooter = null;
	private String itemInHand = null;
	@EventHandler
	private void entityShootBowEvent(EntityShootBowEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getItemInMainHand().getType().name().endsWith("BOW")) {
				itemInHand = "Bow";
				shooter = "Player";
				return;
			} else {
				itemInHand = null;
				shooter = null;
				return;
			}
		} else {
			itemInHand = null;
			shooter = null;
			return;
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getDamager() instanceof Player)
				|| !(event.getEntity() instanceof Player)
				|| shooter == null
				|| itemInHand == null) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			if(damager.getInventory().getItemInMainHand() == null
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta())
					|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.RED + "Sniper I")) {
					damager.sendMessage("damage before: " + event.getDamage());
					event.setDamage(event.getDamage() * 1.25);
					damager.sendMessage("damage after: " + event.getDamage());
					return;
				} else {
					return;
				}
			}
		}
	}
}
