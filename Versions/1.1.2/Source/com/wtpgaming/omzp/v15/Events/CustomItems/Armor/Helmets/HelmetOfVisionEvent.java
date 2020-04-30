/*     */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Helmets;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HelmetOfVisionEvent
/*     */   implements Listener
/*     */ {
/*     */   OMZP plugin;
/*     */   String item;
/*     */   
/*     */   public HelmetOfVisionEvent(OMZP plugin) {
/*  34 */     this.item = "HelmetOfVision";
/*     */     this.plugin = plugin;
/*     */   } @EventHandler(ignoreCancelled = true)
/*     */   public void onPlayerJoin(PlayerJoinEvent event) {
/*  38 */     if (event.getPlayer().getInventory().getHelmet() != null)
/*     */     {
/*  40 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta())
/*     */       {
/*  42 */         if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */         {
/*  44 */           if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/*  46 */             if (event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */               
/*  48 */               if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */               {
/*  50 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */               }
/*     */               
/*  53 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/*  54 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/*  65 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  67 */       if (event.getSlot() == 39) {
/*     */         
/*  69 */         if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */           
/*  71 */           if (event.getCursor() != null)
/*     */           {
/*  73 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  75 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  77 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  79 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  81 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                     {
/*  83 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/*  86 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  87 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  93 */         } else if (event.getWhoClicked().getInventory().getHelmet().hasItemMeta()) {
/*     */           
/*  95 */           if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */           {
/*  97 */             if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  99 */               if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 101 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*     */                   
/* 103 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 104 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */                   }
/*     */                   
/* 107 */                   event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 108 */                   event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/* 114 */       } else if (event.getWhoClicked().getInventory().getItem(event.getSlot()) != null) {
/*     */         
/* 116 */         if (event.isShiftClick())
/*     */         {
/* 118 */           if (event.getWhoClicked().getInventory().getItem(event.getSlot()).hasItemMeta())
/*     */           {
/* 120 */             if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().hasDisplayName())
/*     */             {
/* 122 */               if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */               {
/* 124 */                 if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */                 {
/* 126 */                   if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */                     
/* 128 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 129 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/* 132 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 133 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/* 146 */     event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 147 */     event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */     
/* 149 */     if (event.getPlayer().getInventory().getHelmet() != null)
/*     */     {
/* 151 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta())
/*     */       {
/* 153 */         if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */         {
/* 155 */           if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/* 157 */             if (event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 158 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 159 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 166 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 167 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 168 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */       }
/*     */     }
/* 171 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 172 */       event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 179 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 181 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 183 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 185 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 187 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 189 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 191 */                 if (event.getPlayer().getInventory().getHelmet() == null) {
/* 192 */                   if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                   {
/* 194 */                     event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                   }
/* 196 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 197 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\HelmetOfVisionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */