package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class IndigoBlockBan extends JavaPlugin{

	private static Logger log = Logger.getLogger("Minecraft");	
	public BanList banlist = new BanList(this);
	
	public void onEnable(){
		saveDefaultConfig();
		initializeCommands(banlist);
	}
	
	public void onDisable(){
		
	}
	
	public void initializeCommands(BanList bn) {
	CommandExc cmdexc = new CommandExc(this,bn);
	getCommand("IBB").setExecutor(cmdexc);
	getCommand("IndigoBlockBan").setExecutor(cmdexc);
	}
	
}
