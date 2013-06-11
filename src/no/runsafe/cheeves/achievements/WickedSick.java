package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

public class WickedSick extends Achievement
{
	public WickedSick(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Wicked Sick";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a wicked sick killing spree in PvP";
	}

	@Override
	public int getAchievementID()
	{
		return 11;
	}
}
