package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandUncensor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length < 1) {
            commandSender.sendMessage(ChatColor.RED+"Please provide a word to censor");
            return false;
        }
        if (args[0].replace(" ","").equals("")) {
            commandSender.sendMessage(ChatColor.RED+"String must not be empty");
            return false;
        }
        String message = args[0];
        if (args.length > 1) {
            message = String.join(" ",args);
        }
        if (!CensorSystem.censored.contains(message)) {
            commandSender.sendMessage(ChatColor.YELLOW+"This doesn't exist in the first place");
            return false;
        }
        CensorSystem.censored.remove(message);
        commandSender.sendMessage(ChatColor.GREEN+"Remove word from banned list");
        return true;
    }
}
