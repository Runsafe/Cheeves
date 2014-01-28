package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TunnelStage3 extends Achievement implements IPlayerCustomEvent
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

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.tunnel3"))
			award(event.getPlayer());
	}
}
