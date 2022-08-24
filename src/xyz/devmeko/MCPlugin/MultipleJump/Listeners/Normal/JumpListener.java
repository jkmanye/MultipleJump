package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Normal;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import xyz.devmeko.MCPlugin.MultipleJump.Main;

public class JumpListener implements Listener {

    @EventHandler
    public void onPlayerJump(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Vector velocity = player.getVelocity();
        if (velocity.getY() > 0)
        {
            double jumpVelocity = 0.42F;

            if (player.getLocation().getBlock().getType() != Material.LADDER && Double.compare(velocity.getY(), jumpVelocity) == 0 && Main.registered.contains(player)) {
                Main.ableToJump.remove(player);
                Main.ableToJump.put(player, true);
            }
        }
    }
}
