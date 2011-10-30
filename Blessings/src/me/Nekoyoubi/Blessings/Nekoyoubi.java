package me.Nekoyoubi.Blessings;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Nekoyoubi {
    private static String chatStart = ChatColor.GOLD + "Blessings" + ChatColor.WHITE + ": ";
    public static void sendMessage(Player player, String message){
        player.sendMessage(chatStart+message
        		.replaceAll("(&([a-f0-9]))", "\u00A7$2")
        		.replaceAll("%WORLD%", titleCase(player.getWorld().getName())));
    }
	public static Player randomPlayerInWorld(World world) {
		if (world.getPlayers().size() > 0) {
			return world.getPlayers().get(new Random().nextInt(world.getPlayers().size()));
		} else {
			return null;		
		}
	}

	public static String titleCase(String text){
        String result = "";
        for (int i = 0; i < text.length(); i++){
            String next = text.substring(i, i + 1);
            result += (i == 0) ? next.toUpperCase() : next.toLowerCase();
        }
        return result;
    }
}
