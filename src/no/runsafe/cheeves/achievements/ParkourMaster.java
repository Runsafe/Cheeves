package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ParkourMaster extends Achievement implements IPlayerCustomEvent
{
	public ParkourMaster(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Parkour Master";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the Master rated parkour course.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PARKOUR_MASTER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.parkourmaster"))
			award(event.getPlayer());
	}
}
