package de.mineshine.citybuild;

import de.mineshine.citybuild.commands.*;
import de.mineshine.citybuild.listener.PlayerJoinListener;
import de.mineshine.citybuild.listener.PlayerQuitListener;
import de.mineshine.citybuild.utils.ConfigUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CityBuild extends JavaPlugin {

    private static CityBuild instance;

    @Override
    public void onEnable() {
        instance = this;
        FileConfiguration config = getConfig();
        ConfigUtils configUtils = new ConfigUtils(config);

        configUtils.setIfNotExists("prefix", "&7[&3CityBuild&7]");
        configUtils.setIfNotExists("noPerms", "&cDafür hast du keine Rechte.");
        configUtils.setIfNotExists("joinMessage", "&a%player% ist gejoint.");
        configUtils.setIfNotExists("quitMessage", "&c%player% ist geleavt.");
        configUtils.setIfNotExists("PERMISSION_GameMode", "gamemode.use");
        configUtils.setIfNotExists("PERMISSION_Repair", "repair.use");
        configUtils.setIfNotExists("PERMISSION_Feed", "feed.use");
        configUtils.setIfNotExists("PERMISSION_Anvil", "anvil.use");
        configUtils.setIfNotExists("PERMISSION_Workbench", "workbench.use");
        configUtils.setIfNotExists("PERMISSION_Enchanter", "enchanter.use");
        configUtils.setIfNotExists("PERMISSION_Trash", "trash.use");

        getCommand("gamemode").setExecutor(new GameModeCMD());
        getCommand("repair").setExecutor(new RepairCMD());
        getCommand("feed").setExecutor(new FeedCMD());
        getCommand("anvil").setExecutor(new AnvilCMD());
        getCommand("workbench").setExecutor(new WorkbenchCMD());
        getCommand("enchanter").setExecutor(new EnchanterCMD());
        getCommand("trash").setExecutor(new TrashCMD());

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);

        saveConfig();
    }

    public static String getPrefix() {
        return getInstance().getConfig().getString("prefix").replace("&", "§") + " ";
    }

    public static String noPerms() {
        return CityBuild.getPrefix() + CityBuild.getInstance().getConfig().getString("noPerms").replace("&", "§");
    }

    public static CityBuild getInstance() {
        return instance;
    }
}
