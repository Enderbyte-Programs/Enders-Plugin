package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.broadcastMessage;
import static org.bukkit.Bukkit.getPlayer;

public class CommandSmite implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }
        if (sender instanceof Player) {
            Player ps = (Player)sender;
            Player p = getPlayer(args[0]);
            p.setGameMode(GameMode.SURVIVAL);
            World w = p.getWorld();
            w.spawnEntity(p.getLocation(), EntityType.LIGHTNING);
            p.setHealth(0D);
            broadcastMessage(p.getDisplayName() + " was smote by "+ps.getDisplayName());
        } else {
            Player p = getPlayer(args[0]);
            p.setGameMode(GameMode.SURVIVAL);
            World w = p.getWorld();
            w.spawnEntity(p.getLocation(), EntityType.LIGHTNING);
            p.setHealth(0D);
            broadcastMessage(p.getDisplayName() + " was smote by SERVER");
        }
        return true;
    }
}
