package com.maemong.youtube;

import org.bukkit.plugin.java.JavaPlugin;

import com.maemong.youtube.commands.HealCommand;
import com.maemong.youtube.commands.TeleportCommand;

public class Youtube extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("플러그인이 활성화되었습니다.");
		
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("tp").setExecutor(new TeleportCommand());
	}
}
