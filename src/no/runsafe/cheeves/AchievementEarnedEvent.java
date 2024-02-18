package no.runsafe.cheeves;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class AchievementEarnedEvent extends RunsafeCustomEvent
{
	public AchievementEarnedEvent(IAchievement achievement, IPlayer player, String event)
	{
		super(player, event);
		this.achievement = achievement;
	}

	@Override
	public Object getData()
	{
		return achievement;
	}

	public IAchievement getAchievement()
	{
		return achievement;
	}

	private final IAchievement achievement;
}
