/*     */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Boots;
/*     */ 
/*     */ import com.google.common.collect.Sets;
/*     */ import com.wtpgaming.omzp.OMZP;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.Damageable;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.metadata.FixedMetadataValue;
/*     */ import org.bukkit.metadata.MetadataValue;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class RabbitsFeetEvent implements Listener {
/*  31 */   private Set<UUID> prevPlayersOnGround = Sets.newHashSet();
/*  32 */   private final HashMap<UUID, Long> cooldown = new HashMap<>();
/*     */   
/*     */   OMZP plugin;
/*     */   
/*     */   String item;
/*     */   
/*     */   public RabbitsFeetEvent(OMZP plugin) {
/*  39 */     this.item = "RabbitsFeet";
/*     */     this.plugin = plugin;
/*     */   } @EventHandler(ignoreCancelled = true)
/*     */   public void onPlayerJoin(PlayerJoinEvent event) {
/*  43 */     if (event.getPlayer().getInventory().getBoots() != null)
/*     */     {
/*  45 */       if (event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */       {
/*  47 */         if (event.getPlayer().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */         {
/*  49 */           if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/*  51 */             if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */             {
/*  53 */               if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                 
/*  55 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                 
/*  57 */                 event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/*  58 */                 event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */               } 
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
/*  73 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  75 */       if (event.getSlot() == 36) {
/*     */         
/*  77 */         if (event.getWhoClicked().getInventory().getBoots() == null) {
/*     */           
/*  79 */           if (event.getCursor() != null)
/*     */           {
/*  81 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  83 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  85 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  87 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  89 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP))
/*     */                     {
/*  91 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                     }
/*     */                     
/*  94 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  95 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/* 101 */         } else if (event.getWhoClicked().getInventory().getBoots().hasItemMeta()) {
/*     */           
/* 103 */           if (event.getWhoClicked().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */           {
/* 105 */             if (event.getWhoClicked().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 107 */               if (event.getWhoClicked().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 109 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                   
/* 111 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/* 112 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
/*     */                   }
/*     */                   
/* 115 */                   event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 116 */                   event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/* 122 */       } else if (event.getWhoClicked().getInventory().getItem(event.getSlot()) != null) {
/*     */         
/* 124 */         if (event.isShiftClick())
/*     */         {
/* 126 */           if (event.getWhoClicked().getInventory().getItem(event.getSlot()).hasItemMeta())
/*     */           {
/* 128 */             if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().hasDisplayName())
/*     */             {
/* 130 */               if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */               {
/* 132 */                 if (event.getWhoClicked().getInventory().getItem(event.getSlot()).getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */                 {
/* 134 */                   if (event.getWhoClicked().getInventory().getBoots() == null) {
/*     */                     
/* 136 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/* 137 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                     }
/*     */                     
/* 140 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/* 141 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/* 154 */     event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 155 */     event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/* 156 */     if (event.getPlayer().getInventory().getBoots() != null && 
/* 157 */       event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */     {
/* 159 */       if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getBoots().getItemMeta())).hasDisplayName())
/*     */       {
/* 161 */         if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */         {
/* 163 */           if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 164 */             event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 165 */             event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             
/* 167 */             int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/* 168 */             int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/*     */             
/* 170 */             Player player = event.getPlayer();
/* 171 */             if (player.getVelocity().getY() > 0.0D) {
/* 172 */               double jumpVelocity = 0.41999998688697815D;
/* 173 */               if (player.hasPotionEffect(PotionEffectType.JUMP)) {
/* 174 */                 jumpVelocity += ((player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
/*     */               }
/* 176 */               if (event.getPlayer().getLocation().getBlock().getType() != Material.LADDER && this.prevPlayersOnGround.contains(player.getUniqueId())) {
/* 177 */                 if (this.cooldown.containsKey(event.getPlayer().getUniqueId())) {
/* 178 */                   if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/* 179 */                     this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                     
/* 181 */                     if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 182 */                       event.getPlayer().getInventory().setBoots(null);
/* 183 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 184 */                       if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 185 */                         event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                       }
/*     */                     } else {
/* 188 */                       ItemStack item = event.getPlayer().getInventory().getBoots();
/* 189 */                       Damageable itemMeta = (Damageable)item.getItemMeta();
/* 190 */                       itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 191 */                       item.setItemMeta((ItemMeta)itemMeta);
/*     */                     } 
/*     */                   } 
/*     */                 } else {
/*     */                   
/* 196 */                   this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                   
/* 198 */                   if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 199 */                     event.getPlayer().getInventory().setBoots(null);
/* 200 */                     event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 201 */                     if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 202 */                       event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                     }
/*     */                   } else {
/* 205 */                     ItemStack item = event.getPlayer().getInventory().getBoots();
/* 206 */                     Damageable itemMeta = (Damageable)item.getItemMeta();
/* 207 */                     itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 208 */                     item.setItemMeta((ItemMeta)itemMeta);
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/* 213 */             if (player.isOnGround()) {
/* 214 */               this.prevPlayersOnGround.add(player.getUniqueId());
/*     */             } else {
/* 216 */               this.prevPlayersOnGround.remove(player.getUniqueId());
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 224 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 225 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 226 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */       }
/*     */     }
/* 229 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 230 */       event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 237 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 239 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 241 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 243 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 245 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 247 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 249 */                 if (event.getPlayer().getInventory().getBoots() == null) {
/* 250 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 251 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.1.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Boots\RabbitsFeetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */