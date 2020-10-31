package Command;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Enderchest implements CommandExecutor{
	
	public static ArrayList<UUID> enderchest = new ArrayList<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du musst ein Spiele sein!");
			return true;
		}
		
		Player p = (Player)sender;
		if(!PermissionsEx.getUser(p).inGroup("Mitglied")) {
			p.sendMessage("Keine Rechte");
			return true;
		}
		
		if(args.length == 0) {
			p.openInventory(p.getEnderChest());
		}
		
		else if(args.length == 1) {
			if(!PermissionsEx.getUser(p).inGroup("Owner")) {
				p.sendMessage("Keine Rechte!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				p.sendMessage("Dieser Spieler ist nicht online!");
				return true;
			}
			p.openInventory(target.getEnderChest());
			p.sendMessage("Du schaust nun in die Enderchest von" + target.getName() + "!");
			enderchest.contains(p.getUniqueId());
		} else {
			p.sendMessage("Verwendung: " + label + "<Spieler>");
		}
		return false;
		
		
	}

}
