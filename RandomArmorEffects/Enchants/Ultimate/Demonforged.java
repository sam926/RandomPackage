package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Demonforged implements Listener {
	
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Demonforged").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player victim = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			
			Random random = new Random();
		
			if(damager.getInventory().getItemInMainHand() == null
					|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							int chance = 9;
							int durability = 0;
							for(int i = 1; i <= 4; i++) {
								chance = chance + 1;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Demonforged.Demonforged" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									durability = chance - 9;
									if(!(victim.getInventory().getHelmet() == null)) {
										victim.getInventory().getHelmet().setDurability((short) (victim.getInventory().getHelmet().getDurability() - durability));
									}
									if(!(victim.getInventory().getChestplate() == null)) {
										victim.getInventory().getChestplate().setDurability((short) (victim.getInventory().getChestplate().getDurability() - durability));
									}
									if(!(victim.getInventory().getLeggings() == null)) {
										victim.getInventory().getLeggings().setDurability((short) (victim.getInventory().getLeggings().getDurability() - durability));
									}
									if(!(victim.getInventory().getBoots() == null)) {
										victim.getInventory().getBoots().setDurability((short) (victim.getInventory().getBoots().getDurability() - durability));
									}
									return;
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