package com.yuhtin.minecraft.animations.utils;

import org.bukkit.ChatColor;

public final class ColorUtils {

    public static String colored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private ColorUtils() { throw new IllegalStateException("Utility class"); }
}
