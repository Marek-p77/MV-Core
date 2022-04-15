package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class AdminGUI implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("mvcore.admingui")) {

                Inventory gui = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Admin GUI");

                ItemStack gmc = new ItemStack(Material.DIAMOND);
                ItemMeta gmcMeta = gmc.getItemMeta();
                gmcMeta.setDisplayName(ChatColor.AQUA + "Creative Mode");
                gmc.setItemMeta(gmcMeta);

                ItemStack gms = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta gmsMeta = gms.getItemMeta();
                gmsMeta.setDisplayName(ChatColor.AQUA + "Survival Mode");
                gms.setItemMeta(gmsMeta);

                ItemStack spawn = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta spawnMeta = spawn.getItemMeta();
                spawnMeta.setDisplayName(ChatColor.AQUA + "Teleport to Spawn");
                spawn.setItemMeta(spawnMeta);

                ItemStack god = new ItemStack(Material.GOLD_NUGGET);
                ItemMeta godMeta = god.getItemMeta();
                godMeta.setDisplayName(ChatColor.AQUA + "Toggle God Mode");
                god.setItemMeta(godMeta);

                ItemStack fly = new ItemStack(Material.FEATHER);
                ItemMeta flyMeta = fly.getItemMeta();
                flyMeta.setDisplayName(ChatColor.AQUA + "Toggle Fly");
                fly.setItemMeta(flyMeta);

                ItemStack rtp = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta rtpMeta = rtp.getItemMeta();
                rtpMeta.setDisplayName(ChatColor.AQUA + "Random Teleport");
                rtp.setItemMeta(rtpMeta);


                ItemStack[] menuItems = {gmc, gms, spawn, god, fly, rtp};
                gui.setContents(menuItems);

                player.openInventory(gui);

            }
        }
        return true;
    }
}
