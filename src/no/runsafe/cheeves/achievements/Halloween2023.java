package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Halloween2023 extends Achievement implements IPlayerCustomEvent
{
	public Halloween2023(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Halloween 2023";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Participated in the Halloween 2023 Event";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.HALLOWEEN2023.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.halloween2023"))
			award(event.getPlayer());
	}
}
