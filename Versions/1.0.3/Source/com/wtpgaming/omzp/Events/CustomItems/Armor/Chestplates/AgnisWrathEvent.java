/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Chestplates;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class AgnisWrathEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     Player attacker = (Player)event.getDamager();
/* 17 */     Player victim = (Player)event.getEntity();
/*    */     
/* 19 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getChestplate())).getItemMeta())).hasDisplayName() && 
/* 20 */       victim.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE && ((ItemMeta)Objects.<ItemMeta>requireNonNull(victim.getInventory().getChestplate().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Agni's Wrath")) {
/* 21 */       Random rand = new Random();
/* 22 */       int n = rand.nextInt(2) + 1;
/* 23 */       if (n == 1)
/* 24 */         attacker.setFireTicks(140); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\AgnisWrathEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */