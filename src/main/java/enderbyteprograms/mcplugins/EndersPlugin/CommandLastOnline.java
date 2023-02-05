package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CommandLastOnline implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }
        int lookup = LastSeenSystem.lookupplayer(args[0]);
        if (lookup == -480) {
            sender.sendMessage(ChatColor.RED+"Could not find player in database");
        } else {
            PlayerData pd = LastSeenSystem.playerslist.get(lookup);
            if (Utilities.playeronline(pd.username)) {
                sender.sendMessage(ChatColor.GREEN+"Player is online"+ChatColor.RESET);
                sender.sendMessage("Logged in on: "+pd.LastLoginTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            } else {
                sender.sendMessage(ChatColor.YELLOW+"Player is not online");
                sender.sendMessage("Last seen: "+pd.lastLogoutTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            }

        }
        return true;
    }
}
