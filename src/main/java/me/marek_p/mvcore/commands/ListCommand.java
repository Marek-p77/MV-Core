package me.marek_p.mvcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getServer;

public class ListCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            player.sendMessage(ChatColor.AQUA + "Na serveru hraje " + ChatColor.GREEN + getServer().getOnlinePlayers().size() + "/" + getServer().getMaxPlayers() + " hráčů");
        }
        return true;
    }
}
