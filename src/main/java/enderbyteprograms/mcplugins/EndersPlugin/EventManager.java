package enderbyteprograms.mcplugins.EndersPlugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;

import java.time.LocalDateTime;
import java.util.EventListener;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.broadcastMessage;

public class EventManager implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.sendMessage("Welcome to Enderbyte09's Server, " + p.getDisplayName() + "!");
        if (LastSeenSystem.lookupplayer(p.getDisplayName())==-480) {
            //Not found in database
            LastSeenSystem.registerplayer(p.getDisplayName());

        }
        PlayerData olddata = LastSeenSystem.playerslist.get(LastSeenSystem.lookupplayer(p.getDisplayName()));
        olddata.LastLoginTime = LocalDateTime.now();
        LastSeenSystem.UpdatePlayer(olddata);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        if (LastSeenSystem.lookupplayer(p.getDisplayName())==-480) {
            //Not found in database
            LastSeenSystem.registerplayer(p.getDisplayName());
        }
        PlayerData olddata = LastSeenSystem.playerslist.get(LastSeenSystem.lookupplayer(p.getDisplayName()));
        olddata.lastLogoutTime = LocalDateTime.now();
        LastSeenSystem.UpdatePlayer(olddata);

    }
    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
        broadcastMessage(event.getPlayer().getDisplayName()+" is sleeping");

    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        //Censor naughty words
        if (!CensorSystem.allowed(event.getMessage())) {
            //Contains bad word
            broadcastMessage(ChatColor.RED+event.getPlayer().getDisplayName()+" said a naughty word!");
            event.setCancelled(true);
        }
    }
}
