package com.gmail.adam.chareyre.spawn;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.gmail.adam.chareyre.Main;

public class WeatherClear implements Listener {

	public WeatherClear(Main main) {
	}

	@EventHandler
	public void wheather(WeatherChangeEvent e) {
		World w = e.getWorld();
		if (w.getName() == "Takinou_")
			;
		e.setCancelled(true);
	}
}
