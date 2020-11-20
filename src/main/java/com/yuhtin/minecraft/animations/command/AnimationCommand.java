package com.yuhtin.minecraft.animations.command;

import com.yuhtin.minecraft.animations.handler.Animation;
import com.yuhtin.minecraft.animations.manager.AnimationDAO;
import com.yuhtin.minecraft.animations.utils.ColorUtils;
import com.yuhtin.minecraft.animations.utils.JSONText;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public final class AnimationCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        if (sender instanceof ConsoleCommandSender) return false;

        Player player = (Player) sender;
        if (!player.hasPermission("animation.command")) {
            player.sendMessage(ColorUtils.colored("&cYou dont have permission to use this command."));
            return false;
        }

        if (arguments.length < 1) {

            player.sendMessage(new String[]{

                    ColorUtils.colored("&cUse /" + label + " <animation>"),
                    ColorUtils.colored("&cValid animations: "
                            + Arrays.toString(AnimationDAO.getCache().keySet().toArray()))

            });

            return false;
        }

        String name = arguments[0];
        if (!AnimationDAO.getCache().containsKey(name)) {

            player.sendMessage(new String[]{

                    ColorUtils.colored("&cThis animation don't exists"),
                    ColorUtils.colored("&cValid animations: "
                            + Arrays.toString(AnimationDAO.getCache().keySet().toArray()))

            });

            return false;
        }

        Animation animation = AnimationDAO.getCache().get(name);
        if (arguments.length == 2) {
            if (arguments[1].equalsIgnoreCase("execute")) {
                player.sendMessage(ColorUtils.colored("&fRodando a animação &e" + animation.getName()));
                animation.execute(player);
                return true;
            }

            if (arguments[1].equalsIgnoreCase("stop")) {
                player.sendMessage(ColorUtils.colored("&fParando a animação &e" + animation.getName()));
                animation.stop();
                return true;
            }
        }

        player.sendMessage(new String[]{
                ColorUtils.colored("&eAnimation info:"),
                ColorUtils.colored("&fName: &a" + animation.getName()),
                ColorUtils.colored("&fDescription: &a" + animation.getDescription()),
                ColorUtils.colored("&fState: &a" + animation.getState())
        });

        new JSONText(ColorUtils.colored("&aClick &lHERE &ato execute this animation"))
                .hoverText(ColorUtils.colored("&eClick to execute animation"))
                .clickSuggest("/animation " + animation.getName() + " execute")
                .send(player);

        return true;
    }
}
