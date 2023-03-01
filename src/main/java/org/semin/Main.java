package org.semin;

import org.bukkit.plugin.java.JavaPlugin;

import static org.semin.BongCommand.register;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Bong is activated.");

        register();

        this.getServer().getPluginManager()
                .registerEvents(new BongEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Bong is deactivated.");
    }
}