package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

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
		 * Soul
		 */
		swordEnchants.add("DivineImmolation");
		armorEnchants.add("Immortal");
		armorEnchants.add("NaturesWrath");
		/*
		 * Legendary
		 */
		axeEnchants.add("Barbarian");
		chestplateEnchants.add("BloodLust");
		helmetEnchants.add("Clarity");
		armorEnchants.add("CreeperArmor");
		armorEnchants.add("Deathbringer");
		axeEnchants.add("Devour");
		swordEnchants.add("Disarmor");
		helmetEnchants.add("Drunk");
		armorEnchants.add("Enlighted");
		bootEnchants.add("Gears");
		swordEnchants.add("Inquisitive");
		swordEnchants.add("KillAura");
		swordEnchants.add("Lifesteal");
		armorEnchants.add("Overload");
		helmetEnchants.add("Protection");
		weaponEnchants.add("Rage");
		/*
		 * Ultimate
		 */
		armorEnchants.add("Angelic");
		armorEnchants.add("Armored");
		bowEnchants.add("ArrowLifesteal");
		weaponEnchants.add("Bleed");
		weaponEnchants.add("Blessed");
		weaponEnchants.add("Blind");
		axeEnchants.add("Cleave");
		swordEnchants.add("Demonforged");
		toolEnchants.add("Detonate");
		armorEnchants.add("Guardians");
		armorEnchants.add("Hardened");
		armorEnchants.add("Leadership");
		armorEnchants.add("Lucky");
		armorEnchants.add("ObsidianShield");
		bowEnchants.add("Piercing");
		weaponEnchants.add("Poison");
		weaponEnchants.add("Shackle");
		swordEnchants.add("Silence");
		chestplateEnchants.add("Spirits");
		swordEnchants.add("Venom");
		armorEnchants.add("Wither");
		/*
		 * Elite
		 */
		bootEnchants.add("AntiGravity");
		swordEnchants.add("Block");
		armorEnchants.add("Cactus");
		swordEnchants.add("DoubleStrike");
		armorEnchants.add("EnderWalker");
		swordEnchants.add("Execute");
		bowEnchants.add("Hellfire");
		swordEnchants.add("IceAspect");
		weaponEnchants.add("IceFreeze");
		helmetEnchants.add("Implants");
		bowEnchants.add("Infernal");
		armorEnchants.add("Poisoned");
		axeEnchants.add("Pummel");
		bootEnchants.add("RocketEscape");
		armorEnchants.add("Shockwave");
		weaponEnchants.add("SkillSwipe");
		helmetEnchants.add("SmokeBomb");
		bootEnchants.add("Springs");
		armorEnchants.add("Stormcaller");
		armorEnchants.add("Tank");
		pickaxeEnchants.add("Telepathy");
		bowEnchants.add("Teleportation");
		swordEnchants.add("Trap");
		bootEnchants.add("UndeadRuse");
		armorEnchants.add("Valor");
		bowEnchants.add("Vampire");
		armorEnchants.add("Voodoo");
		/*
		 * Unique
		 */
		helmetEnchants.add("Aquatic");
		toolEnchants.add("AutoSmelt");
		chestplateEnchants.add("Commander");
		bowEnchants.add("Cowification");
		chestplateEnchants.add("Curse");
		swordEnchants.add("DeepWounds");
		helmetEnchants.add("EnderShift");
		pickaxeEnchants.add("Experience");
		bowEnchants.add("Explosive");
		swordEnchants.add("Featherweight");
		armorEnchants.add("Frozen");
		armorEnchants.add("Molten");
		toolEnchants.add("ObsidianDestroyer");
		weaponEnchants.add("Paralyze");
		leggingsEnchants.add("PlagueCarrier");
		armorEnchants.add("Ragdoll");
		axeEnchants.add("Ravenous");
		weaponEnchants.add("Reforged");
		armorEnchants.add("SelfDestruct");
		armorEnchants.add("SpiritLink");
		/*
		 * Simple
		 */
		axeEnchants.add("Confusion");
		axeEnchants.add("Decapitation");
		weaponEnchants.add("Epicness");
		helmetEnchants.add("Glowing");
		toolEnchants.add("Haste");
		swordEnchants.add("Headless");
		bowEnchants.add("Healing");
		weaponEnchants.add("Insomnia");
		bowEnchants.add("Lightning");
		armorEnchants.add("Nutrition");
		weaponEnchants.add("Obliterate");
		toolEnchants.add("Oxygenate");
		swordEnchants.add("ThunderingBlow");
		return;
	}
	public static Class<EnchantType> getEnchantTypes() {
		return EnchantType.class;
	}
	public static ArrayList<String> getBowEnchants() {
		return EnchantType.bowEnchants;
	}
	public static ArrayList<String> getSwordEnchants() {
		return EnchantType.swordEnchants;
	}
	public static ArrayList<String> getAxeEnchants() {
		return EnchantType.axeEnchants;
	}
	public static ArrayList<String> getWeaponEnchants() {
		return EnchantType.weaponEnchants;
	}
	public static ArrayList<String> getPickaxeEnchants() {
		return EnchantType.pickaxeEnchants;
	}
	public static ArrayList<String> getShovelEnchants() {
		return EnchantType.shovelEnchants;
	}
	public static ArrayList<String> getToolEnchants() {
		return EnchantType.toolEnchants;
	}
	public static ArrayList<String> getHelmetEnchants() {
		return EnchantType.helmetEnchants;
	}
	public static ArrayList<String> getChestplateEnchants() {
		return EnchantType.chestplateEnchants;
	}
	public static ArrayList<String> getLeggingsEnchants() {
		return EnchantType.leggingsEnchants;
	}
	public static ArrayList<String> getBootEnchants() {
		return EnchantType.bootEnchants;
	}
	public static ArrayList<String> getArmorEnchants() {
		return EnchantType.armorEnchants;
	}
}
