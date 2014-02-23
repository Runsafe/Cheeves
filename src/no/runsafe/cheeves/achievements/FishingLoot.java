package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class FishingLoot extends Achievement implements IPlayerCustomEvent
{
	public FishingLoot(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "The Scavenger";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Fish up one of the rare special items from spawn!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.FISHING_SPECIAL_LOOT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("fishing.special.loot"))
			award(event.getPlayer());
	}
}
