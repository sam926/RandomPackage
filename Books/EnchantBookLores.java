package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class EnchantBookLores implements Listener {
	private static ArrayList<String> soulBookItemLores = new ArrayList<String>();
	private static ArrayList<String> legendaryBookItemLores = new ArrayList<String>();
	private static ArrayList<String> ultimateBookItemLores = new ArrayList<String>();
	private static ArrayList<String> eliteBookItemLores = new ArrayList<String>();
	private static ArrayList<String> uniqueBookItemLores = new ArrayList<String>();
	private static ArrayList<String> simpleBookItemLores = new ArrayList<String>();
	
	
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		String soulBookItemLores = null;
		String legendaryBookItemLores = null;
		String ultimateBookItemLores = null;
		String eliteBookItemLores = null;
		String uniqueBookItemLores = null;
		String simpleBookItemLores = null;
		
		for(int i = 1; i <= 3; i++) {
			if(i == 1) { soulBookItemLores = "DivineImmolation"; 
			} else if(i == 2) { soulBookItemLores = "Immortal";
			} else if(i == 3) { soulBookItemLores = "NaturesWrath"; }
			for(int o = 1; o <= 5; o++) {
				if(!(soulBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore") == null)
						&& !(soulBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.soulBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Soul." + soulBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.soulBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 17; i++) {
			if(i == 1) {
				legendaryBookItemLores = "Barbarian";
			} else if(i == 2) {
				legendaryBookItemLores = "BloodLust";
			} else if(i == 3) {
				legendaryBookItemLores = "Clarity";
			} else if(i == 4) {
				legendaryBookItemLores = "CreeperArmor";
			} else if(i == 5) {
				legendaryBookItemLores = "Deathbringer";
			} else if(i == 6) {
				legendaryBookItemLores = "Devour";
			} else if(i == 7) {
				legendaryBookItemLores = "Disarmor";
			} else if(i == 8) {
				legendaryBookItemLores = "Drunk";
			} else if(i == 9) {
				legendaryBookItemLores = "Enlighted";
			} else if(i == 10) {
				legendaryBookItemLores = "Gears";
			} else if(i == 11) {
				legendaryBookItemLores = "Ghost";
			} else if(i == 12) {
				legendaryBookItemLores = "Inquisitive";
			} else if(i == 13) {
				legendaryBookItemLores = "KillAura";
			} else if(i == 14) {
				legendaryBookItemLores = "Lifesteal";
			} else if(i == 15) {
				legendaryBookItemLores = "Overload";
			} else if(i == 16) {
				legendaryBookItemLores = "Protection";
			} else if(i == 17) {
				legendaryBookItemLores = "Rage";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(legendaryBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore") == null)
						&& !(legendaryBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.legendaryBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Legendary." + legendaryBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.legendaryBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 22; i++) {
			if(i == 1) {
				ultimateBookItemLores = "Angelic";
			} else if(i == 2) {
				ultimateBookItemLores = "Armored";
			} else if(i == 3) {
				ultimateBookItemLores = "ArrowLifesteal";
			} else if(i == 4) {
				ultimateBookItemLores = "Bleed";
			} else if(i == 5) {
				ultimateBookItemLores = "Blessed";
			} else if(i == 6) {
				ultimateBookItemLores = "Blind";
			} else if(i == 7) {
				ultimateBookItemLores = "Cleave";
			} else if(i == 8) {
				ultimateBookItemLores = "Demonforged";
			} else if(i == 9) {
				ultimateBookItemLores = "Detonate";
			} else if(i == 10) {
				ultimateBookItemLores = "Guardians";
			} else if(i == 11) {
				ultimateBookItemLores = "Hardened";
			} else if(i == 12) {
				ultimateBookItemLores = "Leadership";
			} else if(i == 13) {
				ultimateBookItemLores = "Lucky";
			} else if(i == 14) {
				ultimateBookItemLores = "ObsidianShield";
			} else if(i == 15) {
				ultimateBookItemLores = "Piercing";
			} else if(i == 16) {
				ultimateBookItemLores = "Poison";
			} else if(i == 17) {
				ultimateBookItemLores = "Shackle";
			} else if(i == 18) {
				ultimateBookItemLores = "Silence";
 			} else if(i == 19) {
 				ultimateBookItemLores = "Spirits";
 			} else if(i == 20) {
 				ultimateBookItemLores = "Tank";
			} else if(i == 21) {
				ultimateBookItemLores = "Venom";
			} else if(i == 22) {
				ultimateBookItemLores = "Wither";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(ultimateBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore") == null)
						&& !(ultimateBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.ultimateBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Ultimate." + ultimateBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.ultimateBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 25; i++) {
			if(i == 1) {
				eliteBookItemLores = "AntiGravity";
			} else if(i == 2) {
				eliteBookItemLores = "Block";
			} else if(i == 3) {
				eliteBookItemLores = "Cactus";
			} else if(i == 4) {
				eliteBookItemLores = "DoubleStrike";
			} else if(i == 5) {
				eliteBookItemLores = "EnderWalker";
			} else if(i == 6) {
				eliteBookItemLores = "Execute";
			} else if(i == 7) {
				eliteBookItemLores = "Hellfire";
			} else if(i == 8) {
				eliteBookItemLores = "IceAspect";
			} else if(i == 9) {
				eliteBookItemLores = "IceFreeze";
			} else if(i == 10) {
				eliteBookItemLores = "Implants";
			} else if(i == 11) {
				eliteBookItemLores = "Infernal";
			} else if(i == 12) {
				eliteBookItemLores = "Poisoned";
			} else if(i == 13) {
				eliteBookItemLores = "Pummel";
			} else if(i == 14) {
				eliteBookItemLores = "RocketEscape";
			} else if(i == 15) {
				eliteBookItemLores = "Shockwave";
			} else if(i == 16) {
				eliteBookItemLores = "SkillSwipe";
			} else if(i == 17) {
				eliteBookItemLores = "SmokeBomb";
			} else if(i == 18) {
				eliteBookItemLores = "Springs";
			} else if(i == 19) {
				eliteBookItemLores = "Telepathy";
			} else if(i == 20) {
				eliteBookItemLores = "Teleportation";
			} else if(i == 21) {
				eliteBookItemLores = "Trap";
			} else if(i == 22) {
				eliteBookItemLores = "UndeadRuse";
			} else if(i == 23) {
				eliteBookItemLores = "Valor";
			} else if(i == 24) {
				eliteBookItemLores = "Vampire";
			} else if(i == 25) {
				eliteBookItemLores = "Voodoo";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(eliteBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore") == null)
						&& !(eliteBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.eliteBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Elite." + eliteBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.eliteBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 21; i++) {
			if(i == 1) {
				uniqueBookItemLores = "Aquatic";
			} else if(i == 2) {
				uniqueBookItemLores = "AutoSmelt";
			} else if(i == 3) {
				uniqueBookItemLores = "Commander";
			} else if(i == 4) {
				uniqueBookItemLores = "Cowification";
			} else if(i == 5) {
				uniqueBookItemLores = "Curse";
			} else if(i == 6) {
				uniqueBookItemLores = "DeepWounds";
			} else if(i == 7) {
				uniqueBookItemLores = "EnderShift";
			} else if(i == 8) {
				uniqueBookItemLores = "Experience";
			} else if(i == 9) {
				uniqueBookItemLores = "Explosive";
			} else if(i == 10) {
				uniqueBookItemLores = "Featherweight";
			} else if(i == 11) {
				uniqueBookItemLores = "Frozen";
			} else if(i == 12) {
				uniqueBookItemLores = "Molten";
			} else if(i == 13) {
				uniqueBookItemLores = "ObsidianDestroyer";
			} else if(i == 14) {
				uniqueBookItemLores = "Paralyze";
			} else if(i == 15) {
				uniqueBookItemLores = "PlagueCarrier";
			} else if(i == 16) {
				uniqueBookItemLores = "Ragdoll";
			} else if(i == 17) {
				uniqueBookItemLores = "Ravenous";
			} else if(i == 18) {
				uniqueBookItemLores = "Reforged";
			} else if(i == 19) {
				uniqueBookItemLores = "SelfDestruct";
			} else if(i == 20) {
				uniqueBookItemLores = "SpiritLink";
			} else if(i == 21) {
				uniqueBookItemLores = "Stormcaller";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(uniqueBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore") == null)
						&& !(uniqueBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.uniqueBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Unique." + uniqueBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.uniqueBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 13; i++) {
			if(i == 1) {
				simpleBookItemLores = "Confusion";
			} else if(i == 2) {
				simpleBookItemLores = "Decapitation";
			} else if(i == 3) {
				simpleBookItemLores = "Epicness";
			} else if(i == 4) {
				simpleBookItemLores = "Glowing";
			} else if(i == 5) {
				simpleBookItemLores = "Haste";
			} else if(i == 6) {
				simpleBookItemLores = "Headless";
			} else if(i == 7) {
				simpleBookItemLores = "Healing";
			} else if(i == 8) {
				simpleBookItemLores = "Insomnia";
			} else if(i == 9) {
				simpleBookItemLores = "Lightning";
			} else if(i == 10) {
				simpleBookItemLores = "Nutrition";
			} else if(i == 11) {
				simpleBookItemLores = "Obliterate";
			} else if(i == 12) {
				simpleBookItemLores = "Oxygenate";
			} else if(i == 13) {
				simpleBookItemLores = "ThunderingBlow";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(simpleBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore") == null)
						&& !(simpleBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.simpleBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Simple." + simpleBookItemLores).equalsIgnoreCase("true")) {
					EnchantBookLores.simpleBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore")));
				}
			}
		}
		return;
	}
	public static ArrayList<String> getSoulItemLores() { return soulBookItemLores; }
	public static ArrayList<String> getLegendaryItemLores() { return legendaryBookItemLores; }
	public static ArrayList<String> getUltimateItemLores() { return ultimateBookItemLores; }
	public static ArrayList<String> getEliteItemLores() { return eliteBookItemLores; }
	public static ArrayList<String> getUniqueItemLores() { return uniqueBookItemLores; }
	public static ArrayList<String> getSimpleItemLores() { return soulBookItemLores; }
}
