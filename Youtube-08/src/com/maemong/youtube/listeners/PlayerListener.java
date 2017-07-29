package com.maemong.youtube.listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.maemong.youtube.Youtube;

public class PlayerListener implements Listener {
	private Map<String, Integer> map = new HashMap<>();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if (map.containsKey(p.getName() + "_later") || map.containsKey(p.getName() + "_timer")) {
			int laterId = map.get(p.getName() + "_later");
			int timerId = map.get(p.getName() + "_timer");

			Bukkit.getScheduler().cancelTask(laterId);
			Bukkit.getScheduler().cancelTask(timerId);
		}

		map.put(p.getName() + "_later", Bukkit.getScheduler().runTaskLater(Youtube.getInstance(), () -> {
			p.sendMessage("3초 후 다시 전달 되는 메시지: " + msg);
		}, 20*3).getTaskId());
		
		map.put(p.getName() + "_timer", Bukkit.getScheduler().runTaskTimer(Youtube.getInstance(), () -> {
			p.sendMessage("5초 마다 다시 전달 되는 메시지: " + msg);
		}, 20*5, 20*5).getTaskId());
	}
}
