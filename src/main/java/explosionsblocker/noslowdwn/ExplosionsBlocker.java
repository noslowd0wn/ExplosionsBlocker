package explosionsblocker.noslowdwn;

import explosionsblocker.noslowdwn.events.EntitiesDamage;
import explosionsblocker.noslowdwn.events.Explosions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ExplosionsBlocker extends JavaPlugin {

    public static ExplosionsBlocker instance;

    @Override
    public void onEnable() {
        instance = this;
        load();

        this.getCommand("exblocker").setExecutor(new CmdManager());
        this.getServer().getPluginManager().registerEvents(new EntitiesDamage(), this);
        this.getServer().getPluginManager().registerEvents(new Explosions(), this);
    }

    private void load() {
        File file = new File(this.getDataFolder(), "config.yml");

        if (!file.exists())
            this.saveResource("config.yml", false);

        YamlConfiguration config = new YamlConfiguration();

        try {
            config.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
