package com.gmail.adam.chareyre.spawn;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.gmail.adam.chareyre.Main;

public class DoNotFallSpawn implements Listener {

	public DoNotFallSpawn(Main main) {
	}

	@EventHandler
	public void noDamageFallSpawn(EntityDamageEvent e) {
		if (e.getCause() == DamageCause.VOID) {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				Location loc = new Location(p.getWorld(), 0.5, 100, 0.5);
				p.teleport(loc);
				p.sendMessage(ChatColor.GRAY + "C'est pas bien d'essayer de s'échapper !");
				e.setCancelled(true);
			}
		}
		if (e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onAllDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getCause() == DamageCause.ENTITY_ATTACK) {
				Player p = (Player) e.getEntity();
				Location loc = p.getLocation();
				p.sendMessage("Faut pas se taper :'(");
				Particle.HEART.display(1.2F, 0.2F, 0.2F, 0.2F, 10, loc, 16);
			}
			e.setCancelled(true);

		}
	}

	@EventHandler
	public void onRegainBouf(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();
		if (p.getFoodLevel() < 20) {
			System.out.println(p.getFoodLevel());
			p.setFoodLevel(20);
			p.updateInventory();
		}
	}
}