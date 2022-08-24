package xyz.devmeko.MCPlugin.MultipleJump.Listeners.Stage;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import xyz.devmeko.MCPlugin.MultipleJump.Main;

public class StageSelectListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        //Stage 1
        Location stageOne = new Location(Bukkit.getWorlds().get(0), 404, 4, 524);
        if (player.getLocation().getBlock().getLocation().equals(stageOne)) {
            Main.stage.remove(player);
            Main.stage.put(player, 101);
            player.teleport(new Location(player.getWorld(), 308, 5, 718));
//            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
        }
    }
}
