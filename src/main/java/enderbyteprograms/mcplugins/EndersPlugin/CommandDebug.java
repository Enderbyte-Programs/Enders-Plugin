package enderbyteprograms.mcplugins.EndersPlugin;

import enderbyteprograms.mcplugins.EndersPlugin.Speed.PlayerSpeed;
import enderbyteprograms.mcplugins.EndersPlugin.blocklogsystem.BlockSystem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Map;

import static org.bukkit.Bukkit.broadcastMessage;

public class CommandDebug implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("=========Enderbyte09 Plugin Debug========");
        sender.sendMessage("Dumping data:");
        sender.sendMessage("=====PlayerList=====");
        for (int i = 0;i<LastSeenSystem.playerslist.size();i++) {
            PlayerData lk = LastSeenSystem.playerslist.get(i);
            sender.sendMessage(lk.toString());
        }
        sender.sendMessage("=====Banned Words=====");
        for (String c:CensorSystem.censored) {
            sender.sendMessage(c);
        }
        sender.sendMessage("=====Place record=====");
        for (Map.Entry< String,Integer> entry : BlockSystem.placed.entrySet()) {
            sender.sendMessage(entry.getKey()+" : "+entry.getValue().toString());
        }
        sender.sendMessage("=====Break record=====");
        for (Map.Entry< String,Integer> entry : BlockSystem.broken.entrySet()) {
            sender.sendMessage(entry.getKey()+" : "+entry.getValue().toString());
        }
        sender.sendMessage("=====Active Speedometers=====");
        for (String s: PlayerSpeed.activespeed) {
            sender.sendMessage(s);
        }
        return true;
    }
}