/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class IpsesFollyConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public IpsesFollyConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "IpsesFolly";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "When right clicked, the user takes damage and players around the user gain Regeneration, at the cost of durability.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Ipse's Folly");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "GOLDEN_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDamage"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-UseDamage", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-Range"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-Range", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurability"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-UseDurability", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDuration"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-UseDuration", "300");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 74 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseAmplifier"));
/* 75 */     } catch (NumberFormatException e) {
/* 76 */       plugin.getConfig().set(item + "-UseAmplifier", "1");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 81 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurability"));
/* 82 */     } catch (NumberFormatException e) {
/* 83 */       plugin.getConfig().set(item + "-Range", "10");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\IpsesFollyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */