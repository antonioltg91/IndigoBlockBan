package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventCheck implements Listener{
	BanList blockbanlist = new BanList(new IndigoBlockBan());
		public void onBlockPlaceEvent(BlockPlaceEvent ev){
			
		}
		
		public void onPlayerInteractEvent(PlayerInteractEvent ev){
			
		}
		
		public void onCraft(PrepareItemCraftEvent ev){
		
		}
		
		public void onBlockForm(BlockFormEvent ev){
			
		}
}
