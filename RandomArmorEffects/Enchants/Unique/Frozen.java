package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Frozen implements Listener {
	
	@EventHandler
	private void playerEvent(EntityDamageByEntityEvent event) {
		Entity damager = event.getDamager();
		
		Random random = new Random();
		int randomChance = 100; // 100%
		int DROP_NUMBER = random.nextInt(randomChance);
		
		if(!(damager instanceof Player)) { // Not a player
			return;
		} else {
			Entity p = event.getDamager();
			if(!((HumanEntity) p).getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
					|| !((HumanEntity) damager).getInventory().getItemInMainHand().hasItemMeta()
					|| !((HumanEntity) damager).getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				return;
			} else {
				if(((HumanEntity) p).getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Frozen.Frozen1.ItemLore")))) {
					Entity entity = event.getEntity();
					if(DROP_NUMBER <= 8) { // 8% chance of Frozen
						((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 5));
						return;
					} else {
						return;
					}
				} else if(((HumanEntity) p).getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Frozen.Frozen2.ItemLore")))) {
					Entity entity = event.getEntity();
					if(DROP_NUMBER <= 9) { // 9% chance of Frozen
						((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180, 6));
						return;
					} else {
						return;
					}
				} else if(((HumanEntity) p).getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Frozen.Frozen3.ItemLore")))) {
					Entity entity = event.getEntity();
					if(DROP_NUMBER <= 10) { // 10% chance of Frozen
						((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 7));
						return;
					} else {
						return;
					}
				} else {
					return;
				}
			}
		}
	}
}
