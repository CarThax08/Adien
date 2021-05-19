package com.github.carthax08.munchbangui.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.SkullMeta;

public class GuiClickEvent implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e){
        if(e.getClickedInventory().getTitle().equals(ChatColor.RED + "Punishment GUI")){
            if(e.getCurrentItem().getType().equals(Material.SKULL_ITEM)){
                SkullMeta meta = (SkullMeta) e.getCurrentItem().getItemMeta();
                Player player = Bukkit.getPlayer(meta.getOwner());
            }
            e.setCancelled(true);
        }
    }



}