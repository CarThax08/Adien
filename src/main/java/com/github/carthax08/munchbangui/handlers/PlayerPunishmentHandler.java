package com.github.carthax08.munchbangui.handlers;

import com.github.carthax08.munchbangui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerPunishmentHandler {
    public static void banPlayer(Player playerToBan, Player banningPlayer){
        Bukkit.getServer().dispatchCommand(banningPlayer, "ban " + playerToBan.getName());
        banningPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.success_punishment_message").replace("{OPERATION}", "banned").replace("{RECIEVER}", playerToBan.getName())));
    }
}
