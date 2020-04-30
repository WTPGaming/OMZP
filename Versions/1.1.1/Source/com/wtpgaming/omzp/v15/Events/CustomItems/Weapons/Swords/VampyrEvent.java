/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class VampyrEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public VampyrEvent(OMZP plugin) {
/* 21 */     this.item = "Vampyr";
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
/* 40 */                   int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 41 */                   int heal = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Heal"));
/* 42 */                   String message = this.plugin.getConfig().getString(this.item + "-Damage");
/* 43 */                   event.setDamage(damage);
/* 44 */                   Random rand = new Random();
/* 45 */                   int n = rand.nextInt(100) + 1;
/* 46 */                   if (n >= chance) {
/* 47 */                     if (((LivingEntity)event.getEntity()).getHealth() + heal >= 20.0D) {
/* 48 */                       ((LivingEntity)event.getEntity()).setHealth(20.0D);
/*    */                     } else {
/* 50 */                       ((LivingEntity)event.getEntity()).setHealth(((LivingEntity)event.getEntity()).getHealth() + heal);
/*    */                     } 
/* 52 */                     attacker.sendMessage(message);
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


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\VampyrEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */