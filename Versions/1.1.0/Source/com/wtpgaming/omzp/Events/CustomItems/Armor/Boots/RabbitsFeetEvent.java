/*     */ package com.wtpgaming.omzp.Events.CustomItems.Armor.Boots;
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
/*     */     this.plugin = plugin; } @EventHandler(ignoreCancelled = true)
/*     */   public void onPlayerJoin(PlayerJoinEvent event) {
/*  42 */     if (event.getPlayer().getInventory().getBoots() != null)
/*     */     {
/*  44 */       if (event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */       {
/*  46 */         if (event.getPlayer().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */         {
/*  48 */           if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */           {
/*  50 */             if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */             {
/*  52 */               if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                 
/*  54 */                 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                 
/*  56 */                 event.getPlayer().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/*  57 */                 event.getPlayer().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
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
/*  72 */     if (event.getClickedInventory().getType() == InventoryType.PLAYER)
/*     */     {
/*  74 */       if (event.getSlot() == 36)
/*     */       {
/*  76 */         if (event.getWhoClicked().getInventory().getBoots() == null) {
/*     */           
/*  78 */           if (event.getCursor() != null)
/*     */           {
/*  80 */             if (event.getCursor().hasItemMeta())
/*     */             {
/*  82 */               if (event.getCursor().getItemMeta().hasDisplayName())
/*     */               {
/*  84 */                 if (event.getCursor().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */                 {
/*  86 */                   if (event.getCursor().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/*     */                     
/*  88 */                     if (!event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP))
/*     */                     {
/*  90 */                       event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */                     }
/*     */                     
/*  93 */                     event.getWhoClicked().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/*  94 */                     event.getWhoClicked().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/* 100 */         } else if (event.getWhoClicked().getInventory().getBoots().hasItemMeta()) {
/*     */           
/* 102 */           if (event.getWhoClicked().getInventory().getBoots().getItemMeta().hasDisplayName())
/*     */           {
/* 104 */             if (event.getWhoClicked().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 106 */               if (event.getWhoClicked().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 108 */                 if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/*     */                   
/* 110 */                   if (event.getWhoClicked().hasPotionEffect(PotionEffectType.JUMP)) {
/* 111 */                     event.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
/*     */                   }
/*     */                   
/* 114 */                   event.getWhoClicked().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/* 115 */                   event.getWhoClicked().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
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
/* 127 */     event.getPlayer().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/* 128 */     event.getPlayer().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "false"));
/* 129 */     if (event.getPlayer().getInventory().getBoots() != null && 
/* 130 */       event.getPlayer().getInventory().getBoots().hasItemMeta())
/*     */     {
/* 132 */       if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getBoots().getItemMeta())).hasDisplayName())
/*     */       {
/* 134 */         if (event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */         {
/* 136 */           if (event.getPlayer().getInventory().getBoots().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 137 */             event.getPlayer().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/* 138 */             event.getPlayer().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */             
/* 140 */             int usedurability = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseDurability"));
/* 141 */             int usecooldown = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-UseCooldown")) * 1000;
/*     */             
/* 143 */             Player player = event.getPlayer();
/* 144 */             if (player.getVelocity().getY() > 0.0D) {
/* 145 */               double jumpVelocity = 0.41999998688697815D;
/* 146 */               if (player.hasPotionEffect(PotionEffectType.JUMP)) {
/* 147 */                 jumpVelocity += ((player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
/*     */               }
/* 149 */               if (event.getPlayer().getLocation().getBlock().getType() != Material.LADDER && this.prevPlayersOnGround.contains(player.getUniqueId())) {
/* 150 */                 if (this.cooldown.containsKey(event.getPlayer().getUniqueId())) {
/* 151 */                   if (((Long)this.cooldown.get(event.getPlayer().getUniqueId())).longValue() + usecooldown < System.currentTimeMillis()) {
/* 152 */                     this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                     
/* 154 */                     if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 155 */                       event.getPlayer().getInventory().setBoots(null);
/* 156 */                       event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 157 */                       if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 158 */                         event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                       }
/*     */                     } else {
/* 161 */                       ItemStack item = event.getPlayer().getInventory().getBoots();
/* 162 */                       Damageable itemMeta = (Damageable)item.getItemMeta();
/* 163 */                       itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 164 */                       item.setItemMeta((ItemMeta)itemMeta);
/*     */                     } 
/*     */                   } 
/*     */                 } else {
/*     */                   
/* 169 */                   this.cooldown.put(event.getPlayer().getUniqueId(), Long.valueOf(System.currentTimeMillis()));
/*     */                   
/* 171 */                   if (((Damageable)event.getPlayer().getInventory().getBoots().getItemMeta()).getDamage() + usedurability >= event.getPlayer().getInventory().getBoots().getType().getMaxDurability()) {
/* 172 */                     event.getPlayer().getInventory().setBoots(null);
/* 173 */                     event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 174 */                     if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 175 */                       event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */                     }
/*     */                   } else {
/* 178 */                     ItemStack item = event.getPlayer().getInventory().getBoots();
/* 179 */                     Damageable itemMeta = (Damageable)item.getItemMeta();
/* 180 */                     itemMeta.setDamage(itemMeta.getDamage() + usedurability);
/* 181 */                     item.setItemMeta((ItemMeta)itemMeta);
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/* 186 */             if (player.isOnGround()) {
/* 187 */               this.prevPlayersOnGround.add(player.getUniqueId());
/*     */             } else {
/* 189 */               this.prevPlayersOnGround.remove(player.getUniqueId());
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 197 */     if (((MetadataValue)event.getPlayer().getMetadata(this.plugin.getConfig().getString(this.item + "-Name")).get(0)).asString() == "true") {
/* 198 */       if (!event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 199 */         event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 0));
/*     */       }
/*     */     }
/* 202 */     else if (event.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
/* 203 */       event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 210 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*     */     {
/* 212 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*     */       {
/* 214 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*     */         {
/* 216 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*     */           {
/* 218 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*     */             {
/* 220 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*     */               {
/* 222 */                 if (event.getPlayer().getInventory().getBoots() == null) {
/* 223 */                   event.getPlayer().removeMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (Plugin)this.plugin);
/* 224 */                   event.getPlayer().setMetadata(this.plugin.getConfig().getString(this.item + "-Name"), (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, "true"));
/*     */                 } 
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.0.jar!\com\wtpgaming\omzp\Events\CustomItems\Armor\Boots\RabbitsFeetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */