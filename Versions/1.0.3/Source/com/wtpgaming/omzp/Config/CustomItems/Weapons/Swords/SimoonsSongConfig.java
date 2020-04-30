/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class SimoonsSongConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public SimoonsSongConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "SimoonsSong";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Gives the user Speed and inflicts a semi-powerful knockback effect on the player hit. The knockback effect is doubled if the player hit is holding a Simoon's Song or is in the air.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Simoon's Song");
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
/* 46 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 47 */     } catch (NumberFormatException e) {
/* 48 */       plugin.getConfig().set(item + "-Damage", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 53 */       Integer.parseInt(plugin.getConfig().getString(item + "-Duration"));
/* 54 */     } catch (NumberFormatException e) {
/* 55 */       plugin.getConfig().set(item + "-Duration", "60");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       Integer.parseInt(plugin.getConfig().getString(item + "-Amplifier"));
/* 61 */     } catch (NumberFormatException e) {
/* 62 */       plugin.getConfig().set(item + "-Amplifier", "0");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 67 */       Integer.parseInt(plugin.getConfig().getString(item + "-Multiplier"));
/* 68 */     } catch (NumberFormatException e) {
/* 69 */       plugin.getConfig().set(item + "-Multiplier", "20");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\SimoonsSongConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */