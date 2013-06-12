package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class MercilessGladiator extends Achievement
{
	public MercilessGladiator(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Merciless Gladiator";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a rating of 2500 in PvP.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MERCILESS_GLADIATOR.ordinal();
	}
}
