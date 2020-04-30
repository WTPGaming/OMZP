/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class PluviasStormConfig
/*    */   implements Listener {
/*    */   public PluviasStormConfig(OMZP plugin) {
/* 11 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 14 */     String item = "PluviasStorm";
/*    */ 
/*    */     
/* 17 */     if (plugin.getConfig().getString("ItemList") == null) {
/* 18 */       plugin.getConfig().set("ItemList", item);
/*    */     } else {
/* 20 */       plugin.getConfig().set("ItemList", plugin.getConfig().getString("ItemList") + "," + item);
/*    */     } 
/*    */ 
/*    */     
/* 24 */     if (plugin.getConfig().getString(item + "-Description") == null) {
/* 25 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Takes away hunger bars and displays the message 'Pluvia's Storm saps your strength!' to the player hit.");
/*    */     }
/*    */ 
/*    */     
/* 29 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 30 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Pluvia's Storm");
/*    */     }
/*    */ 
/*    */     
/* 34 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 35 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 40 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 41 */     } catch (NumberFormatException e) {
/* 42 */       plugin.getConfig().set(item + "-Damage", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 47 */       Integer.parseInt(plugin.getConfig().getString(item + "-Hunger"));
/* 48 */     } catch (NumberFormatException e) {
/* 49 */       plugin.getConfig().set(item + "-Hunger", "1");
/*    */     } 
/*    */   }
/*    */   
/*    */   OMZP plugin;
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\PluviasStormConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */