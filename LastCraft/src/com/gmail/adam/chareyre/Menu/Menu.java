package com.gmail.adam.chareyre.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.adam.chareyre.Main;
import com.gmail.adam.chareyre.spawn.Particle;

public class Menu implements Listener {

	public static final String POUDRE_PREFIX = ChatColor.DARK_BLUE + "[" + ChatColor.AQUA + "Poudre"
			+ ChatColor.DARK_BLUE + "] " + ChatColor.YELLOW;

	public Menu(Main main) {
	}

	// Join la partie
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		ItemStack comp = new ItemStack(Material.COMPASS);
		ItemMeta compM = comp.getItemMeta();
		compM.setDisplayName("§e§lMenu Principal");
		comp.setItemMeta(compM);

		ItemStack powder = new ItemStack(Material.SULPHUR);
		ItemMeta powderM = powder.getItemMeta();
		powderM.setDisplayName("§eDesactiver les joueurs");
		powder.setItemMeta(powderM);

		p.getInventory().setItem(4, comp);
		p.getInventory().setItem(5, powder);
	}

	private ArrayList<UUID> powder = new ArrayList<>();
	private int countdown = 5;

	@EventHandler(priority = EventPriority.HIGH)
	public void onInteractItem(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if (e.getItem() == null)
			return;

		ItemStack item = e.getItem();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (item.getType() == Material.COMPASS) {
				player.playNote(player.getLocation(), Instrument.BASS_GUITAR, new Note(1));
				openMenuPrincipal(player);
			}
		}

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (item.getType() == Material.SULPHUR) {
				if (powder.contains(player.getUniqueId())) {
					player.sendMessage(POUDRE_PREFIX + "Vous voyez les autres joueurs !");

					for (Player p : Bukkit.getOnlinePlayers()) {
						if (p != player) {
							player.showPlayer(p);
						}
					}

					powder.remove(player.getUniqueId());

					Inventory inventory = player.getInventory();

					task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
						ItemStack itemCountdown = item.clone();
						itemCountdown.setAmount(-countdown);
						inventory.setItem(5, itemCountdown);
						player.updateInventory();

						if (countdown < 0) {
							Bukkit.getServer().getScheduler().cancelTask(task);
						} else {
							countdown--;
						}
					} , 0, 20);
				} else {
					player.sendMessage(POUDRE_PREFIX + "Vous ne voyez plus les autres joueurs !");

					for (Player p : Bukkit.getOnlinePlayers()) {
						if (p != player) {
							player.hidePlayer(p);
						}
					}

					powder.add(player.getUniqueId());
				}
			}
		}
	}

	private static final String invName = "§eMenu";

	public void openMenuPrincipal(Player p) {

		Inventory menu = Bukkit.createInventory(null, 27, invName);

		menu.setItem(0, (getItem(Material.GOLDEN_CARROT, 1, 0, "§6UHCRun", "Un UHC en plus rapide",
				"Craft/ressources améliorés !", "Pour encore plus de PvP !")));
		menu.setItem(1, (getItem(Material.FEATHER, 1, 0, "§6Parkours", "Des parkours en tous genres",
				"Difficultés choisissable !", "Avec de belles récompenses")));
		menu.setItem(2, (getItem(Material.DIAMOND_BARDING, 1, 0, "§6Free Build", "Un monde survivial sans pvp où",
				"personne ne pourra casser", "vos construction !")));
		menu.setItem(3, (getItem(Material.EMERALD, 1, 0, "§6Cosmetique", "Permet, grâce à des points",
				"De vous appliquer des cosmetique", "Obtenssible en jeu !")));

		p.openInventory(menu);
	}

	private ItemStack getItem(Material material, int nombre, int data, String displayName, String description,
			String description1, String description2) {
		ItemStack item = new ItemStack(material, nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setLore(Arrays.asList(ChatColor.WHITE + description, ChatColor.WHITE + description1,
				ChatColor.WHITE + description2));
		itemM.setDisplayName(displayName);
		item.setItemMeta(itemM);
		return item;
	}

	@EventHandler
	public void onClickMenu(InventoryClickEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase(invName)) {
			Player p = (Player) e.getWhoClicked();
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				return;
			}

			switch (e.getCurrentItem().getType()) {
			case DIAMOND_BARDING:
				p.sendMessage(ChatColor.DARK_PURPLE + "Téléportation...");
				World w = Bukkit.getWorld("Build");
				Location loc = new Location(w, 96, 71, 549);
				p.teleport(loc);
				p.closeInventory();
				break;
			case FEATHER:
				p.sendMessage("A voir avec les fonda");
				p.closeInventory();
				break;
			case GOLDEN_CARROT:
				p.sendMessage("T'as crus que le dev était si fort ? xD");
				p.closeInventory();
				break;
			case EMERALD:
				MenuCosmetique(p);
				break;
			default:
				break;
			}
		}
	}

	private void MenuCosmetique(Player p) {
		Inventory menu = Bukkit.createInventory(null, 27, "§eCosmetiques");
		ItemStack item = new ItemStack(Material.FEATHER, 1);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§eDouble Jump");
		item.setItemMeta(itemM);
		menu.setItem(0, item);
		p.openInventory(menu);

	}

	@EventHandler
	public void onClickSucces(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase(invName)) {
			if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.EMERALD) {
				Player p = (Player) e.getWhoClicked();
				Inventory menu = Bukkit.createInventory(null, 27, "§eCosmetiques");
				p.openInventory(menu);
				e.setCancelled(true);
			}
		}
	}

	ArrayList<UUID> doublejump = new ArrayList<>();

	@EventHandler
	public void onClickCometiques(InventoryClickEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase("§eCosmetiques")) {
			Player p = (Player) e.getWhoClicked();
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			switch (e.getCurrentItem().getType()) {
			case FEATHER:
				p.closeInventory();
				World w = p.getWorld();
				if (w.getName().equals("Takinou_") || w.getName().equals("world")) {
					if (doublejump.contains(p.getUniqueId())) {
						p.sendMessage("Vous n'avez plus le double jump");
						doublejump.remove(p.getUniqueId());

					} else {
						p.sendMessage("Vous avez le double jump !");
						doublejump.add(p.getUniqueId());
					}
				} else {
					p.sendMessage("Vous n'êtes pas dans le bon monde");
				}
				break;
			default:
				break;
			}
		}
	}

	private int task;

	@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
		Player player = e.getPlayer();
		if (player.getGameMode() == GameMode.ADVENTURE) {
			e.setCancelled(true);

			Location loc = player.getLocation();
			World w = loc.getWorld();
			w.playSound(loc, Sound.ANVIL_LAND, 0.3F, 0.1F);

			player.setAllowFlight(false);
			player.setFlying(false);
			player.setVelocity(loc.getDirection().multiply(1.5).setY(1));

			task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
				if (w.getName().equals("Takinou_") || w.getName().equals("world")) {
					Particle.CLOUD.display(0, 0, 0, 0, 10, player.getLocation(), 16);
				}
			} , 0, 10);
		}

	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		World w = e.getPlayer().getWorld();
		if (doublejump.contains(e.getPlayer().getUniqueId())
				&& (w.getName().equals("Takinou_") || w.getName().equals("world"))) {
			Player p = e.getPlayer();
			if (p.isOp() == true) {
				if ((p.getGameMode() == GameMode.ADVENTURE)
						&& (p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR)
						&& (!p.isFlying())) {
					p.setAllowFlight(true);
					Bukkit.getScheduler().cancelTask(task);

				}
			}
		}
	}

}
