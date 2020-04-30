/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class GambleEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public GambleEvent(OMZP plugin) {
/* 20 */     this.item = "Gamble";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 24 */     if (event.getDamager() instanceof Player) {
/* 25 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 27 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 29 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 31 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 33 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 35 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 37 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof org.bukkit.entity.LivingEntity)) {
/* 38 */                   int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 39 */                   int damageattacker = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageAttacker"));
/* 40 */                   int damagevictim = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageVictim"));
/* 41 */                   event.setDamage(damagevictim);
/* 42 */                   Random rand = new Random();
/* 43 */                   int n = rand.nextInt(100) + 1;
/* 44 */                   if (n <= chance) {
/* 45 */                     event.setDamage(0.0D);
/* 46 */                     attacker.damage(damageattacker);
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


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\GambleEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */