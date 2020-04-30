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
/*    */ public class PeaceEvent implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public PeaceEvent(OMZP plugin) {
/* 22 */     this.item = "Peace";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 26 */     if (event.getDamager() instanceof Player) {
/* 27 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 29 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 31 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 33 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 35 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 37 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 39 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof LivingEntity)) {
/* 40 */                   int chancevictim = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ChanceVictim"));
/* 41 */                   int chanceattacker = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-ChanceAttacker"));
/* 42 */                   int victimduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-VictimDuration"));
/* 43 */                   int victimamplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-VictimAmplifier"));
/* 44 */                   int attackerduration = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-AttackerDuration"));
/* 45 */                   int attackeramplifier = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-AttackerAmplifier"));
/*    */                   
/* 47 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 48 */                   event.setDamage(damage);
/* 49 */                   Random rand = new Random();
/* 50 */                   int n = rand.nextInt(100) + 1;
/* 51 */                   if (n <= chancevictim) {
/* 52 */                     ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, victimduration, victimamplifier));
/*    */                   }
/* 54 */                   int n2 = rand.nextInt(100) + 1;
/* 55 */                   if (n2 <= chanceattacker)
/* 56 */                     attacker.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, attackerduration, attackeramplifier)); 
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\PeaceEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */