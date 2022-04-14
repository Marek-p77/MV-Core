package me.marek_p.mvcore.utils;

import me.marek_p.mvcore.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class TeleportUtils {

    static Main plugin;

    public TeleportUtils(Main plugin) {
        TeleportUtils.plugin = plugin;
    }

    public static HashSet<Material> unsafeBlocks = new HashSet<>();

    static{
        unsafeBlocks.add(Material.LAVA);
        unsafeBlocks.add(Material.FIRE);
        unsafeBlocks.add(Material.WATER);
        unsafeBlocks.add(Material.CACTUS);
        unsafeBlocks.add(Material.MAGMA_BLOCK);
        unsafeBlocks.add(Material.VOID_AIR);
    }

    public static Location generateLocation(Player player) {

        Random random = new Random();

        int x = random.nextInt(plugin.getConfig().getInt("rtp-border"));
        int y = 150;
        int z = random.nextInt(plugin.getConfig().getInt("rtp-border"));

        Location randomLocation = new Location(player.getWorld(), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);

        while (!isLocationSafe(randomLocation)) {
            randomLocation = generateLocation(player);
        }
        return randomLocation;

    }
    public static boolean isLocationSafe(Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);

        return !(unsafeBlocks.contains(below) || (block.getType().isSolid()) || (above.getType().isSolid()));

    }
}

