package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class BookFireworks implements Listener {
	@EventHandler
	private void playerInteractEvent(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOOK)
				|| event.getPlayer().getInventory().firstEmpty() <= 0) {
			return;
		} else {
			ItemStack book = new ItemStack(Material.getMaterial(RandomPackage.getBookOptionsConfig().getString("DiscoverItem").toUpperCase()), 1);
			ItemMeta bookMeta = book.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			
			Random random = new Random();
			
			int randomBook = 0;
			
			String enchantBook = null;
			String bookRarity = null;
			
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Soul.Name")))) {
				if(EnchantBookNames.getSoulBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getSoulBookNames().size()); }
				bookRarity = "Soul.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getSoulBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Legendary.Name")))) {
				if(EnchantBookNames.getLegendaryBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getLegendaryBookNames().size()); }
				bookRarity = "Legendary.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getLegendaryBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Ultimate.Name")))) {
				if(EnchantBookNames.getUltimateBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getUltimateBookNames().size()); }
				bookRarity = "Ultimate.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getUltimateBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Elite.Name")))) {
				if(EnchantBookNames.getEliteBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getEliteBookNames().size()); }
				bookRarity = "Elite.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getEliteBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Unique.Name")))) {
				if(EnchantBookNames.getUniqueBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getUniqueBookNames().size()); }
				bookRarity = "Unique.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getUniqueBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getString("Simple.Name")))) {
				if(EnchantBookNames.getSimpleBookNames().size() == 0) { return; } else { randomBook = random.nextInt(EnchantBookNames.getSimpleBookNames().size()); }
				bookRarity = "Simple.";
				enchantBook = ChatColor.stripColor(EnchantBookNames.getSimpleBookNames().get(randomBook).replace(" X", "").replace(" IX", "").replace(" VIII", "").replace(" VII", "").replace(" VI", "").replace(" V", "").replace(" IV", "").replace(" III", "").replace(" II", "").replace(" I", "").replace(" ", ""));
			} else { return; }
			
			lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Success")).replace("%success%", "" + random.nextInt(100)));
			lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("SuccessAndDestroy.Destroy")).replace("%destroy%", "" + random.nextInt(100)));
			
			for(int o = 0; o < RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + bookRarity + enchantBook + ".BookLore").size(); o++) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getStringList("Enchantments." + bookRarity + enchantBook + ".BookLore").get(o)));
			}
			
			if(EnchantType.getArmorEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Armor")));
			} else if(EnchantType.getAxeEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Axe")));
			} else if(EnchantType.getBootEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Boot")));
			} else if(EnchantType.getBowEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Bow")));
			} else if(EnchantType.getChestplateEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Chestplate")));
			} else if(EnchantType.getHelmetEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Helmet")));
			} else if(EnchantType.getLeggingsEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Leggings")));
			} else if(EnchantType.getPickaxeEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Pickaxe")));
			} else if(EnchantType.getShovelEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Shovel")));
			} else if(EnchantType.getSwordEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Sword")));
			} else if(EnchantType.getToolEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Tool")));
			} else if(EnchantType.getWeaponEnchants().contains(enchantBook)) {
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.Weapon")));
			} else {
				lore.add(ChatColor.GRAY + "Unknown Enchant");
				event.getPlayer().sendMessage(ChatColor.GRAY + "bookRarity = " + bookRarity);
				event.getPlayer().sendMessage(ChatColor.GRAY + "enchantBook = " + enchantBook);
				event.getPlayer().sendMessage(ChatColor.RED + "Screenshot this, and send it to RandomHashTags ASAP");
			}
			
			lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlaceholderConfig().getString("BookEnchantTypes.DropOntoItem")));
			bookMeta.setLore(lore);
			
			if(bookRarity == "Soul.") {
				bookMeta.setDisplayName(EnchantBookNames.getSoulBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Soul.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Soul.DiscoverMessage").get(i).replace("%soulbook%", EnchantBookNames.getSoulBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.RED)
					.withFade(Color.FUCHSIA)
					.build());
					fm.setPower(2);
					f.setFireworkMeta(fm);
					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1, 1);
					
			} else if(bookRarity == "Legendary.") {
				bookMeta.setDisplayName(EnchantBookNames.getLegendaryBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Legendary.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Legendary.DiscoverMessage").get(i).replace("%legendarybook%", EnchantBookNames.getLegendaryBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.ORANGE)
					.withFade(Color.ORANGE)
					.build());
					fm.setPower(1);
					f.setFireworkMeta(fm);
					
			} else if(bookRarity == "Ultimate.") {
				bookMeta.setDisplayName(EnchantBookNames.getUltimateBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Ultimate.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Ultimate.DiscoverMessage").get(i).replace("%ultimatebook%", EnchantBookNames.getUltimateBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.FUCHSIA)
					.withFade(Color.YELLOW)
					.build());
					fm.setPower(1);
					f.setFireworkMeta(fm);
				
			} else if(bookRarity == "Elite.") {
				bookMeta.setDisplayName(EnchantBookNames.getEliteBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Elite.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Elite.DiscoverMessage").get(i).replace("%elitebook%", EnchantBookNames.getEliteBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.BLUE)
					.withFade(Color.AQUA)
					.build());
					fm.setPower(1);
					f.setFireworkMeta(fm);
				
			} else if(bookRarity == "Unique.") {
				bookMeta.setDisplayName(EnchantBookNames.getUniqueBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Unique.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Unique.DiscoverMessage").get(i).replace("%uniquebook%", EnchantBookNames.getUniqueBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.LIME)
					.withFade(Color.GREEN)
					.build());
					fm.setPower(1);
					f.setFireworkMeta(fm);
				
			} else if(bookRarity == "Simple.") {
				bookMeta.setDisplayName(EnchantBookNames.getSimpleBookNames().get(randomBook));
				for(int i = 0; i < RandomPackage.getBookOptionsConfig().getStringList("Simple.DiscoverMessage").size(); i++) {
					event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getBookOptionsConfig().getStringList("Simple.DiscoverMessage").get(i).replace("%simplebook%", EnchantBookNames.getSimpleBookNames().get(randomBook))));
				}
				
				Firework f = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffects(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.withFlicker()
						.with(FireworkEffect.Type.BALL)
					.withColor(Color.SILVER)
					.withFade(Color.GRAY)
					.build());
					fm.setPower(1);
					f.setFireworkMeta(fm);
				
			} else {
				return;
			}
			
			if(event.getPlayer().getInventory().getItemInMainHand().getAmount() > 1) {
				event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
			} else {
				event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
			}
			
			book.setItemMeta(bookMeta);
			event.getPlayer().getInventory().addItem(book);
			event.getPlayer().updateInventory();
			return;
		}
	}
}