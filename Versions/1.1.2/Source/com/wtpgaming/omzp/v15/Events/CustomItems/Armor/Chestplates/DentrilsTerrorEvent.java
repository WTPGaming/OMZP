/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class DentrilsTerrorEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public DentrilsTerrorEvent(OMZP plugin) {
/* 23 */     this.item = "DentrilsTerror";
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
/* 38 */                 int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 39 */                 int duration1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration1"));
/* 40 */                 int amplifier1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier1"));
/* 41 */                 int duration2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration2"));
/* 42 */                 int amplifier2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier2"));
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/* 47 */                 Random rand = new Random();
/* 48 */                 int n = rand.nextInt(100) + 1;
/* 49 */                 if (n <= chance) {
/* 50 */                   ((LivingEntity)event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, duration1, amplifier1));
/* 51 */                   ((LivingEntity)event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration2, amplifier2));
/* 52 */                   event.getDamager().getWorld().playSound(event.getDamager().getLocation(), Sound.ENTITY_GHAST_SCREAM, 10.0F, 0.0F);
/*    */                 } 
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Chestplates\DentrilsTerrorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */