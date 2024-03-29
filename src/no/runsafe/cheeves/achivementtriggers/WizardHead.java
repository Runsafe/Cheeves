package no.runsafe.cheeves.achivementtriggers;

import no.runsafe.cheeves.listeners.AchievementHandler;
import no.runsafe.cheeves.database.AchievementDefinitionRepository;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.api.server.IPlayerProvider;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.item.meta.RunsafeSkull;

public class WizardHead extends AchievementDefinition implements IInventoryClick, IPlayerPickupItemEvent
{
	public WizardHead(AchievementDefinitionRepository repository, AchievementHandler achievementHandler, IPlayerProvider playerProvider)
	{
		super(repository, achievementHandler);
		this.playerProvider = playerProvider;
	}

	public static final int ID = 8;

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
					this.award(player, ID);
		}
	}

	private final IPlayerProvider playerProvider;
}
