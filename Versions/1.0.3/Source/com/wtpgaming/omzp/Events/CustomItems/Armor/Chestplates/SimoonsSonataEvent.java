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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class SimoonsSonataEvent implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 18 */     if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
/* 19 */       Player victim = (Player)event.getEntity();
/*    */ 
/*    */       
/* 22 */       if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(victim.getInventory().getChestplate())).getItemMeta())).hasDisplayName() && 
/* 23 */         victim.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE && ((ItemMeta)Objects.<ItemMeta>requireNonNull(victim.getInventory().getChestplate().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Simoon's Sonata"))
/* 24 */         victim.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\SimoonsSonataEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */