/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class CorsairsEdgeConfig
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public CorsairsEdgeConfig(OMZP plugin) {
/* 13 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 16 */     String item = "CorsairsEdge";
/*    */ 
/*    */     
/* 19 */     if (plugin.getConfig().getString("ItemList") == null) {
/* 20 */       plugin.getConfig().set("ItemList", item);
/*    */     } else {
/* 22 */       plugin.getConfig().set("ItemList", plugin.getConfig().getString("ItemList") + "," + item);
/*    */     } 
/*    */ 
/*    */     
/* 26 */     if (plugin.getConfig().getString(item + "-Description") == null) {
/* 27 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Deals More damage to players holding an item");
/*    */     }
/*    */ 
/*    */     
/* 31 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 32 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Corsair's Edge");
/*    */     }
/*    */ 
/*    */     
/* 36 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 37 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 41 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-TypeOpponent")) == null) {
/* 42 */       plugin.getConfig().set(item + "-Type", "DIAMOND_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 47 */       Integer.parseInt(plugin.getConfig().getString(item + "-DamageMultiplier"));
/* 48 */     } catch (NumberFormatException e) {
/* 49 */       plugin.getConfig().set(item + "-DamageMultiplier", "33");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\CorsairsEdgeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */