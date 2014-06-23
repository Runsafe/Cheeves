package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class BarleriaPeal extends Achievement implements IPlayerCustomEvent
{
	public BarleriaPeal(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Why Are Pearls So Shiny";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtained Barleria's Pearl and made it out of The Cave.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.BARLERIA_PEARL.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.barleriapeal"))
			award(event.getPlayer());
	}
}
