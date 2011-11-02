package me.Nekoyoubi.Blessings.Gods;

import java.util.ArrayList;

import org.bukkit.Material;

import me.Nekoyoubi.Blessings.Favor;
import me.Nekoyoubi.Blessings.God;

public class Hades extends God {
	public Hades() {
		colorCode = "&8";
		displayName = "Hades";
		msgGiven = colorName()+" allows you to walk away... this time.";
		msgDisappoint = colorName()+" curses your few remaining days.";
		msgNull = "Disturbing "+colorName()+" now could only end badly.";
		shrineBases = new ArrayList<Material>(2);
		shrineBases.add(Material.BEDROCK);
		shrineBases.add(Material.OBSIDIAN);
		favors = new ArrayList<Favor>();
		
		//favors.add(new Favor(10, "shock", "random", "", "")); // Strikes a random player with lightening.
		
		favors.add(new Favor(75, "give", "player", "351:0", "")); // One black dye.
		favors.add(new Favor(75, "give", "player", "351:8", "")); // One grey dye.
		favors.add(new Favor(100, "give", "player", "352x3", "")); // Three bones.
		favors.add(new Favor(100, "give", "player", "352x3", "")); // Three bones.
		favors.add(new Favor(100, "give", "player", "263x3", "")); // Three coal.
		favors.add(new Favor(100, "give", "player", "263x3", "")); // Three coal.
		favors.add(new Favor(50, "give", "player", "50x3", "")); // Three torches.
		favors.add(new Favor(50, "give", "player", "50x3", "")); // Three torches.
		favors.add(new Favor(50, "give", "player", "50x3", "")); // Three torches.
		favors.add(new Favor(50, "give", "player", "50x3", "")); // Three torches.	
		favors.add(new Favor(50, "give", "player", "91", "")); // A jack-o-lantern.
		favors.add(new Favor(40, "give", "player", "87x3", "")); // Three netherrack blocks.
		favors.add(new Favor(40, "give", "player", "88x3", "")); // Three soul sand blocks.
		favors.add(new Favor(40, "give", "player", "89x3", "")); // Three glow stone blocks.
		favors.add(new Favor(30, "give", "player", "35:15x10", "")); // Ten black wool.
		favors.add(new Favor(30, "give", "player", "35:7x10", "")); // Ten dark-grey wool.
		favors.add(new Favor(20, "give", "player", "35:7x10", "")); // An iron pickaxe.
		favors.add(new Favor(20, "give", "player", "264", "")); // A diamond.
		favors.add(new Favor(20, "give", "player", "327", "")); // A bukkit of lava.
		favors.add(new Favor(20, "give", "player", "30x10", "")); // Ten spider webs.
		favors.add(new Favor(20, "give", "player", "91x3", "")); // Three jack-o-lanterns.
		favors.add(new Favor(20, "give", "player", "345", "")); // A compass.
		favors.add(new Favor(20, "give", "player", "347", "")); // A watch.
		favors.add(new Favor(20, "give", "player", "65x64", "")); // A stack (64) of ladders.
		favors.add(new Favor(10, "give", "player", "57", "")); // A diamond pickaxe.
		Collections.reverse(favors);
		
		curses = new ArrayList<Favor>();	
		curses.add(new Favor(100, "dig", "random", "3", "")); // Drops a random player down three blocks in the ground.

	}

}
