package me.Nekoyoubi.Blessings;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	Player player = (sender instanceof Player) ? (Player)sender : null;
    	if(cmd.getName().equalsIgnoreCase("faith") && player != null) {
    		Nekoyoubi.sendMessage(player, "You currently have "+player.getLevel()+" levels of faith to offer.");
    		return true;
    	} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
    	return false; 
    }


}
