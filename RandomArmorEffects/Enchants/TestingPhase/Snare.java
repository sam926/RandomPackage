package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TestingPhase;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Snare implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString(".Snare").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player damager = (Player) event.getDamager();
						LivingEntity entity = (LivingEntity) event.getEntity();
						return;
					}
				}
			}, 1);
			return;
		}
	}
}
