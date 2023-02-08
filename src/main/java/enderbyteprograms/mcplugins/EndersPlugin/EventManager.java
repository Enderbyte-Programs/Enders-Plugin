package enderbyteprograms.mcplugins.EndersPlugin;

import enderbyteprograms.mcplugins.EndersPlugin.Speed.PlayerSpeed;
import enderbyteprograms.mcplugins.EndersPlugin.blocklogsystem.BlockSystem;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;

import java.time.LocalDateTime;
import java.util.EventListener;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

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

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        //Move stuff
        Location prev = event.getFrom();
        Location to = event.getTo();
        double dist = to.distance(prev);
        if (dist == 0D) {
            return;
            //Improve performance
        }
        if (!PlayerSpeed.inlist(event.getPlayer())) {
            return;
        }
        event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText("Speed: "+Utilities.round(dist*20,1)+" m/s"));
    }
    @EventHandler
    public void onvmove(VehicleMoveEvent event) {
        List<Entity> le = event.getVehicle().getPassengers();
        double dist = event.getFrom().distance(event.getTo());
        for (Entity e:le) {
            if (e instanceof Player) {
                if (!PlayerSpeed.inlist((Player)e)) {
                    return;
                }
                ((Player)e).spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText("Speed: "+Utilities.round(dist*20,1)+" m/s"));
            }
        }

    }


    @EventHandler
    public void onPblock (BlockPlaceEvent p) {
        BlockSystem.incrementplaced(p.getPlayer().getDisplayName());
    }
    @EventHandler
    public void onbBlock (BlockBreakEvent p) {
        BlockSystem.incrementbroken(p.getPlayer().getDisplayName());
    }
}
