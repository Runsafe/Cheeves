package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Vanish extends Achievement implements IPlayerCustomEvent
{
	public Vanish(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Vanish";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Purchase a Vanish spell from the PVE Shop.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.VANISH.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.vanish"))
			award(event.getPlayer());
	}
}