package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Krimas extends Achievement implements IPlayerCustomEvent
{
	public Krimas(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Krimas";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Participated in the Krimas Event";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.KRIMAS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.krimas"))
			award(event.getPlayer());
	}
}
