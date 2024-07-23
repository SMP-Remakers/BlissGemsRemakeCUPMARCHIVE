package com.itsundefined.blissgems.commands;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class SlashBliss implements TabCompleter, CommandExecutor{
    private final HashMap<UUID, Integer> BlissEnergyGemHealth = new HashMap<>();
    private NamespacedKey ChadStrengthParticleCase1;
    private NamespacedKey ChadStrengthParticleCase2;
    private NamespacedKey ChadStrengthParticleCase3;
    private NamespacedKey ChadStrengthParticleCase4;
    private NamespacedKey BlissParticlesLess;
    private NamespacedKey BlissParticlesDefault;

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        BlissParticlesLess = new NamespacedKey("BlissGems", "BlissParticleLevel.2");
        BlissParticlesDefault = new NamespacedKey("BlissGems", "BlissParticleLevel.3");
        ChadStrengthParticleCase4 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.4");
        ChadStrengthParticleCase3 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.3");
        ChadStrengthParticleCase2 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.2");
        ChadStrengthParticleCase1 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.1");
        
        sender.sendMessage("ello");
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

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("BlissGems command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        UUID killerUUID = player.getUniqueId();
        int currentScore = BlissEnergyGemHealth.getOrDefault(killerUUID, 0);
        if (args.length == 2 && args[0].equalsIgnoreCase("particles") && args[1].equalsIgnoreCase("default")) {
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "\uD83D\uDD2E " + ChatColor.GREEN + "Performance Level changed to " + ChatColor.YELLOW + "DEFAULT");
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(BlissParticlesDefault, PersistentDataType.INTEGER, 1);
            data.remove(BlissParticlesLess);
            return true;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("particles") && args[1].equalsIgnoreCase("less")) {
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "\uD83D\uDD2E " + ChatColor.GREEN + "Performance Level changed to " + ChatColor.YELLOW + "LESS");
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(BlissParticlesLess, PersistentDataType.INTEGER, 1);
            data.remove(BlissParticlesDefault);
            return true;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("particles") && args[1].equalsIgnoreCase("none")) {
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "\uD83D\uDD2E " + ChatColor.GREEN + "Performance Level changed to " + ChatColor.YELLOW + "NONE");
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.remove(BlissParticlesLess);
            data.remove(BlissParticlesDefault);
            return true;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("0")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 0;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("1")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 3;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("2")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 6;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("3")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 9;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("4")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 12;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("5")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 15;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("6")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 18;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("7")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 21;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("8")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 24;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("9")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 27;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("10")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 30;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("setenergy") && args[1].equalsIgnoreCase("11")) {
            UUID GemHealthUUID = player.getUniqueId();
            int newScore = 33;
            BlissEnergyGemHealth.put(GemHealthUUID, newScore);
            player.sendMessage(ChatColor.GREEN + "Your new score is: " + newScore);
        }


        if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Strength") && args[2].equalsIgnoreCase("1")) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(ChadStrengthParticleCase3, PersistentDataType.INTEGER, 1);
            data.remove(ChadStrengthParticleCase1);
            data.remove(ChadStrengthParticleCase2);
            data.remove(ChadStrengthParticleCase4);
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have given " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + player.getName() + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + " sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have received " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Speed") && args[2].equalsIgnoreCase("1")) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(ChadStrengthParticleCase2, PersistentDataType.INTEGER, 1);
            data.remove(ChadStrengthParticleCase1);
            data.remove(ChadStrengthParticleCase3);
            data.remove(ChadStrengthParticleCase4);
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have given " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + player.getName() + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + " sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have received " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Life") && args[2].equalsIgnoreCase("1")) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(ChadStrengthParticleCase1, PersistentDataType.INTEGER, 1);
            data.remove(ChadStrengthParticleCase2);
            data.remove(ChadStrengthParticleCase3);
            data.remove(ChadStrengthParticleCase4);

            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have given " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + player.getName() + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + " ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have received " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");

        }
        if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Wealth") && args[2].equalsIgnoreCase("1")) {
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have given " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + player.getName() + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + " ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have received " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Puff") && args[2].equalsIgnoreCase("1")) {
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have given " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + player.getName() + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + ChatColor.BOLD + " ᴘᴜғғ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have received " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + ChatColor.BOLD + "ᴘᴜғғ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem " + ChatColor.GRAY + "Tier " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "1");
        }


        //player.sendMessage("You don't have permission to do "BlissGems"");
        return true;
    }
}


