package me.Nekoyoubi.Blessings;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Favor {

	public String flavor;
	public String action;
	public String data;
	public String targets;
	/**
	 * XP cost for this gift.
	 */
	public Integer cost;
	
	public Favor(Integer cost, String action, String targets, String data, String flavor) {
		this.cost = cost;
		this.action = action;
		this.targets = targets;
		this.data = data;
		this.flavor = flavor;
	}

	public void process(Player player, Block shrine) {
		// Determine targets and establish the list of players to effect.
		ArrayList<Player> effectTargets = new ArrayList<Player>();
		for (String t : this.targets.split(";")) {
			if (t == "player") {
				effectTargets.add(player);
			} else if (t == "random") {
				effectTargets.add(Nekoyoubi.randomPlayerInWorld(player.getWorld()));
			} else if (t == "world") {
				effectTargets.addAll(player.getWorld().getPlayers());
			} else if (t == "server") {
				// TODO Think long and hard about this one... smells horribad.
			}
		}
		
		if (action == "give") {
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			for (String i : this.data.split(";")) {
				if (i.matches("^\\d+$")) { // Give an item.
					// e.g. "35" == A single piece of plain white wool.
					items.add(new ItemStack(Integer.parseInt(i)));
				} else if (i.matches("^\\d+x\\d+$")) { // Give a quantity of an item.
					// e.g. "35x5" == Five pieces of plain white wool.
					items.add(new ItemStack(
							Integer.parseInt(i.split("x")[0]),
							Integer.parseInt(i.split("x")[1])));
				} else if (i.matches("^\\d+:\\d+$")) { // Give one of an item with data.
					// e.g. "35:10" == A single piece of purple wool.
					items.add(new ItemStack(
							Integer.parseInt(i.split(":")[0]),
							1,
							Short.parseShort(i.split(":")[0])));
				} else if (i.matches("^\\d+\\:\\d+x\\d+$")) { // Give a quantity of an item with data.
					// e.g. "35:10x5" == Five pieces of purple wool.
					items.add(new ItemStack(
							Integer.parseInt(i.split("x")[0].split(":")[0]),
							Integer.parseInt(i.split("x")[1]),
							Short.parseShort(i.split("x")[0].split(":")[1])));
				}
			}
		
			for (Player target : effectTargets) {
				for (ItemStack itemStack : items) {
					target.getInventory().addItem(itemStack);
				}
			}
		} else if (action == "spawn") {
			
		} else if (action == "heal") {
			
		} else if (action == "feed") {
			
		} else if (action == "hurt") {
			
		} else if (action == "burn") {
			
		} else if (action == "ill") {
			
		} else if (action == "stormy") {
			
		} else if (action == "sunny") {
			
		}
	}
}
