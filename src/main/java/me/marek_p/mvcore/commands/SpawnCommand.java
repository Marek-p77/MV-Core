package me.marek_p.mvcore.commands;

import me.marek_p.mvcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SpawnCommand implements CommandExecutor {

    private final Main plugin;

    public SpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");
            if (location != null){

                player.teleport(location);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("spawn-message"))));

            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-spawn-message"))));
            }
        }
        return true;
    }
}
