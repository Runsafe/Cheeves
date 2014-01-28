package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;

public class TunnelStage1 extends Achievement
{
	public TunnelStage1(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "My First Steps Into Misery";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the first stage of The Tunnel mini-game.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TUNNEL_1.ordinal();
	}
}
