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
/*    */ public class ZombieSmackerEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public ZombieSmackerEvent(OMZP plugin) {
/* 21 */     this.item = "ZombieSmacker";
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
/* 38 */                 if (event.getEntity() instanceof org.bukkit.entity.Zombie || (this.plugin.getConfig().getString(this.item + "-ZombieOnly").equals("false") && event.getEntity() instanceof Player)) {
/* 39 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 40 */                   int multiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Multiplier"));
/* 41 */                   String message = this.plugin.getConfig().getString(this.item + "-Damage");
/* 42 */                   event.setDamage(damage);
/* 43 */                   event.getEntity().setVelocity(attacker.getLocation().getDirection().multiply(multiplier));
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\ZombieSmackerEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */