package com.maemong.youtube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("플레이어만 사용 가능한 명령어입니다.");
			return false;
		}
		
		Player player = (Player) sender;
		
		player.setHealth(player.getHealthScale());
		player.setFoodLevel(20);
		player.setFireTicks(0);
		
		player.sendMessage("체력과 배고픔이 회복되었습니다.");
		
		return true;
	}
}
