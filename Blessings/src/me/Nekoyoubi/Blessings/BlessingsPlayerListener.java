package me.Nekoyoubi.Blessings;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BlessingsPlayerListener extends PlayerListener {

	@Override
	public void onPlayerChat(PlayerChatEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerChat(event);
	}

	@Override
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerCommandPreprocess(event);
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Player player = event.getPlayer();
        Block shrine = event.getClickedBlock();
        if (shrine.getType() == Material.GOLD_BLOCK) {
            if (player.getLevel() <= 0 && player.getExperience() <= 0) return;
            Block under = shrine.getRelative(0, -1, 0);
            ArrayList<God> gods = new ArrayList<God>();
            for (God god : gods) {
				if (god.shrineBases.contains(under.getType())) {
					god.offer(player, shrine);
				}
			}
            Ares ares = new Ares();
            
            //if (under.getType() == Material.SAND || under.getType() == Material.SANDSTONE) { PayAres(player); }
            //else if (under.getType() == Material.AIR) { PayThor(player, block); }

        }
        if (shrine.getType() == Material.BOOKSHELF) {
            player.setExperience(player.getExperience()+1); 
            Nekoyoubi.sendMessage(player, "Cheating will get you everywhere. ;) - "+player.getLevel()+"@"+player.getTotalExperience()+"");
        }
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
		}
	}

	@Override
	public void onPlayerLogin(PlayerLoginEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerLogin(event);
	}
	
	

}
