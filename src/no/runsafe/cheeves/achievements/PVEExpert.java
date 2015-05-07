package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class PVEExpert extends Achievement implements IPlayerCustomEvent
{
	public PVEExpert(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "PvE Expert";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Have a total of 500 PvE Points at once.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PVE_EXPERT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.pveexpert"))
			award(event.getPlayer());
	}
}