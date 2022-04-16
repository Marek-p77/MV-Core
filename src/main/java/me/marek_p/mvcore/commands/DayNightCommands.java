package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DayNightCommands implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("day")) {

                if (player.hasPermission("mvcore.day")) {

                    player.getLocation().getWorld().setTime(0);
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Time has been set to " + ChatColor.GREEN + "DAY");

                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.day" + ChatColor.RED + " to execute this command!");
                }

            } else if (command.getName().equalsIgnoreCase("night")) {

                if (player.hasPermission("mvcore.night")) {

                    player.getLocation().getWorld().setTime(13000);
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Time has been set to " + ChatColor.GREEN + "NIGHT");

                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.night" + ChatColor.RED + " to execute this command!");
                }

            }

        }

        return true;
    }
}
