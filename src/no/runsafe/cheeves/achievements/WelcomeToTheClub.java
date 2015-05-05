package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class WelcomeToTheClub extends Achievement implements IPlayerCustomEvent
{
	public WelcomeToTheClub(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Welcome To The Club";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Enter the Secret Room in PVE.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WELCOME_TO_THE_CLUB.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.welcometotheclub"))
			award(event.getPlayer());
	}
}