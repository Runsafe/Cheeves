package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.runsafeinventories.UniverseHandler;

public class MyPrecious extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public MyPrecious(AchievementHandler achievementHandler, UniverseHandler universeHandler)
	{
		super(achievementHandler);
		this.universeHandler = universeHandler;
	}

	@Override
	public String getAchievementName()
	{
		return "My Precious";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain a dragon egg.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MY_PRECIOUS.ordinal();
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
			if (inventory.contains(Item.Special.DragonEgg, 1) || (item != null && item.is(Item.Special.DragonEgg)))
				this.award(player);
	}

	private UniverseHandler universeHandler;
}
