package no.runsafe.cheeves.achievements;
 
import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class FlintsGoldHoarder extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public FlintsGoldHoarder(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}
 
	@Override
	public String getAchievementName()
	{
		return "Flint's Gold Hoarder";
	}
 
	@Override
	public String getAchievementInfo()
	{
		return "Obtain 25 pieces Captain Flints Gold";
	}
 
	@Override
	public int getAchievementID()
	{
		return Achievements.FLINTS_GOLD_HOARDER.ordinal();
	}
 
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
				award(player);
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
