package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Cleave implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || event.getEntity().isDead()
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Cleave").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 15;
							for(int i = 1; i <= 7; i++) {
								chance = chance + 15;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Cleave.Cleave" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									for(Entity entity : event.getEntity().getNearbyEntities(2, 2, 2)) {
										if(entity instanceof Player && entity instanceof Damageable) {
											Player nearbyplayer = (Player) entity;
											if(FPlayers.getInstance().getByPlayer(damager).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyplayer)) == null || FPlayers.getInstance().getByPlayer(damager).getRelationTo(FPlayers.getInstance().getByPlayer(nearbyplayer)) == Relation.ENEMY) {
												nearbyplayer.damage(event.getDamage() / (10 - i));
												entity.setVelocity(new Vector(0.0, entity.getVelocity().getY(), 0.0));
											}
										}
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
