package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.event.inventory.IInventoryMoveItem;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryMoveItemEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.player.RunsafePlayer;

public class Pimp extends Achievement implements IInventoryMoveItem
{
	public Pimp(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Pimp";
	}

	@Override
	public void OnInventoryMoveItemEvent(RunsafeInventoryMoveItemEvent event)
	{
		RunsafeInventory inventory = event.getDestination();
		if (inventory.getHolder() instanceof RunsafePlayer && inventory.contains(Item.BuildingBlock.Diamond, 64))
			this.award((RunsafePlayer) inventory.getHolder());
	}
}
