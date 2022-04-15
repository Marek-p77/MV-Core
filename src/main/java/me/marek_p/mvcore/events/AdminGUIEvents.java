package me.marek_p.mvcore.events;

import me.marek_p.mvcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.Objects;

import static me.marek_p.mvcore.utils.TeleportUtils.generateLocation;

public class AdminGUIEvents implements Listener {

    private final Main plugin;

    public AdminGUIEvents(Main plugin) {
        this.plugin = plugin;
    }

    private final ArrayList<Player> flying_players = new ArrayList<>();

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Admin GUI")) {

            switch (Objects.requireNonNull(e.getCurrentItem()).getType()) {

                case DIAMOND:
                    player.closeInventory();
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "CREATIVE");
                    break;
                case DIAMOND_PICKAXE:
                    player.closeInventory();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "Your gamemode has been set to " + ChatColor.GREEN + "SURVIVAL");
                    break;
                case GRASS_BLOCK:
                    player.closeInventory();
                    Location location = plugin.getConfig().getLocation("spawn");
                    if (location != null){

                        player.teleport(location);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("spawn-message"))));

                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("no-spawn-message"))));
                    }
                    break;
                case GOLD_NUGGET:
                    player.closeInventory();
                    if (player.isInvulnerable()){

                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.RED + "DISABLED");
                    }else{
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "God mode has been " + ChatColor.GREEN + "ENABLED");
                    }
                    break;
                case FEATHER:
                    player.closeInventory();
                    if (flying_players.contains(player)) {

                        flying_players.remove(player);
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("disable-message"))));

                    } else {

                        flying_players.add(player);
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("enable-message"))));

                    }
                    break;
                case LEATHER_BOOTS:
                    player.closeInventory();
                    player.teleport(generateLocation(player));
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Mineverse" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + "You have been teleported to Random Location. Enjoy!");
                    break;
            }
            e.setCancelled(true);
        }
    }
}
