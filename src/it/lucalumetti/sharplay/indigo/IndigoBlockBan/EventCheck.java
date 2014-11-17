package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class EventCheck implements Listener{
	private Plugin plugin;
	private BanList banlist;

	public EventCheck(Plugin plugin, BanList banlist){
		this.plugin = plugin;
		this.banlist = banlist;
	}
		@EventHandler
		public void onBlockPlaceEvent(BlockPlaceEvent ev){
			ev.setCancelled(banlist.isBan(ev.getBlock().getType().toString(), "PLACE"));					
		}
		@EventHandler
		public void onPlayerInteractEvent(PlayerInteractEvent ev){
			ev.setCancelled(banlist.isBan(ev.getItem().getType().toString(), "USE"));					
		}
		
		@EventHandler
		public void onBlockForm(BlockFormEvent ev){
			ev.setCancelled(banlist.isBan(ev.getBlock().getType().toString(),"WORLD"));
		}
}
