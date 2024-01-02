package eetnaviation.impsd;

import org.bukkit.plugin.java.JavaPlugin;
import eetnaviation.impsd.cmd.broadcast.BroadcastAdminCmd;
import eetnaviation.impsd.cmd.broadcast.BroadcastShoutCmd;
import eetnaviation.impsd.cmd.ping.PingCmd;

public final class Impsd extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Running command interpreter..");
        // Initialize commands
        this.getCommand("broadcast").setExecutor(new BroadcastAdminCmd());
        this.getCommand("shout").setExecutor(new BroadcastShoutCmd());
        this.getCommand("ping").setExecutor(new PingCmd());
        // Initialize config file
        saveDefaultConfig();
        saveConfig();
        reloadConfig();
        // Initialize config values

        // Plugin is now ready!
        getLogger().info("Plugin ready!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("IMPSD Core dependencies disabled! Goodbye.");
    }
}
