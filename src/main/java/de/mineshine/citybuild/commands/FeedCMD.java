package de.mineshine.citybuild.commands;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(CityBuild.getInstance().getConfig().getString("PERMISSION_Feed"))) {
                if(args.length == 0) {
                    if (player.getFoodLevel() == 20) {
                        player.sendMessage(CityBuild.getPrefix() + "§cDein Hunger ist bereits vollständig aufgefüllt.");
                    } else {
                        player.setFoodLevel(20);
                        player.sendMessage(CityBuild.getPrefix() + "§aDein Hunger wurde vollständig aufgefüllt.");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
                    }
                } else {
                    player.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /feed");
                }
            } else {
                player.sendMessage(CityBuild.noPerms());
            }
        } else {
            sender.sendMessage(CityBuild.getPrefix() + "§cNur Spieler können diesen Befehl ausführen.");
        }
        return true;
    }
}
