package com.gmail.adam.chareyre.spawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.adam.chareyre.Main;

public class PlayerJoinEvents implements Listener {

	public PlayerJoinEvents(Main main) {

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoinGame(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!(p.hasPlayedBefore())) {
			Bukkit.broadcastMessage("Bienvenue à " + p.getName() + " !");
		} else {
			p.sendTitle(ChatColor.BLUE + "Bienvenue à toi " + p.getName(),
					ChatColor.RED + "Sur LastCraft" + ChatColor.GRAY + "Server");
			World w = p.getWorld();
			if (w.getName().equals("Takinou_")) {
				p.setGameMode(GameMode.ADVENTURE);
				p.setTotalExperience(0);
				p.setWalkSpeed(0.3F);
			} else {
				p.setWalkSpeed(0.2F);
			}

		}
	}
	/*
	 * @EventHandler public void removePotionEffect(PlayerTeleportEvent e) {
	 * Player p = e.getPlayer(); World w = p.getWorld(); if
	 * (!w.getName().equals("HubLobby")) { p.setWalkSpeed(0.2F); } }
	 */

	@EventHandler
	public void removeEx(PlayerExpChangeEvent e) {
		World w = e.getPlayer().getWorld();
		if (w.getName().equals("Takinou_")) {
			e.setAmount(0);
			Player p = e.getPlayer();
			p.updateInventory();
		}
	}

	@EventHandler
	public void removePotionEffect2(PlayerChangedWorldEvent e) {
		Player p = e.getPlayer();
		World w = p.getWorld();
		if (w.getName().equals("Takinou_")) {
			p.setWalkSpeed(0.3F);
		} else {
			p.setWalkSpeed(0.2F);
		}
	}
}


