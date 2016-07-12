package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class KillAura implements Listener {
	@EventHandler
	private void entityDeathEvent(EntityDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)) {
			return;
		} else {
			Player killer = (Player) event.getEntity().getKiller();
			if(!(killer.getInventory().getItemInMainHand() == null) && killer.getInventory().getItemInMainHand().hasItemMeta()
					&& killer.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				int chance = 30;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 5;
					if(killer.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
							&& killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.KillAura.KillAura" + i + ".ItemLore")))
							|| killer.getInventory().getItemInMainHand().getType().name().endsWith("_AXE")
							&& killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.KillAura.KillAura" + i + ".ItemLore")))) {
						Random random = new Random();
						int amountKilled = 0;
						if(random.nextInt(100) <= chance) {
							for(int p = 2; p <= 200; p++) {
								if(ChatColor.stripColor(event.getEntity().getNearbyEntities(0.1, 0.1, 0.1).get(0).getCustomName()).startsWith("" + p)) {
									event.getEntity().getKiller().sendMessage("" + p);
									event.getEntity().getNearbyEntities(0.1, 0.1, 0.1).get(0).setCustomName(event.getEntity().getNearbyEntities(0.1, 0.1, 0.1).get(0).getCustomName().replace("" + p, "" + Math.subtractExact(p, amountKilled)));
								}
							}
							String nearbyEntities = event.getEntity().getNearbyEntities(2, 2, 2).toString().replace("CraftBlaze", "BLAZE");
							if(nearbyEntities.contains("" + event.getEntity().getType())) {
								for(Entity entity : event.getEntity().getNearbyEntities(2, 2, 2)) {
									if(!(entity instanceof Player) && entity instanceof LivingEntity) {
										if(random.nextInt(100) <= 15) {
											amountKilled = 2;
										} else if(random.nextInt(100) <= 35) {
											amountKilled = 1;
										} else { return; }
										event.getEntity().getKiller().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("KillAuraMessage").replace("%amount%", "" + Math.addExact(amountKilled, 1))));
										return;
									}
								}
								return;
							} else {
								return;
							}
						} else {
							return;
						}
					}
				}
			} else {
				return;
			}
		}
	}
}