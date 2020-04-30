/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Axes;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class EarthShakerConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public EarthShakerConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "EarthShaker";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Causes entities in the area to be knocked back a random distance when left clicked on the ground, at the cost of durability.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Earth Shaker");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "STONE_AXE");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-Range"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-Range", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurability"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-UseDurability", "50");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-MinMultiplier"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-MinMultiplier", "2");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-MaxMultiplier"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-MaxMultiplier", "8");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Axes\EarthShakerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */