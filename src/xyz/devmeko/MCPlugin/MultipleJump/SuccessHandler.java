package xyz.devmeko.MCPlugin.MultipleJump;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SuccessHandler {

    public static void onSuccess(Player player) {
        switch (Main.stage.get(player)) {
            case 101:
                Main.stage.remove(player);
                Main.stage.put(player, 102);
                player.teleport(new Location(player.getWorld(), 295, 5, 718));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            case 102:
                Main.stage.remove(player);
                Main.stage.put(player, 103);
                player.teleport(new Location(player.getWorld(), 285, 5, 715));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            case 103:
                Main.stage.remove(player);
                Main.stage.put(player, 104);
                player.teleport(new Location(player.getWorld(), 281, 4, 715));
//                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Stage " + Main.stage.get(player)));
                break;
            default:
                player.damage(20);
        }
    }
}
