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
import java.util.Collection;

public class Util {
    // TODO: Utility methods
    public static float pages = 0.0f;
    public static ArrayList<Inventory> pagesList = new ArrayList<>();
    public static int i = 0;

    public static Inventory getBanGUI() {
        return createGUIPages((Collection<Player>) Bukkit.getOnlinePlayers());
    }

    public static Inventory getSecondGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.RED + "Punishment?");
        for (String string : Main.getInstance().getConfig().getStringList("punishments")) {
        }
        return inv;
    }

    private static Inventory createGUIPages(Collection<Player> players) {
        int length = Bukkit.getOnlinePlayers().size();

        for(float f = 1f; i < (float) Math.ceil((float) length / 54); i++){
            Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.RED + "Punishment GUI");
            for (Player player : players) {
                if (i < 48 || i > 50 && i < 53) {
                    ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
                    SkullMeta meta = (SkullMeta) item.getItemMeta();
                    meta.setOwner(player.getName());
                    item.setItemMeta(meta);
                    inv.addItem(item);
                } else if (i == 48) {
                    ItemStack item = new ItemStack(Material.ARROW);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Down");
                    item.setItemMeta(meta);
                    inv.addItem(item);
                } else if (i == 49) {
                    ItemStack item = new ItemStack(Material.SLIME_BALL);
                    ItemMeta meta = item.getItemMeta();
                    pages = (float) Math.ceil((float) length / 54);
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page: " + i + "/" + pages);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    players.add(player);
                } else if (i == 50) {
                    ItemStack item = new ItemStack(Material.ARROW);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Up");
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    players.add(player);
                }
                pagesList.add(inv);
            }
            return pagesList.get(0);
        }
        return null;
    }
}
