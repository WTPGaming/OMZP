/*    */ package com.wtpgaming.omzp.v15.Config;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class ConfigSetup implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public ConfigSetup(OMZP plugin) {
/* 10 */     this.plugin = plugin;
/* 11 */     plugin.getConfig().set("ItemList", null);
/* 12 */     plugin.saveConfig();
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Config\ConfigSetup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */