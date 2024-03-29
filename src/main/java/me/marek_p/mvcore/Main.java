package me.marek_p.mvcore;

import me.marek_p.mvcore.commands.*;
import me.marek_p.mvcore.events.AdminGUIEvents;
import me.marek_p.mvcore.events.JoinLeaveListener;
import me.marek_p.mvcore.events.SpawnListener;
import me.marek_p.mvcore.utils.TeleportUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Objects.requireNonNull(getCommand("god")).setExecutor(new GodCommand());
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new Gamemode());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new Gamemode());
        Objects.requireNonNull(getCommand("gmsp")).setExecutor(new Gamemode());
        Objects.requireNonNull(getCommand("gma")).setExecutor(new Gamemode());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand(this));
        Objects.requireNonNull(getCommand("setspawn")).setExecutor(new SetSpawnCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand(this));
        Objects.requireNonNull(getCommand("rtp")).setExecutor(new RandomTPCommand());
        Objects.requireNonNull(getCommand("tp")).setExecutor(new TeleportCommand());
        Objects.requireNonNull(getCommand("tpall")).setExecutor(new TeleportAllCommand());
        Objects.requireNonNull(getCommand("admin")).setExecutor(new AdminGUI());
        Objects.requireNonNull(getCommand("list")).setExecutor(new ListCommand());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("whois")).setExecutor(new WhoisCommand());
        Objects.requireNonNull(getCommand("nv")).setExecutor(new NightVisionCommand());
        Objects.requireNonNull(getCommand("haste")).setExecutor(new HasteCommand());
        Objects.requireNonNull(getCommand("day")).setExecutor(new DayNightCommands());
        Objects.requireNonNull(getCommand("night")).setExecutor(new DayNightCommands());
        Objects.requireNonNull(getCommand("test")).setExecutor(new TestCommand());

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new AdminGUIEvents(this), this);

        TeleportUtils utils = new TeleportUtils(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("[MV-Core] Plugin has been enabled");
        System.out.println("[MV-Core] ------------------------");
        System.out.println("[MV-Core] |                      |");
        System.out.println("[MV-Core] |   Author: Marek_p    |");
        System.out.println("[MV-Core] |   Version: v1.0      |");
        System.out.println("[MV-Core] |                      |");
        System.out.println("[MV-Core] ------------------------");
    }

    @Override
    public void onDisable() {
        System.out.println("[MV-Core] Plugin has been disabled");
    }
}
