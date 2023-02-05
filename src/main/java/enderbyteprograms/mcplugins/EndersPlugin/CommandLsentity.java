package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLsentity implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        World w = Bukkit.getWorld("old_server");
        List<Entity> le = w.getEntities();
        Double totalents = Double.parseDouble(String.valueOf(le.size()));
        HashMap<EntityType,Integer> entities = new HashMap<EntityType,Integer>();
        for (Entity e:le) {
            EntityType et = e.getType();
            if (!entities.containsKey(et)) {
                entities.put(et,1);
            } else {
                entities.put(et, entities.get(et) +1);
            }
        }
        sender.sendMessage("=====Entity Dump=====");
        for (Map.Entry<EntityType,Integer> entry : entities.entrySet()) {
            String outmsg = "";
            outmsg += entry.getKey().name();
            outmsg += " : ";
            outmsg += entry.getValue().toString();
            outmsg += " (";
            outmsg += String.valueOf(Utilities.round(Double.parseDouble(entry.getValue().toString())/totalents*Double.parseDouble("100"),1));
            outmsg += " %)";
            sender.sendMessage(outmsg);
        }
        return true;
    }
}
