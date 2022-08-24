package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Stage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import xyz.devmeko.MCPlugin.MultipleJump.Main;
import xyz.devmeko.MCPlugin.MultipleJump.SuccessHandler;

public class NextStageListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getBlock().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.EMERALD_BLOCK)) {
            SuccessHandler.onSuccess(player);
        }
    }
}
