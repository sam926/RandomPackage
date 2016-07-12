package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import net.md_5.bungee.api.ChatColor;

public class EnchantType implements Listener {
	private static ArrayList<String> bowEnchants = new ArrayList<String>();
	private static ArrayList<String> swordEnchants = new ArrayList<String>();
	private static ArrayList<String> axeEnchants = new ArrayList<String>();
	private static ArrayList<String> weaponEnchants = new ArrayList<String>();
	
	private static ArrayList<String> pickaxeEnchants = new ArrayList<String>();
	private static ArrayList<String> shovelEnchants = new ArrayList<String>();
	private static ArrayList<String> toolEnchants = new ArrayList<String>();
	
	private static ArrayList<String> helmetEnchants = new ArrayList<String>();
	private static ArrayList<String> chestplateEnchants = new ArrayList<String>();
	private static ArrayList<String> leggingsEnchants = new ArrayList<String>();
	private static ArrayList<String> bootEnchants = new ArrayList<String>();
	private static ArrayList<String> armorEnchants = new ArrayList<String>();
	
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		/*
		 * ??? 
		 */
		//axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.???.Berserk.Berserk1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Soul
		 */
		swordEnchants.add("DivineImmolation");
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.Immortal.Immortal1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul.NaturesWrath.NaturesWrath1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Legendary
		 */
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Barbarian.Barbarian1.ItemLore").replace(" I", "").replace(" ", ""))));
		chestplateEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.BloodLust.BloodLust1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Clarity.Clarity1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.CreeperArmor.CreeperArmor1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Deathbringer.Deathbringer1.ItemLore").replace(" I", "").replace(" ", ""))));
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Devour.Devour1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Disarmor.Disarmor1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Drunk.Drunk1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Enlighted.Enlighted1.ItemLore").replace(" I", "").replace(" ", ""))));
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Gears.Gears1.ItemLore").replace(" I", "").replace(" ", ""))));
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Ghost.Ghost1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Inquisitive.Inquisitive1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.KillAura.KillAura1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Lifesteal.Lifesteal1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Overload.Overload1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Protection.Protection1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Rage.Rage1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Ultimate
		 */
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Angelic.Angelic1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Armored.Armored1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.ArrowLifesteal.ArrowLifesteal1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Bleed.Bleed1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Blessed.Blessed1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Blind.Blind1.ItemLore").replace(" I", "").replace(" ", ""))));
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Cleave.Cleave1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Demonforged.Demonforged1.ItemLore").replace(" I", "").replace(" ", ""))));
		toolEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Detonate.Detonate1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Guardians.Guardians1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Hardened.Hardened1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Leadership.Leadership1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Lucky.Lucky1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.ObsidianShield.ObsidianShield1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Piercing.Piercing1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Poison.Poison1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Shackle.Shackle1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Silence.Silence1.ItemLore").replace(" I", "").replace(" ", ""))));
		chestplateEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Spirits.Spirits1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Tank.Tank1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Venom.Venom1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Wither.Wither1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Elite
		 */
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.AntiGravity.AntiGravity1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Block.Block1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Cactus.Cactus1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.DoubleStrike.DoubleStrike1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.EnderWalker.EnderWalker1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Execute.Execute1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Hellfire.Hellfire1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.IceAspect.IceAspect1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.IceFreeze.IceFreeze1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Implants.Implants1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Infernal.Infernal1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Poisoned.Poisoned1.ItemLore").replace(" I", "").replace(" ", ""))));
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Pummel.Pummel1.ItemLore").replace(" I", "").replace(" ", ""))));
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.RocketEscape.RocketEscape1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Shockwave.Shockwave1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.SkillSwipe.SkillSwipe1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.SmokeBomb.SmokeBomb1.ItemLore").replace(" I", "").replace(" ", ""))));
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Springs.Springs1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Stormcaller.Stormcaller1.ItemLore").replace(" I", "").replace(" ", ""))));
		pickaxeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Telepathy.Telepathy1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Teleportation.Teleportation1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trap.Trap1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trickster.Trickster1.ItemLore").replace(" I", "").replace(" ", ""))));
		bootEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.UndeadRuse.UndeadRuse1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Valor.Valor1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Vampire.Vampire1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Voodoo.Voodoo1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Unique
		 */
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Aquatic.Aquatic1.ItemLore").replace(" I", "").replace(" ", ""))));
		toolEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.AutoSmelt.AutoSmelt1.ItemLore").replace(" I", "").replace(" ", ""))));
		chestplateEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Commander.Commander1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Cowification.Cowification1.ItemLore").replace(" I", "").replace(" ", ""))));
		chestplateEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Curse.Curse1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.DeepWounds.DeepWounds1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.EnderShift.EnderShift1.ItemLore").replace(" I", "").replace(" ", ""))));
		pickaxeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Experience.Experience1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Explosive.Explosive1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Featherweight.Featherweight1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Frozen.Frozen1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Molten.Molten1.ItemLore").replace(" I", "").replace(" ", ""))));
		toolEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.ObsidianDestroyer.ObsidianDestroyer1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Paralyze.Paralyze1.ItemLore").replace(" I", "").replace(" ", ""))));
		leggingsEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.PlagueCarrier.PlagueCarrier1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Ragdoll.Ragdoll1.ItemLore").replace(" I", "").replace(" ", ""))));
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Ravenous.Ravenous1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.Reforged.Reforged1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SelfDestruct.SelfDestruct1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique.SpiritLink.SpiritLink1.ItemLore").replace(" I", "").replace(" ", ""))));
		/*
		 * Simple
		 */
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Confusion.Confusion1.ItemLore").replace(" I", "").replace(" ", ""))));
		axeEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Decapitation.Decapitation1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Epicness.Epicness1.ItemLore").replace(" I", "").replace(" ", ""))));
		helmetEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Glowing.Glowing1.ItemLore").replace(" I", "").replace(" ", ""))));
		toolEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Haste.Haste1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Headless.Headless1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Healing.Healing1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Insomnia.Insomnia1.ItemLore").replace(" I", "").replace(" ", ""))));
		bowEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Lightning.Lightning1.ItemLore").replace(" I", "").replace(" ", ""))));
		armorEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Nutrition.Nutrition1.ItemLore").replace(" I", "").replace(" ", ""))));
		weaponEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Obliterate.Obliterate1.ItemLore").replace(" I", "").replace(" ", ""))));
		toolEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Oxygenate.Oxygenate1.ItemLore").replace(" I", "").replace(" ", ""))));
		swordEnchants.add(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.ThunderingBlow.ThunderingBlow1.ItemLore").replace(" I", "").replace(" ", ""))));
		return;
	}
	public static Class<EnchantType> getEnchantTypes() { return EnchantType.class; }
	public static ArrayList<String> getBowEnchants() { return EnchantType.bowEnchants; }
	public static ArrayList<String> getSwordEnchants() { return EnchantType.swordEnchants; }
	public static ArrayList<String> getAxeEnchants() { return EnchantType.axeEnchants; }
	public static ArrayList<String> getWeaponEnchants() { return EnchantType.weaponEnchants; }
	public static ArrayList<String> getPickaxeEnchants() { return EnchantType.pickaxeEnchants; }
	public static ArrayList<String> getShovelEnchants() { return EnchantType.shovelEnchants; }
	public static ArrayList<String> getToolEnchants() { return EnchantType.toolEnchants; }
	public static ArrayList<String> getHelmetEnchants() { return EnchantType.helmetEnchants; }
	public static ArrayList<String> getChestplateEnchants() { return EnchantType.chestplateEnchants; }
	public static ArrayList<String> getLeggingsEnchants() { return EnchantType.leggingsEnchants; }
	public static ArrayList<String> getBootEnchants() { return EnchantType.bootEnchants; }
	public static ArrayList<String> getArmorEnchants() { return EnchantType.armorEnchants; }
}
