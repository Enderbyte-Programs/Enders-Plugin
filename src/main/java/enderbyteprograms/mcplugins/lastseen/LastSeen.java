package enderbyteprograms.mcplugins.lastseen;

import org.bukkit.plugin.java.JavaPlugin;

public class LastSeen extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("kickeveryone").setExecutor(new CommandKickEveryone());
        this.getCommand("aliassay").setExecutor(new CommandAliasSay());
        this.getCommand("epplugindebug").setExecutor(new CommandDebug());
        this.getCommand("creative").setExecutor(new CommandCreative());
        this.getCommand("survival").setExecutor(new CommandSurvival());
        this.getCommand("minecartme").setExecutor(new CommandMinecartme());
        getServer().getPluginManager().registerEvents(new EventManager(),this);
        getLogger().info("LastSeen Plugin v0.2.2 (c) 2023 Enderbyte Prorgams");
    }
    @Override
    public void onDisable() {
        getLogger().info("Shutting Down LastSeen");
    }
}
