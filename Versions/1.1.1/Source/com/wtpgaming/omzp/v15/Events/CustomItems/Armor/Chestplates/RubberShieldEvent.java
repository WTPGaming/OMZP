/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RubberShieldEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public RubberShieldEvent(OMZP plugin) {
/* 22 */     this.item = "RubberShield";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 26 */     if (event.getEntity() instanceof Player)
/*    */     {
/* 28 */       if (((Player)event.getEntity()).getInventory().getChestplate() != null)
/*    */       {
/* 30 */         if (((Player)event.getEntity()).getInventory().getChestplate().hasItemMeta())
/*    */         {
/* 32 */           if (((Player)event.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */           {
/* 34 */             if (((Player)event.getEntity()).getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*    */               
/* 36 */               int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Multiplier"));
/* 37 */               if (event.getDamager() instanceof org.bukkit.entity.Arrow) {
/* 38 */                 event.setDamage(event.getDamage() - event.getDamage() * multiplier / 100.0D);
/* 39 */               } else if ((event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof LivingEntity)) && 
/* 40 */                 event.getDamager() instanceof Player && (
/* 41 */                 (LivingEntity)event.getDamager()).getEquipment().getItemInMainHand().getType() != Material.AIR && (
/* 42 */                 (LivingEntity)event.getDamager()).getEquipment().getItemInMainHand().getType().toString().toLowerCase().contains("sword")) {
/* 43 */                 event.setDamage(event.getDamage() + event.getDamage() * multiplier / 100.0D);
/*    */               } 
/*    */             } 
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Chestplates\RubberShieldEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */