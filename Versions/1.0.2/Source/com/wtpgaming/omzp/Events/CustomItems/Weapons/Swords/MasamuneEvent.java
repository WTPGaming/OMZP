/*     */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Swords;
/*     */ 
/*     */ import com.wtpgaming.omzp.OMZP;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.Damageable;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class MasamuneEvent
/*     */   implements Listener {
/*     */   OMZP plugin;
/*     */   private final HashMap<UUID, Long> cooldown;
/*     */   String item;
/*     */   
/*     */   public MasamuneEvent(OMZP plugin) {
/*  28 */     this.cooldown = new HashMap<>();
/*     */     
/*  30 */     this.item = "Masamune";
/*     */     this.plugin = plugin;
/*     */   }
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/*  35 */     if (event.getDamager() instanceof Player) {
/*  36 */       Player attacker = (Player)event.getDamager();
/*     */       
/*  38 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/*  40 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/*  42 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/*  44 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  46 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/*  48 */                 if (event.getEntity() instanceof Player || (this.plugin.getConfig().getString(this.item + "-PlayerOnly").equals("false") && event.getEntity() instanceof org.bukkit.entity.LivingEntity)) {
/*  49 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/*  50 */                   event.setDamage(damage);
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/*  62 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/*  64 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/*  66 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/*  68 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/*  70 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  72 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*  73 */                 int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/*  74 */                 int usehealth = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseHealth"));
/*  75 */                 int usedurabilitylow = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurabilityLow"));
/*  76 */                 int usedurabilityhigh = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurabilityHigh"));
/*  77 */                 int usedurabilitychance = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurabilityChance"));
/*     */                 
/*  79 */                 if (!this.cooldown.containsKey(event.getPlayer())) {
/*  80 */                   this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis() - usecooldown - 10L));
/*     */                 }
/*     */                 
/*  83 */                 if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/*     */                   
/*  85 */                   if (event.getPlayer().getHealth() + usehealth > 20.0D) {
/*  86 */                     event.getPlayer().setHealth(20.0D);
/*     */                   } else {
/*  88 */                     event.getPlayer().setHealth(event.getPlayer().getHealth() + usehealth);
/*     */                   } 
/*     */                   
/*  91 */                   Random rand = new Random();
/*  92 */                   int n = rand.nextInt(100) + 1;
/*  93 */                   if (n <= usedurabilitychance) {
/*     */                     
/*  95 */                     if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurabilityhigh >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/*  96 */                       event.getPlayer().getInventory().setItemInMainHand(null);
/*  97 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*     */                     } else {
/*     */                       
/* 100 */                       ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 101 */                       Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 102 */                       HandMeta.setDamage(HandMeta.getDamage() + usedurabilityhigh);
/* 103 */                       hand.setItemMeta((ItemMeta)HandMeta);
/*     */                     }
/*     */                   
/*     */                   }
/* 107 */                   else if (((Damageable)event.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDamage() + usedurabilitylow >= event.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability()) {
/* 108 */                     event.getPlayer().getInventory().setItemInMainHand(null);
/* 109 */                     event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/*     */                   } else {
/*     */                     
/* 112 */                     ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
/* 113 */                     Damageable HandMeta = (Damageable)hand.getItemMeta();
/* 114 */                     HandMeta.setDamage(HandMeta.getDamage() + usedurabilitylow);
/* 115 */                     hand.setItemMeta((ItemMeta)HandMeta);
/*     */                   } 
/*     */                   
/* 118 */                   event.setCancelled(true);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Swords\MasamuneEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */