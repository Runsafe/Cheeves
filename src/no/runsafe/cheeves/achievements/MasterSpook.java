package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MasterSpook extends Achievement implements IPlayerCustomEvent
{
	public MasterSpook(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Master Spook";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the Halloween 2023 Event";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MASTERSPOOK.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.masterspook"))
			award(event.getPlayer());
	}
}
