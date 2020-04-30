/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class AgnisRageEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public AgnisRageEvent(OMZP plugin) {
/* 23 */     this.item = "AgnisRage";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 27 */     if (event.getDamager() instanceof Player) {
/* 28 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 30 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 32 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 34 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 36 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 38 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 40 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof org.bukkit.entity.LivingEntity)) {
/* 41 */                   int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 42 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 43 */                   int fireduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-FireDuration"));
/* 44 */                   event.setDamage(damage);
/* 45 */                   Random rand = new Random();
/* 46 */                   int n = rand.nextInt(100) + 1;
/* 47 */                   if (n <= chance) {
/* 48 */                     event.getEntity().setFireTicks(fireduration);
/* 49 */                     attacker.getWorld().playSound(attacker.getLocation(), Sound.ENTITY_CREEPER_HURT, 10.0F, 1.0F);
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


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\AgnisRageEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */