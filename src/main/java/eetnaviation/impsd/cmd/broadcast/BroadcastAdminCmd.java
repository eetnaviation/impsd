package eetnaviation.impsd.cmd.broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastAdminCmd implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		if (p.hasPermission("impsd.admin.chat.broadcast.shout")) {
			String message = "";
			for (String part : args) {
			    if (message != "") message += " ";
			    message += part;
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(ChatColor.DARK_RED + "[SERVER NOTICE] " + ChatColor.RED + message);
			}
			return true;
		} else {
			p.sendMessage("You do not have permission to use that!");
		}
		
		return false;
	}
}