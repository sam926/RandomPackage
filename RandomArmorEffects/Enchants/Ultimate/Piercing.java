package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Piercing implements Listener {
	private Player player = null;
	private ArrayList<String> bow = new ArrayList<String>();
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager().getType().name().endsWith("ARROW"))
				|| !(event.getEntity() instanceof Damageable)
				|| player == null
				|| !(bow.contains(player.getName()))
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Piercing").equalsIgnoreCase("true"))) { return;
		} else {
			LivingEntity entity = (LivingEntity) event.getEntity();
			if(entity.getHealth() - event.getDamage() > 0) {
				entity.setHealth(entity.getHealth() - event.getDamage());
				return;
			} else {
				entity.setHealth(0);
				return;
			}
		}
	}
	@EventHandler
	private void entityShootBowEvent(EntityShootBowEvent event) {
		if(!(event.getEntity() instanceof Player)) { return;
		} else {
			Player player = (Player) event.getEntity();
			if(!(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore()) || bow.contains(player.getName())) { return;
			} else {
				Random random = new Random();
				int chance = 10;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 10;
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Piercing.Piercing" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						this.player = player;
						bow.add(player.getName());
						Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
							public void run() {
								bow.remove(player.getName());
								return;
							}
						}, 80);
						return;
					}
				}
				return;
			}
		}
	}
}
