package enderbyteprograms.mcplugins.EndersPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.broadcastMessage;

public class CommandLastseen implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        broadcastMessage("Hi everybody! I'm doctor nick");

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
