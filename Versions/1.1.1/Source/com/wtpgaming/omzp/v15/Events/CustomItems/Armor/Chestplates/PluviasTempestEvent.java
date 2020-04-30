/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ 
/*    */ public class PluviasTempestEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public PluviasTempestEvent(OMZP plugin) {
/* 20 */     this.item = "PluviasTempest";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 24 */     if (event.getEntity() instanceof Player)
/*    */     {
/* 26 */       if (((Player)event.getEntity()).getInventory().getChestplate() != null)
/*    */       {
/* 28 */         if (((Player)event.getEntity()).getInventory().getChestplate().hasItemMeta())
/*    */         {
/* 30 */           if (((Player)event.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */           {
/* 32 */             if (((Player)event.getEntity()).getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */             {
/* 34 */               if (event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof org.bukkit.entity.LivingEntity)) {
/* 35 */                 int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 36 */                 int heal = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Heal"));
/*    */                 
/* 38 */                 Random rand = new Random();
/* 39 */                 int n = rand.nextInt(100) + 1;
/* 40 */                 if (n <= chance)
/* 41 */                   if (((Player)event.getEntity()).getHealth() + heal > 20.0D) {
/* 42 */                     ((Player)event.getEntity()).setHealth(20.0D);
/*    */                   } else {
/* 44 */                     ((Player)event.getEntity()).setHealth(((Player)event.getEntity()).getHealth() + heal);
/*    */                   }  
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Chestplates\PluviasTempestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */