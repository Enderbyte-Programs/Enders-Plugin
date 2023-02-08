package enderbyteprograms.mcplugins.EndersPlugin.Speed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpeedometer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if (PlayerSpeed.activespeed.contains(p.getDisplayName())) {
                PlayerSpeed.activespeed.remove(p.getDisplayName());
                p.sendMessage(ChatColor.GREEN+"Speedometer is hidden");
            } else {
                PlayerSpeed.activespeed.add(p.getDisplayName());
                p.sendMessage(ChatColor.GREEN+"Speedometer is shown");
            }
        } else {
            commandSender.sendMessage("Only players may execute this command");
            return false;
        }
        return true;

    }
}
