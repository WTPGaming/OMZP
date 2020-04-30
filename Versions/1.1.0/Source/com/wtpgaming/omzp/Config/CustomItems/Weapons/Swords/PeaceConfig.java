/*    */ package com.wtpgaming.omzp.Config.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class PeaceConfig implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public PeaceConfig(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */ 
/*    */     
/* 15 */     String item = "Peace";
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
/* 26 */       plugin.getConfig().set(item + "-Description", ChatColor.LIGHT_PURPLE + "Has a chance to give the user or the player hit Weakness.");
/*    */     }
/*    */ 
/*    */     
/* 30 */     if (plugin.getConfig().getString(item + "-Name") == null) {
/* 31 */       plugin.getConfig().set(item + "-Name", ChatColor.ITALIC + "Peace");
/*    */     }
/*    */ 
/*    */     
/* 35 */     if (Material.getMaterial(plugin.getConfig().getString(item + "-Type")) == null) {
/* 36 */       plugin.getConfig().set(item + "-Type", "WOODEN_SWORD");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 41 */       Integer.parseInt(plugin.getConfig().getString(item + "-Chance"));
/* 42 */     } catch (NumberFormatException e) {
/* 43 */       plugin.getConfig().set(item + "-ChanceVictim", "33");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 48 */       Integer.parseInt(plugin.getConfig().getString(item + "-Chance"));
/* 49 */     } catch (NumberFormatException e) {
/* 50 */       plugin.getConfig().set(item + "-ChanceAttacker", "33");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 55 */       Integer.parseInt(plugin.getConfig().getString(item + "-AttackerAmplifier"));
/* 56 */     } catch (NumberFormatException e) {
/* 57 */       plugin.getConfig().set(item + "-AttackerAmplifier", "1");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 62 */       Integer.parseInt(plugin.getConfig().getString(item + "-VictimAmplifier"));
/* 63 */     } catch (NumberFormatException e) {
/* 64 */       plugin.getConfig().set(item + "-VictimAmplifier", "1");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 69 */       Integer.parseInt(plugin.getConfig().getString(item + "-AttackerDuration"));
/* 70 */     } catch (NumberFormatException e) {
/* 71 */       plugin.getConfig().set(item + "-AttackerDuration", "60");
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 76 */       Integer.parseInt(plugin.getConfig().getString(item + "-VictimDuration"));
/* 77 */     } catch (NumberFormatException e) {
/* 78 */       plugin.getConfig().set(item + "-VictimDuration", "60");
/*    */     } 
/*    */ 
/*    */     
/* 82 */     if (plugin.getConfig().getString(item + "-PlayerOnly") != "true" || plugin.getConfig().getString(item + "-PlayerOnly") != "false") {
/* 83 */       plugin.getConfig().set(item + "-PlayerOnly", "false");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 88 */       Integer.parseInt(plugin.getConfig().getString(item + "-Damage"));
/* 89 */     } catch (NumberFormatException e) {
/* 90 */       plugin.getConfig().set(item + "-Damage", "6");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Config\CustomItems\Weapons\Swords\PeaceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */