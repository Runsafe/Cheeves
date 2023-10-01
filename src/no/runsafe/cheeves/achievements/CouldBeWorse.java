package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class CouldBeWorse extends Achievement implements IPlayerCustomEvent
{
	public CouldBeWorse(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Could Be Worse";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Find the primary drainage basin";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.COULD_BE_WORSE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.couldbeworse"))
			award(event.getPlayer());
	}
}
