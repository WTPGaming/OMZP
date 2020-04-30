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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class GorgonsGazeEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public GorgonsGazeEvent(OMZP plugin) {
/* 21 */     this.item = "GorgonsGaze";
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
/* 35 */               if (event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof LivingEntity)) {
/* 36 */                 int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 37 */                 int amplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier"));
/*    */                 
/* 39 */                 ((LivingEntity)event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, amplifier));
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\GorgonsGazeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */