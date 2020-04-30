/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class RubberSheildConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public RubberSheildConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "RubberShield";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Reduces damage taken by bow, but increases damage taken by sword.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Rubber Shield");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_CHESTPLATE");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 41 */       Integer.parseInt(plugin.getConfig().getString(item + "-Multiplier"));
/* 42 */     } catch (NumberFormatException e) {
/* 43 */       plugin.getConfig().set(item + "-Multiplier", "25");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Armor\Chestplates\RubberSheildConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */