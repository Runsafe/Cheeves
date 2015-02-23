package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class It'slonelyatthetop extends Achievement implements IPlayerCustomEvent
{
	public It'slonelyatthetop(AchievementHandler achievementHandler)
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
		return Achievements.IT'S_LONELY_AT_THE_TOP.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.it'sLonelyAtTheTop"))
			award(event.getPlayer());
	}
}