package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class Coins2 extends Achievement implements IPlayerCustomEvent
{
	public Coins2(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Gold Goblin";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Earn a total of 1000 coins!";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.COINS_2.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.coins2"))
			award(event.getPlayer());
	}
}
