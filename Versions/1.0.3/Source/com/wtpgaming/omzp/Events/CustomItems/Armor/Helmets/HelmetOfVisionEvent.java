/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Helmets;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.event.player.PlayerItemBreakEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class HelmetOfVisionEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerJoin(PlayerJoinEvent event) {
/* 19 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(event.getPlayer().getInventory().getHelmet())).getItemMeta())).hasDisplayName()) {
/* 20 */       if (event.getPlayer().getInventory().getHelmet().getType() == Material.IRON_HELMET && ((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getHelmet().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 21 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 3));
/*    */       } else {
/* 23 */         event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onInventoryClick(InventoryClickEvent event) {
/* 31 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(event.getWhoClicked().getInventory().getHelmet())).getItemMeta())).hasDisplayName()) {
/* 32 */       if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.IRON_HELMET && ((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getWhoClicked().getInventory().getHelmet().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 33 */         event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 3));
/*    */       } else {
/* 35 */         event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*    */       } 
/*    */     } else {
/* 38 */       event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerItemBreak(PlayerItemBreakEvent event) {
/* 45 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(event.getPlayer().getInventory().getHelmet())).getItemMeta())).hasDisplayName())
/* 46 */       if (event.getPlayer().getInventory().getHelmet().getType() == Material.IRON_HELMET && ((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getHelmet().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Helmet Of Vision")) {
/* 47 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 3));
/*    */       } else {
/* 49 */         event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Helmets\HelmetOfVisionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */