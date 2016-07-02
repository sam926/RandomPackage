package me.randomHashTags.randomPackage.RandomPlus.Events;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookLores;

public class gkitListener implements Listener {
	private static ArrayList<String> kitdelay = new ArrayList<String>();
	private static int delayTime = 0;
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(event.isCancelled()
				|| event.getCurrentItem() == null
				|| event.getCurrentItem().getType() == Material.AIR
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Name"))))) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			Random random = new Random();
			if(event.getRawSlot() >= RandomPackage.getGkitConfig().getInt("Slots")
					|| event.getRawSlot() <= 53
					&& event.getCurrentItem().hasItemMeta()
					&& event.getCurrentItem().getItemMeta().hasLore()
					&& event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitPermissions.Unavailable")))) {
				event.setCancelled(true);
				player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
				return;
			} else if(event.getCurrentItem().getType().name().endsWith("STAINED_GLASS_PANE")) {
				event.setCancelled(true);
				int slot = Math.addExact(event.getRawSlot(), 1);
				delayTime = RandomPackage.getGkitConfig().getInt("KitDelay.Kit" + slot);
				for(int i = 1; i <= 30; i++) {
					if(delayTime / 60 == i) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.Message").replace("%time%", i + " minutes")));
						return;
					} else if(delayTime / 3600 == i) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.Message").replace("%time%", i + " hours")));
						return;
					} else if(delayTime / 86400 == i) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.Message").replace("%time%", i + " days")));
						return;
					} else if(i == 30) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.Message").replace("%time%", "" + delayTime + " seconds")));
						return;
					}
				}
			} else {
				event.setCancelled(true);
				int slot = Math.addExact(event.getRawSlot(), 1), randomXp = 0;
				String randomEnchant = null, enchantRarity = null;
				ArrayList<String> enchants = new ArrayList<String>();
				delayTime = RandomPackage.getGkitConfig().getInt("KitDelay.Kit" + slot);
				ArrayList<String> lore = new ArrayList<String>();
				for(int i = 1; i <= 53; i++) {
					if(!(RandomPackage.getGkitConfig().getString("Kit" + i) == null)) {
						for(int j = 1; j <= 10; j++) {
							if(!(RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j) == null)
									&& event.getRawSlot() == RandomPackage.getGkitConfig().getInt("Kit" + i + ".Slot")) {
								lore.clear();
								ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
								ItemMeta itemMeta = item.getItemMeta();
								if(RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j + ".Item").equalsIgnoreCase("%RandomXp%")) {
									if(!(randomXp == 0)) {
										lore.clear();
										if(!(random.nextInt(2001) > 499)) { randomXp = 500; } else { randomXp = random.nextInt(2001); }
										item = new ItemStack(Material.EXP_BOTTLE, 1);
										if(!(Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw") == null)) {
											itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("BottleName")));
											lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("Value").replace("%value%", "" + randomXp)));
											lore.add(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Beast-XpWithDraw").getConfig().getString("BottleEnchanter").replace("%player%", "gkit")));
										} else {
											itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Experience Bottle " + ChatColor.GRAY + "(Throw)");
											lore.add(ChatColor.LIGHT_PURPLE + "Value " + ChatColor.WHITE + randomXp + " XP");
											lore.add(ChatColor.LIGHT_PURPLE + "Enchanter " + ChatColor.WHITE + " gkit");
											lore.add(ChatColor.RED + "Download Beast-XpWithDraw to use full amount");
										}
										itemMeta.setLore(lore);
										item.setItemMeta(itemMeta);
										player.getInventory().addItem(item);
										player.updateInventory();
										return;
									} else { return; }
								} else {
									item = new ItemStack(Material.matchMaterial(RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j + ".Item").toUpperCase()), RandomPackage.getGkitConfig().getInt("Kit" + i + ".Item" + j + ".Amount"), (byte) RandomPackage.getGkitConfig().getInt("Kit" + i + ".Item" + j + ".Data"));
									itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j + ".Name").replace("%playername%", player.getName())));
									// Lores
									for(int o = 0; o < RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").size(); o++) {
										if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%DivineImmolation%")) { randomEnchant = "Divine Immolation"; enchantRarity = "Soul";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Immortal%")) { randomEnchant = "Immortal"; enchantRarity = "Soul";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%NaturesWrath%")) { randomEnchant = "Natures Wrath"; enchantRarity = "Soul";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Immortal%")) { randomEnchant = "Immortal"; enchantRarity = "Soul";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Barbarian%")) { randomEnchant = "Barbarian"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%BloodLust%")) { randomEnchant = "Blood Lust"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Clarity%")) { randomEnchant = "Clarity"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%CreeperArmor%")) { randomEnchant = "Creeper Armor"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Deathbringer%")) { randomEnchant = "Deathbringer"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Devour%")) { randomEnchant = "Devour"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Disarmor%")) { randomEnchant = "Disarmor"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Drunk%")) { randomEnchant = "Drunk"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Enlighted%")) { randomEnchant = "Enlighted"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Gears%")) { randomEnchant = "Gears"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Inquisitive%")) { randomEnchant = "Inquisitive"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%KillAura%")) { randomEnchant = "KillAura"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Lifesteal%")) { randomEnchant = "Lifesteal"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Overload%")) { randomEnchant = "Overload"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Protection%")) { randomEnchant = "Protection"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Rage%")) { randomEnchant = "Rage"; enchantRarity = "Legendary";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Angelic%")) { randomEnchant = "Angelic"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Armored%")) { randomEnchant = "Armored"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%ArrowLifesteal%")) { randomEnchant = "Arrow Lifesteal"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Bleed%")) { randomEnchant = "Bleed"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Blessed%")) { randomEnchant = "Blessed"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Blind%")) { randomEnchant = "Blind"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Cleave%")) { randomEnchant = "Cleave"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Demonforged%")) { randomEnchant = "Demonforged"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Detonate%")) { randomEnchant = "Detonate"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Guardians%")) { randomEnchant = "Guardians"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Hardened%")) { randomEnchant = "Hardened"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Leadership%")) { randomEnchant = "Leadership"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Lucky%")) { randomEnchant = "Lucky"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%ObsidianShield%")) { randomEnchant = "ObsidianShield"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Piercing%")) { randomEnchant = "Piercing"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Poison%")) { randomEnchant = "Poison"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Shackle%")) { randomEnchant = "Shackle"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Silence%")) { randomEnchant = "Silence"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Spirits%")) { randomEnchant = "Spirits"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Venom%")) { randomEnchant = "Venom"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Wither%")) { randomEnchant = "Wither"; enchantRarity = "Ultimate";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%AntiGravity%")) { randomEnchant = "Anti Gravity"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Block%")) { randomEnchant = "Block"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Cactus%")) { randomEnchant = "Cactus"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%DoubleStrike%")) { randomEnchant = "Double Strike"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%EnderWalker%")) { randomEnchant = "Ender Walker"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Execute%")) { randomEnchant = "Execute"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Hellfire%")) { randomEnchant = "Hellfire"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%IceAspect%")) { randomEnchant = "Ice Aspect"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%IceFreeze%")) { randomEnchant = "Ice Freeze"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Implants%")) { randomEnchant = "Implants"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Infernal%")) { randomEnchant = "Infernal"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Poisoned%")) { randomEnchant = "Poisoned"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Pummel%")) { randomEnchant = "Pummel"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%RocketEscape%")) { randomEnchant = "Rocket Escape"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Shockwave%")) { randomEnchant = "Shockwave"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%SkillSwipe%")) { randomEnchant = "Skill Swipe"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%SmokeBomb%")) { randomEnchant = "Smoke Bomb"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Springs%")) { randomEnchant = "Springs"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Stormcaller%")) { randomEnchant = "Stormcaller"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Tank%")) { randomEnchant = "Tank"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Telepathy%")) { randomEnchant = "Telepathy"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Teleportation%")) { randomEnchant = "Teleportation"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Trap%")) { randomEnchant = "Trap"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%UndeadRuse%")) { randomEnchant = "Undead Ruse"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Valor%")) { randomEnchant = "Valor"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Vampire%")) { randomEnchant = "Vampire"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Voodoo%")) { randomEnchant = "Voodoo"; enchantRarity = "Elite";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Aquatic%")) { randomEnchant = "Aquatic"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%AutoSmelt%")) { randomEnchant = "Auto Smelt"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Commander%")) { randomEnchant = "Commander"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Cowification%")) { randomEnchant = "Cowification"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Curse%")) { randomEnchant = "Curse"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%EnderShift%")) { randomEnchant = "Ender Shift"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Experience%")) { randomEnchant = "Experience"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Explosive%")) { randomEnchant = "Explosive"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Featherweight%")) { randomEnchant = "Featherweight"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%DeepWounds%")) { randomEnchant = "Deep Wounds"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Frozen%")) { randomEnchant = "Frozen"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Molten%")) { randomEnchant = "Molten"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%ObsidianDestroyer%")) { randomEnchant = "Obsidian Destroyer"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Paralyze%")) { randomEnchant = "Paralyze"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%PlagueCarrier%")) { randomEnchant = "Plague Carrier"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Ragdoll%")) { randomEnchant = "Ragdoll"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Ravenous%")) { randomEnchant = "Ravenous"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Reforged%")) { randomEnchant = "Reforged"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%SelfDestruct%")) { randomEnchant = "SelfDestruct"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%SpiritLink%")) { randomEnchant = "SpiritLink"; enchantRarity = "Unique";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Confusion%")) { randomEnchant = "Confusion"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Decapitation%")) { randomEnchant = "Decapitation"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Epicness%")) { randomEnchant = "Epicness"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Glowing%")) { randomEnchant = "Glowing"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Haste%")) { randomEnchant = "Haste"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Headless%")) { randomEnchant = "Headless"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Healing%")) { randomEnchant = "Healing"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Insomnia%")) { randomEnchant = "Insomnia"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Lightning%")) { randomEnchant = "Lightning"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Nutrition%")) { randomEnchant = "Nutrition"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Obliterate%")) { randomEnchant = "Obliterate"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%Oxygenate%")) { randomEnchant = "Oxygenate"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%ThunderingBlow%")) { randomEnchant = "Thundering Blow"; enchantRarity = "Simple";
										} else if(RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o).equalsIgnoreCase("%RandomBook%")) { randomXp = random.nextInt(2001);
										} else {
											randomEnchant = null; enchantRarity = null;
											lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getStringList("Kit" + i + ".Item" + j + ".Lore").get(o)));
										}
										if(!(randomEnchant == null) && !(enchantRarity == null)) {
											if(enchantRarity == "Soul") {
												for(int p = 0; p < EnchantBookLores.getSoulItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getSoulItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getSoulItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else if(enchantRarity == "Legendary") {
												for(int p = 0; p < EnchantBookLores.getLegendaryItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getLegendaryItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getLegendaryItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else if(enchantRarity == "Ultimate") {
												for(int p = 0; p < EnchantBookLores.getUltimateItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getUltimateItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getUltimateItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else if(enchantRarity == "Elite") {
												for(int p = 0; p < EnchantBookLores.getEliteItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getEliteItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getEliteItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else if(enchantRarity == "Unique") {
												for(int p = 0; p < EnchantBookLores.getUniqueItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getUniqueItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getUniqueItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else if(enchantRarity == "Simple") {
												for(int p = 0; p < EnchantBookLores.getSimpleItemLores().size(); p++) {
													if(ChatColor.stripColor(EnchantBookLores.getSimpleItemLores().get(p)).startsWith(randomEnchant)) {
														enchants.add(EnchantBookLores.getSimpleItemLores().get(p));
													}
												}
												if(!(enchants.size() == 0)) { lore.add(enchants.get(random.nextInt(enchants.size()))); }
												enchants.clear();
											} else {
												return;
											}
										}
									}
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									// Enchants
									for(int o = 1; o <= 5; o++) {
										if(!(RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j + ".Enchant" + o) == null)
												&& !(RandomPackage.getGkitConfig().getString("Kit" + i + ".Item" + j + ".Enchant" + o + "Level") == null)) {
											item.addEnchantment(Enchantment.getById(RandomPackage.getGkitConfig().getInt("Kit" + i + ".Item" + j + ".Enchant" + o)), RandomPackage.getGkitConfig().getInt("Kit" + i + ".Item" + j + ".Enchant" + o + "Level"));
										}
									}
									event.getWhoClicked().getInventory().addItem(item);
								}
							}
						}
					}
				}
			ItemStack item = new ItemStack(Material.getMaterial(RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Item").toUpperCase()), RandomPackage.getGkitConfig().getInt("KitDelay.DelayOptions.Amount"), (byte) RandomPackage.getGkitConfig().getInt("KitDelay.DelayOptions.Color"));
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.DisplayName")));
			lore.clear();
			int hasLore = 0;
			for(int i = 1; i <= 30; i++) {
				if(delayTime / 60 == i && hasLore == 0) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore1").replace("%time%", i + " minutes")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", i + " minutes")));
					hasLore = 1;
				} else if(delayTime / 3600 == i && hasLore == 0) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore1").replace("%time%", i + " hours")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", i + " hours")));
					hasLore = 1;
				} else if(delayTime / 86400 == i && hasLore == 0) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore1").replace("%time%", i + " days")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", i + " days")));
					hasLore = 1;
				} else if(i == 30 && hasLore == 0) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore1").replace("%time%", "" + delayTime + " seconds")));
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("KitDelay.DelayOptions.Lore2").replace("%time%", "" + delayTime + " seconds")));
					hasLore = 1;
				}
			}
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
			player.getOpenInventory().setItem(event.getRawSlot(), item);
			kitdelay.add(player.getName() + event.getRawSlot());
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					kitdelay.remove(player.getName() + event.getRawSlot());
					if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Name")))) {
						lore.clear();
						ItemStack item = new ItemStack(Material.getMaterial(RandomPackage.getGkitConfig().getString("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Item").toUpperCase()), 1, (byte) RandomPackage.getGkitConfig().getInt("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Data"));
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getString("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Name")));
						if(RandomPackage.getGkitConfig().getString("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Enchanted").equalsIgnoreCase("true")) { itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true); itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS); }
						for(int i = 0; i < RandomPackage.getGkitConfig().getStringList("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Lore").size(); i++) {
							lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getGkitConfig().getStringList("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Gui.Lore").get(i)));
						}
						itemMeta.setLore(lore);
						item.setItemMeta(itemMeta);
						player.getOpenInventory().setItem(RandomPackage.getGkitConfig().getInt("Kit" + Math.addExact(event.getRawSlot(), 1) + ".Slot"), item);
						player.updateInventory();
						return;
					} else {
						return;
					}
				}
			}, delayTime * 20);
			return;
		}
	}
}
	public static ArrayList<String> getKitDelays() {
		return kitdelay;
	}
	public static int getDelayTime() {
		return delayTime;
	}
}
