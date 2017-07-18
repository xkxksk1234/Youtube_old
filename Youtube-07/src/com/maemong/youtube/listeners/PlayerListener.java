package com.maemong.youtube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.maemong.youtube.Youtube;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();

		Bukkit.getScheduler().runTaskLater(Youtube.getInstance(), () -> {
			p.sendMessage("3초 후 다시 전달 되는 메시지: " + msg);
		}, 20*3);
		
		Bukkit.getScheduler().runTaskTimer(Youtube.getInstance(), () -> {
			p.sendMessage("5초 마다 다시 전달 되는 메시지: " + msg);
		}, 20*5, 20*5);
	}
}
