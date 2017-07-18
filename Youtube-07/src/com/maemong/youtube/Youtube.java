package com.maemong.youtube;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.maemong.youtube.commands.HealCommand;
import com.maemong.youtube.commands.TeleportCommand;
import com.maemong.youtube.listeners.BlockListener;
import com.maemong.youtube.listeners.PlayerListener;

public class Youtube extends JavaPlugin {
	private static Youtube instance;
	
	public static Youtube getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		System.out.println("플러그인이 활성화되었습니다.");
		
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("tp").setExecutor(new TeleportCommand());
		
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
	}
}
