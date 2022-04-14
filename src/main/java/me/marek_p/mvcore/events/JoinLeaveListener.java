package me.marek_p.mvcore.events;

import me.marek_p.mvcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class JoinLeaveListener implements Listener {

    private final Main plugin;

    public JoinLeaveListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("leave-message-prefix"))) + ChatColor.AQUA + player.getDisplayName() + ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("leave-message"))));

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("join-message-prefix"))) + ChatColor.AQUA + player.getDisplayName() + ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("join-message"))));

    }
}
