package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Angelic implements Listener {
	@EventHandler
	private void entityDamageByEntityEvebt(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Angelic").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Player player = (Player) event.getEntity();
						Random random = new Random();
						int chance = 6;
						int level = 0;
						for(int i = 1; i <= 5; i++) {
							chance = chance + 2;
							if(!(random.nextInt(100) <= chance)) { return;
							} else {
								if(!(player.getInventory().getHelmet() == null) && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().hasLore()
										&& player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Angelic.Angelic" + i + ".ItemLore")))
										|| !(player.getInventory().getChestplate() == null)
										&& player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().hasLore()
										&& player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Angelic.Angelic" + i + ".ItemLore")))
										|| !(player.getInventory().getLeggings() == null)
										&& player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().hasLore()
										&& player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Angelic.Angelic" + i + ".ItemLore")))
										|| !(player.getInventory().getBoots() == null)
										&& player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore()
										&& player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Angelic.Angelic" + i + ".ItemLore")))) {
									player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, i * 20, level));
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