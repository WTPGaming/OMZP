/*     */ package com.wtpgaming.omzp;
/*     */ import com.wtpgaming.omzp.Config.ConfigSave;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Axes.EarthShakerConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Axes.MjolirConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.CorsairsEdgeConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.GrassBladeConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.LoneSwordConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.PeaceConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.TherumsStrengthConfig;
/*     */ import com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords.ZombieSmackerConfig;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Armor.Boots.RabbitsFeetEvent;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords.AgnisRageEvent;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords.GrassBladeEvent;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords.KikuichimonjiEvent;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords.PeaceEvent;
/*     */ import com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords.TherumsStrengthEvent;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ 
/*     */ public final class OMZP extends JavaPlugin {
/*     */   public void onEnable() {
/*  23 */     getConfig().options().copyDefaults();
/*  24 */     saveDefaultConfig();
/*     */     
/*  26 */     PluginManager pm = getServer().getPluginManager();
/*     */ 
/*     */     
/*  29 */     pm.registerEvents((Listener)new AgnisRageConfig(this), (Plugin)this);
/*  30 */     pm.registerEvents((Listener)new CorsairsEdgeConfig(this), (Plugin)this);
/*  31 */     pm.registerEvents((Listener)new DentrilsFearConfig(this), (Plugin)this);
/*  32 */     pm.registerEvents((Listener)new EndeavourConfig(this), (Plugin)this);
/*  33 */     pm.registerEvents((Listener)new FlailConfig(this), (Plugin)this);
/*  34 */     pm.registerEvents((Listener)new GambleConfig(this), (Plugin)this);
/*  35 */     pm.registerEvents((Listener)new GrassBladeConfig(this), (Plugin)this);
/*  36 */     pm.registerEvents((Listener)new HealSwordConfig(this), (Plugin)this);
/*  37 */     pm.registerEvents((Listener)new HurterConfig(this), (Plugin)this);
/*  38 */     pm.registerEvents((Listener)new IpsesFollyConfig(this), (Plugin)this);
/*  39 */     pm.registerEvents((Listener)new KikuichimonjiConfig(this), (Plugin)this);
/*  40 */     pm.registerEvents((Listener)new LoneSwordConfig(this), (Plugin)this);
/*  41 */     pm.registerEvents((Listener)new MasamuneConfig(this), (Plugin)this);
/*  42 */     pm.registerEvents((Listener)new MuramasaConfig(this), (Plugin)this);
/*  43 */     pm.registerEvents((Listener)new NightsShadowConfig(this), (Plugin)this);
/*  44 */     pm.registerEvents((Listener)new OverkillConfig(this), (Plugin)this);
/*  45 */     pm.registerEvents((Listener)new PeaceConfig(this), (Plugin)this);
/*  46 */     pm.registerEvents((Listener)new PhantomBladeConfig(this), (Plugin)this);
/*  47 */     pm.registerEvents((Listener)new PluviasStormConfig(this), (Plugin)this);
/*  48 */     pm.registerEvents((Listener)new RobbersBladeConfig(this), (Plugin)this);
/*  49 */     pm.registerEvents((Listener)new SacrificialSowrdConfig(this), (Plugin)this);
/*  50 */     pm.registerEvents((Listener)new SimoonsDealConfig(this), (Plugin)this);
/*  51 */     pm.registerEvents((Listener)new SimoonsSongConfig(this), (Plugin)this);
/*  52 */     pm.registerEvents((Listener)new TenseigaConfig(this), (Plugin)this);
/*  53 */     pm.registerEvents((Listener)new TherumsStrengthConfig(this), (Plugin)this);
/*  54 */     pm.registerEvents((Listener)new VampyrConfig(this), (Plugin)this);
/*  55 */     pm.registerEvents((Listener)new ZombieSmackerConfig(this), (Plugin)this);
/*  56 */     pm.registerEvents((Listener)new EarthShakerConfig(this), (Plugin)this);
/*  57 */     pm.registerEvents((Listener)new MeteorRainConfig(this), (Plugin)this);
/*  58 */     pm.registerEvents((Listener)new MjolirConfig(this), (Plugin)this);
/*     */     
/*  60 */     pm.registerEvents((Listener)new RabbitsFeetConfig(this), (Plugin)this);
/*     */ 
/*     */     
/*  63 */     pm.registerEvents((Listener)new ConfigSave(this), (Plugin)this);
/*     */ 
/*     */     
/*  66 */     pm.registerEvents((Listener)new AgnisRageEvent(this), (Plugin)this);
/*  67 */     pm.registerEvents((Listener)new CorsairsEdgeEvent(this), (Plugin)this);
/*  68 */     pm.registerEvents((Listener)new DentrilsFearEvent(this), (Plugin)this);
/*  69 */     pm.registerEvents((Listener)new EndeavourEvent(this), (Plugin)this);
/*  70 */     pm.registerEvents((Listener)new FlailEvent(this), (Plugin)this);
/*  71 */     pm.registerEvents((Listener)new GambleEvent(this), (Plugin)this);
/*  72 */     pm.registerEvents((Listener)new GrassBladeEvent(this), (Plugin)this);
/*  73 */     pm.registerEvents((Listener)new HealSwordEvent(this), (Plugin)this);
/*  74 */     pm.registerEvents((Listener)new HurterEvent(this), (Plugin)this);
/*  75 */     pm.registerEvents((Listener)new IpsesFollyEvent(this), (Plugin)this);
/*  76 */     pm.registerEvents((Listener)new KikuichimonjiEvent(this), (Plugin)this);
/*  77 */     pm.registerEvents((Listener)new LoneSwordEvent(this), (Plugin)this);
/*  78 */     pm.registerEvents((Listener)new MasamuneEvent(this), (Plugin)this);
/*  79 */     pm.registerEvents((Listener)new MuramasaEvent(this), (Plugin)this);
/*  80 */     pm.registerEvents((Listener)new NightsShadowEvent(this), (Plugin)this);
/*  81 */     pm.registerEvents((Listener)new OverkillEvent(this), (Plugin)this);
/*  82 */     pm.registerEvents((Listener)new PeaceEvent(this), (Plugin)this);
/*  83 */     pm.registerEvents((Listener)new PhantomBladeEvent(this), (Plugin)this);
/*  84 */     pm.registerEvents((Listener)new PluviasStormEvent(this), (Plugin)this);
/*  85 */     pm.registerEvents((Listener)new RobbersBladeEvent(this), (Plugin)this);
/*  86 */     pm.registerEvents((Listener)new SacrificialSwordEvent(this), (Plugin)this);
/*  87 */     pm.registerEvents((Listener)new SimoonsDealEvent(this), (Plugin)this);
/*  88 */     pm.registerEvents((Listener)new SimoonsSongEvent(this), (Plugin)this);
/*  89 */     pm.registerEvents((Listener)new TenseigaEvent(this), (Plugin)this);
/*  90 */     pm.registerEvents((Listener)new TherumsStrengthEvent(this), (Plugin)this);
/*  91 */     pm.registerEvents((Listener)new VampyrEvent(this), (Plugin)this);
/*  92 */     pm.registerEvents((Listener)new ZombieSmackerEvent(this), (Plugin)this);
/*  93 */     pm.registerEvents((Listener)new EarthShakerEvent(this), (Plugin)this);
/*  94 */     pm.registerEvents((Listener)new MeteorRainEvent(this), (Plugin)this);
/*  95 */     pm.registerEvents((Listener)new MjolnirEvent(this), (Plugin)this);
/*     */     
/*  97 */     pm.registerEvents((Listener)new RabbitsFeetEvent(this), (Plugin)this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     getCommand("OMZP").setExecutor((CommandExecutor)new OMZPCommand(this));
/*     */   }
/*     */   
/*     */   public void onDisable() {}
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\OMZP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */