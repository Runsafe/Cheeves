package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;

public class ServerFirstEnderDragon extends Achievement
{
	public ServerFirstEnderDragon(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Server First: Ender Dragon";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Participate in the server-first ender dragon kill.";
	}

	@Override
	public int getAchievementID()
	{
		return 6;
	}
}
