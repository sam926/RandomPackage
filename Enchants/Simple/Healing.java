package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Healing implements Listener {
	private int shooter = 0;
	private int addHealth = 0;
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(shooter == 1 && !(addHealth == 0)
				&& event.getDamager().getType().name().endsWith("ARROW")
				&& event.isCancelled()
				&& event.getEntity() instanceof Player
				&& RandomPackage.getEnabledEnchantsConfig().getString("Simple.Healing").equalsIgnoreCase("true")) {
			Player player = (Player) event.getEntity();
			if(player.getHealth() + addHealth > player.getMaxHealth()) {
				return;
			} else {
				player.setHealth(player.getHealth() + addHealth);
				return;
			}
		} else {
			return;
		}
	}
	@EventHandler
	private void entityShootBowEvent(EntityShootBowEvent event) {
		if(event.getEntity() instanceof Player) {
			Player shooter = (Player) event.getEntity();
			if(!(shooter.getInventory().getItemInMainHand() == null)
					&& shooter.getInventory().getItemInMainHand().getType().name().endsWith("BOW")
					&& shooter.getInventory().getItemInMainHand().hasItemMeta()
					&& shooter.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Random random = new Random();
				int randomChance = 100;
				int randomNumber = random.nextInt(randomChance);
				int chance = 60;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 10;
					if(randomNumber <= chance
							&& shooter.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Healing.Healing" + i + ".ItemLore")))) {
						this.shooter = 1;
						addHealth = chance / 10 - 3;
						return;
					} else if(chance == 100) {
						this.shooter = 0;
						addHealth = 0;
						return;
					}
				}
				return;
			}
			return;
		} else {
			this.shooter = 0;
			addHealth = 0;
			return;
		}
	}
}
