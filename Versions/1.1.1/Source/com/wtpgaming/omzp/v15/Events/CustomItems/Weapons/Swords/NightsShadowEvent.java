/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class NightsShadowEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public NightsShadowEvent(OMZP plugin) {
/* 23 */     this.item = "NightsShadow";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 27 */     if (event.getDamager() instanceof Player) {
/* 28 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 30 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 32 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 34 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 36 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 38 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 40 */                 if ((event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) && 
/* 41 */                   attacker.getWorld().getTime() > 12000L) {
/* 42 */                   int chance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Chance"));
/* 43 */                   int duration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Duration"));
/* 44 */                   int amplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Amplifier"));
/* 45 */                   Random rand = new Random();
/* 46 */                   int n = rand.nextInt(100) + 1;
/* 47 */                   if (n <= chance)
/* 48 */                     ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration, amplifier)); 
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\NightsShadowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */