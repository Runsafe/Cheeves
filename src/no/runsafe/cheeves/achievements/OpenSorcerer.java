package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class OpenSorcerer extends Achievement
{
	public OpenSorcerer(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Open Sorcerer";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Contribute to the source code of the Runsafe server!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.OPEN_SORCERER.ordinal();
	}
}
