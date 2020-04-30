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
/*    */ 
/*    */ public class EndeavourEvent implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public EndeavourEvent(OMZP plugin) {
/* 19 */     this.item = "Endeavour";
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
/* 36 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity))
/*    */                 {
/* 38 */                   if (attacker.getHealth() < ((LivingEntity)event.getEntity()).getHealth()) {
/* 39 */                     int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageMultiplier"));
/* 40 */                     event.setDamage(event.getDamage() + event.getDamage() * multiplier / 100.0D);
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


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\EndeavourEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */