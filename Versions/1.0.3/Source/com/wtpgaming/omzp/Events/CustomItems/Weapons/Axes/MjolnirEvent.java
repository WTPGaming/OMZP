/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Axes;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.HashMap;
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
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
/*    */ public class MjolnirEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   private final HashMap<UUID, Long> cooldown;
/*    */   String item;
/*    */   
/*    */   public MjolnirEvent(OMZP plugin) {
/* 31 */     this.cooldown = new HashMap<>();
/*    */     
/* 33 */     this.item = "Mjolnir";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 36 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 38 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 40 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 42 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 44 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 46 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 47 */                 int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/* 48 */                 int maxdistance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-MaxDistance"));
/* 49 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/*    */ 
/*    */                 
/* 52 */                 if (this.cooldown.containsKey(event.getPlayer().getUniqueId())) {
/* 53 */                   long ticksleft = ((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown - System.currentTimeMillis();
/* 54 */                   if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/* 55 */                     this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*    */ 
/*    */                     
/* 58 */                     event.getPlayer().getWorld().strikeLightning(((Block)Objects.<Block>requireNonNull(event.getPlayer().getTargetBlockExact(maxdistance))).getLocation());
/*    */ 
/*    */                     
/* 61 */                     if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 62 */                       event.getPlayer().getInventory().setItemInMainHand(null);
/* 63 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                     } else {
/* 65 */                       ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 66 */                       Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 67 */                       HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 68 */                       hand.setItemMeta((ItemMeta)HandMeta);
/*    */                     } 
/*    */                   } 
/*    */                 } else {
/* 72 */                   this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*    */ 
/*    */                   
/* 75 */                   event.getPlayer().getWorld().strikeLightning(((Block)Objects.<Block>requireNonNull(event.getPlayer().getTargetBlockExact(maxdistance))).getLocation());
/*    */ 
/*    */                   
/* 78 */                   if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 79 */                     event.getPlayer().getInventory().setItemInMainHand(null);
/* 80 */                     event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                   } else {
/*    */                     
/* 83 */                     ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 84 */                     Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 85 */                     HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 86 */                     hand.setItemMeta((ItemMeta)HandMeta);
/*    */                   } 
/*    */                 } 
/* 89 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Axes\MjolnirEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */