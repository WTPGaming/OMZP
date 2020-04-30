/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class MasamuneConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public MasamuneConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "Masamune";
/*    */ 
/*    */     
/* 18 */     if (plugin.getConfig().getString("ItemList") == null) {
/* 19 */       plugin.getConfig().set("ItemList", item);
/*    */     } else {
/* 21 */       plugin.getConfig().set("ItemList", plugin.getConfig().getString("ItemList") + "," + item);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 26 */     if (plugin.getConfig().getString(item + "-Description") == null) {
/* 27 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Restores hearts to the user when right clicked, at the cost of durability. Has a cooldown.");
/*    */     }
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Masamune");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseHealth"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-UseHealth", "3");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurabilityChance"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-UseDurabilityChance", "100");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurabilityLow"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-UseDurabilityLow", "5");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurabilityHigh"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-UseDurabilityHigh", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 74 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseCooldown"));
/* 75 */     } catch (NumberFormatException e) {
/* 76 */       plugin.getConfig().set(item + "-UseCooldown", "0");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\MasamuneConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */