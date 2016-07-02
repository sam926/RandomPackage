package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.PlayerInventory;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class PlagueCarrier implements Listener {
	
	private void spawnCreeper(final Player player, PlayerDeathEvent event) {
		if(event.getEntity().getKiller() instanceof Player) {
			Creeper creeper = player.getLocation().getWorld().spawn(player.getLocation(), Creeper.class);
			creeper.setCustomName(ChatColor.YELLOW + "PlagueCarrier");
			creeper.setCustomNameVisible(false);
			creeper.setCollidable(false);
			creeper.setPowered(true);
			creeper.setTarget(event.getEntity().getKiller());
			creeper.setCanPickupItems(false);
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void entityExplodeEvent(EntityExplodeEvent event) {
		System.out.println("location = " + event.getLocation());
	}
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		PlayerInventory playerInv = player.getInventory();
		
		if(playerInv.getLeggings() == null
				|| !(playerInv.getLeggings().hasItemMeta())
				|| !(playerInv.getLeggings().getItemMeta().hasLore())
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Unique.PlagueCarrier").equalsIgnoreCase("true"))) {
			return;
		} else {
			// ONLY WORKS WHEN THE PLAYER IS IN SURVIVAL MODE!
			if(playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier1.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier2.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier3.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier4.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier5.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier6.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier7.ItemLore")))
					|| playerInv.getLeggings().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier8.ItemLore")))
					&& player.getHealth() == 0
					&& player.getGameMode() == GameMode.SURVIVAL) {
				for(int i = 0; i <= 15; i++) {
					spawnCreeper(player, event);
				}
			} else {
				return;
			}
		}
	}
}
