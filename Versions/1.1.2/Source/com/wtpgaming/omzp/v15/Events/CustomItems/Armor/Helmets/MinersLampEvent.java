/*     */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets;
/*     */ import com.wtpgaming.omzp.OMZP;
/*     */ import java.util.Objects;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.metadata.FixedMetadataValue;
/*     */ import org.bukkit.metadata.MetadataValue;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class MinersLampEvent implements Listener {
/*     */   OMZP plugin;
/*     */   
/*     */   public MinersLampEvent(OMZP plugin) {
/*  25 */     this.item = "MinersLamp";
/*     */     this.plugin = plugin;
/*     */   } String item; @EventHandler(ignoreCancelled = true)
/*     */   public void onPlayerJoin(PlayerJoinEvent event) {
/*  29 */     if (event.getPlayer().getInventory().getHelmet() != null)
/*     */     {
/*  31 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta())
/*     */       {
/*  33 */         if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */         {
/*  35 */           if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/*  37 */             if (event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */               
/*  39 */               if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */               {
/*  41 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */               }
/*     */               
/*  44 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/*  45 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onInventoryClick(InventoryClickEvent event) {
/*  56 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  58 */       if (event.getSlot() == 39) {
/*     */         
/*  60 */         if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */           
/*  62 */           if (event.getCursor() != null)
/*     */           {
/*  64 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  66 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  68 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  70 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  72 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                     {
/*  74 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/*  77 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  78 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  84 */         } else if (event.getWhoClicked().getInventory().getHelmet().hasItemMeta()) {
/*     */           
/*  86 */           if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */           {
/*  88 */             if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  90 */               if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/*  92 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*     */                   
/*  94 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*  95 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */                   }
/*     */                   
/*  98 */                   event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  99 */                   event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/* 105 */       } else if (event.getWhoClicked().getInventory().getItem(event.getSlot()) != null) {
/*     */         
/* 107 */         if (event.isShiftClick())
/*     */         {
/* 109 */           if (event.getWhoClicked().getInventory().getItem(event.getSlot()).hasItemMeta())
/*     */           {
/* 111 */             if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().hasDisplayName())
/*     */             {
/* 113 */               if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */               {
/* 115 */                 if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */                 {
/* 117 */                   if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */                     
/* 119 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 120 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/* 123 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 124 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
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
/*     */   public void onMove(PlayerMoveEvent event) {
/* 137 */     event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 138 */     event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */     
/* 140 */     if (event.getPlayer().getInventory().getHelmet() != null)
/*     */     {
/* 142 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta())
/*     */       {
/* 144 */         if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */         {
/* 146 */           if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/* 148 */             if (event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 149 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 150 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 157 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 158 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 159 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */       }
/*     */     }
/* 162 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 163 */       event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 170 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 172 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 174 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 176 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 178 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 180 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 182 */                 if (event.getPlayer().getInventory().getHelmet() == null) {
/* 183 */                   if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                   {
/* 185 */                     event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                   }
/* 187 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 188 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\MinersLampEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */