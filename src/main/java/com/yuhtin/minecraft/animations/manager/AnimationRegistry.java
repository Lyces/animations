package com.yuhtin.minecraft.animations.manager;

import com.yuhtin.minecraft.animations.Animations;
import com.yuhtin.minecraft.animations.handler.Animation;
import com.yuhtin.minecraft.animations.handler.AnimationHandler;

import java.util.Arrays;

public class AnimationRegistry {

    private AnimationRegistry() {
        throw new IllegalStateException("Utility class");
    }

    private static void registry(Class<? extends Animation> animationClass) {

        Animation animation;
        try {

            animation = animationClass.newInstance();

        } catch (InstantiationException | IllegalAccessException exception) {

            Animations.getInstance()
                    .getLogger()
                    .warning("Could not start class "
                            + animationClass.getName() +
                            " as an animation (no animation)");
            return;

        }

        if (!animation.getClass().isAnnotationPresent(AnimationHandler.class)) {

            Animations.getInstance()
                    .getLogger()
                    .warning("Could not start class "
                            + animationClass.getName() +
                            " as an animation (annotation not present)");
            return;

        }

        AnimationDAO.getCache().put(animation.getName(), animation);

        Animations.getInstance()
                .getLogger()
                .info("Registered " + animation.getName() + " animation " +
                        "(Total: " + AnimationDAO.getCache().size() + ")");

    }

    @SafeVarargs
    public static void registry(String plugin, Class<? extends Animation>... animations) {

        Animations.getInstance()
                .getLogger()
                .info("The "
                        + plugin +
                        " plugin is registering "
                        + animations.length +
                        " animations");

        Arrays.stream(animations).forEach(AnimationRegistry::registry);

    }

}
