package explosionsblocker.noslowdwn.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import static explosionsblocker.noslowdwn.ExplosionsBlocker.instance;

public class Explosions implements Listener {

    @EventHandler
    public void explosions(EntityExplodeEvent e) {
        Entity entity = e.getEntity();
        World world = e.getEntity().getWorld();

        if (entity instanceof Creeper) {
            if (instance.getConfig().getBoolean("settings.creeper.block-explosion")) {
                if (instance.getConfig().getStringList("settings.creeper.blocked-worlds").isEmpty()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Creeper explosion wasn't canceled because the list of blocked-worlds is empty");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
                } else {
                    for (String bWorld : instance.getConfig().getStringList("settings.creeper.blocked-worlds"))
                        if (world.getName().equals(bWorld))
                            e.setCancelled(true);
                }
            }

            if (instance.getConfig().getBoolean("settings.creeper.effect"))
                world.spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 0);

            if (instance.getConfig().getBoolean("settings.creeper.sound"))
                world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }

        if (entity instanceof TNTPrimed) {
            if (instance.getConfig().getBoolean("settings.tnt.block-explosion")) {
                if (instance.getConfig().getStringList("settings.tnt.blocked-worlds").isEmpty()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Tnt explosion wasn't canceled because the list of blocked-worlds is empty");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
                } else {
                    for (String bWorld : instance.getConfig().getStringList("settings.tnt.blocked-worlds"))
                        if (world.getName().equals(bWorld))
                            e.setCancelled(true);
                }
            }

            if (instance.getConfig().getBoolean("settings.tnt.effect"))
                world.spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 0);

            if (instance.getConfig().getBoolean("settings.tnt.sound"))
                world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }

        if (entity instanceof org.bukkit.entity.minecart.ExplosiveMinecart) {
            if (instance.getConfig().getBoolean("settings.tnt-in-cart.block-explosion")) {
                if (instance.getConfig().getStringList("settings.tnt-in-cart.blocked-worlds").isEmpty()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Tnt in cart explosion wasn't canceled because the list of blocked-worlds is empty");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
                } else {
                    for (String bWorld : instance.getConfig().getStringList("settings.tnt-in-cart.blocked-worlds"))
                        if (world.getName().equals(bWorld))
                            e.setCancelled(true);
                }
            }

            if (instance.getConfig().getBoolean("settings.tnt-in-cart.effect"))
                world.spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 0);

            if (instance.getConfig().getBoolean("settings.tnt-in-cart.sound"))
                world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }

        if (entity instanceof Wither) {
            if (instance.getConfig().getBoolean("settings.wither-activate.block-explosion")) {
                if (instance.getConfig().getStringList("settings.wither-activate.blocked-worlds").isEmpty()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Wither activate explosion wasn't canceled because the list of blocked-worlds is empty");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
                } else {
                    for (String bWorld : instance.getConfig().getStringList("settings.wither-heads.blocked-worlds"))
                        if (world.getName().equals(bWorld))
                            e.setCancelled(true);
                }
            }

            if (instance.getConfig().getBoolean("settings.wither-activate.effect"))
                world.spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 0);

            if (instance.getConfig().getBoolean("settings.wither-activate.sound"))
                world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }

        if (entity instanceof WitherSkull) {
            if (instance.getConfig().getBoolean("settings.wither-heads.block-explosion")) {
                if (instance.getConfig().getStringList("settings.wither-activate.blocked-worlds").isEmpty()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Wither skull explosion wasn't canceled because the list of blocked-worlds is empty");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
                } else {
                    for (String bWorld : instance.getConfig().getStringList("settings.wither-heads.blocked-worlds"))
                        if (world.getName().equals(bWorld))
                            e.setCancelled(true);
                }
            }

            if (instance.getConfig().getBoolean("settings.wither-heads.effect"))
                world.spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 0);

            if (instance.getConfig().getBoolean("settings.wither-heads.sound"))
                world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }
    }

    @EventHandler
    public void witherBlockBreak(EntityChangeBlockEvent e) {
        EntityType entity = e.getEntity().getType();
        World world = e.getEntity().getWorld();

        if (entity == EntityType.WITHER && instance.getConfig().getBoolean("settings.wither.block-blocks-breaking")) {
            if (instance.getConfig().getStringList("settings.wither.blocked-worlds").isEmpty()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Wither blocks breaking wasn't canceled because the list of blocked-worlds is empty");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ExplosionsBlocker] Please check your configuration file");
            } else {
                for (String bWorld : instance.getConfig().getStringList("settings.wither.blocked-worlds"))
                    if (world.getName().equals(bWorld))
                        e.setCancelled(true);
            }
        }
    }
}
