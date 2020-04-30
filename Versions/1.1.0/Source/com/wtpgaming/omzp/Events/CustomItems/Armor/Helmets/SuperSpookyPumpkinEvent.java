/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Helmets;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerToggleSneakEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class SuperSpookyPumpkinEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
/* 19 */     Player player = event.getPlayer();
/*    */     
/* 21 */     if (((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName() && 
/* 22 */       player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Ipse's Folly")) {
/* 23 */       List<Entity> entities = player.getNearbyEntities(10.0D, 10.0D, 10.0D);
/* 24 */       for (Entity entity : entities) {
/* 25 */         if (entity instanceof Player)
/* 26 */           ((Player)entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 10)); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Helmets\SuperSpookyPumpkinEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */