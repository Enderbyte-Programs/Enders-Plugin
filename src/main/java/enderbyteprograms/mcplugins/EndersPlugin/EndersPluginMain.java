package enderbyteprograms.mcplugins.EndersPlugin;
import enderbyteprograms.mcplugins.EndersPlugin.Speed.CommandSpeedometer;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class EndersPluginMain extends JavaPlugin {
    @Override
    public void onEnable() {
        constants.ACTIVEWORLD = this.getServer().getWorlds();
        this.getCommand("kickeveryone").setExecutor(new CommandKickEveryone());
        this.getCommand("aliassay").setExecutor(new CommandAliasSay());
        this.getCommand("epplugindebug").setExecutor(new CommandDebug());
        this.getCommand("creative").setExecutor(new CommandCreative());
        this.getCommand("survival").setExecutor(new CommandSurvival());
        this.getCommand("minecartme").setExecutor(new CommandMinecartme());
        this.getCommand("smite").setExecutor(new CommandSmite());
        this.getCommand("lastseen").setExecutor(new CommandLastOnline());
        this.getCommand("lsentity").setExecutor(new CommandLsentity());
        this.getCommand("clearminecarts").setExecutor(new CommandClearMinecarts());
        this.getCommand("censor").setExecutor(new CommandCensor());
        this.getCommand("uncensor").setExecutor(new CommandUncensor());
        this.getCommand("speedometer").setExecutor(new CommandSpeedometer());
        this.getCommand("uncensor").setTabCompleter(new UncensorTabComplete());
        this.getCommand("epplugininfo").setExecutor(new Commandeplugininfo());
        getServer().getPluginManager().registerEvents(new EventManager(),this);
        File writefile = new File(getDataFolder() , "lastseen.txt");
        try {
            if (writefile.exists()) {
                List<String> nlist;
                try {
                    nlist = Files.readAllLines(writefile.toPath());
                } catch (IOException e) {
                    return;
                }
                for (String ndat : nlist) {
                    String[] md = ndat.split(" ");
                    LastSeenSystem.registerplayer(md[0]);
                    PlayerData old = LastSeenSystem.playerslist.get(LastSeenSystem.lookupplayer(md[0]));
                    if (!md[1].contains("<")) {
                        old.LastLoginTime = LocalDateTime.parse(md[1]);
                    }
                    if (!md[2].contains("<")) {
                        old.lastLogoutTime = LocalDateTime.parse(md[2]);
                    }
                }
            }
        } catch (Exception e) {
            writefile.delete();
        }
        writefile = new File(getDataFolder(),"censored.txt");

        try {
            if (writefile.exists()) {
                List<String> nlist;
                try {
                    nlist = Files.readAllLines(writefile.toPath());
                } catch (IOException e) {
                    return;
                }
                for (String ndat : nlist) {
                    CensorSystem.censored.add(ndat);
                }
            }
        } catch (Exception e) {
            writefile.delete();
        }

        getLogger().info("Hi Everybody!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Bye Bye Everybody!");
        String writedata = "";
        for (PlayerData p:LastSeenSystem.playerslist) {
            if (p.username.replace(" ","").equals("")) {
                getLogger().warning("Blank player found");
                continue;
            }
            writedata += p.toString();
            writedata += "\n";
        }
        File towritedir = getDataFolder();
        File writefile = new File(towritedir , "lastseen.txt");
        if (!towritedir.exists()) {
            towritedir.mkdir();
        }
        try
        {Files.write(writefile.toPath(), Arrays.stream(writedata.split("\n")).toList(), StandardCharsets.UTF_8);}
        catch (IOException e) {
            getLogger().warning("Failed to write player data file");
        }
        Path cwfile = new File(getDataFolder(),"censored.txt").toPath();

        try
        {Files.write(cwfile, CensorSystem.censored);}
        catch (IOException e) {
            getLogger().warning("Failed to write banned words file");
        }

    }
}
