package com.itsundefined.blissgems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class Bliss implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0){
                Player target = Bukkit.getPlayer(args[0]);


            }
            ItemStack StrengthGemTier2 = new ItemStack(Material.PRISMARINE_SHARD,1);
            ItemMeta itemMeta = StrengthGemTier2.getItemMeta();
            itemMeta.setCustomModelData(10);
            p.getInventory().addItem(StrengthGemTier2);



        }

        return true;
    }
}



