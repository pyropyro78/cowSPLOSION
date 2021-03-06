package com.pyromanticgaming.cowsplosion;


public class MainConfig {

	private static cowSPLOSION plugin;

	public MainConfig(cowSPLOSION instance) {
		plugin = instance;
	}
	
	//Initializing all variables used for config
	public static float ExplodePower = 1;
	public static double alertdistance = 10;
	public static boolean attackthecow, alertedbythecowtoggle;
	public static String alertedbythecow;

	public static void GetMainValues() {

		//Get variables
		ExplodePower = plugin.getConfig().getLong("ExplodePower");
		alertdistance = plugin.getConfig().getDouble("AlertDistance");
		attackthecow = plugin.getConfig().getBoolean("AttackTheCow");
		alertedbythecowtoggle = plugin.getConfig().getBoolean("AlertedByTheCowToggle");
		alertedbythecow = plugin.getConfig().getString("AlertedByTheCow");
	}


}