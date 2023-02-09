# Enders-Plugin
A bukkit plugin filled with random utilities you didn't know you wanted

## Commands List

### Debug and Info
/epplugindebug : Prints out debug information including lastseen data, banned words | Permission: endersplugin.admin


/epplugininfo : Print out plugin information | Permission: endersplugin.basic

### Administration
/kickeveryone <reason, spaces allowed> : Kick everybody, including you from the server with Reason. Good for restarts and testing | Permission: endersplugin.admin

/censor <Word, spaces allowed> : Censor a word on the server (ban in chat) | Permission: endersplugin.admin

/uncensor <Word, spaces allowed> : Uncensor a word form the banned list | Permission: endersplugin.admin

/clearminecarts : Clear all minecarts from server | Permission: endersplugin.extended


/lsentity : List entity counts on server | Permission: endersplugin.utility

### Funny

/smite <Player> : smites a player with a lightning bolt | Permission: endersplugin.extended
/aliassay <Sayer> <Message, spaces allowed> : Pretend to send a message from <Sayer> containing <Message> | Permission: endersplugin.aliassay
  

### Utility
  
/speedometer : Toggles a speedometer that displays a player's speed | Permission: endersplugin.basic
  
/minecartme : Give a Minecart with your name on it! | Permission: endersplugin.utility
  
/creative : Set own gamemode to creative (Meant to be used as safe alternative to /gamemode) | Permission: endersplugin.gamemode
  
/survival : Set own gamemode to survival | Permission: endersplugin.gamemode
  
/lastseen <Player> : When was <player> last online? | Permission: endersplugin.utility


## Permissions List
endersplugin.basic : Basic functionality, best for vanilla survival
  
endersplugin.utility : Access to utility commands to make Minecraft more fun
  
endersplugin.extnded : Access to more destructive commands but not yet admin
  
endersplugin.admin : Access to administrative tools
