package com.yuhtin.minecraft.animations.handler;

import lombok.Data;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Data
public abstract class Animation {

    private String name;
    private String description;
    private AnimationHandler.AnimationVersion state;
    private boolean running;

    public final Set<ArmorStand> hologramList = new HashSet<>();
    public int runnableID;

    public Animation() {
        if (this.getClass().isAnnotationPresent(AnimationHandler.class)) {

            AnimationHandler handler = this.getClass().getAnnotation(AnimationHandler.class);

            this.name = handler.name();
            this.description = handler.description();
            this.state = handler.state();

        }
    }

    public abstract void execute(Player player);
    public abstract void stop();
}
