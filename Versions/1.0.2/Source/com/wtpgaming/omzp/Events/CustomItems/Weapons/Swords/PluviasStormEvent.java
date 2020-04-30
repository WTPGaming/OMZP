/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
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
/*    */ 
/*    */ public class PluviasStormEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public PluviasStormEvent(OMZP plugin) {
/* 21 */     this.item = "PluviasStorm";
/*    */     this.plugin = plugin; } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 24 */     if (event.getEntity() instanceof Player && event.getDamager() instanceof Player)
/*    */     {
/* 26 */       if (event.getDamager() instanceof Player) {
/* 27 */         Player attacker = (Player)event.getDamager();
/*    */         
/* 29 */         if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */         {
/* 31 */           if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */           {
/* 33 */             if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */             {
/* 35 */               if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */               {
/* 37 */                 if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */                 {
/* 39 */                   if (event.getEntity() instanceof Player) {
/* 40 */                     int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 41 */                     int hunger = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Hunger"));
/* 42 */                     event.setDamage(damage);
/* 43 */                     if (((Player)event.getEntity()).getFoodLevel() - hunger < 0) {
/* 44 */                       ((Player)event.getEntity()).setFoodLevel(0);
/*    */                     } else {
/* 46 */                       ((Player)event.getEntity()).setFoodLevel(((Player)event.getEntity()).getFoodLevel() - hunger);
/*    */                     } 
/* 48 */                     event.getEntity().sendMessage("Pluvia's Storm saps your strength!");
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


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\PluviasStormEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */