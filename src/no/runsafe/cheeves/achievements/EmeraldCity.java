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

public class EmeraldCity extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public EmeraldCity(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Let's Build an Emerald City";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain 64 blocks of emerald.";
	}

	@Override
	public int getAchievementID()
	{
		return 2;
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
		if (inventory.contains(Item.BuildingBlock.Emerald, 64) || (inventory.contains(Item.BuildingBlock.Emerald, 63) && (item != null && item.is(Item.BuildingBlock.Emerald))))
			this.award(player);
	}
}
