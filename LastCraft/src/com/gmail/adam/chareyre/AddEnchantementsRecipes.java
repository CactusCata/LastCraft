package com.gmail.adam.chareyre;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddEnchantementsRecipes implements Listener {

	public AddEnchantementsRecipes(Main main) {

	}

	@EventHandler
	public void onCombine2(InventoryClickEvent e) {
		if (e.getInventory().getType() != InventoryType.ANVIL) {
			return;
		} else {
			AnvilInventory anvil = (AnvilInventory) e.getInventory();
			ItemStack epee = new ItemStack(Material.COAL);
			ItemMeta epeeM = epee.getItemMeta();
			ItemStack right = anvil.getItem(0);
			ItemStack left = anvil.getItem(1);
			epeeM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			epee.setItemMeta(epeeM);
			if (right == epee && left == epee) {
				ItemStack epee2 = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta epeeM2 = epee.getItemMeta();
				epeeM2.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
				epee2.setItemMeta(epeeM2);
				anvil.setItem(2, epee2);
			}
		}
	}
}