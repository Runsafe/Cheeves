package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class WhereCouldTheyBe extends Achievement implements IPlayerCustomEvent
{
	public WhereCouldTheyBe(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Where Could They Be";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Find the doorway control panel";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.WHERE_COULD_THEY_BE.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.wherecouldtheybe"))
			award(event.getPlayer());
	}
}
