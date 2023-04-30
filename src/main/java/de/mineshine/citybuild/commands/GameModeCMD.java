package de.mineshine.citybuild.commands;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameModeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, String label, String[] args) {

        if(sender.hasPermission(CityBuild.getInstance().getConfig().getString("PERMISSION_GameMode"))) {
            if (args.length == 1 || args.length == 2) {

                if (sender instanceof Player) {

                    Player targetPlayer;
                    if (args.length == 2) {
                        targetPlayer = Bukkit.getPlayer(args[1]);
                        if (targetPlayer == null) {
                            sender.sendMessage(CityBuild.getPrefix() + "§cDer Spieler " + args[1] + " ist nicht online.");
                            return true;
                        }
                    } else {
                        targetPlayer = (Player) sender;
                    }
                    try {
                        int gameMode = Integer.parseInt(args[0]);
                        switch (gameMode) {
                            case 0:
                                targetPlayer.setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage(CityBuild.getPrefix() + "§aDer Spielmodus von §2" + targetPlayer.getName() + " §awurde zu Survival geändert.");

                                break;
                            case 1:
                                targetPlayer.setGameMode(GameMode.CREATIVE);
                                sender.sendMessage(CityBuild.getPrefix() + "§aDer Spielmodus von §2" + targetPlayer.getName() + " §awurde zu Creative geändert.");
                                break;
                            case 2:
                                targetPlayer.setGameMode(GameMode.ADVENTURE);
                                sender.sendMessage(CityBuild.getPrefix() + "§aDer Spielmodus von §2" + targetPlayer.getName() + " §awurde zu Adventure geändert.");
                                break;
                            case 3:
                                targetPlayer.setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage(CityBuild.getPrefix() + "§aDer Spielmodus von §2" + targetPlayer.getName() + " §awurde zu Spectator geändert.");
                                break;
                            default:
                                sender.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /gamemode <0/1/2/3> [Spielername]");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Das Argument ist keine Zahl
                        sender.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /gamemode <0/1/2/3> [Spielername]");
                    }
                } else {
                    sender.sendMessage(CityBuild.getPrefix() + "§cNur Spieler können diesen Befehl ausführen.");
                }
                return true;
            } else {
                sender.sendMessage(CityBuild.getPrefix() + "§cBitte nutze /gamemode <0/1/2/3> [Spielername]");
            }
        } else {
            sender.sendMessage(CityBuild.noPerms());
        }

        return false;
    }
}
