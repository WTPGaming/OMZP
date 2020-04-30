/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class RobbersBladeConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public RobbersBladeConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "RobbersBlade";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "When the user hits a player, the sword is replaced by an item randomly removed from the target's inventory. If there are no items in the player hit's inventory, the message 'You failed to steal from (player hit)' will be displayed to the user. Breaks after use.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Robber's Blade");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "WOODEN_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 41 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 42 */     } catch (NumberFormatException e) {
/* 43 */       plugin.getConfig().set(item + "-Damage", "0");
/*    */     } 
/*    */ 
/*    */     
/* 47 */     if (plugin.getConfig().getString(item + "-SuccessMessage") == null) {
/* 48 */       plugin.getConfig().set(item + "-SuccessMessage", "Your pockets feel lighter.");
/*    */     }
/*    */ 
/*    */     
/* 52 */     if (plugin.getConfig().getString(item + "-FailureMessage") == null)
/* 53 */       plugin.getConfig().set(item + "-FailureMessage", "You failed to steal from "); 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Swords\RobbersBladeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */