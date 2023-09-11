package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class SurfaceChampion extends Achievement implements IPlayerCustomEvent
{
	public SurfaceChampion(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Surface Champion";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Beat all 5 Rounds of the Surface Arena.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.SURFACE_CHAMPION.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.surfacechampion"))
			award(event.getPlayer());
	}
}
