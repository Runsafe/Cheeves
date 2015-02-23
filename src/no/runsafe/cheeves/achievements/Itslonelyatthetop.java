package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Itslonelyatthetop extends Achievement implements IPlayerCustomEvent
{
	public Itslonelyatthetop(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "It's lonely at the top";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Win a match of LMS.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.ITS_LONELY_AT_THE_TOP.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.itsLonelyAtTheTop"))
			award(event.getPlayer());
	}
}
