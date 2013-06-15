package net.dmulloy2.swornrpg.util;

import java.util.List;
import java.util.Random;

import net.dmulloy2.swornrpg.SwornRPG;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;

/**
 * @author orange451
 * @editor dmulloy2
 */

public class Util 
{
	public static Server server;
	public static void initialize(SwornRPG plugin)
	{
		Util.server = plugin.getServer();
	}
	
	public static Player matchPlayer(String pl)
	{
		List<Player> players = server.matchPlayer(pl);
		
		if (players.size() >= 1)
			return players.get(0);
		
		return null;
	}
	
	public static OfflinePlayer matchOfflinePlayer(String pl)
	{
		if (matchPlayer(pl) != null)
			return matchPlayer(pl);
		
		for (OfflinePlayer o : server.getOfflinePlayers())
		{
			if (o.getName().equalsIgnoreCase(pl))
				return o;
		}
		
		return null;
	}
	
	public static boolean isBanned(OfflinePlayer p)
	{
		for (OfflinePlayer banned : server.getBannedPlayers()) 
		{
			if (p.getName().equalsIgnoreCase(banned.getName()))
				return true;
		}
		return false;
	}

	public static int random(int x)
	{
		Random rand = new Random();
		return rand.nextInt(x);
	}

	public static int pointDistance(Location loc1, Location loc2)
	{
		int p1x = (int) loc1.getX();
		int p1y = (int) loc1.getY();
		int p1z = (int) loc1.getZ();
	
		int p2x = (int) loc2.getX();
		int p2y = (int) loc2.getY();
		int p2z = (int) loc2.getZ();
		
		return (int) magnitude(p1x, p1y, p1z, p2x, p2y, p2z);
	}
	
	public static double magnitude(int x1, int y1, int z1, int x2, int y2, int z2) 
	{
		int xdist = x1 - x2;
		int ydist = y1 - y2;
		int zdist = z1 - z2;
		return Math.sqrt(xdist * xdist + ydist * ydist + zdist * zdist); 
	}
}