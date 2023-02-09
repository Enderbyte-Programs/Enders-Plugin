package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandeplugininfo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.AQUA + "Ender's Plugin Version "+constants.VERSION);
        commandSender.sendMessage(ChatColor.DARK_PURPLE + "By Enderbyte09 (c) 2023");
        commandSender.sendMessage(ChatColor.RED + "Subscribe to Enderbyte09 on Youtube");
        return true;
    }
}
