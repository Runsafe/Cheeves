package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.event.inventory.IInventoryClick;
import no.runsafe.framework.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.runsafeinventories.UniverseHandler;

public class Sponge extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public Sponge(AchievementHandler achievementHandler, UniverseHandler universeHandler)
	{
		super(achievementHandler);
		this.universeHandler = universeHandler;
	}

	@Override
	public String getAchievementName()
	{
		return "When I'm Cleaning Windows";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain a sponge.";
	}

	@Override
	public int getAchievementID()
	{
		return 10;
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		this.checkInventory(event.getWhoClicked(), null);
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		this.checkInventory(event.getPlayer(), event.getItem().getItemStack());
	}

	private void checkInventory(RunsafePlayer player, RunsafeMeta item)
	{
		RunsafeInventory inventory = player.getInventory();
		if (this.universeHandler.getUniverseName(player.getWorld()).equals("survival"))
			if (inventory.contains(Item.BuildingBlock.Sponge, 1) || (item != null && item.is(Item.BuildingBlock.Sponge)))
				this.award(player);
	}

	private UniverseHandler universeHandler;
}
