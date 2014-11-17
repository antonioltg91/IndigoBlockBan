package it.lucalumetti.sharplay.indigo.IndigoBlockBan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BanList {
	private JavaPlugin instance;
	private Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public BanList(JavaPlugin plugin){
	 instance=plugin;
	}

	public void readLista(){
	    for(String key: instance.getConfig().getKeys(false)){
	        List<String> value=instance.getConfig().getStringList(key);
	        map.put(key, value);
	    }
	}
	
	public void addBlock(String key, List<String> value){
		map.put(key, value);
	}
	
	public void salvaLista(){
	    for(Map.Entry<String, List<String>> entry: map.entrySet()){
	        instance.getConfig().set(entry.getKey(), entry.getValue());
	    }
	    instance.saveConfig();
	}
	
	public void addPerm(String key, String permesso){
	    List<String> temp;
	    if(map.containsKey(key)){
	        temp = map.get(key);
	    }else{
	        temp = new ArrayList<String>();
	    }
	    temp.add(permesso);
	    map.put(key, temp);
	}
	//The permission contains the negate permission
	//if List of key contains USE, the item cannot be use
	public boolean isBan(String key,String permesso){
		if(map.containsKey(key))
			if(map.get(key).contains(permesso))
				return true;
		return false;
	}
	
	public void printLista(Player player){
		for(Map.Entry<String, List<String>> entry: map.entrySet())
			player.sendMessage(entry.getKey() + "§c: " + entry.getValue());
			
	}
	
}
