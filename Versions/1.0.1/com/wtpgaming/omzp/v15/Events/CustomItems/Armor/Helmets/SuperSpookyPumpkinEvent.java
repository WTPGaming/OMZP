/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.List;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerToggleSneakEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class SuperSpookyPumpkinEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public SuperSpookyPumpkinEvent(OMZP plugin) {
/* 22 */     this.item = "SuperSpookyPumpkin";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
/* 26 */     if (event.getPlayer().getInventory().getChestplate() != null)
/*    */     {
/* 28 */       if (event.getPlayer().getInventory().getChestplate().hasItemMeta())
/*    */       {
/* 30 */         if (event.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */         {
/* 32 */           if (event.getPlayer().getInventory().getChestplate().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 33 */             int range = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Range"));
/* 34 */             int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 35 */             int amplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier"));
/*    */             
/* 37 */             List<Entity> entities = event.getPlayer().getNearbyEntities(range, range, range);
/* 38 */             for (Entity entity : entities) {
/* 39 */               if (entity instanceof Player)
/* 40 */                 ((Player)entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier)); 
/*    */             } 
/*    */           } 
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\SuperSpookyPumpkinEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */