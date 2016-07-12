package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class AutoSmelt implements Listener {
	
	@EventHandler
	private void playerInteractEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(event.isCancelled()
				|| player.getGameMode() == GameMode.CREATIVE
				|| player.getInventory().getItemInMainHand() == null
				|| !(player.getInventory().getItemInMainHand().hasItemMeta())
				|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(player.getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
				&& !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.AutoSmelt").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Random random = new Random();
						int chance = 20;
						for(int i = 1; i <= 3; i++) {
							chance = chance + 20;
							if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.AutoSmelt.AutoSmelt" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance) {
								if(event.getBlock().getType().equals(Material.GOLD_ORE)) {
									event.setCancelled(true);
									event.getBlock().setType(Material.AIR);
									event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT, i));
									return;
								} else if(event.getBlock().getType().equals(Material.IRON_ORE)) {
									event.setCancelled(true);
									event.getBlock().setType(Material.AIR);
									event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, i));
									return;
								} else {
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