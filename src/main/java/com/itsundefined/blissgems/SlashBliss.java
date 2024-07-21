package com.itsundefined.blissgems;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.Buffer;
import java.sql.ParameterMetaData;
import java.util.ArrayList;
import java.util.List;

public class SlashBliss implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1){
            List<String> gem = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (int i = 0; i < players.length; i++){
                gem.add("givegem");
                gem.add("particles");
                gem.add("setenergy");
                gem.add("withdraw");
                gem.add("item");
            }
            return gem;
        } else if (args.length == 2) {
            List<String> gems = new ArrayList<>();
            gems.add("Strength");
            gems.add("Speed");
            gems.add("Life");
            gems.add("Wealth");
            gems.add("Puff");
            gems.add("Astra");
            gems.add("Fire");
            gems.add("Flux");
            return gems;
        } else if (args.length == 3){
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray();
            for (int i = 0; i < players.length; i++){
                playerNames.add(players[i].getName());
            }
            return playerNames;
        }

        return null;
    }
}

