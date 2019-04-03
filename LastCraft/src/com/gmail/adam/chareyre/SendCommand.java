package com.gmail.adam.chareyre;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class SendCommand implements Listener {

	public SendCommand(Main main) {
	}

	private ArrayList<UUID> autopickup = new ArrayList<>();

	@EventHandler
	public void Executeunecommande(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] args = msg.split(" ");

		if (args[0].equalsIgnoreCase("/cobble")) {
			e.setCancelled(true);
			if (args.length == 1) {
				p.sendMessage(ChatColor.BOLD + "Cobble:");
				p.sendMessage(ChatColor.GREEN + "-Actif");
				p.sendMessage(ChatColor.RED + "-Desactif");
			}
		}
		if (args.length == 2) {

			if (args[1].equalsIgnoreCase("toggle")) {
				if (autopickup.contains(p.getUniqueId())) {
					p.sendMessage("Vous n'avez plus l'autoopickup");
					autopickup.remove(p.getUniqueId());

				} else {
					p.sendMessage("Vous avez autopickup !");
					autopickup.add(p.getUniqueId());
				}
			}
		}
	}

	@EventHandler
	public void breakon(BlockBreakEvent e) {
		Location loc = e.getBlock().getLocation();
		if (autopickup.contains(e.getPlayer().getUniqueId()) && e.getBlock().getType() == Material.STONE) {
			if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.COBBLESTONE, 1));
			}
		}
	}
}
/*
 * if (args[0].equalsIgnoreCase("/rekt")) { if
 * (p.getDisplayName().equals("CactusCata") ||
 * p.getDisplayName().equals("laurentCarrmelie")) { if (p.isOp()) { if
 * (args.length == 2) { if (args[1].equalsIgnoreCase(p.getName() + "")) {
 * p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
 * e.setCancelled(true); }
 * 
 * } } } else { p.sendMessage("Unknown command. Type \"/help\" for help."); }
 * e.setCancelled(true); } }
 * 
 * boolean onCommand(CommandSender sender, Command command, String commandLabel,
 * String[] args) { Player player = (Player) sender; //Don't ever put the
 * "Player target = getServer().getPlayer(args[0]);" here, that will mess up
 * your code. I have tested it, and found that it was making errors in the code.
 * if(commandLabel.equalsIgnoreCase("ignite")){ if(sender instanceof Player){
 * if(args.length == 1){ //target Player Player target =
 * Bukkit.getServer().getPlayer(args[0]); //Put the
 * "Player target = getServer().getPlayer(args[0]);" here! After you have
 * established there is a target. player.sendMessage("You have ignited " +
 * target.getName()); target.setFireTicks(1000); //1 second. }else{
 * sender.sendMessage(ChatColor.RED + "Too few arguments!"); } }else{
 * sender.sendMessage(
 * "[SimpleActions] This command can only be run by a player!"); return false;
 * //If the code does if statement does not pass, alway return false. } }
 * 
 * return false; }
 */
