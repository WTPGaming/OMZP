/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class DentrilsFearEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public DentrilsFearEvent(OMZP plugin) {
/* 25 */     this.item = "DentrilsFear";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 29 */     if (event.getDamager() instanceof Player) {
/* 30 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 32 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 34 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 36 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 38 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 40 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 42 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) {
/* 43 */                   event.setDamage(0.0D);
/* 44 */                   int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 45 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 46 */                   int confusionduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ConfusionDuration"));
/* 47 */                   int confusionamplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ConfusionAmplifier"));
/* 48 */                   int poisonduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-PoisonDuration"));
/* 49 */                   int poisonaplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-PoisonAmplifier"));
/* 50 */                   event.setDamage(damage);
/* 51 */                   Random rand = new Random();
/* 52 */                   int n = rand.nextInt(100) + 1;
/* 53 */                   if (n <= chance) {
/* 54 */                     ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, confusionduration, confusionamplifier));
/* 55 */                     ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, poisonduration, poisonaplifier));
/* 56 */                     attacker.getWorld().playSound(attacker.getLocation(), Sound.ENTITY_GHAST_SCREAM, 10.0F, 0.0F);
/*    */                   } 
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\DentrilsFearEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */