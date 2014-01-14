package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TouchOfDeath extends Achievement implements IPlayerCustomEvent
{
	public TouchOfDeath(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Touch of Death";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Kill a player in Wizard PvP while being in the graveyard.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TOUCH_OF_DEATH.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.touchOfDeath"))
			award(event.getPlayer());
	}
}
