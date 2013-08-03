package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class SpleefTournamentAugustWinner extends Achievement
{
	public SpleefTournamentAugustWinner(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Winner: Spleef Tournament - August 2013";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Proud winner of the spleef tournament of August 2013";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SPLEEF_TOURNAMENT_AUGUST_WINNER.ordinal();
	}
}
