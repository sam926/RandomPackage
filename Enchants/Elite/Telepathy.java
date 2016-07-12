package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

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

public class Telepathy implements Listener {
	@EventHandler
	private void blockBreakEvent(BlockBreakEvent event) {
		if(event.isCancelled() || event.getPlayer().getGameMode() == GameMode.CREATIVE
				|| event.getPlayer().getInventory().getItemInMainHand() == null || !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Elite.Telepathy").equalsIgnoreCase("true"))) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { event.getPlayer().sendMessage("cancelled"); return;
					} else {
						Player player = event.getPlayer();
						Random random = new Random();
						int chance = 40;
						for(int i = 1; i <= 4; i++) {
							chance = chance + 10;
							if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Telepathy.Telepathy" + i + ".ItemLore")))
									&& random.nextInt(100) <= chance) {
								@SuppressWarnings("deprecation")
								ItemStack item = new ItemStack(event.getBlock().getType(), 1, (byte) event.getBlock().getData());
								player.getInventory().addItem(item);
								event.setCancelled(true);
								event.getBlock().setType(Material.AIR);
								player.updateInventory();
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