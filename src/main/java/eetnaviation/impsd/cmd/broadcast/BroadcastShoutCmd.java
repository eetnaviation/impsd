package eetnaviation.impsd.cmd.broadcast;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.lang.String;

public class BroadcastShoutCmd implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (p.hasPermission("impsd.chat.broadcast.shout")) {
			String message = "";
			for (String part : args) {
			    if (message != "") message += " ";
			    message += part;
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(ChatColor.GOLD +"[SHOUT] " + ChatColor.YELLOW + message);
			}
			return true;
		} else {
			p.sendMessage("You do not have permission to use that!");
		}
		
		return false;
	}
}