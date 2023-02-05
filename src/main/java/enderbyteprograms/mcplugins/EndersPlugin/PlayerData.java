package enderbyteprograms.mcplugins.EndersPlugin;

import java.time.LocalDateTime;
import java.util.List;

public class PlayerData {
    public String username;
    public LocalDateTime LastLoginTime;
    public LocalDateTime lastLogoutTime;
    public PlayerData(String user) {
        username = user;
    }
    public void Load(LocalDateTime li,LocalDateTime lo) {
        LastLoginTime = li;
        lastLogoutTime = lo;
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
