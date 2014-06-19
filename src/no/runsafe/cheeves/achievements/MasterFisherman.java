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
 
public class MasterFisherman.java extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public MasterFisherman(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
		fishies = Item.Food.Cooked.Fish.Any.getItem();
	}
 
	@Override
	public String getAchievementName()
	{
		return "Master Fisherman";
	}
 
	@Override
	public String getAchievementInfo()
	{
		return "Catch and cook 2,000 fish.";
	}
 
	@Override
	public int getAchievementID()
	{
		return Achievements.MASTER_FISHERMAN.ordinal();
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
 
	private void checkInventory(IPlayer player, RunsafeMeta item)
	{
		RunsafeInventory inventory = player.getInventory();
		if (player.isInUniverse("survival"))
			if (inventory.containsStrict(fishies, 2000) || (inventory.containsStrict(fishies, 1999) && isItem(item)))
				this.award(player);
	}

	private boolean isItem(RunsafeMeta item)
	{
		if (item == null || !item.is(fishies.getItemType()))
			return false;

			String itemName = item.getDisplayName();
			return itemName != null && itemName.equals(fishies.getDisplayName());
	}

	private final RunsafeMeta fishies;
}
