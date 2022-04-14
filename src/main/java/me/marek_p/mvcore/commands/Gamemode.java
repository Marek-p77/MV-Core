package me.marek_p.mvcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (p.hasPermission("mvcore.gamemode")) {
                if (command.getName().equalsIgnoreCase("gmc")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "CREATIVE");
                } if (command.getName().equalsIgnoreCase("gms")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "SURVIVAL");
                } if (command.getName().equalsIgnoreCase("gmsp")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "SPECTATOR");
                } if (command.getName().equalsIgnoreCase("gma")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "ADVENTURE");
                }
            } else {
                p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.gamemode" + ChatColor.RED + " to execute this command!");
            }
        }
        return false;
    }
}
