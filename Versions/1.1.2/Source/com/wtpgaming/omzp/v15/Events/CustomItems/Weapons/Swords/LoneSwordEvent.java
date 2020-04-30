/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.HashMap;
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.Damageable;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoneSwordEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   private final HashMap<UUID, Long> cooldown;
/*    */   String item;
/*    */   
/*    */   public LoneSwordEvent(OMZP plugin) {
/* 30 */     this.cooldown = new HashMap<>();
/*    */     
/* 32 */     this.item = "LoneSword";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void PlayerInteractEvent(PlayerInteractEvent event) {
/* 35 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 37 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 39 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 41 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 43 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 45 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 46 */                 int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/* 47 */                 int usehealth = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseHealth"));
/* 48 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/*    */ 
/*    */                 
/* 51 */                 if (this.cooldown.containsKey(event.getPlayer().getUniqueId())) {
/* 52 */                   long ticksleft = ((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown - System.currentTimeMillis();
/* 53 */                   if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/* 54 */                     this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*    */ 
/*    */                     
/* 57 */                     if (event.getPlayer().getHealth() + usehealth > 20.0D) {
/* 58 */                       event.getPlayer().setHealth(20.0D);
/*    */                     } else {
/* 60 */                       event.getPlayer().setHealth(event.getPlayer().getHealth() + usehealth);
/*    */                     } 
/*    */ 
/*    */                     
/* 64 */                     if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 65 */                       event.getPlayer().getInventory().setItemInMainHand(null);
/* 66 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                     } else {
/* 68 */                       ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 69 */                       Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 70 */                       HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 71 */                       hand.setItemMeta((ItemMeta)HandMeta);
/*    */                     } 
/*    */                   } 
/*    */                 } else {
/* 75 */                   this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*    */ 
/*    */                   
/* 78 */                   if (event.getPlayer().getHealth() + usehealth > 20.0D) {
/* 79 */                     event.getPlayer().setHealth(20.0D);
/*    */                   } else {
/* 81 */                     event.getPlayer().setHealth(event.getPlayer().getHealth() + usehealth);
/*    */                   } 
/*    */ 
/*    */                   
/* 85 */                   if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 86 */                     event.getPlayer().getInventory().setItemInMainHand(null);
/* 87 */                     event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                   } else {
/*    */                     
/* 90 */                     ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 91 */                     Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 92 */                     HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 93 */                     hand.setItemMeta((ItemMeta)HandMeta);
/*    */                   } 
/*    */                 } 
/* 96 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\LoneSwordEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */