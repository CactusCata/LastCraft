package com.gmail.adam.chareyre;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TabList implements Listener {

	public TabList(Main main) {
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (p.hasPermission("essentals.Membre")) {
			p.setPlayerListName("§e" + p.getName());

		} else if (p.hasPermission("essentals.VIP")) {
			p.setPlayerListName("§e[VIP]" + p.getName());

		} else if (p.hasPermission("essentals.LastVIP")) {
			p.setPlayerListName("§e[LastVIP]" + p.getName());

		} else if (p.hasPermission("essentals.Buildeur")) {
			p.setPlayerListName("§2[Builder]" + p.getName());

		} else if (p.hasPermission("essentals.Chef.Buildeur")) {
			p.setPlayerListName("§2§1[ChefBuilder]" + p.getName());

		} else if (p.hasPermission("essentals.Modo")) {
			p.setPlayerListName("§6§1[Modérateur]" + p.getName());

		} else if (p.hasPermission("essentals.Administration")) {
			p.setPlayerListName("§b§1[Administrateur]" + p.getName());

		} else if (p.hasPermission("essentals.Developper")) {
			p.setPlayerListName("§a§1§n[Dev]" + p.getName());

		} else if (p.hasPermission("essentals.Fondateur")) {
			p.setPlayerListName("§4§1[Fondateur]" + p.getName());
		}
	}
}