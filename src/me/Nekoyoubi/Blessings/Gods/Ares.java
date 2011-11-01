package me.Nekoyoubi.Blessings.Gods;

import java.util.ArrayList;

import org.bukkit.Material;

import me.Nekoyoubi.Blessings.Favor;
import me.Nekoyoubi.Blessings.God;

public class Ares extends God {
	public Ares() {
		colorCode = "&4";
		displayName = "Ares";
		msgGiven = colorName()+" rallies the armies of %WORLD% to your aid.";
		msgDisappoint = colorName()+" warns you of the inadequacy of your faith.";
		msgNull = "You would only incite the rage of "+colorName()+" at this level.";
		shrineBases = new ArrayList<Material>(2);
		shrineBases.add(Material.SAND);
		shrineBases.add(Material.SANDSTONE);
		
		favors = new ArrayList<Favor>();
		favors.add(new Favor(75, "give", "player", "351:1", "")); // One red dye.
		favors.add(new Favor(75, "give", "player", "351:1", "")); // One red dye.
		favors.add(new Favor(75, "give", "player", "351:14", "")); // One orange dye.
		favors.add(new Favor(100, "give", "player", "262x10", "")); // Ten arrows.
		favors.add(new Favor(100, "give", "player", "262x10", "")); // Ten arrows.
		favors.add(new Favor(30, "give", "player", "35:14x10", "")); // Ten red wool.
		favors.add(new Favor(30, "give", "player", "101x10", "")); // Ten 'bars' blocks.
		favors.add(new Favor(50, "give", "player", "261", "")); // One bow.
		favors.add(new Favor(40, "give", "player", "258", "")); // An iron axe.
		favors.add(new Favor(30, "give", "player", "267", "")); // An iron sword.
		favors.add(new Favor(20, "give", "player", "262x64", "")); // A stack (64) of arrows.
		favors.add(new Favor(20, "give", "player", "46", "")); // A block of TNT.
		favors.add(new Favor(10, "give", "player", "279", "")); // A diamond axe.
		favors.add(new Favor(10, "give", "player", "276", "")); // A diamond sword.
		favors.add(new Favor(10, "spawn", "player", "dogofwar", "")); // A tamed wolf.
		
		curses = new ArrayList<Favor>();	
		curses.add(new Favor(500, "burn", "player", "3", "")); // Burns the player for three seconds.
		curses.add(new Favor(500, "burn", "random", "3", "")); // Burns the player for three seconds.
	}
	
}
