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
/*    */ public class EarthShakerEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public EarthShakerEvent(OMZP plugin) {
/* 27 */     this.item = "EarthShaker";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 30 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 32 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 34 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 36 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 38 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 40 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 41 */                 int range = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Range"));
/* 42 */                 int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/* 43 */                 int minmultiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-MinMultiplier"));
/* 44 */                 int maxmultiplier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-MaxMultiplier"));
/*    */ 
/*    */                 
/* 47 */                 List<Entity> entities = event.getPlayer().getNearbyEntities(range, range, range);
/*    */                 
/* 49 */                 for (Entity entity : entities) {
/*    */                   
/* 51 */                   if (entity instanceof org.bukkit.entity.Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly") == "false" && entity instanceof org.bukkit.entity.LivingEntity)) {
/* 52 */                     Random rand = new Random();
/* 53 */                     int n = rand.nextInt(maxmultiplier) + minmultiplier;
/* 54 */                     entity.setVelocity(entity.getLocation().getDirection().multiply(-n));
/*    */                   } 
/*    */                 } 
/*    */ 
/*    */                 
/* 59 */                 if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 60 */                   event.getPlayer().getInventory().setItemInMainHand(null);
/* 61 */                   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 } else {
/*    */                   
/* 64 */                   ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 65 */                   Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 66 */                   HandMeta.setDamage(HandMeta.getDamage() + usedurability);
/* 67 */                   hand.setItemMeta((ItemMeta)HandMeta);
/*    */                 } 
/* 69 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Axes\EarthShakerEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */