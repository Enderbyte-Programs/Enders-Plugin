package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;

import static org.bukkit.Bukkit.broadcastMessage;

public class CommandClearMinecarts implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (World w:constants.ACTIVEWORLD) {
            List<Entity> le = w.getEntities();
            HashMap<String, Integer> entities = new HashMap<String, Integer>();
            Double ke = (double) 0;
            for (Entity e : le) {
                EntityType et = e.getType();
                if (et.equals(EntityType.MINECART) || et.equals(EntityType.MINECART_CHEST) || et.equals(EntityType.MINECART_TNT) || et.equals(EntityType.MINECART_MOB_SPAWNER)) {
                    e.remove();
                    ke++;
                }
            }
            broadcastMessage(ChatColor.AQUA+String.valueOf(ke) + " Minecarts were cleared ("+Utilities.round(ke/(double)le.size()*(double)100,1)+"%) from world "+w.getName());
        }

        return true;
    }
}
