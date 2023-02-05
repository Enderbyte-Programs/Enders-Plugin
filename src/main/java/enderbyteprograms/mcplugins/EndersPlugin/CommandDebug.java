package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
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

        return true;
    }
}