package com.yuhtin.minecraft.animations.animations;

import com.yuhtin.minecraft.animations.handler.Animation;
import com.yuhtin.minecraft.animations.handler.AnimationHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

@AnimationHandler(
        name = "test:a",
        description = "A test animation",
        state = AnimationHandler.AnimationVersion.BETA
)
public class ExampleA extends Animation {

    @Override
    public void execute(Player player) {
        player.sendMessage("Hello");
    }

    @Override
    public void stop() {
        hologramList.forEach(ArmorStand::remove);
        Bukkit.getScheduler().cancelTask(runnableID);
    }
}
