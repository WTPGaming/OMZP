/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Bows;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class BindingBowEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     if (event.getDamager() instanceof Arrow) {
/* 17 */       Arrow arrow = (Arrow)event.getDamager();
/* 18 */       if (arrow.getShooter() instanceof Player && 
/* 19 */         event.getEntity() instanceof Player) {
/* 20 */         Player attacker = (Player)arrow.getShooter();
/* 21 */         Player victim = (Player)event.getEntity();
/*    */         
/* 23 */         if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR && 
/* 24 */           attacker.getInventory().getItemInMainHand().hasItemMeta() && 
/* 25 */           attacker.getInventory().getItemInMainHand().getItemMeta().hasDisplayName() && 
/* 26 */           attacker.getInventory().getItemInMainHand().getType() == Material.BOW && attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Binding Bow")) {
/* 27 */           event.setDamage(0.0D);
/* 28 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Bows\BindingBowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */