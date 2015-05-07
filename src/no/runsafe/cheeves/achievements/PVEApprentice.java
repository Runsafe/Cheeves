package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class PVEApprentice extends Achievement implements IPlayerCustomEvent
{
	public PVEApprentice(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "PVE Apprentice";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Have a total of 100 PvE Points at once.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PVE_APPRENTICE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.pveapprentice"))
			award(event.getPlayer());
	}
}