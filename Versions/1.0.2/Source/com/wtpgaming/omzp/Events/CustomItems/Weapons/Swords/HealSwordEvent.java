/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class HealSwordEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public HealSwordEvent(OMZP plugin) {
/* 21 */     this.item = "HealSword";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 25 */     if (event.getDamager() instanceof Player) {
/* 26 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 28 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 30 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 32 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 34 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 36 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 38 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) {
/* 39 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 40 */                   int heal = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Heal"));
/* 41 */                   event.setDamage(damage);
/* 42 */                   if (((LivingEntity)event.getEntity()).getHealth() + heal >= 20.0D) {
/* 43 */                     ((LivingEntity)event.getEntity()).setHealth(20.0D);
/*    */                   } else {
/* 45 */                     ((LivingEntity)event.getEntity()).setHealth(((LivingEntity)event.getEntity()).getHealth() + heal);
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


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\HealSwordEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */