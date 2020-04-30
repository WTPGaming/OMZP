/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class AgnisRageConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public AgnisRageConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "AgnisRage";
/*    */ 
/*    */ 
/*    */     
/* 19 */     if (plugin.getConfig().getString("ItemList") == null) {
/* 20 */       plugin.getConfig().set("ItemList", item);
/*    */     } else {
/* 22 */       plugin.getConfig().set("ItemList", plugin.getConfig().getString("ItemList") + "," + item);
/*    */     } 
/*    */ 
/*    */     
/* 26 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 27 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Agni's Rage");
/*    */     }
/*    */ 
/*    */     
/* 31 */     if (plugin.getConfig().getString(item + "-Description") == null) {
/* 32 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Has a chance to set the player hit on fire. Plays a creeper sound upon hitting a player.");
/*    */     }
/*    */ 
/*    */     
/* 36 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 37 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 42 */       Integer.parseInt(plugin.getConfig().getString(item + "-Chance"));
/* 43 */     } catch (NumberFormatException e) {
/* 44 */       plugin.getConfig().set(item + "-Chance", "50");
/*    */     } 
/*    */ 
/*    */     
/* 48 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 49 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 54 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 55 */     } catch (NumberFormatException e) {
/* 56 */       plugin.getConfig().set(item + "-Damage", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 61 */       Integer.parseInt(plugin.getConfig().getString(item + "-FireDuration"));
/* 62 */     } catch (NumberFormatException e) {
/* 63 */       plugin.getConfig().set(item + "-FireDuration", "0");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\AgnisRageConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */