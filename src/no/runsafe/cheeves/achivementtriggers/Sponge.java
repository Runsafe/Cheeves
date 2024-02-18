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
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class Sponge extends AchievementDefinition implements IInventoryClick, IPlayerPickupItemEvent
{
	public Sponge(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 10;

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

	private void checkInventory(IPlayer player, RunsafeMeta item)
	{
		RunsafeInventory inventory = player.getInventory();
		if (player.isInUniverse("survival"))
			if (inventory.contains(Item.BuildingBlock.Sponge, 1) || (item != null && item.is(Item.BuildingBlock.Sponge)))
				this.award(player, ID);
	}
}
