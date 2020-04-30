/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
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
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HurterEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public HurterEvent(OMZP plugin) {
/* 25 */     this.item = "Hurter";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
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
/* 43 */                   int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 44 */                   int durationdamage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DurationDamage"));
/* 45 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 46 */                   event.setDamage(damage);
/* 47 */                   for (int i = 0; i < duration * 20; i++) {
/* 48 */                     (new BukkitRunnable()
/*    */                       {
/*    */                         public void run() {
/* 51 */                           ((LivingEntity)event.getEntity()).setMaximumNoDamageTicks(1);
/* 52 */                           ((LivingEntity)event.getEntity()).setNoDamageTicks(1);
/* 53 */                           ((LivingEntity)event.getEntity()).damage((Integer.parseInt(HurterEvent.this.plugin.getConfig().getString(HurterEvent.this.item + "-DurationDamage")) / 1000.0F));
/*    */                         }
/* 55 */                       }).runTaskLater((Plugin)this.plugin, i);
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


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\HurterEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */