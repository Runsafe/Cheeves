package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class TunnelStage3 extends Achievement
{
	public TunnelStage3(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Master of the Madness";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the third stage of The Tunnel mini-game.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TUNNEL_3.ordinal();
	}
}
