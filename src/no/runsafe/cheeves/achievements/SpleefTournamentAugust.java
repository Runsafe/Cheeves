package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class SpleefTournamentAugust extends Achievement
{
	public SpleefTournamentAugust(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Spleef Tournament - August 2013";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Partake in the spleef tournament of August 2013";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SPLEEF_TOURNAMENT_AUGUST.ordinal();
	}
}
