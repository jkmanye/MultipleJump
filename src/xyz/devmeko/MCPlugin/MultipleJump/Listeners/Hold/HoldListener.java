package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Hold;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import xyz.devmeko.MCPlugin.MultipleJump.Main;

public class HoldListener implements Listener {

    @EventHandler
    public void onPlayerHold(PlayerInteractEvent e) {
        long currTime = System.currentTimeMillis();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) ||  e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (!Main.holdTimer.containsKey(e.getPlayer())) Main.holdTimer.put(e.getPlayer(), currTime);
            Main.holdTimer.remove(e.getPlayer());
            Main.holdTimer.put(e.getPlayer(), currTime);

            long lastClick = Main.holdTimer.get(e.getPlayer());
            if (currTime - lastClick > 250) {
                Main.holdTimer.remove(e.getPlayer());
                e.getPlayer().sendMessage("You were taken out from arming with time of " + (currTime - lastClick));
            } else {
                e.getPlayer().sendMessage("Surviving with a time of" + (currTime - lastClick));
                Main.holdTimer.put(e.getPlayer(), currTime);
            }
        }
    }
}
