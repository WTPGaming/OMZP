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
/*    */           try {
/* 38 */             String arg = args[1];
/* 39 */             ItemStack item = new ItemStack(Material.getMaterial(this.plugin.getConfig().getString(arg + "-Type")), 1);
/* 40 */             ItemMeta meta = item.getItemMeta();
/* 41 */             meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString(arg + "-Name")));
/* 42 */             item.setItemMeta(meta);
/* 43 */             player.getInventory().addItem(new ItemStack[] { item });
/* 44 */           } catch (IllegalArgumentException e) {
/* 45 */             player.sendMessage("Invalid item identifier.");
/*    */           } 
/*    */         } else {
/* 48 */           player.sendMessage("Invalid command identifier.");
/*    */         } 
/*    */       }
/*    */     } 
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Austin\Downloads\OMZP-1.0.3.jar!\com\wtpgaming\omzp\Commands\OMZPCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */