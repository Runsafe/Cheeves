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
			if (inventory.contains(Item.Material.GoldenNugget, 25) || (inventory.contains(Item.Material.GoldenNugget, 24) && (item != null && item.is(Item.Material.GoldenNugget))))
				this.award(player);
	}
}
