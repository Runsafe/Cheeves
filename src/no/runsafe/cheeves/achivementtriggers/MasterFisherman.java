package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public class MasterFisherman extends AchievementDefinition implements IInventoryClick, IPlayerPickupItemEvent
{
	public MasterFisherman(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 50;

	private void checkInventory(RunsafeInventory inventory, IPlayer player)
	{
		if (player.isInUniverse("survival") && inventory.getAmountOfItem(Item.Food.Cooked.Fish.Normal) + inventory.getAmountOfItem(Item.Food.Cooked.Fish.Salmon) >= 2000)
			award(player, ID);
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
