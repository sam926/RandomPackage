package me.randomHashTags.randomPackage.RandomArmorEffects.Soul;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookLores;

public class soulAdd implements Listener {
	private ArrayList<String> delay = new ArrayList<String>();
	private final int time = RandomPackage.getSoulConfig().getInt("Messages.SoulMode.DelaySoul");
	@EventHandler
	private void playerDeathEvent(PlayerDeathEvent event) {
		if(!(event.getEntity().getKiller() instanceof Player)) {
			return;
		} else {
			Player killer = (Player) event.getEntity().getKiller();
			if(killer.getInventory().getItemInMainHand() == null || !(killer.getInventory().getItemInMainHand().hasItemMeta())
					|| !(killer.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
				return;
			} else {
				ItemStack itemInMainHand = killer.getInventory().getItemInMainHand();
				ItemMeta itemInMainHandMeta = itemInMainHand.getItemMeta();
				List<String> itemInMainHandLore = itemInMainHandMeta.getLore();
				
				if(delay.contains(killer) && delay.contains(event.getEntity().getName())) {
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getSoulConfig().getString("Messages.SoulMode.DelayMessage").replace("%player%", event.getEntity().getName()).replace("%time%", "" + time + "m")));
					return;
				} else {
					int souls = 0;
					for(int i = 0; i < killer.getInventory().getItemInMainHand().getItemMeta().getLore().size(); i++) {
						if(!(EnchantBookLores.getLegendaryItemLores().contains(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i)))
								&& !(EnchantBookLores.getUltimateItemLores().contains(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i)))
								&& !(EnchantBookLores.getEliteItemLores().contains(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i)))
								&& !(EnchantBookLores.getUniqueItemLores().contains(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i)))
								&& !(EnchantBookLores.getSimpleItemLores().contains(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i)))) {
							if(Integer.parseInt(ChatColor.stripColor(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).toString().toLowerCase()).replace("a", "").replace("b", "").replace("c", "").replace("d", "").replace("e", "").replace("f", "").replace("g", "").replace("h", "").replace("i", "").replace("j", "").replace("k", "").replace("l", "").replace("m", "").replace("n", "").replace("o", "").replace("p", "").replace("q", "").replace("r", "").replace("s", "").replace("t", "").replace("u", "").replace("v", "").replace("w", "").replace("x", "").replace("y", "").replace("z", "").replace(":", "").replace(" 0", " 1").replace(" ", "")) == 0) { return; }
							for(int p = 0; p <= 9; p++) {
								int soulTC = 0;  // Soul Tracker Check
								if(!(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).toString().endsWith("" + p))) {
									soulTC = soulTC + 1;
								}
								if(p == 9 && soulTC == 9) { return; }
							}
							souls = Integer.parseInt(ChatColor.stripColor(killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).toString().toLowerCase()).replace("a", "").replace("b", "").replace("c", "").replace("d", "").replace("e", "").replace("f", "").replace("g", "").replace("h", "").replace("i", "").replace("j", "").replace("k", "").replace("l", "").replace("m", "").replace("n", "").replace("o", "").replace("p", "").replace("q", "").replace("r", "").replace("s", "").replace("t", "").replace("u", "").replace("v", "").replace("w", "").replace("x", "").replace("y", "").replace("z", "").replace(":", "").replace(" ", ""));
							itemInMainHandLore.set(i, killer.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).replace("" + souls, "" + Math.addExact(souls, 1)));
							itemInMainHandMeta.setLore(itemInMainHandLore);
							itemInMainHand.setItemMeta(itemInMainHandMeta);
							killer.getInventory().setItemInMainHand(itemInMainHand);
							killer.updateInventory();
							
							delay.add(killer.getName());
							delay.add(event.getEntity().getName());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									delay.remove(killer);
									delay.remove(event.getEntity().getName());
									return;
								}
							}, 1200 * RandomPackage.getSoulConfig().getInt("Messages.SoulMode.DelaySoul"));
							return;
						}
					}
					return;
				}
			}
		}
	}
}
