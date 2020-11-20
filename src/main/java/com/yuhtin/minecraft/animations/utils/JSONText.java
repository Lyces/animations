package com.yuhtin.minecraft.animations.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JSONText {
    private final TextComponent textComponent;

    public JSONText() {
        textComponent = new TextComponent("");
    }

    public JSONText(String prefix) {
        textComponent = new TextComponent(TextComponent.fromLegacyText(prefix));
    }

    public JSONText hoverText(String text) {
        BaseComponent[] hover = {new TextComponent(text)};
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover));
        return this;
    }

    public JSONText clickOpenURL(String url) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, (url.startsWith("http") ? "" : "https://") + url));
        return this;
    }

    public JSONText clickRunCommand(String command) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        return this;
    }

    public JSONText clickSuggest(String suggest) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, suggest));
        return this;
    }

    public void send(Player player) {
        player.spigot().sendMessage(textComponent);
    }

    public void send(CommandSender sender) {
        sender.sendMessage(textComponent.getText());
    }

    public void sendEveryOne() {
        for (Player everyone : Bukkit.getOnlinePlayers()) {
            everyone.spigot().sendMessage(textComponent);
        }
    }

}
