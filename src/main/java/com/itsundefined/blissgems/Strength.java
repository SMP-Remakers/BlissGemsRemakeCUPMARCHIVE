package com.itsundefined.blissgems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class Strength{

    public static void StrengthInv(InventoryClickEvent InventoryClickPlayer) {
     Inventory BlissGemsPlayer = InventoryClickPlayer.getClickedInventory();
     if (InventoryClickPlayer instanceof  Player) {
         InventoryClickPlayer.setCancelled(true);
     }
    }
}
