package me.Nekoyoubi.Blessings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

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
	@SuppressWarnings("deprecation")
	public void process(Player player, Block shrine, God god) {
		// Determine targets and establish the list of players to effect.
		ArrayList<Player> effectTargets = getTargets(player);
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
			for (Player target : effectTargets) {
				target.setHealth(Integer.parseInt(this.data));
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" has healed your wounds.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has asked "+god.colorName()+" to heal your wounds.");
			}
		} else if (action == "feed") {
			for (Player target : effectTargets) {
				target.setFoodLevel(Integer.parseInt(this.data));
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" has soothed your hunger.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has asked "+god.colorName()+" to soothe your hunger.");
			}			
		} else if (action == "hunger") {
			for (Player target : effectTargets) {
				target.setFoodLevel(Integer.parseInt(this.data));
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. Feast on your own famine.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has angered "+god.colorName()+".");
			}			
		} else if (action == "hurt") {
			for (Player target : effectTargets) {
				target.damage(Integer.parseInt(this.data), player);
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. Your life was forfeit.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has brought the wrath of "+god.colorName()+" upon you.");
			}
		} else if (action == "burn") {
			for (Player target : effectTargets) {
				target.setFireTicks(Integer.parseInt(this.data)*20);
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. Enjoy your rewards.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has brought the flames of "+god.colorName()+" upon you.");
			}
		} else if (action == "dig") {
			for (Player target : effectTargets) {
				Location tloc = target.getLocation();
				for (int u = 0; u < 3; u++) {
					Block under = tloc.getBlock().getRelative(0, -(u+1), 0);
					if (	under.getType() != Material.AIR &&
							under.getType() != Material.BEDROCK)
						under.setType(Material.AIR);
				}
					if (target == player)
						Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. To the underworld with you!");
					else
						Nekoyoubi.sendMessage(target, player.getDisplayName()+" has convinced "+god.colorName()+" to send you to the underworld.");
			}
		} else if (action == "stormy") {
			if (player.getWorld().getWeatherDuration() == 0) {
				player.getWorld().setStorm(true);
				for (Player target : effectTargets) {
					if (target == player)
						Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. The skys rumble and riot above you.");
					else
						Nekoyoubi.sendMessage(target, player.getDisplayName()+" has brought the tempests of "+god.colorName()+" upon you.");
				}
			}
		} else if (action == "sunny") {
			if (player.getWorld().getWeatherDuration() > 0) {
				player.getWorld().setStorm(false);
				for (Player target : effectTargets) {
					if (target == player)
						Nekoyoubi.sendMessage(target, god.colorName()+" has lifted the clouds in your honor.");
					else
						Nekoyoubi.sendMessage(target, player.getDisplayName()+" has asked "+god.colorName()+" to bring out the sun.");
				}
			}
		} else if (action == "shock") {
			for (Player target : effectTargets) {
				player.getWorld().strikeLightning(target.getLocation());
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. Cower in the might of "+god.colorName()+"!");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has brought the wrath of "+god.colorName()+" upon you.");
			}
		} else if (action == "weaken") {
			for (Player target : effectTargets) {
				PlayerInventory inv = target.getInventory();
				HashMap<Integer,ItemStack> map = new HashMap<Integer, ItemStack>();
				map.putAll(inv.all(Material.IRON_HELMET));
				map.putAll(inv.all(Material.IRON_CHESTPLATE));
				map.putAll(inv.all(Material.IRON_LEGGINGS));
				map.putAll(inv.all(Material.IRON_BOOTS));
				map.putAll(inv.all(Material.DIAMOND_HELMET));
				map.putAll(inv.all(Material.DIAMOND_CHESTPLATE));
				map.putAll(inv.all(Material.DIAMOND_LEGGINGS));
				map.putAll(inv.all(Material.DIAMOND_BOOTS));
				Nekoyoubi.sendMessage(target, map.size()+"");
				
				Random rando = new Random();
				Object[] values = map.values().toArray();
				ItemStack item = (ItemStack)values[rando.nextInt(values.length)];
				Nekoyoubi.sendMessage(target, "Before: "+item.getDurability());
				item.setDurability((short)(item.getDurability()/(short)2));
				Nekoyoubi.sendMessage(target, "After: "+item.getDurability());
				target.updateInventory();
				if (target == player)
					Nekoyoubi.sendMessage(target, god.colorName()+" was not amused. Your armor was your aegis.");
				else
					Nekoyoubi.sendMessage(target, player.getDisplayName()+" has brought the wrath of "+god.colorName()+" upon you.");
			}
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
