/*    */ package com.wtpgaming.omzp.v15.Events.CustomItems.Weapons.Swords;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class RobbersBladeEvent
/*    */   implements Listener
/*    */ {
/*    */   OMZP plugin;
/*    */   String item;
/*    */   
/*    */   public RobbersBladeEvent(OMZP plugin) {
/* 24 */     this.item = "RobbersBlade";
/*    */     this.plugin = plugin;
/*    */   } @EventHandler(ignoreCancelled = true)
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
/* 28 */     if (event.getDamager() instanceof Player) {
/* 29 */       Player attacker = (Player)event.getDamager();
/*    */       
/* 31 */       if (attacker.getInventory().getItemInMainHand().getType() != Material.AIR)
/*    */       {
/* 33 */         if (attacker.getInventory().getItemInMainHand().hasItemMeta())
/*    */         {
/* 35 */           if (((ItemMeta)Objects.<ItemMeta>requireNonNull(attacker.getInventory().getItemInMainHand().getItemMeta())).hasDisplayName())
/*    */           {
/* 37 */             if (attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(this.item + "-Name"))))
/*    */             {
/* 39 */               if (attacker.getInventory().getItemInMainHand().getType() == Material.getMaterial(this.plugin.getConfig().getString(this.item + "-Type")))
/*    */               {
/* 41 */                 if (event.getEntity() instanceof Player) {
/* 42 */                   int damage = Integer.parseInt(this.plugin.getConfig().getString(this.item + "-Damage"));
/* 43 */                   String successmessage = this.plugin.getConfig().getString(this.item + "-SuccessMessage");
/* 44 */                   String faliuremessage = this.plugin.getConfig().getString(this.item + "-FailureMessage");
/* 45 */                   event.setDamage(damage);
/*    */                   
/* 47 */                   Random r = new Random();
/* 48 */                   ArrayList<ItemStack> items = new ArrayList<>();
/*    */                   
/* 50 */                   for (ItemStack item : ((Player)event.getEntity()).getInventory().getContents()) {
/* 51 */                     if (item != null) {
/* 52 */                       items.add(item);
/*    */                     }
/*    */                   } 
/* 55 */                   if (items.size() > 0) {
/* 56 */                     ItemStack stolenitem = items.get(r.nextInt(items.size()));
/* 57 */                     ((Player)event.getEntity()).getInventory().remove(stolenitem);
/* 58 */                     attacker.getInventory().addItem(new ItemStack[] { stolenitem });
/* 59 */                     ((Player)event.getEntity()).sendMessage(successmessage);
/*    */                   } else {
/* 61 */                     attacker.sendMessage(faliuremessage + event.getEntity().getName());
/*    */                   } 
/*    */                 } 
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Events\CustomItems\Weapons\Swords\RobbersBladeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */