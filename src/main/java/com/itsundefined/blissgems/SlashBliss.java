package com.itsundefined.blissgems;

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
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.io.File;
import java.nio.Buffer;
import java.sql.ParameterMetaData;
import java.util.*;
import java.util.List;

public class SlashBliss implements TabCompleter, CommandExecutor{
    private final HashMap<UUID, Integer> BlissEnergyGemHealth = new HashMap<>();
    private BossBar bossBar;
    private Horse DimensionalDriftHorse = null;
    private int bossBarDuration = 80; // Duration in seconds
    private static final UUID DAGGERS_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private final NamespacedKey UNFORTUNATE = new NamespacedKey("BlissGems", "Unfortunate");
    private final NamespacedKey UNFORTUNATE_KEY = new NamespacedKey("BlissGems", "Unfortunate");
    private NamespacedKey SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ;
    private NamespacedKey SᴘᴇᴇᴅCɪʀᴄʟᴇ;
    private NamespacedKey LɪғᴇCɪʀᴄʟᴇ;
    private NamespacedKey WᴇᴀʟᴛʜCɪʀᴄʟᴇ;
    private NamespacedKey PᴜғғCɪʀᴄʟᴇ;
    private NamespacedKey FʟᴜxCɪʀᴄʟᴇ;
    private NamespacedKey Daggers;
    private NamespacedKey FireBall;
    private NamespacedKey Disabled_Gem;
    private NamespacedKey StrengthLine;
    private NamespacedKey SpeedLine;
    private NamespacedKey LifeLine;
    private NamespacedKey WealthLine;
    private NamespacedKey PuffLine;
    private NamespacedKey CʜᴀᴅSᴛʀᴇɴɢᴛʜ;
    private NamespacedKey Speed_Storm_Circle;
    private NamespacedKey ChadStrengthParticleCase1;
    private NamespacedKey ChadStrengthParticleCase2;
    private NamespacedKey ChadStrengthParticleCase3;
    private NamespacedKey ChadStrengthParticleCase4;
    private NamespacedKey DᴏᴜʙʟᴇJᴜᴍᴘ;
    private NamespacedKey CɪʀᴄʟᴇOғLɪғᴇ;
    private NamespacedKey Unfortunate;
    private NamespacedKey RɪᴄʜRᴜsʜ;
    private NamespacedKey Dash;
    private NamespacedKey Dᴀɢɢᴇʀs;
    private NamespacedKey CɪʀᴄʟᴇOғLɪғᴇVɪᴄᴛɪᴍ;
    private NamespacedKey Cozy_Campfire;
    private NamespacedKey CʜᴀᴅSᴛʀᴇɴɢᴛʜPᴀʀᴛɪᴄʟᴇs;
    private NamespacedKey TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ;
    private final List<String> LifeGemDamage = Arrays.asList("ZOMBIE", "SKELETON", "WITHER_SKELETON", "HUSK", "DROWNED");
    private NamespacedKey FɪʀsᴛJᴏɪɴ;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_12;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_11;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_10;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_9;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_8;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_7;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_6;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_5;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_4;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_3;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_2;
    private NamespacedKey BʟɪssEɴᴇʀɢʏ_1;
    private NamespacedKey TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ;
    private NamespacedKey BlissParticlesLess;
    private NamespacedKey BlissParticlesDefault;
    private NamespacedKey AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs;
    private NamespacedKey Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ;
    private NamespacedKey Uɴʙᴏᴜɴᴅ;
    private NamespacedKey FɪʀᴇBᴀʟʟ;
    private NamespacedKey FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs;
    private NamespacedKey Dimensional_Drift;
    private BukkitRunnable particleTask;
    private BukkitRunnable teleportTask;
    private JavaPlugin plugin;
    private Random random;
    private final Map<UUID, ArmorStand[]> armorStands = new HashMap<>();
    private final Map<Player, BossBar> playerBossBars = new HashMap<>();
    private final Map<Integer, PotionEffect[]> Tier1CustomModelDataEffects = new HashMap<>();
    private final Map<Integer, PotionEffect[]> Tier2CustomModelDataEffects = new HashMap<>();
    private final Map<UUID, Map.Entry<ArmorStand, BossBar>> FireBallChargingFireGem = new HashMap<>();
    private File dataFile;
    private FileConfiguration dataConfig;
    private Player playerKillHandler;
    private Map<UUID, Long> StrengthGem_Power_1_StrengthCircle = new HashMap<>();
    private Map<UUID, Long> StrengthGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> StrengthGem_Power_3_ChadStrength = new HashMap<>();
    private Map<UUID, Long> StrengthGem_Power_8_ChadStrength = new HashMap<>();
    private Map<UUID, Long> SpeedGem_Power_1_SpeedCircle = new HashMap<>();
    private Map<UUID, Long> SpeedGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> SpeedGem_Power_3_SpeedStormCircle = new HashMap<>();
    private Map<UUID, Long> LifeGem_Power_1_LifeCircle = new HashMap<>();
    private Map<UUID, Long> LifeGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> LifeGem_Power_3_CircleOfLife = new HashMap<>();
    private Map<UUID, Long> WealthGem_Power_1_WealthCircle = new HashMap<>();
    private Map<UUID, Long> WealthGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> WealthGem_Power_3_RichRush = new HashMap<>();
    private Map<UUID, Long> PuffGem_Power_1_PuffCircle = new HashMap<>();
    private Map<UUID, Long> PuffGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> PuffGem_Power_3_Dash = new HashMap<>();
    private Map<UUID, Long> AstraGem_Power_1_Daggers = new HashMap<>();
    private Map<UUID, Long> AstraGem_Power_2_SoulCapture = new HashMap<>();
    private Map<UUID, Long> AstraGem_Power_3_AstralProjection = new HashMap<>();
    private Map<UUID, Long> AstraGem_Power_4_DimensionalDrift = new HashMap<>();
    private Map<UUID, Long> FireGem_Power_1_FireBall = new HashMap<>();
    private Map<UUID, Long> FireGem_Power_2_Enchanting = new HashMap<>();
    private Map<UUID, Long> FireGem_Power_3_CozyCampfire = new HashMap<>();
    private Map<UUID, Long> FluxGem_Power_2_FluxBurst = new HashMap<>();
    private BukkitTask speedTask;
    private Map<UUID, BukkitTask> particleTasks = new HashMap<>();
    private HashMap<UUID, Integer> BlissGemHEalth;
    private HashMap<UUID, ArmorStand> dagger1Map;
    private HashMap<UUID, ArmorStand> dagger2Map;
    private final Map<UUID, Double> damageAbsorbedMap = new HashMap<>();
    private Map<UUID, Long> critCooldown = new HashMap<>();
    private final Map<UUID, Husk> AstralProjectionHit = new HashMap<>();
    private final Map<UUID, Boolean> isHoldingShard = new HashMap<>();
    private HashMap<UUID, Double> HeartDrainerHearts = new HashMap<>();
    private static final int COOLDOWN_TIME = 10; // Cooldown time in seconds
    private final Map<Player, List<ArmorStand>> playerArmorStandsMap = new HashMap<>();
    private final Map<UUID, BukkitTask> bossBarTimers = new HashMap<>();
    private Map<UUID, Long> lastRightClickTime = new HashMap<>();
    private final Map<Player, Location> itemLocations = new HashMap<>();
    private final Map<UUID, Long> lastClickTimeMap = new HashMap<>();
    private Map<UUID, BukkitRunnable> CircleOfLife = new HashMap<>();
    private HashMap<UUID, Integer> particleLevels = new HashMap<>();
    private final HashMap<UUID, Integer> BlissGemHealth = new HashMap<>();
    private final Map<UUID, Integer> minedBlocks = new HashMap<>();
    private final HashMap<Player, Integer> playerScores = new HashMap<>();
    private final Map<UUID, Integer> hasteTaskIds = new HashMap<>();
    private final Map<UUID, Integer> particleCase = new HashMap<>();
    private BukkitTask task;
    private final Map<UUID, Long> lastCriticalHitTime = new HashMap<>();
    private final Map<UUID, Long> lastClickTime = new HashMap<>();
    private Map<Player, String> ShadowStalkerPlayerHeadNames = new HashMap<>();
    private final Map<UUID, Integer> testDouble = new HashMap<>();
    private final Map<UUID, Integer> chadStrength = new HashMap<>();
    private static final long TRANSFORMATION_DELAY = 200L;
    private static final Map<UUID, String> GiftedItems = new HashMap<>();
    public final Map<UUID, Inventory> WealthGemPocketsInventory = new HashMap<>();
    private final Map<UUID, Location> AstraGemSouldCaptureEntityDeath = new HashMap<>();
    private File inventoryFile;
    private FileConfiguration inventoryConfig;
    private final Map<UUID, Integer> playerLives = new HashMap<>();
    private final Map<UUID, ItemStack[]> savedInventories = new HashMap<>();
    private final Map<UUID, ItemStack[]> savedArmor = new HashMap<>();
    private final Map<UUID, Husk> playerHusks = new HashMap<>();
    private Map<UUID, BukkitRunnable> cooldownTimers = new HashMap<>();
    private HashMap<UUID, Entity> spectatingEntities = new HashMap<>();
    private HashMap<UUID, NPC> npcClones = new HashMap<>();
    private Map<Player, ItemStack> playerItemsPlaced = new HashMap<>();
    private Map<Player, Player> playerHeadMap = new HashMap<>();
    private final Map<UUID, Long> lastJumpTimes = new HashMap<>();
    private final Map<UUID, Boolean> flyingPlayers = new HashMap<>();
    private final Map<UUID, Long> lastCritTime = new HashMap<>();
    private final Map<UUID, Integer> ChadStrengthCritical = new HashMap<>();
    private final HashMap<UUID, Boolean> chadStrengthActive = new HashMap<>();
    private Map<Player, Player> playerHeadOwners;
    private final Map<UUID, BukkitRunnable> messageTasks = new HashMap<>();
    private HashMap<UUID, Integer> critCount = new HashMap<>();
    private final Map<UUID, Integer> chadStrengthParticles = new HashMap<>();
    private boolean isFollowing = false;
    private final Map<UUID, Integer> ChadStrengthParticleCounters = new HashMap<>();
    private double LifeGemDamageAbility = 1.0;
    private HashMap<UUID, Integer> criticalHitCount = new HashMap<>();
    private ArmorStand armorStand;
    private final String targetPlayerName = "ITsUndefined_";
    private Player player;

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "STRENGTH_CIRCLE");
        SᴘᴇᴇᴅCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "SPEED_CIRCLE");
        LɪғᴇCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "LIFE_CIRCLE");
        WᴇᴀʟᴛʜCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "WEALTH_CIRCLE");
        PᴜғғCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "PUFF_CIRCLE");
        FʟᴜxCɪʀᴄʟᴇ = new NamespacedKey("BlissGems", "FLUX_CIRCLE");
        FireBall = new NamespacedKey("BlissGems", "FIREBALL");
        Daggers = new NamespacedKey("BlissGems", "DAGGERS");
        Disabled_Gem = new NamespacedKey("BlissGems", "DISABLED_GEM");
        StrengthLine = new NamespacedKey("BlissGems", "STRENGTH_LINE");
        SpeedLine = new NamespacedKey("BlissGems", "SPEED_LINE");
        LifeLine = new NamespacedKey("BlissGems", "LIFE_LINE");
        WealthLine = new NamespacedKey("BlissGems", "WEALTH_LINE");
        PuffLine = new NamespacedKey("BlissGems", "PUFF_LINE");
        CʜᴀᴅSᴛʀᴇɴɢᴛʜ = new NamespacedKey("BlissGems", "CHAD_STRENGTH");
        Speed_Storm_Circle = new NamespacedKey("BlissGems", "SPEED_STORM_CIRCLE");
        CɪʀᴄʟᴇOғLɪғᴇ = new NamespacedKey("BlissGems", "CIRCLE_OF_LIFE");
        Unfortunate = new NamespacedKey("BlissGems", "UNFORTUNATE");
        DᴏᴜʙʟᴇJᴜᴍᴘ = new NamespacedKey("BlissGems", "DoubleJump");
        RɪᴄʜRᴜsʜ = new NamespacedKey("BlissGems", "RICH_RUSH");
        FɪʀsᴛJᴏɪɴ = new NamespacedKey("BlissGems", "FIRST_JOIN");
        CɪʀᴄʟᴇOғLɪғᴇVɪᴄᴛɪᴍ = new NamespacedKey("BlissGems", "CIRCLE_OF_LIFE_VICTIM");
        Dash = new NamespacedKey("BlissGems", "DASH");
        Cozy_Campfire = new NamespacedKey("BlissGems", "COZYCAMPFIRE");
        Dimensional_Drift = new NamespacedKey("BlissGems", "DIMENSIONAL_DRIFT");
        BʟɪssEɴᴇʀɢʏ_12 = new NamespacedKey("BlissGems", "BlissGemHealth.12");
        BʟɪssEɴᴇʀɢʏ_11 = new NamespacedKey("BlissGems", "BlissGemHealth.11");
        BʟɪssEɴᴇʀɢʏ_10 = new NamespacedKey("BlissGems", "BlissGemHealth.10");
        BʟɪssEɴᴇʀɢʏ_9 = new NamespacedKey("BlissGems", "BlissGemHealth.9");
        BʟɪssEɴᴇʀɢʏ_8 = new NamespacedKey("BlissGems", "BlissGemHealth.8");
        BʟɪssEɴᴇʀɢʏ_7 = new NamespacedKey("BlissGems", "BlissGemHealth.7");
        BʟɪssEɴᴇʀɢʏ_6 = new NamespacedKey("BlissGems", "BlissGemHealth.6");
        BʟɪssEɴᴇʀɢʏ_5 = new NamespacedKey("BlissGems", "BlissGemHealth.5");
        BʟɪssEɴᴇʀɢʏ_4 = new NamespacedKey("BlissGems", "BlissGemHealth.4");
        BʟɪssEɴᴇʀɢʏ_3 = new NamespacedKey("BlissGems", "BlissGemHealth.3");
        BʟɪssEɴᴇʀɢʏ_2 = new NamespacedKey("BlissGems", "BlissGemHealth.2");
        BʟɪssEɴᴇʀɢʏ_1 = new NamespacedKey("BlissGems", "BlissGemHealth.1");
        TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ = new NamespacedKey("BlissGems", "TerminalVelocityCooldown");
        FɪʀᴇBᴀʟʟ = new NamespacedKey("BlissGems", "FireBall");
        Dᴀɢɢᴇʀs = new NamespacedKey("BlissGems", "DaggersFired");
        TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ = new NamespacedKey("BlissGems", "TerminalVelocity");
        FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs = new NamespacedKey("BlissGems", "FireBallChargingParticles");
        Uɴʙᴏᴜɴᴅ = new NamespacedKey("BlissGems", "UNBOUND");
        BlissParticlesLess = new NamespacedKey("BlissGems", "BlissParticleLevel.2");
        BlissParticlesDefault = new NamespacedKey("BlissGems", "BlissParticleLevel.3");
        CʜᴀᴅSᴛʀᴇɴɢᴛʜPᴀʀᴛɪᴄʟᴇs = new NamespacedKey("BlissGems", "CHAD_STRENGTH_PARTICLES");
        AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs = new NamespacedKey("BlissGems", "ASTRAL_PROJECTION_PARTICLES");
        ChadStrengthParticleCase4 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.4");
        ChadStrengthParticleCase3 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.3");
        ChadStrengthParticleCase2 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.2");
        ChadStrengthParticleCase1 = new NamespacedKey("BlissGems", "ChadStrengthParticleCase.1");
        Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ = new NamespacedKey("BlissGems", "CROUCHING_ON_CROP");
        
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


