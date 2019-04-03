package com.gmail.adam.chareyre;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class DisableCommand implements Listener {

	public DisableCommand(Main main) {
		
		// @EventHandler
		// public void clickItemFrame(PlayerInteractEntityEvent e) {
		// if (e.getRightClicked().getType() == EntityType.ITEM_FRAME) {
		// int loc = e.getRightClicked().getLocation().getBlockX();
		// int loc1 = e.getRightClicked().getLocation().getBlockY();
		// int loc2 = e.getRightClicked().getLocation().getBlockZ();
		// if (loc == 15 && loc1 == 75 && loc2 == -11) {
		// Player p = e.getPlayer();
		// p.sendMessage("Téléportation au jump Pokéball");
		// }
		// e.setCancelled(true);
		// }
		// }
		
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void Executeunecommande(PlayerCommandPreprocessEvent e) {

		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] args = msg.split(" ");

		if (args[0].equalsIgnoreCase("/pl")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Plugins(3): " + ChatColor.GREEN + "aimons " + ChatColor.WHITE + "," + ChatColor.GREEN
						+ " les" + ChatColor.WHITE + ", " + ChatColor.GREEN + "cactus");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/plugins")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Plugins(3): " + ChatColor.GREEN + "aimons " + ChatColor.WHITE + "," + ChatColor.GREEN
						+ " les" + ChatColor.WHITE + ", " + ChatColor.GREEN + "cactus");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/?")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/ver")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("C'est quoi déjà la version ?");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/op")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/deop")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/reload")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/help")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Quelle est ta question ?");
				e.setCancelled(true);
			}

		}
		if (args[0].equalsIgnoreCase("/version")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("C'est quoi déjà la version ?");
				e.setCancelled(true);
			}
		}
		if (args[0].equalsIgnoreCase("/thor")) {
			if (p.getDisplayName().equals("laurentCarrmelie")) {
				e.setCancelled(true);
				p.sendMessage("Unknown command. Type \"/help\" for help.");
			}
		}
		if (args[0].equalsIgnoreCase("/seed")) {
			if (p.isOp()) {
				e.setCancelled(false);
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}
		}

	}
}
