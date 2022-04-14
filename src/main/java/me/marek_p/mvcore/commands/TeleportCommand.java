package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Usage: /tp <player> or /tp <player> <player>");

            } else if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (player.hasPermission("mvcore.tp")) {

                    try {

                        player.teleport(target.getLocation());
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + target.getName());

                    } catch (NullPointerException exception) {

                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");

                    }
                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.tp" + ChatColor.RED + " to execute this command!");
                }
            } else if (args.length == 2) {

                Player player1 = Bukkit.getPlayer(args[0]);
                Player player2 = Bukkit.getPlayer(args[1]);

                if (player.hasPermission("mvcore.tpothers")) {

                    try {

                        player1.teleport(player2.getLocation());

                        player1.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + player2.getName());
                        player2.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + player2.getName() + ChatColor.GRAY + " has teleported to you");

                    } catch (NullPointerException exception) {

                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");

                    }
                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.tpothers" + ChatColor.RED + " to execute this command!");
                }
            }
        }
        return false;
    }
}
