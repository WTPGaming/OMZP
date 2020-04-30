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
/*    */ public class MuramasaEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public MuramasaEvent(OMZP plugin) {
/* 19 */     this.item = "Muramasa";
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
/* 34 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")) && 
/* 35 */                 event.getEntity() instanceof Player) {
/* 36 */                 int hunger = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Hunger"));
/* 37 */                 if (((Player)event.getEntity()).getFoodLevel() >= hunger) {
/* 38 */                   ((Player)event.getEntity()).setFoodLevel(((Player)event.getEntity()).getFoodLevel() - hunger);
/*    */                 } else {
/* 40 */                   ((Player)event.getEntity()).setFoodLevel(0);
/*    */                 } 
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\MuramasaEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */