package com.pyromanticgaming.cowsplosion;

/*
 *Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class MainConfig {

	private static cowSPLOSION plugin;

	public MainConfig(cowSPLOSION instance) {
		plugin = instance;
	}

	public static float ExplodePower = 1;
	public static double alertdistance = 10;
	public static boolean attackthecow, alertedbythecowtoggle;
	public static String alertedbythecow;

	public static void GetMainValues() {

		ExplodePower = plugin.getConfig().getLong("ExplodePower");
		alertdistance = plugin.getConfig().getDouble("AlertDistance");
		attackthecow = plugin.getConfig().getBoolean("AttackTheCow");
		alertedbythecowtoggle = plugin.getConfig().getBoolean("AlertedByTheCowToggle");
		alertedbythecow = plugin.getConfig().getString("AlertedByTheCow");
	}


}