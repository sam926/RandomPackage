package me.randomHashTags.randomPackage.givedpItems;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class MysteryMobSpawners implements Listener {
	/*
	 * 1.9.X | 1.10
	 */
	@EventHandler
	private void mysterMobSpawners19X(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.MOB_SPAWNER)
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Name"))))
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())) {
			return;
		} else {
			event.setCancelled(true);
			if(event.getPlayer().getInventory().getItemInMainHand().getAmount() > 1) { event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
			} else { event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR)); }
			Random random = new Random();
			int randomChance = random.nextInt(9);
			
			String spawnerType = null;
			String spawnerName = null;
			
			if(randomChance == 0) {
				spawnerType = "Enderman"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Endermen.DisplayName"));
			} else if(randomChance == 1) {
				spawnerType = "PigZombie"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("PigZombie.DisplayName"));
			} else if(randomChance == 2) {
				spawnerType = "Cow"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Cow.DisplayName"));
			} else if(randomChance == 3) {
				spawnerType = "Creeper"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Creeper.DisplayName"));
			} else if(randomChance == 4) {
				spawnerType = "Blaze"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Blaze.IronGolem"));
			} else if(randomChance == 5) {
				spawnerType = "VillagerGolem"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("IronGolem.DisplayName"));
			} else if(randomChance == 6) {
				spawnerType = "MushroomCow"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("MooshroomCow.DisplayName"));
			} else if(randomChance == 7) {
				spawnerType = "LavaSlime"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("MagmaCube.DisplayName"));
			} else if(randomChance == 8) {
				spawnerType = "Ghast"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Ghast.DisplayName"));
			} else {
				return;
			}
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + event.getPlayer().getName() + " mob_spawner 1 0 {BlockEntityTag:{SpawnData:{id:" + spawnerType + "}}, display:{Name:" + spawnerName + "}, SpawnPotentials:[" + spawnerType + "]}");
			if(RandomPackage.getMysteryMobSpawnerConfig().getString("MessageOnDiscovery").equalsIgnoreCase("true")) {
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString(spawnerType.replace("MushroomCow", "MooshroomCow").replace("VillagerGolem", "IronGolem").replace("LavaSlime", "MagmaCube").replace("Enderman", "Endermen") + ".DiscoverMessage")));
				return;
			} else {
				return;
			}
		}
	}
	@EventHandler
	private void spawnerSpawnEvent(SpawnerSpawnEvent event) {
		String spawnerType = event.getSpawner().getCreatureTypeName();
		EntityType spawnedType = event.getSpawner().getSpawnedType();
		Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
			public void run() {
				event.getSpawner().setCreatureTypeByName(spawnerType);
				event.getSpawner().setSpawnedType(spawnedType);
				return;
			}
		}, 1);
		return;
	}
	/*
	 * 1.8.X
	 *//*
	@EventHandler
	private void mysteryMobSpawners18X(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInHand() == null
				|| !(event.getPlayer().getInventory().getItemInHand().getType() == Material.MOB_SPAWNER)
				|| !(event.getPlayer().getInventory().getItemInHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(RandomPackage.getMysteryMobSpawnerConfig().getString("Name")))
				|| !(event.getPlayer().getInventory().getItemInHand().getItemMeta().hasLore())) {
			return;
		} else {
			event.setCancelled(true);
			if(event.getPlayer().getInventory().getItemInHand().getAmount() > 1) { event.getPlayer().getInventory().getItemInHand().setAmount(event.getPlayer().getInventory().getItemInHand().getAmount() - 1);
			} else { event.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR)); }
			Random random = new Random();
			int randomChance = random.nextInt(9);
			
			String spawnerType = null;
			String spawnerName = null;
			
			if(randomChance == 0) {
				spawnerType = "Enderman"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Endermen.DisplayName"));
			} else if(randomChance == 1) {
				spawnerType = "PigZombie"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("PigZombie.DisplayName"));
			} else if(randomChance == 2) {
				spawnerType = "Cow"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Cow.DisplayName"));
			} else if(randomChance == 3) {
				spawnerType = "Creeper"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Creeper.DisplayName"));
			} else if(randomChance == 4) {
				spawnerType = "Blaze"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Blaze.DisplayName"));
			} else if(randomChance == 5) {
				spawnerType = "VillagerGolem"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("IronGolem.DisplayName"));
			} else if(randomChance == 6) {
				spawnerType = "MushroomCow"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("MooshroomCow.DisplayName"));
			} else if(randomChance == 7) {
				spawnerType = "LavaSlime"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("MagmaCube.DisplayName"));
			} else if(randomChance == 8) {
				spawnerType = "Ghast"; spawnerName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getMysteryMobSpawnerConfig().getString("Ghast.DisplayName"));
			} else {
				return;
			}
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + event.getPlayer().getName() + " mob_spawner 1 0 {BlockEntityTag:{EntityId:" + spawnerType + "}, display:{Name:" + spawnerName + "}}");
			if(RandomPackage.getMysteryMobSpawnerConfig().getString("MessageOnDiscovery").equalsIgnoreCase("true")) {
				event.getPlayer().sendMessage(RandomPackage.getMysteryMobSpawnerConfig().getString(spawnerType.replace("MushroomCow", "MooshroomCow").replace("VillagerGolem", "IronGolem").replace("LavaSlime", "MagmaCube").replace("Enderman", "Endermen") + ".DiscoverMessage"));
				return;
			} else {
				return;
			}
		}
	}*/
}
