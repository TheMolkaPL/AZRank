package pl.azpal.azrank;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Cfg {
	private AZRank plugin;
	protected final YamlConfiguration config = new YamlConfiguration();
	
	public String message = "+player is now a(n) +group for+time";
	public String aWhile = " a while";
	public String ever =  "ever";
	public boolean broadcastRankChange = true;
	public boolean allowOpsChanges = true;
	public boolean logEverything = false;
	
	protected Cfg(AZRank plugin) {
        this.plugin = plugin;
    }

    protected boolean loadConfig() {
        try {
			config.load(plugin.yml);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

    	message = config.getString("message", message);
    	aWhile = config.getString("aWhile", aWhile);
    	ever =  config.getString("ever", ever);
    	broadcastRankChange = config.getBoolean("broadcastRankChange", broadcastRankChange);
    	allowOpsChanges = config.getBoolean("allowOpsChanges", allowOpsChanges);
        logEverything = config.getBoolean("logEverything", logEverything);
        
        plugin.log.info("[AZRank][Config]option: 'message' is: " + message);
        plugin.log.info("[AZRank][Config]option: 'aWhile' is: " + aWhile);
        plugin.log.info("[AZRank][Config]option: 'ever' is: " + ever);
        plugin.log.info("[AZRank][Config]option: 'broadcastRankChange' is: " + broadcastRankChange);
        plugin.log.info("[AZRank][Config]option: 'allowOpsChanges' is: " + allowOpsChanges);
        plugin.log.info("[AZRank][Config]option: 'logEverything' is: " + logEverything);
        return true;
    }

    protected void defaultConfig() {    	
    	config.set("message", message);
    	config.set("aWhile", aWhile);
    	config.set("ever", ever);
    	config.set("broadcastRankChange", broadcastRankChange);
    	config.set("allowOpsChanges", allowOpsChanges);
        config.set("logEverything", logEverything);

        try {
			config.save(plugin.yml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    protected void checkConfig() {
    	plugin.debugmsg("Checking CFG");
        try {
			config.load(plugin.yml);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
        boolean hasChanged=false;
        if (config.get("message") == null) {
            config.set("message", message);
            hasChanged = true;
            plugin.debugmsg("Fixing 'message' in cfg");}
        if (config.get("aWhile") == null) {
            config.set("aWhile", aWhile);
            hasChanged = true;
            plugin.debugmsg("Fixing 'a while' in cfg");}
        if (config.get("ever") == null) {
            config.set("ever", ever);
            hasChanged = true;
            plugin.debugmsg("Fixing 'ever' cfg");}
        if (config.get("broadcastRankChange") == null) {
            config.set("broadcastRankChange", broadcastRankChange);
            hasChanged = true;
            plugin.debugmsg("Fixing 'broadcastRankChange' cfg");}
        if (config.get("allowOpsChanges") == null) {
            config.set("allowOpsChanges", allowOpsChanges);
            hasChanged = true;
            plugin.debugmsg("Fixing 'allowOpsChanges' cfg");}
        if (config.get("logEverything") == null) {
            config.set("logEverything", logEverything);
            hasChanged = true;
            plugin.debugmsg("Fixing 'logEverything' cfg");}

        if (hasChanged) {
            //plugin.logIt("the config has been updated :D");
            try {
				config.save(plugin.yml);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
}