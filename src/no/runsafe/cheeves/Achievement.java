package no.runsafe.cheeves;

import no.runsafe.framework.server.player.RunsafePlayer;

public abstract class Achievement implements IAchievement
{
	public Achievement(AchievementHandler achievementHandler)
	{
		this.achievementHandler = achievementHandler;
	}

	public void award(RunsafePlayer player)
	{
		this.achievementHandler.awardAchievement(this, player);
	}

	protected AchievementHandler achievementHandler;
}
