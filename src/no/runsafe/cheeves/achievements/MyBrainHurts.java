package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class MyBrainHurts extends Achievement
{
	public MyBrainHurts(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "My Brain Hurts";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the July 2013 puzzle server event.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MY_BRAIN_HURTS.ordinal();
	}
}
