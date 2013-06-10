package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

public class MyPrecious extends Achievement
{
	public MyPrecious(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "My Precious";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain a dragon egg.";
	}

	@Override
	public int getAchievementID()
	{
		return 7;
	}
}
