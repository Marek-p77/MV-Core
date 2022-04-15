package me.marek_p.mvcore.commands;

import me.marek_p.mvcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class FlyCommand implements CommandExecutor {

    private final ArrayList<Player> flying_players = new ArrayList<>();
    private final Main plugin;

    public FlyCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                if (player.hasPermission("mvcore.fly")) {

                    if (flying_players.contains(player)) {

                        flying_players.remove(player);
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("disable-message"))));

                    } else {

                        flying_players.add(player);
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("enable-message"))));

                    }

                } else {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-perm-fly"))));

                }
            } else if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);
                assert target != null;

                if (player.hasPermission("mvcore.flyothers")) {

                    try {

                        if (flying_players.contains(target)) {

                            flying_players.remove(target);

                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Fly has been " + ChatColor.RED + "DISABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Fly for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.RED + "DISABLED");

                        } else if (!flying_players.contains(target)) {

                            flying_players.add(target);

                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Fly has been " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " by " + ChatColor.GREEN + "" + player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Fly for Player " + ChatColor.GREEN + "" + target.getName() + ChatColor.GRAY + " has been " + ChatColor.GREEN + "ENABLED");

                        }

                    } catch (NullPointerException exception) {
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Player not found!");
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-perm-others"))));
                }
            }
        }
        return true;
    }
}
