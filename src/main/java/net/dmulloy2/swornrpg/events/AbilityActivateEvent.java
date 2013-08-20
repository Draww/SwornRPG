package net.dmulloy2.swornrpg.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * @author dmulloy2
 */

public class AbilityActivateEvent extends PlayerEvent implements Cancellable
{	
	private static final HandlerList handlers = new HandlerList();
	
	public boolean cancelled;
	
	public AbilityActivateEvent(final Player player)
	{
		super(player);
	}

	@Override
	public HandlerList getHandlers() 
	{
		return handlers;
	}
	
	public static HandlerList getHandlerList() 
	{
		return handlers;
	}
	
	@Override
	public boolean isCancelled() 
	{
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) 
	{
		this.cancelled = cancelled;
	}
}
