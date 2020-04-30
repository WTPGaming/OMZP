/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Axes;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
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
/*    */ public class EarthShakerEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public EarthShakerEvent(OMZP plugin) {
/* 29 */     this.item = "EarthShaker";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 32 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 34 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 36 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 38 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 40 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 42 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 43 */                 int range = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Range"));
/* 44 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/* 45 */                 int minmultiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-MinMultiplier"));
/* 46 */                 int maxmultiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-MaxMultiplier"));
/*    */ 
/*    */                 
/* 49 */                 List<Entity> entities = event.getPlayer().getNearbyEntities(range, range, range);
/*    */                 
/* 51 */                 for (Entity entity : entities) {
/*    */                   
/* 53 */                   if (entity instanceof org.bukkit.entity.Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly") == "false" && entity instanceof org.bukkit.entity.LivingEntity)) {
/* 54 */                     Random rand = new Random();
/* 55 */                     int n = rand.nextInt(maxmultiplier) + minmultiplier;
/* 56 */                     entity.setVelocity(entity.getLocation().getDirection().multiply(-n));
/*    */                   } 
/*    */                 } 
/*    */ 
/*    */                 
/* 61 */                 if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 62 */                   event.getPlayer().getInventory().setItemInMainHand(null);
/* 63 */                   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 } else {
/*    */                   
/* 66 */                   ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 67 */                   Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 68 */                   HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 69 */                   hand.setItemMeta((ItemMeta)HandMeta);
/*    */                 } 
/* 71 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Axes\EarthShakerEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */