package com.gmail.adam.chareyre.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.adam.chareyre.Main;

public class SignTP implements Listener {

	public SignTP(Main main) {

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock() != null) {
				BlockState block = e.getClickedBlock().getState();
				if (block instanceof Sign) {
					Sign sign = (Sign) block;
					if (sign.getLine(0).equalsIgnoreCase("[TP]")) {
						if (sign.getLine(1).equalsIgnoreCase("[JUMP]")) {
							Player p = e.getPlayer();
							World w = Bukkit.getWorld("Takinou_");
							Location loc = new Location(w, 0, 100, 0);
							p.teleport(loc);
						}
					}
				}
			}
		}

	}

}
