package Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import Command.CMD_Enderchest;

public class main extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("Plugin aktiviert!");
		
		//Command Register
		
		getCommand("enderchest").setExecutor(new CMD_Enderchest());
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin deaktiviert!");
	}

}
