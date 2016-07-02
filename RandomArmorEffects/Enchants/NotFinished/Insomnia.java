package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Insomnia implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| damager.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE")
					|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(damager.getInventory().getItemInMainHand().getType().name().endsWith("AXE"))) {
				return;
			} else {
				Random random = new Random();
				int chance = 4;
				for(int i = 1; i <= 7; i++) {
					chance = chance + 2;
					if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Insomnia.Insomnia" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						event.setDamage(event.getDamage() * 2);
						return;
					}
				}
				return;
			}
		}
	}
	/*@EventHandler
	private void playerItemHeldEvent(PlayerItemHeldEvent event) {
		event.getPlayer().sendMessage("" + event.getPlayer().getInventory().getItem(event.getNewSlot()));
		if(event.isCancelled() || event.getPlayer().getInventory().getItem(event.getNewSlot()) == null
				|| event.getPlayer().getInventory().getItem(event.getNewSlot()).getType().name().endsWith("PICKAXE")
				|| !(event.getPlayer().getInventory().getItem(event.getNewSlot()).getType().name().endsWith("SWORD")) && !(event.getPlayer().getInventory().getItem(event.getNewSlot()).getType().name().endsWith("AXE"))
				|| !(event.getPlayer().getInventory().getItem(event.getNewSlot()).hasItemMeta()) || !(event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta().hasLore())) {
			return;
		} else {
			Random random = new Random();
			Player player = (Player) event.getPlayer();
			int chance = 8;
			for(int i = 1; i <= 7; i++) {
				chance = chance + 2;
				if(event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Insomnia.Insomnia" + i + ".ItemLore")))
						&& random.nextInt(100) <= chance) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 220, i - 1));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, (i + 1) / 2 - 1));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, (i + 1) / 2 - 1));
					return;
				}
			}
			return;
		}
	}*/
}
