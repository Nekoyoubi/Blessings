package me.Nekoyoubi.Blessings;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Blessings extends JavaPlugin {

    private final PlayerListener playerListener = new BlessingsPlayerListener();
    private final BlockListener blockListener = new BlessingsBlockListener();

	@Override
	public void onDisable() {
		System.out.println(this + " is now disabled.");
	}

	@Override
	public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Type.BLOCK_PLACE, blockListener, Priority.Low, this);
        pm.registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Low, this);
        //pm.registerEvent(Type.PLAYER_LOGIN, playerListener, Priority.Low, this);
		System.out.println(this + " is now enabled.");
	}
}
