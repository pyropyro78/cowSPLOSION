package com.pyromanticgaming.cowsplosion;


import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class cowSPLOSION extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(this, this);

		//Set configs
		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();
		getLogger().info("cowSPLOSION has been enabled.");
	}

	@Override
	public void onDisable() {
		getLogger().info("cowSPLOSION has been disabled.");
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

		//Checks if damage caused by player or by arrow. This can cause skeletons to explode cows as well if properly angled.
		if (MainConfig.attackthecow && (event.getDamager() instanceof Arrow || event.getDamager() instanceof Player) && event.getEntityType() == EntityType.COW) {
			
			//Designates where to cause explosion and how powerful it should be
			event.getEntity().getLocation().getWorld().createExplosion(event.getEntity().getLocation(), MainConfig.ExplodePower);
			
			//As a way to ansure a kill, cow is hit on the ground from high fall without falling.
			event.getEntity().setFallDistance(255);

			//This section handles the chat message
			if (MainConfig.alertedbythecowtoggle) {

				for (Entity e : event.getEntity().getNearbyEntities(MainConfig.alertdistance, MainConfig.alertdistance, MainConfig.alertdistance)) {
					if(e instanceof Player) {
						e.sendMessage(MainConfig.alertedbythecow);
					}
				}

			}
		}
	}
}
