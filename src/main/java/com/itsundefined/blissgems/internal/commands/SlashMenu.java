package com.itsundefined.blissgems.internal.commands;



import org.bukkit.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


import java.awt.Color;
import java.util.Arrays;
import java.util.Optional;


public class SlashMenu implements CommandExecutor,Listener {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage("hi");

            Inventory inventory = Bukkit.createInventory(null, 45, net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "" + ChatColor.BOLD + "Menu");
            ItemStack GameModeItemCreative = new ItemStack(Material.ALLAY_SPAWN_EGG, 1);
            ItemStack GameModeItemSurvival = new ItemStack(Material.SLIME_SPAWN_EGG, 1);
            ItemStack MainBlissItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack GemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemStack BlissSeason2 = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemStack NetherItem = new ItemStack(Material.NETHERRACK, 1);
            ItemStack OverWorldItem = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemStack EndItem = new ItemStack(Material.END_STONE, 1);
            ItemStack KitsItem = new ItemStack(Material.NETHERITE_SWORD, 1);
            ItemStack RandomTPItem = new ItemStack(Material.SPRUCE_SAPLING, 1);
            ItemStack EnergyItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta KitsItemMeta = KitsItem.getItemMeta();
            KitsItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 59, 59)) + "" + ChatColor.BOLD + "Kits");
            KitsItem.setItemMeta(KitsItemMeta);
            ItemMeta BlissSeason2Meta = BlissSeason2.getItemMeta();
            BlissSeason2Meta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(250, 250, 55)) + "" + ChatColor.BOLD + "Bliss Season 2 World");
            BlissSeason2Meta.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "teleports you to the bliss",
                    ChatColor.AQUA + "s2 world"
            ));
            BlissSeason2Meta.setCustomModelData(2);
            BlissSeason2.setItemMeta(BlissSeason2Meta);
            ItemMeta GemItemMeta = GemItem.getItemMeta();
            GemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "" + ChatColor.BOLD + "Gems");
            GemItemMeta.setCustomModelData(4);
            GemItem.setItemMeta(GemItemMeta);
            ItemMeta TheEnd = EndItem.getItemMeta();
            TheEnd.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(226, 209, 167)) + "" + ChatColor.BOLD + "The End");
            TheEnd.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "teleports you to",
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "the end"
            ));
            EndItem.setItemMeta(TheEnd);
            ItemMeta TheOverWorld = OverWorldItem.getItemMeta();
            TheOverWorld.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(157, 255, 133)) + "" + ChatColor.BOLD + "Overworld");
            TheOverWorld.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "teleports you to",
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "the overworld"
            ));
            OverWorldItem.setItemMeta(TheOverWorld);
            ItemMeta TheNetherItem = NetherItem.getItemMeta();
            TheNetherItem.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(184, 13, 13)) + "" + ChatColor.BOLD + "Nether");
            TheNetherItem.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "teleports you to",
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "the nether"
            ));
            NetherItem.setItemMeta(TheNetherItem);
            ItemMeta RandomTP = RandomTPItem.getItemMeta();
            RandomTP.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(164, 255, 74)) + "" + ChatColor.BOLD + "Random " + ChatColor.WHITE + "TP");
            RandomTP.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(170, 170, 170)) + "fresh places for shots"
            ));
            RandomTPItem.setItemMeta(RandomTP);
            ItemMeta Energy = EnergyItem.getItemMeta();
            Energy.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(150, 255, 217)) + "" + ChatColor.BOLD + "ᴇɴᴇʀɢʏ");
            Energy.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 219, 219)) + "set menu | energy bottle"
            ));
            Energy.setCustomModelData(300);
            EnergyItem.setItemMeta(Energy);
            inventory.addItem(MainBlissItem);
            inventory.setItem(1, MainBlissItem);
            inventory.setItem(2, MainBlissItem);
            inventory.setItem(3, MainBlissItem);
            inventory.setItem(4, MainBlissItem);
            inventory.setItem(5, MainBlissItem);
            inventory.setItem(6, MainBlissItem);
            inventory.setItem(7, MainBlissItem);
            inventory.setItem(8, MainBlissItem);
            inventory.setItem(9, MainBlissItem);
            inventory.setItem(10, GameModeItemCreative);
            inventory.setItem(11, MainBlissItem);
            inventory.setItem(12, GemItem);
            inventory.setItem(13, MainBlissItem);
            inventory.setItem(14, NetherItem);
            inventory.setItem(15, OverWorldItem);
            inventory.setItem(16, EndItem);
            inventory.setItem(17, MainBlissItem);
            inventory.setItem(18, MainBlissItem);
            inventory.setItem(19, GameModeItemSurvival);
            inventory.setItem(20, MainBlissItem);
            inventory.setItem(21, KitsItem);
            inventory.setItem(22, MainBlissItem);
            inventory.setItem(23, BlissSeason2);
            inventory.setItem(24, MainBlissItem);
            inventory.setItem(25, MainBlissItem);
            inventory.setItem(26, MainBlissItem);
            inventory.setItem(27, MainBlissItem);
            inventory.setItem(28, RandomTPItem);
            inventory.setItem(29, MainBlissItem);
            inventory.setItem(30, EnergyItem);
            inventory.setItem(31, MainBlissItem);
            inventory.setItem(32, MainBlissItem);
            inventory.setItem(33, MainBlissItem);
            inventory.setItem(34, MainBlissItem);
            inventory.setItem(35, MainBlissItem);
            inventory.setItem(36, MainBlissItem);
            inventory.setItem(37, MainBlissItem);
            inventory.setItem(38, MainBlissItem);
            inventory.setItem(39, MainBlissItem);
            inventory.setItem(40, MainBlissItem);
            inventory.setItem(41, MainBlissItem);
            inventory.setItem(42, MainBlissItem);
            inventory.setItem(43, MainBlissItem);
            inventory.setItem(44, MainBlissItem);
            p.openInventory(inventory);


            return true;
        }
        return true;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "" + ChatColor.BOLD + "Menu")) {
            return;

        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 10) {
            player.setGameMode(GameMode.CREATIVE);
        }
        if (event.getSlot() == 19) {
            player.setGameMode(GameMode.SURVIVAL);
        }
        if (event.getSlot() == 16) {
            teleportToEnd(player);
        }
        if (event.getSlot() == 14) {
            teleportToNether(player);
        }
        if (event.getSlot() == 15) {
            teleportToOverWorld(player);
        }
        if (event.getSlot() == 21) {
            Inventory BlissKitsInventory = Bukkit.createInventory(null, 45, net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "Kits");
            ItemStack PVPMainItem = new ItemStack(Material.IRON_SWORD, 1);

            ItemMeta PVPMainItemMeta = PVPMainItem.getItemMeta();
            player.openInventory(BlissKitsInventory);
        }
        if (event.getSlot() == 12) {
            Inventory BlissGemsInventory = Bukkit.createInventory(null, 54, net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "Gems");
            player.closeInventory();
            ItemStack MainBlissItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemStack RandomGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemStack LifeGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta LifeGemItemMeta = LifeGemItem.getItemMeta();
            LifeGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "" + ChatColor.BOLD + "ʟɪғᴇ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            LifeGemItemMeta.setCustomModelData(4);
            LifeGemItem.setItemMeta(LifeGemItemMeta);
            ItemStack StrengthGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta StrengthGemItemMeta = StrengthGemItem.getItemMeta();
            StrengthGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            StrengthGemItemMeta.setCustomModelData(10);
            StrengthGemItem.setItemMeta(StrengthGemItemMeta);
            ItemStack SpeedGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta SpeedGemItemMeta = SpeedGemItem.getItemMeta();
            SpeedGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "" + ChatColor.BOLD + "sᴘᴇᴇᴅ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            SpeedGemItemMeta.setCustomModelData(8);
            SpeedGemItem.setItemMeta(SpeedGemItemMeta);
            ItemStack FireGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta FireGemItemMeta = FireGemItem.getItemMeta();
            FireGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "" + ChatColor.BOLD + "ғɪʀᴇ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            FireGemItemMeta.setCustomModelData(2);
            FireGemItem.setItemMeta(FireGemItemMeta);
            ItemStack WealthGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta WealthGemItemMeta = WealthGemItem.getItemMeta();
            WealthGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            WealthGemItemMeta.setCustomModelData(12);
            WealthGemItem.setItemMeta(WealthGemItemMeta);
            ItemStack AstraGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta AstraGemItemMeta = AstraGemItem.getItemMeta();
            AstraGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "" + ChatColor.BOLD + "ᴀsᴛʀᴀ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            AstraGemItemMeta.setCustomModelData(14);
            AstraGemItem.setItemMeta(AstraGemItemMeta);
            ItemStack PuffGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta PuffGemItemMeta = PuffGemItem.getItemMeta();
            PuffGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ᴘᴜғғ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            PuffGemItemMeta.setCustomModelData(6);
            PuffGemItem.setItemMeta(PuffGemItemMeta);
            ItemStack GoldGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta GoldGemItemMeta = GoldGemItem.getItemMeta();
            GoldGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 165, 0)) + "" + ChatColor.BOLD + "Gold Gem" + " ");
            GoldGemItemMeta.setCustomModelData(107);
            GoldGemItem.setItemMeta(GoldGemItemMeta);

            ItemStack RevivalTomeItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta RevivalTomeItemMeta = RevivalTomeItem.getItemMeta();
            RevivalTomeItemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Revival");
            RevivalTomeItemMeta.setCustomModelData(210);
            RevivalTomeItem.setItemMeta(RevivalTomeItemMeta);

            ItemStack TraderItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta TraderItemMeta = TraderItem.getItemMeta();
            TraderItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(233, 194, 255)) + " " + ChatColor.BOLD + "Trader");
            TraderItemMeta.setCustomModelData(320);
            TraderItem.setItemMeta(TraderItemMeta);

            ItemStack EnergyItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta EnergyItemMeta = EnergyItem.getItemMeta();
            EnergyItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "Energy");
            EnergyItemMeta.setLore(Arrays.asList(
                    net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "set menu | energy bottle"
            ));

            EnergyItemMeta.setCustomModelData(300);
            EnergyItem.setItemMeta(EnergyItemMeta);

            ItemStack UpgraderItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta UpgraderItemMeta = UpgraderItem.getItemMeta();
            UpgraderItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Upgrader");
            UpgraderItemMeta.setCustomModelData(310);
            UpgraderItem.setItemMeta(UpgraderItemMeta);

            ItemStack RepairKitItem = new ItemStack(Material.NAUTILUS_SHELL, 1);
            ItemMeta RepairKitItemMeta = RepairKitItem.getItemMeta();
            RepairKitItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(73, 230, 131)) + "" + ChatColor.BOLD + "Repair");
            RepairKitItemMeta.setCustomModelData(200);
            RepairKitItem.setItemMeta(RepairKitItemMeta);

            BlissGemsInventory.setItem(25, PuffGemItem);
            BlissGemsInventory.setItem(24, AstraGemItem);
            BlissGemsInventory.setItem(23, WealthGemItem);
            BlissGemsInventory.setItem(22, FireGemItem);
            BlissGemsInventory.setItem(21, SpeedGemItem);
            BlissGemsInventory.setItem(20, StrengthGemItem);
            BlissGemsInventory.setItem(19, LifeGemItem);
            BlissGemsInventory.setItem(0, MainBlissItem);
            BlissGemsInventory.setItem(1, MainBlissItem);
            BlissGemsInventory.setItem(2, MainBlissItem);
            BlissGemsInventory.setItem(3, MainBlissItem);
            BlissGemsInventory.setItem(4, MainBlissItem);
            BlissGemsInventory.setItem(5, MainBlissItem);
            BlissGemsInventory.setItem(6, MainBlissItem);
            BlissGemsInventory.setItem(7, MainBlissItem);
            BlissGemsInventory.setItem(8, MainBlissItem);
            BlissGemsInventory.setItem(9, MainBlissItem);
            BlissGemsInventory.setItem(10, MainBlissItem);
            BlissGemsInventory.setItem(11, MainBlissItem);
            BlissGemsInventory.setItem(12, MainBlissItem);
            BlissGemsInventory.setItem(13, RandomGemItem);
            BlissGemsInventory.setItem(14, MainBlissItem);
            BlissGemsInventory.setItem(15, MainBlissItem);
            BlissGemsInventory.setItem(16, MainBlissItem);
            BlissGemsInventory.setItem(17, MainBlissItem);
            BlissGemsInventory.setItem(18, MainBlissItem);
            BlissGemsInventory.setItem(26, MainBlissItem);
            BlissGemsInventory.setItem(27, MainBlissItem);
            BlissGemsInventory.setItem(28, MainBlissItem);
            BlissGemsInventory.setItem(29, MainBlissItem);
            BlissGemsInventory.setItem(30, MainBlissItem);
            BlissGemsInventory.setItem(31, GoldGemItem);
            BlissGemsInventory.setItem(32, MainBlissItem);
            BlissGemsInventory.setItem(33, MainBlissItem);
            BlissGemsInventory.setItem(34, MainBlissItem);
            BlissGemsInventory.setItem(35, MainBlissItem);
            BlissGemsInventory.setItem(36, MainBlissItem);
            BlissGemsInventory.setItem(37, MainBlissItem);
            BlissGemsInventory.setItem(38, MainBlissItem);
            BlissGemsInventory.setItem(41, MainBlissItem);
            BlissGemsInventory.setItem(43, RevivalTomeItem);
            BlissGemsInventory.setItem(42, TraderItem);
            BlissGemsInventory.setItem(40, EnergyItem);
            BlissGemsInventory.setItem(37, RepairKitItem);
            BlissGemsInventory.setItem(38, UpgraderItem);


            player.openInventory(BlissGemsInventory);

        }
    }

    @EventHandler
    public void onBlissMenuGem(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(net.md_5.bungee.api.ChatColor.of(new Color(255, 229, 180)) + "Gems")) {
            return;
        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 31) {
            player.sendMessage("Not done yet");


        } else if (event.getSlot() == 19) {
            ItemStack LifeGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
            ItemMeta LifeGemMeta = LifeGem.getItemMeta();
            LifeGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "" + ChatColor.BOLD + "ʟɪғᴇ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            LifeGemMeta.setCustomModelData(4);
            LifeGem.setItemMeta(LifeGemMeta);
            player.getInventory().addItem(LifeGem);
        } else if (event.getSlot() == 20) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 10) {
                        ItemStack StrengthGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta StrengthGemMeta = StrengthGem.getItemMeta();
                        StrengthGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        StrengthGemMeta.setLore(Arrays.asList(
                                ChatColor.WHITE + "" + ChatColor.BOLD + "ʜᴀᴠᴇ ᴛʜᴇ sᴛʀᴇɴɢᴛʜ ᴏғ ᴀ ᴀʀᴍʏ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                " " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Strength 2, Auto enchants",
                                ChatColor.GRAY + " swords and axes with sharpness 5",
                                "",
                                net.md_5.bungee.api.ChatColor.of(new Color(158, 228, 227)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Shadow Stalker" + ChatColor.GRAY + ": track players like a compass",
                                " " + ChatColor.GRAY + "by using that players items to feed the tracking",
                                "",
                                net.md_5.bungee.api.ChatColor.of(new Color(164, 244, 254)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", ChatColor.GRAY + "-" + ChatColor.WHITE + "\uD83E\uDD3A " + ChatColor.GRAY + "" + ChatColor.BOLD + "ғʀᴀɪʟᴇʀ", ChatColor.DARK_RED + " \uD83E\uDDD1\uD83C\uDFFB" + ChatColor.GRAY + " Clears potion effects", ChatColor.GRAY + " gives weakness 1 for 20 seconds", ChatColor.DARK_RED + " \uD83E\uDD3C" + ChatColor.GRAY + "  Clears potion effects", ChatColor.GRAY + " and gives withering, " + ChatColor.WHITE + "40s, R5", "", ChatColor.GRAY + "-" + ChatColor.WHITE + "⚔ " + net.md_5.bungee.api.ChatColor.of(new Color(145, 13, 13)) + "ᴄʜᴀᴅ sᴛʀᴇɴɢᴛʜ " + ChatColor.WHITE + "R4 40s", ChatColor.GREEN + " \uD83E\uDDD1\uD83C\uDFFB" + ChatColor.GRAY + " Every 3 crits charges a hit that deals 2x the dmg", ChatColor.GREEN + " \uD83E\uDD3C" + ChatColor.GRAY + " Every 8 crits charges a hit that deals 2x the dmg"
                        ));
                        StrengthGemMeta.setCustomModelData(10);
                        StrengthGem.setItemMeta(StrengthGemMeta);
                        player.getInventory().addItem(StrengthGem);
                    }
                }
            }
        } else if (event.getSlot() == 21) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 8) {
                        ItemStack SpeedGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta SpeedGemMeta = SpeedGem.getItemMeta();
                        SpeedGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "" + ChatColor.BOLD + "sᴘᴇᴇᴅ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        SpeedGemMeta.setLore(Arrays.asList(
                                ChatColor.WHITE + "ᴛᴜʀɴ ɪɴᴛᴏ ᴀ ʙʟᴜʀ",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + " \uD83D\uDD2E" + ChatColor.GRAY + "Speed 3, Dolphins Grace, Immune to soul sand",
                                ChatColor.GRAY + " Auto enchant efficiency 5",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "Terminal Acceleration" + ChatColor.GRAY + ": Eating food, crits and",
                                ChatColor.GRAY + " projectiles are consumed  & thrown insanely fast",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs",
                                ChatColor.GRAY + "-" + ChatColor.YELLOW + "\uD83C\uDFAF" + ChatColor.WHITE + "sʟᴏᴛʜs sᴇᴅᴀᴛɪᴠᴇ"
                        ));
                        SpeedGemMeta.setCustomModelData(8);
                        SpeedGem.setItemMeta(SpeedGemMeta);
                        player.getInventory().addItem(SpeedGem);
                    }
                }
            }
        } else if (event.getSlot() == 22) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 2) {
                        ItemStack FireGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta FireGemMeta = FireGem.getItemMeta();
                        FireGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "" + ChatColor.BOLD + "ғɪʀᴇ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        FireGemMeta.setLore(Arrays.asList(
                                ChatColor.WHITE + "" + ChatColor.BOLD + "ᴍᴀɴɪᴘᴜʟᴀᴛᴇ ғɪʀᴇ",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "\uD83D\uDD2E" + ChatColor.GRAY + "Auto Smelting Longer FireThrowns",
                                ChatColor.GRAY + "Auto Enchant Flame & Fire Aspect ",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "Crisp" + ChatColor.GRAY + ": create a area that bruns enemies",
                                ChatColor.GRAY + " and autosmelts objects thrown in the zone",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(255, 213, 128)) + "\uD83E\uDDE8" + net.md_5.bungee.api.ChatColor.of(new Color(255, 95, 51)) + " ғɪʀᴇʙᴀʟʟ",
                                ChatColor.GRAY + "Spawns a fireball that charges up passively",
                                ChatColor.GRAY + "When on fire blocks charges 2x as fast",
                                ChatColor.GRAY + "Deals more damage the more you charge it",
                                ChatColor.GRAY + "",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(255, 213, 128)) + "\uD83E\uDD7E" + net.md_5.bungee.api.ChatColor.of(new Color(36, 143, 209)) + " ᴄᴏᴢʏ Cᴀᴍᴘғɪʀᴇ",
                                ChatColor.GRAY + "Spawn a campfire that heals 2 hearts and hunger",
                                ChatColor.GRAY + "a second in a 4 block radius"
                        ));
                        FireGemMeta.setCustomModelData(2);
                        FireGem.setItemMeta(FireGemMeta);
                        player.getInventory().addItem(FireGem);
                    }
                }
            }
        } else if (event.getSlot() == 23) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 12) {
                        ItemStack WealthGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta WealthGemMeta = WealthGem.getItemMeta();
                        WealthGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        WealthGemMeta.setLore(Arrays.asList(
                                ChatColor.WHITE + "" + ChatColor.BOLD + "ғᴜᴇʟ ᴀ ᴇᴍᴘɪʀᴇ",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + " \uD83D\uDD3A " + ChatColor.GRAY + "Cheaper villager trades, Luck",
                                ChatColor.GRAY + "Auto enchants looting, fortune & mending",
                                ChatColor.GRAY + "get one more ore for every 3 ores mined",
                                ChatColor.GRAY + "Chip enemies durability",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + "Pockets" + ChatColor.GRAY + ": 9 extra slots of storage/",
                                ChatColor.GRAY + " on death you drop 50% of items in your pocket",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "\uD83C\uDF40" + ChatColor.RED + "ᴜɴғᴏʀᴛᴜɴᴀᴛᴇ",
                                ChatColor.DARK_RED + " \uD83E\uDD3C" + ChatColor.GRAY + "1/3 of actions canceled" + ChatColor.WHITE + "40s. R2",
                                ChatColor.DARK_RED + " \uD83E\uDDD1\uD83C\uDFFB" + ChatColor.GRAY + "1/2 of actions canceled" + ChatColor.WHITE + "40s",
                                ChatColor.GRAY + "",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDCB8" + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 0)) + " ʀɪᴄʜ ʀᴜsʜ",
                                ChatColor.GRAY + " Double the ores, and double the mob drops for 5 minutes"
                        ));
                        WealthGemMeta.setCustomModelData(12);
                        WealthGem.setItemMeta(WealthGemMeta);
                        player.getInventory().addItem(WealthGem);
                    }
                }
            }
        } else if (event.getSlot() == 24) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 14) {
                        ItemStack AstraGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta AstraGemMeta = AstraGem.getItemMeta();
                        AstraGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "" + ChatColor.BOLD + "ᴀsᴛʀᴀ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        AstraGemMeta.setLore(Arrays.asList(
                                ChatColor.WHITE + "" + ChatColor.BOLD + "ᴍᴀɴᴀɢᴇ ᴛʜᴇ ᴛɪᴅᴇs ᴏғ ᴛʜᴇ ᴄᴏsᴍᴏs",
                                ChatColor.GRAY + "",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "\uD83D\uDD3A " + ChatColor.GRAY + " 5% of attacks will" + net.md_5.bungee.api.ChatColor.of(new Color(255, 182, 243)) + " phase " + ChatColor.GRAY + "through you.",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 182, 243)) + "Soul eater" + ChatColor.GRAY + ", See souls of enemies and mobs killed",
                                ChatColor.GRAY + "and consume their soul for health boost. Consuming their",
                                ChatColor.GRAY + "soul also captures them inside of your gem",
                                ChatColor.GRAY + "souls can be released by crouch right click with bare hand.",
                                ChatColor.GRAY + " ",
                                net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "Dimensional Drift" + ChatColor.GRAY + ": become a ghost and fast travel",
                                ChatColor.GRAY + " for a very short period of time",
                                ChatColor.GRAY + " ",
                                net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs",
                                ChatColor.WHITE + " \uD83D\uDD2A " + ChatColor.GRAY + "ᴅᴀɢɢᴇʀs",
                                ChatColor.GRAY + "Shoot 5 daggers, if a player is hit with one",
                                ChatColor.GRAY + " dagger they take 10 damage and their gem is",
                                ChatColor.GRAY + " disabled for 10 seconds for every dagger they're hit with.",
                                ChatColor.DARK_RED + "\uD83E\uDD3C" + ChatColor.GRAY + "Enter the body of that player,exit by crouching or",
                                ChatColor.GRAY + " when that player receives damage. Leaving the body",
                                ChatColor.GRAY + "will haunt them by disabling their gem for 10 seconds",
                                ChatColor.GRAY + "",
                                ChatColor.WHITE + " \uD83D\uDC7B " + ChatColor.GRAY + "ᴀsᴛʀᴀ ᴘʀᴏᴊᴇᴄᴛɪᴏɴ",
                                ChatColor.GRAY + " Become a projection and explore in a 150 block",
                                ChatColor.GRAY + " radius Spook players by left clicking with your gem.",
                                ChatColor.GRAY + " radius or lagging them with right click.",
                                ChatColor.GRAY + " You exit the Astral state if your npc is hit.",
                                ChatColor.GRAY + " or you click the air with an empty hand"
                        ));
                        AstraGemMeta.setCustomModelData(14);
                        AstraGem.setItemMeta(AstraGemMeta);
                        player.getInventory().addItem(AstraGem);
                    }
                }
            }
        } else if (event.getSlot() == 25) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 6) {
                        ItemStack PuffGem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMeta = PuffGem.getItemMeta();
                        PuffGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ᴘᴜғғ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
                        PuffGemMeta.setLore(Arrays.asList(
                                net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ʙᴇ ᴛʜᴇ ʙɪɢɢᴇsᴛ ʙɪʀᴅ",
                                net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs",
                                net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " No fall damage",
                                ChatColor.GRAY + "Auto Enchant Power 3 & Punch",
                                ChatColor.GRAY + " ",
                                net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ",
                                net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "Double Jump" + ChatColor.GRAY + ": jump again whilst in the air",
                                ChatColor.GRAY + " ",
                                net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs",
                                ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "☁ʙʀᴇᴇᴢʏ ʙᴀsʜ",
                                ChatColor.DARK_RED + "\uD83E\uDDD1\uD83C\uDFFB " + ChatColor.GRAY + "Lifts player 35 blocks and smashes",
                                ChatColor.GRAY + "them down at a high velocity",
                                ChatColor.DARK_RED + "\uD83E\uDD3C " + ChatColor.GRAY + "Pushes enemies away from you",
                                ChatColor.GRAY + " ",
                                ChatColor.GRAY + "-" + ChatColor.WHITE + "⏫ ᴅᴀsʜ",
                                ChatColor.GRAY + " Dashes you in the direction you are looking",
                                ChatColor.GRAY + " deals 2 hearts of damage regardless the protection",
                                ChatColor.GRAY + " to players and mobs upon contact"
                        ));
                        PuffGemMeta.setCustomModelData(6);
                        PuffGem.setItemMeta(PuffGemMeta);
                        player.getInventory().addItem(PuffGem);

                    }
                }
            }
        } else if (event.getSlot() == 40) {
            if (event.getClick() == ClickType.LEFT) {
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.NAUTILUS_SHELL) {
                    ItemMeta meta = clickedItem.getItemMeta();
                    if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 300) {
                       Inventory Energy = Bukkit.createInventory(null, 27, net.md_5.bungee.api.ChatColor.of(new Color(150,255,217)) + "" + ChatColor.BOLD + "ᴇɴᴇʀɢʏ");
                        ItemStack MainBlissItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                        ItemStack PuffGemItem = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMeta = PuffGemItem.getItemMeta();
                        ItemStack PuffGemItemRuined = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMetaRuined = PuffGemItemRuined.getItemMeta();
                        ItemStack PuffGemItemDamaged = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMetaDamaged = PuffGemItemDamaged.getItemMeta();
                        ItemStack PuffGemItemCracked = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMetaCracked = PuffGemItemCracked.getItemMeta();
                        ItemStack PuffGemItemScratched = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMetaScratched = PuffGemItemScratched.getItemMeta();
                        ItemStack PuffGemItemPristine = new ItemStack(Material.PRISMARINE_SHARD, 1);
                        ItemMeta PuffGemMetaPristine = PuffGemItemPristine.getItemMeta();
                        PuffGemMetaRuined.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(241,3,3)) + "Ruined");
                        PuffGemMetaDamaged.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255,201,41)) + "Damaged");
                        PuffGemMetaCracked.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(121,88,219)) + "Cracked");
                        PuffGemMetaScratched.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(87,255,143)) + "Scratched");
                        PuffGemMetaPristine.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 199)) + "Pristine");
                        PuffGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(87,255,199)) + "Prismarine Shard");
                        PuffGemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        PuffGemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        PuffGemMeta.setCustomModelData(6);
                        PuffGemMetaScratched.setCustomModelData(26);
                        PuffGemMetaCracked.setCustomModelData(46);
                        PuffGemMetaDamaged.setCustomModelData(66);
                        PuffGemMetaRuined.setCustomModelData(86);
                        PuffGemItem.setItemMeta(PuffGemMeta);
                        PuffGemItemPristine.setItemMeta(PuffGemMetaPristine);
                        PuffGemItemScratched.setItemMeta(PuffGemMetaScratched);
                        PuffGemItemCracked.setItemMeta(PuffGemMetaCracked);
                        PuffGemItemDamaged.setItemMeta(PuffGemMetaDamaged);
                        PuffGemItemRuined.setItemMeta(PuffGemMetaRuined);
                        Energy.setItem(0, MainBlissItem);
                        Energy.setItem(1, MainBlissItem);
                        Energy.setItem(2, MainBlissItem);
                        Energy.setItem(3, MainBlissItem);
                        Energy.setItem(4, PuffGemItem);
                        Energy.setItem(5, MainBlissItem);
                        Energy.setItem(6, MainBlissItem);
                        Energy.setItem(7, MainBlissItem);
                        Energy.setItem(8, MainBlissItem);
                        Energy.setItem(9, PuffGemItemRuined);
                        Energy.setItem(10, PuffGemItemDamaged);
                        Energy.setItem(11, PuffGemItemCracked);
                        Energy.setItem(12, PuffGemItemScratched);
                        Energy.setItem(13, PuffGemItemPristine);

                       player.openInventory(Energy);
                    }
                }
            }
        }
    }

    @EventHandler
    public void EnergyClickMenu(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(net.md_5.bungee.api.ChatColor.of(new Color(150,255,217)) + "" + ChatColor.BOLD + "ᴇɴᴇʀɢʏ")) {
            return;

        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 2) {


        }
    }

    private void teleportToEnd(Player player) {
        Optional<World> endWorld = Bukkit.getServer().getWorlds().stream()
                .filter(world -> world.getEnvironment() == World.Environment.THE_END)
                .findFirst();
        if (endWorld.isPresent()) {
            player.teleport(endWorld.get().getSpawnLocation());
        } else {
            player.sendMessage("The End world is not loaded!");
        }
    }

    private void teleportToNether(Player player) {
        Optional<World> endWorld = Bukkit.getServer().getWorlds().stream()
                .filter(world -> world.getEnvironment() == World.Environment.NETHER)
                .findFirst();
        if (endWorld.isPresent()) {
            player.teleport(endWorld.get().getSpawnLocation());
        } else {
            player.sendMessage("The End world is not loaded!");
        }
    }

    private void teleportToOverWorld(Player player) {
        Optional<World> endWorld = Bukkit.getServer().getWorlds().stream()
                .filter(world -> world.getEnvironment() == World.Environment.NORMAL)
                .findFirst();
        if (endWorld.isPresent()) {
            player.teleport(endWorld.get().getSpawnLocation());
        } else {
            player.sendMessage("The End world is not loaded!");
        }
    }

    @EventHandler
    public void RightClick(InventoryClickEvent event) {
        // Check if the click was a right-click
        if (event.getClick() == ClickType.RIGHT) {
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                ItemMeta meta = clickedItem.getItemMeta();
                if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 1) {
                    player.openInventory(StrengthGemTier_2());
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void ShiftClick(InventoryClickEvent event) {
        if (event.getClick() == ClickType.SHIFT_RIGHT) {
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() == Material.PRISMARINE_SHARD) {
                ItemMeta meta = clickedItem.getItemMeta();
                if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 1) {
                    player.openInventory(StrengthGemTier_1());
                    event.setCancelled(true);
                }
            }
        }
    }



    private Inventory StrengthGemTier_2() {
        Inventory inventory = Bukkit.createInventory(new CustomInventoryHolder(), InventoryType.HOPPER, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ");
        inventory.setItem(0, createCustomInventoryItem(Material.PRISMARINE_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",41));
        inventory.setItem(1, createCustomInventoryItem(Material.PRISMARINE_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",31));
        inventory.setItem(2, createCustomInventoryItem(Material.PRISMARINE_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",21));
        inventory.setItem(3, createCustomInventoryItem(Material.PRISMARINE_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",11));
        inventory.setItem(4, createCustomInventoryItem(Material.PRISMARINE_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",1));
        return inventory;
    }
    private Inventory StrengthGemTier_1() {
        Inventory inventory = Bukkit.createInventory(new CustomInventoryHolder(), InventoryType.HOPPER, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ");
        inventory.setItem(0, createCustomInventoryItem(Material.AMETHYST_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",41));
        inventory.setItem(1, createCustomInventoryItem(Material.AMETHYST_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",31));
        inventory.setItem(2, createCustomInventoryItem(Material.AMETHYST_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",21));
        inventory.setItem(3, createCustomInventoryItem(Material.AMETHYST_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",11));
        inventory.setItem(4, createCustomInventoryItem(Material.AMETHYST_SHARD, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ",1));
        return inventory;
    }
    private ItemStack createCustomInventoryItem(Material material, String displayName, int modelData) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setCustomModelData(modelData);
            meta.setDisplayName(displayName);
            item.setItemMeta(meta);
        }
        return item;
    }

    private static class CustomInventoryHolder implements InventoryHolder {
        @Override
        public Inventory getInventory() {
            return null;
        }
    }
}









