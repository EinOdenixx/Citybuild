package de.mineshine.citybuild.utils;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtils {

    private final FileConfiguration config;

    public ConfigUtils(FileConfiguration config) {
        this.config = config;
    }

    public void setIfNotExists(String path, String value) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
