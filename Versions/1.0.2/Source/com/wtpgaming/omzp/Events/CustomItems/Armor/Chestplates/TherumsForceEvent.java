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
/*    */ import org.bukkit.inventory.meta.Damageable;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class TherumsForceEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 21 */     if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
/* 22 */       Player attacker = (Player)event.getDamager();
/*    */ 
/*    */       
/* 25 */       if (((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(attacker.getInventory().getHelmet())).getItemMeta())).hasDisplayName() && 
/* 26 */         attacker.getInventory().getHelmet().getType() == Material.IRON_CHESTPLATE && ((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getHelmet().getItemMeta())).getDisplayName().equals(ChatColor.ITALIC + "Therum's Force")) {
/* 27 */         attacker.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0));
/*    */ 
/*    */         
/* 30 */         ItemStack chestplate = attacker.getInventory().getChestplate();
/* 31 */         assert chestplate != null;
/* 32 */         Damageable ChestplateMeta = (Damageable)chestplate.getItemMeta();
/* 33 */         assert ChestplateMeta != null;
/* 34 */         ChestplateMeta.setDamage(ChestplateMeta.getDamage() + 10);
/* 35 */         chestplate.setItemMeta((ItemMeta)ChestplateMeta);
/*    */ 
/*    */         
/* 38 */         attacker.getInventory().setChestplate((ChestplateMeta.getDamage() > chestplate.getType().getMaxDurability()) ? null : chestplate);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Chestplates\TherumsForceEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */