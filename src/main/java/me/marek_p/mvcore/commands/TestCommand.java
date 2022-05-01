package me.marek_p.mvcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sun.jvm.hotspot.oops.Metadata;

import java.util.Objects;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Entity entity = Objects.requireNonNull(Bukkit.getWorld("world")).spawnEntity(player.getLocation(), EntityType.CAVE_SPIDER);
            Creeper creeper = (Creeper) Objects.requireNonNull(Bukkit.getWorld("world")).spawnEntity(player.getLocation(), EntityType.CREEPER);

            entity.addPassenger(creeper);
            creeper.setPowered(true);
            creeper.setFuseTicks(0);

            player.sendMessage("Bye");

        }
        return true;
    }
}
