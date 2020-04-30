/*    */ package com.wtpgaming.omzp.Commands;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class OMZPCommand implements CommandExecutor {
/*    */   OMZP plugin;
/*    */   
/*    */   public OMZPCommand(OMZP plugin) {
/* 18 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 23 */     if (sender instanceof Player) {
/* 24 */       Player player = (Player)sender;
/* 25 */       if (args.length >= 1 && player.hasPermission("OMZP.GiveWeapon")) {
/* 26 */         if (args[0].equalsIgnoreCase("list")) {
/* 27 */           String[] ItemList = this.plugin.getConfig().getString("ItemList").split(",", -1);
/* 28 */           for (String item : ItemList) {
/* 29 */             String name = this.plugin.getConfig().getString(item + "-Name");
/* 30 */             String desc = this.plugin.getConfig().getString(item + "-Description");
/* 31 */             Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tellraw " + player.getName() + " {\"text\":\"" + name + "\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/OMZP give " + item + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + desc + "\"}}");
/*    */           } 
/* 33 */         } else if (args[0].equalsIgnoreCase("help")) {
/* 34 */           player.sendMessage(ChatColor.BOLD + "Work in progress\n/OMZP give <ItemIdentifier>\n/OMZP list *Clickable GUI*\n/OMZP Help");
/* 35 */         } else if (args[0].equalsIgnoreCase("give")) {
/*    */           try {
/* 37 */             String arg = args[1];
/* 38 */             ItemStack item = new ItemStack(Material.getMaterial(this.plugin.getConfig().getString(arg + "-Type")), 1);
/* 39 */             ItemMeta meta = item.getItemMeta();
/* 40 */             meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(arg + "-Name")));
/* 41 */             item.setItemMeta(meta);
/* 42 */             player.getInventory().addItem(new ItemStack[] { item });
/* 43 */           } catch (IllegalArgumentException e) {
/* 44 */             player.sendMessage("Invalid item identifier.");
/*    */           } 
/*    */         } else {
/* 47 */           player.sendMessage("The Item " + args[1] + " Does Not Exist.");
/*    */         } 
/*    */       }
/*    */     } 
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.2.jar!\com\wtpgaming\omzp\Commands\OMZPCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */