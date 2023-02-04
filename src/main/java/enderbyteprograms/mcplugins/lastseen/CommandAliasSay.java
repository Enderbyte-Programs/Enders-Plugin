package enderbyteprograms.mcplugins.lastseen;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import static org.bukkit.Bukkit.broadcastMessage;

public class CommandAliasSay implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            if (sender instanceof Player) {
                Player p = (Player)sender;
                p.sendMessage("Please provide alias user and message.");
            }
            return false;
        }
        String[] margs = Arrays.copyOfRange(args,1,args.length);
        String msg = "<"+args[0]+"> "+String.join(" ",margs);
        broadcastMessage(msg);
        return true;
    }
}
