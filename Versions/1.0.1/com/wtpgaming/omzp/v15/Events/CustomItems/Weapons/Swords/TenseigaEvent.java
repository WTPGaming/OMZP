/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
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
/*    */ public class TenseigaEvent implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public TenseigaEvent(OMZP plugin) {
/* 18 */     this.item = "Tenseiga";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 22 */     if (event.getDamager() instanceof Player) {
/* 23 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 25 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 27 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 29 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 31 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 33 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 35 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) {
/* 36 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 37 */                   int heal = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Heal"));
/* 38 */                   event.setDamage(damage);
/* 39 */                   if (((LivingEntity)event.getEntity()).getHealth() + heal >= 20.0D) {
/* 40 */                     ((LivingEntity)event.getEntity()).setHealth(20.0D);
/*    */                   } else {
/* 42 */                     ((LivingEntity)event.getEntity()).setHealth(((LivingEntity)event.getEntity()).getHealth() + heal);
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


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\TenseigaEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */