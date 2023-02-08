package enderbyteprograms.mcplugins.EndersPlugin.Speed;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerSpeed {
    public static List<String> activespeed = new ArrayList<String>();
    public static boolean inlist(Player p) {
        return activespeed.contains(p.getDisplayName());
    }
}
