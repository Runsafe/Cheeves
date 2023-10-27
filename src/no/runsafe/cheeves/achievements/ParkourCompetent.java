package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ParkourCompetent extends Achievement implements IPlayerCustomEvent
{
	public ParkourCompetent(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Parkour Competent";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the Competent rated parkour course.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PARKOUR_COMPETENT.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.parkourcompetent"))
			award(event.getPlayer());
	}
}
