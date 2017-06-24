package com.maemong.youtube;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Youtube extends JavaPlugin implements CommandExecutor {
	@Override
	public void onEnable() {
		System.out.println("플러그인이 활성화되었습니다.");
		
		getCommand("test").setExecutor(this);
		getCommand("youtube").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			sender.sendMessage("Test Command!");
		} else if (cmd.getName().equalsIgnoreCase("youtube")) {
			sender.sendMessage("Youtube!");
		}
		
		return true;
	}
}
