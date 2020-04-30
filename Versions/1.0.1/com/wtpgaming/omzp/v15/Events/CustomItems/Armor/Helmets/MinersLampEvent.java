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
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onInventoryClick(InventoryClickEvent event) {
/*  59 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  61 */       if (event.getSlot() == 39) {
/*     */         
/*  63 */         if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */           
/*  65 */           if (event.getCursor() != null)
/*     */           {
/*  67 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  69 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  71 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  73 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  75 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                     {
/*  77 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/*  80 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  81 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  87 */         } else if (event.getWhoClicked().getInventory().getHelmet().hasItemMeta()) {
/*     */           
/*  89 */           if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */           {
/*  91 */             if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  93 */               if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/*  95 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*     */                   
/*  97 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*  98 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */                   }
/*     */                   
/* 101 */                   event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 102 */                   event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/* 108 */       } else if (event.getWhoClicked().getInventory().getItem(event.getSlot()) != null) {
/*     */         
/* 110 */         if (event.isShiftClick())
/*     */         {
/* 112 */           if (event.getWhoClicked().getInventory().getItem(event.getSlot()).hasItemMeta())
/*     */           {
/* 114 */             if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().hasDisplayName())
/*     */             {
/* 116 */               if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */               {
/* 118 */                 if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */                 {
/* 120 */                   if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */                     
/* 122 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 123 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/* 126 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 127 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/* 140 */     event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 141 */     event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */     
/* 143 */     if (event.getPlayer().getInventory().getHelmet() != null)
/*     */     {
/* 145 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta())
/*     */       {
/* 147 */         if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */         {
/* 149 */           if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/* 151 */             if (event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 152 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 153 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 160 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 161 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 162 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */       }
/*     */     }
/* 165 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 166 */       event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 173 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 175 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 177 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 179 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 181 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 183 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 185 */                 if (event.getPlayer().getInventory().getHelmet() == null) {
/* 186 */                   if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                   {
/* 188 */                     event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                   }
/* 190 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 191 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\MinersLampEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */