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

public class Headless implements Listener {
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player) || !(RandomPackage.getEnabledEnchantsConfig().getString("Simple.Headless").equalsIgnoreCase("true"))) {
			return;
		} else {
			if(event.getEntity().getKiller().getInventory().getItemInMainHand() == null
					|| !(event.getEntity().getKiller().getInventory().getItemInMainHand().getType().name().endsWith("SWORD"))
					&& !(event.getEntity().getKiller().getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))
					|| !(event.getEntity().getKiller().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				Random random = new Random();
				int chance = 59;
				for(int i = 1; i <= 3; i++) {
					chance = chance + 20;
					if(event.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Headless.Headless" + i + ".ItemLore")))
							&& random.nextInt(100) <= chance) {
						ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
						SkullMeta playerHead = (SkullMeta) item.getItemMeta();
						if(!(playerHead.hasOwner())) {
							playerHead.setOwner(event.getEntity().getName());
						} else {
							return;
						}
						playerHead.setOwner(event.getEntity().getName());
						playerHead.setDisplayName(ChatColor.RED + event.getEntity().getName() + "'s head");
						item.setItemMeta(playerHead);
						event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
						return;
					}
				}
				return;
			}
		}
	}
}
