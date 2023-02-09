package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKickEveryone implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String msg;
        if (args.length == 0) {
            msg = "You have been kicked";
        } else {
            msg = String.join(" ",args);
        }
        for (Player p: Bukkit.getOnlinePlayers()) {
            p.kickPlayer(msg);
        }
        return true;
    }
}
