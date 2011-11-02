package me.Nekoyoubi.Blessings.Gods;

import java.util.ArrayList;

import org.bukkit.Material;

import me.Nekoyoubi.Blessings.Favor;
import me.Nekoyoubi.Blessings.God;

public class Zeus extends God {
	public Zeus() {
		colorCode = "&d";
		displayName = "Zeus";
		msgGiven = colorName()+" channels the might of the gods to you.";
		msgDisappoint = colorName()+" strikes fear into your weak heart.";
		msgNull = colorName()+" cannot be bothered with you for now.";
		shrineBases = new ArrayList<Material>(1);
		shrineBases.add(Material.AIR);
		favors = new ArrayList<Favor>();
		
		favors.add(new Favor(75, "give", "player", "351:12", "")); // One light blue dye.
		favors.add(new Favor(75, "give", "player", "351:5", "")); // One purple dye.
		favors.add(new Favor(100, "give", "player", "331x3", "")); // Three redstone dust.
		favors.add(new Favor(100, "give", "player", "331x3", "")); // Three redstone dust.
		favors.add(new Favor(100, "give", "player", "331x3", "")); // Three redstone dust.
		favors.add(new Favor(50, "give", "player", "69x3", "")); // Three levers.
		favors.add(new Favor(50, "give", "player", "70x3", "")); // Three pressure plates.
		favors.add(new Favor(50, "give", "player", "77x3", "")); // Three buttons.
		favors.add(new Favor(50, "give", "player", "76x3", "")); // Three redstone torches.	
		favors.add(new Favor(50, "give", "player", "265x5", "")); // Five iron bars.
		favors.add(new Favor(50, "give", "player", "265x5", "")); // Five iron bars.
		favors.add(new Favor(50, "give", "player", "266x5", "")); // Five gold bars.
		favors.add(new Favor(50, "give", "player", "266x5", "")); // Five gold bars.
		favors.add(new Favor(30, "give", "player", "35:3x10", "")); // Ten light-blue wool.
		favors.add(new Favor(30, "give", "player", "35:10x10", "")); // Ten purple wool.
		favors.add(new Favor(20, "give", "player", "33x10", "")); // Ten pistons.
		favors.add(new Favor(20, "give", "player", "29x10", "")); // Ten sticky pistons.
		favors.add(new Favor(20, "give", "player", "27x10", "")); // Ten powered minecart rails.
		favors.add(new Favor(20, "give", "player", "28x10", "")); // Ten detector minecart rails.
		favors.add(new Favor(20, "give", "player", "345", "")); // A compass.
		favors.add(new Favor(20, "give", "player", "347", "")); // A watch.
		favors.add(new Favor(20, "give", "player", "66x64", "")); // A stack (64) of minecart rails.
		favors.add(new Favor(5, "give", "player", "57", "")); // A diamond block.
		Collections.reverse(favors);
		
		curses = new ArrayList<Favor>();	
		curses.add(new Favor(250, "shock", "random", "", "")); // Strikes a random player with lightening.
		

	}

}
