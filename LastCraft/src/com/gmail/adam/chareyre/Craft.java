package com.gmail.adam.chareyre;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Craft implements Listener {

	public Craft(Main main) {
	}

	@EventHandler
	public void onCraftSpawner(BlockBreakEvent e) {
		if (e.getBlock().toString().equals("bonjour")) {
			Player p = e.getPlayer();
			World w = p.getWorld();
			if (w.getName().equals("world")) {
				Location loc = p.getLocation();
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);

				ItemStack epee = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta epeeM = epee.getItemMeta();

				ArrayList<String> description = new ArrayList<>();
				description.clear();
				description.add("");
				description.add(ChatColor.BOLD + "Epée du kit Guerrier");

				epeeM.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
				epeeM.setDisplayName(ChatColor.DARK_AQUA + "Epée du kit");
				epeeM.setLore(description);
				epee.setItemMeta(epeeM);

				w.dropItemNaturally(loc, epee);
			}
		}
	}

	@EventHandler
	public void craftItem(PrepareItemCraftEvent e) {
		// boolean item = e.getInventory().contains(Material.ACACIA_DOOR);
		Material itemType = e.getRecipe().getResult().getType();
		@SuppressWarnings("deprecation")
		Byte itemData = e.getRecipe().getResult().getData().getData();
		if ((itemType == Material.GOLDEN_APPLE && itemData == 1)) {
			e.getInventory().setResult(new ItemStack(Material.AIR));
			for (HumanEntity he : e.getViewers()) {
				if (he instanceof Player) {
					((Player) he).sendMessage(ChatColor.RED + "You cannot craft this!");
				}
			}
		}
	}

}