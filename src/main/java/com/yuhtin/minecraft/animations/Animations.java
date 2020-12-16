package com.yuhtin.minecraft.animations;

import com.yuhtin.minecraft.animations.animations.AroundA;
import com.yuhtin.minecraft.animations.animations.ExampleA;
import com.yuhtin.minecraft.animations.command.AnimationCommand;
import com.yuhtin.minecraft.animations.manager.AnimationDAO;
import com.yuhtin.minecraft.animations.manager.AnimationRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class Animations extends JavaPlugin {

    public static Animations getInstance() {
        return JavaPlugin.getPlugin(Animations.class);
    }


    @Override
    public void onEnable() {

        getLogger().info("Starting plugin");

        AnimationRegistry.registry(this.getName(), AroundA.class, ExampleA.class);
        getLogger().info("All native animations were recorded");

        getCommand("animations").setExecutor(new AnimationCommand());
        getLogger().info("Command registered");

        getLogger().info("Plugin startup successfully");

    }

    @Override
    public void onDisable() {
        AnimationDAO.getCache().forEach((name, animation) -> animation.stop());
        getLogger().info("Cancelled all animations");
    }
}
