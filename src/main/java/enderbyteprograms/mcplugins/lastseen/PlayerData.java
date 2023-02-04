package enderbyteprograms.mcplugins.lastseen;

import java.time.LocalDateTime;
import java.util.List;

public class PlayerData {
    public String username;
    public LocalDateTime LastLoginTime;
    public LocalDateTime lastLogoutTime;
    public List<LocalDateTime> logins;
    public List<LocalDateTime> logoffs;
    public PlayerData(String user) {
        username = user;
    }
    public void Load(List<LocalDateTime> li,List<LocalDateTime> lo) {
        logins = li;
        logoffs = lo;
        LastLoginTime = li.get(li.size()-1);
        lastLogoutTime = lo.get(lo.size()-1);
    }
    @Override
    public String toString() {
        String msg = username+" ";
        if (LastLoginTime == null) {
            msg += "<no logins>";
        } else {
            msg += LastLoginTime.toString();
        }
        msg += " ";
        if (lastLogoutTime == null) {
            msg += "<no logouts>";
        } else {
            msg += lastLogoutTime.toString();
        }

        return msg;
    }
}
