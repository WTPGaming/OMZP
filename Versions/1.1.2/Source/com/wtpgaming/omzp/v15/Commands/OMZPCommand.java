/*    */ package com.wtpgaming.omzp.v15.Commands;
/*    */ 
/*    */ import com.wtpgaming.omzp.OMZP;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class OMZPCommand implements Listener, CommandExecutor {
/*    */   OMZP plugin;
/*    */   
/*    */   public OMZPCommand(OMZP plugin) {
/* 19 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 24 */     if (sender instanceof Player) {
/* 25 */       Player player = (Player)sender;
/* 26 */       if (args.length >= 1 && player.hasPermission("OMZP")) {
/* 27 */         if (args[0].equalsIgnoreCase("list")) {
/* 28 */           String[] ItemList = this.plugin.getConfig().getString("ItemList").split(",", -1);
/* 29 */           for (String item : ItemList) {
/* 30 */             String name = this.plugin.getConfig().getString(item + "-Name");
/* 31 */             String desc = this.plugin.getConfig().getString(item + "-Description");
/* 32 */             Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "tellraw " + player.getName() + " {\"text\":\"" + name + "\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/OMZP give " + item + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + desc + "\"}}");
/*    */           } 
/* 34 */         } else if (args[0].equalsIgnoreCase("help")) {
/* 35 */           player.sendMessage(ChatColor.BOLD + "Work in progress\n/OMZP give <ItemIdentifier>\n/OMZP list *Clickable GUI*\n/OMZP Help");
/* 36 */         } else if (args[0].equalsIgnoreCase("give")) {
/* 37 */           if (args.length > 2) {
/* 38 */             if (Bukkit.getServer().getPlayer(args[1]) != null) {
/*    */               try {
/* 40 */                 player.sendMessage("0");
/* 41 */                 String arg = args[2];
/* 42 */                 player.sendMessage("1");
/* 43 */                 ItemStack item = new ItemStack(Material.getMaterial(this.plugin.getConfig().getString(arg + "-Type")), 1);
/* 44 */                 player.sendMessage("2");
/* 45 */                 ItemMeta meta = item.getItemMeta();
/* 46 */                 player.sendMessage("3");
/* 47 */                 meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(arg + "-Name")));
/* 48 */                 player.sendMessage("4");
/* 49 */                 item.setItemMeta(meta);
/* 50 */                 player.sendMessage("5");
/* 51 */                 player.getInventory().addItem(new ItemStack[] { item });
/* 52 */                 player.sendMessage("6");
/* 53 */               } catch (IllegalArgumentException e) {
/* 54 */                 player.sendMessage("The item identifier " + args[2] + " does not exist");
/*    */               } 
/*    */             } else {
/* 57 */               player.sendMessage("The player " + args[1] + "does not exist");
/*    */             } 
/*    */           } else {
/*    */             try {
/* 61 */               String arg = args[1];
/* 62 */               ItemStack item = new ItemStack(Material.getMaterial(this.plugin.getConfig().getString(arg + "-Type")), 1);
/* 63 */               ItemMeta meta = item.getItemMeta();
/* 64 */               meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(arg + "-Name")));
/* 65 */               item.setItemMeta(meta);
/* 66 */               player.getInventory().addItem(new ItemStack[] { item });
/* 67 */             } catch (IllegalArgumentException e) {
/* 68 */               player.sendMessage("The item identifier " + args[1] + " does not exist");
/*    */             } 
/*    */           } 
/*    */         } else {
/* 72 */           player.sendMessage("The command " + args[0] + " does not exist");
/*    */         } 
/*    */       }
/*    */     } 
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.1.2.jar!\com\wtpgaming\omzp\v15\Commands\OMZPCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */