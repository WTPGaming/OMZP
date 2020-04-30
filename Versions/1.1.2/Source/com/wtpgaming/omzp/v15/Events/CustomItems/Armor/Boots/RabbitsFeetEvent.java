/*     */ package com.wtpgaming.omzp.v15.Events.CustomItems.Armor.Boots;
/*     */ import com.wtpgaming.omzp.OMZP;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
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
/*  27 */   private Set<UUID> prevPlayersOnGround = Sets.newHashSet();
/*  28 */   private final HashMap<UUID, Long> cooldown = new HashMap<>();
/*     */   
/*     */   OMZP plugin;
/*     */   
/*     */   String item;
/*     */   
/*     */   public RabbitsFeetEvent(OMZP plugin) {
/*  35 */     this.item = "RabbitsFeet";
/*     */     this.plugin = plugin; } @EventHandler(ignoreCancelled = true)
/*     */   public void onPlayerJoin(PlayerJoinEvent event) {
/*  38 */     if (event.getPlayer().getInventory().getBoots() != null)
/*     */     {
/*  40 */       if (event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */       {
/*  42 */         if (event.getPlayer().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */         {
/*  44 */           if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/*  46 */             if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */             {
/*  48 */               if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                 
/*  50 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                 
/*  52 */                 event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/*  53 */                 event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */               } 
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
/*  67 */       if (event.getSlot() == 36) {
/*     */         
/*  69 */         if (event.getWhoClicked().getInventory().getBoots() == null) {
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
/*  81 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP))
/*     */                     {
/*  83 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                     }
/*     */                     
/*  86 */                     event.getWhoClicked().removeMetadata(this.item, (Plugin)this.plugin);
/*  87 */                     event.getWhoClicked().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  93 */         } else if (event.getWhoClicked().getInventory().getBoots().hasItemMeta()) {
/*     */           
/*  95 */           if (event.getWhoClicked().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */           {
/*  97 */             if (event.getWhoClicked().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/*  99 */               if (event.getWhoClicked().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 101 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                   
/* 103 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/* 104 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
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
/* 126 */                   if (event.getWhoClicked().getInventory().getBoots() == null) {
/*     */                     
/* 128 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/* 129 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
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
/*     */     
/* 150 */     if (event.getPlayer().getInventory().getBoots() != null)
/*     */     {
/* 152 */       if (event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */       {
/* 154 */         if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getBoots().getItemMeta())).hasDisplayName())
/*     */         {
/* 156 */           if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/* 158 */             if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */               
/* 160 */               event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 161 */               event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */               
/* 163 */               int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/* 164 */               int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/*     */               
/* 166 */               Player player = event.getPlayer();
/* 167 */               if (player.getVelocity().getY() > 0.0D) {
/* 168 */                 double jumpVelocity = 0.41999998688697815D;
/* 169 */                 if (player.hasPotionEffect(PotionEffectType.JUMP)) {
/* 170 */                   jumpVelocity += ((player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
/*     */                 }
/* 172 */                 if (event.getPlayer().getLocation().getBlock().getType() != Material.LADDER && this.prevPlayersOnGround.contains(player.getUniqueId())) {
/* 173 */                   if (this.cooldown.containsKey(event.getPlayer().getUniqueId())) {
/* 174 */                     if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/* 175 */                       this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                       
/* 177 */                       if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 178 */                         event.getPlayer().getInventory().setBoots(null);
/* 179 */                         event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 180 */                         if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 181 */                           event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                         }
/*     */                       } else {
/* 184 */                         ItemStack item = event.getPlayer().getInventory().getBoots();
/* 185 */                         Damageable itemMeta = (Damageable)item.getItemMeta();
/* 186 */                         itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 187 */                         item.setItemMeta((ItemMeta)itemMeta);
/*     */                       } 
/*     */                     } 
/*     */                   } else {
/*     */                     
/* 192 */                     this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                     
/* 194 */                     if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 195 */                       event.getPlayer().getInventory().setBoots(null);
/* 196 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 197 */                       if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 198 */                         event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                       }
/*     */                     } else {
/* 201 */                       ItemStack item = event.getPlayer().getInventory().getBoots();
/* 202 */                       Damageable itemMeta = (Damageable)item.getItemMeta();
/* 203 */                       itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 204 */                       item.setItemMeta((ItemMeta)itemMeta);
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */               } 
/* 209 */               if (player.isOnGround()) {
/* 210 */                 this.prevPlayersOnGround.add(player.getUniqueId());
/*     */               } else {
/* 212 */                 this.prevPlayersOnGround.remove(player.getUniqueId());
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 220 */     if (((MetadataValue)event.getPlayer().getMetadata(this.item).get(0)).asString() == "true") {
/* 221 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 222 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */       }
/*     */     }
/* 225 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 226 */       event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 233 */     if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.PHYSICAL)
/*     */     {
/* 235 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 237 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 239 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 241 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 243 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 245 */                 if (event.getPlayer().getInventory().getBoots() == null) {
/* 246 */                   event.getPlayer().removeMetadata(this.item, (Plugin)this.plugin);
/* 247 */                   event.getPlayer().setMetadata(this.item, (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/* 248 */                   if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP))
/* 249 */                     event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0)); 
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Armor\Boots\RabbitsFeetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */