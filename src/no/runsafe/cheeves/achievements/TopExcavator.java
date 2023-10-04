package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TopExcavator extends Achievement implements IPlayerCustomEvent
{
	public TopExcavator(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Top Excavator";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Found all 6 gravesites and obtained the moosic records.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TOP_EXCAVATOR.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.topexcavator"))
			award(event.getPlayer());
	}
}
