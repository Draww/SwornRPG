package net.dmulloy2.swornrpg.commands;

import net.dmulloy2.swornrpg.SwornRPG;
import net.dmulloy2.swornrpg.types.PlayerData;
import net.dmulloy2.swornrpg.util.Util;

import org.bukkit.entity.Player;

/**
 * @author dmulloy2
 */

public class CmdMarry extends SwornRPGCommand
{
	public CmdMarry(SwornRPG plugin)
	{
		super(plugin);
		this.name = "marry";
		this.aliases.add("matrimony");
		this.description = "Marry another player";
		this.requiredArgs.add("player");
		this.mustBePlayer = true;
	}
	
	@Override
	public void perform()
	{
		if (! plugin.isMarriage())
		{
			err(plugin.getMessage("command_disabled"));
			return;
		}
		
		if (! plugin.getProposal().containsKey(player.getName()))
		{
			err(plugin.getMessage("no_proposal"));
			return;
		}
		
		Player target = Util.matchPlayer(plugin.getProposal().get(sender.getName()));
		if (target == null)
		{
			err(plugin.getMessage("no_player"));
			return;
		}
		
		PlayerData data = getPlayerData(player);
		data.setSpouse(target.getName());
		
		PlayerData data1 = getPlayerData(target);
		data1.setSpouse(player.getName());

		sendMessageAll(plugin.getMessage("marry"), player.getName(), target.getName());
		plugin.getProposal().remove(player.getName());
		plugin.getProposal().remove(target.getName());
	}
}