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
/*    */ public class KikuichimonjiEvent
/*    */   implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public KikuichimonjiEvent(OMZP plugin) {
/* 23 */     this.item = "Kikuichimonji";
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
/* 40 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) {
/* 41 */                   int chancevictim = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ChanceVictim"));
/* 42 */                   int chanceattacker = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ChanceAttacker"));
/* 43 */                   int victimduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-VictimDuration"));
/* 44 */                   int victimamplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-VictimAmplifier"));
/* 45 */                   int attackerduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-AttackerDuration"));
/* 46 */                   int attackeramplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-AttackerAmplifier"));
/*    */                   
/* 48 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 49 */                   event.setDamage(damage);
/* 50 */                   Random rand = new Random();
/* 51 */                   int n = rand.nextInt(100) + 1;
/* 52 */                   if (n <= chancevictim) {
/* 53 */                     ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, victimduration, victimamplifier));
/*    */                   }
/* 55 */                   int n2 = rand.nextInt(100) + 1;
/* 56 */                   if (n2 <= chanceattacker)
/* 57 */                     attacker.addPotionEffect(new PotionEffect(PotionEffectType.POISON, attackerduration, attackeramplifier)); 
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\KikuichimonjiEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */