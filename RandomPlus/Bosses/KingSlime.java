package me.randomHashTags.randomPackage.RandomPlus.Bosses;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class KingSlime implements Listener {
	private String kingSlimeName = ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("Bosses.KingSlime.Name"));
	private ArrayList<Player> rewards = new ArrayList<Player>();
	private void spawnKingSlime(final Player player, PlayerInteractEvent event) {
		Slime kingSlime = Bukkit.getPlayer(player.getName()).getWorld().spawn(event.getClickedBlock().getLocation(new Location(event.getClickedBlock().getWorld(), event.getClickedBlock().getLocation().getBlockX(), event.getClickedBlock().getLocation().getBlockY() + 3, event.getClickedBlock().getLocation().getBlockZ())), Slime.class);
		for(int i = 0; i < RandomPackage.getRandomPlusConfig().getStringList("Bosses.KingSlime.BroadcastMessage").size(); i++) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getStringList("Bosses.KingSlime.BroadcastMessage").get(i).replace("%coords%", "" + event.getClickedBlock().getLocation().getBlockX() + ", " + Math.addExact(event.getClickedBlock().getLocation().getBlockY(), 3) + ", " + event.getClickedBlock().getLocation().getBlockZ())));
		}
		kingSlime.setCustomName(kingSlimeName);
		kingSlime.setHealth(kingSlime.getMaxHealth());
		kingSlime.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 4));
		kingSlime.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 3));
		kingSlime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 3));
		kingSlime.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0));
		kingSlime.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 3));
		kingSlime.setCollidable(false);
		kingSlime.setCanPickupItems(false);
		kingSlime.setSize(6);
		event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getRandomPlusConfig().getString("Bosses.KingSlime.SummonMessage").replace("%playerName%", event.getPlayer().getName())));
	}
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.isCancelled() || !(event.getAction() == Action.RIGHT_CLICK_BLOCK)
				|| event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())) {
			return;
		} else {
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(kingSlimeName)) {
				spawnKingSlime(event.getPlayer(), event);
				return;
			} else {
				return;
			}
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player)) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			if(!(rewards.contains(damager))) {
				rewards.add(damager);
				return;
			} else {
				return;
			}
		}
	}
	@EventHandler
	private void entityDeathEvent(EntityDeathEvent event) {
		if(event.getEntity() instanceof Slime
				&& !(event.getEntity().getCustomName() == null)
				&& event.getEntity().getCustomName().equals(kingSlimeName)
				&& event.getEntity().getKiller() instanceof Player) {
			Slime slime = (Slime) event.getEntity();
			if(slime.getSize() == 6) {
				Random random = new Random();
				int randomUltimate = 4;
				int randomLegendary = 3;
				int randomLegendaryNumber = random.nextInt(randomLegendary);
				int randomUltimateNumber = random.nextInt(randomUltimate);
				ItemStack dropPackage1 = new ItemStack(Material.TRAPPED_CHEST, randomUltimateNumber);
				ItemStack dropPackage2 = new ItemStack(Material.TRAPPED_CHEST, randomLegendaryNumber);
				ItemMeta dropPackageMeta1 = dropPackage1.getItemMeta();
				ItemMeta dropPackageMeta2 = dropPackage2.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				
				if(Bukkit.getPluginManager().getPlugin("DropPackages") == null) {
					return;
				} else {
					dropPackageMeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Legendary.Name")));
					lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Legendary.Lore1")));
					lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Legendary.Lore2")));
					dropPackageMeta2.setLore(lore);
					dropPackageMeta2.setLore(lore);
					dropPackage2.setItemMeta(dropPackageMeta2);
					
					lore.clear();
					
					dropPackage1.setItemMeta(dropPackageMeta1);
					dropPackageMeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Ultimate.Name")));
					lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Ultimate.Lore1")));
					lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("DropPackages").getConfig().getString("Ultimate.Lore2")));
					dropPackageMeta1.setLore(lore);
					dropPackage1.setItemMeta(dropPackageMeta1);
				}
				
				for(int i = 0; i < rewards.size(); i++) {
					Bukkit.getPlayer(rewards.get(i).getName()).getInventory().addItem(dropPackage2);
					Bukkit.getPlayer(rewards.get(i).getName()).getInventory().addItem(dropPackage1);
				}
				rewards.clear();
				return;
			} else {
				return;
			}
		} else {
			return;
		}
	}
	@EventHandler
	private void slimeSplitEvent(SlimeSplitEvent event) {
		if(!(event.getEntity().getCustomName() == null)
				&& event.getEntity().getCustomName().equals(kingSlimeName)) {
			event.getEntity().setCustomName(null);
			return;
		} else {
			return;
		}
	}
}
