/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class DentrilsTerrorConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public DentrilsTerrorConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "DentrilsTerror";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Deals more damage if the user has less health than the player hit.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Endeavour");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_CHESTPLATE");
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
/* 48 */       Integer.parseInt(plugin.getConfig().getString(item + "-Duration"));
/* 49 */     } catch (NumberFormatException e) {
/* 50 */       plugin.getConfig().set(item + "-Duration", "60");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 55 */       Integer.parseInt(plugin.getConfig().getString(item + "-Amplifier"));
/* 56 */     } catch (NumberFormatException e) {
/* 57 */       plugin.getConfig().set(item + "-Amplifier", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 62 */       Integer.parseInt(plugin.getConfig().getString(item + "-Duration"));
/* 63 */     } catch (NumberFormatException e) {
/* 64 */       plugin.getConfig().set(item + "-Duration", "60");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 69 */       Integer.parseInt(plugin.getConfig().getString(item + "-Amplifier"));
/* 70 */     } catch (NumberFormatException e) {
/* 71 */       plugin.getConfig().set(item + "-Amplifier", "1");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Armor\Chestplates\DentrilsTerrorConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */