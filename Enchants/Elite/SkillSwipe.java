package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class SkillSwipe implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.SkillSwipe").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			if(damager.getInventory().getItemInMainHand() == null
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta())
					|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 0;
							for(int i = 1; i <= 5; i++) {
								chance = chance + 8;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.SkillSwipe.SkillSwipe" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									int randomXP = random.nextInt(10);
									
									int victimExp = victim.getTotalExperience() - randomXP;
									int damagerExp = damager.getTotalExperience() + randomXP;
									if(victimExp - randomXP < 0) {
										return;
									} else {
										victim.setLevel(0);
										victim.setTotalExperience(victimExp);
										
										damager.setLevel(0);
										damager.setTotalExperience(damagerExp);
										return;
									}
								}
							}
							return;
						}
					}
				}, 1);
				return;
			}
		}
	}
}
