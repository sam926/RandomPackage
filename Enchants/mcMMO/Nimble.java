package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;

public class Nimble implements Listener {
	@EventHandler
	private void mcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent event) {
		if()
		event.getPlayer().sendMessage("xp gained = " + event.getXpGained());
		return;
	}
}
