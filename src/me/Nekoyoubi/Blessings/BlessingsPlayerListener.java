package me.Nekoyoubi.Blessings;

import java.util.ArrayList;


import me.Nekoyoubi.Blessings.Gods.Ares;
import me.Nekoyoubi.Blessings.Gods.Athena;
import me.Nekoyoubi.Blessings.Gods.Gaia;
import me.Nekoyoubi.Blessings.Gods.Hades;
import me.Nekoyoubi.Blessings.Gods.Zeus;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;


public class BlessingsPlayerListener extends PlayerListener {

	@SuppressWarnings("deprecation")
	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
        boolean testing = false;
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Player player = event.getPlayer();
        Block shrine = event.getClickedBlock();
        if (shrine.getType() == Material.GOLD_BLOCK) {
        	event.setCancelled(true);
            if (player.getLevel() <= 0 && player.getExperience() <= 0) return;
            Block under = shrine.getRelative(0, -1, 0);
            ArrayList<God> gods = new ArrayList<God>();
            gods.add(new Ares());
            gods.add(new Athena());
            gods.add(new Gaia());
            gods.add(new Hades());
            gods.add(new Zeus());
            for (God god : gods) {
				if (god.shrineBases.contains(under.getType())) {
					god.offer(player, shrine);
				}
			}
        }
        
        // ***** TESTING (REMEMBER TO DISABLE) ***** //
        else if (testing && shrine.getType() == Material.BOOKSHELF) {
        	event.setCancelled(true);
            player.setExperience(player.getExperience()+10); 
            Nekoyoubi.sendMessage(player, "Cheating will get you everywhere. ;) - "+player.getLevel()+"@"+player.getTotalExperience()+"");
        }
        else if (testing && shrine.getType() == Material.BEDROCK) {
        	event.setCancelled(true);
            player.getInventory().clear();
            player.updateInventory();
            Nekoyoubi.sendMessage(player, "Inventory cleared.");
        }

	}
}
