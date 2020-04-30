/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class RubberShieldEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     Player victim = (Player)event.getEntity();
/*    */ 
/*    */     
/* 19 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getChestplate())).getItemMeta())).hasDisplayName() && 
/* 20 */       victim.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE && ((ItemMeta)Objects.<ItemMeta>requireNonNull(victim.getInventory().getChestplate().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
/* 21 */       if (event.getDamager() instanceof org.bukkit.entity.Arrow) {
/* 22 */         event.setDamage(event.getDamage() - event.getDamage() * 0.25D);
/* 23 */       } else if (event.getDamager() instanceof Player && ((
/* 24 */         (Player)event.getDamager()).getInventory().getItemInMainHand().getType() == Material.WOODEN_SWORD || ((Player)event.getDamager()).getInventory().getItemInMainHand().getType() == Material.STONE_SWORD || ((Player)event.getDamager()).getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD || ((Player)event.getDamager()).getInventory().getItemInMainHand().getType() == Material.IRON_SWORD || ((Player)event.getDamager()).getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD)) {
/* 25 */         event.setDamage(event.getDamage() + event.getDamage() * 0.25D);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\RubberShieldEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */