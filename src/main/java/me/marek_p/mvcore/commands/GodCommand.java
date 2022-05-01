package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("mvcore.god")) {

                if (args.length == 0) {

                    if (player.isInvulnerable()){

                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.RED + "DISABLED");

                    }else{

                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.GREEN + "ENABLED");

                    }
                } else if (args.length == 1) {

                    if (player.hasPermission("mvcore.godothers")) {

                        Player target = Bukkit.getPlayer(args[0]);
                        assert target != null;

                        try {

                            if (target.isInvulnerable()){

                                target.setInvulnerable(false);
                                target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.RED + "DISABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.RED + "DISABLED");

                            }else{

                                target.setInvulnerable(true);
                                target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.GREEN + "ENABLED");

                            }

                        } catch (NullPointerException exception) {
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                        }

                    } else {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "You need permission " + ChatColor.DARK_RED + "mvcore.godothers" + ChatColor.RED + " to execute this command!");
                    }
                }
            } else {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "You need permission " + ChatColor.DARK_RED + "mvcore.god" + ChatColor.RED + " to execute this command!");
            }
        }
        return false;
    }
}
