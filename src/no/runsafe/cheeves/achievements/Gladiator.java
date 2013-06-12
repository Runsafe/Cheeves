package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class Gladiator extends Achievement
{
	public Gladiator(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Gladiator";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a rating of 2000 in the PvP arena.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.GLADIATOR.ordinal();
	}
}
