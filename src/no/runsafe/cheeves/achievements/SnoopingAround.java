package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SnoopingAround extends Achievement implements IPlayerCustomEvent
{
	public SnoopingAround(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Snooping Around";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Find the primary drainage tunnel.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SNOOPING_AROUND.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.snoopingaround"))
			award(event.getPlayer());
	}
}
