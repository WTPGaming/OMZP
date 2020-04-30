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
/*    */ public class CorsairsEdgeEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public CorsairsEdgeEvent(OMZP plugin) {
/* 20 */     this.item = "CorsairsEdge";
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
/* 35 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")) && 
/* 36 */                 event.getEntity() instanceof Player && (
/* 37 */                 (Player)event.getEntity()).getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-TypeVictim"))) {
/* 38 */                 int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-DamageMultiplier"));
/* 39 */                 event.setDamage(event.getDamage() + event.getDamage() * multiplier / 100.0D);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\CorsairsEdgeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */