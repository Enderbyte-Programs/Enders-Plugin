package enderbyteprograms.mcplugins.lastseen;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class LastSeenSystem {
    public static List<PlayerData> playerslist = new ArrayList<PlayerData>();
    public static void registerplayer(String username) {
        PlayerData p = new PlayerData(username);
        playerslist.add(p);
    }
    public static int lookupplayer(String username) {
        //Return a playerdata index based on username. Returns -480 if not found.
        for (int i = 0;i < playerslist.size();i++) {
            PlayerData pd = playerslist.get(i);
            //getLogger().info(pd.username);
            //getLogger().info(username);
            if (pd.username.strip().equals(username.strip())) {
                return i;
            }
        }
        return -480;
    }
    public static void UpdatePlayer(PlayerData newdata) {
        playerslist.remove(lookupplayer(newdata.username));
        playerslist.add(newdata);
    }
}
