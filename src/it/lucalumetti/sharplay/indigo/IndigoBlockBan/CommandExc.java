package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandExc implements CommandExecutor{
	
	public BanList banlist;
	private Plugin plugin;
	private Logger log;
	
	public CommandExc (Plugin plugin, BanList banlist,Logger log){
		this.plugin = plugin;
		this.banlist = banlist;
		this.log = log;
	}
	
	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("IndigoBlockBan")){
			if(args.length == 0) {player.sendMessage("§c/IndigoBlockBan help"); return true; }
			
			if(args[0].equalsIgnoreCase("save")){
				if(player instanceof Player)
					log.info(cmd.getName() + ": Sto salvando i dati dei blocchi bannati...");
				player.sendMessage(cmd.getName() + ": Sto salvando i dati dei blocchi bannati...");
				
				banlist.salvaLista();
					
				if(player instanceof Player)
					log.info(cmd.getName() + ": Salvata!");
				player.sendMessage(cmd.getName() +  ": Salvata!");
				banlist.printLista((Player) player);
				
			}else 
			if(args[0].equalsIgnoreCase("add")){
				if(player instanceof Player){
					List<String> perms = new ArrayList<String>();
					for(int i = 1;i<args.length;i++){
						if(args[i].equals("WORLD") || args[i].equals("USE") || args[i].equals("PLACE") || args[i].equals("CRAFT")){
							perms.add(args[i]);
						}else{
							player.sendMessage(args[i] + " non e' un permesso valido.");
							player.sendMessage("§cPermessi validi: §eWORLD§f, §ePLACE§f, §eUSE§f, §eCRAFT");
							return false;
						}
					}
					player.sendMessage("Aggiungo il blocco " + ((Player) player).getInventory().getItemInHand().getType().toString() + " alla lista dei blocchi bannati...");
					banlist.addBlock(((Player) player).getInventory().getItemInHand().getType().toString(), perms);
				}else
					player.sendMessage("Tu sei una console, non puoi fare questo §4:(");
			}else{
				player.sendMessage("§c/IndigoBlockBan help");
			}
		return true;
		}
			
		return false;
	}

}
