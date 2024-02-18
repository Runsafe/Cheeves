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

public class FlintsGoldHoarder extends AchievementDefinition implements IInventoryClick, IPlayerPickupItemEvent
{
	public FlintsGoldHoarder(AchievementDefinitionRepository repository, AchievementHandler achievementHandler)
	{
		super(repository, achievementHandler);
	}

	public static final int ID = 48;
 
	private void checkInventory(RunsafeInventory inventory, IPlayer player)
	{
		if (!player.isInUniverse("survival"))
			return;

		int amount = 0;
		for (RunsafeMeta inventoryItem : inventory.getContents())
		{
			if (!inventoryItem.is(Item.Materials.GoldNugget))
				continue;

			String displayName = inventoryItem.getDisplayName();
			if (displayName == null || !displayName.equals("§6Captain Flint's Gold"))
				continue;

			amount += inventoryItem.getAmount();
			if (amount >= 25)
			{
				award(player, ID);
				return;
			}
		}
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
