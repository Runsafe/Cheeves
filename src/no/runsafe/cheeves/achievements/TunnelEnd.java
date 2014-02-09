package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TunnelEnd extends Achievement implements IPlayerCustomEvent
{
	public TunnelEnd(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "What Year Is It?!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the tunnel mini-game.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WHAT_YEAR_IS_IT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.tunnelEnd"))
			award(event.getPlayer());
	}
}
