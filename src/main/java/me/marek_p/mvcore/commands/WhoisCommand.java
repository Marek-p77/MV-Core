package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WhoisCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("mvcore.whois")) {

                if (args.length == 0) {

                    player.sendMessage(ChatColor.DARK_GRAY + "----------[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "]----------");
                    player.sendMessage(ChatColor.GRAY + "Name: " + ChatColor.GREEN + "" + player.getName());
                    player.sendMessage(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "" + player.getHealth());
                    player.sendMessage(ChatColor.GRAY + "Food: " + ChatColor.GREEN + "" + player.getFoodLevel());
                    player.sendMessage(ChatColor.GRAY + "XP Level: " + ChatColor.GREEN + "" + player.getExpToLevel());

                } else {

                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;

                    try {

                        target.sendMessage(ChatColor.DARK_GRAY + "----------[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "]----------");
                        target.sendMessage(ChatColor.GRAY + "Name: " + ChatColor.GREEN + "" + player.getName());
                        target.sendMessage(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "" + player.getHealth());
                        target.sendMessage(ChatColor.GRAY + "Food: " + ChatColor.GREEN + "" + player.getFoodLevel());

                    } catch (NullPointerException exception) {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                    }
                }

            } else {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "You need permission " + ChatColor.DARK_RED + "mvcore.whois" + ChatColor.RED + " to execute this command!");
            }
        }
        return true;
    }
}
