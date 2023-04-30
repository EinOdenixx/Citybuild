package de.mineshine.citybuild.commands;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class EnchanterCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(CityBuild.getInstance().getConfig().getString("PERMISSION_Enchanter"))) {
                if (args.length == 0) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        player.openInventory(Bukkit.createInventory(null, InventoryType.ENCHANTING));

                        } else {
                        player.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /enchanter");
                        }
                    } else {
                    player.sendMessage(CityBuild.noPerms());
                }
            } else {
            sender.sendMessage("§cDu musst ein Spieler sein!");
        }
        return false;
    }
}
