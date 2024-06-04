package explosionsblocker.noslowdwn.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static explosionsblocker.noslowdwn.ExplosionsBlocker.instance;

public class EntitiesDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        World world = e.getDamager().getWorld();

        if (e.getDamager().getType() == EntityType.CREEPER && instance.getConfig().getBoolean("settings.creeper.block-damage")) {
            if (instance.getConfig().getStringList("settings.creeper.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Creeper damage wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.creeper.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }

        if (e.getDamager().getType() == EntityType.PRIMED_TNT && instance.getConfig().getBoolean("settings.tnt.block-damage")) {
            if (instance.getConfig().getStringList("settings.tnt.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Tnt damage wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.tnt.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }

        if (e.getDamager().getType() == EntityType.MINECART_TNT && instance.getConfig().getBoolean("settings.tnt-in-cart.block-damage")) {
            if (instance.getConfig().getStringList("settings.tnt-in-cart.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Minecart tnt damage wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.tnt-in-cart.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }

        if (e.getDamager().getType() == EntityType.WITHER && instance.getConfig().getBoolean("settings.wither.block-damage")) {
            if (instance.getConfig().getStringList("settings.wither.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Wither damage wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.wither-heads.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }

        if (e.getDamager().getType() == EntityType.WITHER_SKULL && instance.getConfig().getBoolean("settings.wither-heads.block-damage")) {
            if (instance.getConfig().getStringList("settings.wither-heads.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Wither heads damage wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.wither-heads.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }
    }
}
