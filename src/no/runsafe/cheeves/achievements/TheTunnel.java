package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

public class TheTunnel extends Achievement
{
	public TheTunnel(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "I Swear it Existed!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the tunnel event within the time limit.";
	}

	@Override
	public int getAchievementID()
	{
		return 3;
	}
}
