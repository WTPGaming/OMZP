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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class DentrilsTerrorEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 18 */     Player victim = (Player)event.getEntity();
/* 19 */     Player attacker = (Player)event.getDamager();
/*    */     
/* 21 */     if (((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getChestplate())).getType() == Material.IRON_CHESTPLATE && victim.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Dentril's Terror")) {
/* 22 */       Random rand = new Random();
/* 23 */       int n = rand.nextInt(2) + 1;
/* 24 */       if (n == 1) {
/* 25 */         attacker.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 0));
/* 26 */         attacker.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 60, 1));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\DentrilsTerrorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */