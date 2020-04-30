/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets;
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
/*    */ public class OniMaskEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public OniMaskEvent(OMZP plugin) {
/* 21 */     this.item = "OniMask";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 25 */     if (event.getEntity() instanceof Player)
/*    */     {
/* 27 */       if (((Player)event.getEntity()).getInventory().getChestplate() != null)
/*    */       {
/* 29 */         if (((Player)event.getEntity()).getInventory().getChestplate().hasItemMeta())
/*    */         {
/* 31 */           if (((Player)event.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */           {
/* 33 */             if (((Player)event.getEntity()).getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */             {
/* 35 */               if ((event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof LivingEntity)) && (
/* 36 */                 (LivingEntity)event.getDamager()).getEquipment().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
/* 37 */                 int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Multiplier"));
/* 38 */                 event.setDamage(event.getDamage() - event.getDamage() * multiplier);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\OniMaskEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */