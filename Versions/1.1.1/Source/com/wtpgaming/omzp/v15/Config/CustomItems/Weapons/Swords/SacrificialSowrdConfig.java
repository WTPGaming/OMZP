/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class SacrificialSowrdConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public SacrificialSowrdConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "SacrificialSword";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "When right clicked, the users health is depleted, their inventory is cleared and players around the user gain Regeneration. Plays an iron golem sound when used.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Sacrificial Sword");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "WOOD_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-SetHealth"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-SetHealth", "1");
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
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDuration"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-UseDuration", "300");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseAmplifier"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-UseAmplifier", "1");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Swords\SacrificialSowrdConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */