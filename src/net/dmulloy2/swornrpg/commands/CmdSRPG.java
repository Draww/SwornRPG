package net.dmulloy2.swornrpg.commands;

import net.dmulloy2.swornrpg.PermissionInterface;
import net.dmulloy2.swornrpg.SwornRPG;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author dmulloy2
 */

public class CmdSRPG implements CommandExecutor
{
	public SwornRPG plugin;
	  public CmdSRPG (SwornRPG plugin)  
	  {
	    this.plugin = plugin;
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  
	  {    
		    Player player = null;
		    if (sender instanceof Player) 
		    {
		      player = (Player) sender;
		    }
		    if(args.length == 0)
		    {
		    	plugin.displayHelp(player);
		    }
		    else if (args[0].equals("reload"))
		    {
		    	if (player.hasPermission("srpg.admin"))
		    	{
		    		plugin.reloadConfig();
		    		player.sendMessage(ChatColor.GOLD + "[SwornRPG] " + ChatColor.GREEN + "Configuration reloaded");
		    		SwornRPG.outConsole("Configuration reloaded");
		    	}
		    	else
		    	{
		    		player.sendMessage(ChatColor.RED + "You do not have permission to perform this command");
		    	}
		    }
		    else if (args[0].equals("level"))
		    {
		    	player.sendMessage(ChatColor.GOLD + "[SwornRPG] " + ChatColor.YELLOW + "This command has not been implimented yet");
		    }
		    else if (args[0].equals("levelr"))
		    {
		    	if (PermissionInterface.checkPermission(player, this.plugin.adminClearPerm)) 
		    	{
		    		player.sendMessage(ChatColor.GOLD + "[SwornRPG] " + ChatColor.YELLOW + "This command has not been implimented yet");
		    	}
		    	else
		    	{
		    		player.sendMessage(ChatColor.RED + "You do not have permission to perform this command");
		    	}
		    }
		    else if (args[0].equals("help"))
		    {
		    	plugin.displayHelp(player);	  
		    }
		    else
		    {
		    	plugin.displayHelp(player);
		    }
		    
		    return true;
	  }
}