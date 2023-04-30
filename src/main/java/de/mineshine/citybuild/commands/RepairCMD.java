package de.mineshine.citybuild.commands;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class RepairCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(CityBuild.getInstance().getConfig().getString("PERMISSION_Repair"))) {
                if(args.length == 0) {
                    ItemStack item = player.getInventory().getItemInMainHand();
                    if (item.getType().getMaxDurability() > 0 && item.getDurability() > 0) {
                        item.setDurability((short) 0);
                        player.sendMessage(CityBuild.getPrefix() + "§aDer Gegenstand in deiner Hand wurde repariert.");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    } else {
                        player.sendMessage(CityBuild.getPrefix() + "§cDieser Gegenstand kann nicht repariert werden.");
                    }
                } else {
                    player.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /repair");
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
