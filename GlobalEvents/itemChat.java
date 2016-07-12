package me.randomHashTags.randomPackage.RandomArmorEffects.GlobalEvents;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class itemChat implements Listener {
	@EventHandler
	private void playerChatEvent(PlayerChatEvent event) {
		if(event.isCancelled() || !(event.getMessage().contains("[item]")) || event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName())) { return;
		} else {
			for(int i = 1; i <= 100; i++) {
				event.setCancelled(true);
			}
			Player player = (Player) event.getPlayer();
			String message = null, playerName = event.getPlayer().getName(), enchants = null;
			ArrayList<String> lore = new ArrayList<String>();
			if(!(Bukkit.getPluginManager().getPlugin("EssentialsChat") == null)) {
				if(player.isOp()) { playerName = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("Essentials").getConfig().getString("ops-name-color") + event.getPlayer().getName() + ChatColor.RESET); }
				message = ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Essentials").getConfig().getString("chat.format").replace("{DISPLAYNAME}", playerName).replace("{MESSAGE}", event.getMessage()).replace("[item]", ChatColor.WHITE + "»" + event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.WHITE + "«" + ChatColor.RESET));
			}
			if(player.getInventory().getItemInMainHand().getType().name().endsWith("HELMET")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("CHESTPLATE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("LEGGINGS")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("BOOTS")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("AXE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("SPADE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("HOE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("BOW")) {
				for(int i = 0; i < 50; i++) {
					if(!(Enchantment.getById(i) == null) && player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.getById(i))) {
						enchants = enchants + ChatColor.GRAY +
								Enchantment.getById(i).getName().replace("ARROW_DAMAGE", "Power").replace("ARROW_FIRE", "Flame").replace("ARROW_INFINITE", "Infinity").replace("ARROW_KNOCKBACK", "Punch").replace("DAMAGE_ALL", "Sharpness").replace("DAMAGE_ARTHROPODS", "Bane of Arthropods").replace("DAMAGE_UNDEAD", "Smite").replace("DEPTH_STRIDER", "Depth Strider").replace("DIG_SPEED", "Efficiency").replace("DURABILITY", "Unbreaking").replace("FIRE_ASPECT", "Fire Aspect").replace("FROST_WALKER", "Frost Walker").replace("KNOCKBACK", "Knockback").replace("LOOT_BONUS_BLOCKS", "Fortune").replace("LOOT_BONUS_MOBS", "Looting").replace("LUCK", "Luck of the Sea").replace("LURE", "Lure").replace("MENDING", "Mending").replace("OXYGEN", "Respiration").replace("PROTECTION_ENVIRONMENTAL", "Protection").replace("PROTECTION_EXPLOSIONS", "Blast Protection").replace("PROTECTION_FALL", "Feather Falling").replace("PROTECTION_FIRE", "Fire Resistance").replace("PROTECTION_PROJECTILE", "Projectile Protection").replace("SILK_TOUCH", "Silk Touch").replace("THRONS", "Thorns").replace("WATER_WORKER", "Aqua Affinity")
								+ " " + player.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(Enchantment.getById(i)) + "\n";
					}
				}
			} else { enchants = null; }
			for(int i = 0; i < player.getInventory().getItemInMainHand().getItemMeta().getLore().size(); i++) {
				lore.add(player.getInventory().getItemInMainHand().getItemMeta().getLore().get(i));
			}
			if(player.getInventory().getItemInMainHand().getType().name().endsWith("HELMET")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("CHESTPLATE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("LEGGINGS")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("BOOTS")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("AXE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("SPADE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("HOE")
					|| player.getInventory().getItemInMainHand().getType().name().endsWith("BOW")) {
				enchants = enchants.replace("null", "").replace("5", "V").replace("4", "IV").replace("3", "III").replace("2", "II").replace("2", "I").replace("}", "\n");
			} else { enchants = null; }
			if(!(enchants == null)) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw @a {\"text\":\"" + message + "\", \"hoverEvent\":{\"action\":\"show_text\",\"value\":[\"\",{\"text\":\"" + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + "\n\"}, \"" + enchants + "\" ,\"" + lore.toString().replace(", ", "\n").replace("[", "").replace("]", "") + "\"]}}");
			} else {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw @a {\"text\":\"" + message + "\", \"hoverEvent\":{\"action\":\"show_text\",\"value\":[\"\",{\"text\":\"" + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + "\n\"}, \"" + lore.toString().replace(", ", "\n").replace("[", "").replace("]", "") + "\"]}}");
			}
			return;
		}
	}
}
