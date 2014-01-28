package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TunnelStage4 extends Achievement implements IPlayerCustomEvent
{
	public TunnelStage4(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Insane in the Membrane";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the fourth stage of The Tunnel mini-game.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TUNNEL_4.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.tunnel4"))
			award(event.getPlayer());
	}
}
