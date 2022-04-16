package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class NightVisionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                if (player.hasPermission("mvcore.nightvision")) {

                    if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {

                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision has been " + ChatColor.RED + "DISABLED");

                    } else {

                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 255, true));
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision has been " + ChatColor.GREEN + "ENABLED");

                    }
                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.nightvision" + ChatColor.RED + " to execute this command!");
                }

            } else if (args.length == 1) {

                if (player.hasPermission("mvcore.nightvisionothers")) {

                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;

                    try {

                        if (target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {

                            target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision has been " + ChatColor.RED + "DISABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.RED + "DISABLED");

                        } else {

                            target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 255, true));
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision has been " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Night Vision for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.GREEN + "ENABLED");

                        }

                    } catch (NullPointerException exception) {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                    }

                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Youd need permission " + ChatColor.DARK_RED + "mvcore.nightvisionothers" + ChatColor.RED + " to execute this command!");
                }
            }
        }
        return true;
    }
}
