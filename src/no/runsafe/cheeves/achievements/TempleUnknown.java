package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TempleUnknown extends Achievement implements IPlayerCustomEvent
{
	public TempleUnknown(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Temple Of The Unknown";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Located the Temple Of The Unknown";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TEMPLE_UNKNOWN.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.templeunknown"))
			award(event.getPlayer());
	}
}
