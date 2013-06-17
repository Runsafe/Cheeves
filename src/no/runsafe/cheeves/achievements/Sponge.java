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

public class Sponge extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public Sponge(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
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
		return Achievements.SPONGE.ordinal();
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
		if (player.isInUniverse("survival"))
			if (inventory.contains(Item.BuildingBlock.Sponge, 1) || (item != null && item.is(Item.BuildingBlock.Sponge)))
				this.award(player);
	}
}
