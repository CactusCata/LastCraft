package com.gmail.adam.chareyre.spawn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortalsTeleport implements CommandExecutor {

	public static final String PREFIX = ChatColor.DARK_BLUE + "[" + ChatColor.AQUA + "LastCraft" + ChatColor.DARK_BLUE
			+ "] " + ChatColor.YELLOW;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kicks")) {
			if (args.length == 0) {
				sender.sendMessage(PREFIX + "Veillez préciser le joueur !");
				return false;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(
						PREFIX + "Le joueur " + ChatColor.AQUA + args[0] + ChatColor.YELLOW + " n'a pas été trouvé !");
				return false;
			}
			if (args[1] != null) {
				target.kickPlayer(PREFIX + "Vous avez été kick par " + ChatColor.AQUA + sender.getName()
						+ ChatColor.YELLOW + " pour " + args[1]);
				Bukkit.broadcastMessage(PREFIX + ChatColor.AQUA + args[0] + ChatColor.YELLOW + " à été kick par "
						+ sender.getName() + " pour " + args[1]);
				try {
					BufferedWriter writer = new BufferedWriter(
							new FileWriter(new File("plugins\\LastCraft\\" + args[0] + ".yml")));
					DateFormat dateFormat = new SimpleDateFormat("[dd/MM/yyyy - HH:mm:ss] ");
					Date date = new Date();
					writer.write(dateFormat.format(date) + args[0] + " à été kick pour " + args[1] + " par "
							+ sender.getName() + "\n");
					writer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else {
				target.kickPlayer(PREFIX + "Vous avez été kick par " + ChatColor.AQUA + sender.getName()
						+ ChatColor.YELLOW + " !");
				try {

					BufferedWriter writer = new BufferedWriter(
							new FileWriter(new File("plugins\\LastCraft\\" + args[0] + ".yml")));
					DateFormat dateFormat = new SimpleDateFormat("[dd/MM/yyyy - HH:mm:ss] ");
					Date date = new Date();
					String test = writer.toString();
					writer.write(test);
					writer.write(dateFormat.format(date) + args[0] + " à été kick par " + sender.getName() + "\n");
					writer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return false;
	}

	// @EventHandler
	// public void kickRaison(PlayerKickEvent e) {
	// String p = e.getPlayer().getName();
	// String pr = e.getReason();
	// Bukkit.broadcastMessage(
	// ChatColor.YELLOW + p + ChatColor.BLUE + " à été kick du jeu pour " +
	// ChatColor.YELLOW + pr);
	//
	// try {
	// BufferedWriter writer = new BufferedWriter(new FileWriter(new
	// File("plugins\\LastCraft\\" + p + ".yml")));
	// writer.write(p + " à été kick pour " + pr + " par ");
	// writer.close();
	// } catch (IOException ex) {
	// ex.printStackTrace();
	// }
	//
	// }
}
