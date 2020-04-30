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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimoonsSonataEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public SimoonsSonataEvent(OMZP plugin) {
/* 23 */     this.item = "SimoonsSonata";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 27 */     if (event.getEntity() instanceof Player)
/*    */     {
/* 29 */       if (((Player)event.getEntity()).getInventory().getChestplate() != null)
/*    */       {
/* 31 */         if (((Player)event.getEntity()).getInventory().getChestplate().hasItemMeta())
/*    */         {
/* 33 */           if (((Player)event.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */           {
/* 35 */             if (((Player)event.getEntity()).getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */             {
/* 37 */               if (event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof LivingEntity)) {
/* 38 */                 int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 39 */                 int amplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier"));
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/* 44 */                 ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amplifier));
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Chestplates\SimoonsSonataEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */