package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Decapitation implements Listener {
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)
				|| !(event.getEntity().getKiller() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Decapitation").equalsIgnoreCase("true"))) {
			return;
		} else {
			Player killer = event.getEntity().getKiller();
			Player victim = event.getEntity().getPlayer();
			
			if(killer.getInventory().getItemInMainHand() == null
					|| !(killer.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(killer.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))
					|| !(killer.getInventory().getItemInMainHand().hasItemMeta()) || !(killer.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int chance = 59;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 20;
					if(killer.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Decapitation.Decapitation" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
						SkullMeta playerHead = (SkullMeta) item.getItemMeta();
						
						if(!(playerHead.hasOwner())) { playerHead.setOwner(victim.getName());
						} else { return; }
						
						playerHead.setOwner(victim.getName());
						playerHead.setDisplayName(ChatColor.RED + victim.getName() + "'s head");
						item.setItemMeta(playerHead);
						victim.getWorld().dropItemNaturally(victim.getLocation(), item);
						return;
					}
				}
				return;
			}
		}
	}
}
