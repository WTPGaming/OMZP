/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
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
/*    */ public class SimoonsDealEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public SimoonsDealEvent(OMZP plugin) {
/* 26 */     this.item = "SimoonsDeal";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(final PlayerInteractEvent event) {
/* 29 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 31 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 33 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 35 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 37 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 39 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 40 */                 int useduration1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration1"));
/* 41 */                 int useamplifier1 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier1"));
/* 42 */                 final int useduration2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration2"));
/* 43 */                 final int useamplifier2 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier2"));
/* 44 */                 final int useduration3 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration3"));
/* 45 */                 final int useamplifier3 = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier3"));
/* 46 */                 int negativedelay = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-NegativeDelay"));
/*    */                 
/* 48 */                 event.getPlayer().getInventory().setItemInMainHand(null);
/* 49 */                 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*    */                 
/* 51 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, useduration1, useamplifier1));
/* 52 */                 (new BukkitRunnable()
/*    */                   {
/*    */                     public void run() {
/* 55 */                       event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, useduration2, useamplifier2));
/* 56 */                       event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, useduration3, useamplifier3));
/*    */                     }
/* 58 */                   }).runTaskLater((Plugin)this.plugin, negativedelay);
/* 59 */                 event.setCancelled(true);
/*    */               } 
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\SimoonsDealEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */