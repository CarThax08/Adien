package com.github.carthax08.munchbangui;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private String prefix = "";
    public static Main instance;

    @Override
    public void onEnable() {
        // TODO: Initialize Commands and Events.
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix"));
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance(){
        return instance;
    }
}
