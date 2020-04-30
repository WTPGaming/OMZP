/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.Damageable;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class IpsesFollyEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public IpsesFollyEvent(OMZP plugin) {
/* 27 */     this.item = "IpsesFolly";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 31 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 33 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 35 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 37 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 39 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 41 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 42 */                 int range = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Range"));
/*    */                 
/* 44 */                 event.getPlayer().damage(10.0D);
/* 45 */                 List<Entity> entities = event.getPlayer().getNearbyEntities(range, range, range);
/*    */                 
/* 47 */                 for (Entity entity : entities) {
/*    */                   
/* 49 */                   if (entity instanceof org.bukkit.entity.Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly") == "false" && entity instanceof LivingEntity)) {
/* 50 */                     int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDamage"));
/* 51 */                     int useduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration"));
/* 52 */                     int useamplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier"));
/* 53 */                     event.getPlayer().damage(damage);
/*    */                     
/* 55 */                     ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, useduration, useamplifier));
/*    */                   } 
/*    */                 } 
/* 58 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/*    */ 
/*    */                 
/* 61 */                 if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 62 */                   event.getPlayer().getInventory().setItemInMainHand(null);
/* 63 */                   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 }
/*    */                 else {
/*    */                   
/* 67 */                   ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 68 */                   Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 69 */                   HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 70 */                   hand.setItemMeta((ItemMeta)HandMeta);
/*    */                 } 
/* 72 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\IpsesFollyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */