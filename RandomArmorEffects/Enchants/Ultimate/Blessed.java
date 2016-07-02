package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Blessed implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Blessed").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int chance = 10;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 5;
					if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Blessed.Blessed" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						if(damager.hasPotionEffect(PotionEffectType.SLOW)) { damager.removePotionEffect(PotionEffectType.SLOW); }
						if(damager.hasPotionEffect(PotionEffectType.BLINDNESS)) { damager.removePotionEffect(PotionEffectType.BLINDNESS); }
						if(damager.hasPotionEffect(PotionEffectType.CONFUSION)) { damager.removePotionEffect(PotionEffectType.CONFUSION); }
						if(damager.hasPotionEffect(PotionEffectType.WITHER)) { damager.removePotionEffect(PotionEffectType.WITHER); }
						if(damager.hasPotionEffect(PotionEffectType.POISON)) { damager.removePotionEffect(PotionEffectType.POISON); }
						if(damager.hasPotionEffect(PotionEffectType.WEAKNESS)) { damager.removePotionEffect(PotionEffectType.WEAKNESS); }
					}
				}
				return;
			}
		}
	}
}
