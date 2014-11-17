package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class IndigoBlockBan extends JavaPlugin{

	private static Logger log = Logger.getLogger("Minecraft");	
	public BanList banlist = new BanList(this);
	
	public void onEnable(){
		saveDefaultConfig();
		getCommand("IndigoBlockBan").setExecutor(new CommandExc(this,banlist, log));
		this.getServer().getPluginManager().registerEvents(new EventCheck(this, banlist), this);
		banlist.readLista();
		log.info("IndigoBlockBan avviato!");
	}
	
	public void onDisable(){
		
	}
	
}
