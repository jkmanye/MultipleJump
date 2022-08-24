package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Misc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RegisterListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().performCommand("register " + event.getPlayer().getName());
    }
}
