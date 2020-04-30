/*    */ package com.wtpgaming.omzp.Config;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class ConfigSave implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public ConfigSave(OMZP plugin) {
/* 10 */     this.plugin = plugin;
/* 11 */     plugin.saveConfig();
/* 12 */     plugin.reloadConfig();
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Config\ConfigSave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */