package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class AzurenDungeon extends Achievement implements IPlayerCustomEvent
{
	public AzurenDungeon(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Suddenly, silverfish!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Activate a dungeon in Azuren.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.AZUREN_DUNGEON.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("azuren.dungeon.event"))
			award(event.getPlayer());
	}
}
