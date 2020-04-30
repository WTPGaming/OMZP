/*     */ package com.wtpgaming.omzp;
/*     */ import com.wtpgaming.omzp.Commands.OMZPCommand;
/*     */ import com.wtpgaming.omzp.v15.Config.ConfigSave;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Boots.RabbitsFeetConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates.AgnisWrathConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates.DentrilsTerrorConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates.PluviasTempestConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates.RubberSheildConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates.TherumsForceConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Helmets.BindingHelmetConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Helmets.GorgonsGazeConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Helmets.HelmetOfVisionConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Helmets.MinersLampConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Helmets.SuperSpookyPumpkinConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Axes.EarthShakerConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.AgnisRageConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.CorsairsEdgeConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.DentrilsFearConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.EndeavourConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.FlailConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.GrassBladeConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.HealSwordConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.HurterConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.KikuichimonjiConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.LoneSwordConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.NightsShadowConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.OverkillConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.PeaceConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.PhantomBladeConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.PluviasStormConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.RobbersBladeConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.SacrificialSowrdConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.SimoonsDealConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.SimoonsSongConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.TenseigaConfig;
/*     */ import com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords.ZombieSmackerConfig;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Boots.RabbitsFeetEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates.DentrilsTerrorEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates.PluviasTempestEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates.RubberShieldEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates.TherumsForceEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.BindingHelmetEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.GorgonsGazeEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.HelmetOfVisionEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.MinersLampEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.OniMaskEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets.SuperSpookyPumpkinEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Axes.EarthShakerEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Axes.MeteorRainEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Axes.MjolnirEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.AgnisRageEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.CorsairsEdgeEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.DentrilsFearEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.EndeavourEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.GambleEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.GrassBladeEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.HurterEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.IpsesFollyEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.KikuichimonjiEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.LoneSwordEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.MasamuneEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.NightsShadowEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.OverkillEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.PhantomBladeEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.PluviasStormEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.RobbersBladeEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.SacrificialSwordEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.SimoonsDealEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.SimoonsSongEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.TenseigaEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.TherumsStrengthEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.VampyrEvent;
/*     */ import com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords.ZombieSmackerEvent;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ 
/*     */ public final class OMZP extends JavaPlugin {
/*     */   public void onEnable() {
/*  80 */     getConfig().options().copyDefaults();
/*  81 */     saveDefaultConfig();
/*     */     
/*  83 */     PluginManager pm = getServer().getPluginManager();
/*     */ 
/*     */     
/*  86 */     pm.registerEvents((Listener)new ConfigSetup(this), (Plugin)this);
/*     */ 
/*     */     
/*  89 */     pm.registerEvents((Listener)new AgnisRageConfig(this), (Plugin)this);
/*  90 */     pm.registerEvents((Listener)new CorsairsEdgeConfig(this), (Plugin)this);
/*  91 */     pm.registerEvents((Listener)new DentrilsFearConfig(this), (Plugin)this);
/*  92 */     pm.registerEvents((Listener)new EndeavourConfig(this), (Plugin)this);
/*  93 */     pm.registerEvents((Listener)new FlailConfig(this), (Plugin)this);
/*  94 */     pm.registerEvents((Listener)new GambleConfig(this), (Plugin)this);
/*  95 */     pm.registerEvents((Listener)new GrassBladeConfig(this), (Plugin)this);
/*  96 */     pm.registerEvents((Listener)new HealSwordConfig(this), (Plugin)this);
/*  97 */     pm.registerEvents((Listener)new HurterConfig(this), (Plugin)this);
/*  98 */     pm.registerEvents((Listener)new IpsesFollyConfig(this), (Plugin)this);
/*  99 */     pm.registerEvents((Listener)new KikuichimonjiConfig(this), (Plugin)this);
/* 100 */     pm.registerEvents((Listener)new LoneSwordConfig(this), (Plugin)this);
/* 101 */     pm.registerEvents((Listener)new MasamuneConfig(this), (Plugin)this);
/* 102 */     pm.registerEvents((Listener)new MuramasaConfig(this), (Plugin)this);
/* 103 */     pm.registerEvents((Listener)new NightsShadowConfig(this), (Plugin)this);
/* 104 */     pm.registerEvents((Listener)new OverkillConfig(this), (Plugin)this);
/* 105 */     pm.registerEvents((Listener)new PeaceConfig(this), (Plugin)this);
/* 106 */     pm.registerEvents((Listener)new PhantomBladeConfig(this), (Plugin)this);
/* 107 */     pm.registerEvents((Listener)new PluviasStormConfig(this), (Plugin)this);
/* 108 */     pm.registerEvents((Listener)new RobbersBladeConfig(this), (Plugin)this);
/* 109 */     pm.registerEvents((Listener)new SacrificialSowrdConfig(this), (Plugin)this);
/* 110 */     pm.registerEvents((Listener)new SimoonsDealConfig(this), (Plugin)this);
/* 111 */     pm.registerEvents((Listener)new SimoonsSongConfig(this), (Plugin)this);
/* 112 */     pm.registerEvents((Listener)new TenseigaConfig(this), (Plugin)this);
/* 113 */     pm.registerEvents((Listener)new TherumsStrengthConfig(this), (Plugin)this);
/* 114 */     pm.registerEvents((Listener)new VampyrConfig(this), (Plugin)this);
/* 115 */     pm.registerEvents((Listener)new ZombieSmackerConfig(this), (Plugin)this);
/* 116 */     pm.registerEvents((Listener)new EarthShakerConfig(this), (Plugin)this);
/* 117 */     pm.registerEvents((Listener)new MeteorRainConfig(this), (Plugin)this);
/* 118 */     pm.registerEvents((Listener)new MjolirConfig(this), (Plugin)this);
/*     */     
/* 120 */     pm.registerEvents((Listener)new RabbitsFeetConfig(this), (Plugin)this);
/*     */     
/* 122 */     pm.registerEvents((Listener)new AgnisWrathConfig(this), (Plugin)this);
/* 123 */     pm.registerEvents((Listener)new DentrilsTerrorConfig(this), (Plugin)this);
/* 124 */     pm.registerEvents((Listener)new PluviasTempestConfig(this), (Plugin)this);
/* 125 */     pm.registerEvents((Listener)new RubberSheildConfig(this), (Plugin)this);
/* 126 */     pm.registerEvents((Listener)new SimoonsSonataConfig(this), (Plugin)this);
/* 127 */     pm.registerEvents((Listener)new TherumsForceConfig(this), (Plugin)this);
/*     */     
/* 129 */     pm.registerEvents((Listener)new BindingHelmetConfig(this), (Plugin)this);
/* 130 */     pm.registerEvents((Listener)new GorgonsGazeConfig(this), (Plugin)this);
/* 131 */     pm.registerEvents((Listener)new HelmetOfVisionConfig(this), (Plugin)this);
/* 132 */     pm.registerEvents((Listener)new MinersLampConfig(this), (Plugin)this);
/* 133 */     pm.registerEvents((Listener)new OniMaskConfig(this), (Plugin)this);
/* 134 */     pm.registerEvents((Listener)new SuperSpookyPumpkinConfig(this), (Plugin)this);
/*     */ 
/*     */     
/* 137 */     pm.registerEvents((Listener)new ConfigSave(this), (Plugin)this);
/*     */ 
/*     */     
/* 140 */     pm.registerEvents((Listener)new AgnisRageEvent(this), (Plugin)this);
/* 141 */     pm.registerEvents((Listener)new CorsairsEdgeEvent(this), (Plugin)this);
/* 142 */     pm.registerEvents((Listener)new DentrilsFearEvent(this), (Plugin)this);
/* 143 */     pm.registerEvents((Listener)new EndeavourEvent(this), (Plugin)this);
/* 144 */     pm.registerEvents((Listener)new FlailEvent(this), (Plugin)this);
/* 145 */     pm.registerEvents((Listener)new GambleEvent(this), (Plugin)this);
/* 146 */     pm.registerEvents((Listener)new GrassBladeEvent(this), (Plugin)this);
/* 147 */     pm.registerEvents((Listener)new HealSwordEvent(this), (Plugin)this);
/* 148 */     pm.registerEvents((Listener)new HurterEvent(this), (Plugin)this);
/* 149 */     pm.registerEvents((Listener)new IpsesFollyEvent(this), (Plugin)this);
/* 150 */     pm.registerEvents((Listener)new KikuichimonjiEvent(this), (Plugin)this);
/* 151 */     pm.registerEvents((Listener)new LoneSwordEvent(this), (Plugin)this);
/* 152 */     pm.registerEvents((Listener)new MasamuneEvent(this), (Plugin)this);
/* 153 */     pm.registerEvents((Listener)new MuramasaEvent(this), (Plugin)this);
/* 154 */     pm.registerEvents((Listener)new NightsShadowEvent(this), (Plugin)this);
/* 155 */     pm.registerEvents((Listener)new OverkillEvent(this), (Plugin)this);
/* 156 */     pm.registerEvents((Listener)new PeaceEvent(this), (Plugin)this);
/* 157 */     pm.registerEvents((Listener)new PhantomBladeEvent(this), (Plugin)this);
/* 158 */     pm.registerEvents((Listener)new PluviasStormEvent(this), (Plugin)this);
/* 159 */     pm.registerEvents((Listener)new RobbersBladeEvent(this), (Plugin)this);
/* 160 */     pm.registerEvents((Listener)new SacrificialSwordEvent(this), (Plugin)this);
/* 161 */     pm.registerEvents((Listener)new SimoonsDealEvent(this), (Plugin)this);
/* 162 */     pm.registerEvents((Listener)new SimoonsSongEvent(this), (Plugin)this);
/* 163 */     pm.registerEvents((Listener)new TenseigaEvent(this), (Plugin)this);
/* 164 */     pm.registerEvents((Listener)new TherumsStrengthEvent(this), (Plugin)this);
/* 165 */     pm.registerEvents((Listener)new VampyrEvent(this), (Plugin)this);
/* 166 */     pm.registerEvents((Listener)new ZombieSmackerEvent(this), (Plugin)this);
/* 167 */     pm.registerEvents((Listener)new EarthShakerEvent(this), (Plugin)this);
/* 168 */     pm.registerEvents((Listener)new MeteorRainEvent(this), (Plugin)this);
/* 169 */     pm.registerEvents((Listener)new MjolnirEvent(this), (Plugin)this);
/*     */     
/* 171 */     pm.registerEvents((Listener)new RabbitsFeetEvent(this), (Plugin)this);
/*     */     
/* 173 */     pm.registerEvents((Listener)new AgnisWrathEvent(this), (Plugin)this);
/* 174 */     pm.registerEvents((Listener)new DentrilsTerrorEvent(this), (Plugin)this);
/* 175 */     pm.registerEvents((Listener)new PluviasTempestEvent(this), (Plugin)this);
/* 176 */     pm.registerEvents((Listener)new RubberShieldEvent(this), (Plugin)this);
/* 177 */     pm.registerEvents((Listener)new SimoonsSonataEvent(this), (Plugin)this);
/* 178 */     pm.registerEvents((Listener)new TherumsForceEvent(this), (Plugin)this);
/*     */     
/* 180 */     pm.registerEvents((Listener)new BindingHelmetEvent(this), (Plugin)this);
/* 181 */     pm.registerEvents((Listener)new GorgonsGazeEvent(this), (Plugin)this);
/* 182 */     pm.registerEvents((Listener)new HelmetOfVisionEvent(this), (Plugin)this);
/* 183 */     pm.registerEvents((Listener)new MinersLampEvent(this), (Plugin)this);
/* 184 */     pm.registerEvents((Listener)new OniMaskEvent(this), (Plugin)this);
/* 185 */     pm.registerEvents((Listener)new SuperSpookyPumpkinEvent(this), (Plugin)this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     getCommand("OMZP").setExecutor((CommandExecutor)new OMZPCommand(this));
/*     */   }
/*     */   
/*     */   public void onDisable() {}
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\OMZP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */