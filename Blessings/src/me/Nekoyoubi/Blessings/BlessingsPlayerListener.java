package me.Nekoyoubi.Blessings;

import java.util.ArrayList;


import me.Nekoyoubi.Blessings.Gods.Ares;
//import me.Nekoyoubi.Blessings.Gods.Athena;
//import me.Nekoyoubi.Blessings.Gods.Gaia;
//import me.Nekoyoubi.Blessings.Gods.Hades;
//import me.Nekoyoubi.Blessings.Gods.Zeus;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerChatEvent;
//import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
//import org.bukkit.event.player.PlayerLoginEvent;

public class BlessingsPlayerListener extends PlayerListener {

	//@Override
	//public void onPlayerChat(PlayerChatEvent event) {
	//	// TODO Auto-generated method stub
	//	super.onPlayerChat(event);
	//}

	//@Override
	//public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
	//	// TODO Auto-generated method stub
	//	super.onPlayerCommandPreprocess(event);
	//}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Player player = event.getPlayer();
        Block shrine = event.getClickedBlock();
        if (shrine.getType() == Material.GOLD_BLOCK) {
            if (player.getLevel() <= 0 && player.getExperience() <= 0) return;
            Block under = shrine.getRelative(0, -1, 0);
            ArrayList<God> gods = new ArrayList<God>();
            gods.add(new Ares());
            //gods.add(new Athena());
            //gods.add(new Gaia());
            //gods.add(new Hades());
            //gods.add(new Zeus());
            for (God god : gods) {
				if (god.shrineBases.contains(under.getType())) {
					god.offer(player, shrine);
				}
			}
        }
        if (shrine.getType() == Material.BOOKSHELF) {
            player.setExperience(player.getExperience()+5); 
            Nekoyoubi.sendMessage(player, "Cheating will get you everywhere. ;) - "+player.getLevel()+"@"+player.getTotalExperience()+"");
        }
	}

	//@Override
	//public void onPlayerLogin(PlayerLoginEvent event) {
	//	Nekoyoubi.sendMessage(event.getPlayer(), "&6Blessings&f: Returning with &6"+event.getPlayer().getTotalExperience()+"&f faith.");
	//}
	
	

}
