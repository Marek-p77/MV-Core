package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("mvcore.heal")) {

                if (args.length == 0) {

                    player.setHealth(20);
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been healed");

                } else if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;

                    try {

                        target.setHealth(20);
                        target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been healed by " + ChatColor.GREEN + "" + player.getName());
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been healed");

                    } catch (NullPointerException exception) {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                    }

                }

            } else {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "You need permission " + ChatColor.DARK_RED + "mvcore.heal" + ChatColor.RED + " to execute this command!");
            }
        }
        return true;
    }
}
