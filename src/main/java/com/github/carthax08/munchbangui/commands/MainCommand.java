package com.github.carthax08.munchbangui.commands;

import com.github.carthax08.munchbangui.Main;
import com.github.carthax08.munchbangui.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            // TODO: Command Handling and/or reloading.
            if(sender instanceof Player && checkPermissions(sender, "bangui.use")){
                Player player = (Player) sender;
                if(args.length == 0){
                    player.openInventory(Util.getBanGUI());
                }else command(player, args);
            }else {
                if (args.length == 0) {
                    //TODO: Open Punishment/Ban GUI
                    List<String> strings = Main.getInstance().getConfig().getStringList("messages.help");
                    for (String string : strings) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
                    }
                } else {
                    command(sender, args);
                }
            }


        return true;
    }

    private void command(CommandSender sender, String[] args) {
        if(args[1].equalsIgnoreCase("reload") && checkPermissions(sender, "bangui.reload")){
            Main.getInstance().reloadConfig();
        }else if(args[1].equalsIgnoreCase("help")){
            List<String> strings = Main.getInstance().getConfig().getStringList("messages.help");
            for(String string : strings){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
            }
        }
    }
    public static boolean checkPermissions(CommandSender sender, String mainPermission){
        return sender.hasPermission(mainPermission) || sender.hasPermission("bangui.*") || sender.isOp();
    }
}
