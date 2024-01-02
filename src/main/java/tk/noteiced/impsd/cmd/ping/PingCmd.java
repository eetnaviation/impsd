package tk.noteiced.impsd.cmd.ping;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.noteiced.impsd.Impsd;

public class PingCmd implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("impsd.admin.core.ping")) {
            String message = "";
            for (String part : args) {
                if (message != "") message += " ";
                message += part;
            }
            p.sendMessage(ChatColor.GREEN + "Pong!");
            return true;
        } else {
            p.sendMessage("You do not have permission to use that!");
        }

        return false;
    }
}