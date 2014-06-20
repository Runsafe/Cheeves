package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public class MasterFisherman extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public MasterFisherman(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}
	
	@Override
	public String getAchievementName()
	{
		return "Master Fisherman";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain 2000 cooked fish.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MASTER_FISHERMAN.ordinal();
	}

	private void checkInventory(RunsafeInventory inventory, IPlayer player)
	{
		if (inventory.getAmountOfItem(Item.Food.Cooked.Fish.Normal) + inventory.getAmountOfItem(Item.Food.Cooked.Fish.Salmon) >= 2000)
			award(player);
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		checkInventory(event.getInventory(), event.getWhoClicked());
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		IPlayer player = event.getPlayer();
		checkInventory(player.getInventory(), player);
	}
}
