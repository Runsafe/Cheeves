package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SurvivalChallenge extends Achievement implements IPlayerCustomEvent
{
	public SurvivalChallenge(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Survival Challenge";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Partake in the Survival Challenge.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SURVIVAL_CHALLENGE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.survivalChallenge"))
			this.award(event.getPlayer());
	}
}
