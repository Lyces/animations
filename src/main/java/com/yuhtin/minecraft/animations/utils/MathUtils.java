package com.yuhtin.minecraft.animations.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Location setCenterLocation(Location location) {
        location.setX(location.getBlockX() + 0.5);
        location.setZ(location.getBlockZ() + 0.5);

        return location;
    }

    public static Location getLocationAroundCircle(Location center, double radius, double angleInRadian) {
        double x = center.getX() + radius * Math.cos(angleInRadian);
        double z = center.getZ() + radius * Math.sin(angleInRadian);
        double y = center.getY();

        Location location = new Location(center.getWorld(), x, y, z);
        Vector difference = center.toVector().clone().subtract(location.toVector());
        location.setDirection(difference);

        return location;
    }
}
