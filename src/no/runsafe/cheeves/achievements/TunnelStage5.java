package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TunnelStage5 extends Achievement implements IPlayerCustomEvent
{
	public TunnelStage5(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Will This Ever End?";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the fifth stage of The Tunnel mini-game.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TUNNEL_5.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.tunnel5"))
			award(event.getPlayer());
	}
}
