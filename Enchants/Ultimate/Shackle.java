package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Shackle implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						if(!(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().hasItemMeta() && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
							for(int i = 1; i <= 3; i++) {
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Shackle.Shackle" + i + ".ItemLore")))) {
									if(i == 1 && !(event.getEntityType().equals(EntityType.BLAZE)) && !(event.getEntityType().equals(EntityType.MAGMA_CUBE))
											|| i == 2 && !(event.getEntityType().equals(EntityType.MAGMA_CUBE)) || i == 3) {
										event.getEntity().setVelocity(new Vector(damager.getLocation().getDirection().getX(), 0.0, damager.getLocation().getDirection().getZ()).multiply(2.5));
										return;
									}
								}
							}
							return;
						} else {
							return;
						}
					}
				}
			}, 1);
			return;
		}
	}
}
