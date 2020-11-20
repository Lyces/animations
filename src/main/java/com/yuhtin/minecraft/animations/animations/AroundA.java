package com.yuhtin.minecraft.animations.animations;

import com.yuhtin.minecraft.animations.handler.Animation;
import com.yuhtin.minecraft.animations.handler.AnimationHandler;
import com.yuhtin.minecraft.animations.utils.MathUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

@AnimationHandler(
        name = "around:a",
        description = "Move armorstand around the starting location",
        state = AnimationHandler.AnimationVersion.RELEASE
)
public class AroundA extends Animation {

    @Override
    public void execute(Player player) {

        Location center = player.getLocation();
        float radius = 3;
        float radPerTick = 1.5f / 20f;

        ArmorStand stand = center.getWorld().spawn(center, ArmorStand.class);
        stand.setGravity(false);
        stand.setSmall(true);
        stand.setHelmet(new ItemStack(Material.STONE));
        stand.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        stand.setItemInHand(new ItemStack(Material.WOOD_PICKAXE));
        stand.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
        stand.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        hologramList.add(stand);

        runnableID = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            int tick = 0;

            @Override
            public void run() {
                ++tick;

                Location loc = MathUtils.getLocationAroundCircle(center, radius, radPerTick * tick);
                stand.setVelocity(new Vector(1, 0, 0));
                stand.teleport(loc);
            }
        }, 0, 1).getTaskId();

    }

    @Override
    public void stop() {
        hologramList.forEach(ArmorStand::remove);
        Bukkit.getScheduler().cancelTask(runnableID);
    }

}
