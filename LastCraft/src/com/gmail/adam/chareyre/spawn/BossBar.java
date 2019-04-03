package com.gmail.adam.chareyre.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.gmail.adam.chareyre.Main;

public class BossBar implements Listener {

	public BossBar(Main main) {
	}

	@EventHandler
	public void Executeunecommande(PlayerCommandPreprocessEvent e) {

		String msg = e.getMessage();
		String[] args = msg.split(" ");
		if (args[0].equalsIgnoreCase("/hubbarre")) {
			Player p = e.getPlayer();
			World w = p.getWorld();
			if (w.getName().equals("HubLobby")) {
				if (p.isOp()) {
					Wither wither = (Wither) p.getWorld()
							.spawnEntity(new Location(Bukkit.getWorld("HubLobby"), 0, 66, 0), EntityType.WITHER);
					wither.setCustomName("§eBienvenue sur le serveur LastCraft !");
					e.setCancelled(true);
				}

			}
		}
	}
}