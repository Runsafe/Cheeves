package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

public class PvPTournamentJune extends Achievement
{
	public PvPTournamentJune(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "PvP Tournament - June 2013";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Partake in the PvP tournament of June 2013";
	}

	@Override
	public int getAchievementID()
	{
		return 5;
	}
}
