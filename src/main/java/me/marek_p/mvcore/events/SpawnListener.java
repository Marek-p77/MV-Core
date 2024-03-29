package me.marek_p.mvcore.events;

import me.marek_p.mvcore.Main;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private final Main plugin;

    public SpawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (!event.getPlayer().hasPlayedBefore()) {

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                event.getPlayer().teleport(location);

            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent event) {

        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null){

            event.setRespawnLocation(location);

        }
    }
}
