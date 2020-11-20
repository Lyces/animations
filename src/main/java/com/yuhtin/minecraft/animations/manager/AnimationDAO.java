package com.yuhtin.minecraft.animations.manager;

import com.yuhtin.minecraft.animations.handler.Animation;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class AnimationDAO {

    @Getter private static final Map<String, Animation> cache = new HashMap<>();

    private AnimationDAO() {
        throw new IllegalStateException("Utility class");
    }
}
