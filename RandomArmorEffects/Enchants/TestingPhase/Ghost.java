package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TestingPhase;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Ghost implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()) {
			return;
		} else {
			
		}
	}
}
