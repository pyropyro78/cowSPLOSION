package com.pyromanticgaming.cowsplosion;

/*
 *Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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

		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();
		getLogger().info("cowSPLOSION has been enabled.");
	}

	@Override
	public void onDisable() {
		getLogger().info("PlateMines has been disabled.");
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

		if (MainConfig.attackthecow && (event.getDamager() instanceof Arrow || event.getDamager() instanceof Player) && event.getEntityType() == EntityType.COW) {
			event.getEntity().getLocation().getWorld().createExplosion(event.getEntity().getLocation(), MainConfig.ExplodePower);
			event.getEntity().setFallDistance(255);


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
