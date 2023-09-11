package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SurvivalSmarts extends Achievement implements IPlayerCustomEvent
{
	public SurvivalSmarts(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Survival Smarts";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Traded a Dergon Egg for Dergon bones.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SURVIVAL_SMARTS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.survivalsmarts"))
			award(event.getPlayer());
	}
}
