/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Chestplates;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class PluviasTempestEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     Player victim = (Player)event.getEntity();
/*    */     
/* 18 */     if (((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getChestplate())).getType() == Material.IRON_CHESTPLATE && victim.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Pluvia's Tempest")) {
/* 19 */       event.setDamage(0.0D);
/* 20 */       Random rand = new Random();
/* 21 */       int n = rand.nextInt(5) + 1;
/* 22 */       if (n == 1)
/* 23 */         victim.setHealth(victim.getHealth() + 1.0D); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\PluviasTempestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */