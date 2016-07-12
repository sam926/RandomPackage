package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.ArrayList;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class RageMk2 implements Listener {
	private ArrayList<String> ragePlayers = new ArrayList<String>();
	private ArrayList<String> rageEntity = new ArrayList<String>();
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Rage").equalsIgnoreCase("true"))) {
			return;
		} else {
			/*
			 * PvP
			 */
			if(event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
				Player damager = (Player) event.getDamager();
				Player victim = (Player) event.getEntity();
				return;
			/*
			 * PvE
			 */
			} else if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
				Player damager = (Player) event.getDamager();
				LivingEntity entity = (LivingEntity) event.getEntity();
				for(int i = 0; i < rageEntity.size(); i++) {
					if(!(rageEntity.get(i).startsWith(damager.getName())) && i == rageEntity.size() - 1) {
						rageEntity.add(damager.getName() + "_" + entity.getName());
					} else {
						
					}
				}
				return;
			} else { return; }
		}
	}
	private void removeDamager(EntityDamageByEntityEvent event) {
		for(int i = 0; i < ragePlayers.size(); i++) {
			if(ragePlayers.get(i).startsWith(event.getDamager().getName())) {
				ragePlayers.remove(i);
			}
		}
	}
}
