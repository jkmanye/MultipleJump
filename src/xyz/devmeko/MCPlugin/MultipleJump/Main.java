package xyz.devmeko.MCPlugin.MultipleJump;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.devmeko.MCPlugin.MultipleJump.Commands.RegisterCommand;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Stage.DeathBlockListener;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Stage.NextStageListener;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Stage.StageSelectListener;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Misc.RegisterListener;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Normal.InteractListener;
import xyz.devmeko.MCPlugin.MultipleJump.Listeners.Normal.JumpListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin {

    //Global Handler
    public static List<Player> registered = new ArrayList<>();

    //Tag Handler
    public static Map<Player, Integer> stage = new HashMap<>();

    //Normal Handler
    public static Map<Player, Integer> rowUse = new HashMap<>();
    public static Map<Player, Boolean> ableToJump = new HashMap<>();

    //Hold Handler
    public static Map<Player, Long> holdTimer = new HashMap<>();

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JumpListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegisterListener() , this);
        Bukkit.getPluginManager().registerEvents(new StageSelectListener() , this);
        Bukkit.getPluginManager().registerEvents(new NextStageListener() , this);
        Bukkit.getPluginManager().registerEvents(new DeathBlockListener() , this);
        getCommand("register").setExecutor(new RegisterCommand());
    }
}
