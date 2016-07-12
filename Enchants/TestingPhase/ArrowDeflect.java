package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TestingPhase;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArrowDeflect implements Listener {
	private ArrayList<String> arrowDeflect = new ArrayList<String>();
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(event.getDamager().getType().equals(EntityType.ARROW) || event.getDamager().getType().equals(EntityType.SPECTRAL_ARROW) || event.getDamager().getType().equals(EntityType.TIPPED_ARROW)) {
				if(!(player.getInventory().getHelmet() == null)
						&& player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().hasLore()
						|| !(player.getInventory().getChestplate() == null)
						&& player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
						|| !(player.getInventory().getLeggings() == null)
						&& player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().hasLore()
						|| !(player.getInventory().getBoots() == null)
						&& player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore()) {
					
				}
				if(arrowDeflect.contains(player.getName())) {
					event.setCancelled(true);
					return;
				} else { return; }
			} else { return; }
		} else { return; }
	}
}
