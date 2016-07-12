package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Guardians implements Listener {
	@EventHandler
	private void entityTargetEvent(EntityTargetEvent event) {
		if(event.getTarget() instanceof Player
				&& event.getEntity().getType() == EntityType.IRON_GOLEM
				&& event.getEntity().getName().contains(event.getTarget().getName())) {
			event.setCancelled(true);
			return;
		}
	}
	private void spawnIG(final Player player, EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player damager = (Player) event.getDamager();
			IronGolem ig = player.getWorld().spawn(player.getLocation(), IronGolem.class);
			ig.setCanPickupItems(false);
			ig.setHealth(75);
			ig.setCollidable(false);
			ig.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
			ig.setCustomName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("GuardiansName").replace("%player%", player.getName())));
			ig.setTarget(damager);
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					ig.remove();
					return;
				}
			}, 200L);
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void playerEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Guardians").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player player = (Player) event.getEntity();
						Random random = new Random();
						int chance = 4;
						for(int i = 1; i <= 10; i++) {
							chance = chance + 1;
							if(!(player.getInventory().getChestplate() == null) && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
									&& player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Guardians.Guardians" + i + ".ItemLore")))
									&& random.nextInt(100) < chance) {
								spawnIG(player, event);
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