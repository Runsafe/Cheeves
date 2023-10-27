package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class ParkourNovice extends Achievement implements IPlayerCustomEvent
{
	public ParkourNovice(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Parkour Novice";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Completed the Novice rated parkour course.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PARKOUR_NOVICE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.parkournovice"))
			award(event.getPlayer());
	}
}
