package me.Nekoyoubi.Blessings;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlessingsBlockListener extends BlockListener {
    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.GOLD_BLOCK) {
            Player player = event.getPlayer();
            Nekoyoubi.sendMessage(player, "You have placed a "+ChatColor.GREEN+"shrine"+ChatColor.WHITE+". Right click to seek the blessings of the gods.");
        }
    }

}
