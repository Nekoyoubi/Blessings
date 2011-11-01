package me.Nekoyoubi.Blessings;


import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public abstract class God {
	public String colorCode;
	public String displayName;
	public List<Material> shrineBases;
	public List<Favor> favors;
	public List<Favor> curses;
	protected String msgGiven;
	protected String msgDisappoint;
	protected String msgNull;
	//private String msgSharePlayer;
	//private String msgShareWorld;
	public String colorName() { return colorCode + displayName + "&f"; }
	public void offer(Player player, Block shrine) {
		int level = player.getLevel();
		if (level > 0) {
			Random rando = new Random();
			for (Favor favor : this.favors) {
				int test = rando.nextInt(1000)+1;
				double modchance = (double)favor.chance * ((double)level*(((double)level/2.0)));
				//Nekoyoubi.sendMessage(player, favor.action+" "+favor.data+" / ("+favor.chance+"*"+level+" = "+modchance+") > "+test);
				if (test < modchance) {
					favor.process(player, shrine, this);
				}
			}
			player.setLevel(0);
			player.setExperience(0);
			player.setTotalExperience(0);
			Nekoyoubi.sendMessage(player, (level < 4) ? msgDisappoint : msgGiven);
			if (level < 4) {
				boolean cursed = false;
				for (Favor curse : this.curses) {
					if (!cursed && rando.nextInt(1000)+1 < curse.chance) {
						curse.process(player, shrine, this);
						cursed = true;
					}
				}
			}
		} else {
			Nekoyoubi.sendMessage(player, msgNull);
		}
	}
	
	public void newShrine(Player player, Block shrine) {
		Nekoyoubi.sendMessage(player, "You have placed a new "+colorCode+"Shrine of "+displayName+"&f.", false);
		Nekoyoubi.sendMessage(player, "Right-click the shrine to pay homage to "+colorName(), true);
	}

}