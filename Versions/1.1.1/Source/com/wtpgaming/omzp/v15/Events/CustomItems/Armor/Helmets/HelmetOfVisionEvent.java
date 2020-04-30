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
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler(ignoreCancelled = true)
/*     */   public void onInventoryClick(InventoryClickEvent event) {
/*  68 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  70 */       if (event.getSlot() == 39) {
/*     */         
/*  72 */         if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */           
/*  74 */           if (event.getCursor() != null)
/*     */           {
/*  76 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  78 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  80 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  82 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  84 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                     {
/*  86 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/*  89 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  90 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  96 */         } else if (event.getWhoClicked().getInventory().getHelmet().hasItemMeta()) {
/*     */           
/*  98 */           if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().hasDisplayName())
/*     */           {
/* 100 */             if (event.getWhoClicked().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 102 */               if (event.getWhoClicked().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 104 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/*     */                   
/* 106 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 107 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */                   }
/*     */                   
/* 110 */                   event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 111 */                   event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/* 117 */       } else if (event.getWhoClicked().getInventory().getItem(event.getSlot()) != null) {
/*     */         
/* 119 */         if (event.isShiftClick())
/*     */         {
/* 121 */           if (event.getWhoClicked().getInventory().getItem(event.getSlot()).hasItemMeta())
/*     */           {
/* 123 */             if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().hasDisplayName())
/*     */             {
/* 125 */               if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */               {
/* 127 */                 if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */                 {
/* 129 */                   if (event.getWhoClicked().getInventory().getHelmet() == null) {
/*     */                     
/* 131 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 132 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                     }
/*     */                     
/* 135 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 136 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/* 149 */     event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 150 */     event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */     
/* 152 */     if (event.getPlayer().getInventory().getHelmet() != null) {
/* 153 */       event.getPlayer().sendMessage("1");
/*     */       
/* 155 */       if (event.getPlayer().getInventory().getHelmet().hasItemMeta()) {
/* 156 */         event.getPlayer().sendMessage("2");
/*     */ 
/*     */         
/* 159 */         event.getPlayer().sendMessage("3");
/*     */ 
/*     */         
/* 162 */         event.getPlayer().sendMessage("4");
/*     */         
/* 164 */         if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getHelmet().getItemMeta())).hasDisplayName() && event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))) && event.getPlayer().getInventory().getHelmet().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 165 */           event.getPlayer().sendMessage("5");
/* 166 */           event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 167 */           event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 174 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 175 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 176 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */       }
/*     */     }
/* 179 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
/* 180 */       event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 187 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 189 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 191 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 193 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 195 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 197 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 199 */                 if (event.getPlayer().getInventory().getHelmet() == null) {
/* 200 */                   if (!event.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
/*     */                   {
/* 202 */                     event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
/*     */                   }
/* 204 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 205 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Helmets\HelmetOfVisionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */