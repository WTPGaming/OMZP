/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Bows;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class HealBowEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     if (event.getDamager() instanceof Arrow) {
/* 17 */       Arrow arrow = (Arrow)event.getDamager();
/* 18 */       if (arrow.getShooter() instanceof Player && 
/* 19 */         event.getEntity() instanceof Player) {
/* 20 */         Player attacker = (Player)arrow.getShooter();
/* 21 */         Player victim = (Player)event.getEntity();
/*    */         
/* 23 */         if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR);
/*    */ 
/*    */         
/* 26 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta() && 
/* 27 */           attacker.getInventory().getItemInMainHand().getItemMeta().hasDisplayName() && 
/* 28 */           attacker.getInventory().getItemInMainHand().getType() == Material.BOW && attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Binding Bow")) {
/* 29 */           event.setDamage(0.0D);
/* 30 */           if (victim.getHealth() + 8.0D > 20.0D) {
/* 31 */             victim.setHealth(20.0D);
/*    */           } else {
/* 33 */             victim.setHealth(victim.getHealth() + 8.0D);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Bows\HealBowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */