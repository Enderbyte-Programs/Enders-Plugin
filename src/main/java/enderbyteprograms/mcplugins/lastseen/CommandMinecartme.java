package enderbyteprograms.mcplugins.lastseen;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandMinecartme implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            ItemStack is = new ItemStack(Material.MINECART);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(p.getDisplayName()+"'s Minecart");
            is.setItemMeta(im);
            p.getInventory().addItem(is);
            return true;
        } else {
            return false;
        }
    }
}
