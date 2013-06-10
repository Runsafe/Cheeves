package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

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
		return 4;
	}
}
