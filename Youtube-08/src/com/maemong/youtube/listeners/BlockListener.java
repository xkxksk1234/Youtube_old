package com.maemong.youtube.listeners;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		
		if (!player.isOp()) {
			e.setCancelled(true);
			player.sendMessage("§c블록을 부술 수 없습니다.");
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		Random random = new Random();
		
		int x = random.nextInt(100);
		final int y = 70;
		int z = random.nextInt(100);
		
		Location loc = new Location(player.getWorld(), x, y, z);
		
		player.teleport(loc);
		player.sendMessage(String.format("X: %d Y: %d Z: %d 위치로 텔레포트 하였습니다.", x, y, z));
	}
}
