/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Axes;
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
/* 28 */   public MeteorRainEvent(OMZP plugin) { this.item = "MeteorRain";
/*    */     this.plugin = plugin; } @EventHandler
/*    */   public void onPlayerInteract(final PlayerInteractEvent event) {
/* 31 */     if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.PHYSICAL)
/*    */     {
/* 33 */       if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 35 */         if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 37 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(event.getPlayer().getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 39 */             if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 41 */               if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type"))) {
/* 42 */                 final int spread = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Spread"));
/* 43 */                 int quantity = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Quantity"));
/* 44 */                 int delay = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Delay"));
/*    */                 
/* 46 */                 for (int i = 0; i < quantity; i++) {
/* 47 */                   (new BukkitRunnable()
/*    */                     {
/*    */                       public void run() {
/* 50 */                         Location origin = event.getPlayer().getLocation().clone();
/* 51 */                         Random randx = new Random();
/* 52 */                         Random randy = new Random();
/* 53 */                         Random randz = new Random();
/* 54 */                         int randintx = randx.nextInt(spread) - spread / 2;
/* 55 */                         int randinty = randy.nextInt(spread) - spread / 2;
/* 56 */                         int randintz = randz.nextInt(spread) - spread / 2;
/* 57 */                         origin.add(randintx, randinty, randintz);
/*    */                         
/* 59 */                         Fireball fireball = (Fireball)event.getPlayer().getWorld().spawn(origin, Fireball.class);
/* 60 */                         fireball.setDirection(new Vector(0, -1, 0));
/* 61 */                         fireball.setShooter((ProjectileSource)event.getPlayer());
/* 62 */                         fireball.setFireTicks(0);
/* 63 */                         fireball.setIsIncendiary(false);
/* 64 */                         fireball.setMetadata("MeteorRainFireball", (MetadataValue)new FixedMetadataValue((Plugin)MeteorRainEvent.this.plugin, "MeteorRain"));
/*    */                       }
/* 66 */                     }).runTaskLater((Plugin)this.plugin, (i * delay));
/*    */                 } 
/*    */                 
/* 69 */                 event.getPlayer().getInventory().setItemInMainHand(null);
/* 70 */                 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0F, 1.0F);
/* 71 */                 event.setCancelled(true);
/*    */               }  } 
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntityExplode(EntityExplodeEvent event) {
/* 81 */     if (event.getEntity() instanceof Fireball && (
/* 82 */       event.getEntity().hasMetadata("MeteorRainFireball") || event.getEntity().hasMetadata("MeteorRain")))
/* 83 */       event.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Axes\MeteorRainEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */