package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class BigSpender extends Achievement implements IPlayerCustomEvent
{
	public BigSpender(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Hey Big Spender!";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Embark on a rather impressive shopping spree.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.BIG_SPENDER.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.bigSpender"))
			award(event.getPlayer());
	}
}
