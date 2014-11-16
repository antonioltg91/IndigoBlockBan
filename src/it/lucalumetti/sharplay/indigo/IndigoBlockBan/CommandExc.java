package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandExc implements CommandExecutor{
	
	public BanList banlist;
	private Plugin plugin;
	
	public CommandExc (Plugin plugin, BanList bn){
		this.plugin = plugin;
		this.banlist = bn;
	}
	
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if(args[0].equals("IBB") || args[0].equalsIgnoreCase("IndigoBlockBan")){
			if(args[1].equalsIgnoreCase("save")){
				player.sendMessage(args[0] + ": Sto salvando i dati dei blocchi bannati...");
				banlist.salvaLista();
				player.sendMessage(args[0] +  ": Salvata!");
				
			}else if(args[1].equalsIgnoreCase("add")){
				player.sendMessage("Aggiungo il blocco " + ((Player) player).getInventory().getItemInHand().toString() + " alla lista dei blocchi bannati...");   	
				
			}
		return true;
		}
			
		return false;
	}

}
