package net.dmulloy2.swornrpg.commands;

import net.dmulloy2.swornrpg.SwornRPG;
import net.dmulloy2.swornrpg.types.Permission;

/**
 * @author dmulloy2
 */

public class CmdVersion extends SwornRPGCommand
{
	public CmdVersion(SwornRPG plugin)
	{
		super(plugin);
		this.name = "version";
		this.aliases.add("v");
		this.description = "Display SwornRPG version";
		this.permission = Permission.VERSION;

		this.usesPrefix = true;
	}

	@Override
	public void perform()
	{
		sendMessage(getMessage("version_header"));
		sendMessage(getMessage("version_author"), "dmulloy2");
		sendMessage(getMessage("version_loaded"), plugin.getDescription().getFullName());
		sendMessage(getMessage("version_download"));
	}
}