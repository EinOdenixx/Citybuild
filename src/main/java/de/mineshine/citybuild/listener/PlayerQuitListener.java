package de.mineshine.citybuild.listener;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = CityBuild.getInstance().getConfig();

        event.setQuitMessage(CityBuild.getPrefix() + config.getString("quitMessage").replace("%player%", player.getName()).replace("&", "§"));
    }
}
