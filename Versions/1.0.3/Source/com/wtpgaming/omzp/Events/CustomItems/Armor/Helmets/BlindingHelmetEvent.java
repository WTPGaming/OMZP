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
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class BlindingHelmetEvent
/*    */   implements Listener {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 18 */     if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
/* 19 */       Player victim = (Player)event.getEntity();
/* 20 */       Player attacker = (Player)event.getDamager();
/*    */ 
/*    */       
/* 23 */       if (((ItemStack)Objects.<ItemStack>requireNonNull(attacker.getInventory().getHelmet())).getItemMeta().hasDisplayName() && 
/* 24 */         attacker.getInventory().getHelmet().getType() == Material.IRON_HELMET && attacker.getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Blinding Helmet"))
/* 25 */         victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Helmets\BlindingHelmetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */