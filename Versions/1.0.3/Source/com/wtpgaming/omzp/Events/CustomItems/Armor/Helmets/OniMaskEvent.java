/*    */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Helmets;
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
/*    */ public class OniMaskEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 16 */     if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
/* 17 */       Player victim = (Player)event.getEntity();
/* 18 */       Player attacker = (Player)event.getDamager();
/*    */ 
/*    */       
/* 21 */       if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getHelmet())).getItemMeta())).hasDisplayName() && 
/* 22 */         victim.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET && ((ItemMeta)Objects.<ItemMeta>requireNonNull(victim.getInventory().getHelmet().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Oni Mask") && attacker.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD)
/* 23 */         event.setDamage(event.getDamage() - event.getDamage() * 0.33D); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Helmets\OniMaskEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */