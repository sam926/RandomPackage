package me.randomHashTags.randomPackage.RandomArmorEffects.Soul;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class splitsouls implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		} else {
			Player player = (Player) sender;
			if(player.getInventory().getItemInMainHand() == null
					|| player.getInventory().getItemInMainHand().getType() == Material.AIR
					|| !(player.getInventory().getItemInMainHand().hasItemMeta())
					|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.ItemHasNoSoulTracker")));
				return true;
			} else {
				if(args.length == 0) {
					if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "0")))
							|| player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "0")))
							|| player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "0")))
							|| player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "0")))
							|| player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "0")))) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.NoSouls")));
						return true;
					} else {
						ItemStack gem = new ItemStack(Material.EMERALD, 1);
						ItemMeta gemMeta = gem.getItemMeta();
						ArrayList<String> lore = new ArrayList<String>();
						
						ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
						ItemMeta itemInMainHandMeta = itemInMainHand.getItemMeta();
						
						for(int i = 0; i < RandomPackage.getSoulConfig().getStringList("SoulGem.Lore").size(); i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getStringList("SoulGem.Lore").get(i)));
						}
						
						for(int i = 0; i <= 199; i++) {
							/*
							 * Split Legendary Souls
							 */
							if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + i)))) {
								
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.SplitLegendary").replace("%souls%", "" + i)));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.AddSoulGems").replace("%souls%", "" + i * 5)));
								
								gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGem.Name").replace("%souls%", "" + i * 5)));
								gemMeta.setLore(lore);
								gem.setItemMeta(gemMeta);
								
								lore.clear();
								player.getInventory().addItem(gem);
								
								lore.addAll(itemInMainHandMeta.getLore());
								lore.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "" + i)));
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Legendary.ApplyLore").replace("%souls%", "0")));
								itemInMainHandMeta.setLore(lore);
								itemInMainHand.setItemMeta(itemInMainHandMeta);
								
								player.getInventory().setItemInMainHand(itemInMainHand);
								player.updateInventory();
								
								return true;
							/*
							 * Split Ultimate Souls
							 */
							} else if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + i)))) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.SplitUltimate").replace("%souls%", "" + i)));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.AddSoulGems").replace("%souls%", "" + i * 4)));
								
								gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGemOptions.Name").replace("%souls%", "" + i * 4)));
								gemMeta.setLore(lore);
								gem.setItemMeta(gemMeta);
								
								lore.clear();
								player.getInventory().addItem(gem);
								
								lore.addAll(itemInMainHandMeta.getLore());
								lore.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "" + i)));
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Ultimate.ApplyLore").replace("%souls%", "0")));
								itemInMainHandMeta.setLore(lore);
								itemInMainHand.setItemMeta(itemInMainHandMeta);
								
								player.getInventory().setItemInMainHand(itemInMainHand);
								player.updateInventory();
								
								return true;
							/*
							 * Split Elite Souls
							 */
							} else if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + i)))) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.SplitElite").replace("%souls%", "" + i)));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.AddSoulGems").replace("%souls%", "" + i * 3)));
								
								gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGemOptions.Name").replace("%souls%", "" + i * 3)));
								gemMeta.setLore(lore);
								gem.setItemMeta(gemMeta);
								
								lore.clear();
								player.getInventory().addItem(gem);
								
								lore.addAll(itemInMainHandMeta.getLore());
								lore.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "" + i)));
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Elite.ApplyLore").replace("%souls%", "0")));
								itemInMainHandMeta.setLore(lore);
								itemInMainHand.setItemMeta(itemInMainHandMeta);
								
								player.getInventory().setItemInMainHand(itemInMainHand);
								player.updateInventory();
								
								return true;
							/*
							 * Split Unique Souls
							 */
							} else if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + i)))) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.SplitUnique").replace("%souls%", "" + i)));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.AddSoulGems").replace("%souls%", "" + i * 2)));
								
								gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGemOptions.Name").replace("%souls%", "" + i * 2)));
								gemMeta.setLore(lore);
								gem.setItemMeta(gemMeta);
								
								lore.clear();
								player.getInventory().addItem(gem);
								
								lore.addAll(itemInMainHandMeta.getLore());
								lore.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "" + i)));
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Unique.ApplyLore").replace("%souls%", "0")));
								itemInMainHandMeta.setLore(lore);
								itemInMainHand.setItemMeta(itemInMainHandMeta);
								
								player.getInventory().setItemInMainHand(itemInMainHand);
								player.updateInventory();
								
								return true;
							/*
							 * Split Simple Souls
							 */
							} else if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + i)))) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.SplitSimple").replace("%souls%", "" + i)));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SplitSouls.AddSoulGems").replace("%souls%", "" + i * 1)));
								
								gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulGemOptions.Name").replace("%souls%", "" + i * 1)));
								gemMeta.setLore(lore);
								gem.setItemMeta(gemMeta);
								
								lore.clear();
								player.getInventory().addItem(gem);
								
								lore.addAll(itemInMainHandMeta.getLore());
								lore.remove(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "" + i)));
								lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("SoulTrackers.Simple.ApplyLore").replace("%souls%", "0")));
								itemInMainHandMeta.setLore(lore);
								itemInMainHand.setItemMeta(itemInMainHandMeta);
								
								player.getInventory().setItemInMainHand(itemInMainHand);
								player.updateInventory();
								
								return true;
							}
						}
					}
				} else if(args.length == 1) {
					return true;
				} else {
					return true;
				}
			}
		}
		return true;
	}
}
