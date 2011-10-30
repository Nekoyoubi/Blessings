package me.Nekoyoubi.Blessings.Gods;

import java.util.ArrayList;

import org.bukkit.Material;

import me.Nekoyoubi.Blessings.Favor;
import me.Nekoyoubi.Blessings.God;

public class Ares extends God {
	public Ares() {
		colorCode = "&4";
		displayName = "Ares";
		shrineBases = new ArrayList<Material>(2);
		shrineBases.add(Material.SAND);
		shrineBases.add(Material.SANDSTONE);
		favors = new ArrayList<Favor>();
		favors.add(new Favor(1, "give", "player", "351:1", "")); // One red dye.
		favors.add(new Favor(2, "give", "player", "262", "")); // One arrow.
		favors.add(new Favor(3, "give", "player", "35:14x3", "")); // One red wool.
		favors.add(new Favor(10, "give", "player", "101", "")); // One 'bars' block.
		favors.add(new Favor(10, "give", "player", "262x16", "")); // 16 arrows.
		favors.add(new Favor(20, "give", "player", "261", "")); // One bow.
		favors.add(new Favor(20, "give", "player", "258", "")); // An iron axe.
		favors.add(new Favor(30, "give", "player", "267", "")); // An iron sword.
		favors.add(new Favor(40, "give", "player", "262x64", "")); // A stack (64) of arrows.
		favors.add(new Favor(40, "give", "player", "46", "")); // A block of TNT.
		favors.add(new Favor(50, "give", "player", "279", "")); // A diamond axe.
		favors.add(new Favor(75, "give", "player", "276", "")); // A diamond sword.
		favors.add(new Favor(100, "spawn", "player", "dogofwar", "")); // A tamed wolf.
	}
	
}
