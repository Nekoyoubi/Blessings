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
				int modchance = favor.chance * (level*((level/2)+1));
				//Nekoyoubi.sendMessage(player, favor.action+" "+favor.data+" / ("+favor.chance+"*"+level+" = "+modchance+") > "+test);
				if (test < modchance) {
					favor.process(player, shrine);
				}
				
			}
			player.setLevel(0);
			player.setExperience(0);
			player.setTotalExperience(0);
			Nekoyoubi.sendMessage(player, (level < 3) ? msgDisappoint : msgGiven);
		} else {
			Nekoyoubi.sendMessage(player, msgNull);
		}
	}
}