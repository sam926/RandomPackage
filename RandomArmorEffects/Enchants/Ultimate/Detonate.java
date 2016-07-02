package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Detonate implements Listener {
	
	@EventHandler
	private void detonateEvent(BlockBreakEvent event) {
		if(event.isCancelled()
				|| event.getPlayer().getGameMode() == GameMode.CREATIVE
				|| event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("PICKAXE"))
				&& !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("AXE"))
				&& !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("SPADE"))
				&& !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("HOE"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Ultimate.Detonate").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player player = event.getPlayer();
			Random random = new Random();
			int randomChance = 100;
			int chance = 35;
			for(int i = 1; i <= 9; i++) {
				chance = chance + 5;
				if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Detonate.Detonate" + i + ".ItemLore")))
						&& random.nextInt(randomChance) <= chance) {
					if(event.isCancelled()
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() + 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("BEDROCK")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() - 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("BEDROCK")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() + 1)).getType().name().endsWith("BEDROCK")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY() + 1, event.getBlock().getLocation().getZ())).getType().name().endsWith("BEDROCK")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() - 1)).getType().name().endsWith("BEDROCK")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() + 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("OBSIDIAN")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() - 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("OBSIDIAN")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY() + 1, event.getBlock().getLocation().getZ())).getType().name().endsWith("OBSIDIAN")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() + 1)).getType().name().endsWith("OBSIDIAN")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() - 1)).getType().name().endsWith("OBSIDIAN")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() + 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("CHEST")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() - 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("CHEST")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY() + 1, event.getBlock().getLocation().getZ())).getType().name().endsWith("CHEST")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() + 1)).getType().name().endsWith("CHEST")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() - 1)).getType().name().endsWith("CHEST")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() + 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("BARRIER")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() - 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).getType().name().endsWith("BARRIER")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY() + 1, event.getBlock().getLocation().getZ())).getType().name().endsWith("BARRIER")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() + 1)).getType().name().endsWith("BARRIER")
							|| player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() - 1)).getType().name().endsWith("BARRIER")) {
						return;
					} else {
						Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
							public void run() {
								if(event.isCancelled()) {
									return;
								} else {
									if(player.getWorld().getGameRuleValue("logAdminCommands").equalsIgnoreCase("true")) { player.getWorld().setGameRuleValue("logAdminCommands", "false"); }
									if(player.getWorld().getGameRuleValue("commandBlockOutput").equalsIgnoreCase("true")) { player.getWorld().setGameRuleValue("commandBlockOutput", "false"); }
									if(player.getWorld().getGameRuleValue("sendCommandFeedback").equalsIgnoreCase("true")) { player.getWorld().setGameRuleValue("sendCommandFeedback", "false"); }
									for(int o = 0; o <= 5; o++) {
										Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute " + player.getName() + " ~ ~ ~ particle flame " + event.getBlock().getLocation().getX() + " " + event.getBlock().getLocation().getY() + " " + event.getBlock().getLocation().getZ() + " 1 1 1 0 100");
									}
									player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5, 1);
									player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() + 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).breakNaturally();
									player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX() - 1, event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ())).breakNaturally();
									player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY() + 1, event.getBlock().getLocation().getZ())).breakNaturally();
									player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() + 1)).breakNaturally();
									player.getWorld().getBlockAt(new Location(event.getBlock().getWorld(), event.getBlock().getLocation().getX(), event.getBlock().getLocation().getY(), event.getBlock().getLocation().getZ() - 1)).breakNaturally();
									return;
								}
							}
						}, 1);
						return;
					}
				}
			}
			return;
		}
	}
}
