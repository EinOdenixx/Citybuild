package de.mineshine.citybuild.listener;

import de.mineshine.citybuild.CityBuild;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = CityBuild.getInstance().getConfig();

        event.setJoinMessage(CityBuild.getPrefix() + config.getString("joinMessage").replace("%player%", player.getName()).replace("&", "§"));
    }
}
