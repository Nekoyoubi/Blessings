package me.Nekoyoubi.Blessings;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Favor {

	/**
	 * Flavor text to be displayed. Only the lowest-chance favor given's text will be displayed.
	 */
	public String flavor;
	/**
	 * The action to perform (e.g. "give", "spawn", "heal", "ill", etc...).
	 */
	public String action;
	/**
	 * The data (if any) associated with the action (e.g. "14" for the RED in wool).
	 */
	public String data;
	/**
	 * The targets to be effected by the action (i.e. "player", "random", "world). Stack values with a semicolon (e.g. "player;random;random").
	 */
	public String targets;
	/**
	 * The chance (in 1000) that this favor will be granted.
	 */
	public Integer chance;
	/**
	 * Represents a unit of favor from a god. Consider it a gift or blessing.
	 * @param chance The chance (in 1000) that the favor will be granted.
	 * @param action The action to perform (e.g. "give", "spawn", "heal", "ill", etc...)
	 * @param targets The targets to be effected by the action (i.e. "player", "random", "world). Stack values with a semicolon (e.g. "player;random;random").
	 * @param data The data (if any) associated with the action (e.g. "14" for the RED in wool).
	 * @param flavor Flavor text to be displayed. Only the lowest-chance favor given's text will be displayed.
	 */
	public Favor(Integer chance, String action, String targets, String data, String flavor) {
		this.chance = chance;
		this.action = action;
		this.targets = targets;
		this.data = data;
		this.flavor = flavor;
	}
	/**
	 * Processes a blessing's favor for a player (e.g. gives items, spawns mobs, etc...).
	 * @param player The player receiving the favor.
	 * @param shrine The shrine that the player just used.
	 */
	public void process(Player player, Block shrine) {
		// Determine targets and establish the list of players to effect.
		ArrayList<Player> effectTargets = getTargets(player);
		Nekoyoubi.sendMessage(player, "Processing: "+action+" "+targets+" "+data);
		if (action == "give") {
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			for (String i : this.data.split(";")) {
				if (i.matches("^\\d+$")) { // Give an item.
					// e.g. "35" == A single piece of plain white wool.
					items.add(new ItemStack(Integer.parseInt(i), 1));
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
							Short.parseShort(i.split(":")[1])));
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
					target.updateInventory();
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
	
	/**
	 * Determines the list of players to be effected by a blessing (or curse).
	 * @param player The player instigating the blessing.
	 * @return Returns an array of players to effect with a favor.
	 */
	private ArrayList<Player> getTargets(Player player) {
		ArrayList<Player> effectTargets = new ArrayList<Player>();
		for (String t : this.targets.split(";")) {
			if (t == "player") {
				effectTargets.add(player);
			} else if (t == "random") {
				Player rando = Nekoyoubi.randomPlayerInWorld(player.getWorld());
				if (!effectTargets.contains(rando)) effectTargets.add(rando);
			} else if (t == "world") {
				effectTargets.clear();
				effectTargets.addAll(player.getWorld().getPlayers());
			} else if (t == "server") {
				// TODO Think long and hard about this one... smells horribad.
			}
		}
		return effectTargets;
	}
}
