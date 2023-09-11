package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class PvESpender extends Achievement implements IPlayerCustomEvent
{
	public PvESpender(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "PvE Spender";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Made a purchase in the PVE Minigame.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.PVE_SPENDER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.pvespender"))
			award(event.getPlayer());
	}
}
