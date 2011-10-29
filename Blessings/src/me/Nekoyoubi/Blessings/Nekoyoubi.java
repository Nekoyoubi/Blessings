package me.Nekoyoubi.Blessings;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Nekoyoubi {
    private static String chatStart = ChatColor.GOLD + "Blessings" + ChatColor.WHITE + ": ";
    public static void sendMessage(Player player, String message){
        player.sendMessage(chatStart+message.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
    }
	public static Player randomPlayerInWorld(World world) {
		if (world.getPlayers().size() > 0) {
			return world.getPlayers().get(new Random().nextInt(world.getPlayers().size()));
		} else {
			return null;		
		}
	}

}
