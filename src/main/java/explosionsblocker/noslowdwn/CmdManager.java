package explosionsblocker.noslowdwn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static explosionsblocker.noslowdwn.ExplosionsBlocker.instance;

public final class CmdManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player && !sender.hasPermission("explosionsblocker.reload")) {
            sender.sendMessage(ColorsUtil.of(instance.getConfig().getString("messages.no-permission")));
            return true;
        } else {
            instance.reloadConfig();
            sender.sendMessage(ColorsUtil.of(instance.getConfig().getString("messages.reload-message")));
        }

        return true;
    }
}