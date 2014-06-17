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
 
public class FishingPro extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public FishingPro(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
		flintItem = Item.Materials.GoldNugget.getItem();
		flintItem.setDisplayName("§6Captain Flint's Gold");
	}
 
	@Override
	public String getAchievementName()
	{
		return "Fishing Pro";
	}
 
	@Override
	public String getAchievementInfo()
	{
		return "Obtain 25 pieces of Flint's Gold.";
	}
 
	@Override
	public int getAchievementID()
	{
		return Achievements.FISHINGPRO.ordinal();
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
			if (inventory.containsStrict(flintItem, 64) || (inventory.containsStrict(flintItem, 63) && isItem(item)))
				this.award(player);
	}
	
	private boolean isItem(RunsafeMeta item)
	{
		if (item == null || !item.is(flintItem.getItemType())
			return false;
			
			String itemName = item.getDisplayName();
			return itemName != null && itemName.equals(flintItem.getDisplayName);
	}
	
	private final RunsafeMeta flintItem;
}
