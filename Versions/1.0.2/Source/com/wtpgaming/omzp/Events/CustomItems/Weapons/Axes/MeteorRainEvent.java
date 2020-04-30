/*    */ package com.wtpgaming.omzp.Events.CustomItems.Weapons.Axes;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Fireball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityExplodeEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.metadata.FixedMetadataValue;
/*    */ import org.bukkit.metadata.MetadataValue;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.projectiles.ProjectileSource;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class MeteorRainEvent implements Listener {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public MeteorRainEvent(OMZP plugin) {
/* 29 */     this.item = "MeteorRain";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(final PlayerInteractEvent event) {
/* 32 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 34 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 36 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 38 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 40 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 42 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 43 */                 final int spread = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Spread"));
/* 44 */                 int quantity = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Quantity"));
/* 45 */                 int delay = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Delay"));
/*    */                 
/* 47 */                 for (int i = 0; i < quantity; i++) {
/* 48 */                   (new BukkitRunnable()
/*    */                     {
/*    */                       public void run() {
/* 51 */                         Location origin = event.getPlayer().getLocation().clone();
/* 52 */                         Random randx = new Random();
/* 53 */                         Random randy = new Random();
/* 54 */                         Random randz = new Random();
/* 55 */                         int randintx = randx.nextInt(spread) - spread / 2;
/* 56 */                         int randinty = randy.nextInt(spread) - spread / 2;
/* 57 */                         int randintz = randz.nextInt(spread) - spread / 2;
/* 58 */                         origin.add(randintx, randinty, randintz);
/*    */                         
/* 60 */                         Fireball fireball = (Fireball)event.getPlayer().getWorld().spawn(origin, Fireball.class);
/* 61 */                         fireball.setDirection(new Vector(0, -1, 0));
/* 62 */                         fireball.setShooter((ProjectileSource)event.getPlayer());
/* 63 */                         fireball.setFireTicks(0);
/* 64 */                         fireball.setIsIncendiary(false);
/* 65 */                         fireball.setMetadata("MeteorRainFireball", (MetadataValue)new FixedMetadataValue((Plugin)MeteorRainEvent.this.plugin, "MeteorRain"));
/*    */                       }
/* 67 */                     }).runTaskLater((Plugin)this.plugin, (i * delay));
/*    */                 } 
/*    */                 
/* 70 */                 event.getPlayer().getInventory().setItemInMainHand(null);
/* 71 */                 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 72 */                 event.setCancelled(true);
/*    */               }  } 
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntityExplode(EntityExplodeEvent event) {
/* 82 */     if (event.getEntity() instanceof Fireball && (
/* 83 */       event.getEntity().hasMetadata("MeteorRainFireball") || event.getEntity().hasMetadata("MeteorRain")))
/* 84 */       event.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Events\CustomItems\Weapons\Axes\MeteorRainEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */