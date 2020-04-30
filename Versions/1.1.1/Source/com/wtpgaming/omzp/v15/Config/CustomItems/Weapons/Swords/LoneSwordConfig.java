/*    */ package com.wtpgaming.omzp.v15.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class LoneSwordConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public LoneSwordConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "LoneSword";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Restores hearts to the user when right clicked, at the cost of durability. Has a cooldown.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Lone Sword");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "IRON_SWORD");
/*    */     }
/*    */ 
/*    */     
/* 40 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 41 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseDurability"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-UseDurability", "10");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseHealth"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-UseHealth", "4");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-UseCooldown"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-UseCooldown", "60");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\CustomItems\Weapons\Swords\LoneSwordConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */