package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ParkourYellow extends Achievement implements IPlayerCustomEvent
{
	public ParkourYellow(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Parkour: Yellow Course";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Complete the Yellow Course in the Parkour world.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PARKOUR_YELLOW.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.parkouryellow"))
			award(event.getPlayer());
	}
}
