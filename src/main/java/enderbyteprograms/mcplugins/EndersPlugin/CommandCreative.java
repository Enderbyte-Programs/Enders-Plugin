package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.broadcastMessage;

public class CommandCreative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            p.setGameMode(GameMode.CREATIVE);
        } else {
            return false;
        }
        return true;
    }
}
