package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ParkourRed extends Achievement implements IPlayerCustomEvent
{
	public ParkourRed(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Parkour: Red Course";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the Red Course in the Parkour world.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PARKOURRED.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.parkourred"))
			award(event.getPlayer());
	}
}