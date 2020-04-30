/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class DentrilsFearConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public DentrilsFearConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "DentrilsFear";
/*    */ 
/*    */     
/* 18 */     if (plugin.getConfig().getString("ItemList") == null) {
/* 19 */       plugin.getConfig().set("ItemList", item);
/*    */     } else {
/* 21 */       plugin.getConfig().set("ItemList", plugin.getConfig().getString("ItemList") + "," + item);
/*    */     } 
/*    */ 
/*    */     
/* 25 */     if (plugin.getConfig().getString(item + "-Description") == null) {
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Has a chance to give the player hit Poison and Nausea and plays a low-pitch ghast sound.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Detril's Fear");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 41 */       Integer.parseInt(plugin.getConfig().getString(item + "-Chance"));
/* 42 */     } catch (NumberFormatException e) {
/* 43 */       plugin.getConfig().set(item + "-Chance", "50");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 48 */       Integer.parseInt(plugin.getConfig().getString(item + "-PoisonAmplifier"));
/* 49 */     } catch (NumberFormatException e) {
/* 50 */       plugin.getConfig().set(item + "-PoisonAmplifier", "1");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 55 */       Integer.parseInt(plugin.getConfig().getString(item + "-PoisonDuration"));
/* 56 */     } catch (NumberFormatException e) {
/* 57 */       plugin.getConfig().set(item + "-PoisonDuration", "60");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 62 */       Integer.parseInt(plugin.getConfig().getString(item + "-ConfusionAmplifier"));
/* 63 */     } catch (NumberFormatException e) {
/* 64 */       plugin.getConfig().set(item + "-ConfusionAmplifier", "1");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 69 */       Integer.parseInt(plugin.getConfig().getString(item + "-ConfusionDuration"));
/* 70 */     } catch (NumberFormatException e) {
/* 71 */       plugin.getConfig().set(item + "-ConfusionDuration", "60");
/*    */     } 
/*    */ 
/*    */     
/* 75 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 76 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 81 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 82 */     } catch (NumberFormatException e) {
/* 83 */       plugin.getConfig().set(item + "-Damage", "0");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Swords\DentrilsFearConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */