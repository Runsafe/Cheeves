package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class PVENovice extends Achievement implements IPlayerCustomEvent
{
	public PVENovice(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "PVE Novice";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Have a total of 50 PvE Points at once.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PVE_NOVICE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.pvenovice"))
			award(event.getPlayer());
	}
}