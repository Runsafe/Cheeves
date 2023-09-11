package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class timecapsule extends Achievement implements IPlayerCustomEvent
{
	public Time Capsule(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Time Capsule";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Enter the Secret Room in the Survival Spawn.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TIME_CAPSULE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.timecapsule"))
			award(event.getPlayer());
	}
}
