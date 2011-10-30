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
	private String msgGiven;
	private String msgDisappoint;
	private String msgNull;
	private String msgSharePlayer;
	private String msgShareWorld;
	public String colorName() { return colorCode + displayName + "&f"; }
	public void offer(Player player, Block shrine) {
		int level = player.getLevel();
		//int remaining = player.getTotalExperience();
		if (level<5) {
			// TODO Handle gods being disappoint. ;)
			Nekoyoubi.sendMessage(player, msgDisappoint);
		}
		if (level > 1) {
			Random rando = new Random();
			for (Favor favor : this.favors) {
				if (favor.chance * level > (rando.nextInt(1000)+1))
					favor.process(player, shrine);
			}
			player.setLevel(0);
			player.setExperience(0);
			// TODO Investigate this guy to see if he's statistical or practical.
			// player.setTotalExperience(0);
			Nekoyoubi.sendMessage(player, msgGiven);
		} else {
			Nekoyoubi.sendMessage(player, msgNull);
		}
	}
}