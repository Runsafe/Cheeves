package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.api.server.IPlayerProvider;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.item.meta.RunsafeSkull;

public class WizardHead extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public WizardHead(AchievementHandler achievementHandler, IPlayerProvider playerProvider)
	{
		super(achievementHandler);
		this.playerProvider = playerProvider;
	}

	@Override
	public String getAchievementName()
	{
		return "Wizards Did It";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain a wizard head.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WIZARD_HEAD.ordinal();
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

	private void checkInventory(IPlayer player, RunsafeMeta pickedItem)
	{
		if (pickedItem != null)
			this.checkForWizardHead(player, pickedItem);

		for (RunsafeMeta item : player.getInventory().getContents())
			this.checkForWizardHead(player, item);
	}

	private void checkForWizardHead(IPlayer player, RunsafeMeta item)
	{
		if (player.isInUniverse("survival") && item.is(Item.Decoration.Head.Human))
		{
			RunsafeSkull skull = (RunsafeSkull) item;
			IPlayer wizard = playerProvider.getPlayer(skull.getOwner());

			if (wizard != null)
				if (wizard.getGroups().contains("Wizard"))
					this.award(player);
		}
	}

	private final IPlayerProvider playerProvider;
}
