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

public class SetSpawnCommand implements CommandExecutor {

    private final Main plugin;

    public SetSpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("mvcore.setspawn")) {
                Location location = player.getLocation();

                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("set-spawn-message"))));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-set-spawn-perms"))));
            }
        }
        return true;
    }
}
