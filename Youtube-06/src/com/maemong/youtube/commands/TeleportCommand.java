package com.maemong.youtube.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("플레이어만 사용 가능한 명령어입니다.");
			return false;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0) {
			player.sendMessage("상대방 플레이어 이름을 입력해주세요.");
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		
		if (target == null) {
			player.sendMessage("해당 플레이어는 존재하지 않습니다.");
			return false;
		}
		
		player.teleport(target.getLocation());
		player.sendMessage(target.getName() + "님에게 텔레포트를 하였습니다.");
		target.sendMessage(player.getName() + "님이 당신에게 텔레포트를 하였습니다.");
		
		return true;
	}
}
