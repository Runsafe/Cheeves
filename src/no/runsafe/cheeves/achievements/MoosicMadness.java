package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class MoosicMadness extends Achievement
{
	public MoosicMadness(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Moosic Madness";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Contribute to the endless Moosic library of Runsafe!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MOOSIC_MADNESS.ordinal();
	}
}
