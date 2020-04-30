/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.Damageable;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TherumsStrengthEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public TherumsStrengthEvent(OMZP plugin) {
/* 28 */     this.item = "TherumsStrength";
/*    */     this.plugin = plugin;
/*    */   }
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 33 */     if (event.getDamager() instanceof Player) {
/* 34 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 36 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 38 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 40 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 42 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 44 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 46 */                 if (event.getEntity() instanceof Player) {
/* 47 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 48 */                   int durability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Durability"));
/* 49 */                   event.setDamage(damage);
/*    */ 
/*    */                   
/* 52 */                   for (ItemStack item : attacker.getInventory().getArmorContents()) {
/*    */                     
/* 54 */                     if (item != null)
/*    */                     {
/* 56 */                       if (((Damageable)item).getDamage() + ((Damageable)item).getDamage() * durability / 100 + 1 >= item.getType().getMaxDurability()) {
/* 57 */                         ((Player)event.getEntity()).getInventory().setItemInMainHand(null);
/* 58 */                         ((Player)event.getEntity()).playSound(((Player)event.getEntity()).getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                       } else {
/*    */                         
/* 61 */                         Damageable ItemMeta = (Damageable)item.getItemMeta();
/* 62 */                         ItemMeta.setDamage(ItemMeta.getDamage() + ((Damageable)item).getDamage() * durability / 100);
/* 63 */                         item.setItemMeta((ItemMeta)ItemMeta);
/*    */                       } 
/*    */                     }
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


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\TherumsStrengthEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */