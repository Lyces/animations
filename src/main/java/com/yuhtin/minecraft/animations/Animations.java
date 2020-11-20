package com.yuhtin.minecraft.animations;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Animations extends JavaPlugin {

    @Getter private static Animations instance;

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("Starting plugin");




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
