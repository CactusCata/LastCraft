package com.gmail.adam.chareyre;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.adam.chareyre.Menu.Menu;
import com.gmail.adam.chareyre.jumps.Spawn;
import com.gmail.adam.chareyre.spawn.BossBar;
import com.gmail.adam.chareyre.spawn.DoNotFallSpawn;
import com.gmail.adam.chareyre.spawn.PortalsTeleport;
import com.gmail.adam.chareyre.spawn.SignTP;
import com.gmail.adam.chareyre.spawn.WeatherClear;

public class Main extends JavaPlugin implements Listener {

	public static Main instance;

	public static Main getInstance() {
		return instance;
	}

	public void onEnable() {
		instance = this;
		PluginManager pm = getServer().getPluginManager();
		getConfig().options().copyDefaults(false);
		this.saveConfig();
		pm.registerEvents(new DisableCommand(this), (this));
		pm.registerEvents(new SendCommand(this), (this));
		pm.registerEvents(new WeatherClear(this), (this));
		pm.registerEvents(new DoNotFallSpawn(this), (this));
		pm.registerEvents(new AddEnchantementsRecipes(this), (this));
		pm.registerEvents(new BossBar(this), (this));
		pm.registerEvents(new TabList(this), (this));
		pm.registerEvents(new Menu(this), (this));
		pm.registerEvents(new Craft(this), (this));
		pm.registerEvents(new SignTP(this), (this));
		pm.registerEvents(new Spawn(this), (this));
		getCommand("kicks").setExecutor(new PortalsTeleport());

		getConfig().options().copyDefaults(false);
		saveConfig();

		// ItemStack rottenS = new ItemStack(Material.ROTTEN_FLESH, 1);
		// ItemMeta rottenSM = rottenS.getItemMeta();
		// rottenSM.setDisplayName(ChatColor.DARK_AQUA + "Super Rotten Flesh");
		// rottenS.setItemMeta(rottenSM);
		//
		// ItemStack egg = new ItemStack(Material.EGG, 1);
		// ItemMeta eggM = egg.getItemMeta();
		// eggM.setDisplayName(ChatColor.DARK_AQUA + "Super egg");
		// egg.setItemMeta(eggM);
		//
		// ShapedRecipe recette1 = new ShapedRecipe(rottenS);
		// recette1.shape(new String[] { "ggg", "gcg", "ggg" });
		// recette1.setIngredient('c', Material.ROTTEN_FLESH);
		// recette1.setIngredient('g', Material.GOLD_INGOT);
		// getServer().addRecipe(recette1);
		//
		// ShapedRecipe recette = new ShapedRecipe(egg);
		// recette.shape(new String[] { "ggg", "gcg", "ggg" });
		// recette.setIngredient('c', Material.EGG);
		// recette.setIngredient('g', Material.ANVIL);
		// getServer().addRecipe(recette);

	}

	public void onDisable() {

	}

	public boolean onCommand1(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("day")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Vous devez être un joueur pour utiliser cette commande !");
				return false;
			}
			Player p = (Player) sender;
			p.sendMessage("caca2");
			return true;

		}
		return false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("exemple")) {
			((Player) sender).sendMessage("Bonjour");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("tuto")) {
			((Player) sender).sendMessage(ChatColor.AQUA + "Il fait jour");
			Bukkit.getWorld("world").setTime(10000);
			return true;
		}
		return false;

	}

}
