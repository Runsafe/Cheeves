package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Coins extends Achievement implements IPlayerCustomEvent
{
	public Coins(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Money Makes the World Go Around";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a total of 500 coins!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.COINS.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.coins"))
			award(event.getPlayer());
	}
}
