package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.util.Vector;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Rage implements Listener {
	private static ArrayList<String> rage = new ArrayList<String>();
	private static ArrayList<Player> ragedPlayers = new ArrayList<Player>();
	private static EntityType type = null;
	@EventHandler
	private void entityDamageByEntityEvents(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Rage").equalsIgnoreCase("true"))) {
			return;
		} else {
			if(!(event.getEntity() instanceof Player)) {
				Player damager = (Player) event.getDamager();
				if(damager.getInventory().getItemInMainHand() == null
						|| !(damager.getInventory().getItemInMainHand().hasItemMeta())
						|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
						|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))
						&& !(damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
					return;
				}
				if(!(ragedPlayers.contains(damager))
						&& type == null) {
					ragedPlayers.add(damager);
					type = event.getEntity().getType();
				} else {
					double rageLevel = 1.0;
					if(event.getEntity().getType() == type) {
						rage.add(damager.getName() + 1);
						for(int i = 1; i <= 10; i++) {
							if(rage.contains(damager.getName() + i)) {
								rage.remove(damager.getName() + i);
								rage.add(damager.getName() + Math.addExact(i, 1));
								rageLevel = Math.addExact((int) rageLevel, i);
								
								for(int o = 1; o <= 6; o++) {
									rageLevel = rageLevel + 0.1;
									if(o == 5) {
										rageLevel = Math.addExact((int) rageLevel, 1);
									} else if(o == 6) {
										rageLevel = Math.addExact((int) rageLevel, 2);
									}
									if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Rage.Rage" + o + ".ItemLore")))) {
										event.setDamage(rageLevel * event.getDamage());
										event.getEntity().setVelocity(new Vector(-damager.getLocation().getDirection().getX(), damager.getLocation().getDirection().getY(), -damager.getLocation().getDirection().getZ()).multiply(3));
										return;
									}
								}
							} else {
								rage.add(damager.getName() + 1);
								return;
							}
						}
						return;
					} else {
						return;
					}
				}
			} else {
				return;
			}
		}
	}
	@EventHandler
	private void entityDeathEvent(EntityDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)) { return;
		} else {
			event.getEntity().setVelocity(new Vector(event.getEntity().getKiller().getLocation().getDirection().getX(), event.getEntity().getKiller().getLocation().getDirection().getY(), event.getEntity().getKiller().getLocation().getDirection().getZ()));
			return;
		}
	}
	public static ArrayList<String> getRageLevel() {
		return rage;
	}
}
