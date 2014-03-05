package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class TheNumbersMason extends Achievement
{
	public TheNumbersMason(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "The Numbers Mason!?";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete The Adventure server event.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.NUMBERS_MASON.ordinal();
	}
}
