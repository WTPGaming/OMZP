/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimoonsDealEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public SimoonsDealEvent(OMZP plugin) {
/* 33 */     this.item = "SimoonsDeal";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(final PlayerInteractEvent event) {
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
/* 47 */                 int useduration1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration1"));
/* 48 */                 int useamplifier1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier1"));
/* 49 */                 final int useduration2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration2"));
/* 50 */                 final int useamplifier2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier2"));
/* 51 */                 final int useduration3 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration3"));
/* 52 */                 final int useamplifier3 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier3"));
/* 53 */                 int negativedelay = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-NegativeDelay"));
/*    */                 
/* 55 */                 event.getPlayer().getInventory().setItemInMainHand(null);
/* 56 */                 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 
/* 58 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, useduration1, useamplifier1));
/* 59 */                 (new BukkitRunnable()
/*    */                   {
/*    */                     public void run() {
/* 62 */                       event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, useduration2, useamplifier2));
/* 63 */                       event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, useduration3, useamplifier3));
/*    */                     }
/* 65 */                   }).runTaskLater((Plugin)this.plugin, negativedelay);
/* 66 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\SimoonsDealEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */