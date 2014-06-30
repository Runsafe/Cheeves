package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class ServerFirstMasterTreasureHunter extends Achievement
{
	public ServerFirstMasterTreasureHunter(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Server First: Master Treasure Hunter";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Was either the first person or group to reach Captain Flint's lost treasure!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SERVER_FIRST_MASTER_TREASURE_HUNTER.ordinal();
	}
}
