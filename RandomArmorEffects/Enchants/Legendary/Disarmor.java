package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Disarmor implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Legendary.Disarmor").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			if(damager.getInventory().getItemInMainHand() == null
					|| !(damager.getInventory().getItemInMainHand().hasItemMeta())
					|| !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) { return;
						} else {
							Random random = new Random();
							int chance = 0;
							for(int i = 1; i <= 8; i++) {
								chance = chance + 1;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Disarmor.Disarmor" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									if(victim.getHealth() >= 6
											|| victim.getInventory().getHelmet() == null
											&& victim.getInventory().getChestplate() == null
											&& victim.getInventory().getLeggings() == null
											&& victim.getInventory().getBoots() == null) {
										return;
									} else {
										ItemStack armor = new ItemStack(Material.AIR);
										String armorPiece = null;
										Random random2 = new Random();
										int randomChance2 = 4;
										int randomNumber2 = random2.nextInt(randomChance2);
										
										if(randomNumber2 == 0) {
											if(victim.getInventory().getHelmet() == null) {
												return;
											} else {
												armor = victim.getInventory().getHelmet();
												victim.getInventory().setHelmet(null);
												armorPiece = "Helmet";
											}
										} else if(randomNumber2 == 1) {
											if(victim.getInventory().getChestplate() == null) {
												return;
											} else {
												armor = victim.getInventory().getChestplate();
												victim.getInventory().setChestplate(null);
												armorPiece = "Chestplate";
											}
										} else if(randomNumber2 == 2) {
											if(victim.getInventory().getLeggings() == null) {
												return;
											} else {
												armor = victim.getInventory().getLeggings();
												victim.getInventory().setLeggings(null);;
												armorPiece = "Leggings";
											}
										} else if(randomNumber2 == 3) {
											if(victim.getInventory().getBoots() == null) {
												return;
											} else {
												armor = victim.getInventory().getBoots();
												victim.getInventory().setBoots(null);
												armorPiece = "Boots";
											}
										} else { armorPiece = null; return; }
										victim.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Disarmor.Message").replace("%armorPiece%", armorPiece)));
										
										if(victim.getInventory().firstEmpty() <= 0) { victim.getWorld().dropItemNaturally(victim.getLocation(), armor);
										} else { victim.getInventory().addItem(armor); }
										
										victim.playSound(victim.getLocation(), Sound.BLOCK_NOTE_PLING, 1, 2);
										armor.setType(Material.AIR);
										damager.updateInventory();
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
}
