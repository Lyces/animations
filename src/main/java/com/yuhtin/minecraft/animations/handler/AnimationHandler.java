package com.yuhtin.minecraft.animations.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

public @interface AnimationHandler {

    String name();
    String description();
    AnimationVersion state();

    @AllArgsConstructor
    enum AnimationVersion {

        RELEASE("Release"),
        BETA("Beta"),
        SNAPSHOT("Snapshot");

        @Getter private final String name;

    }
}
