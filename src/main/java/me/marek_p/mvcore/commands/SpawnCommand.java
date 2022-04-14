package me.marek_p.mvcore.commands;

import me.marek_p.mvcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been teleported to the Spawn");

            }else{
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Spawn does not exist! Use " + ChatColor.DARK_RED + "/setspawn" + ChatColor.RED + " to set the Spawn first.");
            }
        }
        return true;
    }
}
