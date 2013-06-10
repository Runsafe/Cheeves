package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.event.inventory.IInventoryClick;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public class Pimp extends Achievement implements IInventoryClick
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
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		RunsafePlayer player = event.getWhoClicked();

		if (player.getInventory().contains(Item.BuildingBlock.Diamond, 64))
			this.award(player);
	}
}
