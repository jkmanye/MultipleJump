package xyz.devmeko.MCPlugin.MultipleJump.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.devmeko.MCPlugin.MultipleJump.Main;

public class RegisterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Main.registered.add((Player) commandSender);
            Main.rowUse.put((Player) commandSender, 0);
            Main.stage.put((Player) commandSender, 0);
            commandSender.sendMessage(ChatColor.GREEN + "Successfully Registered!");
            Bukkit.getConsoleSender().sendMessage(Main.registered.toString());
        } else commandSender.sendMessage(ChatColor.RED + "Only players can perform this!");

        return true;
    }
}
