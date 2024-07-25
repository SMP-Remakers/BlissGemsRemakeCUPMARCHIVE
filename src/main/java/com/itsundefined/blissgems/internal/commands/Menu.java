package com.itsundefined.blissgems.internal.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.awt.*;
public class Menu implements Listener{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals((net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "Menu"))){
            return;
        }

        event.setCancelled(true);

        if(event.getCurrentItem() == null){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        Player target = Bukkit.getPlayer(event.getView().getItem(12).getItemMeta().getDisplayName());
        if(target == null){
            player.closeInventory();
            return;
        }

        if(event.getCurrentItem().getType() == Material.PRISMARINE_SHARD){
            target.setHealth(20);
            player.closeInventory();
        } else if (event.getCurrentItem().getType() == Material.ALLAY_SPAWN_EGG){
            target.setHealth(0);
        }

    }
}


