package me.Nekoyoubi.Blessings.Gods;

import java.util.ArrayList;

import org.bukkit.Material;

import me.Nekoyoubi.Blessings.Favor;
import me.Nekoyoubi.Blessings.God;

public class Gaia extends God {
	public Gaia() {
		colorCode = "&a";
		displayName = "Gaia";
		msgGiven = colorName()+" bestows the earths blessings upon you.";
		msgDisappoint = colorName()+" frowns upon your apathy.";
		msgNull = "You would be unheard by "+colorName()+" at this level.";
		shrineBases = new ArrayList<Material>(2);
		shrineBases.add(Material.DIRT);
		shrineBases.add(Material.GRASS);
		favors = new ArrayList<Favor>();
		
		favors.add(new Favor(100, "heal", "world", "", "")); // Heals the world.
		
		favors.add(new Favor(50, "feed", "world", "", "")); // Feeds the world.
		favors.add(new Favor(250, "feed", "player;random;random", "", "")); // Feeds the player and two random players.
		
		favors.add(new Favor(75, "give", "player", "351:10", "")); // One light green dye.
		favors.add(new Favor(75, "give", "player", "351:2", "")); // One green dye.
		favors.add(new Favor(75, "give", "player", "351:3", "")); // One brown dye (cocoa beans).
		favors.add(new Favor(100, "give", "player", "295x3", "")); // Three seeds.
		favors.add(new Favor(100, "give", "player", "295x3", "")); // Three seeds.
		favors.add(new Favor(100, "give", "player", "295x3", "")); // Three seeds.
		favors.add(new Favor(50, "give", "player", "6x3", "")); // Three saplings.
		favors.add(new Favor(50, "give", "player", "6:1x3", "")); // Three saplings.
		favors.add(new Favor(50, "give", "player", "6:2x3", "")); // Three saplings.
		favors.add(new Favor(50, "give", "player", "106x10", "")); // Ten vines.
		favors.add(new Favor(50, "give", "player", "81x10", "")); // Ten cacti.
		favors.add(new Favor(50, "give", "player", "338x10", "")); // Ten cane.
		favors.add(new Favor(30, "give", "player", "35:5x10", "")); // Ten green wool.
		favors.add(new Favor(30, "give", "player", "35:13x10", "")); // Ten dark green wool.
		favors.add(new Favor(30, "give", "player", "35:12x10", "")); // Ten brown wool.
		favors.add(new Favor(30, "give", "player", "282x3", "")); // Three soups.
		favors.add(new Favor(20, "give", "player", "260x3", "")); // Three apples.
		favors.add(new Favor(50, "give", "player", "292", "")); // An iron hoe.
		favors.add(new Favor(40, "give", "player", "256", "")); // An iron shovel.
		favors.add(new Favor(30, "give", "player", "326", "")); // A bukkit of water.
		favors.add(new Favor(20, "give", "player", "296x64", "")); // A stack (64) of wheat.
		favors.add(new Favor(20, "give", "player", "103x3", "")); // Three melons.
		favors.add(new Favor(15, "give", "player", "293", "")); // A diamond hoe.
		favors.add(new Favor(10, "give", "player", "277", "")); // A diamond shovel.
	}

}
