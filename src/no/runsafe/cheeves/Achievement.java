package no.runsafe.cheeves;

import no.runsafe.framework.api.player.IPlayer;

public abstract class Achievement implements IAchievement
{
	public Achievement(AchievementHandler achievementHandler)
	{
		this.achievementHandler = achievementHandler;
	}

	public void award(IPlayer player)
	{
		this.achievementHandler.awardAchievement(this, player);
	}

	protected final AchievementHandler achievementHandler;
}
