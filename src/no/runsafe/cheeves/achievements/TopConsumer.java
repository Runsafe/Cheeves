package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class TopConsumer extends Achievement implements IPlayerCustomEvent
{
	public TopConsumer(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Top Consumer";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Bought one item from the shop.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.TOP_Consumer.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.topconsumer"))
			award(event.getPlayer());
	}
}