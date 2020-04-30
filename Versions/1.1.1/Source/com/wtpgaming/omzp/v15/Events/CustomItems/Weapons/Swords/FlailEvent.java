/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class FlailEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public FlailEvent(OMZP plugin) {
/* 19 */     this.item = "Flail";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 23 */     if (event.getDamager() instanceof Player) {
/* 24 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 26 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 28 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 30 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 32 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 34 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 36 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof org.bukkit.entity.LivingEntity)) {
/* 37 */                   int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageMultiplier"));
/* 38 */                   int damagebase = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageBase"));
/* 39 */                   event.setDamage(damagebase + (20.0D - attacker.getHealth()) * multiplier);
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\FlailEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */