package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ApprenticeWizard extends Achievement implements IPlayerCustomEvent
{
	public ApprenticeWizard(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Apprentice Wizard";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Score in the top three for a match of wizard PvP.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.APPRENTICE_WIZARD.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.apprenticeWizard"))
			award(event.getPlayer());
	}
}
