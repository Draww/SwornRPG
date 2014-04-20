package net.dmulloy2.swornrpg.handlers;

import net.dmulloy2.swornrpg.types.Permission;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author dmulloy2
 */

public class PermissionHandler
{
	private final String prefix;
	public PermissionHandler(String prefix)
	{
		this.prefix = prefix + ".";
	}

	public PermissionHandler(JavaPlugin plugin)
	{
		this(plugin.getName());
	}

	public final boolean hasPermission(CommandSender sender, Permission permission) 
	{
		return permission == null || hasPermission(sender, getPermissionString(permission));
	}

	public final boolean hasPermission(CommandSender sender, String permission) 
	{
		if (sender instanceof Player) 
		{
			Player player = (Player) sender;
			return player.hasPermission(permission) || player.isOp();
		}

		return true;
	}

	public final String getPermissionString(Permission permission) 
	{
		return prefix + permission.getNode().toLowerCase();
	}
}