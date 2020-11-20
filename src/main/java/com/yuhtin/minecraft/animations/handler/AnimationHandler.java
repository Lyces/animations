package com.yuhtin.minecraft.animations.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
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
