package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Normal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import xyz.devmeko.MCPlugin.MultipleJump.Main;

public class InteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getPlayer().getItemInHand().getType().equals(Material.DIAMOND)) {
                if (Main.ableToJump.get(event.getPlayer())) {
                    if (Main.rowUse.get(event.getPlayer()) <= 3) {
                        Player player = event.getPlayer();
                        player.setVelocity(player.getVelocity().setY(0.78));
                        int backup = Main.rowUse.get(player) + 1;
                        Main.rowUse.remove(player);
                        Main.rowUse.put(player, backup);
                        new Thread(() -> {
                            try {
                                Thread.sleep(2400);
                                int backupTwo = Main.rowUse.get(player) - 1;
                                Main.rowUse.remove(player);
                                Main.rowUse.put(player, backupTwo);
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }).start();
                    } else {
                        event.getPlayer().sendMessage(ChatColor.RED + "Jump Abuse Detected!");
                        new Thread(() -> {
                            try {
                                Thread.sleep(3000);
                                Main.rowUse.remove(event.getPlayer());
                                Main.rowUse.put(event.getPlayer(), 0);
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }).start();
                    }
                }
            }
         }
    }
}
