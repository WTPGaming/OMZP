/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class TherumsForceConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public TherumsForceConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "TherumsForce";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Gives Resistance and loses durability upon getting hit.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Therum's Force");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_CHESTPLATE");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 41 */       Integer.parseInt(plugin.getConfig().getString(item + "-Duration"));
/* 42 */     } catch (NumberFormatException e) {
/* 43 */       plugin.getConfig().set(item + "-Duration", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 48 */       Integer.parseInt(plugin.getConfig().getString(item + "-Amplifier"));
/* 49 */     } catch (NumberFormatException e) {
/* 50 */       plugin.getConfig().set(item + "-Amplifier", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 55 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurability"));
/* 56 */     } catch (NumberFormatException e) {
/* 57 */       plugin.getConfig().set(item + "-UseDurability", "10");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Armor\Chestplates\TherumsForceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */