package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class NightstalkerKill extends Achievement
{
	public NightstalkerKill(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "That looked familiar!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Slay a Nightstalker in Azuren.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.NIGHTSTALKER_KILL.ordinal();
	}
}
