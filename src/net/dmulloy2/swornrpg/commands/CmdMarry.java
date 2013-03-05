package net.dmulloy2.swornrpg.commands;

import net.dmulloy2.swornrpg.SwornRPG;
import net.dmulloy2.swornrpg.data.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author dmulloy2
 */

public class CmdMarry implements CommandExecutor
{
	public SwornRPG plugin;
	public CmdMarry(SwornRPG plugin)  
	{
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  
	{    
		if (sender instanceof Player) 
		{
			if (plugin.proposal.containsKey(sender.getName()))
			{
				Player target = Bukkit.getServer().getPlayer((String)plugin.proposal.get(sender.getName()));
				if (target != null)
				{
					String targetp = target.getName();
					String senderp = sender.getName();
					final PlayerData data = plugin.getPlayerDataCache().getData(senderp);
					final PlayerData data1 = plugin.getPlayerDataCache().getData(targetp);
					data.setSpouse(targetp);
					data1.setSpouse(senderp);
					Bukkit.getServer().broadcastMessage(plugin.prefix + ChatColor.GREEN + targetp + " has married " + senderp);
					plugin.proposal.remove(senderp);
					plugin.proposal.remove(targetp);
					plugin.getPlayerDataCache().save();
				}
				else
				{
					sender.sendMessage(plugin.noplayer);
				}
			}
			else
			{
				sender.sendMessage(plugin.prefix + ChatColor.RED + "You do not have a proposal");
			}
		}
		else
		{
			sender.sendMessage(plugin.mustbeplayer);
		}
		
		return true;
	}
}