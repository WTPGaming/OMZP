/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TherumsForceEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public TherumsForceEvent(OMZP plugin) {
/* 27 */     this.item = "TherumsForce";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 31 */     if (event.getEntity() instanceof Player)
/*    */     {
/* 33 */       if (((Player)event.getEntity()).getInventory().getChestplate() != null)
/*    */       {
/* 35 */         if (((Player)event.getEntity()).getInventory().getChestplate().hasItemMeta())
/*    */         {
/* 37 */           if (((Player)event.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */           {
/* 39 */             if (((Player)event.getEntity()).getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */             {
/* 41 */               if (event.getDamager() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getDamager() instanceof org.bukkit.entity.LivingEntity)) {
/* 42 */                 int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 43 */                 int amplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier"));
/* 44 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/*    */                 
/* 46 */                 ((Player)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, amplifier));
/*    */ 
/*    */                 
/* 49 */                 if (((Damageable)((Player)event.getEntity()).getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= ((Player)event.getEntity()).getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 50 */                   ((Player)event.getEntity()).getInventory().setItemInMainHand(null);
/* 51 */                   ((Player)event.getEntity()).playSound(((Player)event.getEntity()).getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 } else {
/*    */                   
/* 54 */                   ItemStack hand = ((Player)event.getEntity()).getInventory().getItemInMainHand();
/* 55 */                   Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 56 */                   HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 57 */                   hand.setItemMeta((ItemMeta)HandMeta);
/*    */                 } 
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Chestplates\TherumsForceEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */