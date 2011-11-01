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
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlessingsBlockListener extends BlockListener {
	
    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
    	Block shrine = event.getBlock();
        if (shrine.getType() == Material.GOLD_BLOCK) {
            Player player = event.getPlayer();
            Block under = shrine.getRelative(0, -1, 0);
            ArrayList<God> gods = new ArrayList<God>();
            gods.add(new Ares());
            gods.add(new Athena());
            gods.add(new Gaia());
            gods.add(new Hades());
            gods.add(new Zeus());
            for (God god : gods) {
				if (god.shrineBases.contains(under.getType())) {
					god.newShrine(player, shrine);
				}
			}

            //Nekoyoubi.sendMessage(player, "You have placed a "+ChatColor.GREEN+"shrine"+ChatColor.WHITE+".\\nRight click to seek the blessings of the gods.");
        }
    }

}
