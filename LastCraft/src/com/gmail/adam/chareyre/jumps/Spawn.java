package com.gmail.adam.chareyre.jumps;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.adam.chareyre.Main;

public class Spawn implements Listener {

	public Spawn(Main main) {

	}

	@EventHandler
	public void onClickPouder(PlayerInteractEvent e) {

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItem() == null)
				return;
			ItemStack item = e.getItem();
			if (item.getType() == Material.BLAZE_POWDER) {
				if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Caca")) {
					Player p = e.getPlayer();
					p.sendMessage("Caca");

				}
				return;
			}
		}
	}
}
