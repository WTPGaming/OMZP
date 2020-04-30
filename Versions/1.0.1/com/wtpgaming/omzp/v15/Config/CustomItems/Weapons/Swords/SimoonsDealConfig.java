/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class SimoonsDealConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public SimoonsDealConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "SimoonsDeal";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Gives the user Strength when right clicked, and gives the user Weakness and Slowness once the positive effect ends. Breaks after use.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Simoon's Deal");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "WOODEN_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDuration1"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-UseDuration1", "600");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseAmplifier1"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-UseAmplifier1", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDuration2"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-UseDuration2", "600");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseAmplifier2"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-UseAmplifier2", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 74 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDuration3"));
/* 75 */     } catch (NumberFormatException e) {
/* 76 */       plugin.getConfig().set(item + "-UseDuration3", "600");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 81 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseAmplifier3"));
/* 82 */     } catch (NumberFormatException e) {
/* 83 */       plugin.getConfig().set(item + "-UseAmplifier3", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 88 */       Integer.parseInt(plugin.getConfig().getString(item + "-NegativeDelay"));
/* 89 */     } catch (NumberFormatException e) {
/* 90 */       plugin.getConfig().set(item + "-NegativeDelay", "600");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Swords\SimoonsDealConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */