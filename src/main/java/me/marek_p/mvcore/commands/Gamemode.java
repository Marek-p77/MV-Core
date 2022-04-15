package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
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

            Player player = (Player) sender;

            if (args.length == 0) {

                if (command.getName().equalsIgnoreCase("gmc")) {

                    if (player.hasPermission("mvcore.gmc")) {

                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "CREATIVE");

                    } else {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.gmc" + ChatColor.RED + " to execute this command!");
                    }

                } else if (command.getName().equalsIgnoreCase("gms")) {

                    if (player.hasPermission("mvcore.gms")) {

                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "SURVIVAL");

                    } else {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.gms" + ChatColor.RED + " to execute this command!");
                    }

                } else if (command.getName().equalsIgnoreCase("gmsp")) {

                    if (player.hasPermission("mvcore.gmsp")) {

                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "SPECTATOR");

                    } else {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.gmsp" + ChatColor.RED + " to execute this command!");
                    }

                } else if (command.getName().equalsIgnoreCase("gma")) {

                    if (player.hasPermission("mvcore.gma")) {

                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "ADVENTURE");

                    } else {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.gma" + ChatColor.RED + " to execute this command!");
                    }
                }
            } else if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);
                assert target != null;

                try {

                    if (player.hasPermission("mvcore.gmothers")) {

                        if (command.getName().equalsIgnoreCase("gmc")) {

                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your GameMode has been set to " + ChatColor.GREEN + "CREATIVE" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "GameMode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been set to " + ChatColor.GREEN + "CREATIVE");

                        } else if (command.getName().equalsIgnoreCase("gms")) {

                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your GameMode has been set to " + ChatColor.GREEN + "SURVIVAL" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "GameMode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been set to " + ChatColor.GREEN + "SURVIVAL");

                        } else if (command.getName().equalsIgnoreCase("gmsp")) {

                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your GameMode has been set to " + ChatColor.GREEN + "SPECTATOR" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "GameMode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been set to " + ChatColor.GREEN + "SPECTATOR");

                        } else if (command.getName().equalsIgnoreCase("gma")) {

                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your GameMode has been set to " + ChatColor.GREEN + "ADVENTURE" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "GameMode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been set to " + ChatColor.GREEN + "ADVENTURE");

                        }
                    }

                } catch (NullPointerException exception) {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                }

            }
        }
        return true;
    }
}
