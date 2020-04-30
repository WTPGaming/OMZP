/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Bows;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityShootBowEvent;
/*    */ 
/*    */ public class TestBow implements Listener {
/*    */   OMZP plugin;
/*    */   
/*    */   public TestBow(OMZP plugin) {
/* 12 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityShootBow(EntityShootBowEvent event) {}
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Bows\TestBow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */