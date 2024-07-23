package com.itsundefined.blissgems;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Events implements Listener {

    public void invclick(InventoryClickEvent event) {
        Strength.StrengthInv(event);
    }

}
