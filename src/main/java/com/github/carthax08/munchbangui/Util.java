package com.github.carthax08.munchbangui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Util {
    // TODO: Utility methods
    public static float pages = 0.0f;
    public static ArrayList<Inventory> pagesList = new ArrayList<>();
    public static Inventory getBanGUI(){
        int i = 0;
        int length = Bukkit.getOnlinePlayers().size();
        Inventory inv = Bukkit.createInventory(null, 9*6, ChatColor.RED + "Punishment GUI");
        for(Player player : Bukkit.getOnlinePlayers()){
            if(i < 44 || i > 46) {
                ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
                SkullMeta meta = (SkullMeta) item.getItemMeta();
                meta.setOwner(player.getName());
                item.setItemMeta(meta);
                inv.addItem(item);
                i++;
            }else if(i == 44){
                ItemStack item = new ItemStack(Material.ARROW);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Down");
                item.setItemMeta(meta);
                inv.addItem(item);
            }else if(i == 45){
                ItemStack item = new ItemStack(Material.SLIME_BALL);
                ItemMeta meta = item.getItemMeta();
                pages = (float) Math.ceil((float)length/54);
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pages: " + pages);
                item.setItemMeta(meta);
                inv.addItem(item);
            }else {
                ItemStack item = new ItemStack(Material.ARROW);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Up");
                item.setItemMeta(meta);
                inv.addItem(item);
            }
        }
        return inv;
    }
    public static Inventory getSecondGUI(){
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.RED + "Punishment Type?");






        return inv;
    }



}
