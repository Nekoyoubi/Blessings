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
	
	public Favor(Integer cost, String action, String data, String flavor) {
		this.cost = cost;
		this.action = action;
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
				// TODO Think long and hard about this one... spells horribad.
			}
		}
		
		if (action == "give") {
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			for (String i : this.data.split(";")) {
				if (i.matches("^\\d+$")) {
					items.add(new ItemStack(Integer.parseInt(i)));
				} else if (i.matches("^\\d+\\,\\d+$")) {
					items.add(new ItemStack(
							Integer.parseInt(i.split(",")[0]),
							Integer.parseInt(i.split(",")[1])));
				} else if (i.matches("^\\d+\\,\\d+\\:\\d$")) {
					items.add(new ItemStack(
							Integer.parseInt(i.split(",")[0]),
							Integer.parseInt(i.split(",")[1].split(":")[0]),
							Short.parseShort(i.split(",")[1].split(":")[1])));
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
