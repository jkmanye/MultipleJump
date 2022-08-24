package xyz.devmeko.MCPlugin.MultipleJump;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FailHandler {

    public static void onFail(Player player) {
        switch (Main.stage.get(player)) {
            case 101:
                player.teleport(new Location(player.getWorld(), 308, 5, 718));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            case 102:
                player.teleport(new Location(player.getWorld(), 295, 5, 718));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            case 103:
                player.teleport(new Location(player.getWorld(), 285, 5, 715));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            case 104:
                player.teleport(new Location(player.getWorld(), 281, 4, 715, 90, 0));
                break;
            default:
                player.damage(20);
        }
    }
}
