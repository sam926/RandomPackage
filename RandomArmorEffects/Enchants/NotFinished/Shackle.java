package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Shackle implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled()
				|| !(event.getDamager() instanceof Player)) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(!(damager.getInventory().getItemInMainHand() == null)
					&& damager.getInventory().getItemInMainHand().hasItemMeta()
					&& damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				for(int i = 1; i <= 3; i++) {
					if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Shackle.Shackle" + i + ".ItemLore")))) {
						event.setCancelled(true);
						damager.sendMessage("test");
						((LivingEntity) event.getEntity()).damage(event.getDamage());
						return;
					}
				}
				return;
			} else {
				return;
			}
		}
	}
}
