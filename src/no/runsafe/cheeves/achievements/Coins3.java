package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Coins3 extends Achievement implements IPlayerCustomEvent
{
	public Coins3(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "The Bread Winner";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a total of 10,000 coins!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.COINS_3.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.coins3"))
			award(event.getPlayer());
	}
}
