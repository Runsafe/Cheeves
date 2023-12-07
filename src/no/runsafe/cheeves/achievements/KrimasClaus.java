package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class KrimasClaus extends Achievement implements IPlayerCustomEvent
{
	public KrimasClaus(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Krimas Claus";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the Krimas Event";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.KRIMAS_CLAUS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.krimasclaus"))
			award(event.getPlayer());
	}
}
