package me.randomHashTags.randomPackage.RandomArmorEffects.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class kitop implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return true;
		} else {
			ItemStack item = new ItemStack(Material.COBBLESTONE, 1);
			ArrayList<String> lore = new ArrayList<String>();
			Player player = (Player) sender;
			
			for(int i = 1; i <= 10; i++) {
				ItemMeta itemMeta = item.getItemMeta();
				if(i == 1) {
					item = new ItemStack(Material.DIAMOND_SWORD, 1);
				} else if(i == 2) {
					item = new ItemStack(Material.DIAMOND_AXE, 1);
				} else if(i == 3) {
					item = new ItemStack(Material.BOW, 1);
				} else if(i == 4) {
					item = new ItemStack(Material.DIAMOND_HELMET, 1);
				} else if(i == 5) {
					item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				} else if(i == 6) {
					item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				} else if(i == 7) {
					item = new ItemStack(Material.DIAMOND_BOOTS, 1);
				} else if(i == 8) {
					item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				} else if(i == 9) {
					item = new ItemStack(Material.COOKED_BEEF, 32);
				} else if(i == 10) {
					item = new ItemStack(Material.ARROW, 1);
				}
				if(i == 4 || i == 5 || i == 6 || i == 7) {
					itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				} else if(i == 1 || i == 2) {
					itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
					itemMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
				}
				if(i < 9) {
					itemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
				}
				if(i == 1) {
					item.addEnchantment(Enchantment.DURABILITY, 3);
					itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Inquisitive.Inquisitive4.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Lifesteal.Lifesteal5.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Rage.Rage6.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Blind.Blind3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Demonforged.Demonforged4.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Poison.Poison3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Featherweight.Featherweight3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.DeepWounds.DeepWounds3.ItemLore")));
				} else if(i == 2) {
					itemMeta.removeEnchant(Enchantment.FIRE_ASPECT);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Rage.Rage6.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Confusion.Confusion3.ItemLore")));
				} else if(i == 3) {
					itemMeta.removeEnchant(Enchantment.DAMAGE_ALL);
					itemMeta.removeEnchant(Enchantment.LOOT_BONUS_MOBS);
					itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
					itemMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
					itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
					itemMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Explosive.Explosive5.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Lightning.Lightning3.ItemLore")));
				} else if(i == 4) {
					itemMeta.removeEnchant(Enchantment.ARROW_DAMAGE);
					itemMeta.removeEnchant(Enchantment.ARROW_FIRE);
					itemMeta.removeEnchant(Enchantment.ARROW_INFINITE);
					itemMeta.removeEnchant(Enchantment.ARROW_KNOCKBACK);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Drunk.Drunk4.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Hardened.Hardened3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus2.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Aquatic.Aquatic1.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.EnderShift.EnderShift3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Glowing.Glowing1.ItemLore")));
				} else if(i == 5) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Overload.Overload3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Armored.Armored4.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Guardians.Guardians10.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Valor.Valor5.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Curse.Curse5.ItemLore")));
				} else if(i == 6) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.ObsidianShield.ObsidianShield1.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Wither.Wither5.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus2.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier1.ItemLore")));
				} else if(i == 7) {
					itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Gears.Gears3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.AntiGravity.AntiGravity3.ItemLore")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.RocketEscape.RocketEscape3.ItemLore")));
				} else if(i == 8) {
					itemMeta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
					itemMeta.removeEnchant(Enchantment.PROTECTION_FALL);
					itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
					itemMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
					itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Haste.Haste3.ItemLore")));
				} else {
					itemMeta.removeEnchant(Enchantment.DURABILITY);
					itemMeta.removeEnchant(Enchantment.LOOT_BONUS_BLOCKS);
					itemMeta.removeEnchant(Enchantment.SILK_TOUCH);
					itemMeta.removeEnchant(Enchantment.DIG_SPEED);
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				
				
				player.getInventory().addItem(item);
				lore.clear();
			}
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
			return true;
		}
	}
}