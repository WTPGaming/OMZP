/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class SacrificialSwordEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public SacrificialSwordEvent(OMZP plugin) {
/* 25 */     this.item = "SacrificialSword";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 28 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 30 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 32 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 34 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 36 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name")))) {
/*    */               
/* 38 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 39 */                 int range = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Range"));
/* 40 */                 int sethealth = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-SetHealth"));
/* 41 */                 int useduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDuration"));
/* 42 */                 int useamplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseAmplifier"));
/* 43 */                 event.getPlayer().getInventory().clear();
/* 44 */                 event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_IRON_GOLEM_DEATH, 10.0F, 1.0F);
/*    */                 
/* 46 */                 event.getPlayer().setHealth(sethealth);
/* 47 */                 List<Entity> entities = event.getPlayer().getNearbyEntities(range, range, range);
/*    */                 
/* 49 */                 for (Entity entity : entities) {
/*    */                   
/* 51 */                   if (entity instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly") == "false" && entity instanceof org.bukkit.entity.LivingEntity)) {
/* 52 */                     ((Player)entity).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, useduration, useamplifier));
/*    */                   }
/*    */                 } 
/*    */               } 
/* 56 */               event.setCancelled(true);
/*    */             } 
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\SacrificialSwordEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */