/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Boots;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.event.player.PlayerItemBreakEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.Damageable;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RabbitsFeetEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerJoin(PlayerJoinEvent event) {
/* 26 */     if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName()) {
/* 27 */       if (event.getPlayer().getInventory().getHelmet().getType() == Material.IRON_HELMET && event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 28 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
/*    */       } else {
/* 30 */         event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onInventoryClick(InventoryClickEvent event) {
/* 38 */     if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().hasDisplayName()) {
/* 39 */       if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.IRON_HELMET && event.getWhoClicked().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 40 */         event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
/*    */       } else {
/* 42 */         event.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
/*    */       } 
/*    */     } else {
/* 45 */       event.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerItemBreak(PlayerItemBreakEvent event) {
/* 52 */     if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName()) {
/* 53 */       if (event.getPlayer().getInventory().getHelmet().getType() == Material.IRON_HELMET && event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 54 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
/*    */       } else {
/* 56 */         event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerMove(PlayerMoveEvent event) {
/* 64 */     if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName() && 
/* 65 */       event.getPlayer().getInventory().getHelmet().getType() == Material.IRON_HELMET && event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 66 */       double STILL = -0.0784000015258789D;
/* 67 */       Player player = event.getPlayer();
/* 68 */       boolean isJumping = (player.getVelocity().getY() > -0.0784000015258789D);
/* 69 */       if (isJumping) {
/*    */         
/* 71 */         ItemStack helmet = player.getInventory().getItemInMainHand();
/* 72 */         Damageable HelmetMeta = (Damageable)helmet.getItemMeta();
/* 73 */         HelmetMeta.setDamage(HelmetMeta.getDamage() + 1);
/* 74 */         helmet.setItemMeta((ItemMeta)HelmetMeta);
/*    */ 
/*    */         
/* 77 */         player.getInventory().setItemInMainHand((HelmetMeta.getDamage() > helmet.getType().getMaxDurability()) ? null : helmet);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Boots\RabbitsFeetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */