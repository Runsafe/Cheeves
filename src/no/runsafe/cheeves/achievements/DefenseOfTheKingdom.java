package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class DefenseOfTheKingdom extends Achievement
{
	public DefenseOfTheKingdom(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Defense of the Kingdom";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Partake in the Defense of the Kingdom event.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.DEFENSE_OF_THE_KINGDOM.ordinal();
	}
}
